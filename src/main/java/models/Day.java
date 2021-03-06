package models;

import sun.util.calendar.Gregorian;

import javax.persistence.*;
import java.util.GregorianCalendar;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "day")
public class Day {

    private Set<Meal> meals;
    private GregorianCalendar date;
    private int id;

    public Day() {
    }

    public Day(GregorianCalendar date) {
        this.date = date;
        this.meals = new HashSet<Meal>();
    }

    @OneToMany(mappedBy = "day")
    public Set<Meal> getMeals() {
        return meals;
    }

    public void setMeals(Set<Meal> meals) {
        this.meals = meals;
    }

    @Column(name = "date")
    public GregorianCalendar getDate() {
        return date;
    }

    public void setDate(GregorianCalendar date) {
        this.date = date;
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

    public void addMeal(Meal meal){
        meals.add(meal);
    }


    public double getTotalCalories() {
        double dayCalories = 0;
        for (Meal meal : meals){
            dayCalories += meal.getMealCalories();
        }
        return dayCalories;
    }
}
