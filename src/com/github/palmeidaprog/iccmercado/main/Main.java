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
    protected static Stage primaryStage;
    private static volatile Main instance;
    public synchronized static Main getInstance() {
        return instance;
    }

    @Override
    public void start(Stage pStage) throws Exception{
        instance = this;
        primaryStage = pStage;
        FXMLLoader loader = new FXMLLoader(getClass().getResource("sample.fxml"));
        //Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        loader.setController(Controller.getInstance());
        Controllers.getInstance().setController(Controller.getInstance());
        Parent root = loader.load();
        primaryStage.setTitle("TI - Mercado de Trabalho");
        try {
            //InputStream f = Main.class.getResourceAsStream("favicon.ico");
            Image f = new Image(Main.class.getResourceAsStream("favicon.png"));
            primaryStage.getIcons().add(f);
        } catch(Exception e) { }
        primaryStage.setScene(new Scene(root, 800, 680));
        primaryStage.show();
    }

    public static Image getImageResource(int i) {
        if (i == 1) {
            return new Image(Main.class.getResourceAsStream("star_full.png"));
        } else {
            return new Image(Main.class.getResourceAsStream("star_empty.png"));
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}
