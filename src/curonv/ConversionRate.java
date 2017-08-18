package curonv;

import java.io.FileNotFoundException;

import java.io.FileReader;
import java.io.IOException;
import java.util.Set;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class ConversionRate {
	
    public static void changeConversionRate (Currency currencyOrigin, Currency currencyTarget) {

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
   