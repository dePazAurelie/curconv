package curonv;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class ConversionRate {
	
	// Ne prends plus qu'un paramètre, est appelé dans le builder de Currency (plus efficace)
    public static void changeConversionRate (Currency currency) {
    	JSONParser parser = new JSONParser();
    	
        try {
        	JSONObject file = (JSONObject) parser.parse(new FileReader("live.json"));
            JSONObject quotes = (JSONObject) file.get("quotes");
            
            currency.setConversionRateUSD(Double.parseDouble(quotes.get("USD" + currency.getCurrencyCode()).toString()));

        } catch (FileNotFoundException e) {
        	e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }
}
