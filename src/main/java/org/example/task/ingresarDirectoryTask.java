package org.example.task;

import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isPresent;
import static org.example.userinterface.crearEmpleadoUI.BTN_AGREGAR;
import static org.example.userinterface.crearEmpleadoUI.BTN_PIM;
import static org.example.userinterface.navegarDirectoryUI.BTN_DIRECTORY;

public class ingresarDirectoryTask implements Task {
    public static ingresarDirectoryTask ingresarDirectory(){
        return new ingresarDirectoryTask();
    }

    @Override
    public <T extends net.serenitybdd.screenplay.Actor> void performAs(T actor) {
        actor.attemptsTo(
                WaitUntil.the(BTN_DIRECTORY, isPresent()).forNoMoreThan(30).seconds(),
                Click.on(BTN_DIRECTORY)
        );// Implementation goes here
    }
}
