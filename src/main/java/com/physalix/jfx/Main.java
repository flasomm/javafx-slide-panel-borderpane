package com.physalix.jfx;

import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ToolBar;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

/**
 * Main class.
 * 
 * @author Fabrice Sommavilla <fs@physalix.com>
 */
public class Main extends Application {

    private static final String STYLESHEET_PATH = "/styles/styles.css";

    @Override
    public void start(Stage stage) {
        Scene scene = new Scene(new Group());
        scene.getStylesheets().add(STYLESHEET_PATH);
        stage.setTitle("BorderPane Slides In And Out on Command Sample");
        stage.setWidth(600);
        stage.setHeight(431);

        AnchorPane anchorPane = new AnchorPane();
        anchorPane.setPrefHeight(431);
        anchorPane.setPrefWidth(600);

        BorderPane borderPane = new BorderPane();
        borderPane.setPrefHeight(400.0);
        borderPane.setPrefWidth(600.0);
        AnchorPane.setBottomAnchor(borderPane, 0.0);
        AnchorPane.setLeftAnchor(borderPane, 0.0);
        AnchorPane.setRightAnchor(borderPane, 0.0);
        AnchorPane.setTopAnchor(borderPane, 31.0);

        ToolBar toolbar = new ToolBar();
        toolbar.setPrefWidth(600.0);
        AnchorPane.setTopAnchor(toolbar, 0.0);
        AnchorPane.setLeftAnchor(toolbar, 0.0);
        AnchorPane.setRightAnchor(toolbar, 0.0);

        Button buttonTop = new Button("Top");
        Label labelTop = new Label("Top");
        
        Button buttonLeft = new Button("Left");
        Label labelLeft = new Label("Left");
        
        Button buttonBottom = new Button("Bottom");
        Label labelBottom = new Label("Bottom");
        
        Button buttonRight = new Button("Right");
        Label labelRight = new Label("Right");

        
        BorderSlideBar topFlapBar = new BorderSlideBar(100, buttonTop, Pos.TOP_LEFT, labelTop);
        borderPane.setTop(topFlapBar);

        BorderSlideBar leftFlapBar = new BorderSlideBar(100, buttonLeft, Pos.BASELINE_LEFT, labelLeft);
        borderPane.setLeft(leftFlapBar);

        BorderSlideBar bottomFlapBar = new BorderSlideBar(100, buttonBottom, Pos.BOTTOM_LEFT, labelBottom);
        borderPane.setBottom(bottomFlapBar);
        
        BorderSlideBar rightFlapBar = new BorderSlideBar(100, buttonRight, Pos.BASELINE_RIGHT, labelRight);
        borderPane.setRight(rightFlapBar);
        
        toolbar.getItems().addAll(buttonTop, buttonLeft, buttonBottom, buttonRight);

        anchorPane.getChildren().addAll(borderPane, toolbar);

        ((Group) scene.getRoot()).getChildren().addAll(anchorPane);

        stage.setScene(scene);
        stage.show();
    }

    // ---------- ---------- ---------- ---------- ----------
    /**
     * The main() method is ignored in correctly deployed JavaFX application.
     * main() serves only as fallback in case the application can not be
     * launched through deployment artifacts, e.g., in IDEs with limited FX
     * support. NetBeans ignores main().
     *
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
}
