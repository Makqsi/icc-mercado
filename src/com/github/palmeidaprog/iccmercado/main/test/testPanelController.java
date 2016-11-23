/*
* Mercado de TI
* @author Paulo R. Almeida Filho
* pauloalmeidaf@gmail.com
* */

package com.github.palmeidaprog.iccmercado.main.test;


import com.github.palmeidaprog.iccmercado.main.Controller;
import com.github.palmeidaprog.iccmercado.main.UIEffects;
import javafx.fxml.FXML;
import javafx.scene.layout.VBox;

public class testPanelController {
    @FXML protected VBox test1, test2;
    private UIEffects e = UIEffects.getInstance();
    private Controller c = Controller.getInstance();
    private int box = 0;

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
}
