package curonv;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

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
    
    public static void updateConversionRate () {
        JSONParser parser = new JSONParser();

        try {         
            URL oracle = new URL("http://apilayer.net/api/live?access_key=f63bce189d18f99578accd94d5ecda6a"); // URL to Parse
            URLConnection yc = oracle.openConnection();
            BufferedReader in = new BufferedReader(new InputStreamReader(yc.getInputStream()));
            
            String str = "";
            String buff = "";
            while ((buff = in.readLine()) != null) {
            		str += buff;
            }
           in.close();
            System.out.println(str);
            
            try (FileWriter file = new FileWriter("live.json")) {

                file.write(str);
                file.flush();
                
            } catch (IOException e) {
                e.printStackTrace();
            }
            
    } catch (FileNotFoundException e) {
        e.printStackTrace();
    } catch (IOException e) {
        e.printStackTrace();
    }   
}
}
