/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package de.berlios.kcookb.ui.development;

import java.io.Serializable;
import java.util.logging.Logger;
import org.openide.util.NbBundle;
import org.openide.windows.TopComponent;
import org.openide.windows.WindowManager;
//import org.openide.util.Utilities;

/**
 * Top component which displays something.
 */
final class DevelopmentTopComponent extends TopComponent {

    private static DevelopmentTopComponent instance;
    /** path to the icon used by the component and its open action */
//    static final String ICON_PATH = "SET/PATH/TO/ICON/HERE";
    private static final String PREFERRED_ID = "DevelopmentTopComponent";

    private DevelopmentTopComponent() {
        initComponents();
        setName(NbBundle.getMessage(DevelopmentTopComponent.class, "CTL_DevelopmentTopComponent"));
        setToolTipText(NbBundle.getMessage(DevelopmentTopComponent.class, "HINT_DevelopmentTopComponent"));
//        setIcon(Utilities.loadImage(ICON_PATH, true));

    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jbtnAddRecipe = new javax.swing.JButton();
        jbtnRemoveRecipe = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jbtnCloseBook = new javax.swing.JButton();
        jbtnOpenBook = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jList1 = new javax.swing.JList();

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(org.openide.util.NbBundle.getMessage(DevelopmentTopComponent.class, "DevelopmentTopComponent.jPanel1.border.title"))); // NOI18N

        org.openide.awt.Mnemonics.setLocalizedText(jbtnAddRecipe, org.openide.util.NbBundle.getMessage(DevelopmentTopComponent.class, "DevelopmentTopComponent.jbtnAddRecipe.text")); // NOI18N
        jbtnAddRecipe.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnAddRecipeActionPerformed(evt);
            }
        });

        org.openide.awt.Mnemonics.setLocalizedText(jbtnRemoveRecipe, org.openide.util.NbBundle.getMessage(DevelopmentTopComponent.class, "DevelopmentTopComponent.jbtnRemoveRecipe.text")); // NOI18N
        jbtnRemoveRecipe.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnRemoveRecipeActionPerformed(evt);
            }
        });

        org.openide.awt.Mnemonics.setLocalizedText(jButton3, org.openide.util.NbBundle.getMessage(DevelopmentTopComponent.class, "DevelopmentTopComponent.jButton3.text")); // NOI18N

        org.openide.awt.Mnemonics.setLocalizedText(jButton4, org.openide.util.NbBundle.getMessage(DevelopmentTopComponent.class, "DevelopmentTopComponent.jButton4.text")); // NOI18N

        org.openide.awt.Mnemonics.setLocalizedText(jbtnCloseBook, org.openide.util.NbBundle.getMessage(DevelopmentTopComponent.class, "DevelopmentTopComponent.jbtnCloseBook.text")); // NOI18N
        jbtnCloseBook.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnCloseBookActionPerformed(evt);
            }
        });

        org.openide.awt.Mnemonics.setLocalizedText(jbtnOpenBook, org.openide.util.NbBundle.getMessage(DevelopmentTopComponent.class, "DevelopmentTopComponent.jbtnOpenBook.text")); // NOI18N
        jbtnOpenBook.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnOpenBookActionPerformed(evt);
            }
        });

        org.jdesktop.layout.GroupLayout jPanel1Layout = new org.jdesktop.layout.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .add(jbtnAddRecipe)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(jbtnRemoveRecipe)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(jButton3)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(jButton4)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(jbtnCloseBook)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(jbtnOpenBook)
                .addContainerGap(27, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanel1Layout.createSequentialGroup()
                .add(jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(jbtnAddRecipe)
                    .add(jbtnRemoveRecipe)
                    .add(jButton3)
                    .add(jButton4)
                    .add(jbtnCloseBook)
                    .add(jbtnOpenBook))
                .addContainerGap(org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(org.openide.util.NbBundle.getMessage(DevelopmentTopComponent.class, "DevelopmentTopComponent.jPanel2.border.title"))); // NOI18N

        jList1.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jScrollPane1.setViewportView(jList1);

        org.jdesktop.layout.GroupLayout jPanel2Layout = new org.jdesktop.layout.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .add(jScrollPane1, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 522, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanel2Layout.createSequentialGroup()
                .add(jScrollPane1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(185, Short.MAX_VALUE))
        );

        org.jdesktop.layout.GroupLayout layout = new org.jdesktop.layout.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(org.jdesktop.layout.GroupLayout.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.TRAILING)
                    .add(org.jdesktop.layout.GroupLayout.LEADING, jPanel2, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .add(org.jdesktop.layout.GroupLayout.LEADING, jPanel1, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .addContainerGap()
                .add(jPanel1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(jPanel2, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jbtnAddRecipeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnAddRecipeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jbtnAddRecipeActionPerformed

    private void jbtnRemoveRecipeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnRemoveRecipeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jbtnRemoveRecipeActionPerformed

    private void jbtnOpenBookActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnOpenBookActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jbtnOpenBookActionPerformed

    private void jbtnCloseBookActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnCloseBookActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jbtnCloseBookActionPerformed
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JList jList1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton jbtnAddRecipe;
    private javax.swing.JButton jbtnCloseBook;
    private javax.swing.JButton jbtnOpenBook;
    private javax.swing.JButton jbtnRemoveRecipe;
    // End of variables declaration//GEN-END:variables

    /**
     * Gets default instance. Do not use directly: reserved for *.settings files only,
     * i.e. deserialization routines; otherwise you could get a non-deserialized instance.
     * To obtain the singleton instance, use {@link #findInstance}.
     */
    public static synchronized DevelopmentTopComponent getDefault() {
        if (instance == null) {
            instance = new DevelopmentTopComponent();
        }
        return instance;
    }

    /**
     * Obtain the DevelopmentTopComponent instance. Never call {@link #getDefault} directly!
     */
    public static synchronized DevelopmentTopComponent findInstance() {
        TopComponent win = WindowManager.getDefault().findTopComponent(PREFERRED_ID);
        if (win == null) {
            Logger.getLogger(DevelopmentTopComponent.class.getName()).warning(
                    "Cannot find " + PREFERRED_ID + " component. It will not be located properly in the window system.");
            return getDefault();
        }
        if (win instanceof DevelopmentTopComponent) {
            return (DevelopmentTopComponent) win;
        }
        Logger.getLogger(DevelopmentTopComponent.class.getName()).warning(
                "There seem to be multiple components with the '" + PREFERRED_ID +
                "' ID. That is a potential source of errors and unexpected behavior.");
        return getDefault();
    }

    @Override
    public int getPersistenceType() {
        return TopComponent.PERSISTENCE_ALWAYS;
    }

    @Override
    public void componentOpened() {
        // TODO add custom code on component opening
    }

    @Override
    public void componentClosed() {
        // TODO add custom code on component closing
    }

    /** replaces this in object stream */
    @Override
    public Object writeReplace() {
        return new ResolvableHelper();
    }

    @Override
    protected String preferredID() {
        return PREFERRED_ID;
    }

    final static class ResolvableHelper implements Serializable {

        private static final long serialVersionUID = 1L;

        public Object readResolve() {
            return DevelopmentTopComponent.getDefault();
        }
    }
}
