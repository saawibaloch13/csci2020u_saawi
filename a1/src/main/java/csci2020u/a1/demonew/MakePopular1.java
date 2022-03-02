package com.example.demonew;

//Now we will implement the Make interface
//to make different type of pizza(Popular order 1)
//This is a concrete builder which provides implementation
//of the steps in Make
public class MakePopular1 implements Make {

    private Pizza pizza;
    public MakePopular1() {
        this.pizza = new Pizza();
    }

    @Override
    public void builddough() {
        pizza.setterdough("Thin Dough");
    }
    @Override
    public void buildsauce() {
        pizza.settersauce("Marinara Sauce");
    }

    @Override
    public void buildtoppings() {
        pizza.settertoppings("Cheese");
    }
    //return the final product after applying all the steps
    @Override
    public Pizza GetPizza() {
        Pizza popular_pizza1 = this.pizza;
        this.pizza = new Pizza();
        return popular_pizza1;
    }
}
