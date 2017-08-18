package curonv;

public class Currency {
    private String name;
    private String symbol;
    private String currencyCode;
    private double conversionRateUSD;


    public Currency(String name, String symbol, String currencyCode) {
        this.name = name;
        this.symbol = symbol;
        this.currencyCode = currencyCode;
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

    public double getConversionRateUSD() {
        return conversionRateUSD;
    }

    protected void setConversionRateUSD(double conversionRateUSD) {
        this.conversionRateUSD = conversionRateUSD;
    }
}