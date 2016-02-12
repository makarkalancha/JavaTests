package everything.javafx.javafx2_intro_by_exp.ch01;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.effect.DropShadow;
import javafx.scene.paint.Color;
import javafx.scene.shape.CubicCurve;
import javafx.scene.shape.CubicCurveBuilder;
import javafx.scene.shape.Ellipse;
import javafx.scene.shape.Line;
import javafx.scene.shape.LineTo;
import javafx.scene.shape.MoveTo;
import javafx.scene.shape.Path;
import javafx.scene.shape.QuadCurve;
import javafx.scene.shape.QuadCurveBuilder;
import javafx.scene.shape.QuadCurveTo;
import javafx.scene.shape.Shape;
import javafx.scene.shape.StrokeType;
import javafx.stage.Stage;

/**
 * Created by mcalancea on 2016-02-12.
 */
public class app01_05_Shapes extends Application {

    public static void main(String[] args) {
        Application.launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("Chapter 1-5 Shapes");
        Group root = new Group();
        Scene scene = new Scene(root, 300, 700, Color.WHITE);

        CubicCurve cubicCurve = CubicCurveBuilder.create()
                .startX(100).startY(125)
                .controlX1(130).controlY1(25)
                .controlX2(160).controlY2(225)
                .endX(190).endY(125)
                .strokeType(StrokeType.CENTERED).strokeWidth(1)
                .stroke(Color.BLACK)
                .strokeWidth(3)
                .fill(Color.WHITE)
                .build();
        root.getChildren().add(cubicCurve);

        Line line1 = new Line(100, 125, 130, 25);
        line1.setStroke(Color.RED);
        root.getChildren().add(line1);
        Line line2 = new Line(130, 25, 160, 225);
        line2.setStroke(Color.RED);
        root.getChildren().add(line2);
        Line line3 = new Line(160, 225, 190, 125);
        line3.setStroke(Color.RED);
        root.getChildren().add(line3);

        //ice cream
        Path path = new Path();

        MoveTo moveTo = new MoveTo();
        moveTo.setX(50);
        moveTo.setY(150);

        QuadCurveTo quadCurveTo = new QuadCurveTo();
        quadCurveTo.setX(150);
        quadCurveTo.setY(150);
        quadCurveTo.setControlX(100);
        quadCurveTo.setControlY(50);

        LineTo lineTo1 = new LineTo();
        lineTo1.setX(50);
        lineTo1.setY(150);

        LineTo lineTo2 = new LineTo();
        lineTo2.setX(100);
        lineTo2.setY(275);//275

        LineTo lineTo3 = new LineTo();
        lineTo3.setX(150);
        lineTo3.setY(150);

        path.getElements().add(moveTo);
        path.getElements().add(quadCurveTo);
        path.getElements().add(lineTo1);
        path.getElements().add(lineTo2);
        path.getElements().add(lineTo3);
        path.setTranslateY(30);
        path.setStrokeWidth(3);
        path.setStroke(Color.BLACK);

        root.getChildren().add(path);

        //smile
        QuadCurve quad = QuadCurveBuilder.create()
                .startX(50).startY(50)
                .controlX(125).controlY(150)
                .endX(150).endY(50)
                .translateY(path.getBoundsInParent().getMaxY())
                .strokeWidth(3)
                .stroke(Color.BLACK)
                .fill(Color.WHITE)
                .build();
        root.getChildren().add(quad);

        Line line4 = new Line(50, 50, 125, 150);
        line4.setTranslateY(path.getBoundsInParent().getMaxY());
        line4.setStroke(Color.RED);
        root.getChildren().add(line4);

        Line line5 = new Line(125, 150, 150, 50);
        line5.setTranslateY(path.getBoundsInParent().getMaxY());
        line5.setStroke(Color.RED);
        root.getChildren().add(line5);


        //outer donut
        Ellipse bigCircle = new Ellipse();
        bigCircle.setCenterX(100);
        bigCircle.setCenterY(100);
        bigCircle.setRadiusX(50);
        bigCircle.setRadiusY(75 / 2);
        bigCircle.setTranslateY(quad.getBoundsInParent().getMaxX());
        bigCircle.setStrokeWidth(3);
        bigCircle.setStroke(Color.BLACK);
        bigCircle.setFill(Color.WHITE);
        //donut hole
        Ellipse smallCircle = new Ellipse();
        smallCircle.setCenterX(100);
        smallCircle.setCenterY(100);
        smallCircle.setRadiusX(35 / 2);
        smallCircle.setRadiusY(25 / 2);
        smallCircle.setTranslateY(quad.getBoundsInParent().getMaxX());

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
        donut.setTranslateY(quad.getBoundsInParent().getMinY() + 1);

        root.getChildren().add(donut);

        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
