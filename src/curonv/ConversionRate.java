package curonv;

public class ConversionRate {

    public static void changeConversionRate (Currency currencyOrigin, Currency currencyTarget) {
        // Valentin --> cette fonction reçoit deux objet Currency, ne renvoit rien (à voir) et set la valeur du taux de conversion des deux objets en fonction le la key.

    		switch (currencyOrigin.getCurrencyCode()) {
            case "USD":
                currencyOrigin.setConversionRateUSD(1);
                break;
            case "EUR":
                currencyOrigin.setConversionRateUSD(0.850941);
                break;
            case "GBP":
                currencyOrigin.setConversionRateUSD(0.776578);
                break;
            case "YEN":
                currencyOrigin.setConversionRateUSD(108.713);
                break;
            default:
            }

        switch (currencyTarget.getCurrencyCode()) {
            case "USD":
                currencyTarget.setConversionRateUSD(1);
                break;
            case "EUR":
                currencyTarget.setConversionRateUSD(0.850941);
                break;
            case "GBP":
                currencyTarget.setConversionRateUSD(0.776578);
                break;
            case "YEN":
                currencyTarget.setConversionRateUSD(108.713);
                break;
            default:
        }
    }

    public ConversionRate() {
    }
}