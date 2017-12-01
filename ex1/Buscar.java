package ex1;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;

public class Buscar extends JFrame {

	private JPanel contentPane;
	private JTextField codigo;
	private JTextField id;
	private JTextField nombre;
	private JTextField precio;
	private JTextField stock;
	private JButton btnSalir;
	private JButton btnAtras;

	public Buscar() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 482, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblCodigo = new JLabel("Codigo: ");
		lblCodigo.setBounds(74, 67, 46, 14);
		contentPane.add(lblCodigo);
		
		codigo = new JTextField();
		codigo.setBounds(130, 64, 86, 20);
		contentPane.add(codigo);
		codigo.setColumns(10);
		
		id = new JTextField();
		id.setEditable(false);
		id.setBounds(44, 112, 86, 20);
		contentPane.add(id);
		id.setColumns(10);
		
		nombre = new JTextField();
		nombre.setEditable(false);
		nombre.setBounds(140, 112, 86, 20);
		contentPane.add(nombre);
		nombre.setColumns(10);
		
		precio = new JTextField();
		precio.setEditable(false);
		precio.setBounds(236, 112, 86, 20);
		contentPane.add(precio);
		precio.setColumns(10);
		
		stock = new JTextField();
		stock.setEditable(false);
		stock.setBounds(332, 112, 86, 20);
		contentPane.add(stock);
		stock.setColumns(10);
		
		JButton buscar = new JButton("Buscar");
		buscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try{
		            Class.forName("java.sql.Driver");
		            Connection conn=(Connection)DriverManager.getConnection("jdbc:mysql://localhost:3306/ex1","root","");
		            Statement st=(Statement) conn.createStatement();
		            String query="select * from productos where id_producto="+codigo.getText();
		            ResultSet rs=st.executeQuery(query);
		            System.out.println(rs);
		            boolean p = false;
		            
		            while(rs.next()){
		               	id.setText(rs.getString("id_producto"));
		               	nombre.setText(rs.getString("nombre_producto"));
		               	precio.setText(rs.getString("precio_producto"));
		               	stock.setText(rs.getString("stock_producto"));
		               	p = true;
		            }
		           	if(p!=true) {
		            	JOptionPane.showMessageDialog(null, "No exisse");
		            }
		            rs.close();
		            st.close();
		            conn.close();
		            
		        }
		        catch (Exception ev){
		            JOptionPane.showMessageDialog(null,"Error: No hay el producto");
		        }
			}
		});
		buscar.setBounds(285, 63, 89, 23);
		contentPane.add(buscar);
		
		btnSalir = new JButton("Salir");
		btnSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnSalir.setBounds(177, 213, 89, 23);
		contentPane.add(btnSalir);
		
		btnAtras = new JButton("Atras");
		btnAtras.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Ventana v= new Ventana();
				v.setVisible(true);
				dispose();
			}
		});
		btnAtras.setBounds(177, 179, 89, 23);
		contentPane.add(btnAtras);
	}

}
