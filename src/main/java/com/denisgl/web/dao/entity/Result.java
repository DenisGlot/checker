package com.denisgl.web.dao.entity;

import javax.persistence.*;
import java.util.Date;
import java.util.Objects;

@Entity
@Table
public class Result {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column
    private String winner;
    @Column
    @Temporal(TemporalType.TIMESTAMP)
    private Date date;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getWinner() {
        return winner;
    }

    public void setWinner(String winner) {
        this.winner = winner;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "Result{" +
                "id=" + id +
                ", winner='" + winner + '\'' +
                ", date=" + date +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Result result = (Result) o;
        return id == result.id &&
                Objects.equals(winner, result.winner) &&
                Objects.equals(date, result.date);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, winner, date);
    }
}
