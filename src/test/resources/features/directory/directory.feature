@katadavivienda
Feature: Realizar el login
  Yo como usuario
  Quiero realizar el login de la pagina
  Para validar el correcto ingreso

  Background:
    Given el usuario ingresa a la pagina web con el login
    When el usuario ingresa sus credenciales Admin y admin123
    Then Se valida que ingresa de manera correcta

  @navegarDirectory
  Scenario: Navegar en la opcion Directory
    Given el usuario ingresa al modulo Directory
    When el usuario digita Haider, Arias Naranjo en el campo de nombre empleado y presiona el botón buscar
    Then Se valida que muestra el emplado creado


