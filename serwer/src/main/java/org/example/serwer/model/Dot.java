package com.example.serwer.model;

import javafx.scene.paint.Color;

public record Dot(int x, int y, String colorHex, int radius) {

    /**
     * Buduje String do wysłania: "x;y;colorHex;radius"
     */
    public static String toMessage(int x, int y, Color color, int radius) {
        String hex = color.toString();            // np. 0xFF0000FF
        return x + ";" + y + ";" + hex + ";" + radius;
    }

    /**
     * Parsuje wiadomość w formacie "x;y;colorHex;radius" na obiekt Dot.
     * Rzuca IllegalArgumentException jeśli format nieprawidłowy.
     */
    public static Dot fromMessage(String msg) {
        String[] parts = msg.split(";");
        if (parts.length != 4) {
            throw new IllegalArgumentException("Nieprawidłowy format wiadomości: " + msg);
        }
        int x = Integer.parseInt(parts[0]);
        int y = Integer.parseInt(parts[1]);
        String hex = parts[2];
        int radius = Integer.parseInt(parts[3]);
        return new Dot(x, y, hex, radius);
    }

    /**
     * Pomocniczo: generuje wiadomość sieciową z własnych pól.
     */
    public String toMessage() {
        return toMessage(x, y, Color.web(colorHex), radius);
    }

    /**
     * Przyda się gdy chcesz konwertować kolor Hex na Color.
     */
    public Color toColor() {
        return Color.web(colorHex);
    }
}