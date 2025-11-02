@katadavivienda
Feature: Realizar el login
  Yo como usuario
  Quiero realizar el login de la pagina
  Para validar el correcto ingreso

  Background:
    Given el usuario ingresa a la pagina web con el login
    When el usuario ingresa sus credenciales Admin y admin123
    Then Se valida que ingresa de manera correcta

  @crearEmpleado
  Scenario: Crear un empleado nuevo
    Given el usuario ingresa al modulo PIM
    When el usuario presiona el boton agregar empleado
    And llena el formulario con nombre Haider, segundo nombre Fabian y apellido Arias
    Then Se guarda el empleado de manera correcta


