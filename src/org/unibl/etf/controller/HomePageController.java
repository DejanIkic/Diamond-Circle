package org.unibl.etf.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import org.unibl.etf.enums.Dimension;
import org.unibl.etf.service.Simulation;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class HomePageController implements Initializable {

    private static final String SIMULATION_FXML = "/org/unibl/etf/fxml/simulation.fxml";
    private static final String INPUT_PLAYERS_FXML = "/org/unibl/etf/fxml/inputPlayers.fxml";
    private static final String TITLE = "DiamondCircle";
    private Stage s;

    @FXML
    private ChoiceBox<Integer> numberOfPlayers;

    @FXML
    private Button startButton;

    @FXML
    private ChoiceBox<String> dimensionChoiceBox;

    @FXML
    void onMouseClicked(ActionEvent event) {
        //if (KeyCode.ENTER == event.getCode()) {
        showSimulation(event);

    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        dimensionChoiceBox.getItems().addAll(Dimension.SEVEN.stringValue, Dimension.EIGHT.stringValue, Dimension.NINE.stringValue, Dimension.TEN.stringValue);
        dimensionChoiceBox.setValue(Dimension.SEVEN.stringValue);
        numberOfPlayers.getItems().addAll(2,3,4);
        numberOfPlayers.setValue(2);

        Simulation.setHomePageController(this);
    }


    @FXML
    private void showSimulation(ActionEvent event) {

        FXMLLoader loader = new FXMLLoader(getClass().getResource(INPUT_PLAYERS_FXML));
        try {
            Parent root = (Parent) loader.load();

            InputPlayersController inputPlayersController = loader.getController();
            //Simulation.setInputPlayersController(inputPlayersController);
            InputPlayersController.setNumberOfPlayers(numberOfPlayers.getValue());
            inputPlayersController.setGameDimensions(Dimension.getDimensionByString(dimensionChoiceBox.getValue()));

            s = (Stage) ((Node) event.getSource()).getScene().getWindow();
            Scene scene = new Scene(root);
            s.setScene(scene);
            s.show();
        } catch (IOException e) {
            System.out.println("OVDJE H");
        }
    }
    public  Integer getNumberOfPlayers(){
        return numberOfPlayers.getValue();
    }

    public  Dimension getDimensionChoiceBox() {
        return Dimension.getDimensionByString(dimensionChoiceBox.getValue());
    }


}
