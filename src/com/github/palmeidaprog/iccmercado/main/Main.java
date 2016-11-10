/* TI - Mercado de Trabalho
Paulo Roberto Almeida Filho
pauloalmeidaf@gmail.com
*/

package com.github.palmeidaprog.iccmercado.main;

import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.image.Image;
import java.io.InputStream;

public class Main extends Application {
    public static Stage primaryStage;

    @Override
    public void start(Stage pStage) throws Exception{
        primaryStage = pStage;
        FXMLLoader loader = new FXMLLoader(getClass().getResource("sample.fxml"));
        //Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        loader.setController(Controller.getInstance());
        Controllers.getInstance().setController(Controller.getInstance());
        Parent root = loader.load();
        primaryStage.setTitle("TI - Mercado de Trabalho");
        try {
            InputStream f = getClass().getResourceAsStream("favicon.ico");
            primaryStage.getIcons().add(new Image(f));
        } catch(Exception e) { }
        primaryStage.setScene(new Scene(root, 800, 620));
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
