package gr.uop;

import javafx.application.Application;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.geometry.VPos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.Separator;
import javafx.scene.control.TextField;
import javafx.scene.control.TitledPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;


/**
 * JavaFX App
 */
public class App extends Application {

    @Override
    public void start(Stage stage) {
        VBox mainPane = new VBox();
        mainPane.setPadding(new Insets(10, 2, 2, 2));

        HBox centerPane = new HBox(30);
        centerPane.setAlignment(Pos.TOP_CENTER);

        TitledPane settingsPane = new TitledPane();
        settingsPane.setText("Grid Settings");
        settingsPane.setCollapsible(false);

        VBox settingsInnerPane = new VBox(10);
        settingsInnerPane.getChildren().add(new CheckBox("Snap to Grid"));
        settingsInnerPane.getChildren().add(new CheckBox("Show Grid"));
        
        settingsPane.setContent(settingsInnerPane);

        TitledPane dimensionsPane = new TitledPane();
        dimensionsPane.setText("Grid Dimensions");
        dimensionsPane.setCollapsible(false);

        Label horLabel = new Label("Horizontal:");
        Label verLabel = new Label("Vertical:");
        TextField horTextField = new TextField();
        horTextField.setPrefColumnCount(5);
        TextField verTextField = new TextField();
        verTextField.setPrefColumnCount(5);

        GridPane dimensionsInnerPane = new GridPane();
        dimensionsInnerPane.setHgap(5);
        dimensionsInnerPane.setVgap(10);
        dimensionsInnerPane.add(horLabel, 0, 0);
        dimensionsInnerPane.add(verLabel, 0, 1);
        dimensionsInnerPane.add(horTextField, 1, 0);
        dimensionsInnerPane.add(verTextField, 1, 1);
        GridPane.setHalignment(horLabel, HPos.RIGHT);
        GridPane.setHalignment(verLabel, HPos.RIGHT);
        GridPane.setValignment(horLabel, VPos.CENTER);

        dimensionsPane.setContent(dimensionsInnerPane);

        VBox buttonsPane = new VBox(10);
        Button okButton = new Button("OK");
        okButton.setMaxWidth(Double.MAX_VALUE);
        Button cancelButton = new Button("Cancel");
        cancelButton.setMaxWidth(Double.MAX_VALUE);
        Button helpButton = new Button("Help");
        helpButton.setMaxWidth(Double.MAX_VALUE);
        buttonsPane.getChildren().addAll(okButton, cancelButton, helpButton);
        buttonsPane.setAlignment(Pos.TOP_CENTER);

        centerPane.getChildren().addAll(settingsPane, dimensionsPane, buttonsPane);

        VBox.setVgrow(centerPane, Priority.ALWAYS);

        Label statusLabel = new Label("Status");
        statusLabel.setMaxWidth(Double.MAX_VALUE);
        statusLabel.setPadding(new Insets(2));
        mainPane.getChildren().addAll(centerPane, new Separator(), statusLabel);

        var scene = new Scene(mainPane, 500, 180);
        stage.setScene(scene);
        stage.setTitle("Settings");
        stage.setMinHeight(180);
        stage.setMinWidth(500);
        stage.show();
        stage.setMinHeight(stage.getHeight());
        stage.setMinWidth(stage.getWidth());
    }

    public static void main(String[] args) {
        launch(args);
    }

}