package org.example.userinterface;

import net.serenitybdd.screenplay.targets.Target;
import net.thucydides.core.annotations.findby.By;

public class crearEmpleadoUI {

    private crearEmpleadoUI(){}

    public static final Target BTN_PIM = Target
            .the("Ingresar a la opción PIM")
            .located(By.xpath("//*[text()='PIM']"));

    public static final Target BTN_AGREGAR = Target
            .the("Agregar empleado")
            .located(By.xpath("//button[contains(., 'Add')]"));

    public static final Target DIGITAR_NOMBRE = Target
            .the("Digitar nombre")
            .located(By.xpath("//input[@name='firstName']"));

    public static final Target DIGITAR_SEGUNDO_NOMBRE = Target
            .the("Digitar segundo nombre")
            .located(By.xpath("//input[@name='middleName']"));

    public static final Target DIGITAR_APELLIDO = Target
            .the("Digitar apellido")
            .located(By.xpath("//input[@name='lastName']"));

    public static final Target BTN_SAVE = Target
            .the("Presionar boton guardar")
            .located(By.xpath("//button[normalize-space()='Save']"));

    public static final Target PERSONAL_DETAILS = Target
            .the("Datos personales")
            .located(By.xpath("//h6[text()='Personal Details']"));
}
