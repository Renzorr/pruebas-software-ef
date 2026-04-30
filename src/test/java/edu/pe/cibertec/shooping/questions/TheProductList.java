package edu.pe.cibertec.shooping.questions;

import edu.pe.cibertec.shooping.ui.ProductsScreen;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.Visibility;

public class TheProductList {
    public static Question<Boolean> contains(String productName) {
        return Visibility.of(ProductsScreen.productByName(productName)).asBoolean();
    }
}
