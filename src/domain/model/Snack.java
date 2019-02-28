package domain.model;

public class Snack extends Food {
    static final int KORTING_SNACK = 25;
    public Snack(String beschrijving, double prijs) {
        super(beschrijving, prijs);
        setKorting(KORTING_SNACK);
    }

}
