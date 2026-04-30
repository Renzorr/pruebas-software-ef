package edu.pe.cibertec.shooping.tasks;

import edu.pe.cibertec.shooping.ui.ProductsScreen;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;

public class FilterByCategory implements Task {

    private final String category;

    public FilterByCategory(String category) {
        this.category = category;
    }

    public static FilterByCategory of(String category) {
        return new FilterByCategory(category);
    }


    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Click.on(ProductsScreen.categoryFilter(category))
        );
    }
}
