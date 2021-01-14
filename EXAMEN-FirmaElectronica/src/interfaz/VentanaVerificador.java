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
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import modelo.Controlador;

/**
 * Interfaz con la funcion de verificar una firma digital de un archivo
 *
 */
@SuppressWarnings("serial")
public class VentanaVerificador extends JFrame implements ActionListener {

	public static final String SUBIR_ARCHIVO = "Subir archivo";
	public static final String SUBIR_FIRMA = "Subir firma";
	public static final String SUBIR_CLAVE_PUBLICA = "Subir clave publica";
	public static final String COMPROBAR = "COMPROBAR";
	
	private JTextField txtSubirArchivo;
	private JTextField txtSubirFirma;
	private JTextField txtSubirClavePublica;
	
	private Inicio inicio;
	private String rutaArchivo;
	private String rutaFirma;
	private String rutaClavePublica;

	public VentanaVerificador(Inicio inicio) 
	{
		this.inicio = inicio;
		rutaArchivo = "";
		rutaFirma = "";
		rutaClavePublica = "";
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(500, 350, 300, 380);
		JPanel contentPane = new JPanel();
                contentPane.setBackground(Color.pink);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
                
                ImageIcon imagen1 = new ImageIcon("src/imagenes/pdf2.png");
                ImageIcon imagen2 = new ImageIcon("src/imagenes/firma.png");
                ImageIcon imagen3 = new ImageIcon("src/imagenes/llaves.png");
                ImageIcon imagen4 = new ImageIcon("src/imagenes/regresa.png");
                ImageIcon imagen5 = new ImageIcon("src/imagenes/verifi.png");
		
                JLabel titulo = new JLabel("VERIFIQUEMOS");
		titulo.setBounds(100, 10, 150, 20);
		contentPane.add(titulo);
                
		JButton butSubirArchivo = new JButton(imagen1);
		butSubirArchivo.setActionCommand(SUBIR_ARCHIVO);
		butSubirArchivo.addActionListener((ActionListener) this);	
		butSubirArchivo.setBounds(10, 40, 64, 64);
                butSubirArchivo.setBorder(null);
                butSubirArchivo.setContentAreaFilled(false);
		contentPane.add(butSubirArchivo);
		
		JButton butSubFirma = new JButton(imagen2);
		butSubFirma.setActionCommand(SUBIR_FIRMA);
		butSubFirma.addActionListener((ActionListener) this);
		butSubFirma.setBounds(200, 110, 64, 64);
                butSubFirma.setBorder(null);
                butSubFirma.setContentAreaFilled(false);
		contentPane.add(butSubFirma);
		
		JButton butSubClavePublica = new JButton(imagen3);
		butSubClavePublica.setActionCommand(SUBIR_CLAVE_PUBLICA);
		butSubClavePublica.addActionListener((ActionListener) this);
		butSubClavePublica.setBounds(10, 180, 64, 64);
                butSubClavePublica.setBorder(null);
                butSubClavePublica.setContentAreaFilled(false);
		contentPane.add(butSubClavePublica);
		
		//-----------------------------------------------------
		JButton butComprobar = new JButton(imagen5);
		butComprobar.setActionCommand(COMPROBAR);
		butComprobar.addActionListener((ActionListener) this);
		butComprobar.setBounds(100, 250, 64, 64);
                butComprobar.setBorder(null);
                butComprobar.setContentAreaFilled(false);
		contentPane.add(butComprobar);
		//-----------------------------------------------------
		
		JButton butMenuPrincipal = new JButton(imagen4);
		butMenuPrincipal.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{				
				inicio.setVisible(true);
				dispose();	
			}
		});
		butMenuPrincipal.setBounds(250, 5, 24, 24);
                butMenuPrincipal.setBorder(null);
                butMenuPrincipal.setContentAreaFilled(false);
		contentPane.add(butMenuPrincipal);
		
		txtSubirArchivo = new JTextField();
		txtSubirArchivo.setEditable(false);
		txtSubirArchivo.setBounds(100, 60, 165, 23);
		contentPane.add(txtSubirArchivo);
		txtSubirArchivo.setColumns(10);
		
		txtSubirFirma = new JTextField();
		txtSubirFirma.setEditable(false);
		txtSubirFirma.setColumns(10);
		txtSubirFirma.setBounds(10, 130, 165, 23);
		contentPane.add(txtSubirFirma);
		
		txtSubirClavePublica = new JTextField();
		txtSubirClavePublica.setEditable(false);
		txtSubirClavePublica.setColumns(10);
		txtSubirClavePublica.setBounds(100, 200, 165, 23);
		contentPane.add(txtSubirClavePublica);
	}

	public void subirArchivo()
	{
		JFileChooser fc=new JFileChooser();
		 
		int seleccion=fc.showOpenDialog(this);
		 
		if(seleccion==JFileChooser.APPROVE_OPTION)
		{ 
		    File fichero=fc.getSelectedFile();
		    rutaArchivo = fichero.getAbsolutePath(); 
		    txtSubirArchivo.setText(fichero.getName());	    
		}
	}
	
	public void subirFirma()
	{
		JFileChooser fc=new JFileChooser();
		 
		int seleccion=fc.showOpenDialog(this);
		 
		if(seleccion==JFileChooser.APPROVE_OPTION)
		{ 
		    File fichero=fc.getSelectedFile();
		    rutaFirma = fichero.getAbsolutePath(); 
		    txtSubirFirma.setText(fichero.getName());	    
		}
	}
	
	public void subirClavePublica()
	{
		JFileChooser fc=new JFileChooser();
 
		int seleccion=fc.showOpenDialog(this);
		 
		if(seleccion==JFileChooser.APPROVE_OPTION)
		{ 
		    File fichero=fc.getSelectedFile();
		    rutaClavePublica = fichero.getAbsolutePath(); 
		    txtSubirClavePublica.setText(fichero.getName());	    
		}
	}
	
	public void comprobar()
	{
		if(rutaArchivo.equals("") || rutaFirma.equals("") || rutaClavePublica.equals(""))
		{
			JOptionPane.showMessageDialog(this, "Llene todos los campos",
					"Error",JOptionPane.ERROR_MESSAGE);
		}
		else
		{
			Controlador controlador = inicio.getControlador();
			try 
			{
				boolean respuesta = controlador.validarFirma(rutaArchivo, rutaFirma, rutaClavePublica);
				if(respuesta)
				{
					
					JOptionPane.showMessageDialog(this, "Ay perro si es este","Respuesta",JOptionPane.INFORMATION_MESSAGE);
				}
				else
				{
					
					JOptionPane.showMessageDialog(this, "noooo chavo, ¿que paso?","Respuesta",JOptionPane.INFORMATION_MESSAGE);
					
				}
			} 
			catch (Exception e) 
			{
				JOptionPane.showMessageDialog(this, "¿olvidaste tu firma o que?",
						"Error",JOptionPane.ERROR_MESSAGE);	
			}
		}
	}
	
	public void limpiar()
	{
		rutaArchivo="";
		rutaFirma="";
		rutaClavePublica="";
		
		txtSubirArchivo.setText("");
		txtSubirFirma.setText("");
		txtSubirClavePublica.setText("");
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		String comando = e.getActionCommand();
		
		if(comando.equals(SUBIR_ARCHIVO))
		{
			subirArchivo();
		}
		else if(comando.equals(SUBIR_FIRMA))
		{
			subirFirma();
		}
		else if(comando.equals(SUBIR_CLAVE_PUBLICA))
		{
			
			subirClavePublica();
		}
		else if(comando.equals(COMPROBAR))
		{
			comprobar();
		}
		
	}

}
