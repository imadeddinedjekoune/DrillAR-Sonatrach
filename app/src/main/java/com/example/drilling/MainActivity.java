package com.example.drilling;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
/*
    androidx.gridlayout.widget.GridLayout gridLayoutrid ;
    CardView gridQR ;
    CardView gridlocalisation ;
    CardView grisRessource ;
    CardView gridEDT;
*/
    private Button btn2 ;
    private Button btn1 ;

    private EditText mailText ;
    private EditText PasswordText ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        /*gridLayoutrid = (androidx.gridlayout.widget.GridLayout)findViewById(R.id.month_grid);
        setSingleEvent(gridLayoutrid);
        gridQR = (CardView) findViewById(R.id.gridQR);
        gridlocalisation = (CardView) findViewById(R.id.gridLocalisation);
        grisRessource = (CardView) findViewById(R.id.gridressource);
        gridEDT = (CardView) findViewById(R.id.gridEDT);*/


        btn1 = findViewById(R.id.loginButton2);
        mailText = findViewById(R.id.username1);
        PasswordText = findViewById(R.id.password1);

        btn1.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                if ((mailText.getText().toString().equals("Admin@sonatrach.dz")&& PasswordText.getText().toString().equals("Admin")) || (mailText.getText().toString().equals("t")&& PasswordText.getText().toString().equals("t"))){
                Intent i = new Intent(MainActivity.this,AR.class);
                startActivity(i);}

            }
        });
        /*

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
                });*/
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













    /*@Override
    protected void onResume() {
        super.onResume();
        gridQR.setCardBackgroundColor(Color.WHITE);
        gridlocalisation.setCardBackgroundColor(Color.WHITE);
        grisRessource.setCardBackgroundColor(Color.WHITE);
        gridEDT.setCardBackgroundColor(Color.WHITE);
    }

    private void setSingleEvent(androidx.gridlayout.widget.GridLayout grid) {
        for(int i = 0 ;i<grid.getChildCount();i++){
            CardView card = (CardView) grid.getChildAt(i);
            if (i==0){
                card.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        gridQR.setCardBackgroundColor(Color.parseColor("#ff0fc2c0"));
                        Intent i = new Intent(MainActivity.this, Menu.class);
                        startActivity(i);

                    }
                });
            }
            if (i==1){
                card.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {

                        //gridlocalisation.setCardBackgroundColor(Color.parseColor("#ff0fc2c0"));
                        Toast.makeText(MainActivity.this,"Activity will be load soon !",Toast.LENGTH_SHORT).show();

                    }
                });
            }


        }
    }

*/
}