package com.example.drilling;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.webkit.URLUtil;
import android.widget.Toast;

import com.budiyev.android.codescanner.CodeScanner;
import com.budiyev.android.codescanner.CodeScannerView;
import com.budiyev.android.codescanner.DecodeCallback;
import com.google.zxing.Result;

import java.util.ArrayList;
import java.util.List;

public class Menu extends AppCompatActivity {
    private CodeScanner mCodeScanner;

    String[] permissions = {
            Manifest.permission.CAMERA
    };
    int PERM_CODE = 11;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        CodeScannerView scannerView = findViewById(R.id.scanner_view);


        mCodeScanner = new CodeScanner(this, scannerView);
        mCodeScanner.setDecodeCallback(new DecodeCallback() {
            @Override
            public void onDecoded(@NonNull final Result result) {
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        //Toast.makeText(Menu.this, result.getText(), Toast.LENGTH_SHORT).show();
                        String url = result.getText();
                        //textView.setText("Result is :"+ URLUtil.isValidUrl(url));//result.getText()

                        if (URLUtil.isValidUrl(url)) {
                            loadsalle(url);
                        } else {
                            Toast.makeText(Menu.this, "QR code invalid url", Toast.LENGTH_SHORT).show();
                        }


                    }
                });
            }
        });
    }

    void loadsalle(String url) {
        Intent sceneViewerIntent = new Intent(Intent.ACTION_VIEW);
        Uri intentUri =
                Uri.parse("https://arvr.google.com/scene-viewer/1.0").buildUpon()
                        //.appendQueryParameter("file", "https://raw.githubusercontent.com/KhronosGroup/glTF-Sample-Models/master/2.0/Duck/glTF/Duck.gltf")
                        .appendQueryParameter("file", url)
                        .appendQueryParameter("mode", "ar_preferred")
                        .appendQueryParameter("title", "Model3D")
                        .build();
        sceneViewerIntent.setData(intentUri);
        sceneViewerIntent.setPackage("com.google.ar.core");
        startActivity(sceneViewerIntent);
    }


    protected void onResume() {
        super.onResume();
        requastCamera();

    }
    private void requastCamera() {
        if (checkPermissions()){
            mCodeScanner.startPreview();
        }
    }
    private boolean checkPermissions ()
    {
        List<String> listofpermission = new ArrayList<>();
        for(String perm : permissions)
        {

            if(ContextCompat.checkSelfPermission(getApplicationContext(),perm)!= PackageManager.PERMISSION_GRANTED)
            {
                listofpermission.add(perm);
            }
        }
        if (!listofpermission.isEmpty()){
            ActivityCompat.requestPermissions(this,listofpermission.toArray(new String[listofpermission.size()]),PERM_CODE);
            return false  ;
        }
        return true ;


    }
}