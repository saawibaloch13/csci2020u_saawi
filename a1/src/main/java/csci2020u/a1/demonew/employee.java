package com.example.demonew;

//Director class- defines the order in which the steps are executed
public class employee {
    private Make make;
    public employee (Make make) {
        this.make = make;
    }
    public void MakePizza() {
        make.builddough();
        make.buildtoppings();
        make.buildsauce();
    }
}