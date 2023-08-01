package co.com.Conversor_Monedas.clases;

import java.awt.EventQueue;
import co.com.Conversor_Monedas.enums.*;

import javax.swing.JFrame;
import java.awt.GridLayout;
import java.awt.BorderLayout;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.math.BigDecimal;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;
import javax.swing.JCheckBox;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import javax.swing.JTextField;
import java.awt.Insets;
import javax.swing.JLabel;
import javax.swing.JToggleButton;
import javax.swing.JList;
import javax.swing.JComboBox;
import javax.swing.JScrollPane;
import javax.swing.BoxLayout;
import javax.swing.JPanel;
import javax.swing.DefaultComboBoxModel;

public class interfaz {

	private JFrame frame;
	private JTextField Entry_Valor;
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_2;
	private JLabel Resultado;
	private JLabel lblNewLabel_4;
	private JComboBox Moneda_Cambio;

	/**
	 * Launch the application.
	 */


	/**
	 * Create the application.
	 */
	public interfaz() {
		
	
	}

	/**
	 * Initialize the contents of the frame.
	 * @wbp.parser.entryPoint
	 */
	public void initialize() {
		Computo.initExchangeRates();
		frame = new JFrame();
		frame.getContentPane().setLayout(null);
		frame.setBounds(268, 36, 504, 293);
		funcionalidad();
		frame.setVisible(true);
		
		
	}
	private void funcionalidad() {
		Entry_Valor = new JTextField();
		Entry_Valor.setBounds(24, 39, 163, 30);
		frame.getContentPane().add(Entry_Valor);
		Entry_Valor.setColumns(10);
		
		JComboBox<Nombre_Monedas> Moneda_Cambio = new JComboBox<Nombre_Monedas>(Nombre_Monedas.values());
		Moneda_Cambio.setBounds(333, 133, 145, 30);
		frame.getContentPane().add(Moneda_Cambio);
		
		JComboBox<Nombre_Monedas> Moneda_Actual = new JComboBox<Nombre_Monedas>(Nombre_Monedas.values());
		Moneda_Actual.setBounds(333, 43, 145, 26);
		frame.getContentPane().add(Moneda_Actual);
		
		
		
		
		JLabel lblNewLabel = new JLabel("Valor");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(48, 11, 107, 30);
		frame.getContentPane().add(lblNewLabel);
		
		lblNewLabel_1 = new JLabel("Moneda Actual");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(339, 11, 107, 30);
		frame.getContentPane().add(lblNewLabel_1);
		
		lblNewLabel_2 = new JLabel("Cambio");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setBounds(48, 89, 107, 30);
		frame.getContentPane().add(lblNewLabel_2);
		
		Resultado = new JLabel("Resultado");
		Resultado.setHorizontalAlignment(SwingConstants.CENTER);
		Resultado.setBounds(24, 133, 163, 30);
		frame.getContentPane().add(Resultado);
		
		lblNewLabel_4 = new JLabel("Moneda Cambio");
		lblNewLabel_4.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_4.setBounds(339, 89, 107, 30);
		frame.getContentPane().add(lblNewLabel_4);
		
		
		JButton Boton_Convertir = new JButton("Convert");
		Boton_Convertir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				BigDecimal Cantidad = BigDecimal.valueOf(Double.parseDouble(Entry_Valor.getText()));
				BigDecimal Resul = Computo.convert((Nombre_Monedas)Moneda_Actual.getSelectedItem(),(Nombre_Monedas) Moneda_Cambio.getSelectedItem(), Cantidad);
				Resultado.setText(Resul.toString());
				
			}
		});
		
		
		Boton_Convertir.setBounds(195, 190, 107, 37);
		frame.getContentPane().add(Boton_Convertir);
		
		
	}
}
