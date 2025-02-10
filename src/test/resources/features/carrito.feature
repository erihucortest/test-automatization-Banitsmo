Feature: Funcionalidad del carrito de compras

  Scenario: Agregar dos cursos al carrito y eliminar uno
  Dado que el usuario está en la página de tienda
  Cuando agrega dos cursos al carrito
  Y va a la página del carrito
  Y elimina uno de los cursos del carrito
  Entonces el precio total debería ser menor a 400
