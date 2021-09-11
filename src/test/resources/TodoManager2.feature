Feature: Todo
  Scenario: Como usuario admin
  Quiero guardar mis contactos
  Para usarlos cuando los necesite


    Given tengo abierto el aplicativo
    When hago click en button adicionar contacto
    And hago click en adicionar titulo y nota
      |nombre  | eynar|
      |apellido| pari |
      |email   | eynar@eynar|
      |fecha   | 04/09/2021 |
    And hago en el doble check para ver la lista
    Then deberian mostrar la lista