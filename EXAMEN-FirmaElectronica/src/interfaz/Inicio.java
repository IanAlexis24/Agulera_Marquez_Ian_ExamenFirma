package interfaz;

import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import javax.swing.ImageIcon;
import javax.swing.border.Border;
import modelo.Controlador;

@SuppressWarnings("serial")
public class Inicio extends JFrame {
        
    private Controlador controlador;
	public Inicio() {
            controlador = new Controlador();
		
            setTitle("FD");
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            setBounds(500, 350, 280, 300);
            JPanel contentPane = new JPanel();
            contentPane.setBackground(Color.pink);
            contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
            setContentPane(contentPane);
            setLayout(null);
		
            VentanaPDF PDFBueno = new VentanaPDF();
                
            VentanaGeneradorClaves generadorClaves = new VentanaGeneradorClaves(this);
            VentanaFirmador firma = new VentanaFirmador(this);
            VentanaVerificador comprobador = new VentanaVerificador(this);
            
            ImageIcon imagen1 = new ImageIcon("src/imagenes/pdf2.png");
            ImageIcon imagen2 = new ImageIcon("src/imagenes/llaves.png");
            ImageIcon imagen3 = new ImageIcon("src/imagenes/firma.png");
            ImageIcon imagen4 = new ImageIcon("src/imagenes/verifi.png");
            
            //generar pdf boton
            JButton GeneraPDF = new JButton(imagen1);
            GeneraPDF.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                PDFBueno.setVisible(true);
                dispose();
            }
            });
            GeneraPDF.setBounds(90, 40, 64, 64);
            GeneraPDF.setBorder(null);
            GeneraPDF.setContentAreaFilled(false);
            contentPane.add(GeneraPDF);
            
            //generar llaves boton
            JButton butGeneradorClaves = new JButton(imagen2);
            butGeneradorClaves.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
		generadorClaves.setVisible(true);
		dispose();
            }
            });
            butGeneradorClaves.setBounds(25, 105, 64, 64);
            butGeneradorClaves.setBorder(null);
            butGeneradorClaves.setContentAreaFilled(false);
            contentPane.add(butGeneradorClaves);
		
            JButton ExpFirma = new JButton(imagen3);
            ExpFirma.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
		firma.setVisible(true);
		dispose();
            }
            });
            ExpFirma.setBounds(155, 105, 64, 64);
            ExpFirma.setBorder(null);
            ExpFirma.setContentAreaFilled(false);
            contentPane.add(ExpFirma);
		
            JButton butComprobador = new JButton(imagen4);
            butComprobador.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
		comprobador.setVisible(true);
		dispose();
            }
            });
            butComprobador.setBounds(90, 170, 64, 64);
            butComprobador.setBorder(null);
            butComprobador.setContentAreaFilled(false);
            contentPane.add(butComprobador);
	}
	
	public Controlador getControlador() {
		return controlador;
	}

	public void setControlador(Controlador controlador) {
		this.controlador = controlador;
	}

	public static void main(String[] args) 
	{
		Inicio window = new Inicio();
		window.setVisible(true);

	}

}
