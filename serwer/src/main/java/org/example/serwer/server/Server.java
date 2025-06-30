package com.example.app.server;

import com.example.serwer.model.Dot;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class Server {
    private final int port;
    private final List<ClientThread> clients = new CopyOnWriteArrayList<>();

    public Server(int port) {
        this.port = port;
    }

    /** Uruchamia serwer, akceptuje połączenia i startuje wątki klientów */
    public void start() throws IOException {
        try (ServerSocket serverSocket = new ServerSocket(port)) {
            System.out.println("Server started on port " + port);
            while (true) {
                Socket socket = serverSocket.accept();
                ClientThread client = new ClientThread(this, socket);
                clients.add(client);
                client.start();

                // Po dołączeniu wyślij mu zapisane kropki:
                for (Dot d : getSavedDots()) {
                    client.send(d.toMessage());
                }
            }
        }
    }

    /** Wyślij wiadomość (wiadomość Dot w formie String) do wszystkich klientów */
    public void broadcast(String msg) {
        // najpierw zapisz w bazie
        Dot dot = Dot.fromMessage(msg);
        saveDot(dot);

        // rozsyłaj do każdego
        for (ClientThread c : clients) {
            c.send(msg);
        }
    }

    /** Zapisz do DB – implementacja niżej */
    public void saveDot(Dot dot) {
        // tu wykonujesz INSERT do SQLite
    }

    /** Pobierz wszystkie zapisane kółka z DB */
    public List<Dot> getSavedDots() {
        // tu SELECT * FROM dot i zmapuj na List<Dot>
        return List.of(); // na razie pusta
    }
}