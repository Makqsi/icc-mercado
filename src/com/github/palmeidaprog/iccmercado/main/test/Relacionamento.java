/*
* Mercado de TI
* Paulo R. Almeida Filho
* pauloalmeidaf@gmail.com
* */

package com.github.palmeidaprog.iccmercado.main.test;

import com.github.palmeidaprog.iccmercado.main.Interfaces.Linkable;

import java.net.MalformedURLException;
import java.net.URL;

public class Relacionamento implements Linkable {
    private URL youtube;
    private URL wikipedia;
    private URL google;
    private int stars;

    //--Singleton pattern--------------------------------------------------
    private static volatile Relacionamento instance = null;

    // constructor
    private Relacionamento() {
        try {
            youtube = new URL("https://www.youtube.com/watch?v=T-7ykWKbrc8");
            wikipedia = new URL("https://pt.wikipedia.org/wiki/Relacionamento");
            google = new URL("https://www.google.com.br/?gfe_rd=cr&ei=eE04WNf4IOPM8Afs0q24CA#s" +
                    "afe=off&q=%22relacionamento+interpessoal+no+trabalho%22");
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }

    public synchronized static Relacionamento getInstance() {
        if(instance == null) {
            instance = new Relacionamento();
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
