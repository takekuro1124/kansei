/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.denki.reversi.board;

/**
 *
 * @author denki
 */
public class Board {
    private int[][] mBoard;
    
    public int[][] getBoard() {
        return mBoard;
    }
    
    public Board() {
        // メモリに読み込まれた時に実行する。
        mBoard = new int[8][8];
        mBoard[3][3] = BLACK;
        mBoard[3][4] = WHITE;
        mBoard[4][3] = WHITE;
        mBoard[4][4] = BLACK;
    }
    public static final int NONE = -1; 
     public static final int SPACE = 0; 
     public static final int BLACK = 1; 
     public static final int WHITE = 2; 
 


    private static boolean check(int[][] board, int player, int x, int y, int moveX, int moveY, int count) { 
         int nextX = x + moveX;          int nextY = y + moveY; 
 
 
         if((nextX < 0 || nextX >= board.length) || 
            (nextY < 0 || nextY >= board[0].length)) { 
             return false; 
         } 
 
 
         if(board[nextX][nextY] == SPACE) return false; 
 
 
         if(board[nextX][nextY] != SPACE && 
            board[nextX][nextY] != player) { 
             // 次を探索 
             return check(board, player, nextX, nextY, moveX, moveY, count + 1); 
         } 
 
 
         if(board[nextX][nextY] == player && count > 0) return true; 
 
 
         return false; 
     } 
  

    
    // 駒を置く
    public boolean setPiece(int player,  int x, int y) {
        if(mBoard[x][y] != SPACE) return false;

        boolean ret = false;

        // おけるかどうかの判定
        for(int i = -1; i < 2; i++) { 
             for(int j = -1; j < 2; j++) { 
                 if(i == 0 && j == 0) continue; 
                 ret = check(mBoard, player, x, y, i, j, 0); 
                 if(ret) {
                     // 終了
                     i = 3;
                     j = 3;
                 } 
             } 
         } 
 
        if(!ret) return false;
        
        // ひっくり返す。
        change(mBoard, player, x, y);
             
         return true; 
        
    }
        public static int[][] change(int[][] board, int player, int x, int y) { 
         for(int i = -1; i < 2; i++) { 
             for(int j = -1; j < 2; j++) { 
                 if(i == 0 && j == 0) continue; 
                 boolean ret = check(board, player, x, y, i, j, 0); 
                 if(ret) { 
                     // ひっくり返す処理 
                     int nextX = x + i; 
                     int nextY = y + j; 
                     while((nextX >= 0 && nextX < board.length) && 
                             (nextY >= 0 && nextY < board.length) && 
                             (board[nextX][nextY] != SPACE) && (board[nextX][nextY] != player)) { 
                         board[nextX][nextY] = player; 
                         nextX += i; 
                         nextY += j; 
                     } 
                     board[x][y] = player; 
                 } 
             } 
         } 
 
 
         return board; 
     } 

}
