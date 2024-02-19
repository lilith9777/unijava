package Default;


import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
//javafxapp
public class Main extends Application {
static Stage primaryStage;
//Scenes
static Scene mainScene, CountryScene;

	
    public static void main(String[] args) {
        launch(args);
        
    }
 
    @Override
    public void start(Stage primaryStage) {
        this.primaryStage=primaryStage;
SceneCreator mainSceneCreator= new MainSceneCreator(950,400);
   mainScene=mainSceneCreator.createScene();
   
   SceneCreator CountrySceneCreator= new CountrySceneCreator(950,400);
CountryScene=CountrySceneCreator.createScene();

        primaryStage.setTitle("Countries Webapp");
        primaryStage.setScene(mainScene);
        primaryStage.show();
    }

	}
 

