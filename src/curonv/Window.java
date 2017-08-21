package curonv;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;

import java.awt.Font;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import net.miginfocom.swing.MigLayout;
import java.awt.Color;

/**
 * Définit les éléments de la fenêtre et les actions a effectuer dans certains cas.
 * 
 * @author de Paz - Ronteix
 */

public class Window extends JFrame {	
	private JPanel contentPane;
	private JTextField originValue;

	/**
	 * Builder de Window : ne prend pas de paramètre et initialise tous les éléments de la fenêtre.
	 */
	public Window() {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1000, 450);							// Taille de la fenêtre
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(15, 15, 15, 15));
		setContentPane(contentPane);
		contentPane.setLayout(new MigLayout("", "[100px][250px][100px][100px][250px][100px][100px]", "[][][100px][100px][100px][100px,grow][100px][][100px][]"));
		// Taille des colonnes et des lignes contenant les éléments.
		
		
		/**
		 * Textfield où l'utilisateur indique la valeur qu'il souhaite convertir
		 */
		originValue = new JTextField();
		originValue.setHorizontalAlignment(SwingConstants.CENTER);
		originValue.setFont(new Font("Calibri", Font.BOLD, 30));
		originValue.setText("?");
		contentPane.add(originValue, "cell 1 3,grow");
		originValue.setColumns(10);
		
		/**
		 * Titre
		 */
		JLabel converterTitle = new JLabel("Currency Converter");
		converterTitle.setFont(new Font("Calibri", Font.BOLD, 36));
		converterTitle.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(converterTitle, "cell 1 0 6 1,alignx center,aligny center");
		
		/**
		 * Sous-titre
		 */
		JLabel converterSubTitle = new JLabel("Enter a value and pick an origin currency and a target currency.");
		converterSubTitle.setFont(new Font("Calibri", Font.ITALIC, 25));
		converterSubTitle.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(converterSubTitle, "cell 1 1 6 1,alignx center,aligny center");
		
		/**
		 * Affiche le code de la monnaie initiale choisie
		 */
		JLabel initialCurrency = new JLabel("Currency");
		initialCurrency.setFont(new Font("Calibri", Font.BOLD, 25));
		contentPane.add(initialCurrency, "cell 2 3,alignx center,aligny center");
		
		/**
		 * Affiche le code de la monnaie finale choisie
		 */
		JLabel finalCurrency = new JLabel("Currency");
		finalCurrency.setForeground(new Color(199, 21, 133));
		finalCurrency.setFont(new Font("Calibri", Font.BOLD, 25));
		contentPane.add(finalCurrency, "cell 5 3,alignx center,aligny center");
		
		/**
		 * Affiche le caractère "="
		 */
		JLabel converterEqual = new JLabel("=");
		converterEqual.setHorizontalAlignment(SwingConstants.CENTER);
		converterEqual.setFont(new Font("Calibri", Font.PLAIN, 25));
		contentPane.add(converterEqual, "cell 3 3,grow");
		
		/**
		 * Imprime le résultat de la conversion
		 */
		JLabel converterResult = new JLabel("?");
		converterResult.setForeground(new Color(199, 21, 133));
		converterResult.setBackground(Color.WHITE);
		converterResult.setHorizontalAlignment(SwingConstants.CENTER);
		converterResult.setFont(new Font("Calibri", Font.BOLD, 30));
		contentPane.add(converterResult, "cell 4 3,grow");
		
		/**
		 * Imprime les messages d'erreur
		 */
		JLabel messageAlert = new JLabel("");
		messageAlert.setForeground(new Color(255, 0, 0));
		messageAlert.setFont(new Font("Calibri", Font.BOLD, 27));
		contentPane.add(messageAlert, "cell 0 9 7 1,alignx center,aligny center");
		
		/**
		 * Combobox où l'utilisateur choisit la monnaie initiale.
		 * Ajout d'un listener pour mettre à jour l'affichage du JLabel initialCurrency en fonction de la monnaie sélectionnée
		 * 
		 * @see CurrencyInfo.CurrencyList()
		 */
		JComboBox<String> comboOrigin = new JComboBox<>();
		comboOrigin.setFont(new Font("Calibri", Font.PLAIN, 25));
		
		// Ajout des noms un par un en utilisant la fontion CurrencyInfo.CurrencyList()
		for (int i = 0 ; i < CurrencyInfo.CurrencyList().size() ; i++) {
			comboOrigin.addItem(CurrencyInfo.CurrencyList().get(i));
		}
		
		comboOrigin.addActionListener (new ActionListener () {
		    @Override
			public void actionPerformed(ActionEvent e) {
		        initialCurrency.setText(CurrencyInfo.nameToCode((String) comboOrigin.getSelectedItem()));
		    }
		});
		
		contentPane.add(comboOrigin, "cell 0 5 3 1,grow");
		
		/**
		 * Combobox où l'utilisateur choisit la monnaie finale.
		 * Ajout d'un listener pour mettre à jour l'affichage du JLabel finalCurrency en fonction de la monnaie sélectionnée
		 * 
		 * @see CurrencyInfo.CurrencyList()
		 */
		JLabel label = new JLabel("-->");
		label.setFont(new Font("Calibri", Font.BOLD, 20));
		contentPane.add(label, "cell 3 5,alignx center,aligny center");
		
		
		JComboBox<String> comboTarget = new JComboBox<>();
		comboTarget.setFont(new Font("Calibri", Font.PLAIN, 25));
		for (int i = 0 ; i < CurrencyInfo.CurrencyList().size() ; i++) {
			comboTarget.addItem(CurrencyInfo.CurrencyList().get(i));
		}
		
		comboTarget.addActionListener (new ActionListener () {
		    @Override
			public void actionPerformed(ActionEvent e) {
		        finalCurrency.setText(CurrencyInfo.nameToCode((String) comboTarget.getSelectedItem()));
		    }
		});
		
		contentPane.add(comboTarget, "cell 4 5 3 1,grow");
		
		/**
		 * Bouton Convert ! Ajout d'un listener
		 * 1. Test : les deux monnaie ont-elles été choisie ? si non, message d'erreur dans le JLabel messageAlert
		 * 2. Création de deux objets Currency avec les attributs des monnaies choisies + la valeur entrée la l'utilisateur pour l'un d'entre eux
		 * 3. Converter.conversion avec les deux objets.
		 * 4. On affiche le résultats.
		 * 
		 * @see Converter.conversion()
		 * @see Currency
		 */
		JButton convertButton = new JButton("Convert !");
		convertButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (!(initialCurrency.getText().equals("Currency") || finalCurrency.getText().equals("Currency"))) {
					Currency originCurrency = new Currency(initialCurrency.getText(), originValue.getText());
					Currency targetCurrency = new Currency(finalCurrency.getText(), "?");
					Converter.conversion(originCurrency, targetCurrency);
					
					// Affichage résultats
					originValue.setText(originCurrency.getStrValue());
					converterResult.setText(targetCurrency.getStrValue());
					messageAlert.setText(targetCurrency.getStrAlertValue());
					
				} else {
					messageAlert.setText("Please, select two currencies !");
				}
			}
		});
		
		convertButton.setFont(new Font("Calibri", Font.BOLD, 35));
		contentPane.add(convertButton, "cell 0 7 7 1,alignx center,aligny center");
	}	
}
