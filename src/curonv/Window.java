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

public class Window extends JFrame {	
	private JPanel contentPane;
	private JTextField originValue;

	public Window() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1000, 450);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(15, 15, 15, 15));
		setContentPane(contentPane);
		contentPane.setLayout(new MigLayout("", "[100px][250px][100px][100px][250px][100px][100px]", "[][][100px][100px][100px][100px,grow][100px][][100px][]"));
		
		
		JLabel converterTitle = new JLabel("Currency Converter");
		converterTitle.setFont(new Font("Calibri", Font.BOLD, 36));
		converterTitle.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(converterTitle, "cell 1 0 6 1,alignx center,aligny center");
		
		JLabel converterSubTitle = new JLabel("Enter a value and pick an origin currency and a target currency.");
		converterSubTitle.setFont(new Font("Calibri", Font.ITALIC, 25));
		converterSubTitle.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(converterSubTitle, "cell 1 1 6 1,alignx center,aligny center");
		
		
		originValue = new JTextField();
		originValue.setHorizontalAlignment(SwingConstants.CENTER);
		originValue.setFont(new Font("Calibri", Font.BOLD, 30));
		originValue.setText("?");
		contentPane.add(originValue, "cell 1 3,grow");
		originValue.setColumns(10);
		
		
		JLabel originCurrency = new JLabel("Currency");
		originCurrency.setFont(new Font("Calibri", Font.BOLD, 25));
		contentPane.add(originCurrency, "cell 2 3,alignx center,aligny center");
		
		JLabel finalCurrency = new JLabel("Currency");
		finalCurrency.setForeground(new Color(199, 21, 133));
		finalCurrency.setFont(new Font("Calibri", Font.BOLD, 25));
		contentPane.add(finalCurrency, "cell 5 3,alignx center,aligny center");
		
		
		JLabel converterEqual = new JLabel("=");
		converterEqual.setHorizontalAlignment(SwingConstants.CENTER);
		converterEqual.setFont(new Font("Calibri", Font.PLAIN, 25));
		contentPane.add(converterEqual, "cell 3 3,grow");
		
		
		JLabel converterResult = new JLabel("?");
		converterResult.setForeground(new Color(199, 21, 133));
		converterResult.setBackground(Color.WHITE);
		converterResult.setHorizontalAlignment(SwingConstants.CENTER);
		converterResult.setFont(new Font("Calibri", Font.BOLD, 30));
		contentPane.add(converterResult, "cell 4 3,grow");
		
		
		JComboBox<String> comboOrigin = new JComboBox<>();
		comboOrigin.setFont(new Font("Calibri", Font.PLAIN, 25));
		for (int i = 0 ; i < CurrencyInfo.CurrencyList().size() ; i++) {
			comboOrigin.addItem(CurrencyInfo.CurrencyList().get(i));
		}
		
		comboOrigin.addActionListener (new ActionListener () {
		    public void actionPerformed(ActionEvent e) {
		        originCurrency.setText(CurrencyInfo.nameToCode((String) comboOrigin.getSelectedItem()));
		    }
		});
		
		contentPane.add(comboOrigin, "cell 0 5 3 1,grow");
		
		
		JLabel label = new JLabel("-->");
		label.setFont(new Font("Calibri", Font.BOLD, 20));
		contentPane.add(label, "cell 3 5,alignx center,aligny center");
		
		
		JComboBox<String> comboTarget = new JComboBox<>();
		comboTarget.setFont(new Font("Calibri", Font.PLAIN, 25));
		for (int i = 0 ; i < CurrencyInfo.CurrencyList().size() ; i++) {
			comboTarget.addItem(CurrencyInfo.CurrencyList().get(i));
		}
		
		comboTarget.addActionListener (new ActionListener () {
		    public void actionPerformed(ActionEvent e) {
		        finalCurrency.setText(CurrencyInfo.nameToCode((String) comboTarget.getSelectedItem()));
		    }
		});
		
		contentPane.add(comboTarget, "cell 4 5 3 1,grow");
		
		
		JLabel messageAlert = new JLabel("");
		messageAlert.setForeground(new Color(255, 0, 0));
		messageAlert.setFont(new Font("Calibri", Font.BOLD, 27));
		contentPane.add(messageAlert, "cell 0 9 7 1,alignx center,aligny center");
		
		
		JButton convertButton = new JButton("Convert !");
		convertButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String result;
				originValue.setText(originValue.getText().replace(',', '.'));
				
				if (originValue.getText().matches("[0-9]+.[0-9]+")) {
					result = Converter.conversion(originValue.getText(), originCurrency.getText(), finalCurrency.getText());
					
					if (result.matches("[0-9]+.[0-9]+")) {
						converterResult.setText(result);
						messageAlert.setText("");
					} else {
						messageAlert.setText(result);
					}
				} else {
					messageAlert.setText("Enter a numerical value !");
				}
			}
		});
		
		convertButton.setFont(new Font("Calibri", Font.BOLD, 35));
		contentPane.add(convertButton, "cell 0 7 7 1,alignx center,aligny center");
	}	
}
