package io.github.pedalpi.pedalpidisplay.model;

public class Effect {

    private int index;
    private String name;

    public Effect(int index, String name) {
        this.index = index;
        this.name = name;
    }

    public String getIndex() {
        return "" + index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
