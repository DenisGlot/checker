package com.denisgl.web.model;


import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class MoveTest {

    Point point82 = new Point(2,8);
    Point point71 = new Point(1,7);
    static Move fakeMove = new Move();
    static Move move = new Move();

    @BeforeClass
    public static void setUp(){
        move.setFrom(82);
        move.setTo(71);
        fakeMove.setFrom(55);
    }

    @Test
    public void testConvertMoveToFromPoint() {
        assertEquals(point82, Move.convertMoveToFromPoint(move));
    }

    @Test
    public void testConvertMoveToToPoint() {
        assertEquals(point71,Move.convertMoveToToPoint(move));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testFailMove(){
        Move.convertMoveToFromPoint(fakeMove);
    }
}