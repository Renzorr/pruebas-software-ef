package edu.pe.cibertec.shooping.ui;

import io.appium.java_client.AppiumBy;
import net.serenitybdd.screenplay.targets.Target;

public class ShippingPage {

    public static final Target ADDRESS_FIELD =
            Target.the("campo dirección")
                    .located(AppiumBy.xpath(
                            "(//android.widget.EditText)[1]"));

    public static final Target CITY_FIELD =
            Target.the("campo ciudad")
                    .located(AppiumBy.xpath(
                            "(//android.widget.EditText)[2]"));

    public static final Target ZIP_FIELD =
            Target.the("campo código postal")
                    .located(AppiumBy.xpath(
                            "(//android.widget.EditText)[3]"));

    public static final Target CARD_NUMBER_FIELD =
            Target.the("campo número de tarjeta")
                    .located(AppiumBy.xpath(
                            "(//android.widget.EditText)[4]"));

    public static final Target EXPIRY_FIELD =
            Target.the("campo vencimiento MM/YY")
                    .located(AppiumBy.xpath(
                            "(//android.widget.EditText)[5]"));

    public static final Target CVV_FIELD =
            Target.the("campo CVV")
                    .located(AppiumBy.xpath(
                            "(//android.widget.EditText)[6]"));
}