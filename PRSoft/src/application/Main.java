package application;
	
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.RadioMenuItem;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.Region;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;


public class Main extends Application  {
	
	Stage window;
	Button sudoku;
	Button samurai;
	Button freeform;
	
	Scene sudokuScene;
	Scene samuraiScene;
	Scene freeformScene;
	
	
	
	public static void main(String[] args) {
		launch(args);
	}
	
	
	@Override
	public void start(Stage primaryStage) {
		BorderPane pane = new BorderPane();
		
		
		
		window = primaryStage;
		window.setTitle("Sudoku");
		
		 //knöpfe erste seite
	    HBox buttonMenu = new HBox();
	    sudoku = new Button("Sudoku");
		sudoku.setOnAction(e -> window.setScene(sudokuScene));
		samurai = new Button("Samurai");
		freeform = new Button("Freeform");
		buttonMenu.setSpacing(210);
		buttonMenu.getChildren().addAll(sudoku,samurai,freeform);
		
		
		Label welcomeLabel = new Label("Welcome to our Sudoku Game, please choose a gamemode");
		welcomeLabel.setFont(new Font("Arial",20));
		
		
	
		BorderPane borderPane = new BorderPane();
		borderPane.setBottom(buttonMenu);
		borderPane.setCenter(welcomeLabel);
		
		
	
		Scene mainScene = new Scene(borderPane,600,600);
		window.setScene(mainScene);
		window.show();
		
		
		//sudoku normal seite
		//spielfeld
		Playfield sudokuBoard = new Playfield();
		pane.setCenter(sudokuBoard.getGridPane());
		
		
		
		
		
	    sudokuScene = new Scene(pane,500,500);
		
	    
	    	//menü stuff
	  		//menüleiste
	  		Menu helpMenu = new Menu("Help");
	  		//menü items
	  		helpMenu.getItems().add(new MenuItem("Rules"));
	  		//menubar
	  		MenuBar menuBar = new MenuBar();
	  		menuBar.getMenus().addAll(helpMenu);
	  		pane.setTop(menuBar);
	  		
	  		
	  	Menu saveMenu = new Menu("Savegame"); 
	  	MenuItem save = new MenuItem("Save");
	  	MenuItem load = new MenuItem("Load");
	  	saveMenu.getItems().addAll(save,load);
	  	menuBar.getMenus().add(saveMenu);
	    
	    
	  	//Difficulty Menüeintrag	
	    Menu difficultyMenu = new Menu("Difficulty");
	    ToggleGroup difficultyToggle = new ToggleGroup();
	    RadioMenuItem easy = new RadioMenuItem("Easy");
	    RadioMenuItem medium = new RadioMenuItem("Medium");
	    RadioMenuItem hard = new RadioMenuItem("Hard");
	    
	    easy.setToggleGroup(difficultyToggle);
	    medium.setToggleGroup(difficultyToggle);
	    hard.setToggleGroup(difficultyToggle);
	    difficultyMenu.getItems().addAll(easy, medium, hard);
	    menuBar.getMenus().add(difficultyMenu);
	    
	    //Buttons
	    VBox leftMenu = new VBox();
	    Button hint = new Button("Hint");
	    Button check = new Button("Check");
	    Button autosolve = new Button("Autosolve");
	    Button create = new Button("Create Game");
	    leftMenu.getChildren().addAll(hint,check,autosolve,create);
	    leftMenu.setAlignment(Pos.CENTER_LEFT);
	    pane.setLeft(leftMenu);
	    
	    
	    //Hauptmenü Button
	    VBox backMenu = new VBox();
	    Button back = new Button("main menu");
	    back.setOnAction(e -> window.setScene(mainScene));
	    backMenu.getChildren().add(back);
	    backMenu.setAlignment(Pos.BOTTOM_RIGHT);
	    pane.setRight(backMenu);
	    
	    //richtiges schließen des Programms
	    
	    window.setOnCloseRequest(e-> {
			//consume heißt wir führen den schließvorgang fort und es wird nicht immer geschlossen nur wenn yes gedrückt wird
			e.consume();
			closeProgram();
		});
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	}
	    
	    
	    
	    
	    private void closeProgram() {
			Boolean answer = ConfirmBox.display("Closing","Are you sure that you want to close the program?");
			if(answer == true) {
			window.close();
			}
		}    
	    
	    
	    
	    
	    
	    
	    
	   
	}
	
	
	

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

