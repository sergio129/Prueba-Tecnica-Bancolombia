Feature: interactuar y llenar los datos del formulario

  @Reto
  Scenario: Ejecucion exitosa del formulario
    Given Nos logeamos en evalartapp
    When Escribimos la cantidad de veces: 72 letra: "e"
    And Completamos operacion matematica