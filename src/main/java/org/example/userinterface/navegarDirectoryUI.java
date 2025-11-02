package org.example.userinterface;

import net.serenitybdd.screenplay.targets.Target;
import net.thucydides.core.annotations.findby.By;

public class navegarDirectoryUI {
    private navegarDirectoryUI(){}

    public static final Target BTN_DIRECTORY = Target
            .the("Ingresar a la opción Directory")
            .located(By.xpath("//a[contains(@href,'directory')]"));

    public static final Target TXT_NOMBRE_EMPLEADO = Target
            .the("Digitar el nombre del empleado")
            .located(By.xpath("//input[contains(@placeholder,'Type for')]"));

    public static final Target BTN_BUSCAR = Target
            .the("Buscar empleado")
            .located(By.xpath("//button[text()=' Search ']"));

    public static final Target DIRECTORY = Target
            .the("directory")
            .located(By.xpath("//h5[text()='Directory']"));
}
