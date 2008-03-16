/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package de.berlios.kcookb;

import de.berlios.kcookb.model.Ingredient;
import de.berlios.kcookb.model.KCookB;
import de.berlios.kcookb.model.Note;
import de.berlios.kcookb.model.Recipe;
import de.berlios.kcookb.model.RecipeDificulty;
import de.berlios.kcookb.model.RecipePrice;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author Knitter
 */
public class KCookBMain {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        KCookBMain m = new KCookBMain();
        
        KCookB book = new KCookB("kcookbdb.yap");
       // m.adicionarReceitas(book);
        m.pesquisar(book);
        book.closeCatalog();
    //new DB4oTestSuite().start();
    }
    
    private void pesquisar(KCookB book) {
        LinkedList<String> tags = new LinkedList<String>();
        tags.add("fraco");
        tags.add("remedio");
        
        List<Recipe> rs = book.searchWithTags(tags);
        for(Recipe r : rs) {
            System.err.println(r);
        }
        
    }

    private void adicionarReceitas(KCookB book) {
        LinkedList<Ingredient> lIngred1 = new LinkedList<Ingredient>();
        LinkedList<String> tags1 = new LinkedList<String>();
        tags1.add("fraco");
        tags1.add("forte");
        tags1.add("abc");
        LinkedList<String> tags2 = new LinkedList<String>();
        tags2.add("bom");
        tags2.add("correcto");
        LinkedList<String> tags3 = new LinkedList<String>();
        tags3.add("remedio");
        tags3.add("outros");
        LinkedList<Note> tips1 = new LinkedList<Note>();
        LinkedList<Note> notes1 = new LinkedList<Note>();
        
        book.addRecipe("receita 1", new Date(), new Date(), RecipeDificulty.HARD,
                RecipePrice.CHEAP, lIngred1, null, "Peixe", 4, null, null, notes1,
                tips1, 8, false, tags1, "", new Date(), new Date());

        book.addRecipe("receita 2", new Date(), new Date(), RecipeDificulty.HARD,
                RecipePrice.CHEAP, lIngred1, null, "Bebidas", 4, null, null, notes1,
                tips1, 10, false, tags2, "", new Date(), new Date());

        book.addRecipe("receita 3", new Date(), new Date(), RecipeDificulty.HARD,
                RecipePrice.MEDIUM, lIngred1, null, "Sobremesa", 4, null, null, notes1,
                tips1, 1.5, false, tags3, "", new Date(), new Date());

        book.addRecipe("receita 4", new Date(), new Date(), RecipeDificulty.HARD,
                RecipePrice.EXPENSIVE, lIngred1, null, "Carne", 4, null, null, notes1,
                tips1, 2, false, tags1, "", new Date(), new Date());
    }
}
