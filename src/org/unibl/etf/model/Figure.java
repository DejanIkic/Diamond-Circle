package org.unibl.etf.model;

import javafx.scene.image.ImageView;
import org.unibl.etf.enums.Color;


public abstract class Figure {
    protected Color color;
    protected static int movementPoints;
    protected static boolean canPassObstacle;
    protected static ImageView icon;
    protected static final String imageFolderURL = "/org/unibl/etf/images/figures";

    public Figure() {
        color=null;
        movementPoints=0;
        canPassObstacle=false;
        icon=null;
    }

    public Figure(Color color){
        this.color=color;
    }
    public abstract void move();
}
