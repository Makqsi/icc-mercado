/*
@author Paulo Roberto Almeida Filho
@email palmeidaprogramming@gmail.com
UI Effects methods
*/

package com.github.palmeidaprog.iccmercado.main;


import javafx.animation.*;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Control;
import javafx.scene.control.Label;
import javafx.scene.effect.BoxBlur;
import javafx.scene.effect.Glow;
import javafx.scene.effect.Reflection;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.util.Duration;

import java.net.URL;
import java.util.ResourceBundle;

public class UIEffects {
    private Controller controller = Controller.getInstance();

    // Effects/Efeitos
    private FadeTransition ft, ftl;
    private Reflection ref = new Reflection();



    //--Singleton Constuctor---------------------------------------------
    
    private static volatile UIEffects instance = null;
    private UIEffects() { }
    public synchronized static UIEffects getInstance() {
        if(instance == null) {
            instance = new UIEffects();
        }
        return instance;
    }

    //--Effects methods-------------------------------------------------
    
    // change VBox and calls for fade effects.
    // muda VBox e chama por efeitos de fade.
    protected void enterEffects() {
        addBlur(true);
    }


    protected void fadeTrans(Pane v) {
        fadeBoxes(controller.navigationBox.getChildren().get(1), 1);
        controller.navigationBox.getChildren().set(1, v);
        fadeBoxes(controller.navigationBox.getChildren().get(1), 0);
    }


    // resets all menus opacity
    // reinicia a opacidade de todos menus
    protected void opacityFull() {
        controller.testVB.setOpacity(1.0);
        controller.homeVB.setOpacity(1.0);
        controller.educacaoVB.setOpacity(1.0);
        controller.leiVB.setOpacity(1.0);
        controller.tituloLbl.setOpacity(1.0);
    }

    protected void colorAnim(VBox c) {
        FillTransition tra = new FillTransition();
        //tra.setShape(c);

        tra.setDuration(new Duration(2000));
        tra.setToValue(Color.GOLD);
        tra.setCycleCount(10);
        tra.setAutoReverse(true);
        tra.play();
    }

    protected void nodeScaling(Node n) {
        final ScaleTransition stBig = new ScaleTransition();
        //stBig.setNode(this);
        stBig.setFromX(1.0);
        stBig.setFromY(1.0);
        stBig.setToX(2.0);
        stBig.setToY(2.0);
        stBig.setDuration(new Duration(1000));

        final ScaleTransition stSmall = new ScaleTransition();
        //stSmall.setNode(this);
        stSmall.setFromX(2.0);
        stSmall.setFromY(2.0);
        stSmall.setToX(1.0);
        stSmall.setToY(1.0);
        stSmall.setDuration(new Duration(1000));

    }

    // add glow and reflection to a control
    // adiciona brilho e reflexo a um controle
    protected void addReflecGlow(Control c) {
        Reflection r = new Reflection();
        r.setFraction(0.75);
        Glow g = new Glow(0.27);
        g.setInput(r);
        c.setEffect(g);
    }

    protected void fadeBoxes(Node c, int i) { // todo: test
        FadeTransition f = new FadeTransition(Duration.millis(500), c);
        if(i == 0) {
            f.setFromValue(0.0);
            f.setToValue(1.0);
        }
        else {
            f.setFromValue(1.0);
            f.setToValue(0.0);
        }
        f.setCycleCount(1);
        f.play();
    }

    protected void fadeAnim(VBox v, Label l) { //todo: implement rest

        opacityFull(); // resets menu's opacity / reinicia opacidade dos menus
        if(ft != null) {
            ft.stop();
        }
        if(ftl != null) {
            ftl.stop();
        }

        ft = new FadeTransition(Duration.millis(750), v);
        ft.setFromValue(1.0);
        ft.setToValue(0.3);
        ft.setCycleCount(Timeline.INDEFINITE);
        ft.setAutoReverse(true);
        ft.play();

        ftl = new FadeTransition(Duration.millis(750), l);
        ftl.setFromValue(1.0);
        ftl.setToValue(0.1);
        ftl.setCycleCount(Timeline.INDEFINITE);
        ftl.setAutoReverse(true);
        ftl.play();
    }

    protected void trans(Label l) {
        TranslateTransition tt = new TranslateTransition(Duration.millis(300), l);
        double x = l.getTranslateX();
        double y = l.getTranslateY();

        tt.setFromX(500);
        tt.setToX(0);
        tt.setCycleCount(1);
        tt.setAutoReverse(false);

        /*tt.setFromX(-3);
        tt.setByX(3);
        tt.setFromY(-3);
        tt.setByY(3);
        tt.setCycleCount(10);
        tt.setAutoReverse(true);*/

        tt.play();
    }

    protected void trans(Node l) {
        TranslateTransition tt = new TranslateTransition(Duration.millis(300), l);
        double x = l.getTranslateX();
        double y = l.getTranslateY();

        tt.setFromX(500);
        tt.setToX(0);
        tt.setCycleCount(1);
        tt.setAutoReverse(false);

        /*tt.setFromX(-3);
        tt.setByX(3);
        tt.setFromY(-3);
        tt.setByY(3);
        tt.setCycleCount(10);
        tt.setAutoReverse(true);*/

        tt.play();
    }

    protected void fadeAnim() {
        //effectStatus = false;
        ft.stop();
        ftl.stop();
    }

    // return all "buttons/VBox" to their default colors (not selected)
    // volta todos os botoes para a cor padrao (não selecionado)
    protected void normalColors() {
        controller.homeVB.setStyle("-fx-background-color: #d086f5");
        controller.testVB.setStyle("-fx-background-color: #e7655a");
        controller.educacaoVB.setStyle("-fx-background-color: #fcc666");
        controller.leiVB.setStyle("-fx-background-color: #06e3bd");
    }

    // adds and remove blur and glow effect to the main panel
    // adiciona e remove efeito "blur" e "glow" ao painel de navegação
    protected void addBlur(boolean b) {
        Glow glow = new Glow(0.20);
        BoxBlur blur = new BoxBlur(1.0, 1.0, 3);

        if(b) {
            //blur.setInput(blur);
            //controller.mainPanel.setEffect(blur);
            glow.setInput(blur);
            controller.getMainNode().setEffect(glow);
        }
        else {
            controller.getMainNode().setEffect(null);
        }
        blur.setHeight(10.0);
        blur.setWidth(10.0);
        glow.setLevel(1.0);
        controller.getMainNode().setDisable(b);
    }


}
