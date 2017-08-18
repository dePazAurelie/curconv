package curonv;
import java.util.ArrayList;

public class Converter {
    private ConversionRate conversionRate = new ConversionRate();
    private ArrayList<Index> tableConversion = conversionRate.getConversionRate();

    public void conversion(double nbOrigin, String strOrigin, String strTarget) {
        Currency currencyOrigin = makeCurrency(strOrigin);
        Currency currencyTarget = makeCurrency(strTarget);



    }

    public Currency makeCurrency(String str) {
        switch (str) {
            case "USD":
                return new Dollar();
            case "EUR":
                return new Euro();
            case "GBP":
                return new Pound();
            case "YEN":
                return new Yen();
            default:
                return null;
        }
    }

    public Converter(double nbOrigin, String currencyOrigin, String currencyTarget) {
        conversion(nbOrigin, currencyOrigin, currencyTarget);
    }
}
