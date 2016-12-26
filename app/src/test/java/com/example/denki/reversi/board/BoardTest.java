/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.denki.reversi.board;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author denki
 */
public class BoardTest {
    
    public BoardTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of setPiece method, of class Board.
     */
    @Test
    public void testSetPiece() {
     final int SPACE = 0; 
     final int BLACK = 1; 
     final int WHITE = 2; 
        System.out.println("setPiece");

        Board instance = new Board();
        boolean result = instance.setPiece(1, 6, 2);
        assertEquals(false, result);
        result = instance.setPiece(1, 2, 3);
        assertEquals(false, result);
        result = instance.setPiece(1, 3, 5);
        // TODO review the generated test code and remove the default call to fail.
        assertEquals(true, result);
        
        int[][] board = instance.getBoard();
        assertNotNull(board);
        assertEquals(board[3][3],BLACK);
        assertEquals(board[3][4],BLACK);
        assertEquals(board[4][3],WHITE);
        assertEquals(board[4][4],BLACK);
        assertEquals(board[3][5],BLACK);
        
        // 次の手を置く
//        result = instance.setPiece(WHITE, 2, 2);
//        assertEquals(board[2][2],WHITE);
//        assertEquals(board[3][3],WHITE);
    }
    
}
