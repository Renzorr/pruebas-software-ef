package edu.pe.cibertec.shooping.ui;

import io.appium.java_client.AppiumBy;
import net.serenitybdd.screenplay.targets.Target;

public class ProductsScreen {

    public static Target categoryFilter(String category) {
        return Target.the(category + " category filter")
                .located(AppiumBy.xpath(
                        "//androidx.compose.ui.platform.ComposeView"
                                + "/android.view.View/android.view.View"
                                + "/android.view.View"
                                + "/android.view.View[@checkable='true' and "
                                + ".//android.widget.TextView[@text='" + category + "']]"));
    }

    public static Target productByName(String productName) {
        return Target.the("Product: " + productName)
                .located(AppiumBy.xpath(
                        "//android.widget.TextView[@text='" + productName + "']"));
    }

    public static final Target ADD_TO_CART_BUTTON =
            Target.the("botón agregar al carrito")
                    .located(AppiumBy.xpath(
                            "(//android.view.View[@content-desc='Agregar al carrito'])[1]"));

    public static final Target CART_NAV =
            Target.the("navegación al carrito")
                    .located(AppiumBy.xpath(
                            "//android.widget.TextView[@text='Carrito']"));

    public static final Target PROFILE_NAV =
            Target.the("navegación al perfil")
                    .located(AppiumBy.xpath(
                            "//android.widget.TextView[@text='Perfil']"));
}