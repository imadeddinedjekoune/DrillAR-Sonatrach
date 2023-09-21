package com.example.drilling;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.widget.Button;


import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class AR extends AppCompatActivity {
    private Button btn2 ;
    private Button btn1 ;
    private Button btn3 ;
    private Button btn4 ;
    private Button btn5 ;
    private Button btn6 ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn1 = findViewById(R.id.button1);
        btn2 = findViewById(R.id.button2);
        btn3 = findViewById(R.id.button3);
        btn4 = findViewById(R.id.button4);
        btn5 = findViewById(R.id.button5);



        btn1.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        loadsalle("https://raw.githubusercontent.com/SouidiAmine/repo/main/Pump.gltf");

                    }
                });
        btn2.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        loadsalle("https://raw.githubusercontent.com/SouidiAmine/repo/main/agitator.gltf");

                    }
                });
        btn3.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        loadsalle("https://raw.githubusercontent.com/SouidiAmine/repo/main/shaker.gltf");

                    }
                });
        btn4.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        loadsalle("https://raw.githubusercontent.com/SouidiAmine/repo/main/degasser.gltf");

                    }
                });
        btn5.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        loadsalle("https://raw.githubusercontent.com/SouidiAmine/generateur/main/Generateur2.gltf");

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
}