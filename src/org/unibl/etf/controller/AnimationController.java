package org.unibl.etf.controller;

import javafx.animation.*;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Point3D;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.transform.Rotate;
import javafx.util.Duration;

import java.net.MalformedURLException;
import java.net.URL;


public class AnimationController {

    private ImageView FRONT = new ImageView(new Image("/org/unibl/etf/images/frontSide.png"));
    private ImageView BACK = new ImageView(new Image("/org/unibl/etf/images/backSide.png"));
    private static final String FRONT_URL = "/org/unibl/etf/images/frontSide.png";
    private static final String BACK_URL = "/org/unibl/etf/images/backSide.png";
    @FXML
    private ImageView imageView;



    @FXML
    private ImageView imageView2;



    @FXML
    public void rotateImage(ActionEvent event) throws InterruptedException, MalformedURLException {


        SequentialTransition st = new SequentialTransition();
        RotateTransition firstR = new RotateTransition();

        firstR.setInterpolator(Interpolator.LINEAR);
        firstR.setDuration(Duration.millis(500));
        firstR.setAxis(Rotate.X_AXIS);
        imageView.setImage(new Image(FRONT_URL));
        firstR.setNode(imageView);
        firstR.setFromAngle(0);
        firstR.setToAngle(90);

        RotateTransition secondR = new RotateTransition();
        imageView2.setImage(new Image(BACK_URL));
        secondR.setNode(imageView2);
        secondR.setDuration(Duration.millis(1000));
        secondR.setFromAngle(90);
        secondR.setToAngle(270);
        secondR.setAxis(Rotate.X_AXIS);

        RotateTransition thirdR = new RotateTransition();
        thirdR.setInterpolator(Interpolator.LINEAR);
        thirdR.setDuration(Duration.millis(500));
        thirdR.setAxis(Rotate.X_AXIS);
        imageView.setImage(new Image(FRONT_URL));
        thirdR.setNode(imageView);
        thirdR.setFromAngle(-90);
        thirdR.setToAngle(0);

        st.getChildren().addAll(firstR, secondR,thirdR);
        st.play();

    }

    //    private void rotateImage(Node node, int degree, Point3D axis, Duration delay){
//        ScaleTransition rotate = new ScaleTransition();
//        rotate.setNode(node);
//
//        //rotate.setInterpolator(Interpolator.LINEAR);
//        rotate.setDuration(Duration.millis(1500));
//        rotate.setByX(0);
//
//        rotate.play();
//    }


    @FXML
    void rotateImageNina1(ActionEvent event) throws InterruptedException {
        RotateTransition firstR = new RotateTransition();
        firstR.setInterpolator(Interpolator.LINEAR);
        firstR.setDuration(Duration.millis(1000));
        firstR.setAxis(Rotate.X_AXIS);
        imageView.setImage(new Image(FRONT_URL));
        firstR.setNode(imageView);
        firstR.setFromAngle(0);
        firstR.setToAngle(-90);
        firstR.play();
    }
     @FXML
    void rotateImageNina2(ActionEvent event) {

    }

}
