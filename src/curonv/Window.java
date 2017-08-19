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

public class Window extends JFrame {	
	private JPanel contentPane;
	private JTextField originValue;

	public Window() {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1000, 325);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(15, 15, 15, 15));
		setContentPane(contentPane);
		contentPane.setLayout(new MigLayout("", "[100px][250px][100px][100px][250px][100px][100px]", "[][][100px][100px][100px][100px,grow][100px][]"));
		
		
		JLabel converterTitle = new JLabel("Currency Converter");
		converterTitle.setFont(new Font("Calibri", Font.BOLD, 36));
		converterTitle.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(converterTitle, "cell 1 0 6 1,alignx center,aligny center");
		
		
		JLabel converterSubTitle = new JLabel("Enter a value and pick an origin currency and a target currency.");
		converterSubTitle.setFont(new Font("Calibri", Font.ITALIC, 20));
		converterSubTitle.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(converterSubTitle, "cell 1 1 6 1,alignx center,aligny center");
		
		
		originValue = new JTextField();
		originValue.setHorizontalAlignment(SwingConstants.CENTER);
		originValue.setFont(new Font("Calibri", Font.BOLD, 30));
		originValue.setText("?");
		contentPane.add(originValue, "cell 1 3,grow");
		originValue.setColumns(10);
		
		
		JLabel originCurrency = new JLabel("Currency");
		originCurrency.setFont(new Font("Calibri", Font.PLAIN, 20));
		contentPane.add(originCurrency, "cell 2 3,alignx center,aligny center");
		
		JLabel finalCurrency = new JLabel("Currency");
		finalCurrency.setFont(new Font("Calibri", Font.PLAIN, 20));
		contentPane.add(finalCurrency, "cell 5 3,alignx center,aligny center");
		
		
		JLabel converterEqual = new JLabel("=");
		converterEqual.setHorizontalAlignment(SwingConstants.CENTER);
		converterEqual.setFont(new Font("Calibri", Font.PLAIN, 25));
		contentPane.add(converterEqual, "cell 3 3,grow");
		
		
		JLabel converterResult = new JLabel("?");
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
		
		JButton convertButton = new JButton("Convert !");
		convertButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (!(originValue.getText().equals("?"))) {
					converterResult.setText(Converter.conversion(originValue.getText(), originCurrency.getText(), finalCurrency.getText()));
				} else {
					converterResult.setText("Enter Value !");
				}
			}
		});		
		convertButton.setFont(new Font("Calibri", Font.BOLD, 35));
		contentPane.add(convertButton, "cell 0 7 7 1,alignx center,aligny center");
	}	
}
