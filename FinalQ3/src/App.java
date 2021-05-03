import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

public class App extends Application {

  // Create variables and nodes
  private int count = 0;
  private Label label = new Label("Increment/Decrement");
  private TextField textField = new TextField();
  private Button increment = new Button("inc");
  private Button decrement = new Button("dec");
  private Button reset = new Button("reset");
  
  @Override
  public void start(Stage primaryStage) {
    // Create the IU
    GridPane gridPane = new GridPane();
    gridPane.setHgap(10);
    gridPane.setVgap(10);
    label.setFont(Font.font("Times New Romen", FontWeight.BOLD, 15));
    textField.setPrefHeight(40);
    textField.setEditable(false);
    textField.setText("0");
    HBox hBox = new HBox(increment, decrement, reset);
    hBox.setAlignment(Pos.CENTER);
    HBox.setMargin(hBox, new Insets(15));

    // Add nodes
    gridPane.add(label, 0, 0);
    gridPane.add(textField, 0, 1);
    gridPane.add(hBox, 0, 2);
    gridPane.setAlignment(Pos.CENTER);

    // Handle events
    increment.setOnAction(e -> {
      count++;
      textField.setText(String.valueOf(count));
    });

    decrement.setOnAction(e -> {
      count--;
      textField.setText(String.valueOf(count));
    });

    reset.setOnAction(e -> {
      count = 0;
      textField.setText("0");
    });

    // Set stage, scene, title
    Scene scene = new Scene(gridPane, 200, 150);
    primaryStage.setTitle("FinalFX");
    primaryStage.setScene(scene);
    primaryStage.show();
  }
  
  
  
  
  
  
  public static void main(String[] args) {
        launch(args);
    }
}
