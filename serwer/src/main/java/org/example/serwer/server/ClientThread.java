package com.example.app.server;

import java.io.*;
import java.net.Socket;

public class ClientThread extends Thread {
    private final Server server;
    private final Socket socket;
    private final BufferedReader in;
    private final PrintWriter out;

    public ClientThread(Server server, Socket socket) throws IOException {
        this.server = server;
        this.socket = socket;
        this.in  = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        this.out = new PrintWriter(socket.getOutputStream(), true);
    }

    /** Główna pętla wątku – czyta linie i rozgłasza dalej */
    @Override
    public void run() {
        try {
            String line;
            while ((line = in.readLine()) != null) {
                // każda linia to Dot.toMessage(...)
                server.broadcast(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            cleanup();
        }
    }

    /** Wyślij do tego klienta */
    public void send(String msg) {
        out.println(msg);
    }

    private void cleanup() {
        server.clients.remove(this);
        try { socket.close(); } catch (IOException ignored) {}
    }
}