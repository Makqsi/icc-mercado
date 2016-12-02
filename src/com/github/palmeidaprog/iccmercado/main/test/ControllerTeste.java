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

    //--Singleton-Constructor----------------------------------
    private static volatile ControllerTeste instance = null;

    // FXMLoader
    public ControllerTeste() {
        getInstance();
    }
    private ControllerTeste(char x) {
    }
    public synchronized static ControllerTeste getInstance() {
        if(instance == null) {
            instance = new ControllerTeste('x');
        }
        return instance;
    }

    //--Eventos------------------------------------------------
    public void startBtnClick() {
        System.out.println(c.toString()); // @debug
        c.startTest();
        c.setEtapa("Aviso (Etapa 2 de 13)");
        //c.fadeTrans(testPanel);
    }


}
