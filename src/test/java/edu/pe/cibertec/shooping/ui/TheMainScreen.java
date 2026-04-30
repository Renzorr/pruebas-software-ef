package edu.pe.cibertec.shooping.ui;

import io.appium.java_client.AppiumBy;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.Visibility;
import net.serenitybdd.screenplay.targets.Target;

public class TheMainScreen {
    private static final Target HOME_INDICATOR = Target
            .the("man screen indicator")
            .located(AppiumBy.xpath("//android.widget.TextView[@text=\"Productos\"]"));

    public static Question<Boolean> isVisible() {
        return Visibility.of(HOME_INDICATOR).asBoolean();
    }
}
