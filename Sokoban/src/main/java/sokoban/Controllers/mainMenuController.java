package sokoban.Controllers;

import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import sokoban.App;

public class mainMenuController{
    
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

}
