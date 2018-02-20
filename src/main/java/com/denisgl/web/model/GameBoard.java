package com.denisgl.web.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;


public class GameBoard {

    public static final int sizeX = 8;

    public static final int sizeY = 8;

    private Map<Point, Checker> desc = new ConcurrentHashMap<>();

    public GameBoard(){
        fillBoardOnStrartUp();
    }

    public void fillBoardOnStrartUp(){
        desc.clear();
        generatePointsTopDownLeftRight().forEach((point)->{
            if(isWhitePoint(point)){
                desc.put(point,new Checker(CheckerType.NONE,CheckerSide.NONE));
            } else {
                arrangePlacesForWhitesAndBlacks(point);
            }
        });
    }

    private List<Point> generatePointsTopDownLeftRight() {
        List<Point> allPoints = new ArrayList<>();

        for (int y = 1; y <= sizeY; y++) {
            for (int x = 1; x <= sizeX; x++) {
                Point point = new Point(x, y);
                allPoints.add(point);
                point = null;
            }
        }
        return allPoints;
    }

    private boolean isWhitePoint(Point point){
        return (point.getX()+point.getY())%2 == 1;
    }

    private void arrangePlacesForWhitesAndBlacks(Point point){
        if(point.getY()<=3){
            desc.put(point,new Checker(CheckerType.REGULAR,CheckerSide.WHITE));
        } else if(point.getY()>=6){
            desc.put(point,new Checker(CheckerType.REGULAR,CheckerSide.BLACK));
        } else {
            desc.put(point,new Checker(CheckerType.NONE,CheckerSide.NONE));
        }
    }

    public Map<Point, Checker> getDesc() {
        return desc;
    }
}
