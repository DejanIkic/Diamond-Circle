package org.unibl.etf.model;

import org.unibl.etf.enums.Color;
import org.unibl.etf.exception.WrongNameException;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Player {

    private String name;
    private Color color;
    private static ArrayList<String> names = new ArrayList<String>(4);
    private ArrayList<Figure> figureList = new ArrayList<>(4);

    public Player() {
        this.name = "";
        this.color = null;
    }

    public Color getColor() {
        return color;
    }

    public Player(String name) throws WrongNameException {

        if (names.contains(name)) {
            names.clear();
            throw new WrongNameException();
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

}


