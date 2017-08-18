package curonv;

import java.util.ArrayList;

public class ConversionRate {
    private ArrayList<Index> rate = new ArrayList<>();

    public void rateInit() {
        rate.add(new Index("USD", 1));
        rate.add(new Index("EUR", 0.851453));
        rate.add(new Index("GBP", 0.776578));
        rate.add(new Index("YEN", 109.066));
    }

    public ArrayList<Index> getConversionRate() {
        return rate;
    }

    public ConversionRate() {
        rateInit();
    }
}