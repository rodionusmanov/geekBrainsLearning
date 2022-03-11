package homework10_3;

import java.util.Locale;
import java.util.Random;

public class Fruit {
    protected String type;
    protected double weight;

    public Fruit() {
        this.type = "Волосатый фрукт рамбутан";
        this.weight = 100.0;
    }

    public void display(){
        System.out.println(type + " " + weight);
    }



   /* public void printInfo() {   //Метод печати состояния кота
        if (!hunger) {
            System.out.println(this + " - сытый");
        } else {
            System.out.println(this + " - голодный");
        }
    }*/

/*
    @Override
    public String toString() {
        return "Кот " + name + ": текущая сытость " + currentHunger + "/" + maxHunger + " ед.";
    }
*/

   /* public void eat(Plate plate) {  //Метод кормления кота из миски
        if (plate.foodCount != 0) { //Проверка на пустоту миски
            currentHunger = maxHunger - plate.decreaseFood(maxHunger - currentHunger); //Получение нового уровня сытости
        }
        this.hunger = (this.maxHunger != this.currentHunger); //Задание состояния голода кота
    }*/
}

