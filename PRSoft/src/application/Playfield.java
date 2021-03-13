package application;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;

public class Playfield extends GridPane {
	
	static GridPane sudokuBoard;
	
	public Playfield() {
		sudokuBoard = new GridPane();
		createBoard();
		
	}

	
	public static void createBoard() {
	sudokuBoard = new GridPane();
	sudokuBoard.setPadding(new Insets(10,10,10,10));
	sudokuBoard.setVgap(10);
	sudokuBoard.setHgap(8);

	for (int blockColumn = 0; blockColumn < 3 ; blockColumn++) {
        for (int blockRow = 0; blockRow < 3; blockRow++) {

            GridPane box = new GridPane();
            box.setStyle("-fx-background-color: black, -fx-control-inner-background; -fx-background-insets: 0, 2; -fx-padding: 3;");
            for (int column = 0; column < 3; column++) {
                for (int row = 0 ; row < 3; row++) {
                    TextField textField = new TextField("0");
                    textField.setStyle("-fx-pref-width: 2em;");
                    box.getChildren().add(textField);
                    GridPane.setConstraints(textField, column, row);

                }
            }


        GridPane.setConstraints(box, blockColumn, blockRow);
       sudokuBoard.setAlignment(Pos.CENTER);
        sudokuBoard.getChildren().add(box);
        }
    }

	
	
	
}
	
	
	public GridPane getGridPane() {
		return sudokuBoard;
	}

}