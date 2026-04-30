package edu.pe.cibertec.shooping.steps;

import edu.pe.cibertec.shooping.tasks.Login;
import edu.pe.cibertec.shooping.ui.CartScreen;

import edu.pe.cibertec.shooping.ui.CheckoutPage;
import edu.pe.cibertec.shooping.ui.ShippingPage;

import edu.pe.cibertec.shooping.ui.TheMainScreen;
import io.appium.java_client.android.AndroidDriver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.actions.Clear;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.actors.OnStage;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class CheckoutSteps {

    private Actor actor() {
        return OnStage.theActorCalled("comprador");
    }

    private void sleep(int ms) {
        try { Thread.sleep(ms); } catch (InterruptedException ignored) {}
    }

    private void waitForMainScreen() {
        int maxWait = 15000;
        int interval = 1000;
        int elapsed = 0;
        while (elapsed < maxWait) {
            try {
                if (actor().asksFor(TheMainScreen.isVisible())) return;
            } catch (Exception ignored) {}
            sleep(interval);
            elapsed += interval;
        }
        assertTrue(false, "La pantalla principal no cargó en " + maxWait + "ms");
    }

    private void scrollDown() {
        AndroidDriver driver = edu.pe.cibertec.shooping.hooks.AppiumHooks.getDriver();
        driver.executeScript("mobile: scrollGesture", java.util.Map.of(
                "left", 0,
                "top", 500,
                "width", 1000,
                "height", 1500,
                "direction", "down",
                "percent", 0.85
        ));
    }

    @Given("que el usuario tiene productos en el carrito")
    public void queElUsuarioTieneProductosEnElCarrito() {
        actor().attemptsTo(
                Login.withCredentials("admin@test.com", "123456")
        );
        waitForMainScreen();
        actor().attemptsTo(
                Click.on(CartScreen.ADD_TO_CART_FIRST_PRODUCT)
        );
        sleep(1500);
        actor().attemptsTo(
                Click.on(CartScreen.CART_NAV)
        );
        sleep(2000);
        assertTrue(
                CartScreen.CART_TITLE.resolveFor(actor()).isPresent(),
                "Debe estar en la pantalla del carrito"
        );
    }

    @Given("que el usuario tiene el carrito vacio")
    public void queElUsuarioTieneElCarritoVacio() {
        actor().attemptsTo(
                Login.withCredentials("admin@test.com", "123456")
        );
        waitForMainScreen();
        actor().attemptsTo(
                Click.on(CartScreen.CART_NAV)
        );
        sleep(2000);
        assertTrue(
                CartScreen.CART_TITLE.resolveFor(actor()).isPresent(),
                "Debe estar en la pantalla del carrito"
        );
    }

    @When("procede al checkout")
    public void procedeAlCheckout() {
        actor().attemptsTo(
                Click.on(CartScreen.PROCEED_TO_PAYMENT_BUTTON)
        );
        sleep(2000);
        assertTrue(
                CheckoutPage.CHECKOUT_TITLE.resolveFor(actor()).isPresent(),
                "Debe aparecer la pantalla de Checkout"
        );
    }

    @And("ingresa los datos de envio")
    public void ingresaLosDatosDeEnvio() {
        actor().attemptsTo(
                Clear.field(ShippingPage.ADDRESS_FIELD),
                Enter.theValue("Av. Javier Prado 123").into(ShippingPage.ADDRESS_FIELD),
                Clear.field(ShippingPage.CITY_FIELD),
                Enter.theValue("Lima").into(ShippingPage.CITY_FIELD),
                Clear.field(ShippingPage.ZIP_FIELD),
                Enter.theValue("15036").into(ShippingPage.ZIP_FIELD)
        );
        sleep(500);
        actor().attemptsTo(
                Enter.theValue("4111111111111111").into(ShippingPage.CARD_NUMBER_FIELD),
                Enter.theValue("12/26").into(ShippingPage.EXPIRY_FIELD),
                Enter.theValue("123").into(ShippingPage.CVV_FIELD)
        );
        sleep(500);
    }

    @And("confirma la compra")
    public void confirmaLaCompra() {
        scrollDown();
        sleep(1000);
        actor().attemptsTo(
                Click.on(CheckoutPage.CONFIRM_BUTTON)
        );
        sleep(3000);
    }

    @When("intenta proceder al checkout")
    public void intentaProcederAlCheckout() {
        sleep(500);
    }

    @When("procede al checkout sin ingresar direccion")
    public void procedeAlCheckoutSinIngresarDireccion() {
        actor().attemptsTo(
                Click.on(CartScreen.PROCEED_TO_PAYMENT_BUTTON)
        );
        sleep(2000);
        assertTrue(
                CheckoutPage.CHECKOUT_TITLE.resolveFor(actor()).isPresent(),
                "Debe aparecer la pantalla de Checkout"
        );
        actor().attemptsTo(
                Clear.field(ShippingPage.ADDRESS_FIELD)
        );
        sleep(500);
        scrollDown();
        sleep(1000);
        actor().attemptsTo(
                Click.on(CheckoutPage.CONFIRM_BUTTON)
        );
        sleep(1500);
    }

    @Then("deberia ver el mensaje de compra exitosa")
    public void deberiaVerElMensajeDeCompraExitosa() {
        assertTrue(
                CheckoutPage.SUCCESS_MESSAGE.resolveFor(actor()).isPresent(),
                "Debe mostrarse el mensaje: ¡Pedido Confirmado!"
        );
    }

    @Then("deberia ver mensaje de carrito vacio")
    public void deberiaVerMensajeDeCarritoVacio() {
        sleep(1500);
        assertTrue(
                CartScreen.EMPTY_CART_MESSAGE.resolveFor(actor()).isPresent(),
                "Debe mostrarse el mensaje: 'Tu carrito está vacío'"
        );
    }

    @Then("deberia ver mensaje de direccion requerida")
    public void deberiaVerMensajeDeDireccionRequerida() {
        sleep(2000);
        assertTrue(
                CheckoutPage.ADDRESS_ERROR.resolveFor(actor()).isPresent(),
                "Debe mostrarse un mensaje de dirección requerida"
        );
    }
}