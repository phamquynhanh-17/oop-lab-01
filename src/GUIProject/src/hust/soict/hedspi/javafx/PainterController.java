package GUIProject.src.hust.soict.hedspi.javafx;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

public class PainterController {

    @FXML
    private Pane drawingAreaPane;
    
    @FXML
    private ToggleGroup toolToggleGroup;

    @FXML
    void drawingAreaMouseDragged(MouseEvent event) {
    	
    	RadioButton selectedTool = (RadioButton)toolToggleGroup.getSelectedToggle();
        Color drawColor = Color.BLACK;
    	
        if (selectedTool != null && selectedTool.getText().equals("Eraser")) {
            drawColor = Color.WHITE;
        }
        
    	Circle newCircle = new Circle(event.getX(), 
    			event.getY(), 4, drawColor);
    	drawingAreaPane.getChildren().add(newCircle);
    }

    @FXML
    void clearButtonPressed(ActionEvent event) {
    	drawingAreaPane.getChildren().clear();
    }

}


