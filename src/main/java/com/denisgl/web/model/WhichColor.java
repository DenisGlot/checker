package com.denisgl.web.model;

public class WhichColor {

    private static WhichColor instance = new WhichColor();

    public static WhichColor getInstance(){
        return instance;
    }

    private WhichColor(){}
    private CheckerSide nikitaSide;

    private CheckerSide denisSide;

    public CheckerSide getNikitaSide() {
        return nikitaSide;
    }

    public CheckerSide getDenisSide() {
        return denisSide;
    }

    public void setDenisAndNikitaSideToNull() {
        this.denisSide = null;
        this.nikitaSide = null;
    }

    public void declareSidesIfTheyAreNull(){
        if(nikitaSide == null && denisSide == null){
            nikitaSide = CheckerSide.getRandomSide();
            denisSide = CheckerSide.getOpposite(nikitaSide);
        }
    }
}
