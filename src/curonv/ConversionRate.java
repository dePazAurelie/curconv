package curonv;

import jdk.nashorn.internal.parser.JSONParser;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;

import java.io.FileNotFoundException;

import java.io.FileReader;
import java.io.IOException;
import java.util.Set;

public class ConversionRate {
	
    public static void changeConversionRate (Currency currencyOrigin, Currency currencyTarget) {

            JSONParser parser = new JSONParser();

            try {
            	
                JSONObject file = (JSONObject) parser.parse(new FileReader("live.json"));
                JSONObject quotes = (JSONObject) file.get("quotes");
                Set<String> set = quotes.keySet();

                currencyOrigin.setConversionRateUSD((double) quotes.get("USD" + currencyOrigin.getCurrencyCode()));
                currencyTarget.setConversionRateUSD((double) quotes.get("USD" + currencyTarget.getCurrencyCode()));
                  
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
   