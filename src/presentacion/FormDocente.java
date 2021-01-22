package presentacion;
import java.awt.event.KeyEvent;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import negocio.NDocente;

public class FormDocente extends javax.swing.JFrame {
    NDocente docN;
    public FormDocente() {
        initComponents();
        this.setLocationRelativeTo(null);
        docN = new NDocente();
    }
    //Funciones======================================================
    private void limpiarCampos(){
        jtfid.setText("0");
        jtfnombres.setText("");
        jtfprofesion.setText("");
        jtfcarnetidentidad.setText("");
        jtftelefono.setText("");
        jComboBoxSexo.setSelectedIndex(0);
        this.bloquearBotones();
    }
    
    private void limpiarTabla(){
        String [] titulos = {"ID","CODIGO","NOMBRES","APELLIDOS","PROFESION","CI","SEXO","TELEFONO"};
        jTableDocente.setModel( new DefaultTableModel(null, titulos) );
        this.limpiarCampos();
    }
    
    private void bloquearBotones(){
        jButtonModificar.setEnabled(false);
        jButtonElimianr.setEnabled(false);
    }
    
    private void desbloquearBotones(){
        jButtonModificar.setEnabled(true);
        jButtonElimianr.setEnabled(true);
        jButtonGuardar.setEnabled(false);
    }
    
    private void nuevo(){
        this.limpiarCampos();
        jtfnombres.requestFocus();
        jButtonGuardar.setEnabled(true);
    }
    
    private boolean validarCampos(){
        return !(jtfnombres.getText().equals("") ||
                 jtfprofesion.getText().equals("") ||
                 jtfcarnetidentidad.getText().equals("") ||
                 jtftelefono.getText().equals("") ||
                 jComboBoxSexo.getSelectedIndex()==0
                );
    }
    
    private void guardar(){
        if(this.validarCampos()){
            int codigo=Integer.parseInt(jtfcodigo.getText());
            String nombre = jtfnombres.getText().toUpperCase();
            String apellido = jtfapellidoss1.getText().toUpperCase();
            String profesion= jtfprofesion.getText().toUpperCase();
            String ci = jtfcarnetidentidad.getText().toUpperCase();
            String telefono = jtftelefono.getText().toUpperCase();
            String sexo = jComboBoxSexo.getSelectedItem().toString().substring(0, 1);

            docN.insertarDocente(codigo,nombre, apellido,profesion, ci, sexo, telefono);
            docN.buscarDocente(jTableDocente);

            this.bloquearBotones();
            jButtonGuardar.setEnabled(false);
        }else
            JOptionPane.showMessageDialog(null, "Complete todos los campos!!", "Advertencia!", JOptionPane.WARNING_MESSAGE);
    }
    
    private void modificar(){
        if(this.validarCampos()){
            int id = Integer.parseInt(jtfid.getText());
            int codigo = Integer.parseInt(jtfcodigo.getText());
            String nombre = jtfnombres.getText().toUpperCase();
            String apellido = jtfapellidoss1.getText().toUpperCase();
            String profesion = jtfprofesion.getText().toUpperCase();
            String ci = jtfcarnetidentidad.getText().toUpperCase();
            String telefono = jtftelefono.getText().toUpperCase();
            String sexo = jComboBoxSexo.getSelectedItem().toString().substring(0, 1);

            docN.actualizarDocente(id,codigo, nombre, apellido,profesion, ci, sexo, telefono);
            docN.buscarDocente(jTableDocente);

            this.bloquearBotones();
        }else
            JOptionPane.showMessageDialog(null, "Complete todos los campos!!", "Advertencia!", JOptionPane.WARNING_MESSAGE);
    }
    
    private void eliminar(){
        int n = JOptionPane.showConfirmDialog(rootPane, "¿Está seguro de eliminar a \n"+jtfnombres.getText()+" "+jtfprofesion.getText()+" ?");
        if(n==JOptionPane.YES_OPTION){
            int id = Integer.parseInt(jtfid.getText());
            docN.eliminarDocente(id);
            docN.buscarDocente(jTableDocente);
            this.bloquearBotones();
        }
    }
    
