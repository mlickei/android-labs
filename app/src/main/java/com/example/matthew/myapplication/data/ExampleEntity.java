package com.example.matthew.myapplication.data;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

/**
 * Created by Matthew on 3/25/2018.
 */
@Entity(tableName = "entry")
public class ExampleEntity {

    @PrimaryKey
    private int eId;

    @ColumnInfo(name="name")
    private String name;

    @ColumnInfo(name="cost")
    private double cost;

    public int getEId() {
        return eId;
    }

    public void setEId(int eId) {
        this.eId = eId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }
}
