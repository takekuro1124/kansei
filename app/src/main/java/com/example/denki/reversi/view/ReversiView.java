package com.example.denki.reversi.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Bundle;
import android.text.BoringLayout;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.graphics.Paint;

import com.example.denki.reversi.board.Board;

/**
 * Created by denki on 2016/09/26.
 */
public class ReversiView extends View {

    private int[][] mBoard;
    private int mPlayer = 1;
    private Board mInstance;

    public void setBoard(int[][] mBoard) {
        this.mBoard = mBoard;
    }

    // デフォルトコンストラクタ
    public ReversiView(Context context) {
        super(context);
        mInstance = new Board();
    }

    // XMLに定義するときに呼び出されるコンストラクタ
    public ReversiView(Context context, AttributeSet attr) {
        super(context, attr);
        mInstance = new Board();
    }



    // タッチした時のイベント
    // どのマスがタッチされたかを検知させる。
    @Override
    public boolean onTouchEvent(MotionEvent event) {
        float x = event.getX();
        float y = event.getY();
        //座標をマスの目に変える
        int width = (this.getWidth() >= this.getHeight()) ? this.getHeight() : this.getWidth();

        int posX = (int) (x / (width / 8));
        int posY = (int) (y / (width / 8));

        // コマを置く
        if(mInstance.setPiece(mPlayer, posX, posY)) {
            //if(Board.setPiece(mPlayer, posX, posY)) {
            //       // ひっくり返せた。
            //       // 手番の交代
            //1が自分
            mPlayer = (mPlayer == 1) ? 2 : 1;
            //       // 再描画
            mBoard = new int[8][8];
            for (int i = 0; i < mBoard.length; i++) {
                for (int j = 0; j < mBoard[i].length; j++) {
                    mBoard[i][j] = 0;
                }
            }
            invalidate();
        }

    return super.onTouchEvent(event);

}


        // 描画の処理（板の背景、コマ。すべて描画する）
        @Override
        protected void onDraw(Canvas canvas){
            super.onDraw(canvas);

            Paint p = new Paint();

            p.setARGB(255, 0, 255, 0);
            canvas.drawRect(0, 0, this.getWidth(), this.getHeight(), p);

            Paint paint2 = new Paint();
            Paint paint3 = new Paint();

            int width = (this.getWidth() >= this.getHeight()) ? this.getHeight() : this.getWidth();

            paint2.setColor(Color.argb(255, 0, 0, 0));
//        float[] pts = {40.0f,0.0f,40.0f,250.0f,
//                  80.0f,0.0f,80.0f,250.0f,
//                  120.0f,0.0f,120.0f,250.0f,
//                  160.0f,0.0f,160.0f,250.0f,
//                200.0f,0.0f,200.0f,250.0f,
//                240.0f,0.0f,240,0f,250.0f,
//                280.0f,0.0f,280.0f,250.0f,
//                320.0f,0.0f,320.0f,250.0f};

            int masu = width / 8;
            for (int i = 0; i < 9; i++) {
                canvas.drawLine(masu * i, 0, masu * i, width, paint2);
            }
            for (int i = 0; i < 9; i++) {
                canvas.drawLine(0, masu * i, width, masu * i, paint3);
            }
//        float[] pts = {40.0f,0.0f,40.0f,250.0f,
//                  80.0f,0.0f,80.0f,250.0f,
//                  120.0f,0.0f,120.0f,250.0f,
//                  160.0f,0.0f,160.0f,250.0f,
//                200.0f,0.0f,200.0f,250.0f,
//                240.0f,0.0f,240,0f,250.0f};
//        canvas.drawLines(pts,paint2);

            // コマの描画
            int[][] board = mInstance.getBoard();
            if (board != null) {
                for (int i = 0; i < board.length; i++)
                    for (int j = 0; j < board[i].length; j++) {
                        // TODO: 描画の処理を書く
                        Paint paint1 = new Paint();
                        if (board[i][j] == 1) {
                            // 黒
                            p.setColor(Color.argb(255, 0, 0, 0));
                            p.setAntiAlias(true);
                            canvas.drawCircle((masu * i + masu * (i + 1)) / 2, (masu * j + masu * (j + 1)) / 2, 20.0f, p);
                        } else if (board[i][j] == 2) {
                            // 白
                            p.setColor(Color.argb(255, 255, 255, 255));
                            p.setAntiAlias(true);
                            canvas.drawCircle((masu * i + masu * (i + 1)) / 2, (masu * j + masu * (j + 1)) / 2, 20.0f, p);
                        }
                    }
            }

        }
    }