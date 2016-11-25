/*
* Mercado de TI
* Paulo R. Almeida Filho
* pauloalmeidaf@gmail.com
* */

package com.github.palmeidaprog.iccmercado.main.test;

import com.github.palmeidaprog.iccmercado.main.Interfaces.Linkable;

import java.net.MalformedURLException;
import java.net.URL;

public class Ensino implements Linkable {
    private URL youtube;
    private URL wikipedia;
    private URL google;
    private int stars;

    //--Singleton pattern--------------------------------------------------
    private static volatile Ensino instance = null;

    // constructor
    private Ensino() {
        try {
            youtube = new URL("https://www.youtube.com/watch?v=QVendyeiM2A");
            wikipedia = new URL("https://pt.wikipedia.org/wiki/Ensino");
            google = new URL("https://www.google.com.br/?gfe_rd=cr&ei=Vic1WInEB8em8we2g" +
                    "bHYBg&gws_rd=ssl#safe=off&q=%22defini%C3%A7%C3%A3o+de+ensino%22");
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }

    }

    public synchronized static Ensino getInstance() {
        if(instance == null) {
            instance = new Ensino();
        }
        return instance;
    }

    //--Linkable methods----------------------------------------------------

    public URL getYoutube() {
        return youtube;
    }

    public URL getWiki() {
        return wikipedia;
    }

    public URL getSearch() {
        return google;
    }

    public void setStars(int s) {
        stars = s;
    }

    public int getStars() {
        return stars;
    }
}
