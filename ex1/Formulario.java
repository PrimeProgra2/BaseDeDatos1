package ex1;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.sql.DriverManager;
import java.sql.ResultSet;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JSpinner;
import javax.swing.JTextArea;
import javax.swing.JCheckBox;
import javax.swing.JToggleButton;
import javax.swing.JSeparator;
import javax.swing.JSlider;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import javax.swing.ButtonGroup;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SpinnerNumberModel;

public class Formulario extends JFrame {

	private JPanel contentPane;
	private JTextField nombre;
	private JTextField precio;
	private final ButtonGroup buttonGroup = new ButtonGroup();

	public Formulario() {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 473, 357);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblFormularioDeVenta = new JLabel("FORMULARIO DE VENTA");
		lblFormularioDeVenta.setBounds(129, 26, 196, 14);
		contentPane.add(lblFormularioDeVenta);
		
		JLabel lblNombreCliente = new JLabel("Nombre Cliente: ");
		lblNombreCliente.setBounds(26, 54, 99, 14);
		contentPane.add(lblNombreCliente);
		
		nombre = new JTextField();
		nombre.setBounds(129, 51, 196, 20);
		contentPane.add(nombre);
		nombre.setColumns(10);
		
		JLabel lblProducto = new JLabel("Producto: ");
		lblProducto.setBounds(26, 98, 99, 14);
		contentPane.add(lblProducto);
		
		JComboBox producto = new JComboBox();
		producto.setBounds(129, 95, 118, 20);
		producto.setModel(new DefaultComboBoxModel(bus()));
		contentPane.add(producto);
		producto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try{
	            Class.forName("java.sql.Driver");
	            Connection com=(Connection)DriverManager.getConnection("jdbc:mysql://localhost:3306/ex1","root","");
	            Statement stt=(Statement) com.createStatement();
	            String query="select * from productos where nombre_producto like '"+producto.getSelectedItem()+"'";
	            ResultSet rss=stt.executeQuery(query);
	            while(rss.next()){
	                precio.setText(rss.getString("precio_producto"));
	            }
	            rss.close();
	            stt.close();
	            com.close();
	            
	            
	        }
	        catch (Exception ev){
	            JOptionPane.showMessageDialog(null,"Error: No hay el producto");
	        }
				
			}
		});
		JLabel lblPrecio = new JLabel("Precio: ");
		lblPrecio.setBounds(264, 98, 46, 14);
		contentPane.add(lblPrecio);
		
		precio = new JTextField();
		precio.setBounds(320, 95, 87, 20);
		precio.setEditable(false);
		contentPane.add(precio);
		precio.setColumns(10);
		
		JLabel lblCantidad = new JLabel("Cantidad: ");
		lblCantidad.setBounds(26, 140, 99, 14);
		contentPane.add(lblCantidad);
		
		JSpinner cantidad = new JSpinner();
		cantidad.setModel(new SpinnerNumberModel(1, 1, 1000, 1));
		cantidad.setBounds(129, 137, 46, 20);
		contentPane.add(cantidad);
		
		JCheckBox descuento = new JCheckBox("Descuento (10%)");
		descuento.setBounds(264, 136, 143, 23);
		contentPane.add(descuento);
		
		JLabel lblTipoDeDocumento = new JLabel("Tipo de documento: ");
		lblTipoDeDocumento.setBounds(88, 192, 128, 14);
		contentPane.add(lblTipoDeDocumento);
		
		JRadioButton recibo = new JRadioButton("Recibo");
		recibo.setSelected(true);
		buttonGroup.add(recibo);
		recibo.setBounds(88, 213, 109, 23);
		contentPane.add(recibo);
		
		JRadioButton factura = new JRadioButton("Factura");
		buttonGroup.add(factura);
		factura.setBounds(201, 213, 109, 23);
		contentPane.add(factura);
		
		JButton generar = new JButton("Generar");
		generar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String c1 = "\n";
				String tipo;
				if(factura.isSelected()==true){
					tipo="FACTURA";
				}else{
					tipo="RECIBO";
				}
				String des;
				if(descuento.isSelected()==true){
					des="SI";
				}else{
					des="NO";
				}
				c1+="\t"+tipo+"\n\n";
				c1+="----------------------------------------------------------------------------------\n\n";
				c1+="Nombre:\t"+nombre.getText()+"\nProducto:\t"+producto.getSelectedItem()+"\nPrecio:\t"+precio.getText()+
				    "\nCantidad:\t"+cantidad.getValue()+"\nDescuento:\t"+des;
				JTextArea ob = new JTextArea(20,30);
			      ob.setText(c1);
			      JScrollPane ob1 = new JScrollPane(ob);
			      JOptionPane.showMessageDialog(null, ob1);
				}
		});
		generar.setBounds(43, 266, 89, 23);
		contentPane.add(generar);
		
		JButton nuevo = new JButton("Nuevo");
		nuevo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				nombre.setText("");
				producto.setSelectedItem(null);
				precio.setText("");
				cantidad.setValue(1);
				descuento.setSelected(false);
				recibo.setSelected(false);
				factura.setSelected(false);
			}
		});
		nuevo.setBounds(214, 266, 89, 23);
		contentPane.add(nuevo);
		
		JButton salir = new JButton("Salir");
		salir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		salir.setBounds(317, 266, 89, 23);
		contentPane.add(salir);
		
	}
	public static String[] bus (){
		String[]v = new String [100];
		 try{
	            Class.forName("java.sql.Driver");
	            Connection conn=(Connection)DriverManager.getConnection("jdbc:mysql://localhost:3306/ex1","root","");
	            Statement st=(Statement) conn.createStatement();
	            String query="select * from productos";
	            ResultSet rs=st.executeQuery(query);
	            int i=0;
	            while(rs.next()){
	                String d1=rs.getString("id_producto");
	                String d2=rs.getString("nombre_producto");
	                String d3=rs.getString("precio_producto");
	                String d4=rs.getString("stock_producto");
	                v[i]=d2;
	                i++;
	            }
	            rs.close();
	            st.close();
	            conn.close();
	            
	            
	        }
	        catch (Exception e){
	            JOptionPane.showMessageDialog(null,"Error: Problema de conexion");
	        }
		return v;
	}

}
