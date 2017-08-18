package curonv;

import java.util.ArrayList;

public class ConversionRate {
    private ArrayList<Currency> conversionRate = new ArrayList<>();

    public void conversionRate() {
            conversionRate.add(new Dollar(1));
            conversionRate.add(new Euro(0.851051));
            conversionRate.add(new Pound(0.775389));
            conversionRate.add(new Yen(109.066));
    }
}
