Feature: Todo
  Scenario: Como usuario admin
  Quiero guardar mis contactos
  Para usarlos cuando los necesite


    Given tengo Todo abierto
    When hago click en Ok button adicionar contacto
    And lleno el campo Titulo con "AAAARemove"
    And lleno el campo Notas con "4444444"
    And presiono el check para guardar
    And hago en el doble check para ver los contactos agregados
    Then el contact "AAAARemove" deberia ser creado