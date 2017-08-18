package curonv;

public class Euro extends Currency {

    public Euro(double conversionRate) {
        super("Euro", "€", "EUR");
        this.setConversionRate(conversionRate);
    }
}
