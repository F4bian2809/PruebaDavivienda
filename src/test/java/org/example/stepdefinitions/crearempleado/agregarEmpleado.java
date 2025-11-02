package org.example.stepdefinitions.crearempleado;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.exceptions.commons.CommonsExeptions;
import org.example.questions.login.validarCrearEmpleadoQuestions;
import org.example.task.crearEmpleadoTask;
import org.example.task.ingresarPIMTask;


import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static org.example.utilities.Constantes.MENSAJE_ERROR;
import static org.hamcrest.CoreMatchers.is;

public class agregarEmpleado {

    @Given("el usuario ingresa al modulo PIM")
    public void ingresarPIM() {
        theActorInTheSpotlight().attemptsTo(
                ingresarPIMTask.ingresarPIM()
        );
    }

    @When("el usuario presiona el boton agregar empleado")
    public void agregarEmpleado() {
        theActorInTheSpotlight().attemptsTo(
                ingresarPIMTask.ingresarPIM()
        );
    }

    @And("^llena el formulario con nombre (.*) segundo nombre (.*) y apellido (.*)$")
    public void llenarFormulario(String nombre, String segundo_nombre, String apellido) {
        theActorInTheSpotlight().attemptsTo(
                crearEmpleadoTask.llenarFormulario(nombre, segundo_nombre, apellido)
        );
    }

    @Then("^Se guarda el empleado de manera correcta$")
    public void validarEmpleadoCreado() {
        theActorInTheSpotlight().should(
                seeThat(
                        validarCrearEmpleadoQuestions.empleadocreado(),is(true)
                ).orComplainWith(CommonsExeptions.class,MENSAJE_ERROR)
        );
    }
}
