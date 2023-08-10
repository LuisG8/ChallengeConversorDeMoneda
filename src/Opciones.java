import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Opciones extends JFrame {

	private JPanel contentPane;
	private float valor;
	private int opcion;
	private JButton btn;
	private JButton btnCancelar;
	private Opciones selfReference;
	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					Opciones frame = new Opciones();
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
	public Opciones(Float valor, MainConversor main) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 387, 197);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		this.valor=valor;
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"De Pesos a Dólar", "De Pesos a Euro", "De Pesos a Libras", "De Pesos a Yen", "De Pesos a Won Coreano", "De Dólar a Pesos", "De Euro a Pesos", "De Libras a Pesos"}));
		comboBox.setBounds(110, 68, 151, 22);
		contentPane.add(comboBox);
		
		
		
		JLabel lblNewLabel = new JLabel("Elige una moneda a la que deseas convertir");
		lblNewLabel.setBounds(72, 28, 243, 14);
		contentPane.add(lblNewLabel);
		
		btn = new JButton("Listo");
		btn.setBounds(50, 101, 89, 23);
		contentPane.add(btn);
		btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Resultado res = new Resultado(comboBox.getSelectedIndex(), valor, selfReference);
				selfReference.setVisible(false);
				res.setVisible(true);
			}
		});
		
		btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnCancelar.setBounds(215, 101, 89, 23);
		contentPane.add(btnCancelar); 
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				selfReference.dispose();
				main.setVisible(true);
			}
		});
		selfReference=this;
	}
}
