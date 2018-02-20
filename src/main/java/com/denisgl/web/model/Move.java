package com.denisgl.web.model;

import java.io.Serializable;
import java.util.Objects;

public class Move implements Serializable {

    private static final long serialVersionUID = 1445656432556L;

    private int from;
    private int to;



    public int getFrom() {
        return from;
    }

    public void setFrom(int from) {
        this.from = from;
    }

    public int getTo() {
        return to;
    }

    public void setTo(int to) {
        this.to = to;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Move move = (Move) o;
        return from == move.from &&
                to == move.to;
    }

    @Override
    public int hashCode() {

        return Objects.hash(from, to);
    }

    @Override
    public String toString() {
        return "Move{" +
                "from=" + from +
                ", to=" + to +
                '}';
    }

    public static Point convertMoveToFromPoint(Move move){
        return getPointFromTwoDigit(move.getFrom());
    }
    public static Point convertMoveToToPoint(Move move){
        return getPointFromTwoDigit(move.getTo());
    }
    private static Point  getPointFromTwoDigit(int point){
        int y = point/10;
        int x = point%10;
        if(point>88 || point<11 || (x+y)%2 == 1){
            throw new IllegalArgumentException("y = " + y + " x = " + x);
        }
        return new Point(x,y);
    }
}
