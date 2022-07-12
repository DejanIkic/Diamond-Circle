package org.unibl.etf.main;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;


public class Main extends Application {
    private static final String HOME_PAGE_FXML = "/org/unibl/etf/fxml/homePage.fxml";
    private static final String ANIMATION_FXML = "/org/unibl/etf/fxml/animation.fxml";
    private static final String SIMULATION_FXML = "/org/unibl/etf/fxml/simulation.fxml";
    private static final String INPUT_PLAYERS_FXML = "/org/unibl/etf/fxml/inputPlayers.fxml";
    private static final String FIGURE_FXML ="/org/unibl/etf/fxml/figure.fxml";



    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource(HOME_PAGE_FXML));
        Scene scene = new Scene(root);
        stage.setScene(scene);

        stage.setTitle("DiamondCircle");
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);

    }
}
