import models.*;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.GregorianCalendar;

import static org.junit.Assert.assertEquals;

public class MealTest {

    private Meal meal;
    private Day day;
    private Food food;
    private ArrayList<Food> foods;

    @Before
    public void before(){
        day = new Day(new GregorianCalendar(2018,5,17));
        foods = new ArrayList<Food>();
        meal = new Meal(MealType.DINNER, day);
        food = new Food("Duck a la Orange", 1000000, FoodType.PROTEIN, 300.00, meal);
    }

    @Test
    public void canAddFoodToMeal(){
        meal.addFood(food);
        assertEquals(1, meal.getFoods().size());
    }

}
