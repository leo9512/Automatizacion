Feature: Agregar direccion

  Scenario Outline: El usuario registrado agrega una nueva direccion
    Given el usuario inicia sesion con el username "<usuario>" y el password "<password>", se dirige a Address Book y da click en New Address
     When el usuario llena los campos requeridos nombre"<firstName>", apellido"<lastName>", compañia"<company>", direccion uno"<address1>", direccion dos"<address2>", ciudad"<city>", codigo postal"<postCode>", pais"<country>", estado o region"<regionState>" y hace click en continue
     Then el usuario deberia aparecer en la página con titulo "<mensaje>"

    Examples: 
      | usuario           | password | firstName | lastName | company     | address1    | address2    | city     | postCode | country  | regionState | mensaje              |
      | usertest@test.com | usertest | Neyder    | Daza     | Bancolombia | Calle 1#2-3 | Calle 2#3-4 | Guarne   |      052 | Colombia | Antioquia   | Address Book Entries |
      | usertest@test.com | usertest | Pedro     | Franco   | Bancolombia |             |             | Medellin |      050 | Colombia | Antioquia   | Add Address          |
