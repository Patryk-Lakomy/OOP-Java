import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) {
        GameCanvas gameCanvas = new GameCanvas(800, 600);
        gameCanvas.draw(); // Rysowanie czarnego tła

        StackPane root = new StackPane(gameCanvas);
        Scene scene = new Scene(root);

        primaryStage.setTitle("Game Canvas Example");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}