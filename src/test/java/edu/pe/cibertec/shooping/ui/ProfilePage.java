package edu.pe.cibertec.shooping.ui;

import io.appium.java_client.AppiumBy;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.Text;
import net.serenitybdd.screenplay.questions.Visibility;
import net.serenitybdd.screenplay.targets.Target;

public class ProfilePage {

    public static final Target PROFILE_NAV =
            Target.the("navegación al perfil")
                    .located(AppiumBy.xpath(
                            "//android.widget.TextView[@text='Perfil']"));

    public static final Target PROFILE_TITLE =
            Target.the("título Mi Perfil")
                    .located(AppiumBy.xpath(
                            "//android.widget.TextView[@text='Mi Perfil']"));

    public static final Target LOGOUT_BUTTON =
            Target.the("botón cerrar sesión")
                    .located(AppiumBy.xpath(
                            "//android.view.View[@clickable='true' " +
                                    "and .//android.view.View[@content-desc='Cerrar sesión']]"));

    public static final Target USERNAME_DISPLAY =
            Target.the("nombre del usuario")
                    .located(AppiumBy.xpath(
                            "//android.widget.TextView[@text='Nombre']" +
                                    "/following-sibling::android.widget.TextView[1]"));

    public static final Target LOGOUT_DIALOG_TITLE =
            Target.the("título diálogo cerrar sesión")
                    .located(AppiumBy.xpath(
                            "//android.widget.TextView[@text='Cerrar Sesión']"));

    public static final Target CONFIRM_LOGOUT_BUTTON =
            Target.the("botón confirmar cerrar sesión")
                    .located(AppiumBy.xpath(
                            "//android.view.View[@clickable='true' " +
                                    "and .//android.widget.TextView[@text='Sí, cerrar sesión']]"));

    public static final Target CANCEL_LOGOUT_BUTTON =
            Target.the("botón cancelar cerrar sesión")
                    .located(AppiumBy.xpath(
                            "//android.view.View[@clickable='true' " +
                                    "and .//android.widget.TextView[@text='Cancelar']]"));

    public static Question<Boolean> isLogoutButtonVisible() {
        return Visibility.of(LOGOUT_BUTTON).asBoolean();
    }

    public static Question<String> getCurrentUsername() {
        return Text.of(USERNAME_DISPLAY);
    }
}