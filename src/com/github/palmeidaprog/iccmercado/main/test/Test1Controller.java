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

public class Test1Controller {
    private Image full = Main.getImageResource(1);
    private Image empty = Main.getImageResource(0);
    @FXML private ImageView s1, s2, s3, s4, s5;
    private int stars = 0;


    // Turn off all the stars
    // Apaga todas estrelas
    private void turnOffStars() {
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

    public void star1Click() {
        stars = 1;
        mouseEnterStar(stars);
    }

    public void star2Click() {
        stars = 2;
        mouseEnterStar(stars);
    }

    public void star3Click() {
        stars = 3;
        mouseEnterStar(stars);
    }

    public void star4Click() {
        stars = 4;
        mouseEnterStar(stars);
    }

    public void star5Click() {
        stars = 5;
        mouseEnterStar(stars);
    }

}
