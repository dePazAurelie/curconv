package curonv;

public class Converter {

    public void conversion(double nbOrigin, String strOrigin, String strTarget) {
        double nbTarget;
        double nbDollar;
        Currency currencyOrigin = new Currency(strOrigin);
        Currency currencyTarget = new Currency(strTarget);
        
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

    public Converter(double nbOrigin, String currencyOrigin, String currencyTarget) {
        conversion(nbOrigin, currencyOrigin, currencyTarget);
    }
}