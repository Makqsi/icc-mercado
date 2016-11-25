/*
* Mercado de TI
* @author Paulo R. Almeida Filho
* pauloalmeidaf@gmail.com
* */

package com.github.palmeidaprog.iccmercado.main.test;


import com.github.palmeidaprog.iccmercado.main.Controller;
import com.github.palmeidaprog.iccmercado.main.UIEffects;
import javafx.fxml.FXML;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.scene.Node;

public class testPanelController {
    @FXML private VBox test1, test2, test3, test4;
    @FXML private BorderPane testPanel;
    private UIEffects e = UIEffects.getInstance();
    private Controller c = Controller.getInstance();
    private int box = 0;

    private volatile static testPanelController instance = null;
    public testPanelController() {
        instance = this;
    }

    public static synchronized testPanelController getInstance() {
        return instance;
    }

    // Evento de clique do botão avançar
    // Avançar button click event
    public void avancarBtnClickAction() {
        switch(box) {
            case 0:
                avancar(test1);
                break;
            case 1:
                avancar(test2);
                break;
            case 2:
                avancar(test3);
                break;
            case 3:
                avancar(test4);
                break;
            default:
                break;
        }
    }

    // Evento de clique do botão avançar
    // Avançar button click event
    public void retornarBtnClickAction() {
        switch(box) {
            case 0:
                break;
            case 1:
                retornar(testPanel);
                break;
            case 2:
                retornar(test1);
                break;
            case 3:
                retornar(test2);
                break;
            case 4:
                retornar(test3);
            default:
                break;
        }
    }

    // change VBox and using appropriate effects
    // mudar VBox e utilizar o efeitos apropriados
    private void avancar(VBox vB) {
        box++;
        e.fadeBoxes(c.testPanel.getCenter(), 1);
        c.testPanel.setCenter(vB);
        e.fadeBoxes(c.testPanel.getCenter(), 0);
        e.trans(vB);
    }

    // change VBox and using appropriate effects
    // mudar VBox e utilizar o efeitos apropriados
    private void retornar(Node vB) {
        box--;
        e.fadeBoxes(c.testPanel.getCenter(), 1);
        c.testPanel.setCenter(vB);
        e.fadeBoxes(c.testPanel.getCenter(), 0);
        e.transBack(vB);
    }
}
