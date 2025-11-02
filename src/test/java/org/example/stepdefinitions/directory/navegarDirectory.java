package org.example.stepdefinitions.directory;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.exceptions.commons.CommonsExeptions;
import org.example.questions.login.ValidarDirectoryQuestions;
import org.example.task.buscarEmpleadoTask;
import org.example.task.ingresarDirectoryTask;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static org.example.utilities.Constantes.MENSAJE_ERROR;
import static org.hamcrest.CoreMatchers.is;

public class navegarDirectory {

    @Given("el usuario ingresa al modulo Directory")
    public void ingresarDirectory() {
        theActorInTheSpotlight().attemptsTo(
                ingresarDirectoryTask.ingresarDirectory()
        );
    }

    @When("^el usuario digita (.*) en el campo de nombre empleado y presiona el botón buscar$")
    public void buscarEmpleado(String nombreEmpleado) {
        theActorInTheSpotlight().attemptsTo(
                buscarEmpleadoTask.buscarEmpleado(nombreEmpleado)
        );
    }

    @Then("^Se valida que muestra el emplado creado$")
    public void validarBusquedaEmpleado() {
        theActorInTheSpotlight().should(
                seeThat(
                        ValidarDirectoryQuestions.moduloDirectory(),is(true)
                ).orComplainWith(CommonsExeptions.class,MENSAJE_ERROR)
        );
    }
}
