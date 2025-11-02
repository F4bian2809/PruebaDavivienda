package org.example.task;

import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static net.serenitybdd.screenplay.Tasks.instrumented;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isPresent;
import static org.example.userinterface.navegarDirectoryUI.*;

public class buscarEmpleadoTask implements Task {
    private String nombreEmpleado;

    public buscarEmpleadoTask(String nombreEmpleado) {
        this.nombreEmpleado = nombreEmpleado;
    }

    public static buscarEmpleadoTask buscarEmpleado(String nombreEmpleado) {
        return instrumented(buscarEmpleadoTask.class, nombreEmpleado);
    }

    @Override
    public <T extends net.serenitybdd.screenplay.Actor> void performAs(T actor) {
        actor.attemptsTo(
                WaitUntil.the(TXT_NOMBRE_EMPLEADO, isPresent()).forNoMoreThan(10).seconds(),
                Enter.theValue(nombreEmpleado).into(TXT_NOMBRE_EMPLEADO),
                WaitUntil.the(BTN_BUSCAR, isPresent()).forNoMoreThan(30).seconds(),
                Click.on(BTN_BUSCAR)
        );
    }
}
