package io.github.pedalpi.pedalpidisplay.communication;

import org.json.JSONObject;

public class Message {

    private final ProtocolType type;
    private final JSONObject content;

    public Message(ProtocolType type) {
        this.type = type;
        this.content = null;
    }

    public Message(ProtocolType type, JSONObject content) {
        this.type = type;
        this.content = content;
    }

    public boolean hasContent() {
        return content != null;
    }

    public JSONObject getContent() {
        return content;
    }

    @Override
    public String toString() {
        if (hasContent())
            return type + " " + content.toString();
        else
            return type.toString();
    }
}
