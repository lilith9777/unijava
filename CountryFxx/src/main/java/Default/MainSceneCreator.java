package Default;

import java.awt.event.ActionEvent;

import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;




public class MainSceneCreator extends SceneCreator implements EventHandler<MouseEvent>{
	
	
	//Scenes
	//flow pane
	FlowPane rootFlowpane;
	//Buttons
	Button Currency, Name , Language, All;
	
	/**
	 * @param width
	 * @param height
	 */
	public   MainSceneCreator(double width,double height) {
		super(width,height);
		 rootFlowpane=new FlowPane();
	        Currency= new Button("Section 1");
	        Name= new Button("Section 2");
	        Language=new Button("Countries");
	        All= new Button("Section 3");
	        
	        //Set flow pane
	        rootFlowpane.setHgap(10);
	        rootFlowpane.setAlignment(Pos.CENTER);
	        Currency.setMinSize(120, 30);
	        Name.setMinSize(120, 30);
	        Language.setMinSize(120,30);
	        All.setMinSize(120,30);
	        rootFlowpane.getChildren().add(Currency);
	        rootFlowpane.getChildren().add(Name);
	        rootFlowpane.getChildren().add(Language);
	        rootFlowpane.getChildren().add(All);
	        //attachment of the button
	        Name.setOnMouseClicked(this);
	        Language.setOnMouseClicked(this);

		
		

		
	}
	@Override
	Scene createScene() {
		return new Scene(rootFlowpane,width,height); 
		
	}
//	public void handle(MouseEvent event) {
//		if(event.getSource()==Name) { 
//			Main.primaryStage.setTitle("Search A Movie");
//			Main.primaryStage.setScene(Main.mainScene);
//	}
//		if(event.getSource()==Language) { 
//			Main.primaryStage.setTitle("Search A Movie");
//			Main.primaryStage.setScene(Main.CountryScene);
//	}

//}
	public void handle(MouseEvent event) {
        if (event.getSource() == Name) {
            // Switch to the appropriate scene
            Main.primaryStage.setTitle("Search by Name");
            Main.primaryStage.setScene(Main.CountryScene);
        
        } else if (event.getSource() == Language) {
            Main.primaryStage.setTitle("Search by Language");
            Main.primaryStage.setScene(Main.CountryScene);


            // Handle action for 'All' button if needed
        }

	}}

