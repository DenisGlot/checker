package com.denisgl.web.model;

import org.junit.Test;

import static org.junit.Assert.*;
import static org.junit.Assert.fail;

public class CheckerSideTest {

    static final CheckerSide red = CheckerSide.WHITE;

    @Test
    public void testEqualsType() {
        assertTrue(red.equalsType(CheckerSide.WHITE));
        assertFalse(red.equalsType(CheckerSide.BLACK));
    }

    @Test
    public void testGetOpposite() {
        CheckerSide toBeBlack = CheckerSide.getOpposite(red);
        assertTrue(toBeBlack == CheckerSide.BLACK);

    }

    @Test
    public void testGetRandomSide() {
        CheckerSide randomSide = CheckerSide.getRandomSide();
        assertTrue(randomSide == CheckerSide.WHITE || randomSide == CheckerSide.BLACK);
    }
}