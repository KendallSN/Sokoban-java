package sokoban.Controllers;

import java.io.IOException;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import sokoban.App;

public class levelSelectMenuController {
    @FXML
    private Button level1Button;
    
    @FXML
    private Button level2Button;

    @FXML
    private Button level3Button;

    @FXML
    private Button level4Button;

    @FXML
    private Button level5Button;

    @FXML
    private Button quitButton;

    @FXML
    private Button returnMenuButton;

    @FXML
    private void switchToPrimary() throws IOException {
        App.setRoot("mainMenu");
    }
    @FXML
    private void onActionTest() throws IOException {
        App.setRoot("game");
    }
}