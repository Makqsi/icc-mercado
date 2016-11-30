/*
* Mercado de TI
* @author Paulo R. Almeida Filho
* pauloalmeidaf@gmail.com
* */

package com.github.palmeidaprog.iccmercado.main.test;


import com.github.palmeidaprog.iccmercado.main.Interfaces.Professionable;
import com.github.palmeidaprog.iccmercado.main.Main;
import com.github.palmeidaprog.iccmercado.main.test.Professions.AnalistaDeSistema;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.util.List;

public class ResultWindowController {
    @FXML private Label nr1, prof1, area1, perc1;
    @FXML private ProgressBar bar1;
    @FXML private Button btn1;
    private Stage details = new Stage();

    //--Singleton pattern--------------------------------------------------
    private static volatile ResultWindowController instance = null;

    // constructor
    private ResultWindowController() { }
    public synchronized static ResultWindowController getInstance() {
        if(instance == null) {
            instance = new ResultWindowController();
        }
        return instance;
    }

    //---------------------------------------------------------------------

    public void update() {
        List<Professionable> l = Choices.getInstance().getList();


    }

    public void btn1Clicked() {
        details.setScene(AnalistaDeSistema.getInstance().getDetails());
        try {
            Image f = new Image(Main.class.getResourceAsStream("favicon.png"));
            details.getIcons().add(f);
        } catch(Exception e) { }

        details.setTitle("Detalhes: " + AnalistaDeSistema.getInstance().getProfession());
        details.show();
    }
}
