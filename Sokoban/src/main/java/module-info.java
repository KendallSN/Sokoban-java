module sokoban {
    requires javafx.controls;
    requires javafx.fxml;

    opens sokoban to javafx.fxml;
    exports sokoban;
}
