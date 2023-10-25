package com.example.proyecto_nota1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.icu.text.IDNA;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    TextView info;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        info = (TextView) findViewById(R.id.Info);

        findViewById(R.id.Mostrar).setOnClickListener(this);
    }
    public void onClickAcceder(View view){
        Intent intent = new Intent(this, Acceder.class);
        startActivity(intent);
    }


    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.Mostrar:
                if (info.getVisibility() == View.GONE){
                    info.setVisibility(View.VISIBLE);
                }else {
                    info.setVisibility(View.GONE);
                }
        }


    }
}