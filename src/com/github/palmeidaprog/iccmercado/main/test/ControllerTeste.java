/*
* Mercado de TI
* Paulo R. Almeida Filho
* pauloalmeidaf@gmail.com
* */

package com.github.palmeidaprog.iccmercado.main.test;

import com.github.palmeidaprog.iccmercado.main.Controller;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class ControllerTeste implements Initializable {
    @FXML private Button startBtn;
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

    //--initialize--------------------------------------------------

    public void initialize(URL u, ResourceBundle rb) {
/*        FXMLLoader loaderPane = new FXMLLoader(getClass().getResource("test/testPanel.fxml"));
        loaderPane.setController(testPanelController.getInstance());
        try {
            testPanel = loaderPane.load();
        } catch(IOException e) {
            e.printStackTrace();
        }*/
    }

    //--Eventos------------------------------------------------
    public void startBtnClick() {
        c.startTest();
        c.setEtapa("Aviso (Etapa 2 de 13)");
        //c.fadeTrans(testPanel);
    }


}
