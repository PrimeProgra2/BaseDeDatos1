package ex1;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;

public class Ventana extends JFrame {

	private JPanel contentPane;

	public Ventana() {
		
		Administracion Adm = new Administracion();
		Formulario Form = new Formulario();
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu Anadir = new JMenu("Administracion");
		menuBar.add(Anadir);
		
		JMenuItem Adicionar = new JMenuItem("Adicionar");
		Adicionar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Adicionar add1 = new Adicionar();
				add1.setVisible(true);
				dispose();
			}
		});
		Anadir.add(Adicionar);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("Eliminar\r\n");
		mntmNewMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Eliminar del = new Eliminar();
				del.setVisible(true);
				dispose();
			}
		});
		Anadir.add(mntmNewMenuItem);
		
		JMenuItem mntmBuscar = new JMenuItem("Buscar");
		mntmBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Buscar buss = new Buscar();
				buss.setVisible(true);
				dispose();
			}
		});
		Anadir.add(mntmBuscar);
		
		JMenu mnNewMenu = new JMenu("Formulario");
		menuBar.add(mnNewMenu);
		
		JMenuItem mntmCrear = new JMenuItem("Crear");
		mntmCrear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Formulario formm = new Formulario();
				formm.setVisible(true);
				dispose();
			}
		});
		mnNewMenu.add(mntmCrear);
		
		JMenu mnOpciones = new JMenu("Opciones");
		menuBar.add(mnOpciones);
		
		JMenuItem mntmAtras = new JMenuItem("Atras");
		mntmAtras.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Ventana v= new Ventana();
				v.setVisible(true);
				dispose();
			}
		});
		mnOpciones.add(mntmAtras);
		
		JMenuItem mntmSalir = new JMenuItem("Salir");
		mntmSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
			}
		});
		mnOpciones.add(mntmSalir);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblSupermercadoPrime = new JLabel("SUPERMERCADO PRIME");
		lblSupermercadoPrime.setFont(new Font("Tw Cen MT", Font.PLAIN, 25));
		lblSupermercadoPrime.setBounds(93, 90, 254, 46);
		contentPane.add(lblSupermercadoPrime);
		
		JButton salir = new JButton("Salir");
		salir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
			}
		});
		salir.setBounds(149, 164, 128, 23);
		contentPane.add(salir);
	}
}
