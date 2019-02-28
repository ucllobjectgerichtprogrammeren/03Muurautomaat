package domain.model;

public class Drink extends Food {
    static final int KORTING_DRINK = 50;

    public Drink(String beschrijving, double prijs) {
        super(beschrijving, prijs);
        setKorting(KORTING_DRINK);
    }

}
