package sokoban.Controllers;

import java.io.IOException;
import javafx.fxml.FXML;
import sokoban.App;

public class levelSelectMenuController {

    @FXML
    private void switchToPrimary() throws IOException {
        App.setRoot("mainMenu");
    }
}