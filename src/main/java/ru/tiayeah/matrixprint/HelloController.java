package ru.tiayeah.matrixprint;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;

public class HelloController {
    @FXML
    private Button DefaultCreateButton;
    @FXML
    private CheckBox BorderCheckbox;
    @FXML
    private AnchorPane AnchorPane;
    private IMatrix matrix;

    @FXML
    protected void onDefaultCreateButtonClick() {
        System.out.println();
        AnchorPane.getChildren().clear();
        matrix = new OrdinaryMatrix(5,5);
        MatrixInitializer.fillMatrix(matrix, 15, 10);
        matrix.draw(new ConsoleDrawer(), BorderCheckbox.isSelected());
        matrix.draw(new GUIDrawer(AnchorPane), BorderCheckbox.isSelected());
    }

    @FXML
    protected void onSparseCreateMatrixClick() {
        System.out.println();
        AnchorPane.getChildren().clear();
        matrix = new SparseMatrix(5,5);
        MatrixInitializer.fillMatrix(matrix, 15, 10);
        matrix.draw(new ConsoleDrawer(), BorderCheckbox.isSelected());
        matrix.draw(new GUIDrawer(AnchorPane), BorderCheckbox.isSelected());
    }

    @FXML
    protected void onCheckBoxClick() {
        AnchorPane.getChildren().clear();
        if (matrix != null) {
            matrix.draw(new GUIDrawer(AnchorPane), BorderCheckbox.isSelected());
            System.out.println();
            matrix.draw(new ConsoleDrawer(), BorderCheckbox.isSelected());
        }
    }
}