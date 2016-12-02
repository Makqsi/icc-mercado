package com.github.palmeidaprog.iccmercado.main.test;

import com.github.palmeidaprog.iccmercado.main.Controller;
import javafx.event.EventHandler;
import javafx.fxml.Initializable;
import javafx.stage.WindowEvent;

import java.net.URL;
import java.util.ResourceBundle;

/*
* Mercado de TI
* @author Paulo R. Almeida Filho
* pauloalmeidaf@gmail.com
* */
public class DialogController implements Initializable {

    //--Singleton pattern--------------------------------------------------
    private static volatile DialogController instance = null;
    private Controller c = Controller.getInstance();

    // constructor
    private DialogController() { }
    public synchronized static DialogController getInstance() {
        if(instance == null) {
            instance = new DialogController();
        }
        return instance;
    }

    public void initialize(URL u, ResourceBundle rb) {

        // Stage close event / Evento de fechar janela (stage)
        // Anonymous class / classe anonima
        c.dError.setOnCloseRequest(new EventHandler<WindowEvent>() {
            @Override
            public void handle(WindowEvent event) {
                c.disable(false);
            }
        });
    }

    //--Events-----------------------------------------------------------

    public void okClick() {
        c.disable(false);
        c.dError.close();
    }
}
