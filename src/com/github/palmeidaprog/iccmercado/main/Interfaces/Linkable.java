/*
* Mercado de TI
* Paulo R. Almeida Filho
* pauloalmeidaf@gmail.com
* */

package com.github.palmeidaprog.iccmercado.main.Interfaces;

import java.net.URL;

/**
 * Created by paulo on 11/21/16.
 */
public interface Linkable {
    URL youtube;
    URL wikipedia;
    URL google;

    public static URL getYoutube() {
        return youtube;
    }

    static URL getWiki() {
        return wikipedia;
    }

    static URL getSearch() {
        return google;
    }
}
