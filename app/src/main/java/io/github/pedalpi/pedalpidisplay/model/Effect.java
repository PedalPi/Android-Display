package io.github.pedalpi.pedalpidisplay.model;

import org.json.JSONException;
import org.json.JSONObject;

import io.github.pedalpi.pedalpidisplay.architecture.ConversionException;

public class Effect {

    private final JSONObject json;

    public Effect(JSONObject object) {
        this.json = object;
    }

    public String getIndex() {
        try {
            return "" + json.getInt("index");
        } catch (JSONException e) {
            throw new ConversionException(e);
        }
    }

    public String getName() {
        try {
            return "" + json.getString("name");
        } catch (JSONException e) {
            throw new ConversionException(e);
        }
    }
}
