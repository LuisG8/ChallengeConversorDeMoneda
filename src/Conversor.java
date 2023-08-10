import java.awt.EventQueue;
import java.util.LinkedList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Color;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Conversor extends JFrame {

	private JPanel contentPane;
	private JComboBox comboBox;
	private JLabel lblNewLabel;
	private JButton btnNewButton;
	private JButton btnCancel;
	private Conversor selfReference;
	
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Conversor frame = new Conversor();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Conversor() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 319, 158);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(240, 240, 240));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Conversor de moneda"}));
		comboBox.setBounds(45, 46, 219, 25);
		contentPane.add(comboBox);
		
		lblNewLabel = new JLabel("Seleccione una opción de conversor");
		lblNewLabel.setBounds(45, 11, 219, 14);
		contentPane.add(lblNewLabel);
		
		btnNewButton = new JButton("OK");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//String seleccion = (String) comboBox.getSelectedItem();
				MainConversor conversor = new MainConversor(selfReference);
				conversor.setVisible(true);
				selfReference.setVisible(false);
			}
		});
		btnNewButton.setBounds(55, 82, 89, 23);
		contentPane.add(btnNewButton);
		
		btnCancel = new JButton("Cancel");
		btnCancel.setBounds(154, 82, 89, 23);
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//String seleccion = (String) comboBox.getSelectedItem();
				selfReference.dispose();
			}
		});
		contentPane.add(btnCancel);
		selfReference = this;
	}
}
