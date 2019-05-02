package domain.model;

public class Drink extends Food {
    private static int KORTING_DRINK = 50;

    public Drink(String beschrijving, double prijs) {
        super(beschrijving, prijs);
        setKorting(KORTING_DRINK);
    }

}
