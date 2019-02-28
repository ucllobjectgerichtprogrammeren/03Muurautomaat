package domain.model;

import java.time.LocalTime;
import java.util.ArrayList;

public class Machine {
    private String naam;
    private ArrayList<Product> producten;
    private String beschrijving;
    private LocalTime datumLaatsteBijvulling;

    public Machine(String naam, String beschrijving) {
        setNaam(naam);
        setBeschrijving(beschrijving);
        producten = new ArrayList<>();
    }

    public void voegProductToe(Product product) {
        if (checkAanwezig(product.getBeschrijving()) != null)
            throw new IllegalArgumentException("Dit product zit al in de machine");
        producten.add(product);
    }

    public void vulProductAan(Product product, int aantal) {
        if (aantal <= 0)
            throw new IllegalArgumentException("Geen geldig aantal om aan te vullen");
        Product p = checkAanwezig(product.getBeschrijving());
        if (p == null)
            throw new IllegalArgumentException("Dit product kan niet aangevuld worden omdat het nog niet geregistreerd is");
        p.wijzigAantal(aantal);
        datumLaatsteBijvulling = LocalTime.now();
    }

    public Product vindProduct(Product product) {
        for (Product p : getProducten())
            if (p.equals(product))
                return p;
        return null;
    }

    public Product checkAanwezig(String beschrijvingProduct) {
        for (Product p : getProducten())
            if (p.getBeschrijving().equals(beschrijvingProduct))
                return p;
        return null;
    }

    public String getNaam() {
        return naam;
    }

    public void setNaam(String naam) {
        if (naam == null || naam.trim().isEmpty())
            throw new IllegalArgumentException("Geen geldige naam voor de machine");
        this.naam = naam;
    }

    public ArrayList<Product> getProducten() {
        return producten;
    }

    @Override
    public String toString() {
        String result = "Machine met naam \"" + getNaam() + "\"\n";
        result += "*****************************\n";
        for (Product product : getProducten()) {
            result += product.toString() + "\n";
            result += "-----------------------------\n";
        }
        return result;
    }

    public double getTotaalPrijs() {
        double totaalPrijs = 0;
        for (Product p : getProducten())
            totaalPrijs += p.getPrijs() * p.getAantal();
        return totaalPrijs;
    }

    public String getBeschrijving() {
        return beschrijving;
    }

    public void setBeschrijving(String beschrijving) {
        if (beschrijving == null || beschrijving.trim().isEmpty())
            throw new IllegalArgumentException("Geen geldige beschrijving van de machine");
        this.beschrijving = beschrijving;
    }

    public LocalTime getDatumLaatsteBijvulling() {
        return datumLaatsteBijvulling;
    }

    private void setDatumLaatsteBijvulling(LocalTime datumLaatsteBijvulling) {
        if (datumLaatsteBijvulling == null)
            throw new IllegalArgumentException("Geen geldige datum van laatste bijvulling");
        this.datumLaatsteBijvulling = datumLaatsteBijvulling;
    }
}
