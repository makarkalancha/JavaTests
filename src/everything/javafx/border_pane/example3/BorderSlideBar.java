package everything.javafx.border_pane.example3;

import javafx.animation.Animation;
import javafx.animation.Transition;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.util.Duration;

/**
 * User: Makar Kalancha
 * Date: 24/09/2017
 * Time: 01:33
 */


/**
 * Animates a node on and off screen to the top, right, bottom or left side.
 */
public class BorderSlideBar extends Pane{
    private final String CSS = "/" + this.getClass().getSimpleName() + ".css";
    private double expandedSize;
    private Position flapbarLocation;
    private Pane node;

    /**
     * Creates a sidebar panel in a BorderPane, containing an horizontal alignment
     * of the given nodes.
     *
     * <pre>
     * <code>
     *  Example:
     *
     *  BorderSlideBar topFlapBar = new BorderSlideBar(
     *                  100, button, Pos.TOP_LEFT, new contentController());
     *  mainBorderPane.setTop(topFlapBar);
     * </code>
     * </pre>
     *
     * @param expandedSize The size of the panel.
     * @param controlButton The button responsible to open/close slide bar.
     * @param location The location of the panel (TOP_LEFT, BOTTOM_LEFT, BASELINE_RIGHT, BASELINE_LEFT).
     * @param node Nodes inside the panel.
     */
    public BorderSlideBar(Color color, double expandedSize, /**/Position location, Pane node) {

        this.node = node;
        setBackground(new Background(new BackgroundFill(color, CornerRadii.EMPTY, Insets.EMPTY)));
        node.getStyleClass().add("sidebar");
        node.getStylesheets().add(CSS);
//        setExpandedSize(expandedSize);
        setExpandedSize(node.getWidth());
        node.setVisible(false);

        // Set location
        if (location == null) {
            flapbarLocation = Position.TOP; // Set default location
        }
        flapbarLocation = location;

        initPosition();

        // Add nodes in the vbox
        getChildren().addAll(node);
    }

    /**
     * Initialize position orientation.
     */
    private void initPosition() {
        switch (flapbarLocation) {
            case TOP:
                node.setPrefHeight(0);
                node.setMinHeight(0);
                break;
            case BOTTOM:
                node.setPrefHeight(0);
                node.setMinHeight(0);
                break;
            case RIGHT:
                node.setPrefWidth(0);
                node.setMinWidth(0);
                break;
            case LEFT:
                node.setPrefWidth(0);
                node.setMinWidth(0);
                break;
        }
    }

    /**
     * Translate the VBox according to location Pos.
     *
     * @param size
     */
    private void translateByPos(double size) {
        switch (flapbarLocation) {
            case TOP:
                node.setPrefHeight(size);
                node.setTranslateY(-getExpandedSize() + size);
                break;
            case BOTTOM:
                node.setPrefHeight(size);
                break;
            case RIGHT:
                node.setPrefWidth(size);
                break;
            case LEFT:
                node.setPrefWidth(size);
                break;
        }
    }

    /**
     * @return the expandedSize
     */
    public double getExpandedSize() {
        return expandedSize;
    }

    /**
     * @param expandedSize the expandedSize to set
     */
//    public void setExpandedSize(double expandedSize) {
    private void setExpandedSize(double expandedSize) {
        this.expandedSize = expandedSize;
    }

    public void handle(ActionEvent actionEvent) {
        // Create an animation to hide the panel.
        final Animation hidePanel = new Transition() {
            {
                setCycleDuration(Duration.millis(250));
            }

            @Override
            protected void interpolate(double frac) {
                final double size = getExpandedSize() * (1.0 - frac);
                translateByPos(size);
            }
        };

        hidePanel.onFinishedProperty().set(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                node.setVisible(false);
            }
        });

        // Create an animation to show the panel.
        final Animation showPanel = new Transition() {
            {
                setCycleDuration(Duration.millis(250));
            }

            @Override
            protected void interpolate(double frac) {
                final double size = getExpandedSize() * frac;
                translateByPos(size);
            }
        };

        showPanel.onFinishedProperty().set(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
            }
        });

        if (showPanel.statusProperty().get() == Animation.Status.STOPPED
                && hidePanel.statusProperty().get() == Animation.Status.STOPPED) {

            if (node.isVisible()) {
                hidePanel.play();

            } else {
                node.setVisible(true);
                showPanel.play();
            }
        }
    }

}