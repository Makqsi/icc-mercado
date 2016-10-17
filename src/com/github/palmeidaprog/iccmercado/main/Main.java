/* TI - Mercado de Trabalho
Prof. Ana Eliza - Turma NA15 - 14/10/2016
Aluno: Paulo Roberto Almeida Filho
pauloalmeidaf@gmail.com
9a Lista - Exercício 1
*/

package com.github.palmeidaprog.iccmercado.main;

import javafx.application.Application;
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
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        primaryStage.setTitle("TI - Mercado de Trabalho");
        try {
            InputStream f = getClass().getResourceAsStream("favicon.ico");
            primaryStage.getIcons().add(new Image(f));
        } catch(Exception e) { }
        primaryStage.setScene(new Scene(root, 800, 600));
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
