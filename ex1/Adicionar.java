package ex1;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.Statement;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;

public class Adicionar extends JFrame {

	private JPanel contentPane;
	private JTextField codigo;
	private JTextField nombre;
	private JTextField precio;
	private JTextField stock;
	private JButton btnSalir;

	public Adicionar() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblCodigo = new JLabel("Codigo: ");
		lblCodigo.setBounds(45, 42, 64, 14);
		contentPane.add(lblCodigo);
		
		JLabel lblNombre = new JLabel("Nombre: ");
		lblNombre.setBounds(45, 67, 64, 14);
		contentPane.add(lblNombre);
		
		JLabel lblPrecio = new JLabel("Precio: ");
		lblPrecio.setBounds(45, 92, 64, 14);
		contentPane.add(lblPrecio);
		
		JLabel lblStock = new JLabel("Stock: ");
		lblStock.setBounds(45, 117, 64, 14);
		contentPane.add(lblStock);
		
		codigo = new JTextField();
		codigo.setBounds(119, 39, 126, 20);
		contentPane.add(codigo);
		codigo.setColumns(10);
		
		nombre = new JTextField();
		nombre.setBounds(119, 64, 190, 20);
		contentPane.add(nombre);
		nombre.setColumns(10);
		
		precio = new JTextField();
		precio.setBounds(119, 92, 86, 20);
		contentPane.add(precio);
		precio.setColumns(10);
		
		stock = new JTextField();
		stock.setBounds(119, 120, 86, 20);
		contentPane.add(stock);
		stock.setColumns(10);
		
		JButton btnOk = new JButton("OK");
		btnOk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//DefaultTableModel model=(DefaultTableModel)tabla1.getModel();
		        try{
		            Class.forName("java.sql.Driver");
		            Connection conn=(Connection)DriverManager.getConnection("jdbc:mysql://localhost:3306/ex1","root","");
		            Statement st=(Statement) conn.createStatement();
		            PreparedStatement insertar=(PreparedStatement) conn.prepareStatement("INSERT into productos (id_producto, nombre_producto, precio_producto, stock_producto) values (?,?,?,?)");
		          
		            insertar.setString(1,codigo.getText());
		            insertar.setString(2,nombre.getText());
		            insertar.setString(3,precio.getText());
		            insertar.setString(4,stock.getText());
		            
		            insertar.executeUpdate();
		            
		            conn.close();
		            
		            
		        }
		        catch (Exception e){
		            JOptionPane.showMessageDialog(null,"Error: Problema de conexion");
		        }
			}
		});
		btnOk.setBounds(128, 171, 89, 23);
		contentPane.add(btnOk);
		
		btnSalir = new JButton("Salir");
		btnSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnSalir.setBounds(220, 171, 89, 23);
		contentPane.add(btnSalir);
		
		JButton btnAtras = new JButton("Atras");
		btnAtras.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Ventana v= new Ventana();
				v.setVisible(true);
				dispose();
			}
		});
		btnAtras.setBounds(176, 199, 89, 23);
		contentPane.add(btnAtras);
	}
}
