package org.unibl.etf.service;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import org.unibl.etf.controller.HomePageController;
import org.unibl.etf.controller.InputPlayersController;
import org.unibl.etf.controller.SimulationController;
import org.unibl.etf.enums.Dimension;
import org.unibl.etf.model.Player;

import java.util.ArrayList;

public class Simulation {


    public static SimulationController controller;
    public static HomePageController homePageController;
    public static InputPlayersController inputPlayersController;
    public static final String PLAYED_GAMES_FOLDER_URL = "/org/unibl/etf/playedgames";
    private static Dimension dimensionsOfGame;
    private static ArrayList<Player> playersList = new ArrayList<>();
    private static int numberOfFieldsToPass;
    public static final String TITLE = "DiamondCircle";
    public static boolean stop;

    public static void initCardDescription() {
    }

    public static void ininCard() {

    }

    public static void initPlayerList() {
        HBox temp = controller.getListOfPlayers();
        temp.getChildren().clear();
        for (Player value : playersList) {
            Label player = new Label();
            player.setText(value.getName());
            player.setFont(new Font("Baskerville Old Face", 24));
            player.setTextFill(Color.web((value.getColor().getRGBValue())));
            temp.getChildren().add(player);
        }
        controller.setListOfPlayers(temp);
    }

    public static void initPlayersFigures() {

    }

    public static void initPauseContinueButton() {

    }

    public static void initMap() {

    }


    public void initializeMap() {

    }

    class FigureButton extends Button {
        //private String playerNumber;

        private String figureNumber;
        private Player player;

        public FigureButton() {
            super();
            //playerNumber="";
            figureNumber = "";
            //prefHeight()

        }

        public FigureButton(Player player) {

        }


    }


    private void addVBoxFields(int dimensions) {

    }

    public static void addPlayer(Player p) {
        playersList.add(p);
    }

    public static void clearPlayerList() {
        playersList.clear();
    }

    public static void setController(SimulationController controller) {
        Simulation.controller = controller;
    }

     public static void setInputPlayersController(InputPlayersController inputPlayersController) {
         Simulation.inputPlayersController = inputPlayersController;
     }

    public static void setHomePageController(HomePageController homePageController) {
        Simulation.homePageController = homePageController;
    }
}
