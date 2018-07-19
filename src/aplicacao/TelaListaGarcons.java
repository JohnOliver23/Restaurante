package aplicacao;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.TreeMap;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.ScrollPaneConstants;
import javax.swing.border.EmptyBorder;

import fachada.Fachada;
import modelo.Garcom;
import modelo.Mesa;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JList;
import javax.swing.JLabel;

public class TelaListaGarcons extends JFrame {

	private JPanel contentPane;
	private JButton btnListar;
	private DefaultListModel listModel = new DefaultListModel();

	
	public TelaListaGarcons() {
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowOpened(WindowEvent arg0) {
				btnListar.doClick();
			}
		});
		setTitle("Listar Garçons");
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 550, 290);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JList list = new JList();
		list.setBounds(10, 23, 339, 206);
		contentPane.add(list);
		
		JButton btnNewButton = new JButton("Adicionar");
		btnNewButton.setBounds(413, 34, 89, 23);
		contentPane.add(btnNewButton);
		
		JLabel lblGarcons = new JLabel("Listagem de Gar\u00E7ons: ");
		lblGarcons.setBounds(10, 0, 264, 14);
		contentPane.add(lblGarcons);
		
		btnListar = new JButton("Listar");
		btnListar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e1) {
				try{
					String texto;
					int i =0;
					TreeMap<String, Garcom> listaGarcons = Fachada.listarGarcons();
					
					if (listaGarcons.isEmpty())
						 lblGarcons.setText("O restaurante não possui garçons cadastrados \n");
					else 	
						
						for(Garcom g: listaGarcons.values()) {
							listModel.add(i, g);
							i++;
						}
					
					list.setModel(listModel);
				}
				catch(Exception e2){
					JOptionPane.showMessageDialog(null, e2.getMessage());
				}
			}
		});
		
		JButton btnRemove = new JButton("Remover");
		btnRemove.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try{
					Garcom g = (Garcom) list.getSelectedValue();
					Fachada.excluirGarcom(g.getApelido());
					JOptionPane.showMessageDialog(null, "Garcon excluido com Sucesso");
					listModel.clear();
					list.setModel(listModel);
					int i =0;
					TreeMap<String, Garcom> listaGarcons = Fachada.listarGarcons();
					if (listaGarcons.isEmpty())
						 lblGarcons.setText("O restaurante não possui garçons cadastrados \n");
					else 	
						for(Garcom g1: listaGarcons.values()) {
							listModel.add(i, g1);
							i++;
						}
					
					list.setModel(listModel);
					
					
				}
				catch(Exception e2){
					JOptionPane.showMessageDialog(null, e2.getMessage());
				}				
			}
			
		});
		btnRemove.setBounds(413, 68, 89, 23);
		contentPane.add(btnRemove);
		

		

		

	}
}
