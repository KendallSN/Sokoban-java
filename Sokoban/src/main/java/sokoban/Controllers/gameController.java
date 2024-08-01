package sokoban.Controllers;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import sokoban.App;

public class gameController implements Initializable{
    @FXML
    private Pane a;
    @FXML
    private GridPane gameGrid;

    private String test="-fx-background-image:url('a.png'); -fx-background-size:cover;";
    @FXML
    public void action() {
        for (int i = 0; i <11; i++) {
            for (int j = 0; j <11; j++) {
                gameGrid.add(new Pane(), i, j);
            }
        }
        for (int i = 0; i <121; i++) {
            gameGrid.getChildren().get(i).setStyle(test);
        }
    }
    @FXML
    void b(ActionEvent event) throws IOException {
        //App.setRoot("mainMenu");
    }
    @Override
    public void initialize(URL url, ResourceBundle rb) {

    }
}
