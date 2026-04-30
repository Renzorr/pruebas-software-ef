package edu.pe.cibertec.shooping.steps;

import edu.pe.cibertec.shooping.tasks.Login;
import edu.pe.cibertec.shooping.ui.LoginScreen;
import edu.pe.cibertec.shooping.ui.ProfilePage;
import edu.pe.cibertec.shooping.ui.TheMainScreen;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actors.OnStage;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class LogoutSteps {

    private Actor actor() {
        return OnStage.theActorCalled("usuario");
    }

    private void sleep(int ms) {
        try { Thread.sleep(ms); } catch (InterruptedException ignored) {}
    }

    @When("hace clic en el menu de usuario")
    public void haceClicEnElMenuDeUsuario() {
        actor().attemptsTo(
                Click.on(ProfilePage.PROFILE_NAV)
        );
        sleep(2000);
        assertTrue(
                ProfilePage.PROFILE_TITLE.resolveFor(actor()).isPresent(),
                "Debe estar visible la pantalla Mi Perfil"
        );
    }

    @And("hace clic en cerrar sesion")
    public void haceClicEnCerrarSesion() {
        assertTrue(
                actor().asksFor(ProfilePage.isLogoutButtonVisible()),
                "El botón de cerrar sesión debe ser visible"
        );

        String username = actor().asksFor(ProfilePage.getCurrentUsername());
        assertNotNull(username, "Debe haber un nombre de usuario en pantalla");
        assertTrue(
                !username.isEmpty(),
                "El nombre del usuario no debe estar vacío"
        );

        actor().attemptsTo(
                Click.on(ProfilePage.LOGOUT_BUTTON)
        );
        sleep(1500);

        assertTrue(
                ProfilePage.LOGOUT_DIALOG_TITLE.resolveFor(actor()).isPresent(),
                "Debe aparecer el diálogo de confirmación de cierre de sesión"
        );

        actor().attemptsTo(
                Click.on(ProfilePage.CONFIRM_LOGOUT_BUTTON)
        );
        sleep(2000);
    }

    @Then("deberia regresar a la pantalla de login")
    public void deberiaRegresarALaPantallaDeLogin() {
        assertTrue(
                LoginScreen.LOGIN_SCREEN_INDICATOR.resolveFor(actor()).isPresent(),
                "Debe mostrarse la pantalla de login con el texto 'Bienvenido de vuelta'"
        );
    }
}