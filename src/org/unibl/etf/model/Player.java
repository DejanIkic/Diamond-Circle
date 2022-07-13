package org.unibl.etf.model;

import org.unibl.etf.controller.InputPlayersController;
import org.unibl.etf.enums.Color;
import org.unibl.etf.exception.WrongNameException;
import org.unibl.etf.service.Simulation;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Player {

    private String name;
    private final Color color;
    private static final ArrayList<String> names = new ArrayList<String>(4);
    private static final ArrayList<Integer> orderOfPlay= new ArrayList<>(4);
    private final ArrayList<Figure> figureList = new ArrayList<>(4);
    private int ordinalNumber; //redni broj igraca u simulaciji

    public Player() {
        this.name = "";
        this.color = null;
        ordinalNumber=0;
    }

    public Color getColor() {
        return color;
    }

    public Player(String name) throws WrongNameException {

        if (names.contains(name)) {
            names.clear();
            orderOfPlay.clear();
            Color.clearLock();
            throw new WrongNameException();
        }
        while(true) {
            int x = (int) (Math.random() * InputPlayersController.getNumberOfPlayers());
            if(!orderOfPlay.contains(x)) {
                this.ordinalNumber = x;
                orderOfPlay.add(x);
                break;
            }
        }
        names.add(name);
        this.name = name;

        Color color = null;
        int i;
        while (true) {
            color = Color.values()[i = ((int) (Math.random() * 4))];
            if (!color.getLock()) {
                this.color = Color.values()[i];
                Color.valueOf(color.name()).setLock();
                break;
            }
        }

        for (int j = 0; j < 4; j++) {
            this.figureList.add(randomFigure());
        }


    }



   /* public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int brojIgraca = 2;
        ArrayList<Player> players = new ArrayList<>();
        for (int i = 0; i < 4; i++) {

            try {
                System.out.print("Unesite ime " + (i + 1) + ". igraca: ");
                Player player = new Player(sc.next());
                player.figureList.add(player.randomFigure());
                player.figureList.add(player.randomFigure());
                player.figureList.add(player.randomFigure());
                player.figureList.add(player.randomFigure());
                players.add(player);
            } catch (WrongNameException e) {
                System.out.println(e.getLocalizedMessage());
                i--;
            }
        }
        for (int i = 0; i < 4; i++) {
            System.out.println(players.get(i).name + players.get(i).color + "Figure: "+ players.get(i).figureList);
            System.out.println();
        }
    }*/

    private Figure randomFigure(){
        int i =(int) (Math.random()*3);
        return switch (i) {
            case 0 -> new FloatingFigure(this.color);
            case 1 -> new SuperSonicFigure(this.color);
            case 2 -> new OrdinaryFigure(this.color);
            default -> null;
        };
    }

    public int getOrdinalNumber() {
        return ordinalNumber;
    }
    public ArrayList<Figure> getFigureList() {
        return figureList;
    }
    public void setOrdinalNumber(int ordinalNumber) {
        this.ordinalNumber = ordinalNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Color getBoja() {
        return color;
    }

    public static ArrayList<String> getNames() {
        return names;
    }
}


