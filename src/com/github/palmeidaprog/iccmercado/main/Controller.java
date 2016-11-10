/*
* Mercado de TI
* Paulo R. Almeida Filho
* pauloalmeidaf@gmail.com
* */

package com.github.palmeidaprog.iccmercado.main;

import javafx.animation.*;
import javafx.scene.Node;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
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

public class Controller implements Initializable {
    @FXML private Label tituloLbl;
    @FXML private VBox testVB, homeVB, educacaoVB, leiVB, mainPanel;
    @FXML private int currentMenu = 1;
    private boolean blinkFlag;
    private boolean disableEffect = false;
    private String tituloAntigo = "Mercado de Trabalho de TI";

    // navigation panels / painéis de navegação
    @FXML private VBox mainEducVB, mainTesteVB, mainLeiVB, navigationBox;
    @FXML private BorderPane testPanel;
    @FXML private Button startBtn;


    //effects / efeitos
    private FadeTransition ft, ftl;
    private Reflection ref = new Reflection();
    private boolean effectStatus = false;

    //--Singleton-constructor--------------------------------------------------------

    private static volatile Controller instance = null;
    // used by FXMLLoader
    // usado pelo FXML loaderś
   /*public Controller() {
        //getInstance();
    }*/

    private Controller(char x) { }
    public synchronized static Controller getInstance() {
        if(instance == null) {
            instance = new Controller('x');
        }
        return instance;
    }

    public synchronized static void setInst(Controller c) {
        instance = Controllers.getInstance().getController();
    }

    //--Initialization/Inicialização--------------------------------------------------

    public void initialize(URL u, ResourceBundle rb) {
        //instance = this;
        System.out.println(this.toString()); // @debug
    }

    public void closeAction() {
        Main.primaryStage.close();
    }

    //--Mouse Click Events/Eventos de cliques de mouse---------------------------------

    public void homeClickAction() {
        if(currentMenu != 1) {
            normalColors(); // todos botoes para a cor padrão / change button colors to default
            homeVB.setStyle("-fx-background-color: #52596b");
            tituloAntigo = "Mercado de Trabalho de TI";
            tituloLbl.setText(tituloAntigo);
            fadeTrans(mainPanel);
            mouseExitAction();
            currentMenu = 1;
        }
    }

    public void testClickAction() {
        if(currentMenu != 2) {
            normalColors(); // todos botoes para a cor padrão / change button colors to default
            testVB.setStyle("-fx-background-color: #52596b");
            tituloAntigo = "Teste de Aptidão";
            tituloLbl.setText(tituloAntigo);
            fadeTrans(mainTesteVB);
            mouseExitAction();
            colorAnim(testVB);
            currentMenu = 2;
        }
    }

    public void educacaoClickAction() {
        if(currentMenu != 3) {
            normalColors(); // todos botoes para a cor padrão / change button colors to default
            educacaoVB.setStyle("-fx-background-color: #52596b");
            tituloAntigo = "Educação para TI";
            tituloLbl.setText(tituloAntigo);
            fadeTrans(mainEducVB);
            mouseExitAction();
            currentMenu = 3;
        }
    }

    public void leiClickAction() {
        if(currentMenu != 4) {
            normalColors(); // todos botoes para a cor padrão / change button colors to default
            leiVB.setStyle("-fx-background-color: #52596b");
            tituloAntigo = "Leis sobre Mercado de TI";
            tituloLbl.setText(tituloAntigo);
            fadeTrans(mainLeiVB);
            mouseExitAction();
            currentMenu = 4;
        }
    }

    //--Mouse Enter and Exit Events/Eventos de sobre mouse e saida de mouse------------------

    // mouse exit menu at the left event
    // evento de saida de mouse do eventos da esquerda
    public void mouseExitAction() {
        disableEffect = true;
        tituloLbl.setText(tituloAntigo);
        tituloLbl.setEffect(null);
        addBlur(false);
        fadeAnim();
        opacityFull();
    }

    public void leiMouseEnterAction() {
        if(currentMenu != 4) {
            disableEffect = false;
            tituloLbl.setText("Leis sobre Mercado de TI");
            //leiVB.setOpacity(0.8);
            addBlur(true);
            addReflecGlow(tituloLbl);
            trans(tituloLbl);
            fadeAnim(leiVB, tituloLbl);
        }
    }

    public void testeMouseEnterAction() {
        if(currentMenu != 2) {
            disableEffect = false;
            tituloLbl.setText("Teste de Aptidão");
            //anim.start();
            //testVB.setOpacity(0.8);
            addBlur(true);
            addReflecGlow(tituloLbl);
            trans(tituloLbl);
            fadeAnim(testVB, tituloLbl);
        }
    }

