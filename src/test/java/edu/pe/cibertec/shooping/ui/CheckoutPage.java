package edu.pe.cibertec.shooping.ui;

import io.appium.java_client.AppiumBy;
import net.serenitybdd.screenplay.targets.Target;

public class CheckoutPage {  // ← antes era CheckoutScreen

    public static final Target CHECKOUT_TITLE =
            Target.the("título checkout")
                    .located(AppiumBy.xpath(
                            "//android.widget.TextView[@text='Checkout']"));

    public static final Target CONFIRM_BUTTON =
            Target.the("botón confirmar compra")
                    .located(AppiumBy.xpath(
                            "//android.widget.ScrollView/android.view.View[@clickable='true' "
                                    + "and @focusable='true'][last()]"));

    public static final Target SUCCESS_MESSAGE =
            Target.the("mensaje pedido confirmado")
                    .located(AppiumBy.xpath(
                            "//android.widget.TextView[@text='¡Pedido Confirmado!']"));

    public static final Target ADDRESS_ERROR =
            Target.the("mensaje dirección requerida")
                    .located(AppiumBy.xpath(
                            "//android.widget.TextView[contains(@text,'dirección') "
                                    + "or contains(@text,'requerida') "
                                    + "or contains(@text,'obligatorio') "
                                    + "or contains(@text,'campo')]"));
}