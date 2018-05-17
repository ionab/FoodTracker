package models;

import javax.persistence.*;

@Entity
@Table(name = "foods")
public class Food {
    private String name;
    private double calories;
    private FoodType foodtype;
    private double price;
    private int id;
    private Meal meal;


    public Food() {
    }

    public Food(String name, double calories, FoodType foodtype, double price, Meal meal) {
        this.name = name;
        this.calories = calories;
        this.foodtype = foodtype;
        this.price = price;
        this.meal = meal;
    }

    @Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    @Column(name = "calories")
    public double getCalories() {
        return calories;
    }

    public void setCalories(double calories) {
        this.calories = calories;
    }
    @Enumerated(EnumType.STRING)
    public FoodType getFoodtype() {
        return foodtype;
    }

    public void setFoodtype(FoodType foodtype) {
        this.foodtype = foodtype;
    }
    @Column(name = "price")
    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
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
    @JoinColumn(name = "meal_id", nullable = false)
    public Meal getMeal() {
        return meal;
    }

    public void setMeal(Meal meal) {
        this.meal = meal;
    }
}
