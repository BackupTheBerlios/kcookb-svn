/*
 * Search.java
 *
 * Created on 28 de Março de 2008, 0:00
 */
package de.berlios.kcookb.gui;

import de.berlios.kcookb.model.Recipe;
import de.berlios.kcookb.model.RecipeDificulty;
import de.berlios.kcookb.model.RecipePrice;
import java.util.List;
import javax.swing.DefaultListModel;
import javax.swing.JList;

/**
 *
 * @author  Knitter
 */
public class Search extends javax.swing.JDialog {

    private DefaultListModel model;

    /** Creates new form Search */
    public Search(java.awt.Frame parent, boolean modal, String text) {
        super(parent, modal);
        initComponents();
        if (text != null && !text.isEmpty()) {
            KCookBGui g = (KCookBGui) getParent();
            List<Recipe> rs = g.getBook().searchByName(text);
            model.clear();
            for (Recipe r : rs) {
                model.addElement(r);
            }
        }
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

        jpResults = new javax.swing.JPanel();
        jscpResults = new javax.swing.JScrollPane();
        jlstResults = new JList(model = new DefaultListModel());
        jbtnHelp = new javax.swing.JButton();
        jbtnCancel = new javax.swing.JButton();
        jpOptions = new javax.swing.JPanel();
        jlblText = new javax.swing.JLabel();
        jtfText = new javax.swing.JTextField();
        jSeparator1 = new javax.swing.JSeparator();
        jbtnSearch = new javax.swing.JButton();
        jchkSearchInDescription = new javax.swing.JCheckBox();
        jchkSearchInType = new javax.swing.JCheckBox();
        jchkSearchInIngredientes = new javax.swing.JCheckBox();
        jchkSearchInLabel = new javax.swing.JCheckBox();
        jlbljchkSearchIn = new javax.swing.JLabel();
        jcbxDificulty = new javax.swing.JComboBox();
        jlblDificulty = new javax.swing.JLabel();
        jlblPrice = new javax.swing.JLabel();
        jcbxPrice = new javax.swing.JComboBox();
        jchkSearchInRating = new javax.swing.JCheckBox();
        jbtnShow = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        java.util.ResourceBundle bundle = java.util.ResourceBundle.getBundle("de/berlios/kcookb/resources/i18n/i18n"); // NOI18N
        jpResults.setBorder(javax.swing.BorderFactory.createTitledBorder(bundle.getString("Search.jpResults.border.title"))); // NOI18N

        jlstResults.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jscpResults.setViewportView(jlstResults);

        javax.swing.GroupLayout jpResultsLayout = new javax.swing.GroupLayout(jpResults);
        jpResults.setLayout(jpResultsLayout);
        jpResultsLayout.setHorizontalGroup(
            jpResultsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpResultsLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jscpResults, javax.swing.GroupLayout.DEFAULT_SIZE, 514, Short.MAX_VALUE)
                .addContainerGap())
        );
        jpResultsLayout.setVerticalGroup(
            jpResultsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpResultsLayout.createSequentialGroup()
                .addComponent(jscpResults, javax.swing.GroupLayout.DEFAULT_SIZE, 288, Short.MAX_VALUE)
                .addContainerGap())
        );

        jbtnHelp.setText(bundle.getString("Search.jbtnHelp.text")); // NOI18N
        jbtnHelp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnHelpActionPerformed(evt);
            }
        });

        jbtnCancel.setText(bundle.getString("Search.jbtnCancel.text")); // NOI18N
        jbtnCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnCancelActionPerformed(evt);
            }
        });

        jpOptions.setBorder(javax.swing.BorderFactory.createTitledBorder(bundle.getString("Search.jpOptions.border.title"))); // NOI18N

        jlblText.setText(bundle.getString("Search.jlblText.text")); // NOI18N

        jbtnSearch.setText(bundle.getString("Search.jbtnSearch.text")); // NOI18N
        jbtnSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnSearchActionPerformed(evt);
            }
        });

        jchkSearchInDescription.setText(bundle.getString("Search.jchkSearchInDescription.text")); // NOI18N

        jchkSearchInType.setText(bundle.getString("Search.jchkSearchInType.text")); // NOI18N

        jchkSearchInIngredientes.setText(bundle.getString("Search.jchkSearchInIngredientes.text")); // NOI18N

        jchkSearchInLabel.setText(bundle.getString("Search.jchkSearchInLabel.text")); // NOI18N

        jlbljchkSearchIn.setText(bundle.getString("Search.jlbljchkSearchIn.text")); // NOI18N

        jlblDificulty.setText(bundle.getString("Search.jlblDificulty.text")); // NOI18N

        jlblPrice.setText(bundle.getString("Search.jlblPrice.text")); // NOI18N

        jchkSearchInRating.setText(bundle.getString("Search.jchkSearchInRating.text")); // NOI18N

        javax.swing.GroupLayout jpOptionsLayout = new javax.swing.GroupLayout(jpOptions);
        jpOptions.setLayout(jpOptionsLayout);
        jpOptionsLayout.setHorizontalGroup(
            jpOptionsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpOptionsLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jpOptionsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jpOptionsLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jpOptionsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jpOptionsLayout.createSequentialGroup()
                                .addComponent(jlbljchkSearchIn)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jSeparator1, javax.swing.GroupLayout.DEFAULT_SIZE, 458, Short.MAX_VALUE))
                            .addGroup(jpOptionsLayout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addGroup(jpOptionsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jpOptionsLayout.createSequentialGroup()
                                        .addComponent(jchkSearchInDescription)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jchkSearchInType)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jchkSearchInLabel)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jchkSearchInIngredientes)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jchkSearchInRating))
                                    .addGroup(jpOptionsLayout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jlblDificulty)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jcbxDificulty, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(jlblPrice)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jcbxPrice, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                    .addGroup(jpOptionsLayout.createSequentialGroup()
                        .addComponent(jlblText)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jtfText, javax.swing.GroupLayout.DEFAULT_SIZE, 390, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jbtnSearch)))
                .addContainerGap())
        );
        jpOptionsLayout.setVerticalGroup(
            jpOptionsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpOptionsLayout.createSequentialGroup()
                .addGroup(jpOptionsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jlblText)
                    .addComponent(jbtnSearch)
                    .addComponent(jtfText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jpOptionsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jlbljchkSearchIn)
                    .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 11, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jpOptionsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jchkSearchInDescription)
                    .addComponent(jchkSearchInType)
                    .addComponent(jchkSearchInLabel)
                    .addComponent(jchkSearchInIngredientes)
                    .addComponent(jchkSearchInRating))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jpOptionsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jlblPrice)
                    .addComponent(jcbxPrice, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jlblDificulty)
                    .addComponent(jcbxDificulty, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jbtnShow.setText(bundle.getString("Search.jbtnShow.text")); // NOI18N
        jbtnShow.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnShowActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jpResults, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jbtnShow)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jbtnCancel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jbtnHelp))
                    .addComponent(jpOptions, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jpOptions, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jpResults, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jbtnHelp)
                    .addComponent(jbtnCancel)
                    .addComponent(jbtnShow))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

