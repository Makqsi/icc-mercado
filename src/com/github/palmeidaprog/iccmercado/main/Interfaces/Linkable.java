/*
* Mercado de TI
* Paulo R. Almeida Filho
* pauloalmeidaf@gmail.com
* */

package com.github.palmeidaprog.iccmercado.main.Interfaces;

import java.net.URL;

public interface Linkable {
    URL getYoutube();
    URL getWiki();
    URL getSearch();
    void setStars(int s);
    int getStars();
}
