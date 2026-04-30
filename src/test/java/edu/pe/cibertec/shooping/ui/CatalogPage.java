package edu.pe.cibertec.shooping.ui;

import io.appium.java_client.AppiumBy;
import net.serenitybdd.screenplay.targets.Target;

public class CatalogPage {

    public static final Target SEARCH_FIELD =
            Target.the("campo de búsqueda")
                    .located(AppiumBy.xpath(
                            "//android.widget.EditText"));

    public static final Target PRODUCT_LIST =
            Target.the("lista de productos")
                    .located(AppiumBy.xpath(
                            "//android.view.View[@scrollable='true']"));

    public static final Target FIRST_PRODUCT =
            Target.the("primer producto de la lista")
                    .located(AppiumBy.xpath(
                            "(//android.view.View[@scrollable='true']"
                                    + "/android.view.View[@clickable='true'])[1]"));

    public static Target productsByName(String name) {
        return Target.the("producto con nombre: " + name)
                .located(AppiumBy.xpath(
                        "//android.widget.TextView[contains(@text,'" + name + "')]"));
    }

    public static Target categoryOption(String category) {
        return Target.the("categoría: " + category)
                .located(AppiumBy.xpath(
                        "//androidx.compose.ui.platform.ComposeView"
                                + "/android.view.View/android.view.View"
                                + "/android.view.View"
                                + "/android.view.View[@checkable='true' and "
                                + ".//android.widget.TextView[@text='" + category + "']]"));
    }
}