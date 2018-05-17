import models.*;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.GregorianCalendar;

import static org.junit.Assert.assertEquals;

public class DayTest {

    private Meal meal;
    private Day day;
    private Food food;
    private ArrayList<Meal> meals;


    @Before
    public void before(){
        meals = new ArrayList<Meal>();
        day = new Day(new GregorianCalendar(2018,5,17));
        meal = new Meal(MealType.DINNER, day);
        food = new Food("Duck a la Orange", 1000000, FoodType.PROTEIN, 300.00, meal);
    }

    @Test
    public void canAddMealsToDay() {
        day.addMeal(meal);
        assertEquals(1, day.getMeals().size());
    }
}
