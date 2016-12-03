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
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Control;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.scene.Node;
import javafx.stage.Stage;
import java.net.URL;

import java.io.IOException;
import java.util.ResourceBundle;

public class testPanelController implements Initializable {
    @FXML private VBox test2, test3, test4, test5, test6, test7,
            test8, test9, test10, resultTest;

    @FXML public VBox test1, atencaoBox;
    //@FXML private BorderPane testPanel;
    private UIEffects e = UIEffects.getInstance();
    private Controller c = Controller.getInstance();
    private int box = 0;

    //--Singleton design---------------------------------------------------------

    private volatile static testPanelController instance = null;
    private testPanelController() { }
    public static synchronized testPanelController getInstance() {
        if(instance == null) {
            instance = new testPanelController();
        }
        return instance;
    }

    //--initialize----------------------------------------------------------------

    public void initialize(URL u, ResourceBundle rb) {

        // test1
        FXMLLoader loader1 = new FXMLLoader(getClass().getResource("1_test.fxml"));
        loader1.setController(Test1Controller.getInstance());
        try {
            test1 = loader1.load();
        } catch(IOException e) {
            e.printStackTrace();
        }

        // test2
        FXMLLoader loader = new FXMLLoader(getClass().getResource("2_test.fxml"));
        loader.setController(Test2Controller.getInstance());
        try {
            test2 = loader.load();
        } catch(IOException e) {
            e.printStackTrace();
        }

        // test3
        FXMLLoader loader2 = new FXMLLoader(getClass().getResource("3_test.fxml"));
        loader2.setController(Test3Controller.getInstance());
        try {
            test3 = loader2.load();
        } catch(IOException e) {
            e.printStackTrace();
        }

        // test4
        FXMLLoader loader4 = new FXMLLoader(getClass().getResource("4_test.fxml"));
        loader4.setController(Test4Controller.getInstance());
        try {
            test4 = loader4.load();
        } catch(IOException e) {
            e.printStackTrace();
        }

        // test5
        FXMLLoader loader5 = new FXMLLoader(getClass().getResource("5_test.fxml"));
        loader5.setController(Test5Controller.getInstance());
        try {
            test5 = loader5.load();
        } catch(IOException e) {
            e.printStackTrace();
        }

        // test6
        FXMLLoader loader6 = new FXMLLoader(getClass().getResource("6_test.fxml"));
        loader6.setController(Test6Controller.getInstance());
        try {
            test6 = loader6.load();
        } catch(IOException e) {
            e.printStackTrace();
        }

        // test7
        FXMLLoader loader7 = new FXMLLoader(getClass().getResource("7_test.fxml"));
        loader7.setController(Test7Controller.getInstance());
        try {
            test7 = loader7.load();
        } catch(IOException e) {
            e.printStackTrace();
        }

        // test8
        FXMLLoader loader8 = new FXMLLoader(getClass().getResource("8_test.fxml"));
        loader8.setController(Test8Controller.getInstance());
        try {
            test8 = loader8.load();
        } catch(IOException e) {
            e.printStackTrace();
        }

        // test9
        FXMLLoader loader9 = new FXMLLoader(getClass().getResource("9_test.fxml"));
        loader9.setController(Test9Controller.getInstance());
        try {
            test9 = loader9.load();
        } catch(IOException e) {
            e.printStackTrace();
        }

        // test10
        FXMLLoader loader10 = new FXMLLoader(getClass().getResource("10_test.fxml"));
        loader10.setController(Test10Controller.getInstance());
        try {
            test10 = loader10.load();
        } catch(IOException e) {
            e.printStackTrace();
        }
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
                retornar(atencaoBox);
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

    public void resetBox() {
        box = 0;
    }
}
