package curonv;

import java.awt.EventQueue;
import java.math.BigDecimal;
import java.math.RoundingMode;

public class Converter {
	
    public static String conversion(String strOriginValue, String strOrigin, String strTarget) {
        double nbDollar;
        double nbResult;
        double nbOrigin = Double.parseDouble(strOriginValue);
        
        if (strOrigin.equals("Currency") || strTarget.equals("Currency")) {
        	return "Please select two currencies !";
        } else {
        	Currency currencyOrigin = new Currency(strOrigin);
        	Currency currencyTarget = new Currency(strTarget);
        
        	ConversionRate.changeConversionRate(currencyOrigin, currencyTarget);

        	nbDollar = dollarConvert(nbOrigin, currencyOrigin.getConversionRateUSD());
        	nbResult = convertDollar(nbDollar, currencyTarget.getConversionRateUSD());
        	
        	nbResult = round(nbResult);
        	
        	return String.format ("%.2f", nbResult);
        }
    }

    public static double dollarConvert(double nbOrigin, double rateUSD) {
        double nbDollar;
        nbDollar = (nbOrigin/rateUSD);
        return nbDollar;
    }

    public static double convertDollar(double nbDollar, double USDrate) {
        double nbTarget;
        nbTarget = (nbDollar * USDrate);
        return nbTarget;
    }
    
    public static double round(double value) {
        BigDecimal bd = new BigDecimal(value);
        bd = bd.setScale(2, RoundingMode.HALF_UP);
        return bd.doubleValue();
    }

    public Converter() {      
        EventQueue.invokeLater(new Runnable() {
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
