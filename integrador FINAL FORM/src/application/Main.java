package application;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;



public class Main extends Application {
	
	private static BorderPane root = new BorderPane();

	public static BorderPane getRoot() {
		return root;
	}
	
	public static void main(String[] args) {
		launch(args);
	}
	@Override
	public void start(Stage stage) throws Exception {
		stage.setTitle("The World");
		root = FXMLLoader.load(getClass().getResource("/view/Principal.fxml"));
		Scene scene = new Scene(root, 900, 600);
		stage.setScene(scene);
		stage.show();
	}
}