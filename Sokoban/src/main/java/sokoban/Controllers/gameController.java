package sokoban.Controllers;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.GridPane;
import sokoban.App;
import sokoban.models.FileTextReader;
import sokoban.models.GameEngine;

public class gameController implements Initializable{
    GameEngine gameEngine;
    
    @FXML
    private GridPane gameGrid;
    
    @FXML
    void keyPressed(KeyEvent event) {
        gameEngine.keyPressed(event.getText());
    }
    @FXML
    void saveLevel(ActionEvent event) {
        FileTextReader.saveLevel(gameEngine.getCurrentLevel(), levelSelectMenuController.lvlSelected);
    }
    @FXML
    void quitToMenu(ActionEvent event) throws IOException {
        App.setRoot("mainMenu");
    }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        this.gameEngine= new GameEngine();
        gameEngine.initializeGameGrid(gameGrid);
        if(mainMenuController.continueFromSave){
            gameEngine.loadSavedLevel();
        }else{
            gameEngine.loadSelectedLevel(levelSelectMenuController.lvlSelected);
        }
    }
}