package sokoban.Controllers;

import java.io.IOException;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import sokoban.App;

public class levelSelectMenuController {
     @FXML
    private ImageView level1ImageView;

    @FXML
    private ImageView level2ImageView;

    @FXML
    private ImageView level3ImageView;

    @FXML
    private ImageView level4ImageView;

    @FXML
    private ImageView level5ImageView;

    @FXML
    private Button quitButton;

    @FXML
    private Button returnMenuButton;

    @FXML
    private void switchToPrimary() throws IOException {
        App.setRoot("mainMenu");
    }
}