package com.example.demonew;

//This is our product-Pizza
//Our product consists of different fields and has setter methods for each field
public class Pizza
{
    private String dough;
    private String toppings;
    private String sauce;

    public void setterdough (String dough){
        this.dough = dough;
    }
    public void settertoppings (String toppings)
    { this.toppings = toppings;
    }
    public void settersauce (String sauce)
    { this.sauce = sauce;
    }

    //used to show the pizza
    public void ShowPizza ()
    {
        System. out. println(dough+", "+toppings+", "+sauce);
    }
}

