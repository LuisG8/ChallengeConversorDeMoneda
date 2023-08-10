import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JButton;

public class Resultado extends JFrame {

	private JPanel contentPane;
	private JLabel lblNewLabel;
	private JButton btn;
	private Resultado selfReference;

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					Resultado frame = new Resultado();
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
	public Resultado(Integer val, Float cantidad, Opciones op) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 284, 169);
		
		// Inicializa el contentPane y configura el layout.
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lblNewLabel = new JLabel("Tienes: ");
		lblNewLabel.setBounds(49, 26, 150, 14); // Ajusta las coordenadas para alinear el JLabel.
		contentPane.add(lblNewLabel);
		
		// Configura el JButton.
		btn = new JButton("Listo");
		btn.setBounds(81, 75, 89, 23);
		btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				selfReference.dispose();
				op.setVisible(true);
			}
		});
		contentPane.add(btn);
		
		int valor = val;
		
		switch(valor) {
		case 0:
			lblNewLabel.setText("Tienes: "+ cantidad*0.059);
			break;
		case 1:
			lblNewLabel.setText("Tienes: "+ cantidad*0.053);
			break;
		case 2:
			lblNewLabel.setText("Tienes: "+ cantidad*0.046);
			break;
		case 3:
			lblNewLabel.setText("Tienes: "+ cantidad*8.43);
			break;
		case 4:
			lblNewLabel.setText("Tienes: "+ cantidad*77.19);
			break;
		case 5:
			lblNewLabel.setText("Tienes: "+ cantidad*17.07);
			break;
		case 6:
			lblNewLabel.setText("Tienes: "+ cantidad*18.72);
			break;
		case 7:
			lblNewLabel.setText("Tienes: "+ cantidad*21.70);
			break;
		}
		
		selfReference = this;
	}

}
