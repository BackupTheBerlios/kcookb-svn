/*
 * About.java
 *
 * Created on 15 de Março de 2008, 18:01
 */
package de.berlios.kcookb.gui;

import java.io.IOException;
import javax.swing.JEditorPane;

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

    private String loadDetails() {
        //TODO: i18n
        String text = "Versão do produto: " 
                + java.util.ResourceBundle.getBundle("de/berlios/kcookb/resources/config").getString("VERSION") 
                + "\nJava: " + System.getProperty("java.vm.name")  + ", "
                + System.getProperty("java.vm.version")
                + "\nSistema: " + System.getProperty("os.name") + " "              
                + System.getProperty("os.version") + " " 
                + System.getProperty("os.arch") + "\nPasta Pessoal: " 
                + System.getProperty("user.home");
        return text;
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

        jtbpAbout = new javax.swing.JTabbedPane();
        jpLogo = new javax.swing.JPanel();
        jlblLogo = new javax.swing.JLabel();
        jscpDetails = new javax.swing.JScrollPane();
        jtaDetails = new javax.swing.JTextArea();
        jtaDetails.setText(loadDetails());
        jpLicense = new javax.swing.JPanel();
        jscpLicense = new javax.swing.JScrollPane();
        try {
            jepLicense = new JEditorPane(getClass().getResource("/de/berlios/kcookb/resources/gpl-2.0.txt"));
        } catch(IOException ex) {
            ex.printStackTrace();
        }

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("null");
        setResizable(false);

        jlblLogo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/de/berlios/kcookb/resources/images/logo.png"))); // NOI18N

        jtaDetails.setColumns(20);
        jtaDetails.setEditable(false);
        jtaDetails.setRows(5);
        jtaDetails.setBorder(null);
        jscpDetails.setViewportView(jtaDetails);

        javax.swing.GroupLayout jpLogoLayout = new javax.swing.GroupLayout(jpLogo);
        jpLogo.setLayout(jpLogoLayout);
        jpLogoLayout.setHorizontalGroup(
            jpLogoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpLogoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jpLogoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jscpDetails, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 464, Short.MAX_VALUE)
                    .addComponent(jlblLogo, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 464, Short.MAX_VALUE))
                .addContainerGap())
        );
        jpLogoLayout.setVerticalGroup(
            jpLogoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpLogoLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jlblLogo, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 26, Short.MAX_VALUE)
                .addComponent(jscpDetails, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        java.util.ResourceBundle bundle = java.util.ResourceBundle.getBundle("de/berlios/kcookb/resources/i18n/i18n"); // NOI18N
        jtbpAbout.addTab(bundle.getString("ABOUTDIALOG_LOGOTAB_TITLE"), jpLogo); // NOI18N

        jepLicense.setEditable(false);
        jscpLicense.setViewportView(jepLicense);

        javax.swing.GroupLayout jpLicenseLayout = new javax.swing.GroupLayout(jpLicense);
        jpLicense.setLayout(jpLicenseLayout);
        jpLicenseLayout.setHorizontalGroup(
            jpLicenseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpLicenseLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jscpLicense)
                .addContainerGap())
        );
        jpLicenseLayout.setVerticalGroup(
            jpLicenseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpLicenseLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jscpLicense, javax.swing.GroupLayout.DEFAULT_SIZE, 315, Short.MAX_VALUE)
                .addContainerGap())
        );

        jtbpAbout.addTab(bundle.getString("ABOUTDIALOG_LICENSETAB_TITLE"), jpLicense); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jtbpAbout, javax.swing.GroupLayout.DEFAULT_SIZE, 489, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jtbpAbout, javax.swing.GroupLayout.DEFAULT_SIZE, 370, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JEditorPane jepLicense;
    private javax.swing.JLabel jlblLogo;
    private javax.swing.JPanel jpLicense;
    private javax.swing.JPanel jpLogo;
    private javax.swing.JScrollPane jscpDetails;
    private javax.swing.JScrollPane jscpLicense;
    private javax.swing.JTextArea jtaDetails;
    private javax.swing.JTabbedPane jtbpAbout;
    // End of variables declaration//GEN-END:variables
}
