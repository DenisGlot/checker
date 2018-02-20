package com.denisgl.web.model;

import java.util.Random;

public enum CheckerSide {

    BLACK,
    WHITE,
    NONE;

    public boolean equalsType(CheckerSide other) {
        return equals(other);
    }

    /**
     * @throws NullPointerException if side = null
     */
    public static CheckerSide getOpposite(CheckerSide side){
        if(side == null){
            throw new NullPointerException();
        }
        if(side.equalsType(WHITE)){
            return BLACK;
        } else {
            return WHITE;
        }
    }

    public static CheckerSide getRandomSide(){
        int zeroOrOne = new Random().nextInt(2);

        return zeroOrOne==1 ? WHITE : BLACK;
    }
}
