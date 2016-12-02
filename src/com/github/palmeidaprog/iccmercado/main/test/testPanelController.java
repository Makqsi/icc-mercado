/*
* Mercado de TI
* @author Paulo R. Almeida Filho
* pauloalmeidaf@gmail.com
* */

package com.github.palmeidaprog.iccmercado.main.test;


import com.github.palmeidaprog.iccmercado.main.Controller;
import com.github.palmeidaprog.iccmercado.main.UIEffects;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Control;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.scene.Node;
import javafx.stage.Stage;

import java.io.IOException;

public class testPanelController {
    @FXML private VBox test1, test2, test3, test4, test5, test6, test7,
            test8, test9, test10, resultTest, atencaoBox;
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
                if(Hardware.getInstance().getStars() != 0) {
                    avancar(test2);
                }
                else {
                    errorDialog();
                }
                break;
            case 2:
                if(Lideranca.getInstance().getStars() != 0) {
                    avancar(test3);
                }
                else {
                    errorDialog();
                }
                break;
            case 3:
                if(Criatividade.getInstance().getStars() != 0) {
                    avancar(test4);
                }
                else {
                    errorDialog();
                }
                break;
            case 4:
                if(Ensino.getInstance().getStars() != 0) {
                    avancar(test5);
                }
                else {
                    errorDialog();
                }
                break;
            case 5:
                if(Relacionamento.getInstance().getStars() != 0) {
                    avancar(test6);
                }
                else {
                    errorDialog();
                }
                break;
            case 6:
                if(Pesquisa.getInstance().getStars() != 0) {
                    avancar(test7);
                }
                else {
                    errorDialog();
                }
                break;
            case 7:
                if(Matematica.getInstance().getStars() != 0) {
                    avancar(test8);
                }
                else {
                    errorDialog();
                }
                break;
            case 8:
                if(Logica.getInstance().getStars() != 0) {
                    avancar(test9);
                }
                else {
                    errorDialog();
                }
                break;
            case 9:
                if(Problemas.getInstance().getStars() != 0) {
                    avancar(test10);
                }
                else {
                    errorDialog();
                }
                break;
            case 10:
                if(Design.getInstance().getStars() != 0) {
                    c.setEtapa("Etapa 13 de 13");
                    e.fadeBoxes(c.navigationBox.getChildren().get(1), 1);
                    c.navigationBox.getChildren().set(1, c.resultTest);
                    e.fadeBoxes(c.navigationBox.getChildren().get(1), 0);
                    e.trans(c.resultTest);
                    TestResultController.getInstance().update();
                }
                else {
                    errorDialog();
                }
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
                break;
            case 5:
                retornar(test4);
                break;
            case 6:
                retornar(test5);
                break;
            case 7:
                retornar(test6);
                break;
            case 8:
                retornar(test7);
                break;
            case 9:
                retornar(test8);
                break;
            case 10:
                retornar(test9);
                break;
            default:
                break;
        }
    }

    // change VBox and using appropriate effects
    // mudar VBox e utilizar o efeitos apropriados
    private void avancar(VBox vB) {
        box++;
        c.setEtapa("Etapa " + (box + 2) + " de 13");
        e.fadeBoxes(c.testPanel.getCenter(), 1);
        c.testPanel.setCenter(vB);
        e.fadeBoxes(c.testPanel.getCenter(), 0);
        e.trans(vB);
    }

    // change VBox and using appropriate effects
    // mudar VBox e utilizar o efeitos apropriados
    private void retornar(Node vB) {
        box--;
        c.setEtapa("Etapa " + (box + 2) + " de 13");
        e.fadeBoxes(c.testPanel.getCenter(), 1);
        c.testPanel.setCenter(vB);
        e.fadeBoxes(c.testPanel.getCenter(), 0);
        e.transBack(vB);
    }

    //Dialog Window Error
    public void errorDialog() {
        FXMLLoader dlg = new FXMLLoader(getClass().getResource("error_dialog.fxml"));
        dlg.setController(DialogController.getInstance());
        Parent root = null;
        try {
            root = dlg.load();
        } catch(IOException e) {
            e.printStackTrace();
        }
        c.dError.setScene(new Scene(root, 321, 206)); // c is main application controller
        c.disable(true);
        c.dError.showAndWait();
    }
}
