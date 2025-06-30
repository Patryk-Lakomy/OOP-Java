module org.example.serwer {
    requires javafx.controls;
    requires javafx.fxml;


    opens org.example.serwer to javafx.fxml;
    exports org.example.serwer;
}