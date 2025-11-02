package org.example.utilities;

import net.serenitybdd.annotations.Step;
import net.serenitybdd.annotations.Steps;
import net.serenitybdd.core.pages.PageObject;
public class WebSite {
    @Steps(shared=true)
    PageObject page;

    @Step("Abrir pagina en el navegador")
    public void navigateTo(String url) {
        page.setDefaultBaseUrl(url);
        page.open();
    }
}
