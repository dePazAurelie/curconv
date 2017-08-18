package curonv;

import java.io.FileNotFoundException;

import java.io.FileReader;
import java.io.IOException;
import java.util.Set;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class ConversionRate {

<<<<<<< HEAD
    public void changeConversionRate (Currency currencyOrigin, Currency currencyTarget) {

            JSONParser parser = new JSONParser();

            try {
            	
                JSONObject file = (JSONObject) parser.parse(new FileReader("live.json"));
                JSONObject quotes = (JSONObject) file.get("quotes");
                Set<String> set = quotes.keySet();
                
                
                currencyOrigin.setConversionRateUSD((Double) quotes.get(currencyOrigin.getCurrencyCode()));
                currencyTarget.setConversionRateUSD((Double) quotes.get(currencyTarget.getCurrencyCode()));
                  
                //System.out.println("key: " + key + " // value: " + quotes.get(key));

            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            } catch (ParseException e) {
                e.printStackTrace();
            }

        }
}
    	
    		/* switch (currency.getCurrencyCode()) {
=======
    public static void changeConversionRate (Currency currencyOrigin, Currency currencyTarget) {
        // Valentin --> cette fonction reçoit deux objet Currency, ne renvoit rien (à voir) et set la valeur du taux de conversion des deux objets en fonction le la key.

    		switch (currencyOrigin.getCurrencyCode()) {
>>>>>>> branch 'beta' of https://github.com/vyrtualsynthese/curconv.git
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
<<<<<<< HEAD
=======
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
>>>>>>> branch 'beta' of https://github.com/vyrtualsynthese/curconv.git
        }
    }

    public ConversionRate() {
    }
}*/