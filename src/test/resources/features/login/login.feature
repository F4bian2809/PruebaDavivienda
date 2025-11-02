Feature: Realizar el login
  Yo como usuario
  Quiero realizar el login de la pagina
  Para validar el correcto ingreso

  @abrirpagina
  Scenario: Realizar login de manera correcta
    Given el usuario ingresa a la pagina web con el login
    When el usuario ingresa sus credenciales Admin y admin123
    Then Se valida que ingresa de manera correcta



