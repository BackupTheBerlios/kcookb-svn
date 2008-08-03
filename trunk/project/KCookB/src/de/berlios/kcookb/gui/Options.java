/**
 *  Copyright (C) 2008  Sérgio Lopes
 *
 *  This file is part of KCookB.
 *
 *  KCookB is free software: you can redistribute it and/or modify
 *  it under the terms of the GNU General Public License as published by
 *  the Free Software Foundation, either version 2 of the License, or
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

import de.berlios.kcookb.model.utils.Settings;
import javax.swing.JFileChooser;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

/**
 *
 * @author  Knitter
 */
public class Options extends javax.swing.JDialog {

    private boolean dirty;

    /** Creates new form Options */
    public Options(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        jtfEmail.getDocument().addDocumentListener(new DocumentListener() {

            public void insertUpdate(DocumentEvent e) {
                dirty = true;
            }

            public void removeUpdate(DocumentEvent e) {
                dirty = true;
            }

            public void changedUpdate(DocumentEvent e) {
                dirty = true;
            }
        });

        jtfOwnerName.getDocument().addDocumentListener(new DocumentListener() {

            public void insertUpdate(DocumentEvent e) {
                dirty = true;
            }

            public void removeUpdate(DocumentEvent e) {
                dirty = true;
            }

            public void changedUpdate(DocumentEvent e) {
                dirty = true;
            }
        });
        init();
    }

    public void showCentered() {
        setLocation(getParent().getX() + (getParent().getWidth() / 2) - (getWidth() / 2),
                getParent().getY() + (getParent().getHeight() / 2) - (getHeight() / 2));
        setVisible(true);
    }
    
