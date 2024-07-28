package sokoban.Controllers;

import java.io.IOException;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import sokoban.App;

public class victoryController {
    @FXML
    public Button actionButton;
    
    @FXML
    private void switchToSecondary() throws IOException {
        App.setRoot("levelSelectMenu");
    }
    @FXML
    private void doAction() throws IOException {
        switchToSecondary();
    }
}
