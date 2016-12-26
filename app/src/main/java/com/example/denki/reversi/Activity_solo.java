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

/**
 * Created by denki on 2016/11/07.
 */

public class Activity_solo extends Activity implements View.OnClickListener {

    private Button solo_easy;
    private Button solo_normal;
    private Button solo_hard;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_solo);

        //簡単
        solo_easy = (Button) findViewById(R.id.solo_easy);
        solo_easy.setOnClickListener(this);

        //普通
        solo_normal = (Button) findViewById(R.id.solo_normal);
        solo_normal.setOnClickListener(this);

        //むつかしい
        solo_hard = (Button) findViewById(R.id.solo_hard);
        solo_hard.setOnClickListener(this);
    }


    @Override
    public void onClick(View view) {
        int id = view.getId();

        switch (id) {
            case R.id.solo_easy: {
                //「easy」をタップした時の処理
                Intent intent = new Intent(this, Activity_reversi.class);
                intent.putExtra("com", 1);
                startActivity(intent);
                break;
            }
            case R.id.solo_normal: {
                //「normal」をタップした時の処理
                Intent intent = new Intent(this, Activity_reversi.class);
                intent.putExtra("com", 2);
                startActivity(intent);
                break;
            }
            case R.id.solo_hard: {
                //「hard」をタップした時の処理
                Intent intent = new Intent(this, Activity_reversi.class);
                intent.putExtra("com", 3);
                startActivity(intent);
                break;
            }
        }
    }
}