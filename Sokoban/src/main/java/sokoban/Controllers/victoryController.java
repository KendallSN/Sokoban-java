package sokoban.Controllers;

import java.io.IOException;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import sokoban.App;

public class victoryController {
    @FXML
    private Button levelSelectionButton;

    @FXML
    private Button nextButton;

    @FXML
    private Button quitButton;

    @FXML
    private Button repetitionButton;

    @FXML
    private Button returnMenuButton;
    
    @FXML
    private void switchToSecondary() throws IOException {
        App.setRoot("levelSelectMenu");
    }
    @FXML
    private void doAction() throws IOException {
        switchToSecondary();
    }
}
