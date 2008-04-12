/*
 * BookInfoGui.java
 *
 * Created on 15 de Março de 2008, 18:01
 */

package de.berlios.kcookb.gui;

import de.berlios.kcookb.model.BookInfo;

/**
 *
 * @author  Knitter
 */
public class BookInfoGui extends javax.swing.JDialog {
    
    private BookInfo info;
    
    /** Creates new form BookInfoGui */
    public BookInfoGui(java.awt.Frame parent, boolean modal, BookInfo info) {
        super(parent, modal);
        initComponents();
        this.info = info;
    }
    
    public void showCentered() {
        setLocation(getParent().getX() + (getParent().getWidth() / 2) - (getWidth() / 2),
                getParent().getY() + (getParent().getHeight() / 2) - (getHeight() / 2));
        setVisible(true);        
    }
    
    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jpCatalogInfo = new javax.swing.JPanel();
        jlblAuthorName = new javax.swing.JLabel();
        jtfName = new javax.swing.JTextField();
        jtfEmail = new javax.swing.JTextField();
        jlblAuthorEmail = new javax.swing.JLabel();
        jlblCreatedOn = new javax.swing.JLabel();
        jdcCreatedOn = new com.toedter.calendar.JDateChooser();
        jbtHelp = new javax.swing.JButton();
        jbtCancel = new javax.swing.JButton();
        jbtSave = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        java.util.ResourceBundle bundle = java.util.ResourceBundle.getBundle("de/berlios/kcookb/resources/languages/language"); // NOI18N
        setTitle(bundle.getString("BOOKINFODIALOG_TITLE")); // NOI18N
        setResizable(false);

        jpCatalogInfo.setBorder(javax.swing.BorderFactory.createTitledBorder(bundle.getString("BOOKINFODIALOG_BORDER"))); // NOI18N

        jlblAuthorName.setText("Autor:");

        jlblAuthorEmail.setText("E-mail:");

        jlblCreatedOn.setText("Criado em:");

        javax.swing.GroupLayout jpCatalogInfoLayout = new javax.swing.GroupLayout(jpCatalogInfo);
        jpCatalogInfo.setLayout(jpCatalogInfoLayout);
        jpCatalogInfoLayout.setHorizontalGroup(
            jpCatalogInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpCatalogInfoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jpCatalogInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jpCatalogInfoLayout.createSequentialGroup()
                        .addGroup(jpCatalogInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jlblAuthorName)
                            .addComponent(jlblAuthorEmail))
                        .addGap(24, 24, 24)
                        .addGroup(jpCatalogInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jtfName)
                            .addComponent(jtfEmail, javax.swing.GroupLayout.DEFAULT_SIZE, 212, Short.MAX_VALUE)))
                    .addGroup(jpCatalogInfoLayout.createSequentialGroup()
                        .addComponent(jlblCreatedOn)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jdcCreatedOn, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jpCatalogInfoLayout.setVerticalGroup(
            jpCatalogInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpCatalogInfoLayout.createSequentialGroup()
                .addGroup(jpCatalogInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jlblAuthorName)
                    .addComponent(jtfName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jpCatalogInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jlblAuthorEmail)
                    .addComponent(jtfEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jpCatalogInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jlblCreatedOn)
                    .addComponent(jdcCreatedOn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        jbtHelp.setText("Ajuda");
        jbtHelp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtHelpActionPerformed(evt);
            }
        });

        jbtCancel.setText("Cancelar");
        jbtCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtCancelActionPerformed(evt);
            }
        });

        jbtSave.setText("Guardar");
        jbtSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtSaveActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jbtSave)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jbtCancel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jbtHelp))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jpCatalogInfo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(12, 12, 12))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jpCatalogInfo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jbtHelp)
                    .addComponent(jbtCancel)
                    .addComponent(jbtSave))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jbtHelpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtHelpActionPerformed
        //TODO: help for book info dialog
    }//GEN-LAST:event_jbtHelpActionPerformed

    private void jbtCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtCancelActionPerformed
        //TODO: clear fields for proper dispose
        dispose();
    }//GEN-LAST:event_jbtCancelActionPerformed

    private void jbtSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtSaveActionPerformed
        //TODO: save catalog info changes
    }//GEN-LAST:event_jbtSaveActionPerformed
 
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jbtCancel;
    private javax.swing.JButton jbtHelp;
    private javax.swing.JButton jbtSave;
    private com.toedter.calendar.JDateChooser jdcCreatedOn;
    private javax.swing.JLabel jlblAuthorEmail;
    private javax.swing.JLabel jlblAuthorName;
    private javax.swing.JLabel jlblCreatedOn;
    private javax.swing.JPanel jpCatalogInfo;
    private javax.swing.JTextField jtfEmail;
    private javax.swing.JTextField jtfName;
    // End of variables declaration//GEN-END:variables
    
}
