package org.unibl.etf.controller;

import javafx.animation.Interpolator;
import javafx.animation.TranslateTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.util.Duration;


public class FigureController {

    @FXML
    private Button xB;

    @FXML
    private ImageView imageViewPawn;

    @FXML
    void xM(ActionEvent event) {
        TranslateTransition tr=new TranslateTransition(Duration.millis(100));
        tr.setNode(imageViewPawn);
        tr.setByX(50);;
        tr.setInterpolator(Interpolator.LINEAR);
        tr.play();
    }

}
