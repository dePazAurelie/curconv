package curonv;

public class ConversionRate {

    public void changeConversionRate (Currency currency) {
        switch (currency.getCurrencyCode()) {
            case "USD":
                currency.setConversionRateUSD(1);
                break;
            case "EUR":
                currency.setConversionRateUSD(0.850941);
                break;
            case "GBP":
                currency.setConversionRateUSD(0.776578);
                break;
            case "YEN":
                currency.setConversionRateUSD(108.713);
                break;
            default:
        }
    }

    public ConversionRate() {
    }
}