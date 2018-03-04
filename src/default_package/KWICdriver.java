package default_package;

import javafx.geometry.Insets;
import javafx.geometry.Pos;

import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextArea;

import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 * KWICdriver: Main driver program to parse the file, process, sort and show the
 * output
 *
 */
import javafx.application.*;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class KWICdriver extends Application{

	/**
	 * Main program

	 */
	public static TextArea textArea;
	public static Label headerLabel;
	Button submitButton;
	Button exitButton;
	Button addNoiseWordButton;

	public static void main(String args[]) throws IOException {
		launch(args);
	}

	public void start(Stage stage) throws Exception {

		VBox vBox = new VBox();
		vBox.setPadding(new Insets(5));
		vBox.setSpacing(10);

		HBox buttonBar = new HBox();
		buttonBar.setPadding(new Insets(5));
		buttonBar.setSpacing(10);
		buttonBar.setCenterShape(true);

		textArea = new TextArea();
		textArea.setStyle("-fx-highlight-fill: lightgray; -fx-font-weight: bold; -fx-highlight-text-fill: firebrick; -fx-font-size: 14px;");

		headerLabel = new Label("Enter message:");
		headerLabel.setStyle("-fx-highlight-fill: lightgray; -fx-font-weight: bold; -fx-highlight-text-fill: firebrick; -fx-font-size: 18px;");
		//headerLabel.setAlignment(Pos.TOP_CENTER);

		submitButton = new Button("Submit");
		exitButton = new Button("Exit");
		addNoiseWordButton = new Button("Add Noise Word");
		buttonBar.setAlignment(Pos.BOTTOM_CENTER);
		buttonBar.setStyle("-fx-highlight-fill: lightgray; -fx-font-weight: bold; -fx-font-size: 18px;");


		submitButton.setOnAction(new EventHandler<ActionEvent>(){
			@Override
			public void handle(ActionEvent e)
			{
				// Initialize Input get text from gui
				Input input = new Input();
				LineStorage lineStorage = new LineStorage();
				input.getUserInput(lineStorage);

				textArea.setText("");
				// Initialize Circular Shift based on the line storage and process shift
				CircularShift circularShift = new CircularShift();
				circularShift.setup(lineStorage);

				// Initialize Alphabetizer based on the Circular Shift and sort
				Alphabetizer alphabetizer = new Alphabetizer();
				alphabetizer.alpha(circularShift);

				//Initialize Output based on the Alphabetizer and print output
				Output output = new Output(alphabetizer);
				output.print();
				
				submitButton.setVisible(false);
				
			}
		});

		buttonBar.getChildren().addAll(submitButton, exitButton, addNoiseWordButton);
		vBox.getChildren().addAll(headerLabel, textArea, buttonBar);
		Scene scene = new Scene(vBox, 1080, 920);

		textArea.setMinHeight(scene.getHeight()*.8);

		stage.setTitle("Key Word in Context");
		stage.setScene(scene);
		stage.show();
	}

	public Button getSubmitButton(){
		return submitButton;
	}

	public TextArea getTextArea(){
		return textArea;
	}

	public Label getHeaderLaber(){
		return headerLabel;
	}
}