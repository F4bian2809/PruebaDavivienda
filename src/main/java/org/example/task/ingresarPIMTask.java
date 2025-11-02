package org.example.task;

import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isPresent;
import static org.example.userinterface.crearEmpleadoUI.BTN_AGREGAR;
import static org.example.userinterface.crearEmpleadoUI.BTN_PIM;

public class ingresarPIMTask implements Task {

    public static ingresarPIMTask ingresarPIM(){
        return new ingresarPIMTask();
    }

    @Override
    public <T extends net.serenitybdd.screenplay.Actor> void performAs(T actor) {
        actor.attemptsTo(
                WaitUntil.the(BTN_PIM, isPresent()).forNoMoreThan(30).seconds(),
                Click.on(BTN_PIM),
                WaitUntil.the(BTN_AGREGAR, isPresent()).forNoMoreThan(30).seconds(),
                Click.on(BTN_AGREGAR)
        );
    }
}
