package GUI;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.scene.layout.VBox;

public class AlertBox {

     public static void display(String title, String message){

         Stage window = new Stage();

         window.initModality(Modality.APPLICATION_MODAL);
         window.setTitle(title);
         window.setMinWidth(250);
         window.setMinHeight(150);

         Label label = new Label();
         label.setText(message);
         Button closeButton = new Button("OK");
         closeButton.setOnAction(e->window.close());


         VBox layout = new VBox(10);
         layout.getChildren().addAll(label, closeButton);
         layout.setAlignment(Pos.CENTER);

         Scene scene = new Scene(layout);
         window.setScene(scene);
         window.show();




     }



}
