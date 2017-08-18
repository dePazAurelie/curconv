package curonv;

public class Yen extends Currency {

    public Yen(double conversionRate) {
        super("Yen", "¥", "YEN");
        this.setConversionRate(conversionRate);
    }
}
