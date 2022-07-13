package org.unibl.etf.controller;


import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import org.unibl.etf.enums.Dimension;
import org.unibl.etf.service.Simulation;

import java.net.URL;
import java.util.ResourceBundle;

import static org.unibl.etf.service.Simulation.homePageController;

public class SimulationController implements Initializable {

    private static int numberOfPlayers;
    private static Dimension gameDimensions;
    private long startTime;


    @FXML
    private Button stopResumeButton;

    @FXML
    private ImageView cardImageView;

    @FXML
    private VBox gameFilesList;

    @FXML
    private HBox listOfPlayers;

    @FXML
    private GridPane mapGridPane;


    @FXML
    private VBox figuresVBox;

    @FXML
    private Label cardValueDescription;

    @FXML
    private Label currentNOPlayedGames;

    @FXML
    private Label timeSinceStartOfGame;

    //    <Label text="Igrac 1">
//               <font>
//                  <Font name="Baskerville Old Face" size="24.0" />
//               </font>
//            </Label>
    private void addPlayersToList() {

    }
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        Simulation.setController(this);
        numberOfPlayers = homePageController.getNumberOfPlayers();
        gameDimensions = homePageController.getDimensionChoiceBox();

        //Simulation.initCard();
        //Simulation.initCardDescription();
        Simulation.initPlayerList();
        Simulation.initPlayersFigures();
        //Simulation.initMap();
        //Simulation.initPauseContinueButton();

    }



    /*_________________________________________________GETERS____________________________________________________*/
    public static int getNumberOfPlayers() {
        return numberOfPlayers;
    }

    public static Dimension getGameDimensions() {
        return gameDimensions;
    }

    public long getStartTime() {
        return startTime;
    }

    public Button getStopResumeButton() {
        return stopResumeButton;
    }

    public ImageView getCardImageView() {
        return cardImageView;
    }

    public VBox getGameFilesList() {
        return gameFilesList;
    }

    public GridPane getMapGridPane() {
        return mapGridPane;
    }

    public VBox getFiguresVBox() {
        return figuresVBox;
    }

    public Label getCardValueDescription() {
        return cardValueDescription;
    }

    public Label getCurrentNOPlayedGames() {
        return currentNOPlayedGames;
    }

    public Label getTimeSinceStartOfGame() {
        return timeSinceStartOfGame;
    }
    public HBox getListOfPlayers() {
        return listOfPlayers;
    }
    /* ___________________________________________________________________________________________________________*/
    /* ___________________________________________________________________________________________________________*/
    /* _________________________________________________SETERS_____________________________________________________*/

    public void setStartTime(long startTime) {
        this.startTime = startTime;
    }

    public void setStopResumeButton(Button stopResumeButton) {
        this.stopResumeButton = stopResumeButton;
    }

    public void setCardImageView(ImageView cardImageView) {
        this.cardImageView = cardImageView;
    }

    public void setGameFilesList(VBox gameFilesList) {
        this.gameFilesList = gameFilesList;
    }

    public void setListOfPlayers(HBox listOfPlayers) {
        this.listOfPlayers = listOfPlayers;
    }

    public void setMapGridPane(GridPane mapGridPane) {
        this.mapGridPane = mapGridPane;
    }

    public void setFiguresVBox(VBox figuresVBox) {
        this.figuresVBox = figuresVBox;
    }

    public void setCardValueDescription(Label cardValueDescription) {
        this.cardValueDescription = cardValueDescription;
    }

    public void setCurrentNOPlayedGames(Label currentNOPlayedGames) {
        this.currentNOPlayedGames = currentNOPlayedGames;
    }

    public void setTimeSinceStartOfGame(Label timeSinceStartOfGame) {
        this.timeSinceStartOfGame = timeSinceStartOfGame;
    }

    public void setNumberOfPlayers(int numberOfPlayers) {
        SimulationController.numberOfPlayers = numberOfPlayers;
    }

    public void setGameDimensions(Dimension gameDimensions) {
        SimulationController.gameDimensions = gameDimensions;
    }




    /* _________________________________________________SETERS____________________________________________________*/


}
