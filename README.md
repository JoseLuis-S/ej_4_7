# Ejercicio 4_7

1. Se quiere crear una clase `Cuenta` la cual se caracteriza por tener asociado un número de cuenta y un saldo disponible. 

   2. Además, se puede consultar el saldo disponible, recibir abonos y realizar pagos.

   3. Crear también una clase Persona, que se caracteriza por un DNI y una lista de cuentas bancarias.

   4. La `Persona` puede tener asociada hasta 3 cuentas bancarias, y debe tener un método que permita añadir cuentas *(hasta 3 el máximo permitido)*.  Las cuentas se almacenarán en un array/vector. No usar una lista.

   5. Métodos de clase:
    
       * Debe contener un método que devuelva si la persona es morosa *(si tienen alguna cuenta con saldo negativo)*. Recibirá como parámetro el objeto `Persona` y devolverá un booleano.
       * Debe contener un método que realice una transferencia entre dos cuentas. Recibirá como parámetro dos objetos `PersonaB`, dos identificacdors de cuentas y la cantidad a transferir. Devolverá un booleano indicando si se ha podido realizar o no la operación.

   6. En el programa principal, instanciar un objeto Persona con un DNI cualquiera, así como dos objetos cuenta, una sin saldo inicial y otra con 700 euros.
      La persona recibe la nómina mensual, por lo que ingresa 1100 euros en la primera cuenta, pero tiene que pagar el alquiler de 750 euros con la segunda.
      Imprimir por pantalla si la persona es morosa.

   7. Posteriormente hacer una transferencia de una cuenta a otra *(de forma que todos los saldos sean positivos)* y mostrar por pantalla el estado de la persona.
