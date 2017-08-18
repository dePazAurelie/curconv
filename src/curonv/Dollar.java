package curonv;

public class Dollar extends Currency{

    public Dollar(double conversionRate) {
        super("Dollar", "$", "USD");
        this.setConversionRate(conversionRate);
    }
}
