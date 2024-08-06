package sokoban.Controllers;

import java.io.IOException;
import javafx.application.Platform;
import javafx.event.ActionEvent;
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
    private void onActionSelectLevel() throws IOException {
        App.setRoot("levelSelectMenu");
    }
    @FXML
    private void onActionReplay() throws IOException {
        gameController.onReplay=true;
        App.setRoot("game");
    }
    @FXML
    void onActionQuit(ActionEvent event) {
         Platform.exit();
    }
    @FXML
    void onActionReturnMenu(ActionEvent event) throws IOException {
        App.setRoot("mainMenu");
    }
}
