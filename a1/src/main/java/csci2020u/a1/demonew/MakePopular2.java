package com.example.demonew;

//Now we will implement the Make interface
//to make different type of pizza(Popular order 2)
//This is a concrete builder which provides implementation
//of the steps in Make
public class MakePopular2 implements Make {

    private Pizza pizza;
    public MakePopular2() {
        this.pizza = new Pizza();
    }

    @Override
    public void builddough() {
        pizza.setterdough("Thick Dough");
    }
    @Override
    public void buildsauce() {
        pizza.settersauce("Honey Siracha Sauce");
    }

    @Override
    public void buildtoppings() {
        pizza.settertoppings("Pepperoni");
    }
    //return the final product after applying all the steps
    @Override
    public Pizza GetPizza() {
        Pizza popular_pizza2 = this.pizza;
        this.pizza = new Pizza();
        return popular_pizza2;
    }
}
