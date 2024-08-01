package sokoban.Controllers;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import sokoban.App;
import sokoban.models.ListGrid;

public class mainMenuController implements Initializable{
    
    @FXML
    public Button actionButton;
    @FXML
    private void newGameOnAction() throws IOException {
        App.setRoot("levelSelectMenu");
    }
    @FXML
    void continueOnAction(ActionEvent event) {
        
    }
    @FXML
    void quitOnAction(ActionEvent event) {
        
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        char[] miVectorDeChar = {'a', 'b', 'c','d',
                                 'e', 'f','d', 'e',
                                 'f','d', 'e', 'x'};
        ListGrid listGrid =new ListGrid(3,4,miVectorDeChar);
        }

}
