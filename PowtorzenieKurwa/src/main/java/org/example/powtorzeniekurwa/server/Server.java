package org.example.powtorzeniekurwa.server;

import java.io.*;
import java.net.*;

public class Server {
    private ServerSocket serverSocket;

    public void start(int port) throws IOException {
        serverSocket = new ServerSocket(port);
        System.out.println("Serwer nasłuchuje na porcie " + port);
        while (true) {
            Socket clientSocket = serverSocket.accept();
            new Thread(new ClientThread(clientSocket)).start();
        }
    }

    public void stop() throws IOException {
        serverSocket.close();
    }
}