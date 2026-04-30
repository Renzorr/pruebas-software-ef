package edu.pe.cibertec.shooping.steps;

import edu.pe.cibertec.shooping.tasks.FilterByCategory;
import edu.pe.cibertec.shooping.tasks.Login;
import edu.pe.cibertec.shooping.ui.CatalogPage;
import edu.pe.cibertec.shooping.ui.TheMainScreen;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;

import static net.serenitybdd.screenplay.actors.OnStage.theActorCalled;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class CatalogSteps {

    private Actor actor;

    @Given("que el usuario esta logueado en la aplicacion")
    public void queElUsuarioEstaLogueadoEnLaAplicacion() {
        actor = theActorCalled("usuario");
        actor.attemptsTo(
                Login.withCredentials("admin@test.com", "123456")
        );
        assertTrue(
                actor.asksFor(TheMainScreen.isVisible()),
                "El usuario debe estar en la pantalla principal después del login"
        );
    }

    @Given("que el usuario esta en el catalogo")
    public void queElUsuarioEstaEnElCatalogo() {
        actor = theActorCalled("usuario");
        actor.attemptsTo(
                Login.withCredentials("admin@test.com", "123456")
        );
        assertTrue(
                actor.asksFor(TheMainScreen.isVisible()),
                "El usuario debe estar en la pantalla de productos"
        );
    }

    @When("navega al catalogo de productos")
    public void navegaAlCatalogoDeProductos() {
        // La pantalla principal YA ES el catálogo — "Productos" es el título
        assertTrue(
                actor.asksFor(TheMainScreen.isVisible()),
                "Debe estar visible la pantalla del catálogo"
        );
    }

    @When("busca el producto {string}")
    public void buscaElProducto(String nombreProducto) {
        actor.attemptsTo(
                Click.on(CatalogPage.SEARCH_FIELD),
                Enter.theValue(nombreProducto).into(CatalogPage.SEARCH_FIELD)
        );
    }

    @When("filtra los productos por la categoria {string}")
    public void filtraLosProductosPorLaCategoria(String categoria) {
        actor.attemptsTo(
                FilterByCategory.of(categoria)
        );
    }

    @Then("deberia ver la lista de productos disponibles")
    public void deberiaVerLaListaDeProductosDisponibles() {
        assertTrue(
                CatalogPage.PRODUCT_LIST.resolveFor(actor).isPresent(),
                "El contenedor scrollable de productos debe estar presente"
        );
        assertTrue(
                CatalogPage.FIRST_PRODUCT.resolveFor(actor).isPresent(),
                "Debe existir al menos un producto en la lista"
        );
    }

    @Then("deberia ver productos que contengan {string}")
    public void deberiaVerProductosQueContengan(String nombre) {
        assertTrue(
                CatalogPage.productsByName(nombre).resolveFor(actor).isPresent(),
                "Debe aparecer al menos un producto que contenga: " + nombre
        );
    }

    @Then("deberia ver solo productos de la categoria {string}")
    public void deberiaVerSoloProductosDeLaCategoria(String categoria) {
        assertTrue(
                CatalogPage.PRODUCT_LIST.resolveFor(actor).isPresent(),
                "La lista debe seguir visible tras filtrar"
        );
        assertTrue(
                CatalogPage.categoryOption(categoria).resolveFor(actor).isPresent(),
                "La categoría seleccionada debe estar presente: " + categoria
        );
    }
}