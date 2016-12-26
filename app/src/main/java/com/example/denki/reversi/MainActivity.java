package com.example.denki.reversi;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import  android.view.MenuItem;
import android.view.View;
import android.content.Intent;
import android.widget.TextView;
import android.widget.Button;
import android.view.View.OnClickListener;

public class MainActivity extends Activity implements OnClickListener{

    private Button button_solo;
    private Button button_multi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //ひとりで遊ぶ
        button_solo = (Button)findViewById(R.id.button_solo);
        button_solo.setOnClickListener(this);

        //ふたりで対戦
        button_multi = (Button)findViewById(R.id.button_multi);
        button_multi.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {

        //「ひとりで遊ぶ」をタップした時の処理
        if(view == button_solo){
            Intent intent = new Intent(this, Activity_solo.class);
            startActivity(intent);
        }

        //「ふたりで対戦」をタップした時の処理
        if(view == button_multi){
            Intent intent = new Intent(this, Activity_reversi.class);
            intent.putExtra("com",0);
            startActivity(intent);
        }
    }
}
