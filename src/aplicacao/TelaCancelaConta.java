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
import modelo.Produto;

public class TelaCancelaConta extends JFrame {

	private JPanel contentPane;
	private JTextField txtIdMesa;
	private JLabel lblIdMesa;
	private JButton btnCancelar;
	private JLabel lblMensagem;
	private JLabel lblGarcom;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaCancelaConta frame = new TelaCancelaConta();
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
	public TelaCancelaConta() {
		setTitle("Cancelar Conta");
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 281, 174);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		lblIdMesa = new JLabel("Numero Mesa: ");
		lblIdMesa.setBounds(10, 14, 97, 14);
		contentPane.add(lblIdMesa);

		txtIdMesa = new JTextField();
		txtIdMesa.setBounds(105, 11, 74, 20);
		contentPane.add(txtIdMesa);
		txtIdMesa.setColumns(10);
		
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
		comboGarcom.setBounds(105, 39, 131, 20);
		contentPane.add(comboGarcom);
		
		btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try{
					int id = Integer.parseInt(txtIdMesa.getText());
					String apelidoGarcom = comboGarcom.getSelectedItem().toString();
					Fachada.verificaGarcom(apelidoGarcom, id);
					Fachada.cancelarConta(id);
					lblMensagem.setText("conta da mesa "+ id + " cancelada");
					
					txtIdMesa.setText("");
					txtIdMesa.requestFocus();
				}
				catch(Exception erro){
					lblMensagem.setText(erro.getMessage());
				}
			}
		});
		btnCancelar.setBounds(45, 87, 115, 23);
		contentPane.add(btnCancelar);
		
		lblMensagem = new JLabel("");
		lblMensagem.setBounds(0, 121, 273, 14);
		contentPane.add(lblMensagem);
		
		lblGarcom = new JLabel("Garcom: ");
		lblGarcom.setBounds(10, 42, 65, 14);
		contentPane.add(lblGarcom);
	}
}