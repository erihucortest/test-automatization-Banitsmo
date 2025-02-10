package mypackage.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.targets.Target;

public class AgregarCursoACarrito implements Task {

    private static final Target COURSE_ONE = Target.the("Botón Agregar Curso 1 al carrito")
            .locatedBy("//a[@class='button product_type_simple add_to_cart_button ajax_add_to_cart' and @data-product_id='169']\n");

    private static final Target COURSE_TWO = Target.the("Botón Agregar Curso 2 al carrito")
            .locatedBy("//a[@class='button product_type_simple add_to_cart_button ajax_add_to_cart' and @data-product_id='170']\n");

    public static AgregarCursoACarrito twoCourses() {
        return new AgregarCursoACarrito();
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Click.on(COURSE_ONE),
                Click.on(COURSE_TWO)
        );
    }
}
