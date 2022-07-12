package org.unibl.etf.model;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import org.unibl.etf.enums.Color;

public class OrdinaryFigure extends Figure {
    //protected Color color;
    //protected static int movementPoints;
    //protected static boolean canPassObstacle;
    //protected static ImageView icon;

    public OrdinaryFigure() {
        super();
    }

    public OrdinaryFigure(Color color) {
        super(color);
        String colorNameLowerCase = color.toString().toLowerCase();
        String imageURL = imageFolderURL + "/" + colorNameLowerCase + "Standard.png";
        Image t = new Image(imageURL);
        icon = new ImageView(t);
    }

    @Override
    public void move() {

    }

    protected void setCanPassObstacle() {

    }
    @Override
    public String toString() {
        return "SF";
    }
}