private void jbtnSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnSearchActionPerformed
    if (!jtfText.getText().trim().isEmpty()) {
        KCookBGui g = (KCookBGui) getParent();
        List<Recipe> rs = g.getBook().search(jtfText.getText().trim(), jchkSearchInDescription.isSelected(),
                jchkSearchInIngredientes.isSelected(), jchkSearchInLabel.isSelected(),
                jchkSearchInRating.isSelected(), jchkSearchInType.isSelected(),
                (RecipeDificulty) jcbxDificulty.getSelectedItem(), (RecipePrice) jcbxPrice.getSelectedItem());
        model.clear();
        for (Recipe r : rs) {
            model.addElement(r);
        }
    }
}//GEN-LAST:event_jbtnSearchActionPerformed

private void jbtnShowActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnShowActionPerformed
    ((KCookBGui) getParent()).showRecipe((Recipe) model.getElementAt(jlstResults.getSelectedIndex()));
}//GEN-LAST:event_jbtnShowActionPerformed

private void jbtnHelpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnHelpActionPerformed
// TODO add your handling code here:
}//GEN-LAST:event_jbtnHelpActionPerformed

private void jbtnCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnCancelActionPerformed
    dispose();
}//GEN-LAST:event_jbtnCancelActionPerformed
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JButton jbtnCancel;
    private javax.swing.JButton jbtnHelp;
    private javax.swing.JButton jbtnSearch;
    private javax.swing.JButton jbtnShow;
    private javax.swing.JComboBox jcbxDificulty;
    private javax.swing.JComboBox jcbxPrice;
    private javax.swing.JCheckBox jchkSearchInDescription;
    private javax.swing.JCheckBox jchkSearchInIngredientes;
    private javax.swing.JCheckBox jchkSearchInLabel;
    private javax.swing.JCheckBox jchkSearchInRating;
    private javax.swing.JCheckBox jchkSearchInType;
    private javax.swing.JLabel jlblDificulty;
    private javax.swing.JLabel jlblPrice;
    private javax.swing.JLabel jlblText;
    private javax.swing.JLabel jlbljchkSearchIn;
    private javax.swing.JList jlstResults;
    private javax.swing.JPanel jpOptions;
    private javax.swing.JPanel jpResults;
    private javax.swing.JScrollPane jscpResults;
    private javax.swing.JTextField jtfText;
    // End of variables declaration//GEN-END:variables
}
