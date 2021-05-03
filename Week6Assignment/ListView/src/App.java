import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.SelectionMode;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class App extends Application {
  
  @Override
  public void start(Stage primaryStage) {

    Person ian = new Person("Ian", "Bergstrom");
    Person carter = new Person("Carter", "Daniel");
    Person march = new Person("March", "Hill");

    // Create an array of person objects in string form
    String[] people = { ian.getlName() + ", " + ian.getFName(), carter.getlName() + ", " + carter.getFName(), march.getlName() + ", " + march.getFName() };


    // Create a ListView from the people array
    ListView<String> lv = new ListView<>(FXCollections.observableArrayList(people));
    lv.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);

    // Create a FlowPane to contain the label of the selected item from the ListView
    FlowPane flowPane = new FlowPane();
    flowPane.getChildren().add(new Label());

    // Create a VBox to contain the ListView and the FlowPane
    VBox vBox = new VBox(5);
    vBox.setPadding(new Insets(15));
    vBox.getChildren().addAll(lv, flowPane);

    // Handle event
    lv.getSelectionModel().selectedItemProperty().addListener(
      e -> {
        flowPane.getChildren().clear();
        Label selected = new Label(lv.getSelectionModel().getSelectedItem());
        
        flowPane.getChildren().add(selected);
    });

    // Create scene, set it, set title, and show it.
    Scene scene = new Scene(vBox, 300, 400);
    primaryStage.setTitle("ListViewDemo");
    primaryStage.setScene(scene);
    primaryStage.show();
    
  }


  public static void main(String[] args) {
    launch(args);
  }
}