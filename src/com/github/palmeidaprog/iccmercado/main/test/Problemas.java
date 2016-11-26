/*
* Mercado de TI
* Paulo R. Almeida Filho
* pauloalmeidaf@gmail.com
* */

package com.github.palmeidaprog.iccmercado.main.test;

import com.github.palmeidaprog.iccmercado.main.Interfaces.Linkable;

import java.net.MalformedURLException;
import java.net.URL;

public class Problemas implements Linkable {
    private URL youtube;
    private URL wikipedia;
    private URL google;
    private int stars;

    //--Singleton pattern--------------------------------------------------
    private static volatile Problemas instance = null;

    // constructor
    private Problemas() {
        try {
            youtube = new URL("https://www.youtube.com/watch?v=CtckGvDS98U");
            wikipedia = new URL("https://pt.wikipedia.org/wiki/Resolu%C3%A7%C3%A3o_de_problemas");
            google = new URL("https://www.google.com.br/webhp?sourceid=chrome-instant&ion=1&espv=2&ie=UTF-8" +
                    "#safe=off&q=%22resolu%C3%A7%C3%A3o+de+problemas%22");
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }

    public synchronized static Problemas getInstance() {
        if(instance == null) {
            instance = new Problemas();
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
