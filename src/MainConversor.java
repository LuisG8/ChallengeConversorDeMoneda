import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;

public class MainConversor extends JFrame {

	private JPanel contentPane;
	private JButton btn;
	private JButton btnCancelar;
	private JLabel lblNewLabel;
	private MainConversor selfReference;
	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					MainConversor frame = new MainConversor();
//					frame.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}

	/**
	 * Create the frame.
	 */
	public MainConversor(Conversor con) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 446, 160);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lblNewLabel = new JLabel("Ingrese la cantidad que desea convertir");
		lblNewLabel.setBounds(112, 11, 269, 14);
		contentPane.add(lblNewLabel);
		
		JTextField textField = new JTextField();
		textField.setBounds(137, 42, 152, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		btn = new JButton("Listo");
		btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//String seleccion = (String) comboBox.getSelectedItem();
//				MainConversor conversor = new MainConversor();
//				conversor.setVisible(true);
				selfReference.setVisible(false);
				
				try {
					Opciones opciones = new Opciones(convertirANumero(textField.getText()), selfReference);
					
					opciones.setVisible(true);
					selfReference.setVisible(false);
				} catch (ValorNoEsNumeroException exc) {
		            System.err.println("Error: El valor no es un número válido");
		            exc.printStackTrace();
		        }
				
			}
		});
		btn.setBounds(90, 73, 89, 23);
		contentPane.add(btn);
		
		btnCancelar = new JButton("Cancelar");
		btnCancelar.setBounds(245, 73, 89, 23);
		contentPane.add(btnCancelar);
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//String seleccion = (String) comboBox.getSelectedItem();
//				MainConversor conversor = new MainConversor();
//				conversor.setVisible(true);
				selfReference.dispose();
				
				con.setVisible(true);
			}
		});
		selfReference = this;
	}
	 public static float convertirANumero(String valor) throws ValorNoEsNumeroException {
	        try {
	            return Float.parseFloat(valor);
	        } catch (NumberFormatException e) {
	            throw new ValorNoEsNumeroException(valor);
	        }
	    }


}
