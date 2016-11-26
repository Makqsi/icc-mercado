/*
* Mercado de TI
* Paulo R. Almeida Filho
* pauloalmeidaf@gmail.com
* */

package com.github.palmeidaprog.iccmercado.main.test;

import com.github.palmeidaprog.iccmercado.main.Interfaces.Linkable;

import java.net.MalformedURLException;
import java.net.URL;

public class Design implements Linkable {
    private URL youtube;
    private URL wikipedia;
    private URL google;
    private int stars;

    //--Singleton pattern--------------------------------------------------
    private static volatile Design instance = null;

    // constructor
    private Design() {
        try {
            youtube = new URL("https://www.youtube.com/watch?v=OtoY44KS2og");
            wikipedia = new URL("https://pt.wikipedia.org/wiki/L%C3%B3gica");
            google = new URL("https://www.google.com.br/webhp?sourceid=chrome-instant&ion=1&e" +
                    "spv=2&ie=UTF-8#q=logica%20e%20abstra%C3%A7%C3%A3o");
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
