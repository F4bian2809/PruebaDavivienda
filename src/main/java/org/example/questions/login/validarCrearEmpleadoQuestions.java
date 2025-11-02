package org.example.questions.login;

import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isPresent;
import static org.example.userinterface.crearEmpleadoUI.PERSONAL_DETAILS;
import static org.example.userinterface.navegarDirectoryUI.TXT_NOMBRE_EMPLEADO;

public class validarCrearEmpleadoQuestions implements Question<Boolean> {
    @Override
    public Boolean answeredBy(net.serenitybdd.screenplay.Actor actor) {
        actor.attemptsTo(
                WaitUntil.the(PERSONAL_DETAILS, isPresent()).forNoMoreThan(20).seconds());
        return PERSONAL_DETAILS.isVisibleFor(actor);
    }

    public static validarCrearEmpleadoQuestions empleadocreado() {

        return new validarCrearEmpleadoQuestions();
    }
}
