package edu.pe.cibertec.shooping.ui;

import io.appium.java_client.AppiumBy;
import net.serenitybdd.screenplay.targets.Target;

public class CartScreen {

    public static final Target CART_TITLE =
            Target.the("título carrito de compras")
                    .located(AppiumBy.xpath(
                            "//android.widget.TextView[@text='Carrito de Compras']"));

    public static final Target CART_ITEM_COUNT =
            Target.the("cantidad de productos en el carrito")
                    .located(AppiumBy.xpath(
                            "//android.widget.TextView[contains(@text,'productos en el carrito')]"));

    public static final Target PROCEED_TO_PAYMENT_BUTTON =
            Target.the("botón proceder al pago")
                    .located(AppiumBy.xpath(
                            "//android.widget.TextView[@text='Proceder al Pago']"));

    public static final Target CART_NAV =
            Target.the("navegación al carrito")
                    .located(AppiumBy.xpath(
                            "//android.widget.TextView[@text='Carrito']"));

    public static final Target ADD_TO_CART_FIRST_PRODUCT =
            Target.the("agregar al carrito primer producto")
                    .located(AppiumBy.xpath(
                            "(//android.view.View[@content-desc='Agregar al carrito'])[1]"));

    public static final Target EMPTY_CART_MESSAGE =
            Target.the("mensaje carrito vacío")
                    .located(AppiumBy.xpath(
                            "//android.widget.TextView[@text='Tu carrito está vacío']"));
}