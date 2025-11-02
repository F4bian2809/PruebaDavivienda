package org.example.task;

import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static net.serenitybdd.screenplay.Tasks.instrumented;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isPresent;
import static org.example.userinterface.crearEmpleadoUI.*;


public class crearEmpleadoTask implements Task {
    private String firstname;
    private String  middlename;
    private String lastname;

    public crearEmpleadoTask (String firstname, String middlename, String lastname){
        this.firstname = firstname;
        this.middlename = middlename;
        this.lastname = lastname;
    }

    public static crearEmpleadoTask llenarFormulario(String firstname, String middlename, String lastname){
        return instrumented(crearEmpleadoTask.class, firstname, middlename, lastname);
    }

    @Override
    public <T extends net.serenitybdd.screenplay.Actor> void performAs(T actor) {
        actor.attemptsTo(
                WaitUntil.the(DIGITAR_NOMBRE, isPresent()).forNoMoreThan(30).seconds(),
                Enter.theValue(firstname).into(DIGITAR_NOMBRE),
                WaitUntil.the(DIGITAR_SEGUNDO_NOMBRE, isPresent()).forNoMoreThan(30).seconds(),
                Enter.theValue(middlename).into(DIGITAR_SEGUNDO_NOMBRE),
                WaitUntil.the(DIGITAR_APELLIDO, isPresent()).forNoMoreThan(30).seconds(),
                Enter.theValue(lastname).into(DIGITAR_APELLIDO),
                WaitUntil.the(BTN_SAVE, isPresent()).forNoMoreThan(10).seconds(),
                Click.on(BTN_SAVE)
        );

    }
}
