package org.example.userinterface;

import net.thucydides.core.annotations.findby.By;

import net.serenitybdd.screenplay.targets.Target;


public class loginUI {

    private loginUI(){}

    public static final Target TXT_USER = Target
            .the("Digitar Usuario")
            .located(By.name("username"));

    public static final Target TXT_PASS = Target
            .the("Digitar Contraseña")
            .located(By.name("password"));

    public static final Target BTN_LOGIN = Target
            .the("Presionar Botón login")
            .located(By.xpath("//*[@id='app']//button[@type='submit']"));

    public static final Target DASHBOARD = Target
            .the("Ingreso a dashboard")
            .located(By.xpath("//h6[text()='Dashboard']"));
}
