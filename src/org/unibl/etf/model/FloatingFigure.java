package org.unibl.etf.model;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import org.unibl.etf.enums.Color;

public class FloatingFigure extends Figure {
    //protected Color color;
    //protected static int movementPoints;
    //protected static boolean canPassObstacle;
    //protected static ImageView icon;

    public FloatingFigure() {
        super();
        canPassObstacle=true;

    }

    public  FloatingFigure(Color color){
        super(color);
        String colorNameLowerCase = color.toString().toLowerCase();
        String imageURL= imageFolderURL + "/" + colorNameLowerCase + "Float.png";
        //String imageURL = "/org/unibl/etf/images/figures/redFloat.png";
        Image t = new Image(imageURL);
        icon = new ImageView(t);
    }

    @Override
    public void move() {

    }

    @Override
    public String toString() {
        return "FF";
    }
}
