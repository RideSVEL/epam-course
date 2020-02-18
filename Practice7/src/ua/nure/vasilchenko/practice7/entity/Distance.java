package ua.nure.vasilchenko.practice7.entity;

public class Distance {

    private String type;
    private int range;

    public Distance(String type, int range) {
        this.type = type;
        this.range = range;
    }

    public Distance() {
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getRange() {
        return range;
    }

    public void setRange(int range) {
        this.range = range;
    }
}
