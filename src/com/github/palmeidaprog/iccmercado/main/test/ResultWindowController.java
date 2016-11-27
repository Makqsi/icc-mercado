/*
* Mercado de TI
* @author Paulo R. Almeida Filho
* pauloalmeidaf@gmail.com
* */

package com.github.palmeidaprog.iccmercado.main.test;


import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;

public class ResultWindowController {
    @FXML private Label nr1, prof1, area1, perc1;
    @FXML private ProgressBar bar1;
    @FXML private Button btn1;

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

    public void btn1Clicked() {
        prof1.setText("Programador");
    }


}
