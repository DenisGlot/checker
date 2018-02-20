package com.denisgl.web.model;

import com.denisgl.web.repository.InitSessionFactory;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Map;

public class Rules {

    final static Logger logger = Logger.getLogger(Rules.class);

    private Point from;
    private Point to;
    private Checker checkerFrom;
    private Checker checkerTo;

    @Autowired
    GameBoard gameBoard;

    private boolean isNotValidChecker(Checker checker){
        return checker.getCheckerType().equalsType(CheckerType.NONE) || checker.getCheckerSide().equalsType(CheckerSide.NONE);
    }

    public boolean isValidMove(Move move, CheckerSide side) {
        logger.debug(">>>> move = " + move);
        from = Move.convertMoveToFromPoint(move);
        to = Move.convertMoveToToPoint(move);
        Map<Point,Checker> desc = gameBoard.getDesc();
        checkerFrom = desc.get(from);
        checkerTo = desc.get(to);
        if(checkerFrom.getCheckerSide().equalsType(CheckerSide.WHITE)) {
            logger.debug(">>>>white");
            if(checkerTo.getCheckerType().equalsType(CheckerType.NONE)){
                if(((to.getY() - 1) == from.getY()) && (Math.abs(to.getX() - from.getX()) == 1)){
                    return setMapForCheckers();
                }
            }
        }
        if(checkerFrom.getCheckerSide().equalsType(CheckerSide.BLACK)) {
            logger.debug(">>>>black");
            if(checkerTo.getCheckerType().equalsType(CheckerType.NONE)){
                if(((to.getY() + 1) == from.getY()) && (Math.abs(to.getX() - from.getX()) == 1)){
                   return setMapForCheckers();
                }
            }
        }
        return false;
    }

    private boolean setMapForCheckers(){
        checkerTo = checkerFrom.clone();
        checkerFrom.setCheckerType(CheckerType.NONE);
        checkerFrom.setCheckerSide(CheckerSide.NONE);
        gameBoard.getDesc().put(from,checkerFrom);
        gameBoard.getDesc().put(to,checkerTo);
        return true;
    }
}
