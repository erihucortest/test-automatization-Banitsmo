package mypackage.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.targets.Target;

public class IrACarrito implements Task {

    public static final Target CART_PAGE = Target.the("Enlace al carrito")
            .locatedBy("//*[@id='wpmenucartli']");

    public static IrACarrito visit() {
        return new IrACarrito();
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(Click.on(CART_PAGE));
    }
}
