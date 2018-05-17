package models;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "meals")

public class Meal {

    private Set<Food> foods;
    private int id;
    private MealType mealType;
    private Day day;


    public Meal() {
    }

    public Meal(MealType mealType, Day day) {
        this.mealType = mealType;
        this.day = day;
        this.foods = new HashSet<Food>();
    }

    @OneToMany(mappedBy = "meal")
    public Set<Food> getFoods() {
        return foods;
    }

    public void setFoods(Set<Food> foods) {
        this.foods = foods;
    }
    @Enumerated(EnumType.STRING)
    public MealType getMealType() {
        return mealType;
    }

    public void setMealType(MealType mealType) {
        this.mealType = mealType;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @ManyToOne
    @JoinColumn(name = "day_id", nullable = false)
    public Day getDay() {
        return day;
    }

    public void setDay(Day day) {
        this.day = day;
    }

    public void addFood(Food food){
        foods.add(food);
    }

    public double getMealCalories() {
        double mealCalories = 0;
        for (Food foodItem : foods) {
            mealCalories += foodItem.getCalories();
        }
        return mealCalories;
    }
}
