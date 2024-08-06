package sokoban.Controllers;

import java.io.IOException;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import sokoban.App;

public class levelSelectMenuController {
    public static int lvlSelected=0;
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
    void pressLvl1Button(ActionEvent event) throws IOException {
        lvlSelected=1;
        gameController.onReplay=false;
        App.setRoot("game");
    }

    @FXML
    void pressLvl2Button(ActionEvent event) throws IOException {
        lvlSelected=2;
        gameController.onReplay=false;
        App.setRoot("game");
    }

    @FXML
    void pressLvl3Button(ActionEvent event) throws IOException {
        lvlSelected=3;
        gameController.onReplay=false;
        App.setRoot("game");
    }

    @FXML
    void pressLvl4Button(ActionEvent event) throws IOException {
        lvlSelected=4;
        gameController.onReplay=false;
        App.setRoot("game");
    }

    @FXML
    void pressLvl5Button(ActionEvent event) throws IOException {
        lvlSelected=5;
        gameController.onReplay=false;
        App.setRoot("game");
    }
    @FXML
    void onActionQuit(ActionEvent event) {
         Platform.exit();
    }

}