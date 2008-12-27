/*
 *  Settings.java
 *
 *  Copyright (C) 2008  Sérgio Lopes
 *
 *  This file is part of KCookB.
 *
 *  KCookB is free software: you can redistribute it and/or modify
 *  it under the terms of the GNU General Public License as published by
 *  the Free Software Foundation, either version 3 of the License, or
 *  (at your option) any later version.
 *
 *  KCookB is distributed in the hope that it will be useful,
 *  but WITHOUT ANY WARRANTY; without even the implied warranty of
 *  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *  GNU General Public License for more details.
 *
 *  You should have received a copy of the GNU General Public License
 *  along with KCookB. If not, see <http://www.gnu.org/licenses/gpl.html>.
 */
package de.berlios.kcookb.gui;

import java.io.File;
import java.util.Properties;

/**
 *
 * @author Knitter
 */
public class Settings extends javax.swing.JDialog {

    /** Creates new form Settings */
    public Settings(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
    }

    @Override
    public void setVisible(boolean visible) {
        setLocation(getParent().getX() + (getParent().getWidth() / 2) - (getWidth() / 2),
                getParent().getY() + (getParent().getHeight() / 2) - (getHeight() / 2));

        super.setVisible(true);
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jpMainPanel = new javax.swing.JPanel();
        jlblDefaultFolder = new javax.swing.JLabel();
        jtfDefaultFolder = new javax.swing.JTextField();
        jbtnBrowse = new javax.swing.JButton();
        jlblRecentBooks = new javax.swing.JLabel();
        jspnRecentBooks = new javax.swing.JSpinner();
        jchkRenameImages = new javax.swing.JCheckBox();
        jlblImagesLabel = new javax.swing.JLabel();
        separator = new javax.swing.JSeparator();
        jchkCreateImagesFolder = new javax.swing.JCheckBox();
        jbtnCancel = new javax.swing.JButton();
        jbtnSave = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jpMainPanel.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        java.util.ResourceBundle bundle = java.util.ResourceBundle.getBundle("de/berlios/kcookb/resources/i18n/i18n"); // NOI18N
        jlblDefaultFolder.setText(bundle.getString("Settings.jlblDefaultFolder.text")); // NOI18N

        jtfDefaultFolder.setText(bundle.getString("Settings.jtfDefaultFolder.text")); // NOI18N

        jbtnBrowse.setText(bundle.getString("Settings.jbtnBrowse.text")); // NOI18N
        jbtnBrowse.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnBrowseActionPerformed(evt);
            }
        });

        jlblRecentBooks.setText(bundle.getString("Settings.jlblRecentBooks.text")); // NOI18N

        jspnRecentBooks.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                jspnRecentBooksStateChanged(evt);
            }
        });

        jchkRenameImages.setText(bundle.getString("Settings.jchkRenameImages.text")); // NOI18N
        jchkRenameImages.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jchkRenameImagesActionPerformed(evt);
            }
        });

        jlblImagesLabel.setText(bundle.getString("Settings.jlblImagesLabel.text")); // NOI18N

        jchkCreateImagesFolder.setText(bundle.getString("Settings.jchkCreateImagesFolder.text")); // NOI18N
        jchkCreateImagesFolder.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jchkCreateImagesFolderActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jpMainPanelLayout = new javax.swing.GroupLayout(jpMainPanel);
        jpMainPanel.setLayout(jpMainPanelLayout);
        jpMainPanelLayout.setHorizontalGroup(
            jpMainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpMainPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jpMainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jpMainPanelLayout.createSequentialGroup()
                        .addGroup(jpMainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jpMainPanelLayout.createSequentialGroup()
                                .addGroup(jpMainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jlblDefaultFolder)
                                    .addComponent(jlblRecentBooks))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jpMainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jpMainPanelLayout.createSequentialGroup()
                                        .addComponent(jtfDefaultFolder, javax.swing.GroupLayout.DEFAULT_SIZE, 174, Short.MAX_VALUE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jbtnBrowse))
                                    .addComponent(jspnRecentBooks, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jpMainPanelLayout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addGroup(jpMainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jchkCreateImagesFolder)
                                    .addComponent(jchkRenameImages))))
                        .addContainerGap())
                    .addGroup(jpMainPanelLayout.createSequentialGroup()
                        .addComponent(jlblImagesLabel)
                        .addGap(14, 14, 14)
                        .addComponent(separator, javax.swing.GroupLayout.DEFAULT_SIZE, 288, Short.MAX_VALUE))))
        );
        jpMainPanelLayout.setVerticalGroup(
            jpMainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpMainPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jpMainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jlblDefaultFolder)
                    .addComponent(jtfDefaultFolder, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jbtnBrowse))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jpMainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jlblRecentBooks)
                    .addComponent(jspnRecentBooks, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jpMainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jpMainPanelLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jlblImagesLabel))
                    .addGroup(jpMainPanelLayout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(separator)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jchkRenameImages)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jchkCreateImagesFolder))
        );

        jbtnCancel.setText(bundle.getString("Settings.jbtnCancel.text")); // NOI18N
        jbtnCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnCancelActionPerformed(evt);
            }
        });

        jbtnSave.setText(bundle.getString("Settings.jbtnSave.text")); // NOI18N
        jbtnSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnSaveActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jpMainPanel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jbtnSave)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jbtnCancel)))
                .addContainerGap())
        );

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jbtnCancel, jbtnSave});

        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jpMainPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jbtnCancel)
                    .addComponent(jbtnSave))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jbtnCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnCancelActionPerformed
        dispose();
    }//GEN-LAST:event_jbtnCancelActionPerformed

    private void jbtnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnSaveActionPerformed
        Properties p = ((KCookB)getOwner()).getGlSettings();
        p.setProperty("", "");
        //TODO: save settings
    }//GEN-LAST:event_jbtnSaveActionPerformed

    private void jchkRenameImagesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jchkRenameImagesActionPerformed
        // TODO add your handling code here:
}//GEN-LAST:event_jchkRenameImagesActionPerformed

    private void jchkCreateImagesFolderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jchkCreateImagesFolderActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jchkCreateImagesFolderActionPerformed

    private void jbtnBrowseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnBrowseActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jbtnBrowseActionPerformed

    private void jspnRecentBooksStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_jspnRecentBooksStateChanged
        // TODO add your handling code here:
    }//GEN-LAST:event_jspnRecentBooksStateChanged

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jbtnBrowse;
    private javax.swing.JButton jbtnCancel;
    private javax.swing.JButton jbtnSave;
    private javax.swing.JCheckBox jchkCreateImagesFolder;
    private javax.swing.JCheckBox jchkRenameImages;
    private javax.swing.JLabel jlblDefaultFolder;
    private javax.swing.JLabel jlblImagesLabel;
    private javax.swing.JLabel jlblRecentBooks;
    private javax.swing.JPanel jpMainPanel;
    private javax.swing.JSpinner jspnRecentBooks;
    private javax.swing.JTextField jtfDefaultFolder;
    private javax.swing.JSeparator separator;
    // End of variables declaration//GEN-END:variables
}