    private void mostrar(){
        docN.buscarDocente(jTableDocente);
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jtfprofesion = new javax.swing.JTextField();
        jtfcarnetidentidad = new javax.swing.JTextField();
        jtftelefono = new javax.swing.JTextField();
        jtfnombres = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableDocente = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        jButtonMostrar = new javax.swing.JButton();
        jButtonElimianr = new javax.swing.JButton();
        jButtonModificar = new javax.swing.JButton();
        jButtonGuardar = new javax.swing.JButton();
        jButtonNuevo = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jLabel11 = new javax.swing.JLabel();
        jtfid = new javax.swing.JTextField();
        jComboBoxSexo = new javax.swing.JComboBox<>();
        jBExit = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        jtfapellidoss1 = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        jtfcodigo = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(204, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 30)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("GESTIONAR DOCENTE");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, -1, -1));

        jLabel6.setText("Profesion:");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 80, 60, -1));

        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel7.setText("Carnet Identidad:");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 120, 130, -1));

        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel9.setText("Telefono:");
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 140, 130, -1));

        jLabel10.setFont(new java.awt.Font("Dialog", 1, 11)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 102, 0));
        jLabel10.setText("ID:");
        jPanel1.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 80, 80, -1));

        jtfprofesion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtfprofesionActionPerformed(evt);
            }
        });
        jPanel1.add(jtfprofesion, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 80, 180, -1));

        jtfcarnetidentidad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtfcarnetidentidadActionPerformed(evt);
            }
        });
        jPanel1.add(jtfcarnetidentidad, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 110, 140, -1));

        jtftelefono.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtftelefonoActionPerformed(evt);
            }
        });
        jPanel1.add(jtftelefono, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 140, 140, -1));

        jtfnombres.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtfnombresActionPerformed(evt);
            }
        });
        jPanel1.add(jtfnombres, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 140, 150, -1));

        jTableDocente.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jTableDocente.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jTableDocenteMouseReleased(evt);
            }
        });
        jScrollPane1.setViewportView(jTableDocente);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 210, 540, 180));

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Acciones"));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jButtonMostrar.setBackground(new java.awt.Color(107, 188, 161));
        jButtonMostrar.setText("Mostrar");
        jButtonMostrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonMostrarActionPerformed(evt);
            }
        });
        jPanel2.add(jButtonMostrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 200, 90, -1));

        jButtonElimianr.setBackground(new java.awt.Color(255, 160, 160));
        jButtonElimianr.setText("Eliminar");
        jButtonElimianr.setEnabled(false);
        jButtonElimianr.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonElimianrActionPerformed(evt);
            }
        });
        jPanel2.add(jButtonElimianr, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 160, 90, -1));

        jButtonModificar.setBackground(new java.awt.Color(237, 167, 133));
        jButtonModificar.setText("Modificar");
        jButtonModificar.setEnabled(false);
        jButtonModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonModificarActionPerformed(evt);
            }
        });
        jPanel2.add(jButtonModificar, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 120, 90, -1));

        jButtonGuardar.setBackground(new java.awt.Color(89, 144, 198));
        jButtonGuardar.setText("Guardar");
        jButtonGuardar.setEnabled(false);
        jButtonGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonGuardarActionPerformed(evt);
            }
        });
        jPanel2.add(jButtonGuardar, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 80, 90, -1));

        jButtonNuevo.setBackground(new java.awt.Color(103, 184, 133));
        jButtonNuevo.setText("Nuevo");
        jButtonNuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonNuevoActionPerformed(evt);
            }
        });
        jPanel2.add(jButtonNuevo, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 40, 90, -1));

        jButton2.setBackground(new java.awt.Color(255, 204, 153));
        jButton2.setText("Limpiar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 240, 90, -1));

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 60, 130, 330));

        jLabel11.setText("Nombres:");
        jPanel1.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 140, 80, -1));

        jtfid.setEditable(false);
        jtfid.setBackground(new java.awt.Color(255, 204, 204));
        jtfid.setFont(new java.awt.Font("Dialog", 1, 11)); // NOI18N
        jtfid.setForeground(new java.awt.Color(255, 102, 0));
        jtfid.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jtfid.setText("0");
        jPanel1.add(jtfid, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 80, 60, -1));

        jComboBoxSexo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Sexo:", "Masculino", "Femenino" }));
        jComboBoxSexo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jComboBoxSexoKeyPressed(evt);
            }
        });
        jPanel1.add(jComboBoxSexo, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 170, 140, -1));

        jBExit.setBackground(new java.awt.Color(255, 102, 102));
        jBExit.setForeground(new java.awt.Color(255, 255, 255));
        jBExit.setText("Salir");
        jBExit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBExitActionPerformed(evt);
            }
        });
        jPanel1.add(jBExit, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 20, 60, -1));

        jLabel8.setText("Apellidos:");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 170, 80, -1));

        jtfapellidoss1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtfapellidoss1ActionPerformed(evt);
            }
        });
        jPanel1.add(jtfapellidoss1, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 170, 150, -1));

        jLabel12.setFont(new java.awt.Font("Dialog", 1, 11)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 102, 0));
        jLabel12.setText("CODIGO:");
        jPanel1.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 110, 80, -1));

        jtfcodigo.setEditable(false);
        jtfcodigo.setBackground(new java.awt.Color(153, 255, 255));
        jtfcodigo.setFont(new java.awt.Font("Dialog", 1, 11)); // NOI18N
        jtfcodigo.setForeground(new java.awt.Color(255, 102, 0));
        jtfcodigo.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jtfcodigo.setText("0");
        jPanel1.add(jtfcodigo, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 110, 150, -1));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 720, 410));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonMostrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonMostrarActionPerformed
        this.mostrar();
    }//GEN-LAST:event_jButtonMostrarActionPerformed

    private void jButtonElimianrActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonElimianrActionPerformed
        this.eliminar();
    }//GEN-LAST:event_jButtonElimianrActionPerformed

    private void jButtonModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonModificarActionPerformed
        this.modificar();
    }//GEN-LAST:event_jButtonModificarActionPerformed

    private void jButtonGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonGuardarActionPerformed
        this.guardar();
        jButtonNuevo.requestFocus();
    }//GEN-LAST:event_jButtonGuardarActionPerformed

    private void jTableDocenteMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableDocenteMouseReleased
        int fila = jTableDocente.getSelectedRow();
        if(fila > -1){
            String id = jTableDocente.getValueAt(fila, 0).toString();
            String nombre = jTableDocente.getValueAt(fila, 1).toString();
            String apellido = jTableDocente.getValueAt(fila, 2).toString();
            String ci = jTableDocente.getValueAt(fila, 3).toString();
            String sexo = jTableDocente.getValueAt(fila, 4).toString();
            String telefono = jTableDocente.getValueAt(fila, 5).toString();
            
            jtfid.setText(id);
            jtfnombres.setText(nombre);
            jtfprofesion.setText(apellido);
            jtfcarnetidentidad.setText(ci);
            switch (sexo) { case "M": jComboBoxSexo.setSelectedIndex(1); break; case "F": jComboBoxSexo.setSelectedIndex(2); break; default: jComboBoxSexo.setSelectedIndex(0); break; }
            jtftelefono.setText(telefono);
            
            this.desbloquearBotones();
        }
    }//GEN-LAST:event_jTableDocenteMouseReleased

    private void jButtonNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonNuevoActionPerformed
        this.nuevo();
    }//GEN-LAST:event_jButtonNuevoActionPerformed

    private void jBExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBExitActionPerformed
        this.dispose();
    }//GEN-LAST:event_jBExitActionPerformed

    private void jtfnombresActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtfnombresActionPerformed
        jtfprofesion.requestFocus();
    }//GEN-LAST:event_jtfnombresActionPerformed

    private void jtfprofesionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtfprofesionActionPerformed
        jtfcarnetidentidad.requestFocus();
    }//GEN-LAST:event_jtfprofesionActionPerformed

    private void jtfcarnetidentidadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtfcarnetidentidadActionPerformed
        jtftelefono.requestFocus();
    }//GEN-LAST:event_jtfcarnetidentidadActionPerformed

    private void jtftelefonoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtftelefonoActionPerformed
        jComboBoxSexo.requestFocus();
    }//GEN-LAST:event_jtftelefonoActionPerformed

    private void jComboBoxSexoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jComboBoxSexoKeyPressed
        if(evt.getKeyCode()==KeyEvent.VK_ENTER)
            jButtonGuardar.requestFocus();
    }//GEN-LAST:event_jComboBoxSexoKeyPressed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        docN.desconectar();
    }//GEN-LAST:event_formWindowClosing

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jtfapellidoss1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtfapellidoss1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtfapellidoss1ActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBExit;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButtonElimianr;
    private javax.swing.JButton jButtonGuardar;
    private javax.swing.JButton jButtonModificar;
    private javax.swing.JButton jButtonMostrar;
    private javax.swing.JButton jButtonNuevo;
    private javax.swing.JComboBox<String> jComboBoxSexo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTableDocente;
    private javax.swing.JTextField jtfapellidoss1;
    private javax.swing.JTextField jtfcarnetidentidad;
    private javax.swing.JTextField jtfcodigo;
    private javax.swing.JTextField jtfid;
    private javax.swing.JTextField jtfnombres;
    private javax.swing.JTextField jtfprofesion;
    private javax.swing.JTextField jtftelefono;
    // End of variables declaration//GEN-END:variables
}
