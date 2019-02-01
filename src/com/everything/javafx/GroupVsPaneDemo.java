package com.everything.javafx;

/**
 * User: Makar Kalancha
 * Date: 09/04/2016
 * Time: 22:53
 */
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Pane;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;


//http://stackoverflow.com/questions/30901185/difference-between-pane-and-group
/*
A Group is not resizable (meaning that its size is not managed by its parent in the scene graph),
and takes on the union of the bounds of its child nodes. (So, in other words, the local bounds of a
Group will be the smallest rectangle containing the bounds of all the child nodes). If it is larger than
the space it is allocated in its parent, it will be clipped.

By contrast, a Pane is resizable, so its size is set by its parent, which essentially determine its bounds.
 */
public class GroupVsPaneDemo extends Application {

    @Override
    public void start(Stage primaryStage) {
        Pane pane = new Pane();
        Group group = new Group();

        VBox.setVgrow(group, Priority.NEVER);
        VBox.setVgrow(pane, Priority.NEVER);

        VBox vbox = new VBox(group, pane);


        Rectangle rect1 = new Rectangle(100, 100, 100, 100);
        Rectangle rect2 = new Rectangle(100, 100, 100, 100);
        Rectangle rect3 = new Rectangle(200, 200, 100, 100);
        Rectangle rect4 = new Rectangle(200, 200, 100, 100);
        rect1.setFill(Color.BLUE);
        rect2.setFill(Color.BLUE);
        rect3.setFill(Color.GREEN);
        rect4.setFill(Color.GREEN);

        group.getChildren().addAll(rect1, rect3);
        pane.getChildren().addAll(rect2, rect4);

        Scene scene = new Scene(vbox, 800, 800);
        scene.addEventHandler(KeyEvent.KEY_PRESSED, e -> {
            double deltaX ;
            switch(e.getCode()) {
                case LEFT:
                    deltaX = -10 ;
                    break ;
                case RIGHT:
                    deltaX = 10 ;
                    break ;
                default:
                    deltaX = 0 ;
            }
            rect3.setX(rect3.getX() + deltaX);
            rect4.setX(rect4.getX() + deltaX);
        });

        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}