package mypackage.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.targets.Target;

public class EliminarCursoDeCarrito implements Task {

    private static final Target REMOVE_BUTTON = Target.the("Botón para eliminar un curso del carrito")
            .locatedBy("//a[@class='remove' and @data-product_id='169']\n");

    public static EliminarCursoDeCarrito oneCourse() {
        return new EliminarCursoDeCarrito();
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(Click.on(REMOVE_BUTTON));
    }
}