    private void init() {
        jtfEmail.setText(Settings.getSettings().getEmail());
        boolean flag = Settings.getSettings().isUseHome();
        if(!flag) {
            jrbtCustomLocation.setSelected(true);
            jtfCustomLocation.setText(Settings.getSettings().getCustomLocation());
        }
        flag = Settings.getSettings().isUseProxy();
        if(flag) {
            //TODO: set all other fields
        }
        jchkPopulateCategories.setSelected(Settings.getSettings().isPopulateCategories());
        jchkSaveCreationDate.setSelected(Settings.getSettings().isSaveCreationDate());
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btgBookLocation = new javax.swing.ButtonGroup();
        jbtnHelp = new javax.swing.JButton();
        jbtnCancel = new javax.swing.JButton();
        jbtnApply = new javax.swing.JButton();
        jpBookLocation = new javax.swing.JPanel();
        jtfCustomLocation = new javax.swing.JTextField();
        jbtnBrowseLocation = new javax.swing.JButton();
        jrbtUseHome = new javax.swing.JRadioButton();
        jrbtCustomLocation = new javax.swing.JRadioButton();
        jpNewBookOptions = new javax.swing.JPanel();
        jlblOwnerName = new javax.swing.JLabel();
        jtfOwnerName = new javax.swing.JTextField();
        jlblEmail = new javax.swing.JLabel();
        jtfEmail = new javax.swing.JTextField();
        jchkSaveCreationDate = new javax.swing.JCheckBox();
        jchkPopulateCategories = new javax.swing.JCheckBox();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("null");
        setResizable(false);

        java.util.ResourceBundle bundle = java.util.ResourceBundle.getBundle("de/berlios/kcookb/resources/i18n/i18n"); // NOI18N
        jbtnHelp.setText(bundle.getString("OPTIONSDIALOG_HELPBUTTON")); // NOI18N
        jbtnHelp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnHelpActionPerformed(evt);
            }
        });

        jbtnCancel.setText(bundle.getString("OPTIONSDIALOG_CANCELBUTTON")); // NOI18N
        jbtnCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnCancelActionPerformed(evt);
            }
        });

        jbtnApply.setText(bundle.getString("OPTIONSDIALOG_APPLYBUTTON")); // NOI18N
        jbtnApply.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnApplyActionPerformed(evt);
            }
        });

        jpBookLocation.setBorder(javax.swing.BorderFactory.createTitledBorder(bundle.getString("OPTIONSDIALOG_BOOKLOCATIONBORDER"))); // NOI18N

        jtfCustomLocation.setEnabled(false);

        jbtnBrowseLocation.setText(bundle.getString("Options.jbtnBrowseLocation.text")); // NOI18N
        jbtnBrowseLocation.setToolTipText("null");
        jbtnBrowseLocation.setEnabled(false);
        jbtnBrowseLocation.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnBrowseLocationActionPerformed(evt);
            }
        });

        btgBookLocation.add(jrbtUseHome);
        jrbtUseHome.setSelected(true);
        jrbtUseHome.setText(bundle.getString("OPTIONSDIALOG_USEHOMEOPTION")); // NOI18N
        jrbtUseHome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jrbtUseHomeActionPerformed(evt);
            }
        });

        btgBookLocation.add(jrbtCustomLocation);
        jrbtCustomLocation.setText(bundle.getString("OPTIONSDIALOG_CUSTOMOPTION")); // NOI18N
        jrbtCustomLocation.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jrbtCustomLocationActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jpBookLocationLayout = new javax.swing.GroupLayout(jpBookLocation);
        jpBookLocation.setLayout(jpBookLocationLayout);
        jpBookLocationLayout.setHorizontalGroup(
            jpBookLocationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpBookLocationLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jpBookLocationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jrbtUseHome)
                    .addGroup(jpBookLocationLayout.createSequentialGroup()
                        .addComponent(jrbtCustomLocation)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jtfCustomLocation, javax.swing.GroupLayout.DEFAULT_SIZE, 205, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jbtnBrowseLocation)))
                .addContainerGap())
        );
        jpBookLocationLayout.setVerticalGroup(
            jpBookLocationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpBookLocationLayout.createSequentialGroup()
                .addComponent(jrbtUseHome)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jpBookLocationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jrbtCustomLocation)
                    .addComponent(jbtnBrowseLocation)
                    .addComponent(jtfCustomLocation, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jpNewBookOptions.setBorder(javax.swing.BorderFactory.createTitledBorder(bundle.getString("OPTIONSDIALOG_NEWBOOKBORDER"))); // NOI18N

        jlblOwnerName.setText(bundle.getString("OPTIONSDIALOG_NEWBOOKOWNER")); // NOI18N

        jlblEmail.setText(bundle.getString("OPTIONSDIALOG_NEWBOOKOWNEREMAIL")); // NOI18N

        jchkSaveCreationDate.setSelected(true);
        jchkSaveCreationDate.setText(bundle.getString("OPTIONSDIALOG_SAVECREATIONDATEOPTION")); // NOI18N
        jchkSaveCreationDate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jchkSaveCreationDateActionPerformed(evt);
            }
        });

        jchkPopulateCategories.setSelected(true);
        jchkPopulateCategories.setText(bundle.getString("OPTIONSDIALOG_POPULATECATEGORIESOPTION")); // NOI18N
        jchkPopulateCategories.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jchkPopulateCategoriesActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jpNewBookOptionsLayout = new javax.swing.GroupLayout(jpNewBookOptions);
        jpNewBookOptions.setLayout(jpNewBookOptionsLayout);
        jpNewBookOptionsLayout.setHorizontalGroup(
            jpNewBookOptionsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpNewBookOptionsLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jpNewBookOptionsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jlblEmail)
                    .addComponent(jlblOwnerName))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jpNewBookOptionsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jtfOwnerName, javax.swing.GroupLayout.DEFAULT_SIZE, 271, Short.MAX_VALUE)
                    .addComponent(jchkSaveCreationDate)
                    .addComponent(jchkPopulateCategories)
                    .addComponent(jtfEmail, javax.swing.GroupLayout.DEFAULT_SIZE, 271, Short.MAX_VALUE))
                .addContainerGap())
        );
        jpNewBookOptionsLayout.setVerticalGroup(
            jpNewBookOptionsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpNewBookOptionsLayout.createSequentialGroup()
                .addGroup(jpNewBookOptionsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jlblOwnerName)
                    .addComponent(jtfOwnerName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jpNewBookOptionsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jlblEmail)
                    .addComponent(jtfEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jchkSaveCreationDate)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jchkPopulateCategories)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jpBookLocation, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jpNewBookOptions, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(10, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jbtnApply)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jbtnCancel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jbtnHelp)
                        .addContainerGap())))
        );

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jbtnApply, jbtnCancel, jbtnHelp});

        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jpNewBookOptions, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jpBookLocation, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jbtnHelp)
                    .addComponent(jbtnCancel)
                    .addComponent(jbtnApply))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jbtnHelpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnHelpActionPerformed
        //TODO: help for Options dialog
}//GEN-LAST:event_jbtnHelpActionPerformed

    private void jbtnCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnCancelActionPerformed
        dispose();
}//GEN-LAST:event_jbtnCancelActionPerformed

    private void jbtnApplyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnApplyActionPerformed
        if (dirty) {
            Settings.getSettings().saveSettings();
            dirty = false;
        }
}//GEN-LAST:event_jbtnApplyActionPerformed

    private void jbtnBrowseLocationActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnBrowseLocationActionPerformed
        JFileChooser jfc = new JFileChooser(System.getProperty("user.home"));
        jfc.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        jfc.setMultiSelectionEnabled(false);
        if (jfc.showOpenDialog(this) == JFileChooser.APPROVE_OPTION) {
            jtfCustomLocation.setText(jfc.getSelectedFile().getAbsolutePath().trim());
        }
}//GEN-LAST:event_jbtnBrowseLocationActionPerformed

    private void jrbtCustomLocationActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jrbtCustomLocationActionPerformed
        jtfCustomLocation.setEditable(true);
        jbtnBrowseLocation.setEnabled(true);
        dirty = true;
    }//GEN-LAST:event_jrbtCustomLocationActionPerformed

    private void jrbtUseHomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jrbtUseHomeActionPerformed
        jtfCustomLocation.setEditable(false);
        jbtnBrowseLocation.setEnabled(false);
        dirty = true;
    }//GEN-LAST:event_jrbtUseHomeActionPerformed

private void jchkSaveCreationDateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jchkSaveCreationDateActionPerformed
    dirty = true;
}//GEN-LAST:event_jchkSaveCreationDateActionPerformed

private void jchkPopulateCategoriesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jchkPopulateCategoriesActionPerformed
    dirty = true;
}//GEN-LAST:event_jchkPopulateCategoriesActionPerformed
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup btgBookLocation;
    private javax.swing.JButton jbtnApply;
    private javax.swing.JButton jbtnBrowseLocation;
    private javax.swing.JButton jbtnCancel;
    private javax.swing.JButton jbtnHelp;
    private javax.swing.JCheckBox jchkPopulateCategories;
    private javax.swing.JCheckBox jchkSaveCreationDate;
    private javax.swing.JLabel jlblEmail;
    private javax.swing.JLabel jlblOwnerName;
    private javax.swing.JPanel jpBookLocation;
    private javax.swing.JPanel jpNewBookOptions;
    private javax.swing.JRadioButton jrbtCustomLocation;
    private javax.swing.JRadioButton jrbtUseHome;
    private javax.swing.JTextField jtfCustomLocation;
    private javax.swing.JTextField jtfEmail;
    private javax.swing.JTextField jtfOwnerName;
    // End of variables declaration//GEN-END:variables
}
