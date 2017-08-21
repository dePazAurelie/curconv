package curonv;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

/**
 * Ensemble de fonctions qui permettent d'extraire du fichier JSon les infos concernant les monnaies 
 * 
 * @author de Paz
 * @author Ronteix
 */
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
    
    /**
     * Fonction qui permet de trouver dans le fichier JSON le currency code à partir du nom de la monnaie.
     * prend en paramètre le nom de la monnaie, renvoie un string currency code.
     * Utilisé dans Window pour mettre à jour les JLabel.
     * 
     * @see Window
     * @param name nom de la monnaie
     * @return String keyStr key qui correspond au nom : Currency code
     */
    public static String nameToCode(String name) {
		JSONParser parser = new JSONParser();

        try {
        	JSONObject file = (JSONObject) parser.parse(new FileReader("money-info.json"));
        	for (Object key : file.keySet()) {
                String keyStr = (String)key;
                JSONObject currencyId = (JSONObject) file.get(keyStr);
                
                if (((String) currencyId.get("name")).equals(name)) {
                	return (keyStr);
                }
            }
            return null;

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }
		return "Error";		
	}
    
    /**
     * Fonction qui créé un array de tous les noms de monnaie contenu dans le fichier JSON
     * Utilisé dans Window pour mettre à jour les Combobox.
     *
     * @see Window
     * @return un array de String qui contient tous les noms de monnaie issus du fichier JSON
     */
	public static ArrayList<String> CurrencyList () {
        JSONParser parser = new JSONParser();
        ArrayList<String> currencyList = new ArrayList<>();

        try {
            JSONObject file = (JSONObject) parser.parse(new FileReader("money-info.json"));
            
            for (Object key : file.keySet()) {				// Boucle sur toutes les key et enregistre le nom dans un array
                String keyStr = (String)key;
                JSONObject currencyId = (JSONObject) file.get(keyStr);
                currencyList.add((String) currencyId.get("name"));
            }
            
            currencyList.sort(String::compareToIgnoreCase);
            return currencyList;

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
