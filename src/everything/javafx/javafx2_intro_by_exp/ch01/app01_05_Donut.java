package everything.javafx.javafx2_intro_by_exp.ch01;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.effect.DropShadow;
import javafx.scene.paint.Color;
import javafx.scene.shape.Ellipse;
import javafx.scene.shape.Path;
import javafx.scene.shape.Shape;
import javafx.stage.Stage;

/**
 * Created by mcalancea on 2016-02-12.
 */
public class app01_05_Donut extends Application {

    public static void main(String[] args) {
        Application.launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("Chapter 1-5 Shapes");
        Group root = new Group();
        Scene scene = new Scene(root, 600, 1600, Color.WHITE);


        //outer donut
        Ellipse bigCircle = new Ellipse();
        bigCircle.setCenterX(100);
        bigCircle.setCenterY(100);
        bigCircle.setRadiusX(50);
        bigCircle.setRadiusY(75 / 2);
//        bigCircle.setTranslateY(quad.getBoundsInParent().getMaxY());
        bigCircle.setStrokeWidth(3);
        bigCircle.setStroke(Color.BLACK);
        bigCircle.setFill(Color.WHITE);
//        bigCircle.build();
        //donut hole
//        Ellipse smallCircle = EllipseBuilder.create()
//                .centerX(100).centerY(100)
//                .radiusX(35 / 2).radiusY(25 / 2)
//                .build();
        Ellipse smallCircle = new Ellipse();
        smallCircle.setCenterX(100);
        smallCircle.setCenterY(100);
        smallCircle.setRadiusX(35 / 2);
        smallCircle.setRadiusY(25 / 2);

        //make a donut
        Shape donut = Path.subtract(bigCircle, smallCircle);
        //orange glaze
        donut.setFill(Color.rgb(255, 200, 0));

        //add drop shadow
        DropShadow dropShadow = new DropShadow();
        dropShadow.setOffsetX(2.0f);
        dropShadow.setOffsetY(2.0f);
        dropShadow.setColor(Color.rgb(50, 50, 50, .588));
        donut.setEffect(dropShadow);

        //move slightly down
//        donut.setTranslateY(quad.getBoundsInParent().getMinY() + 1);

        root.getChildren().add(donut);

        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
