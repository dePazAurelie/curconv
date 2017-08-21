package curonv;

/**
 * Permet de créer des objets Currency
 * 
 * @author de Paz
 * @author Ronteix
 */
public class Currency {
    private String name;
    private String symbol;
    private String currencyCode;
    private double conversionRateUSD;
    private String strValue;				// Utilisé dans Converter pour sauvegarder la valeur entrée par l'utilisateur et le résultat de la conversion.
    private String strAlertValue;			// Utilisé dans Converter pour sauvegarder les messages d'erreur générés par les tests.

    /**
     * Créé un objet Currency avec un nom (name), un currencyCode, un Symbole (symbol) et un taux de conversion par rapport au Dollar.
     * 
     * @param currencyCode String de trois lettres représentant le currency code de la monnaie
     * @param strValue Valeur initiale (ou finale) entrée par l'utilisateur (ou calculée lors de la conversion) utilisée dans le Converter.
     */
    
	public Currency(String currencyCode, String strValue) {
    	this.name = CurrencyInfo.CurrencyName(currencyCode);
        this.symbol = CurrencyInfo.CurrencySymbol(currencyCode);
        this.currencyCode = currencyCode;
        ConversionRate.changeConversionRate(this);
        this.strValue = strValue;
        strAlertValue = "";
    }

    public String getName() {
        return name;
    }

    public String getSymbol() {
        return symbol;
    }

    public String getCurrencyCode() {
        return currencyCode;                                            
    }

    public double getConversionRateUSD() {
        return conversionRateUSD;
    }

    protected void setConversionRateUSD(double conversionRateUSD) {
        this.conversionRateUSD = conversionRateUSD;
    }

	public String getStrValue() {
		return strValue;
	}

	public void setStrValue(String strValue) {
		this.strValue = strValue;
	}

	public String getStrAlertValue() {
		return strAlertValue;
	}

	public void setStrAlertValue(String strAlertValue) {
		this.strAlertValue = strAlertValue;
	}
}
