package org.example.questions.login;

import net.serenitybdd.screenplay.Question;

import static org.example.userinterface.loginUI.DASHBOARD;

public class ValidarLoginQuestions implements Question<Boolean> {
    @Override
    public Boolean answeredBy(net.serenitybdd.screenplay.Actor actor) {
        return DASHBOARD.isVisibleFor(actor); // Cambiar según la lógica real
    }

    public static ValidarLoginQuestions board() {
        return new ValidarLoginQuestions();
    }
}
