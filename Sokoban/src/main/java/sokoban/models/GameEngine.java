package sokoban.models;

import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;

public class GameEngine {
        private String test="-fx-background-image:url('textures/a.png'); -fx-background-size:cover;";
    public void loadSelectedLevel(int lvlSelected, GridPane gameGrid) {
        for (int i = 0; i <121; i++) {
            gameGrid.getChildren().get(i).setStyle(test);
        }
    }

    public void initializeGameGrid(GridPane gameGrid) {
        if(gameGrid.getCellBounds(0, 0).isEmpty()){
            for (int i = 0; i <11; i++) {
                for (int j = 0; j <11; j++) {
                    gameGrid.add(new Pane(), i, j);
                }
            }
        }
    }
    
}
