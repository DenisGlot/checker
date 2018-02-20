package com.denisgl.web.model;

import org.springframework.beans.factory.annotation.Autowired;

import java.util.Map;

public class Rules {

    Point from;
    Point to;
    Checker checkerFrom;
    Checker checkerTo;

    @Autowired
    GameBoard gameBoard;

    public void doSome(){

    }

    private boolean isNotValidChecker(Checker checker){
        return checker.getCheckerType().equalsType(CheckerType.NONE) || checker.getCheckerSide().equalsType(CheckerSide.NONE);
    }

    public boolean isValidMove(Move move, CheckerSide side) {
        from = Move.convertMoveToFromPoint(move);
        to = Move.convertMoveToToPoint(move);
        Map<Point,Checker> desc = gameBoard.getDesc();
        checkerFrom = desc.get(from);
        checkerTo = desc.get(to);
        if(!checkerFrom.getCheckerSide().equalsType(side)) { return false;}
        if(checkerFrom.getCheckerSide().equalsType(CheckerSide.WHITE)) {
            if(checkerTo.getCheckerType().equalsType(CheckerType.NONE)){
                if(((to.getY() - 1) == from.getY()) && (Math.abs(to.getX() - from.getX()) == 1)){
                    setMapForCheckers();
                }
            }
        }
        if(checkerFrom.getCheckerSide().equalsType(CheckerSide.BLACK)) {
            if(checkerTo.getCheckerType().equalsType(CheckerType.NONE)){
                if(((to.getY() + 1) == from.getY()) && (Math.abs(to.getX() - from.getX()) == 1)){
                   setMapForCheckers();
                }
            }
        }
        return false;
    }

    private boolean setMapForCheckers(){
        checkerTo = checkerFrom;
        checkerFrom.setCheckerType(CheckerType.NONE);
        checkerFrom.setCheckerSide(CheckerSide.NONE);
        gameBoard.getDesc().put(from,checkerFrom);
        gameBoard.getDesc().put(to,checkerTo);
        return true;
    }
}
