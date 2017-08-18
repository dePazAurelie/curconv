package curonv;

public abstract class Currency {
    private String name;
    private String symbol;
    private String currencyCode;
    private double conversionRate;


    public Currency(String name, String symbol, String currencyCode) {
        this.name = name;
        this.symbol = symbol;
    }

    public String getName() {
        return name;
    }

    public String getSymbol() {
        return symbol;
    }

    public String getCurrencyCode() {
        return currencyCode;
    }

    public double getConversionRate() {
        return conversionRate;
    }

    public void setConversionRate(double conversionRate) {
        this.conversionRate = conversionRate;
    }
}