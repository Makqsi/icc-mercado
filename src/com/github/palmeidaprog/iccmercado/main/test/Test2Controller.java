/*
* Mercado de TI
* @author Paulo R. Almeida Filho
* pauloalmeidaf@gmail.com
* */

package com.github.palmeidaprog.iccmercado.main.test;


import com.github.palmeidaprog.iccmercado.main.Main;
import javafx.fxml.FXML;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.awt.*;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;

public class Test2Controller {
    private Image full = Main.getImageResource(1);
    private Image empty = Main.getImageResource(0);
    @FXML private ImageView s1, s2, s3, s4, s5;
    private int stars = 0;

    // FXMLoader
    private static volatile Test2Controller instance = null;
    private Test2Controller() { }
    public synchronized static Test2Controller getInstance() {
        if(instance == null) {
            instance = new Test2Controller();
        }
        return instance;
    }



    //--Click on links events--------------------------------------------------------------------

    private void openLink(URL link) {
        String os = System.getProperty("os.name").toLowerCase();

        // open default browser depending the OS
        // abrir o navegador padrão dependendo do OS
        try {
            if(os.contains("linux")) {
                new ProcessBuilder("sensible-browser", link.toString()).start();
            }
            else if(os.contains("mac")) {
                new ProcessBuilder("open", link.toString()).start();
            }
            else {
                if (Desktop.isDesktopSupported()) {
                    // open in a new thread
                    // abre numa nova thread
                    new Thread(() -> {
                        try {
                            Desktop.getDesktop().browse(link.toURI());
                        } catch (IOException | URISyntaxException e1) {
                            e1.printStackTrace();
                        }
                    }).start();
                }
            }
        } catch(IOException e) {
            e.printStackTrace();
        }
    }

    public void getYoutube() {
        openLink(Lideranca.getInstance().getYoutube());
    }

    public void getWiki() {
        openLink(Lideranca.getInstance().getWiki());
    }

    public void getGoogle() {
        openLink(Lideranca.getInstance().getSearch());
    }

    //--Star-events--------------------------------------------------------------------

    // Turn off all the stars
    // Apaga todas estrelas
    public void turnOffStars() {
        s5.setImage(empty);
        s4.setImage(empty);
        s3.setImage(empty);
        s2.setImage(empty);
        s1.setImage(empty);
    }

    // Mouse entering stars events
    // Evento mouse entrando sobre as estrelas
    private void mouseEnterStar(int pos) {
        turnOffStars();
        switch(pos) {
            case 5:
                s5.setImage(full);
            case 4:
                s4.setImage(full);
            case 3:
                s3.setImage(full);
            case 2:
                s2.setImage(full);
            case 1:
                s1.setImage(full);
                break;
        }
    }

    // Mouse exiting stars event
    // Evento da seta do mouse saindo sobre as estrelas
    public void mouseExitStar() {
        mouseEnterStar(stars);
    }

    public void star1Enter() {
        mouseEnterStar(1);
    }

    public void star2Enter() {
        mouseEnterStar(2);
    }

    public void star3Enter() {
        mouseEnterStar(3);
    }

    public void star4Enter() {
        mouseEnterStar(4);
    }

    public void star5Enter() {
        mouseEnterStar(5);
    }

    public void setStars(int s) {
        stars = s;
        Lideranca.getInstance().setStars(s);
    }

    public void star1Click() {
        setStars(1);
        mouseEnterStar(stars);
    }

    public void star2Click() {
        setStars(2);
        mouseEnterStar(stars);
    }

    public void star3Click() {
        setStars(3);
        mouseEnterStar(stars);
    }

    public void star4Click() {
        setStars(4);
        mouseEnterStar(stars);
    }

    public void star5Click() {
        setStars(5);
        mouseEnterStar(stars);
    }

}
