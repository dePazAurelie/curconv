package curonv;

import java.awt.EventQueue;
import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * Classe qui gère la conversion d'une monnaie à une autre.
 * 
 * @author de Paz
 * @author Ronteix
 */

public class Converter {
	
	/**
	 * Gère la conversion : prend en paramètre deux objets Currency. Récupère l'attribut strValue de originCurrency qui contient la valeur entrée par
	 * l'utilisateur et la convertie en nombre de type double après gestion des cas d'erreur : regex = strValue ne doit contenir que des chiffres ou
	 * des chiffres et un point.
	 * 
	 * Utilise l'attribut strAlertValue de Currency pour stocker les messages d'erreur et strValue pour stocker les valeurs initiale et finale.
	 * 
	 * @see Currency
	 * 
	 * @param originCurrency Monnaie d'origine
	 * @param targetCurrency Monnaie target
	 */
	
    public static void conversion(Currency originCurrency, Currency targetCurrency) {
        originCurrency.setStrValue(originCurrency.getStrValue().replace(',', '.'));			// Remplace les virgules par un point
        double nbDollar;
        double nbResult;
        
        // Test que l'utilisateur a bien entré un chiffre
        if (!originCurrency.getStrValue().matches("[0-9]+.[0-9]+") && !originCurrency.getStrValue().matches("[0-9]+")) {
        	targetCurrency.setStrAlertValue("Please, enter a numerical value !");
        	targetCurrency.setStrValue("?");
        	
        } else {
        	double nbOrigin = Double.parseDouble(originCurrency.getStrValue());				// Conversion en double

        	nbDollar = dollarConvert(nbOrigin, originCurrency.getConversionRateUSD());		// Converti en Dollar
        	nbResult = convertDollar(nbDollar, targetCurrency.getConversionRateUSD());		// Converti dans la monnaie désirée.
        	nbResult = round(nbResult);
        	
        	// Converti en String et remplace les virgules par un point
        	targetCurrency.setStrValue(String.format ("%.2f", nbResult).replace(',', '.'));
        	targetCurrency.setStrAlertValue("");
        }
    }
    
    /**
     * Première conversion en Dollar : prend en paramètre le nombre (double nbOrigin) à convertir et le taux de conversion (double) entre la monnaie
     * initiale et le Dollar. Renvoie le résultat de la convertion en Dollar (double nbDollar).
     * 
     * @param nbOrigin nombre à convertir
     * @param rateUSD taux de conversion avec le Dollar
     * @return nbDollar
     */
    public static double dollarConvert(double nbOrigin, double rateUSD) {
        double nbDollar;
        nbDollar = (nbOrigin/rateUSD);
        return nbDollar;
    }

    /**
     * Deuxième conversion du Dollar vers la monnaie finale.
     * prend en paramètre le nombre (double nbDollar) en Dollar à convertir et le taux de conversion (double) entre la monnaie finale et le Dollar.
     * Renvoie le résultat de la convertion dans la monnaie finale (double nbTarget).
     * 
     * @param nbDollar Nombre en Dollar
     * @param USDrate Taux de conversion entre le Dollar et la monnaie choisie
     * @return nbTarget
     */
    public static double convertDollar(double nbDollar, double USDrate) {
        double nbTarget;
        nbTarget = (nbDollar * USDrate);
        return nbTarget;
    }
    
    /**
     * Arrondi à la deuxième décimale le nombre passé en paramètre.
     * 
     * @param value valeur à arrondir
     * @return rounded value
     */
    
    public static double round(double value) {
        BigDecimal bd = new BigDecimal(value);
        bd = bd.setScale(2, RoundingMode.HALF_UP);
        return bd.doubleValue();
    }

    /**
     * Builer de Converter : Lance la fenêtre window pour interagir avec l'utilisateur.
     * Ne prend pas de paramètre.
     */
    public Converter() {
    	ConversionRate.updateConversionRate();
        EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				try {
					Window frame = new Window();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});        
    }
}
