/*
* Mercado de TI
* Paulo R. Almeida Filho
* pauloalmeidaf@gmail.com
* */

package com.github.palmeidaprog.iccmercado.main.test;

import com.github.palmeidaprog.iccmercado.main.Interfaces.Linkable;
import com.github.palmeidaprog.iccmercado.main.Interfaces.Rateable;

import java.net.MalformedURLException;
import java.net.URL;

public class Pesquisa implements Linkable, Rateable {
    private URL youtube;
    private URL wikipedia;
    private URL google;
    private int stars;

    //--Singleton pattern--------------------------------------------------
    private static volatile Pesquisa instance = null;

    // constructor
    private Pesquisa() {
        try {
            youtube = new URL("https://www.youtube.com/watch?v=XueXwmoP_v8");
            wikipedia = new URL("https://pt.wikipedia.org/wiki/Pesquisa");
            google = new URL("https://www.google.com.br/webhp?sourceid=chrome-instant&i" +
                    "on=1&espv=2&ie=UTF-8#q=matem%C3%A1tica");
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }

    public synchronized static Pesquisa getInstance() {
        if(instance == null) {
            instance = new Pesquisa();
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
