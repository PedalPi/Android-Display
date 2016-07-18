package io.github.pedalpi.pedalpidisplay.model;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.Serializable;

import io.github.pedalpi.pedalpidisplay.architecture.ConversionException;

public class Effect implements Serializable {


    private final int index;
    private final String name;

    public Effect(JSONObject json) {
        try {
            this.index = json.getInt("index");
            this.name = json.getString("name");

        } catch (JSONException e) {
            throw new ConversionException(e);
        }
    }

    public String getIndex() {
        return index + "";
    }

    public String getName() {
        return name;
    }
}
