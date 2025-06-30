module org.example.powtorzeniekurwa {
    requires javafx.controls;
    requires javafx.fxml;


    opens org.example.powtorzeniekurwa to javafx.fxml;
    exports org.example.powtorzeniekurwa;
}