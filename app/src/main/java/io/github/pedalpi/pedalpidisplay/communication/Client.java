package io.github.pedalpi.pedalpidisplay.communication;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;

public class Client {

    public interface OnMessageListener {
        void onMessage(Message message);
    }

    private static Client instance;

    public synchronized Client getInstance() {
        if (instance != null)
            return instance;

        Client.instance = new Client();

        return Client.instance;
    }

    private Socket connection;
    private PrintStream out;
    private BufferedReader in;

    private boolean status;
    private OnMessageListener listener;

    private Transmission transmission;

    private Client() {
        listener = new OnMessageListener() {public void onMessage(Message message) {}};
    }

    public void connect(String ip, int port) throws IOException, ClassNotFoundException {
        this.connection = new Socket(ip, port);
        this.out = new PrintStream(connection.getOutputStream());
        this.in = new BufferedReader(new InputStreamReader(connection.getInputStream()));

        transmission = new Transmission(this);
    }

    public void disconnect() throws IOException {
        transmission.close();
        connection.close();
    }

    public void send(Message message) {
        out.print(message);
    }

    public String getStreamLine() throws IOException {
        return in.readLine();
    }

    public void setListener(OnMessageListener listener) {
        this.listener = listener;
    }

    public OnMessageListener getListener() {
        return listener;
    }
}
