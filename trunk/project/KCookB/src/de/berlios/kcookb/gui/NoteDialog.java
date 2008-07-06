/*
 * NoteDialog.java
 *
 * Created on 14 de Abril de 2008, 1:51
 */
package de.berlios.kcookb.gui;

import de.berlios.kcookb.model.Note;

/**
 *
 * @author  Knitter
 */
public class NoteDialog extends javax.swing.JDialog {

    private Note note;

    /** Creates new form NoteDialog */
    public NoteDialog(java.awt.Frame parent, boolean modal, Note note) {
        super(parent, modal);
        this.note = note;
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

        jpNotes = new javax.swing.JPanel();
        jscpNotes = new javax.swing.JScrollPane();
        jtaNotes = new javax.swing.JTextArea();
        jbtnHelp = new javax.swing.JButton();
        jbtnCancel = new javax.swing.JButton();
        jbtnSave = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        java.util.ResourceBundle bundle = java.util.ResourceBundle.getBundle("de/berlios/kcookb/resources/i18n/i18n"); // NOI18N
        jpNotes.setBorder(javax.swing.BorderFactory.createTitledBorder(bundle.getString("NoteDialog.jpNotes.border.title"))); // NOI18N

        jtaNotes.setColumns(20);
        jtaNotes.setRows(5);
        jscpNotes.setViewportView(jtaNotes);

        javax.swing.GroupLayout jpNotesLayout = new javax.swing.GroupLayout(jpNotes);
        jpNotes.setLayout(jpNotesLayout);
        jpNotesLayout.setHorizontalGroup(
            jpNotesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpNotesLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jscpNotes, javax.swing.GroupLayout.DEFAULT_SIZE, 466, Short.MAX_VALUE)
                .addContainerGap())
        );
        jpNotesLayout.setVerticalGroup(
            jpNotesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpNotesLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jscpNotes, javax.swing.GroupLayout.DEFAULT_SIZE, 339, Short.MAX_VALUE)
                .addContainerGap())
        );

        jbtnHelp.setText(bundle.getString("NoteDialog.jbtnHelp.text")); // NOI18N
        jbtnHelp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnHelpActionPerformed(evt);
            }
        });

        jbtnCancel.setText(bundle.getString("NoteDialog.jbtnCancel.text")); // NOI18N
        jbtnCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnCancelActionPerformed(evt);
            }
        });

        jbtnSave.setText(bundle.getString("NoteDialog.jbtnSave.text")); // NOI18N
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
                    .addComponent(jpNotes, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jbtnSave)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jbtnCancel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jbtnHelp)))
                .addContainerGap())
        );

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jbtnCancel, jbtnHelp, jbtnSave});

        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jpNotes, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jbtnHelp)
                    .addComponent(jbtnCancel)
                    .addComponent(jbtnSave))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jbtnCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnCancelActionPerformed
        dispose();
}//GEN-LAST:event_jbtnCancelActionPerformed

    private void jbtnHelpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnHelpActionPerformed
        //TODO: help for NoteDialog
}//GEN-LAST:event_jbtnHelpActionPerformed

    private void jbtnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnSaveActionPerformed
        if(!jtaNotes.getText().trim().isEmpty()) {
            note.setText(jtaNotes.getText().trim());
        }
}//GEN-LAST:event_jbtnSaveActionPerformed
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jbtnCancel;
    private javax.swing.JButton jbtnHelp;
    private javax.swing.JButton jbtnSave;
    private javax.swing.JPanel jpNotes;
    private javax.swing.JScrollPane jscpNotes;
    private javax.swing.JTextArea jtaNotes;
    // End of variables declaration//GEN-END:variables
}