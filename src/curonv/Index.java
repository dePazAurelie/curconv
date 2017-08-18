package curonv;

public class Index {

    private String currencyCode;
    private double conversionRate;

    public Index(String currencyCode, double conversionRate) {
        this.currencyCode = currencyCode;
        this.conversionRate = conversionRate;
    }

    public String getCurrencyCode() {
        return currencyCode;
    }

    public void setCurrencyCode(String currencyCode) {
        this.currencyCode = currencyCode;
    }

    public double getConversionRate() {
        return conversionRate;
    }

    public void setConversionRate(double conversionRate) {
        this.conversionRate = conversionRate;
    }

    public Index() {
    }
}
