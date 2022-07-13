package org.unibl.etf.model;

import javafx.concurrent.Task;
import javafx.scene.image.ImageView;
import org.unibl.etf.enums.Color;


public abstract class Figure extends Task<Void> {
    protected Color color;
    protected static int movementPoints;
    protected static boolean canPassObstacle;
    protected ImageView icon;
    protected static final String imageFolderURL = "/org/unibl/etf/images/figures";
    protected int totalFieldsPassed;



    protected FigureState state;
    protected long startTime;

    public Figure() {
        color=null;
        movementPoints=0;
        canPassObstacle=false;
        icon=null;
        totalFieldsPassed=0;
        startTime=0;
        state=FigureState.AT_START;
    }

    public Figure(Color color){
        this.color=color;
    }
    public abstract void move();

    public  ImageView getIcon() {
        return icon;
    }

    public FigureState getFigureState() {
        return state;
    }

    public void setFigureState(FigureState state) {
        this.state = state;
    }
    protected enum FigureState{
        ACTIVE,AT_START,FALLEN
    }
}
