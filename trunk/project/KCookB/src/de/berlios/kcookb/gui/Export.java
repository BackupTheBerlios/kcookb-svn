/*
 * Export.java
 *
 * Created on 15 de Março de 2008, 18:01
 */

package de.berlios.kcookb.gui;

import java.util.Vector;
import javax.swing.ImageIcon;

/**
 *
 * @author  Knitter
 */
public class Export extends javax.swing.JDialog {
    
    private Vector exportIcons;
    /** Creates new form Export */
    public Export(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        exportIcons = new Vector();
        
        exportIcons.add(new ImageIcon(getClass().getResource("/de/berlios/kcookb/resources/images/export-csv.png")));
        //TODO: add more icons.
        
        initComponents();
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

        jpAvailableTypes = new javax.swing.JPanel();
        jscpAvailableTypes = new javax.swing.JScrollPane();
        jlistAvailableTypes = new javax.swing.JList(exportIcons);
        jpOptions = new javax.swing.JPanel();
        jbtnHelp = new javax.swing.JButton();
        jbtnCancel = new javax.swing.JButton();
        jbtnExport = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        java.util.ResourceBundle bundle = java.util.ResourceBundle.getBundle("de/berlios/kcookb/resources/i18n/i18n"); // NOI18N
        jpAvailableTypes.setBorder(javax.swing.BorderFactory.createTitledBorder(bundle.getString("EXPORTDIALOG_AVAILABLEFORMATS"))); // NOI18N

        jscpAvailableTypes.setViewportView(jlistAvailableTypes);

        javax.swing.GroupLayout jpAvailableTypesLayout = new javax.swing.GroupLayout(jpAvailableTypes);
        jpAvailableTypes.setLayout(jpAvailableTypesLayout);
        jpAvailableTypesLayout.setHorizontalGroup(
            jpAvailableTypesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpAvailableTypesLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jscpAvailableTypes, javax.swing.GroupLayout.DEFAULT_SIZE, 109, Short.MAX_VALUE)
                .addContainerGap())
        );
        jpAvailableTypesLayout.setVerticalGroup(
            jpAvailableTypesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpAvailableTypesLayout.createSequentialGroup()
                .addComponent(jscpAvailableTypes, javax.swing.GroupLayout.DEFAULT_SIZE, 276, Short.MAX_VALUE)
                .addContainerGap())
        );

        jpOptions.setBorder(javax.swing.BorderFactory.createTitledBorder(bundle.getString("EXPORTDIALOG_OPTIONS_TITLE"))); // NOI18N
        jpOptions.setLayout(new java.awt.CardLayout());

        java.util.ResourceBundle bundle1 = java.util.ResourceBundle.getBundle("de/berlios/kcookb/gui/Bundle"); // NOI18N
        jbtnHelp.setText(bundle1.getString("EXPORTDIALOG_HELPBUTTON")); // NOI18N
        jbtnHelp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnHelpActionPerformed(evt);
            }
        });

        jbtnCancel.setText(bundle.getString("EXPORTDIALOG_CANCELBUTTON")); // NOI18N
        jbtnCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnCancelActionPerformed(evt);
            }
        });

        jbtnExport.setText(bundle.getString("EXPORTDIALOG_EXPORTBUTTON")); // NOI18N
        jbtnExport.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnExportActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jpAvailableTypes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jpOptions, javax.swing.GroupLayout.DEFAULT_SIZE, 350, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jbtnExport)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jbtnCancel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jbtnHelp)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jpAvailableTypes, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jpOptions, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 317, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jbtnHelp)
                    .addComponent(jbtnCancel)
                    .addComponent(jbtnExport))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jbtnCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnCancelActionPerformed
        dispose();
}//GEN-LAST:event_jbtnCancelActionPerformed

    private void jbtnHelpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnHelpActionPerformed
        // TODO add your handling code here:
}//GEN-LAST:event_jbtnHelpActionPerformed

    private void jbtnExportActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnExportActionPerformed
        // TODO add your handling code here:
}//GEN-LAST:event_jbtnExportActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jbtnCancel;
    private javax.swing.JButton jbtnExport;
    private javax.swing.JButton jbtnHelp;
    private javax.swing.JList jlistAvailableTypes;
    private javax.swing.JPanel jpAvailableTypes;
    private javax.swing.JPanel jpOptions;
    private javax.swing.JScrollPane jscpAvailableTypes;
    // End of variables declaration//GEN-END:variables
    
}
