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
    private Image full = Main.getInstance().getImageResource(1);
    private Image empty = Main.getInstance().getImageResource(0);
    @FXML private ImageView s1, s2, s3, s4, s5;

    private void mouseEnterStar(int pos) {
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
}
