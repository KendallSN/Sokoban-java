package sokoban.Controllers;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.GridPane;
import sokoban.App;
import sokoban.models.FileTextReader;
import sokoban.models.GameEngine;

public class gameController implements Initializable{
    GameEngine gameEngine;
    public static boolean onReplay;
    @FXML
    private GridPane gameGrid;
    
    @FXML
    void keyPressed(KeyEvent event) throws IOException {
        gameEngine.keyPressed(event.getText());
    }

    @FXML
    void saveLevel(ActionEvent event) {
        if(!onReplay){
            FileTextReader.saveLevel(gameEngine.getCurrentLevel(), gameEngine.getCurrentLevelID(),gameEngine.getSteps());
        }
    }
    @FXML
    void quitToMenu(ActionEvent event) throws IOException {
        if(gameEngine.getTimer()!=null){gameEngine.getTimer().cancel();}
        App.setRoot("mainMenu");
    }
    @FXML
    void quitOnAction(ActionEvent event) {
        Platform.exit();
    }
    @FXML
    void restartOnAction(ActionEvent event) {
        if(!onReplay){
            gameEngine.restartLevel();
        }
    }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        this.gameEngine= new GameEngine();
        this.gameEngine.initializeGameGrid(gameGrid);
        if(onReplay){
            gameEngine.reproduceReplay();
        }else {
            FileTextReader.deleteWinnedLevel();
            if(mainMenuController.continueFromSave){
                gameEngine.loadSavedLevel();
            }else{
                gameEngine.loadSelectedLevel(levelSelectMenuController.lvlSelected);
            }
        }
    }
}