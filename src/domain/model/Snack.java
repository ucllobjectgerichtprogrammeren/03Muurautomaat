package domain.model;

public class Snack extends Food {
    static  int KORTING_SNACK = 25;
    private boolean kt;
    public Snack(String beschrijving, double prijs) {
        super(beschrijving, prijs);
        setKorting(KORTING_SNACK);
    }

    public static int getKortingSnack(){
        return KORTING_SNACK;
    }

    public double getKorting() {
        if (kt)
            return KORTING_SNACK*0.50;
        else
            return KORTING_SNACK;
    }

}
