package io.github.pedalpi.pedalpidisplay.communication;

public enum ProtocolType {
    ACK("ack"),
    EFFECT("effect"),
    ERROR("error");

    private final String type;

    ProtocolType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return type;
    }
}
