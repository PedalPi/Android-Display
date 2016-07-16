package io.github.pedalpi.pedalpidisplay.communication;

import org.json.JSONObject;

public class Message {

    private final ProtocolType type;
    private final JSONObject message;

    public Message(ProtocolType type) {
        this.type = type;
        this.message = null;
    }

    public Message(ProtocolType type, JSONObject message) {
        this.type = type;
        this.message = message;
    }

    public boolean hasMessage() {
        return message != null;
    }

    @Override
    public String toString() {
        if (hasMessage())
            return type + " " + message.toString();
        else
            return type.toString();
    }
}
