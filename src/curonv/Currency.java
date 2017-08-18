package curonv;

public abstract class Currency {
    private String name;
    private String symbol;
    private String currencyCode;


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
}