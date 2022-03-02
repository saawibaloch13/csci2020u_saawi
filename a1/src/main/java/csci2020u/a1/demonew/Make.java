package com.example.demonew;

//Builder class
//This has all the steps needed to make our product-Pizza
public interface Make
{
    //steps
    public void builddough();
    public void buildtoppings();
    public void buildsauce();

    public Pizza GetPizza();
}