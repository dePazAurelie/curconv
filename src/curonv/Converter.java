package curonv;

public class Converter {

    public void conversion(double nbOrigin, String strOrigin, String strTarget) {
        double nbTarget;
        double nbDollar;
        Currency currencyOrigin = makeCurrency(strOrigin);
        Currency currencyTarget = makeCurrency(strTarget);
        ConversionRate.changeConversionRate(currencyOrigin, currencyTarget);

        nbDollar = dollarConvert(nbOrigin, currencyOrigin.getConversionRateUSD());
        nbTarget = convertDollar(nbDollar, currencyTarget.getConversionRateUSD());

        System.out.println(nbOrigin + " " + currencyOrigin.getSymbol() + " = " + nbDollar + " $ = " + nbTarget + " " + currencyTarget.getSymbol());
    }

    public double dollarConvert(double nbOrigin, double rateUSD) {
        double nbDollar;
        nbDollar = (nbOrigin/rateUSD);
        return nbDollar;
    }

    public double convertDollar(double nbDollar, double USDrate) {
        double nbTarget;
        nbTarget = (nbDollar * USDrate);
        return nbTarget;
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
