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

import com.example.denki.reversi.view.ReversiView;

/**
 * Created by denki on 2016/12/05.
 */

public class Activity_reversi extends  Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reversi);

        int[][] board = new int[8][8];
        board[3][3] = 1;
        board[3][4] = 2;
        board[4][3] = 2;
        board[4][4] = 1;

        ReversiView view = (ReversiView)findViewById(R.id.view);
        view.setBoard(board);
    }
}
