package aplicacao;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import fachada.Fachada;
import modelo.Garcom;

public class TelaFechaConta extends JFrame {

	private JPanel contentPane;
	private JTextField txtIdMesa;
	private JLabel lblMesa;
	private JButton btnFechar;
	private JLabel lblmsg;
	private JLabel lblGarom;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaFechaConta frame = new TelaFechaConta();
					frame.setVisible(true);
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public TelaFechaConta() {
		setTitle("Fechar Conta");
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 311, 177);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		txtIdMesa = new JTextField();
		txtIdMesa.setBounds(147, 22, 67, 20);
		contentPane.add(txtIdMesa);
		txtIdMesa.setColumns(10);

		lblMesa = new JLabel("Mesa");
		lblMesa.setBounds(69, 25, 46, 14);
		contentPane.add(lblMesa);
		
		ArrayList<Garcom> garcoms = new ArrayList<>();
		garcoms = Fachada.listarGarcons();
		String[] array = new String[garcoms.size()];
		int i =0;
		for(Garcom g: garcoms) {
		    array[i] = g.getApelido();
		    i++;
		}
		JComboBox comboGarcom = new JComboBox(array);
		//comboBox.setModel(new DefaultComboBoxModel<>(garcoms);
		comboGarcom.setBounds(141, 50, 131, 20);
		contentPane.add(comboGarcom);
		
		btnFechar = new JButton("Fechar");
		btnFechar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try{
					int id = Integer.parseInt(txtIdMesa.getText());
					Fachada.fecharConta(id);
					String apelidoGarcom = comboGarcom.getSelectedItem().toString();
					Fachada.verificaGarcom(apelidoGarcom, id);
					lblmsg.setText("conta da mesa número: " + id + " fechada");
					
					txtIdMesa.setText("");
					txtIdMesa.requestFocus();
				}
				catch(Exception e2){
					lblmsg.setText(e2.getMessage());
				}
			}
		});
		btnFechar.setBounds(99, 81, 115, 23);
		contentPane.add(btnFechar);
		
		lblmsg = new JLabel("");
		lblmsg.setBounds(10, 115, 285, 21);
		contentPane.add(lblmsg);
		
		lblGarom = new JLabel("Gar\u00E7om: ");
		lblGarom.setBounds(69, 53, 67, 14);
		contentPane.add(lblGarom);
	}
}