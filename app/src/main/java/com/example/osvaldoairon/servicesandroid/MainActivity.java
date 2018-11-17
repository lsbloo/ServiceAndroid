package com.example.osvaldoairon.servicesandroid;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;


public class MainActivity extends AppCompatActivity{

    private Button btn_play;
    private Button btn_pause;
    private Button btn_stop;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        btn_play = (Button)findViewById(R.id.btn_play);
        btn_pause = (Button)findViewById(R.id.btn_pause);
        btn_stop = (Button)findViewById(R.id.btn_stop);
    }

    public void btnPlayClick(View view){
        Intent it = new Intent(MainActivity.this,MeuService.class);
        it.putExtra("acao", "play");
        startService(it);
    }
    public void btnPauseClick(View view){
        Intent it = new Intent(MainActivity.this,MeuService.class);
        it.putExtra("acao", "pause");
        startService(it);
    }
    public void btnStopClick(View view){
        Intent it = new Intent(MainActivity.this,MeuService.class);
        it.putExtra("acao", "stop");
        startService(it);
    }
}