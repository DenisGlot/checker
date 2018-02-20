package com.denisgl.web.model.nonchecker;


import com.denisgl.web.model.WhichColor;
import org.junit.Test;

import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;


public class WhichColorTest {

    private static WhichColor wichColor = WhichColor.getInstance();

    @Test
    public void testOnCreatingSides(){
        wichColor.declareSidesIfTheyAreNull();
        assertTrue(wichColor.getDenisSide()!=null);
        assertTrue(wichColor.getNikitaSide()!=null);
    }

    @Test
    public void testSetDenisAndNikitaSideToNull() {
        wichColor.setDenisAndNikitaSideToNull();
        assertNull(wichColor.getDenisSide());
        assertNull(wichColor.getNikitaSide());
    }
}