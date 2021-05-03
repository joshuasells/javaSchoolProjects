import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.geometry.VPos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;


public class App extends Application implements Serializable {

  @Override
  public void start(Stage primaryStage) {
    ArrayList<Person> tempPeople = null;
    // Load a saved file.
    try {
      FileInputStream fileInput = new FileInputStream("Contacts.dat");
      ObjectInputStream input = new ObjectInputStream(fileInput);
      tempPeople = (ArrayList<Person>)(input.readObject());
      fileInput.close();
    }
    catch (Exception ex) {
      System.out.println("An ERROR OCCURED!!");
      ex.printStackTrace();
    }
    
    ArrayList<Person> people = tempPeople;
    
/*    
    //----------------DEBUG ( uncomment this to have a sample of person objects)---------------------------//
    //------------You will have to comment out the code that is used to load from a file.------------------//
    
    
    Person ian = new Person("Ian", "Bergstrom", new Address("800 W. Main Street", "St. Paul", "CA", "55109"), "ian@gmail.com", "A study hard working student.");
    Person carter = new Person("Carter", "Daniel", new Address("1000 Sample Street", "Maple Grove", "MN", "55410"), "carter@gmail.com", "A very lazy student");
    Person march = new Person("March", "Hill", new Address("2000 Test Street", "Brooklyn Center", "ND", "33465"), "march@gmail.com0", "The best student ever");
    
    ArrayList<Person> people = new ArrayList<>();
    
    // Here I would loop through the loaded file and add every person to the ArrayList.
    // For now I will just add the three people I created above.
    
    people.add(ian);
    people.add(carter);
    people.add(march);
    
    
    //------------------END OF DEBUG------------------------------------------------------------------------//
    //------------------------------------------------------------------------------------------------------//
    
*/
    // Create a ListView
    ListView<Person> listView = new ListView<>(FXCollections.observableArrayList(people));

    // Make the Listview display the Person objects as a string using the toString() method.
    // This comes in handy because we can use the selected part of the ListView to get the Person object's information.
    // If the listview was simply a list of Strings based on the Person object's, then we would need extra programming to get back the properties of the Person object.
    listView.setCellFactory(param -> new ListCell<Person>() {
      @Override
      protected void updateItem(Person person, boolean empty) {
        super.updateItem(person, empty);

        if (empty || person == null || person.toString() == null) {
          setText(null);
        }
        else {
          setText(person.toString());
        }
      }
    });

    // Set selection mode to single on the ListView.
    listView.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
    listView.setPrefWidth(150);

    // Create a BorderPane to contain the content.
    BorderPane contentWrapper = new BorderPane();
    contentWrapper.setPadding(new Insets(20, 40, 40, 20));

    // Create an image of the address book image.
    // Add this image to the top of the contentWrapper (BorderPane).
    Image image = new Image("addressBook.png");
    contentWrapper.setTop(new ImageView(image));

    // Set the ListView we created earlier to the left of the contentWrapper (BorderPane).
    contentWrapper.setLeft(listView);

    // Create a GridPane to hold all of the contact data.
    GridPane gridPane = new GridPane();
    gridPane.setPadding(new Insets(0, 0, 0, 15));
    gridPane.setVgap(7);
    gridPane.setHgap(7);
    gridPane.setAlignment(Pos.TOP_LEFT);
    gridPane.setMaxWidth(400);

    // Add all the Labels to the gridPane
    gridPane.add(new Label("First"), 0, 0);
    gridPane.add(new Label("Last"), 2, 0);
    gridPane.add(new Label("Street"), 0, 1);
    gridPane.add(new Label("City"), 0, 2);
    gridPane.add(new Label("State"), 2, 2);
    gridPane.add(new Label("Zip"), 0, 3);
    gridPane.add(new Label("Email"), 0, 4);
    Label notesLabel = new Label("Notes");
    gridPane.add(notesLabel, 0, 5);
    GridPane.setValignment(notesLabel, VPos.TOP);

    // Create the text fields and add them to the gridPane
    TextField firstTF = new TextField();
    gridPane.add(firstTF, 1, 0);
    TextField lastTF = new TextField();
    gridPane.add(lastTF, 3, 0);
    TextField streetTF = new TextField();
    gridPane.add(streetTF, 1, 1, 3, 1);
    TextField cityTF = new TextField();
    gridPane.add(cityTF, 1, 2);

    // State combobox
    String[] states = {"AL", "AK", "AZ", "AR", "CA", "CO", "CT", "DE", "DC", "FL", 
                       "GA", "HI", "ID", "IL", "IN", "IA", "KS", "KY", "LA", "ME",
                       "MD", "MA", "MI", "MN", "MS", "MO", "MT", "NB", "NV", "NH",
                       "NJ", "NM", "NY", "NC", "ND", "OH", "OK", "OR", "PA", "PR",
                       "RI", "SC", "SD", "TN", "TX", "UT", "VT", "VA", "WA", "WV", "WI", "WY"};
    
    ObservableList<String> statesList = 
      FXCollections.observableArrayList(states);
    ComboBox<String> stateCB = new ComboBox<>();
    stateCB.getItems().addAll(statesList);
    gridPane.add(stateCB, 3, 2);

    TextField zipTF = new TextField();
    gridPane.add(zipTF, 1, 3);
    TextField emailTF = new TextField();
    gridPane.add(emailTF, 1, 4);
    TextArea notesTA = new TextArea();
    notesTA.setPrefRowCount(6);
    gridPane.add(notesTA, 1, 5, 3, 1);

    // Create an HBox with 3 buttons and add them to the gridPane.
    HBox btnHBox = new HBox();
    btnHBox.setSpacing(20);
    Button newButton = new Button("New");
    Button deleteButton = new Button("Delete");
    Button updateButton = new Button("Update");
    btnHBox.getChildren().addAll(newButton, deleteButton, updateButton);
    gridPane.add(btnHBox, 1, 6, 3, 1);
    GridPane.setHalignment(btnHBox, HPos.LEFT);
    

    // Set the gridPane to the center of the contentWrapper (BorderPane).
    contentWrapper.setCenter(gridPane);
    BorderPane.setAlignment(gridPane, Pos.TOP_LEFT);


    // Handle the click events of selecting a person from the ListView.
    listView.getSelectionModel().selectedItemProperty().addListener(
      e -> {
        firstTF.setText(listView.getSelectionModel().getSelectedItem().getFName());
        lastTF.setText(listView.getSelectionModel().getSelectedItem().getlName());
        streetTF.setText(listView.getSelectionModel().getSelectedItem().getAddress().getStreet());
        cityTF.setText(listView.getSelectionModel().getSelectedItem().getAddress().getCity());
        stateCB.setValue(listView.getSelectionModel().getSelectedItem().getAddress().getState());
        zipTF.setText(listView.getSelectionModel().getSelectedItem().getAddress().getZip());
        emailTF.setText(listView.getSelectionModel().getSelectedItem().getEmail());
        notesTA.setText(listView.getSelectionModel().getSelectedItem().getNote());
    });

    // Handle the new button being clicked.
    newButton.setOnAction(e -> {
      Person newContact = new Person("", "", new Address("", "", "", ""), "", "");
      listView.getItems().add(newContact);
      people.add(newContact);
    });

    // Handle the delete button being clicked.
    deleteButton.setOnAction(e -> {
      int indexToDelete = listView.getSelectionModel().getSelectedIndex();
      listView.getItems().remove(indexToDelete);
      people.remove(indexToDelete);
    });

    // Handle the update button being clicked.
    updateButton.setOnAction(e -> {
      listView.getSelectionModel().getSelectedItem().setfName(firstTF.getText());
      listView.getSelectionModel().getSelectedItem().setlName(lastTF.getText());
      listView.getSelectionModel().getSelectedItem().getAddress().setStreet(streetTF.getText());
      listView.getSelectionModel().getSelectedItem().getAddress().setState(stateCB.getValue());
      listView.getSelectionModel().getSelectedItem().getAddress().setCity(cityTF.getText());
      listView.getSelectionModel().getSelectedItem().getAddress().setZip(zipTF.getText());
      listView.getSelectionModel().getSelectedItem().setEmail(emailTF.getText());
      listView.getSelectionModel().getSelectedItem().setNote(notesTA.getText());
    });

    // Handle the event of the user exiting the program.
    primaryStage.setOnCloseRequest(e -> {
      try {
        FileOutputStream fileOutput = new FileOutputStream("Contacts.dat");
        ObjectOutputStream output = new ObjectOutputStream(fileOutput);
        output.writeObject(people);

//        for (int i = 0; i < people.size(); i++) {
//          output.writeObject(people.get(i));
//        }
        output.close();
      } catch (FileNotFoundException e1) {
        e1.printStackTrace();
      } catch (IOException e2) {
        e2.printStackTrace();
      }
    });

    // Create scene, set it, set title, and show it.
    Scene scene = new Scene(contentWrapper);
    primaryStage.setTitle("AddressBook");
    primaryStage.setScene(scene);
    primaryStage.show();

  }

  public static void main(String[] args) {
    launch(args);
  }
}
