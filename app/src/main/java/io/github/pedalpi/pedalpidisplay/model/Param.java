package io.github.pedalpi.pedalpidisplay.model;

import org.json.JSONException;
import org.json.JSONObject;

import io.github.pedalpi.pedalpidisplay.architecture.ConversionException;

public class Param {

    private final JSONObject json;

    public Param(JSONObject json) {
        this.json = json;
    }

    public String getValue() {
        try {
            return "" + json.getDouble("value");
        } catch (JSONException e) {
            throw new ConversionException(e);
        }
    }

    public String getName() {
        try {
            return json.getString("name");
        } catch (JSONException e) {
            throw new ConversionException(e);
        }
    }

    public String getMinimum() {
        try {
            return "" + json.getDouble("minimum");
        } catch (JSONException e) {
            throw new ConversionException(e);
        }
    }

    public String getMaximum() {
        try {
            return "" + json.getDouble("maximum");
        } catch (JSONException e) {
            throw new ConversionException(e);
        }
    }
}
