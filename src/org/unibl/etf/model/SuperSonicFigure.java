package org.unibl.etf.model;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import org.unibl.etf.enums.Color;

public class SuperSonicFigure extends Figure {
    //protected Color color;
    //protected static int movementPoints;
    //protected static boolean canPassObstacle;
    //protected static ImageView icon;

    public SuperSonicFigure() {
        super();

    }

    @Override
    protected Void call() throws Exception {
        return null;
    }

    public SuperSonicFigure(Color color) {
        super(color);
        String colorNameLowerCase = color.toString().toLowerCase();
        String imageURL = imageFolderURL + "/" + colorNameLowerCase + "Fast.png";
        Image t = new Image(imageURL);

        icon = new ImageView(t);
        //icon.resize(20, 20);
        icon.setFitWidth(29);
        icon.setFitHeight(29);
    }

    @Override
    public void move() {

    }

    @Override
    public String toString() {
        return "SSF";
    }
}
