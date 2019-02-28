package domain.model;

public class Product {
    private String beschrijving;
    private double prijs;
    private int aantal;

    public Product(String beschrijving, double prijs) {
        setBeschrijving(beschrijving);
        setPrijs(prijs);
    }

    public String getBeschrijving() {
        return beschrijving;
    }

    private void setBeschrijving(String beschrijving) {
        if (beschrijving == null || beschrijving.trim().isEmpty())
            throw new IllegalArgumentException("Geen geldige beschrijving voor product");
        this.beschrijving = beschrijving;
    }

    public double getPrijs() {
        return prijs;
    }

    private void setPrijs(double prijs) {
        if (prijs < 0)
            throw new IllegalArgumentException("Geef geldige prijs voor product");
        this.prijs = prijs;
    }

    public int getAantal() {
        return aantal;
    }

    public void setAantal(int aantal) {
        if (aantal < 0)
            throw new IllegalArgumentException("Geen geldig aantal voor dit product");
        this.aantal = aantal;
    }

    public boolean wijzigAantal(int wijziging) {
        if (aantal + wijziging < 0)
            return false;
        else {
            aantal += wijziging;
            return true;
        }

    }

    @Override
    public String toString() {
        return printKlasse()
                + "\nBeschrijving: " + getBeschrijving()
                + "\nPrijs: " + getPrijs();
    }

    //extra
    private String printKlasse() {
        String klasse = this.getClass().toString();
        int punt = klasse.lastIndexOf(".");
        return klasse.substring(punt + 1);
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || !(o.getClass().equals(this.getClass())))
            return false;
        Product p = (Product) o;
        return this.getAantal() == p.getAantal()
                && this.getBeschrijving().equalsIgnoreCase(p.getBeschrijving())
                && this.getPrijs() == p.getPrijs();
    }


}
