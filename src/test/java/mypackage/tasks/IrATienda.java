package mypackage.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Open;
import net.serenitybdd.screenplay.targets.Target;

public class IrATienda implements Task {

    public static final Target SHOP_PAGE = Target.the("Página de tienda")
            .locatedBy("http://practice.automationtesting.in/shop");

    public static IrATienda shop() {
        return new IrATienda();
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(Open.url(SHOP_PAGE.getCssOrXPathSelector()));
    }
}