    public void homeMouseEnterAction() {
        if(currentMenu != 1) {
            disableEffect = false;
            tituloLbl.setText("Mercado de Trabalho de TI");
            //homeVB.setOpacity(0.8);
            addBlur(true);
            addReflecGlow(tituloLbl);
            trans(tituloLbl);
            fadeAnim(homeVB, tituloLbl);
        }
    }

    public void educacaoMouseEnterAction() {
        if(currentMenu != 3) {
            disableEffect = false;
            tituloLbl.setText("Educação para TI");
            //educacaoVB.setOpacity(0.8);
            addBlur(true);
            addReflecGlow(tituloLbl);
            trans(tituloLbl);
            fadeAnim(educacaoVB, tituloLbl);

        }
    }

    //--Test Controller Methods---------------------------------------------------

    public void startTest() {
        fadeTrans(testPanel);
    }

    //--Effects/Efeitos-----------------------------------------------------------

    // change VBox and calls for fade effects.
    // muda VBox e chama por efeitos de fade.
    public void fadeTrans(Pane v) {
        fadeBoxes(navigationBox.getChildren().get(1), 1);
        navigationBox.getChildren().set(1, v);
        fadeBoxes(navigationBox.getChildren().get(1), 0);
    }


    // resets all menus opacity
    // reinicia a opacidade de todos menus
    private void opacityFull() {
        testVB.setOpacity(1.0);
        homeVB.setOpacity(1.0);
        educacaoVB.setOpacity(1.0);
        leiVB.setOpacity(1.0);
        tituloLbl.setOpacity(1.0);
    }

    private void colorAnim(VBox c) {
        FillTransition tra = new FillTransition();
        //tra.setShape(c);

        tra.setDuration(new Duration(2000));
        tra.setToValue(Color.GOLD);
        tra.setCycleCount(10);
        tra.setAutoReverse(true);
        tra.play();
    }

    private void nodeScaling(Node n) {
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
    private void addReflecGlow(Control c) {
        Reflection r = new Reflection();
        r.setFraction(0.75);
        Glow g = new Glow(0.27);
        g.setInput(r);
        c.setEffect(g);
    }

    private void fadeBoxes(Node c, int i) { // todo: test
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

    private void fadeAnim(VBox v, Label l) { //todo: implement rest

        opacityFull(); // resets menu's opacity / reinicia opacidade dos menus
        if(ft != null) {
            ft.stop();
        }
        if(ftl != null) {
            ftl.stop();
        }

        effectStatus = true;
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

    private void trans(Label l) {
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

    private void fadeAnim() {
        effectStatus = false;
        ft.stop();
        ftl.stop();
    }

    // return all "buttons/VBox" to their default colors (not selected)
    // volta todos os botoes para a cor padrao (não selecionado)
    private void normalColors() {
        homeVB.setStyle("-fx-background-color: #d086f5");
        testVB.setStyle("-fx-background-color: #e7655a");
        educacaoVB.setStyle("-fx-background-color: #fcc666");
        leiVB.setStyle("-fx-background-color: #06e3bd");
    }

    // adds and remove blur and glow effect to the main panel
    // adiciona e remove efeito "blur" e "glow" ao painel de navegação
    private void addBlur(boolean b) {
        Glow glow = new Glow(0.20);
        BoxBlur blur = new BoxBlur(1.0, 1.0, 3);

        if(b) {
            //blur.setInput(blur);
            mainPanel.setEffect(blur);
            mainPanel.setEffect(glow);
        }
        else {
            mainPanel.setEffect(null);
        }
        blur.setHeight(10.0);
        blur.setWidth(10.0);
        glow.setLevel(1.0);
        mainPanel.setDisable(b);
    }

    // anonymous class
    // classe anônima
    private AnimationTimer anim = new AnimationTimer() {
        @Override
        public void handle(long now) {
            Glow glow = new Glow(0.30);

            /*for(int i = 0; i < 10; i++) {
                tituloLbl.setText(tituloLbl.getText() + "a");
            }*/
            tituloLbl.setEffect(null);
            tituloLbl.setEffect(glow);
            for(int i = 1; i <= 7000000; i++) {
                if(glow.getLevel() <= 1) {
                    glow.setLevel(glow.getLevel() + (double) i / 10000000);
                    tituloLbl.setText(tituloLbl.getText() + "a");
                }
                else {
                    glow.setLevel(0.3);
                    tituloLbl.setText(tituloLbl.getText() + "a");
                }
            }
        }
    };

}
