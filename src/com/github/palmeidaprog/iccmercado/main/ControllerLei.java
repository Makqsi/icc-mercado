package com.github.palmeidaprog.iccmercado.main;

import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Control;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;

/**
 * Created by paulo on 10/27/16.
 */
public class ControllerLei {
    @FXML private VBox leiVB1, leiVB2, leiVB3, leiVB4, leiVB5, leiVB6;
    @FXML private Button btnVoltar, btnAvancar;
    @FXML private BorderPane mainLeiVB;
    private int box = 0;
    private UIEffects e = UIEffects.getInstance();
    private Controller c = Controller.getInstance();

    // Evento de clique do botão avançar
    // Avançar button click event
    public void avancarBtnClickAction() {
        switch(box) {
            case 0:
                btnVoltar.setDisable(false);
                avancar(leiVB2);
                break;
            case 1:
                avancar(leiVB3);
                break;
            case 2:
                avancar(leiVB4);
                break;
            case 3:
                avancar(leiVB5);
                break;
            case 4:
                avancar(leiVB6);
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
                retornar(leiVB1);
                btnVoltar.setDisable(true);
                break;
            case 2:
                retornar(leiVB2);
                break;
            case 3:
                retornar(leiVB3);
                break;
            case 4:
                retornar(leiVB4);
                break;
            case 5:
                retornar(leiVB5);
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
        c.setPagina("Página " + (box+1) + " de 6");
        c.setEtapa(c.getPagina());
        e.fadeBoxes(mainLeiVB.getCenter(), 1);
        mainLeiVB.setCenter(vB);
        e.fadeBoxes(mainLeiVB.getCenter(), 0);
        e.trans(vB);
    }

    // change VBox and using appropriate effects
    // mudar VBox e utilizar o efeitos apropriados
    private void retornar(Node vB) {
        box--;
        c.setPagina("Página " + (box+1) + " de 6");
        c.setEtapa(c.getPagina());
        e.fadeBoxes(mainLeiVB.getCenter(), 1);
        mainLeiVB.setCenter(vB);
        e.fadeBoxes(mainLeiVB.getCenter(), 0);
        e.transBack(vB);
    }

}
