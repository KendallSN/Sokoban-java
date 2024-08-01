package sokoban.Controllers;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import sokoban.models.GameEngine;

public class gameController implements Initializable{
    GameEngine gameEngine = new GameEngine();
    
    @FXML
    private GridPane gameGrid;

    private String test="-fx-background-image:url('textures/a.png'); -fx-background-size:cover;";
    @FXML
    public void action() {
        
    }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        gameEngine.initializeGameGrid(gameGrid);
        gameEngine.loadSelectedLevel(levelSelectMenuController.lvlSelected,gameGrid);
    }
}
