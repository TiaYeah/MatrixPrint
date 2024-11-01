module ru.tiayeah.matrixprint {
    requires javafx.controls;
    requires javafx.fxml;


    opens ru.tiayeah.matrixprint to javafx.fxml;
    exports ru.tiayeah.matrixprint;
}