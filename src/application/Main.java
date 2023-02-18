package application;

import java.util.Locale;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;


public class Main extends Application {
	public static Scene mainScene;

	@Override
	public void start(Stage primaryStage) {
		try {

			FXMLLoader loader = new FXMLLoader(getClass().getResource("/telas/MainView.fxml"));
			Parent root = loader.load();
			mainScene = new Scene(root);
			primaryStage.setScene(mainScene);
			primaryStage.setTitle("LEMALOB: Projeto Gente Jovem");
			
			primaryStage.show();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		Locale.setDefault(new Locale("pt", "BR"));
		launch(args);
	}
}
