package sokoban.Controllers;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import sokoban.App;
import sokoban.models.FileTextReader;
import sokoban.models.ListGrid;

public class mainMenuController implements Initializable{
    
    @FXML
    public Button actionButton;
    @FXML
    private void newGameOnAction() throws IOException {
        App.setRoot("levelSelectMenu");
    }
    @FXML
    void continueOnAction(ActionEvent event) {
        
    }
    @FXML
    void quitOnAction(ActionEvent event) {
        Platform.exit();
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        FileTextReader a= new FileTextReader();
        
        char[] miVectorDeChar = a.getListaChar().get(4);
        
        ListGrid listGrid = new ListGrid(11,11, miVectorDeChar);
        
        for (int i = 0; i < 11; i++) {
            for (int k = 0; k < 11; k++) {
                System.out.print(listGrid.getElement(i, k).getElement()+" ");
            } 
             System.out.println("");
        }
        
    }

}
