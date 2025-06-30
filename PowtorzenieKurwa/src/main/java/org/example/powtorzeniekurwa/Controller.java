package org.example.powtorzeniekurwa;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import org.example.powtorzeniekurwa.server.ClientThread;
import org.example.powtorzeniekurwa.server.Server;

import java.io.IOException;

public class Controller {

    Server serwerek=new Server();

    @FXML
    private Label welcomeText;

    @FXML
    protected void onHelloButtonClick() {
        welcomeText.setText("Welcome to JavaFX Application!");
    }

    public void onStartServerClicked() {
        new Thread(() -> {
            try {
                serwerek.start(5000);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }).start();
    }

    public void onConnectClicked() {
        new Thread(() -> {
            try {
                kliencik.startConnection("127.0.0.1", 5000);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }).start();
    }
    public void onMouseClicked(){
        System.out.println("s");
    }



}