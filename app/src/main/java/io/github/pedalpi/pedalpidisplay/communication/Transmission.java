package io.github.pedalpi.pedalpidisplay.communication;

import java.io.IOException;

class Transmission implements Runnable {

    private boolean status;
    private Server server;

    public Transmission(Server server) {
        this.server = server;
    }

    @Override
    public void run() {
        this.status = true;

        while (status) {
            Message message = getMessage();
            if (message != null)
                this.server.getListener().onMessage(message);
        }
    }

    private Message getMessage() {
        if (server.getClients().isEmpty())
            return null;

        Client client = server.getClients().get(0);

        try {
            String data = client.getStreamLine();
            if (data == null) {
                //Log.i("DATA", "String empty");
                return null;
            }

            return MessageBuilder.generate(data);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return new Message(ProtocolType.ERROR);
    }

    public void close() {
        this.status = false;
    }
}
