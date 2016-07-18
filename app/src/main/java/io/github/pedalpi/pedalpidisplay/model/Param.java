package io.github.pedalpi.pedalpidisplay.model;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.Serializable;

import io.github.pedalpi.pedalpidisplay.architecture.ConversionException;

public class Param implements Serializable {

    private final String name;
    private final double current;
    private final double minimum;
    private final double maximum;

    public Param(JSONObject json) {
        try {
            this.current = json.getDouble("current");
            this.name =  json.getString("name");
            this.minimum =  json.getDouble("min");
            this.maximum =  json.getDouble("max");

        } catch (JSONException e) {
            throw new ConversionException(e);
        }
    }

    public String getCurrent() {
        return "" + this.current;
    }

    public String getName() {
        return this.name;
    }

    public String getMinimum() {
        return this.minimum  + "";
    }

    public String getMaximum() {
        return this.maximum + "";
    }
}
