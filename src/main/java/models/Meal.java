package models;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "meals")

public class Meal {

    private Set<Food> foods;
    private int id;
    private MealType mealType;


    public Meal() {
    }

    public Meal(MealType mealType) {
        this.mealType = mealType;
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
}
