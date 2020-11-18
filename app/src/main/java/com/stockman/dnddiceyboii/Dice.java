package com.stockman.dnddiceyboii;

public class Dice {

    public String mName;
    public int maxRoll;
    Integer side;

    public Dice(String name, int maxRoll, Integer side) {
        mName = name;
        this.maxRoll = maxRoll;
        this.side = side;
    }

    public String getName() {
        return mName;
    }

    public void setName(String name) {
        mName = name;
    }

    public int getMaxRoll() {
        return maxRoll;
    }

    public void setMaxRoll(int maxRoll) {
        this.maxRoll = maxRoll;
    }

    public Integer getSide() {
        return side;
    }

    public void setSide(Integer side) {
        this.side = side;
    }

}
