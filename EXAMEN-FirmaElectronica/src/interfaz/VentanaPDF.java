package interfaz;

import java.io.File;
import java.io.FileOutputStream;
import java.io.FileNotFoundException;
import com.itextpdf.text.*;
import com.itextpdf.text.pdf.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Diego Rivera
 */
public final class VentanaPDF extends javax.swing.JFrame {

    /**
     * Creates new form PDf
     */
    public VentanaPDF() {
        
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Nombre = new javax.swing.JTextField();
        Apellidos = new javax.swing.JTextField();
        Boleta = new javax.swing.JTextField();
        regresar = new javax.swing.JButton();
        Generar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        Mensaje = new javax.swing.JTextArea();
        jLabel5 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("DATOS");
        setLocation(new java.awt.Point(500, 300));
        setMaximumSize(new java.awt.Dimension(450, 450));
        setMinimumSize(new java.awt.Dimension(450, 450));
        setPreferredSize(new java.awt.Dimension(450, 450));
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        getContentPane().add(Nombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 60, 232, -1));
        getContentPane().add(Apellidos, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 110, 232, -1));
        getContentPane().add(Boleta, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 160, 232, -1));

        regresar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/regresa.png"))); // NOI18N
        regresar.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        regresar.setBorderPainted(false);
        regresar.setMaximumSize(new java.awt.Dimension(24, 24));
        regresar.setMinimumSize(new java.awt.Dimension(24, 24));
        regresar.setPreferredSize(new java.awt.Dimension(24, 24));
        regresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                regresarActionPerformed(evt);
            }
        });
        getContentPane().add(regresar, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 10, 30, 30));

        Generar.setBackground(new java.awt.Color(255, 255, 255));
        Generar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/crear.png"))); // NOI18N
        Generar.setToolTipText("");
        Generar.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        Generar.setBorderPainted(false);
        Generar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                GenerarActionPerformed(evt);
            }
        });
        getContentPane().add(Generar, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 310, 70, 70));

        jLabel1.setFont(new java.awt.Font("Arial Black", 0, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 204));
        jLabel1.setText("TU NOMBRESITO");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 40, -1, -1));

        jLabel2.setFont(new java.awt.Font("Arial Black", 0, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 51, 51));
        jLabel2.setText("TUS APELLIDOS GUAPO");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 90, -1, -1));

        jLabel3.setFont(new java.awt.Font("Arial Black", 0, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 153, 153));
        jLabel3.setText("TU BOLETA PLS");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 140, -1, -1));

        jLabel4.setFont(new java.awt.Font("Arial Black", 0, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 102, 204));
        jLabel4.setText("MIS DESEOS SON");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 190, -1, -1));

        Mensaje.setColumns(20);
        Mensaje.setRows(5);
        jScrollPane1.setViewportView(Mensaje);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 210, 292, -1));

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/navidad.png"))); // NOI18N
        jLabel5.setText("jLabel5");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 450, 400));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    
    private void regresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_regresarActionPerformed
        Inicio regresa = new Inicio();
        regresa.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_regresarActionPerformed

    private void GenerarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_GenerarActionPerformed
        try {
            // TODO add your handling code here:
            generar(Nombre.getText());
        } catch (FileNotFoundException ex) {
            Logger.getLogger(VentanaPDF.class.getName()).log(Level.SEVERE, null, ex);
        } catch (DocumentException ex) {
            Logger.getLogger(VentanaPDF.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_GenerarActionPerformed

    /**
     * @param args the command line arguments
     */


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField Apellidos;
    private javax.swing.JTextField Boleta;
    private javax.swing.JButton Generar;
    private javax.swing.JTextArea Mensaje;
    private javax.swing.JTextField Nombre;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton regresar;
    // End of variables declaration//GEN-END:variables

    private void generar(String nombre) throws FileNotFoundException, DocumentException {
        if (!(Nombre.getText().isEmpty() || (Apellidos.getText().isEmpty()) || (Boleta.getText().isEmpty()) || (Mensaje.getText().isEmpty()))) {
            
            Paragraph parrafo = new Paragraph("Datos personales");
            parrafo.setAlignment(1);

            FileOutputStream archivo2 = new FileOutputStream(nombre + "Firmado" + ".pdf");
            Document documento2 = new Document();
            PdfWriter.getInstance(documento2, archivo2);
            
            documento2.open();
            Paragraph parrafo3= new Paragraph("Tu informacion bb");
            parrafo.setAlignment(1);
            
            documento2.add(parrafo3);
            documento2.add(new Paragraph("Este es tu Nombresito: " + Nombre.getText()));
            documento2.add(new Paragraph("Tus Apellidos: " + Apellidos.getText()));
            documento2.add(new Paragraph("Tu Boletita: " + Boleta.getText()));
            documento2.add(new Paragraph("Tus deseos: " + Mensaje.getText()));
            documento2.close();
            
            
            JOptionPane.showMessageDialog(null, "El PDF fue creado bien bonito");
        }
        else{
            JOptionPane.showMessageDialog(null, "Llena los campos o no habra regalo :c");
        }

    }
}
