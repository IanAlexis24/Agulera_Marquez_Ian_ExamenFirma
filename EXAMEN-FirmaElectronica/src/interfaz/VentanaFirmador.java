package interfaz;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import javax.swing.ImageIcon;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import modelo.Controlador;

/**
 * Interfaz con la funcion de firmar documentos
 *
 */
@SuppressWarnings("serial")
public class VentanaFirmador extends JFrame implements ActionListener{

	
	public static final String SUBIR_ARCHIVO = "Subir archivo";
	public static final String FIRMAR_ARCHIVO = "Firmar archivo";
	
	private JPasswordField passFieldContrasena;
	private JTextField txtNombreDocumento;
	
	private Inicio inicio;
	private String rutaArchivo;

	public VentanaFirmador(Inicio inicio) 
	{
		
		this.inicio = inicio;
		rutaArchivo="";
		
                setTitle("Firma");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(500, 350, 260, 290);
		JPanel contentPane = new JPanel();
                contentPane.setBackground(Color.pink);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
                
                ImageIcon imagen1 = new ImageIcon("src/imagenes/subir.png");
                ImageIcon imagen2 = new ImageIcon("src/imagenes/firma.png");
                ImageIcon imagen3 = new ImageIcon("src/imagenes/regresa.png");
                
                JLabel Titilo = new JLabel("FIRMA PLS");
		Titilo.setBounds(90, 10, 150, 20);
		contentPane.add(Titilo);
		
		//--------------------------------------------------------
		JButton butSubirDocumento = new JButton(imagen1);
		butSubirDocumento.setActionCommand(SUBIR_ARCHIVO);
		butSubirDocumento.addActionListener((ActionListener) this);
		butSubirDocumento.setBounds(10, 40, 64, 64);
                butSubirDocumento.setBorder(null);
                butSubirDocumento.setContentAreaFilled(false);
		contentPane.add(butSubirDocumento);
		//--------------------------------------------------------
		
		passFieldContrasena = new JPasswordField();
		passFieldContrasena.setBounds(40, 130, 150, 20);
		contentPane.add(passFieldContrasena);
		
		JLabel labIngreseContrasena = new JLabel("Contraseña",SwingConstants.CENTER);
		
		labIngreseContrasena.setBounds(70, 110, 85, 14);
		contentPane.add(labIngreseContrasena);
		
		//--------------------------------------------------------
		JButton butFirmarDocumento = new JButton(imagen2);
		butFirmarDocumento.setActionCommand(FIRMAR_ARCHIVO);
		butFirmarDocumento.addActionListener((ActionListener) this);
		butFirmarDocumento.setBounds(80, 160, 64, 64);
                butFirmarDocumento.setBorder(null);
                butFirmarDocumento.setContentAreaFilled(false);
		contentPane.add(butFirmarDocumento);
		//--------------------------------------------------------
		
		txtNombreDocumento = new JTextField();
		txtNombreDocumento.setEditable(false);
		txtNombreDocumento.setBounds(80, 45, 150, 50);
		contentPane.add(txtNombreDocumento);
		txtNombreDocumento.setColumns(10);
		
		
		JButton butMenuPrincipal = new JButton(imagen3);
		butMenuPrincipal.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				inicio.setVisible(true);
				dispose();
			}
		});
		butMenuPrincipal.setBounds(210, 10, 24, 24);
                butMenuPrincipal.setBorder(null);
                butMenuPrincipal.setContentAreaFilled(false);
		contentPane.add(butMenuPrincipal);
	}

	
	public void subirArchivo()
	{
		JFileChooser fc=new JFileChooser();
		fc.setDialogTitle("Seleccionar archivo");  
		 
		int seleccion=fc.showOpenDialog(this);
		 
		if(seleccion==JFileChooser.APPROVE_OPTION)
		{ 
		    File fichero=fc.getSelectedFile();
		    rutaArchivo = fichero.getAbsolutePath(); 
		    txtNombreDocumento.setText(fichero.getName());
		    
		}
	}
	
	public void firmarArchivo()
	{
		//verificar datos minimos
		String password = new String(passFieldContrasena.getPassword());
		if(rutaArchivo.equals("") || password.equals(""))
		{
			JOptionPane.showMessageDialog(this, "Seleccione un archivo y una contraseña",
					"Error",JOptionPane.ERROR_MESSAGE);
		}
		else
		{
			Controlador controlador = inicio.getControlador();
			
			JOptionPane.showMessageDialog(this, "Seleccione el destino del archivo");
			
			//Seleccionar donde guardar la firma
			JFileChooser fc = new JFileChooser();
			fc.setDialogTitle("Guardar archivo");   
			 
			int seleccion = fc.showSaveDialog(this);
			 
			if (seleccion == JFileChooser.APPROVE_OPTION) 
			{
			    File fichero = fc.getSelectedFile();
			    String rutaFirma = fichero.getAbsolutePath();
			    
			    //proceder a firmar
			    try 
			    {
					controlador.firmarArchivo(rutaArchivo, rutaFirma, password);
					JOptionPane.showMessageDialog(this, "Se genero la firma","Respuesta",JOptionPane.INFORMATION_MESSAGE);
					
					rutaArchivo = "";
					txtNombreDocumento.setText("");
					passFieldContrasena.setText(""); 
				} 
			    catch (Exception e) 
			    {
			    		JOptionPane.showMessageDialog(this, e.getMessage(),"Error",JOptionPane.ERROR_MESSAGE);
				}
			}
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		String comando = e.getActionCommand();
		
		if(comando.equals(SUBIR_ARCHIVO))
		{
			
			subirArchivo();
		}
		else if(comando.equals(FIRMAR_ARCHIVO))
		{
			firmarArchivo();
		}
		
	}

}
