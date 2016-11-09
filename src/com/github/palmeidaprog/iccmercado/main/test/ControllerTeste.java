/*
* Mercado de TI
* Paulo R. Almeida Filho
* pauloalmeidaf@gmail.com
* */

package com.github.palmeidaprog.iccmercado.main.test;

import com.github.palmeidaprog.iccmercado.main.Controller;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;

public class ControllerTeste {
    @FXML private Button startBtn;
    @FXML private static BorderPane testPanel;
    private static Controller c = Controller.getInstance();

    //--Eventos------------------------------------------------
    public void startBtnClick() {
        c.startTest();
    }


}
