package org.example.task;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.waits.WaitUntil;


import static net.serenitybdd.screenplay.Tasks.instrumented;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isPresent;
import static org.example.userinterface.loginUI.*;

public class ingresarCredencialesTask implements Task {
    //Declarar variables privadas
    private String user;
    private String password;

    //Constructores
    public ingresarCredencialesTask (String user, String password){
        this.user = user;
        this.password = password;
    }

    public static ingresarCredencialesTask with(String user, String password){
        return instrumented(ingresarCredencialesTask.class, user, password);
    }


    @Override
    public <T extends Actor> void performAs(T actor){
        actor.attemptsTo(
                WaitUntil.the(TXT_USER, isPresent()).forNoMoreThan(10).seconds(),
                Enter.theValue((user)).into(TXT_USER),
                WaitUntil.the(TXT_PASS, isPresent()).forNoMoreThan(10).seconds(),
                Enter.theValue((password)).into(TXT_PASS),
                WaitUntil.the(BTN_LOGIN, isPresent()).forNoMoreThan(10).seconds(),
                Click.on(BTN_LOGIN)

        );
    }
}
