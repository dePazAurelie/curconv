package curonv;

public class Converter {
    private ConversionRate conversionRate = new ConversionRate();

    public void conversion(double nbOrigin, String strOrigin, String strTarget) {
        Currency currencyOrigin = makeCurrency(strOrigin);
        Currency currencyTarget = makeCurrency(strTarget);




    }

    public Currency makeCurrency(String str) {
        switch (str) {
            case "USD":
                return new Currency("Dollar", "$", "USD") {
                };
            case "EUR":
                return new Currency("Euro", "€", "EUR") {
                };
            case "GBP":
                return new Currency("Pound", "£", "GBP");
            case "YEN":
                return new Currency("Yen", "¥", "YEN");
            default:
                return null;
        }
    }

    public Converter(double nbOrigin, String currencyOrigin, String currencyTarget) {
        conversion(nbOrigin, currencyOrigin, currencyTarget);
    }
}
