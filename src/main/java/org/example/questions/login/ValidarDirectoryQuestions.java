package org.example.questions.login;

import net.serenitybdd.screenplay.Question;

import static org.example.userinterface.navegarDirectoryUI.DIRECTORY;

public class ValidarDirectoryQuestions implements Question<Boolean> {
    @Override
    public Boolean answeredBy(net.serenitybdd.screenplay.Actor actor) {
        return DIRECTORY.isVisibleFor(actor); // Placeholder return value
    }

    public static ValidarDirectoryQuestions moduloDirectory() {
        return new ValidarDirectoryQuestions();
    }
}
