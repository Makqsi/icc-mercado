/*
* Mercado de TI
* @author Paulo R. Almeida Filho
* pauloalmeidaf@gmail.com
* */

package com.github.palmeidaprog.iccmercado.main.test;


import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Label;

public class ResultWindowController {

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


}
