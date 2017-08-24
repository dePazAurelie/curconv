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
import java.text.DateFormat;
import java.text.SimpleDateFormat;


/**
* @author de Paz
* @author Ronteix
*/
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
    
    /**
     *  Fonction se connectant à l'API distante et mettant à jours le JSON des rates. Est call une fois au lancement puis a chaque pression du bouton update.
     */
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
            
            try {
                FileWriter file = new FileWriter("live.json");

                file.write(str);
                file.flush();
                updateConversionTimestamp();
                
            } catch (IOException e) {
                e.printStackTrace();
            }
            
        } catch (FileNotFoundException e) {
        	e.printStackTrace();
        } catch (IOException e) {
        	e.printStackTrace();
        }   
    }
    
    /**
     * Fonction qui affiche et renvois le timestamp dans une String
     * @return un String à afficher
     */

    public static String updateConversionTimestamp () {
    	JSONParser parser = new JSONParser();
    	
        try {
        	JSONObject file = (JSONObject) parser.parse(new FileReader("live.json"));
        	
            java.util.Date time = new java.util.Date((long)file.get("timestamp")*1000);
            DateFormat f = new SimpleDateFormat("yyyy-MM-dd' 'HH:mm");
            return f.format(time);

        } catch (FileNotFoundException e) {
        	e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }
		return null;
    }
}
