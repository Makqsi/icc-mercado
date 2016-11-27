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

public class Design implements Linkable, Rateable {
    private URL youtube;
    private URL wikipedia;
    private URL google;
    private int stars;

    //--Singleton pattern--------------------------------------------------
    private static volatile Design instance = null;

    // constructor
    private Design() {
        try {
            youtube = new URL("https://www.youtube.com/watch?v=zfBzIfH6LEc");
            wikipedia = new URL("https://pt.wikipedia.org/wiki/Design");
            google = new URL("https://www.google.com.br/?gfe_rd=cr&ei=5tU5WOCxGs3K8gef2YP" +
                    "QCw&gws_rd=ssl#safe=off&q=design");
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }

    public synchronized static Design getInstance() {
        if(instance == null) {
            instance = new Design();
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
