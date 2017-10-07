package com.everything.java8tests.functionalprogramming.ch04.filters;

import java.awt.*;
import java.util.Arrays;
import java.util.function.Consumer;
import java.util.function.Function;

/**
 * User: Makar Kalancha
 * Date: 22/01/2016
 * Time: 21:21
 */
public class Camera {
    private Function<Color, Color> filter;

    public Camera() {
        setFilters();
    }

    public void setFilters(final Function<Color, Color>... filters) {
        filter = Arrays.asList(filters).stream()
                        .reduce((filter, next) -> filter.compose(next))
                        .orElse(color -> color);
    }

    public Color capture(final Color inputColor) {
        final Color processedColor = filter.apply(inputColor);
        return processedColor;
    }

    public static void main(String[] args) {
        final Camera camera = new Camera();
        final Consumer<String> printCaptured = (filterInfo) ->
                System.out.println(String.format("with %s: %s",
                        filterInfo, camera.capture(new Color(200, 100, 200))));
        printCaptured.accept("no filter");

        camera.setFilters(Color::brighter);
        printCaptured.accept("brighter colors");

        camera.setFilters(Color::darker);
        printCaptured.accept("darker colors");
    }
}
