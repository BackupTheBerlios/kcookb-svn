/*
 * About.java
 *
 * Created on 15 de Março de 2008, 18:01
 */

package de.berlios.kcookb.gui;

/**
 *
 * @author  Knitter
 */
public class About extends javax.swing.JDialog {
    
    /** Creates new form About */
    public About(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
    }
    
    public void showCentered() {
        setVisible(true);
    }
    
    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jtbpAbout = new javax.swing.JTabbedPane();
        jpLogo = new javax.swing.JPanel();
        lblLogo = new javax.swing.JLabel();
        jpLicense = new javax.swing.JPanel();
        jscpLicense = new javax.swing.JScrollPane();
        jepLicense = new javax.swing.JEditorPane();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        java.util.ResourceBundle bundle = java.util.ResourceBundle.getBundle("de/berlios/kcookb/resources/languages/language"); // NOI18N
        setTitle(bundle.getString("ABOUTDIALOG_TITLE")); // NOI18N
        setResizable(false);

        lblLogo.setText("jLabel1");

        javax.swing.GroupLayout jpLogoLayout = new javax.swing.GroupLayout(jpLogo);
        jpLogo.setLayout(jpLogoLayout);
        jpLogoLayout.setHorizontalGroup(
            jpLogoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpLogoLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblLogo, javax.swing.GroupLayout.DEFAULT_SIZE, 405, Short.MAX_VALUE)
                .addContainerGap())
        );
        jpLogoLayout.setVerticalGroup(
            jpLogoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpLogoLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblLogo, javax.swing.GroupLayout.DEFAULT_SIZE, 304, Short.MAX_VALUE)
                .addContainerGap())
        );

        jtbpAbout.addTab(bundle.getString("ABOUTDIALOG_LOGOTAB_TITLE"), jpLogo); // NOI18N

        jscpLicense.setViewportView(jepLicense);

        javax.swing.GroupLayout jpLicenseLayout = new javax.swing.GroupLayout(jpLicense);
        jpLicense.setLayout(jpLicenseLayout);
        jpLicenseLayout.setHorizontalGroup(
            jpLicenseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpLicenseLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jscpLicense, javax.swing.GroupLayout.DEFAULT_SIZE, 405, Short.MAX_VALUE)
                .addContainerGap())
        );
        jpLicenseLayout.setVerticalGroup(
            jpLicenseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpLicenseLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jscpLicense, javax.swing.GroupLayout.DEFAULT_SIZE, 304, Short.MAX_VALUE)
                .addContainerGap())
        );

        jtbpAbout.addTab(bundle.getString("ABOUTDIALOG_LICENSETAB_TITLE"), jpLicense); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jtbpAbout, javax.swing.GroupLayout.DEFAULT_SIZE, 430, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jtbpAbout, javax.swing.GroupLayout.DEFAULT_SIZE, 354, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JEditorPane jepLicense;
    private javax.swing.JPanel jpLicense;
    private javax.swing.JPanel jpLogo;
    private javax.swing.JScrollPane jscpLicense;
    private javax.swing.JTabbedPane jtbpAbout;
    private javax.swing.JLabel lblLogo;
    // End of variables declaration//GEN-END:variables
    
}
