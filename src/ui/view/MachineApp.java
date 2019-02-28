package ui.view;

import domain.model.Machine;
import domain.model.Drink;
import domain.model.NonFood;
import domain.model.Snack;

public class MachineApp {
    Machine machine = new Machine("Automaat 01","Automaat op de eerste verdieping");

    public static void main(String[] args) {
        Snack snack1 = new Snack("Snicker", 10);
        Snack snack2 = new Snack("Mars",20);
        NonFood nonFood1 = new NonFood("Shampoo",15,true);
        NonFood nonFood2 = new NonFood("Scheerapparaat",100,false);
        Drink drink1 = new Drink("Cola",30);
        Drink drink2 = new Drink("Sprite",40);


    }
}
