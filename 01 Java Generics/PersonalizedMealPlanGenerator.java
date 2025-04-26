import java.util.Arrays;
import java.util.List;

interface MealPlan {
    String getMealType();
    List<String> getMeals();
}
class VegetarianMeal implements MealPlan {
    public List<String> getMeals() {
        return Arrays.asList("Paneer Curry","Dal Rice","Vegetable Stir Fry");
    }
    public String getMealType() {
        return "Vegetarian";
    }
}
class VeganMeal implements MealPlan {
    public List<String> getMeals() {
        return Arrays.asList("Vegan Buddha Bowl","Tofu Stir Fry","Chickpea Salad");
    }
    public String getMealType(){
        return "Vegan";
    }
}
class KetoMeal implements MealPlan {
    public List<String> getMeals() {
        return Arrays.asList("Grilled Chicken","Avocado Salad","Zucchini Noodles");
    }
    public String getMealType() {
        return "Keto";
    }
}
class HighProteinMeal implements MealPlan {
    public List<String> getMeals() {
        return Arrays.asList("Protein Smoothie","Boiled Eggs","Grilled Salmon");
    }
    public String getMealType() {
        return "High Protein";
    }
}
class Meal<T extends MealPlan> {
    private T plan;
    public Meal(T plan) {
        this.plan=plan;
    }
    public void showPlan() {
        System.out.println("Meal Type: "+plan.getMealType());
        System.out.println("Meals: ");
        for (String meal : plan.getMeals()) {
            System.out.println("- "+meal);
        }
    }
}
class MealPlanner {
    public static <T extends MealPlan> Meal<T> generateMealPlan(T plan) {
        System.out.println("Generating meal plan for: "+plan.getMealType());
        return new Meal<>(plan);
    }
}
public class PersonalizedMealPlanGenerator {
    public static void main(String[] args) {
        VegetarianMeal veg=new VegetarianMeal();
        VeganMeal vegan=new VeganMeal();
        KetoMeal keto=new KetoMeal();
        HighProteinMeal highProtein=new HighProteinMeal();
        Meal<VegetarianMeal> vegPlan=MealPlanner.generateMealPlan(veg);
        Meal<VeganMeal> veganPlan=MealPlanner.generateMealPlan(vegan);
        Meal<KetoMeal>ketoPlan=MealPlanner.generateMealPlan(keto);
        Meal<HighProteinMeal> highProteinPlan=MealPlanner.generateMealPlan(highProtein);
        System.out.println("\n--- Personalized Plans ---");
        vegPlan.showPlan();
        System.out.println();
        veganPlan.showPlan();
        System.out.println();
        ketoPlan.showPlan();
        System.out.println();
        highProteinPlan.showPlan();
    }
}