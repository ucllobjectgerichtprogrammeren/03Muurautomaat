package domain.model;

public class Food extends Product {
    private int korting;

    public Food(String beschrijving, double prijs) {
        super(beschrijving, prijs);
    }

    protected void setKorting(int korting) {
        if (korting <= 0 || korting >= 100)
            throw new IllegalArgumentException("Geen geldige korting");
        this.korting = korting;
    }

    @Override
    public double getPrijs() {
        return super.getPrijs() * (1.-korting/100.);
    }

    @Override
    public String toString() {
        return super.toString()
                +"\nVerkregen korting: "+getKorting();
    }

    private int getKorting() {
        return korting;
    }

    @Override
    public boolean equals(Object o) {
        return super.equals(o)
                && this.getKorting() == ((Food) o).getKorting();
    }

}
