import db.DBHelper;
import models.*;

import java.util.GregorianCalendar;

public class Runner {

    public static void main(String[] args) {

        Day day = new Day(new GregorianCalendar(2018, 4, 23));
        Meal meal1 = new Meal(MealType.LUNCH, day);
        Food food1 = new Food("Pizza", 800.00, FoodType.CARBOHYDRATE, 9.99, meal1);

        DBHelper.save(day);
        DBHelper.save(meal1);
        DBHelper.save(food1);




    }
}
