/*
* Mercado de TI
* Paulo R. Almeida Filho
* pauloalmeidaf@gmail.com
* */

package com.github.palmeidaprog.iccmercado.main.test;

import com.github.palmeidaprog.iccmercado.main.Interfaces.Linkable;

import java.net.MalformedURLException;
import java.net.URL;

public class Criatividade implements Linkable {
    private URL youtube;
    private URL wikipedia;
    private URL google;
    private int stars;

    //--Singleton pattern--------------------------------------------------
    private static volatile Criatividade instance = null;

    // constructor
    private Criatividade() {
        try {
            youtube = new URL("https://www.youtube.com/watch?v=2-40UJvhQ1w");
            wikipedia = new URL("https://pt.wikipedia.org/wiki/Criatividade");
            google = new URL("https://www.google.com.br/webhp?sourceid=chrome-instant" +
                    "&ion=1&espv=2&ie=UTF-8#safe=off&q=defini%C3%A7a%C3%B5+de+criatividade");
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }

    public synchronized static Criatividade getInstance() {
        if(instance == null) {
            instance = new Criatividade();
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
