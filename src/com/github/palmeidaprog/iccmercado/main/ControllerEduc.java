package com.github.palmeidaprog.iccmercado.main;

import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
/*
* Mercado de TI
* @author Paulo R. Almeida Filho
* pauloalmeidaf@gmail.com
* */

public class ControllerEduc {
    @FXML private VBox educVB1, educVB2, educVB3, educVB4, educVB5;
    @FXML private Button btnVoltar, btnAvancar;
    @FXML private BorderPane mainEducVB;
    private int box = 0;
    private UIEffects e = UIEffects.getInstance();
    private Controller c = Controller.getInstance();

    public void avancarBtnClickAction() {
        switch(box) {
            case 0:
                btnVoltar.setDisable(false);
                avancar(educVB2);
                break;
            case 1:
                avancar(educVB3);
                break;
            case 2:
                avancar(educVB4);
                break;
            case 3:
                avancar(educVB5);
                btnAvancar.setDisable(true);
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
                retornar(educVB1);
                btnVoltar.setDisable(true);
                break;
            case 2:
                retornar(educVB2);
                break;
            case 3:
                retornar(educVB3);
                break;
            case 4:
                retornar(educVB4);
                btnAvancar.setDisable(false);
                break;
            default:
                break;
        }
    }

    // change VBox and using appropriate effects
    // mudar VBox e utilizar o efeitos apropriados
    private void avancar(VBox vB) {
        box++;
        c.setPagEduc("Página " + (box+1) + " de 5");
        c.setEtapa(c.getPagEduc());
        e.fadeBoxes(mainEducVB.getCenter(), 1);
        mainEducVB.setCenter(vB);
        e.fadeBoxes(mainEducVB.getCenter(), 0);
        e.trans(vB);
    }

    // change VBox and using appropriate effects
    // mudar VBox e utilizar o efeitos apropriados
    private void retornar(Node vB) {
        box--;
        c.setPagEduc("Página " + (box+1) + " de 5");
        c.setEtapa(c.getPagEduc());
        e.fadeBoxes(mainEducVB.getCenter(), 1);
        mainEducVB.setCenter(vB);
        e.fadeBoxes(mainEducVB.getCenter(), 0);
        e.transBack(vB);
    }
}
