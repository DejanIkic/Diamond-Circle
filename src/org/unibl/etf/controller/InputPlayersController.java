package org.unibl.etf.controller;

import javafx.collections.ObservableArray;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;
import org.unibl.etf.enums.Dimension;
import org.unibl.etf.exception.WrongNameException;
import org.unibl.etf.model.Player;
import org.unibl.etf.service.Simulation;


import java.io.IOException;
import java.util.ArrayList;

public class InputPlayersController {

    private static final HomePageController homePageController = Simulation.homePageController;
    private static final SimulationController controller = Simulation.controller;
    private static final String SIMULATION_FXML = "/org/unibl/etf/fxml/simulation.fxml";
    private static Dimension gameDimensions;
    private static int numberOfPlayers;
    private static ArrayList<String> names = new ArrayList<>();


    @FXML
    private Button startButton;

    @FXML
    private VBox vBoxList;


    @FXML
    void showSimulation(ActionEvent event) {
        int nOP = homePageController.getNumberOfPlayers();
        Simulation.clearPlayerList();
        int i;
            for ( i = 0; i < nOP; i++) {
                HBox temp = (HBox) vBoxList.getChildren().get(i);
                ObservableList<Node> x = temp.getChildren();
                //Label l = (Label) x.get(0);
                TextField tf = (TextField) x.get(1);
                try {
                    Simulation.addPlayer(new Player(tf.getText()));

                } catch (WrongNameException e) {
                    //System.out.println("Imena moraju biti jedinstvena, unesite imena ponovo!");
                    Alert warningAlert = new Alert(Alert.AlertType.WARNING);
                    warningAlert.setTitle("Pogresno ime!");
                    warningAlert.setContentText("Imena moraju biti jedinstvena, unesite imena ponovo!");
                    warningAlert.show();
                    Simulation.clearPlayerList();
                    return;
                }
            }


        try {
            ((Node) event.getSource()).getScene().getWindow().hide();
            Parent root = FXMLLoader.load(getClass().getResource(SIMULATION_FXML));
            Stage s = new Stage();
            Scene myScene = new Scene(root);
            s.setResizable(false);
            s.setScene(myScene);
            s.initOwner(startButton.getScene().getWindow());
            s.initModality(Modality.APPLICATION_MODAL);
            s.setTitle(Simulation.TITLE);
            s.show();

        } catch (IOException e) {
            System.out.println("OVDJE");
        }

    }

    @FXML
    private void initialize() {
        Simulation.setInputPlayersController(this);
        int NOPlayers = homePageController.getNumberOfPlayers();
        vBoxList.getChildren().clear();
        HBox[] hBoxArray = new HBox[NOPlayers];

        for (int i = 0; i < NOPlayers; i++) {
            hBoxArray[i] = new HBox();
            hBoxArray[i].setPadding(new Insets(5));
            hBoxArray[i].setAlignment(Pos.CENTER);
            Label l = new Label("Igrac " + (i + 1));
            TextField tf = new TextField();
            tf.setPromptText("Ime " + (i + 1) + ". igraca");
            hBoxArray[i].getChildren().addAll(l);
            hBoxArray[i].getChildren().add(tf);
        }

        for (int i = 0; i < NOPlayers; i++) {
            vBoxList.getChildren().add(hBoxArray[i]);
        }
        vBoxList.getChildren().add(startButton);

    }

    /**
     * ________________________GETERS___________________________
     */
    public static Dimension getGameDimensions() {
        return gameDimensions;
    }

    public static int getNumberOfPlayers() {
        return numberOfPlayers;
    }
    /** ________________________GETERS___________________________*/
    /** _________________________________________________________*/
    /**
     * ________________________SETERS___________________________
     */

    public void setGameDimensions(Dimension gameDimensions) {
        InputPlayersController.gameDimensions = gameDimensions;
    }

    public static void setNumberOfPlayers(int numberOfPlayers) {
        InputPlayersController.numberOfPlayers = numberOfPlayers;
    }


    /** ________________________SETERS___________________________*/


    /*@FXML
    private void start(Stage stage){
        vBoxList.getChildren().clear();
        HBox hBoxArray[] = new HBox[numberOfPlayers];
        for (int i = 0; i < numberOfPlayers; i++) {
            hBoxArray[i]=new HBox(20);
            HBox temp = hBoxArray[i];
            temp.setAlignment(Pos.CENTER);
            Label l = new Label("Igrac" +(i+1));
            TextField tf= new TextField("TF");
            temp.getChildren().addAll(l,tf);
        }
        for (int i = 0; i < numberOfPlayers; i++) {
            vBoxList.getChildren().add(hBoxArray[i]);
        }
    }*/
}
