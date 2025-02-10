package mypackage.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.targets.Target;
import net.serenitybdd.screenplay.waits.WaitUntil;
import org.openqa.selenium.By;

import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class VerificarPrecioTotal implements Task {

    private static final Target TOTAL_PRICE = Target.the("Precio total del carrito")
            .located(By.cssSelector("//tr[@class='order-total']//td[@data-title='Total']//strong//span[@class='woocommerce-Price-amount']"));

    private final double expectedPrice;

    public VerificarPrecioTotal(double expectedPrice) {
        this.expectedPrice = expectedPrice;
    }

    public static VerificarPrecioTotal isUnder(double price) {
        return new VerificarPrecioTotal(price);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(WaitUntil.the(TOTAL_PRICE, isVisible()).forNoMoreThan(10).seconds());

        String totalPriceText = TOTAL_PRICE.resolveFor(actor).getText();
        double actualPrice = Double.parseDouble(totalPriceText.replace("₹", "").trim());

        if (actualPrice >= expectedPrice) {
            throw new AssertionError("El precio total no es menor a " + expectedPrice + ", es: " + actualPrice);
        }
    }
}
