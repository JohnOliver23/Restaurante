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
import modelo.Conta;
import modelo.Garcom;

public class TelaCriarConta extends JFrame {

	private JPanel contentPane;
	private JTextField txtIdMesa;
	private JLabel lblIdMesa;
	private JButton btnCriar;
	private JLabel lblMsg;

	public TelaCriarConta() {
		setTitle("Por favor, crie sua conta!!");
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 299, 177);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		txtIdMesa = new JTextField();
		txtIdMesa.setBounds(94, 11, 86, 20);
		contentPane.add(txtIdMesa);
		txtIdMesa.setColumns(10);

		lblIdMesa = new JLabel("Id Mesa");
		lblIdMesa.setBounds(10, 14, 74, 14);
		contentPane.add(lblIdMesa);
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
		comboGarcom.setBounds(94, 42, 131, 20);
		contentPane.add(comboGarcom);
		
		btnCriar = new JButton("Criar");
		btnCriar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try{
					int id = Integer.parseInt(txtIdMesa.getText());
					String apelidoGarcom = comboGarcom.getSelectedItem().toString();
					Fachada.verificaGarcom(apelidoGarcom, id);
					Conta c = Fachada.criarConta(id);
					lblMsg.setText("conta nº "+ c.getNumero() + " da mesa  " + id + " está aberta!");
					
					txtIdMesa.setText("");
					txtIdMesa.requestFocus();
				}
				catch(Exception erro){
					lblMsg.setText(erro.getMessage());

				}
			}
		});
		btnCriar.setBounds(77, 73, 115, 23);
		contentPane.add(btnCriar);
		
		lblMsg = new JLabel("");
		lblMsg.setBounds(25, 107, 233, 14);
		contentPane.add(lblMsg);
		
		JLabel lblGarcom = new JLabel("Garcom:");
		lblGarcom.setBounds(10, 45, 74, 14);
		contentPane.add(lblGarcom);
	}
}
