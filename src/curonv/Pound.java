package curonv;

public class Pound extends Currency{
    public Pound(double conversionRate) {
        super("Pound", "£", "GBP");
        this.setConversionRate(conversionRate);
    }
}
