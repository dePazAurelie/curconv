package curonv;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Set;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class CurrencyInfo {

    public static String CurrencyName (String arg) {

        JSONParser parser = new JSONParser();

        try {
        	
            JSONObject file = (JSONObject) parser.parse(new FileReader("money-info.json"));
            JSONObject currencyId = (JSONObject) file.get(arg);
            
            return ((String) (currencyId.get("name")));

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }
	return "Error";

    }
    
    public static ArrayList<String> CurrencyList () {

        JSONParser parser = new JSONParser();
        ArrayList<String> currencyList = new ArrayList<>();

        try {
        	
            JSONObject file = (JSONObject) parser.parse(new FileReader("money-info.json"));
            
            for (Object key : file.keySet()) {
                String keyStr = (String)key;
                currencyList.add(keyStr);
            }
            
            return (ArrayList<String>) currencyList;

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }
		return null;
    }
    
    public static String CurrencySymbol(String arg) {
        JSONParser parser = new JSONParser();

        try {
        	
            JSONObject file = (JSONObject) parser.parse(new FileReader("money-info.json"));
            JSONObject currencyId = (JSONObject) file.get(arg);
		
            return ((String) (currencyId.get("symbol_native")));

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }
		return "Null";
    }
	
}
