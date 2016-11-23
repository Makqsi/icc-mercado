/*
* Mercado de TI
* Paulo R. Almeida Filho
* pauloalmeidaf@gmail.com
* */

package com.github.palmeidaprog.iccmercado.main.test;

import com.github.palmeidaprog.iccmercado.main.Interfaces.Linkable;
import java.net.MalformedURLException;
import java.net.URL;

public class Hardware implements Linkable {
    private URL youtube;
    private URL wikipedia;
    private URL google;
    private int stars;

    //--Singleton pattern--------------------------------------------------
    private static volatile Hardware instance = null;

    // constructor
    private Hardware() {
        try {
            youtube = new URL("https://www.youtube.com/watch?v=dgkxCLOfB50");
            wikipedia = new URL("https://pt.wikipedia.org/wiki/Hardware");
            google = new URL("https://www.google.com.br/?gfe_rd=cr&ei=Vic1" +
                    "WInEB8em8we2gbHYBg&gws_rd=ssl#safe=off&q=%22o+que+%C3%A9+hardware%22");
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }

    public synchronized static Hardware getInstance() {
        if(instance == null) {
            instance = new Hardware();
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
