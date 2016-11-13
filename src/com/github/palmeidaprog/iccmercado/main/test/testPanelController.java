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
    @FXML protected VBox test1;
    private UIEffects e = UIEffects.getInstance();
    private Controller c = Controller.getInstance();

    public void avancarBtnClickAction() {
        e.fadeBoxes(c.testPanel.getCenter(), 1);
        c.testPanel.setCenter(test1);
        e.fadeBoxes(c.testPanel.getCenter(), 0);
        e.trans(test1);
    }
}
