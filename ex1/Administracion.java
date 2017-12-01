package ex1;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Administracion extends JFrame {

	private JPanel contentPane;

	public Administracion() {
		
		Adicionar Add = new Adicionar();
		Eliminar Del = new Eliminar();
		Buscar Sea = new Buscar();
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnAdicionar = new JButton("Adicionar");
		btnAdicionar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Add.setVisible(true);
				dispose();
			}
		});
		btnAdicionar.setBounds(176, 51, 89, 23);
		contentPane.add(btnAdicionar);
		
		JButton btnEliminar = new JButton("Eliminar");
		btnEliminar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Del.setVisible(true);
				dispose();
			}
		});
		btnEliminar.setBounds(176, 85, 89, 23);
		contentPane.add(btnEliminar);
		
		JButton btnBuscar = new JButton("Buscar");
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Sea.setVisible(true);
				dispose();
			}
		});
		btnBuscar.setBounds(176, 119, 89, 23);
		contentPane.add(btnBuscar);
		
		JButton btnAtras = new JButton("Salir");
		btnAtras.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnAtras.setBounds(176, 203, 89, 23);
		contentPane.add(btnAtras);
	}
}
