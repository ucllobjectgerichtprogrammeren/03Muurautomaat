package domain.model;

public class NonFood extends Product {
    private boolean toegelatenMin16;

    public NonFood(String beschrijving, double prijs, boolean toegelatenMin16) {
        super(beschrijving, prijs);
        setToegelatenMin16(toegelatenMin16);
    }

    public boolean isToegelatenMin16() {
        return toegelatenMin16;
    }

    public void setToegelatenMin16(boolean toegelatenMin16) {
        this.toegelatenMin16 = toegelatenMin16;
    }

    @Override
    public String toString() {
        return super.toString()
                +"\nKT: "+(isToegelatenMin16()?"ja":"neen");
    }

    @Override
    public boolean equals(Object o) {
        return super.equals(o)
                && this.isToegelatenMin16() == ((NonFood) o).isToegelatenMin16();
    }
}
