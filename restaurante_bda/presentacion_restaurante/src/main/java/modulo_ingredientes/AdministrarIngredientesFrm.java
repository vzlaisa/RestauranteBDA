/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package modulo_ingredientes;

import coordinadores.CoordinadorAplicacion;

/**
 *
 * @author Ximena
 */
public class AdministrarIngredientesFrm extends javax.swing.JFrame {
    private CoordinadorAplicacion coordinadorAplicacion;

    /**
     * Creates new form AdministrarIngredientesFrm
     */
    public AdministrarIngredientesFrm() {
        initComponents();
        this.setLocationRelativeTo(null);
        this.coordinadorAplicacion = CoordinadorAplicacion.getInstancia();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        lRegistrarIngrediente = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        btnRegistrarIngrediente = new javax.swing.JButton();
        btnAumentarStock = new javax.swing.JButton();
        btnAtras = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        btnEliminarIngrediente = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLabel1.setText("¿Qué desea hacer?");

        lRegistrarIngrediente.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lRegistrarIngrediente.setText("Registrar un ingrediente");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel2.setText("Actualizar stock de un ingrediente");

        btnRegistrarIngrediente.setBackground(new java.awt.Color(0, 0, 0));
        btnRegistrarIngrediente.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnRegistrarIngrediente.setForeground(new java.awt.Color(255, 255, 255));
        btnRegistrarIngrediente.setText("Registrar Ingrediente");
        btnRegistrarIngrediente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegistrarIngredienteActionPerformed(evt);
            }
        });

        btnAumentarStock.setBackground(new java.awt.Color(0, 0, 0));
        btnAumentarStock.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnAumentarStock.setForeground(new java.awt.Color(255, 255, 255));
        btnAumentarStock.setText("Actualizar Stock");
        btnAumentarStock.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAumentarStockActionPerformed(evt);
            }
        });

        btnAtras.setBackground(new java.awt.Color(0, 0, 0));
        btnAtras.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnAtras.setForeground(new java.awt.Color(255, 255, 255));
        btnAtras.setText("Atrás");
        btnAtras.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAtrasActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel3.setText("Eliminar un ingrediente");

        btnEliminarIngrediente.setBackground(new java.awt.Color(0, 0, 0));
        btnEliminarIngrediente.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnEliminarIngrediente.setForeground(new java.awt.Color(255, 255, 255));
        btnEliminarIngrediente.setText("Eliminar Ingrediente");
        btnEliminarIngrediente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarIngredienteActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(25, 25, 25))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(btnAumentarStock, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(58, 58, 58))))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(33, 33, 33)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lRegistrarIngrediente)
                                    .addComponent(btnRegistrarIngrediente))
                                .addGap(83, 83, 83)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel3)
                                    .addComponent(btnEliminarIngrediente, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(btnAtras, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(199, 199, 199)
                        .addComponent(jLabel1)))
                .addContainerGap(218, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(59, 59, 59)
                .addComponent(jLabel1)
                .addGap(43, 43, 43)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lRegistrarIngrediente)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnRegistrarIngrediente, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnAumentarStock, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnEliminarIngrediente, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 145, Short.MAX_VALUE)
                .addComponent(btnAtras, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnRegistrarIngredienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistrarIngredienteActionPerformed
        this.dispose();
        coordinadorAplicacion.mostrarRegistrarIngredienteFrm();
    }//GEN-LAST:event_btnRegistrarIngredienteActionPerformed

    private void btnAtrasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAtrasActionPerformed
        atras();
    }//GEN-LAST:event_btnAtrasActionPerformed

    private void btnAumentarStockActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAumentarStockActionPerformed
        this.dispose();
        coordinadorAplicacion.mostrarActualizarStockIngredienteFrm();
    }//GEN-LAST:event_btnAumentarStockActionPerformed

    private void btnEliminarIngredienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarIngredienteActionPerformed
        this.dispose();
        coordinadorAplicacion.mostrarEliminarIngredienteFrm();
    }//GEN-LAST:event_btnEliminarIngredienteActionPerformed

    /**
     * Mostrar menú principal. Si no se accionó ninguna opción, se devuelve al
     * menú principal.
     */
    private void atras() {
        this.dispose();
        coordinadorAplicacion.mostrarMenu();
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAtras;
    private javax.swing.JButton btnAumentarStock;
    private javax.swing.JButton btnEliminarIngrediente;
    private javax.swing.JButton btnRegistrarIngrediente;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lRegistrarIngrediente;
    // End of variables declaration//GEN-END:variables
}
