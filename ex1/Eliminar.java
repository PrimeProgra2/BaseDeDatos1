package ex1;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.Statement;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.DriverManager;
import java.awt.event.ActionEvent;

public class Eliminar extends JFrame {

	private JPanel contentPane;
	private JTextField codigo;
	private JButton btnSalir;
	private JButton btnAtras;

	
	public Eliminar() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblIngreseCodigo = new JLabel("Ingrese codigo: ");
		lblIngreseCodigo.setBounds(43, 67, 91, 14);
		contentPane.add(lblIngreseCodigo);
		
		codigo = new JTextField();
		codigo.setBounds(166, 64, 86, 20);
		contentPane.add(codigo);
		codigo.setColumns(10);
		
		JButton eliminar = new JButton("Eliminar");
		eliminar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try{
		            Class.forName("java.sql.Driver");
		            Connection conn=(Connection)DriverManager.getConnection("jdbc:mysql://localhost:3306/ex1","root","");
		            Statement st=(Statement) conn.createStatement();
		            PreparedStatement insertar=(PreparedStatement) conn.prepareStatement("DELETE FROM productos WHERE productos . id_producto ="+codigo.getText());
		          
		            insertar.executeUpdate();
		            
		            conn.close();
	
		        }
		        catch (Exception ev){
		            JOptionPane.showMessageDialog(null,"Error: Problema de conexion");
		        }
			}
		});
		eliminar.setBounds(43, 108, 89, 23);
		contentPane.add(eliminar);
		
		btnSalir = new JButton("Salir");
		btnSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnSalir.setBounds(163, 108, 89, 23);
		contentPane.add(btnSalir);
		
		btnAtras = new JButton("Atras");
		btnAtras.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Ventana v= new Ventana();
				v.setVisible(true);
				dispose();
			}
		});
		btnAtras.setBounds(289, 108, 89, 23);
		contentPane.add(btnAtras);
	}
}
