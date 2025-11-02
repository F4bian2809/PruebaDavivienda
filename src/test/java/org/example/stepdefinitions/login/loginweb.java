package org.example.stepdefinitions.login;

import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import net.serenitybdd.screenplay.actions.Open;
import io.cucumber.java.en.When;
import net.serenitybdd.annotations.Steps;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import org.example.exceptions.commons.CommonsExeptions;
import org.example.questions.login.ValidarLoginQuestions;
import org.example.questions.login.validarCrearEmpleadoQuestions;
import org.example.task.ingresarCredencialesTask;
import org.example.utilities.WebSite;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static org.example.utilities.Constantes.MENSAJE_ERROR;
import static org.hamcrest.CoreMatchers.is;

public class loginweb {


    @Steps(shared = true)
    WebSite pagina;

    @Before
    public void serTheStage(){
        OnStage.setTheStage(new OnlineCast());
        OnStage.theActorCalled("user");
    }

    @Given("el usuario ingresa a la pagina web con el login")
    public void ingresarPaginaWeb() {
        theActorInTheSpotlight().attemptsTo(
                Open.url("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login")
        );

    }

    @When("^el usuario ingresa sus credenciales (.*) y (.*)")
    public void digitarUsuario(String user, String password){
        theActorInTheSpotlight().attemptsTo(
                ingresarCredencialesTask.with(user,password)
        );
    }

    @Then("^Se valida que ingresa de manera correcta$")
    public void validarIngresoCorrecto() {
        theActorInTheSpotlight().should(
                seeThat(
                        ValidarLoginQuestions.board(),is(true)
                ).orComplainWith(CommonsExeptions.class,MENSAJE_ERROR)
        );
    }

}
