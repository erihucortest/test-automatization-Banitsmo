package mypackage.steps;

import io.cucumber.java.es.Dado;
import io.cucumber.java.es.Cuando;
import io.cucumber.java.es.Y;
import io.cucumber.java.es.Entonces;
import mypackage.User;
import mypackage.tasks.*;
import net.serenitybdd.screenplay.Actor;

public class CarritoPasos {

    private Actor actor = User.actor();

    @Dado("que el usuario está en la página de tienda")
    public void dadoQueElUsuarioEstaEnLaPaginaDeTienda() {
        actor.attemptsTo(IrATienda.shop());
    }

    @Cuando("agrega dos cursos al carrito")
    public void cuandoAgregaDosCursosAlCarrito() {
        actor.attemptsTo(AgregarCursoACarrito.twoCourses());
    }

    @Y("va a la página del carrito")
    public void yVaALaPaginaDelCarrito() {
        actor.attemptsTo(IrACarrito.visit());
    }

    @Y("elimina uno de los cursos del carrito")
    public void yEliminaUnoDeLosCursosDelCarrito() {
        actor.attemptsTo(EliminarCursoDeCarrito.oneCourse());
    }

    @Entonces("el precio total debería ser menor a 400")
    public void entoncesElPrecioTotalDeberiaSerMenorA400() {
        actor.attemptsTo(VerificarPrecioTotal.isUnder(400));
    }
}
