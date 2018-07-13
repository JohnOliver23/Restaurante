package aplicacao;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.TreeMap;

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

public class TelaPedidoProduto extends JFrame {

	private JPanel contentPane;
	private JTextField txtMesa;
	private JLabel lblProd;
	private JLabel lblMesa;
	private JButton btnSolicitar;
	private JLabel lblMsg;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaPedidoProduto frame = new TelaPedidoProduto();
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
	public TelaPedidoProduto() {
		setTitle("Solicitar Produto");
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 311, 201);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		lblProd = new JLabel("Produto");
		lblProd.setBounds(10, 49, 46, 14);
		contentPane.add(lblProd);

		lblMesa = new JLabel("Mesa: ");
		lblMesa.setBounds(10, 14, 46, 14);
		contentPane.add(lblMesa);

		txtMesa = new JTextField();
		txtMesa.setBounds(72, 11, 86, 20);
		contentPane.add(txtMesa);
		txtMesa.setColumns(10);
		
		
		
		TreeMap<String, Garcom> garcoms = new TreeMap<>();
		garcoms = Fachada.listarGarcons();
		String[] array = new String[garcoms.size()];
		int i =0;
		for(Garcom g: garcoms.values()) {
		    array[i] = g.getApelido();
		    i++;
		}
		
		JComboBox comboGarcom = new JComboBox(array);
		//comboBox.setModel(new DefaultComboBoxModel<>(garcoms);
		comboGarcom.setBounds(83, 80, 131, 20);
		contentPane.add(comboGarcom);
		
		ArrayList<Produto> produtos = new ArrayList<>();
		produtos = Fachada.listarProdutos();
		String[] arrayprod = new String[produtos.size()];
	     i =0;
		for(Produto p: produtos) {
		    arrayprod[i] = p.getNome();
		    i++;
		}
		JComboBox comboProd = new JComboBox(arrayprod);
		comboProd.setSize(131, 20);
		comboProd.setLocation(72, 46);
		comboGarcom.setBounds(72, 80, 131, 20);
		contentPane.add(comboProd);
		

		
		btnSolicitar = new JButton("Solicitar");
		btnSolicitar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e1) {
				try{
					String nome = comboProd.getSelectedItem().toString();
					int id = Integer.parseInt(txtMesa.getText());
					String apelidoGarcom = comboGarcom.getSelectedItem().toString();
					Fachada.verificaGarcom(apelidoGarcom, id);
					Fachada.solicitarProduto(id, nome);
					lblMsg.setText(nome + " solicitado para a mesa " + id + " com sucesso");
					
					
					txtMesa.setText("");
					
				}
				catch(Exception e2){
					lblMsg.setText(e2.getMessage());
				}
			}
		});
		btnSolicitar.setBounds(83, 105, 115, 23);
		contentPane.add(btnSolicitar);
		
		lblMsg = new JLabel("");
		lblMsg.setBounds(10, 148, 273, 14);
		contentPane.add(lblMsg);
		
		JLabel lblGarom = new JLabel("Gar\u00E7om: ");
		lblGarom.setBounds(10, 77, 68, 14);
		contentPane.add(lblGarom);
		
		
		
		
		
	}
}