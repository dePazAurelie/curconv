package curonv;

public class ConversionRate {

    public void changeConversionRate (Currency currencyOrigin, Currency currencyTarget) {
        // Valentin --> cette fonction reçoit deux objet Currency, ne renvoit rien (à voir) et set la valeur du taux de conversion des deux objets en fonction le la key.
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