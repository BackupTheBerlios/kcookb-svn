/*
 *  KCookB.java
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

import de.berlios.kcookb.model.KCBEngine;
import de.berlios.kcookb.model.Recipe;
import de.berlios.kcookb.model.listeners.KCBEngineEvent;
import de.berlios.kcookb.model.listeners.KCBEngineListener;
import java.awt.Desktop;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Properties;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.LogManager;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeCellRenderer;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.MutableTreeNode;

public class KCookB extends javax.swing.JFrame implements KCBEngineListener {

    private KCBEngine engine;
    private KCookB me = this;
    private Properties glSettings;
    public static final String BUNDLE_PATH = "de/berlios/kcookb/resources/i18n/i18n";
    private ResourceBundle rBundle;
    private DefaultTreeModel tmAll;
    private MutableTreeNode rootNode;

    /** Creates new form KCookB */
    public KCookB() {
        loadSettingsFile();
        engine = new KCBEngine();
        engine.addListener(this);
        rBundle = ResourceBundle.getBundle(KCookB.BUNDLE_PATH);
        initComponents();

        DefaultTreeCellRenderer renderer = new DefaultTreeCellRenderer();
        //ImageIcon rootIcon = new ImageIcon(getClass().getResource("/de/berlios/kcookb/resources/book.png"));
        ImageIcon leaftIcon = new ImageIcon(getClass().getResource("/de/berlios/kcookb/resources/page.png"));
        ImageIcon closedIcon = new ImageIcon(getClass().getResource("/de/berlios/kcookb/resources/book.png"));
        ImageIcon openedIcon = new ImageIcon(getClass().getResource("/de/berlios/kcookb/resources/book_open.png"));
        renderer.setClosedIcon(closedIcon);
        renderer.setLeafIcon(leaftIcon);
        renderer.setOpenIcon(openedIcon);

        jtAllRecipes.setCellRenderer(renderer);

    }

    //TODO:
    private void loadSettingsFile() {
        glSettings = new Properties();
        try {
            File home = new File(System.getProperty("user.home") + File.separator + ".kcookb");
            if (home.exists() && home.isDirectory()) {
                File setf = new File(home + File.separator + "settings.xml");
                if (!setf.exists()) {
                    setf.createNewFile();
                }
                glSettings.loadFromXML(new FileInputStream(setf));
            }
        } catch (IOException ex) {
            Logger.getLogger(KCookB.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void createBook() {
        if (engine.hasOpenBook()) {
            if (JOptionPane.showConfirmDialog(this, rBundle.getString("KCookB.openBookExists.message"),
                    rBundle.getString("KCookB.openBookExists.title"),
                    JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.WARNING_MESSAGE,
                    new ImageIcon(getClass().getResource("/de/berlios/kcookb/resources/error.png"))) !=
                    JOptionPane.OK_OPTION) {
                return;
            }
        }
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                new CreateBook(me, true, engine, glSettings.getProperty("default-home",
                        System.getProperty("user.home"))).setVisible(true);
            }
        });
    }

    private void openBook() {
        if (engine.hasOpenBook()) {
            if (JOptionPane.showConfirmDialog(this, rBundle.getString("KCookB.openBookExists.message"),
                    rBundle.getString("KCookB.openBookExists.title"),
                    JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.WARNING_MESSAGE,
                    new ImageIcon(getClass().getResource("/de/berlios/kcookb/resources/error.png"))) !=
                    JOptionPane.OK_OPTION) {
                return;
            }
        }

        JFileChooser jfc = new JFileChooser();
        //jfc.setFileFilter(new KCBFileFilter());
        //jfc.setFileView(new KCBFileView());

        if (jfc.showOpenDialog(this) == JFileChooser.APPROVE_OPTION) {
            engine.openBook(jfc.getSelectedFile().getAbsolutePath());
        }
    }

    private void toggleExistingBookOptions(boolean state) {
        //FILE MENU OPTIONS
        jmiCloseBook.setEnabled(state);
        jmiExport.setEnabled(state);
        jmiPrint.setEnabled(state);

        //EDIT MENU
        jmEdit.setEnabled(state);

        //TOOLS MENU
        jmiZip.setEnabled(state);

        //TOOLBAR BUTTONS
        jbtnNewRecipe.setEnabled(state);
        jbtEditRecipe.setEnabled(state);
        jbtnRemoveRecipe.setEnabled(state);
        jbtnPrintCurrent.setEnabled(state);
        jtfSearchField.setEnabled(state);
        jbtnSearch.setEnabled(state);
        jbtnNext.setEnabled(state);
        jbtnPrevious.setEnabled(state);

    }

    private void printCurrent() {
        //TODO: implement
        throw new UnsupportedOperationException("Not implemented yet!");
    }

    private void showCreateRecipeDialog(final boolean edit) {
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                new CreateRecipe(me, true, edit).setVisible(true);
            }
        });
    }

    public KCBEngine getEngine() {
        return engine;
    }

    public Properties getGlSettings() {
        return glSettings;
    }

    @Override
    public void setVisible(boolean visible) {
        Dimension scrSize = Toolkit.getDefaultToolkit().getScreenSize();
        Dimension mySize = getSize();

        if (mySize.height > scrSize.height) {
            mySize.height = scrSize.height;
        }

        if (mySize.width > scrSize.width) {
            mySize.width = scrSize.width;
        }

        setLocation((scrSize.width - mySize.width) / 2,
                (scrSize.height - mySize.height) / 2);
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

        jtbMainToolbar = new javax.swing.JToolBar();
        jbtnNewBook = new javax.swing.JButton();
        jbtnOpenBook = new javax.swing.JButton();
        separator7 = new javax.swing.JToolBar.Separator();
        jbtnNewRecipe = new javax.swing.JButton();
        jbtEditRecipe = new javax.swing.JButton();
        jbtnRemoveRecipe = new javax.swing.JButton();
        separator8 = new javax.swing.JToolBar.Separator();
        jbtnPrintCurrent = new javax.swing.JButton();
        separator9 = new javax.swing.JToolBar.Separator();
        jtfSearchField = new javax.swing.JTextField();
        jbtnSearch = new javax.swing.JButton();
        separator10 = new javax.swing.JToolBar.Separator();
        jbtnPrevious = new javax.swing.JButton();
        jbtnNext = new javax.swing.JButton();
        jspMainSplit = new javax.swing.JSplitPane();
        jtbpMainTab = new javax.swing.JTabbedPane();
        jpAllRecipes = new javax.swing.JPanel();
        jscAllRecipes = new javax.swing.JScrollPane();
        jtAllRecipes = new javax.swing.JTree();
        jpTaggedRecipes = new javax.swing.JPanel();
        jscTaggedRecipe = new javax.swing.JScrollPane();
        jtTaggedRecipes = new javax.swing.JTree();
        jpStaredRecipes = new javax.swing.JPanel();
        jscStaredRecipes = new javax.swing.JScrollPane();
        jtStaredRecipes = new javax.swing.JTree();
        jpMainPanel = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextPane1 = new javax.swing.JTextPane();
        jmbMenuBar = new javax.swing.JMenuBar();
        jmFile = new javax.swing.JMenu();
        jmiNewBook = new javax.swing.JMenuItem();
        separator13 = new javax.swing.JSeparator();
        jmiOpenBook = new javax.swing.JMenuItem();
        jmRecent = new javax.swing.JMenu();
        jmiCloseBook = new javax.swing.JMenuItem();
        separator2 = new javax.swing.JSeparator();
        jmiExport = new javax.swing.JMenuItem();
        jmiImport = new javax.swing.JMenuItem();
        separator4 = new javax.swing.JSeparator();
        jmiPrint = new javax.swing.JMenuItem();
        separator3 = new javax.swing.JSeparator();
        jmiExit = new javax.swing.JMenuItem();
        jmEdit = new javax.swing.JMenu();
        jmiNewRecipe = new javax.swing.JMenuItem();
        jmiEditRecipe = new javax.swing.JMenuItem();
        jmiDeleteRecipe = new javax.swing.JMenuItem();
        separator12 = new javax.swing.JSeparator();
        jmiFind = new javax.swing.JMenuItem();
        jmTools = new javax.swing.JMenu();
        jmiZip = new javax.swing.JMenuItem();
        jmiPlugins = new javax.swing.JMenuItem();
        separator11 = new javax.swing.JSeparator();
        jmiOptions = new javax.swing.JMenuItem();
        jmHelp = new javax.swing.JMenu();
        jmiHelp = new javax.swing.JMenuItem();
        separator6 = new javax.swing.JSeparator();
        jmiWeb = new javax.swing.JMenuItem();
        separator5 = new javax.swing.JSeparator();
        jmiAbout = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jtbMainToolbar.setFloatable(false);
        jtbMainToolbar.setRollover(true);

        jbtnNewBook.setIcon(new javax.swing.ImageIcon(getClass().getResource("/de/berlios/kcookb/resources/book_add.png"))); // NOI18N
        jbtnNewBook.setFocusable(false);
        jbtnNewBook.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jbtnNewBook.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jbtnNewBook.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnNewBookActionPerformed(evt);
            }
        });
        jtbMainToolbar.add(jbtnNewBook);

        jbtnOpenBook.setIcon(new javax.swing.ImageIcon(getClass().getResource("/de/berlios/kcookb/resources/book_open.png"))); // NOI18N
        jbtnOpenBook.setFocusable(false);
        jbtnOpenBook.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jbtnOpenBook.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jbtnOpenBook.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnOpenBookActionPerformed(evt);
            }
        });
        jtbMainToolbar.add(jbtnOpenBook);
        jtbMainToolbar.add(separator7);

        jbtnNewRecipe.setIcon(new javax.swing.ImageIcon(getClass().getResource("/de/berlios/kcookb/resources/page_add.png"))); // NOI18N
        jbtnNewRecipe.setEnabled(false);
        jbtnNewRecipe.setFocusable(false);
        jbtnNewRecipe.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jbtnNewRecipe.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jbtnNewRecipe.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnNewRecipeActionPerformed(evt);
            }
        });
        jtbMainToolbar.add(jbtnNewRecipe);

        jbtEditRecipe.setIcon(new javax.swing.ImageIcon(getClass().getResource("/de/berlios/kcookb/resources/page_edit.png"))); // NOI18N
        jbtEditRecipe.setEnabled(false);
        jbtEditRecipe.setFocusable(false);
        jbtEditRecipe.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jbtEditRecipe.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jbtEditRecipe.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtEditRecipeActionPerformed(evt);
            }
        });
        jtbMainToolbar.add(jbtEditRecipe);

        jbtnRemoveRecipe.setIcon(new javax.swing.ImageIcon(getClass().getResource("/de/berlios/kcookb/resources/page_delete.png"))); // NOI18N
        jbtnRemoveRecipe.setEnabled(false);
        jbtnRemoveRecipe.setFocusable(false);
        jbtnRemoveRecipe.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jbtnRemoveRecipe.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jbtnRemoveRecipe.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnRemoveRecipeActionPerformed(evt);
            }
        });
        jtbMainToolbar.add(jbtnRemoveRecipe);
        jtbMainToolbar.add(separator8);

        jbtnPrintCurrent.setIcon(new javax.swing.ImageIcon(getClass().getResource("/de/berlios/kcookb/resources/printer.png"))); // NOI18N
        jbtnPrintCurrent.setEnabled(false);
        jbtnPrintCurrent.setFocusable(false);
        jbtnPrintCurrent.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jbtnPrintCurrent.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jbtnPrintCurrent.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnPrintCurrentActionPerformed(evt);
            }
        });
        jtbMainToolbar.add(jbtnPrintCurrent);
        jtbMainToolbar.add(separator9);

        jtfSearchField.setHorizontalAlignment(javax.swing.JTextField.TRAILING);
        java.util.ResourceBundle bundle = java.util.ResourceBundle.getBundle("de/berlios/kcookb/resources/i18n/i18n"); // NOI18N
        jtfSearchField.setText(bundle.getString("KCookB.jtfSearchField.text")); // NOI18N
        jtfSearchField.setEnabled(false);
        jtfSearchField.setMaximumSize(new java.awt.Dimension(150, 20));
        jtbMainToolbar.add(jtfSearchField);

        jbtnSearch.setIcon(new javax.swing.ImageIcon(getClass().getResource("/de/berlios/kcookb/resources/magnifier.png"))); // NOI18N
        jbtnSearch.setEnabled(false);
        jbtnSearch.setFocusable(false);
        jbtnSearch.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jbtnSearch.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jbtnSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnSearchActionPerformed(evt);
            }
        });
        jtbMainToolbar.add(jbtnSearch);
        jtbMainToolbar.add(separator10);

        jbtnPrevious.setIcon(new javax.swing.ImageIcon(getClass().getResource("/de/berlios/kcookb/resources/resultset_previous.png"))); // NOI18N
        jbtnPrevious.setEnabled(false);
        jbtnPrevious.setFocusable(false);
        jbtnPrevious.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jbtnPrevious.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jbtnPrevious.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnPreviousActionPerformed(evt);
            }
        });
        jtbMainToolbar.add(jbtnPrevious);

        jbtnNext.setIcon(new javax.swing.ImageIcon(getClass().getResource("/de/berlios/kcookb/resources/resultset_next.png"))); // NOI18N
        jbtnNext.setEnabled(false);
        jbtnNext.setFocusable(false);
        jbtnNext.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jbtnNext.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jbtnNext.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnNextActionPerformed(evt);
            }
        });
        jtbMainToolbar.add(jbtnNext);

        jspMainSplit.setDividerLocation(120);

        jtbpMainTab.setTabPlacement(javax.swing.JTabbedPane.BOTTOM);

        jtAllRecipes.setModel(null);
        jtAllRecipes.addTreeSelectionListener(new javax.swing.event.TreeSelectionListener() {
            public void valueChanged(javax.swing.event.TreeSelectionEvent evt) {
                jtAllRecipesValueChanged(evt);
            }
        });
        jscAllRecipes.setViewportView(jtAllRecipes);

        javax.swing.GroupLayout jpAllRecipesLayout = new javax.swing.GroupLayout(jpAllRecipes);
        jpAllRecipes.setLayout(jpAllRecipesLayout);
        jpAllRecipesLayout.setHorizontalGroup(
            jpAllRecipesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jscAllRecipes, javax.swing.GroupLayout.DEFAULT_SIZE, 114, Short.MAX_VALUE)
        );
        jpAllRecipesLayout.setVerticalGroup(
            jpAllRecipesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jscAllRecipes, javax.swing.GroupLayout.DEFAULT_SIZE, 495, Short.MAX_VALUE)
        );

        jtbpMainTab.addTab(bundle.getString("KCookB.jpAllRecipes.TabConstraints.tabTitle"), null, jpAllRecipes, bundle.getString("KCookB.jpAllRecipes.TabConstraints.tabToolTip")); // NOI18N

        jtTaggedRecipes.setModel(null);
        jscTaggedRecipe.setViewportView(jtTaggedRecipes);

        javax.swing.GroupLayout jpTaggedRecipesLayout = new javax.swing.GroupLayout(jpTaggedRecipes);
        jpTaggedRecipes.setLayout(jpTaggedRecipesLayout);
        jpTaggedRecipesLayout.setHorizontalGroup(
            jpTaggedRecipesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jscTaggedRecipe, javax.swing.GroupLayout.DEFAULT_SIZE, 114, Short.MAX_VALUE)
        );
        jpTaggedRecipesLayout.setVerticalGroup(
            jpTaggedRecipesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jscTaggedRecipe, javax.swing.GroupLayout.DEFAULT_SIZE, 495, Short.MAX_VALUE)
        );

        jtbpMainTab.addTab(bundle.getString("KCookB.jpTaggedRecipes.TabConstraints.tabTitle"), new javax.swing.ImageIcon(getClass().getResource("/de/berlios/kcookb/resources/tag_blue.png")), jpTaggedRecipes, bundle.getString("KCookB.jpTaggedRecipes.TabConstraints.tabToolTip")); // NOI18N

        jtStaredRecipes.setModel(null);
        jscStaredRecipes.setViewportView(jtStaredRecipes);

        javax.swing.GroupLayout jpStaredRecipesLayout = new javax.swing.GroupLayout(jpStaredRecipes);
        jpStaredRecipes.setLayout(jpStaredRecipesLayout);
        jpStaredRecipesLayout.setHorizontalGroup(
            jpStaredRecipesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jscStaredRecipes, javax.swing.GroupLayout.DEFAULT_SIZE, 114, Short.MAX_VALUE)
        );
        jpStaredRecipesLayout.setVerticalGroup(
            jpStaredRecipesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jscStaredRecipes, javax.swing.GroupLayout.DEFAULT_SIZE, 495, Short.MAX_VALUE)
        );

        jtbpMainTab.addTab(bundle.getString("KCookB.jpStaredRecipes.TabConstraints.tabTitle"), new javax.swing.ImageIcon(getClass().getResource("/de/berlios/kcookb/resources/star.png")), jpStaredRecipes, bundle.getString("KCookB.jpStaredRecipes.TabConstraints.tabToolTip")); // NOI18N

        jspMainSplit.setLeftComponent(jtbpMainTab);

        jScrollPane1.setViewportView(jTextPane1);

        javax.swing.GroupLayout jpMainPanelLayout = new javax.swing.GroupLayout(jpMainPanel);
        jpMainPanel.setLayout(jpMainPanelLayout);
        jpMainPanelLayout.setHorizontalGroup(
            jpMainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 664, Short.MAX_VALUE)
        );
        jpMainPanelLayout.setVerticalGroup(
            jpMainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 525, Short.MAX_VALUE)
        );

        jspMainSplit.setRightComponent(jpMainPanel);

        jmFile.setText(bundle.getString("KCookB.jmFile.text")); // NOI18N

        jmiNewBook.setIcon(new javax.swing.ImageIcon(getClass().getResource("/de/berlios/kcookb/resources/book_add.png"))); // NOI18N
        jmiNewBook.setText(bundle.getString("KCookB.jmiNewBook.text")); // NOI18N
        jmiNewBook.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmiNewBookActionPerformed(evt);
            }
        });
        jmFile.add(jmiNewBook);
        jmFile.add(separator13);

        jmiOpenBook.setIcon(new javax.swing.ImageIcon(getClass().getResource("/de/berlios/kcookb/resources/book_open.png"))); // NOI18N
        jmiOpenBook.setText(bundle.getString("KCookB.jmiOpenBook.text")); // NOI18N
        jmiOpenBook.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmiOpenBookActionPerformed(evt);
            }
        });
        jmFile.add(jmiOpenBook);

        jmRecent.setText(bundle.getString("KCookB.jmRecent.text")); // NOI18N
        jmFile.add(jmRecent);

        jmiCloseBook.setText(bundle.getString("KCookB.jmiCloseBook.text")); // NOI18N
        jmiCloseBook.setEnabled(false);
        jmiCloseBook.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmiCloseBookActionPerformed(evt);
            }
        });
        jmFile.add(jmiCloseBook);
        jmFile.add(separator2);

        jmiExport.setText(bundle.getString("KCookB.jmiExport.text")); // NOI18N
        jmiExport.setEnabled(false);
        jmiExport.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmiExportActionPerformed(evt);
            }
        });
        jmFile.add(jmiExport);

        jmiImport.setText(bundle.getString("KCookB.jmiImport.text")); // NOI18N
        jmiImport.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmiImportActionPerformed(evt);
            }
        });
        jmFile.add(jmiImport);
        jmFile.add(separator4);

        jmiPrint.setIcon(new javax.swing.ImageIcon(getClass().getResource("/de/berlios/kcookb/resources/printer.png"))); // NOI18N
        jmiPrint.setText(bundle.getString("KCookB.jmiPrint.text")); // NOI18N
        jmiPrint.setEnabled(false);
        jmiPrint.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmiPrintActionPerformed(evt);
            }
        });
        jmFile.add(jmiPrint);
        jmFile.add(separator3);

        jmiExit.setText(bundle.getString("KCookB.jmiExit.text")); // NOI18N
        jmiExit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmiExitActionPerformed(evt);
            }
        });
        jmFile.add(jmiExit);

        jmbMenuBar.add(jmFile);

        jmEdit.setText(bundle.getString("KCookB.jmEdit.text")); // NOI18N
        jmEdit.setEnabled(false);

        jmiNewRecipe.setIcon(new javax.swing.ImageIcon(getClass().getResource("/de/berlios/kcookb/resources/page_add.png"))); // NOI18N
        jmiNewRecipe.setText(bundle.getString("KCookB.jmiNewRecipe.text")); // NOI18N
        jmiNewRecipe.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmiNewRecipeActionPerformed(evt);
            }
        });
        jmEdit.add(jmiNewRecipe);

        jmiEditRecipe.setIcon(new javax.swing.ImageIcon(getClass().getResource("/de/berlios/kcookb/resources/page_edit.png"))); // NOI18N
        jmiEditRecipe.setText(bundle.getString("KCookB.jmiEditRecipe.text")); // NOI18N
        jmiEditRecipe.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmiEditRecipeActionPerformed(evt);
            }
        });
        jmEdit.add(jmiEditRecipe);

        jmiDeleteRecipe.setIcon(new javax.swing.ImageIcon(getClass().getResource("/de/berlios/kcookb/resources/page_delete.png"))); // NOI18N
        jmiDeleteRecipe.setText(bundle.getString("KCookB.jmiDeleteRecipe.text")); // NOI18N
        jmiDeleteRecipe.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmiDeleteRecipeActionPerformed(evt);
            }
        });
        jmEdit.add(jmiDeleteRecipe);
        jmEdit.add(separator12);

        jmiFind.setIcon(new javax.swing.ImageIcon(getClass().getResource("/de/berlios/kcookb/resources/magnifier.png"))); // NOI18N
        jmiFind.setText(bundle.getString("KCookB.jmiFind.text")); // NOI18N
        jmiFind.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmiFindActionPerformed(evt);
            }
        });
        jmEdit.add(jmiFind);

        jmbMenuBar.add(jmEdit);

        jmTools.setText(bundle.getString("KCookB.jmTools.text")); // NOI18N

        jmiZip.setText(bundle.getString("KCookB.jmiZip.text")); // NOI18N
        jmiZip.setEnabled(false);
        jmiZip.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmiZipActionPerformed(evt);
            }
        });
        jmTools.add(jmiZip);

        jmiPlugins.setIcon(new javax.swing.ImageIcon(getClass().getResource("/de/berlios/kcookb/resources/plugin.png"))); // NOI18N
        jmiPlugins.setText(bundle.getString("KCookB.jmiPlugins.text")); // NOI18N
        jmiPlugins.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmiPluginsActionPerformed(evt);
            }
        });
        jmTools.add(jmiPlugins);
        jmTools.add(separator11);

        jmiOptions.setIcon(new javax.swing.ImageIcon(getClass().getResource("/de/berlios/kcookb/resources/cog.png"))); // NOI18N
        jmiOptions.setText(bundle.getString("KCookB.jmiOptions.text")); // NOI18N
        jmiOptions.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmiOptionsActionPerformed(evt);
            }
        });
        jmTools.add(jmiOptions);

        jmbMenuBar.add(jmTools);

        jmHelp.setText(bundle.getString("KCookB.jmHelp.text")); // NOI18N

        jmiHelp.setIcon(new javax.swing.ImageIcon(getClass().getResource("/de/berlios/kcookb/resources/help.png"))); // NOI18N
        jmiHelp.setText(bundle.getString("KCookB.jmiHelp.text")); // NOI18N
        jmiHelp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmiHelpActionPerformed(evt);
            }
        });
        jmHelp.add(jmiHelp);
        jmHelp.add(separator6);

        jmiWeb.setIcon(new javax.swing.ImageIcon(getClass().getResource("/de/berlios/kcookb/resources/world_go.png"))); // NOI18N
        jmiWeb.setText(bundle.getString("KCookB.jmiWeb.text")); // NOI18N
        jmiWeb.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmiWebActionPerformed(evt);
            }
        });
        jmHelp.add(jmiWeb);
        jmHelp.add(separator5);

        jmiAbout.setText(bundle.getString("KCookB.jmiAbout.text")); // NOI18N
        jmiAbout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmiAboutActionPerformed(evt);
            }
        });
        jmHelp.add(jmiAbout);

        jmbMenuBar.add(jmHelp);

        setJMenuBar(jmbMenuBar);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jtbMainToolbar, javax.swing.GroupLayout.DEFAULT_SIZE, 790, Short.MAX_VALUE)
            .addComponent(jspMainSplit, javax.swing.GroupLayout.DEFAULT_SIZE, 790, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jtbMainToolbar, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jspMainSplit, javax.swing.GroupLayout.DEFAULT_SIZE, 527, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jmiNewBookActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmiNewBookActionPerformed
        createBook();
    }//GEN-LAST:event_jmiNewBookActionPerformed

    private void jmiOpenBookActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmiOpenBookActionPerformed
        openBook();
    }//GEN-LAST:event_jmiOpenBookActionPerformed

    private void jmiCloseBookActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmiCloseBookActionPerformed
        engine.closeBook();
    }//GEN-LAST:event_jmiCloseBookActionPerformed

    private void jmiExportActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmiExportActionPerformed
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                new Export(me, true).setVisible(true);
            }
        });
    }//GEN-LAST:event_jmiExportActionPerformed

    private void jmiImportActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmiImportActionPerformed
        //TODO: implement
        throw new UnsupportedOperationException("Not implemented yet!");
    }//GEN-LAST:event_jmiImportActionPerformed

    private void jmiPrintActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmiPrintActionPerformed
        //TODO: implement
        throw new UnsupportedOperationException("Not implemented yet!");
    }//GEN-LAST:event_jmiPrintActionPerformed

    private void jmiExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmiExitActionPerformed
        engine.closeBook();
        System.exit(0);
    }//GEN-LAST:event_jmiExitActionPerformed

    private void jmiEditRecipeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmiEditRecipeActionPerformed
        showCreateRecipeDialog(true);
    }//GEN-LAST:event_jmiEditRecipeActionPerformed

    private void jmiDeleteRecipeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmiDeleteRecipeActionPerformed
        //TODO: implement
        throw new UnsupportedOperationException("Not implemented yet!");
    }//GEN-LAST:event_jmiDeleteRecipeActionPerformed

    private void jmiFindActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmiFindActionPerformed
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                new Search(me, true).setVisible(true);
            }
        });
    }//GEN-LAST:event_jmiFindActionPerformed

    private void jmiZipActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmiZipActionPerformed
        JFileChooser jfc = new JFileChooser();

        //TODO: filter extensions
        if (jfc.showSaveDialog(this) == JFileChooser.APPROVE_OPTION) {
            //TODO: save as zip
        }
    }//GEN-LAST:event_jmiZipActionPerformed

    private void jmiPluginsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmiPluginsActionPerformed
        //TODO: implement
        throw new UnsupportedOperationException("Not implemented yet!");
    }//GEN-LAST:event_jmiPluginsActionPerformed

    private void jmiOptionsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmiOptionsActionPerformed
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                new Settings(me, true).setVisible(true);
            }
        });
    }//GEN-LAST:event_jmiOptionsActionPerformed

    private void jmiHelpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmiHelpActionPerformed
        //TODO: show help
        throw new UnsupportedOperationException("Not implemented yet!");
    }//GEN-LAST:event_jmiHelpActionPerformed

    private void jmiWebActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmiWebActionPerformed
        boolean failed = true;
        if (Desktop.isDesktopSupported()) {
            if (Desktop.getDesktop().isSupported(Desktop.Action.BROWSE)) {
                try {
                    Desktop.getDesktop().browse(new URI("http://kcookb.berlios.de"));
                    failed = false;
                } catch (URISyntaxException ex) {
                    Logger.getLogger(KCookB.class.getName()).log(Level.SEVERE, null, ex);
                } catch (IOException ex) {
                    Logger.getLogger(KCookB.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }

        if (failed) {
            JOptionPane.showConfirmDialog(this, rBundle.getString("KCookB.unsupportedDesktop.message"),
                    rBundle.getString("KCookB.unsupportedDesktop.title"),
                    JOptionPane.OK_CANCEL_OPTION, JOptionPane.INFORMATION_MESSAGE,
                    new ImageIcon(getClass().getResource("/de/berlios/kcookb/resources/information.png")));
        }
    }//GEN-LAST:event_jmiWebActionPerformed

    private void jmiAboutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmiAboutActionPerformed
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                new About(me, true).setVisible(true);
            }
        });
    }//GEN-LAST:event_jmiAboutActionPerformed

    private void jbtnNewBookActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnNewBookActionPerformed
        createBook();
    }//GEN-LAST:event_jbtnNewBookActionPerformed

    private void jbtnOpenBookActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnOpenBookActionPerformed
        openBook();
    }//GEN-LAST:event_jbtnOpenBookActionPerformed

    private void jbtnNewRecipeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnNewRecipeActionPerformed
        showCreateRecipeDialog(false);
    }//GEN-LAST:event_jbtnNewRecipeActionPerformed

    private void jbtEditRecipeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtEditRecipeActionPerformed
        showCreateRecipeDialog(true);
    }//GEN-LAST:event_jbtEditRecipeActionPerformed

    private void jbtnRemoveRecipeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnRemoveRecipeActionPerformed
        //TODO: implement
        throw new UnsupportedOperationException("Not implemented yet!");
    }//GEN-LAST:event_jbtnRemoveRecipeActionPerformed

    private void jbtnPrintCurrentActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnPrintCurrentActionPerformed
        printCurrent();
    }//GEN-LAST:event_jbtnPrintCurrentActionPerformed

    private void jbtnSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnSearchActionPerformed
        //TODO: implement
        throw new UnsupportedOperationException("Not implemented yet!");
    }//GEN-LAST:event_jbtnSearchActionPerformed

    private void jbtnPreviousActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnPreviousActionPerformed
        //TODO: implement
        throw new UnsupportedOperationException("Not implemented yet!");
    }//GEN-LAST:event_jbtnPreviousActionPerformed

    private void jbtnNextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnNextActionPerformed
        //TODO: implement
        throw new UnsupportedOperationException("Not implemented yet!");
    }//GEN-LAST:event_jbtnNextActionPerformed

    private void jmiNewRecipeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmiNewRecipeActionPerformed
        showCreateRecipeDialog(false);
    }//GEN-LAST:event_jmiNewRecipeActionPerformed

    private void jtAllRecipesValueChanged(javax.swing.event.TreeSelectionEvent evt) {//GEN-FIRST:event_jtAllRecipesValueChanged

        DefaultMutableTreeNode node = (DefaultMutableTreeNode) jtAllRecipes.getLastSelectedPathComponent();
        if (node == null) {
            return;
        }
        
        Object nodeInfo = node.getUserObject();
        if (node.isLeaf()) {
            Recipe r = (Recipe) nodeInfo;
            jTextPane1.setText(r.getName() + "\n\n" + r.getDirections());
            //Cast and do something
        } else {
            //do something else
        }
    }//GEN-LAST:event_jtAllRecipesValueChanged

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        System.setProperty("java.util.logging.config.file", "logging.properties");
        LogManager logManager = LogManager.getLogManager();
        try {
            logManager.readConfiguration();
            Logger.getLogger(KCookB.class.getName()).log(Level.WARNING, "Logger Set!");
        } catch (IOException ex) {
            Logger.getLogger(KCookB.class.getName()).log(Level.SEVERE, "Logger configuration failed", ex);
        } catch (SecurityException ex) {
            Logger.getLogger(KCookB.class.getName()).log(Level.SEVERE, "Logger configuration failed", ex);
        }

        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(KCookB.class.getName()).log(Level.SEVERE, "Look-and-feel error.", ex);
        } catch (InstantiationException ex) {
            Logger.getLogger(KCookB.class.getName()).log(Level.SEVERE, "Look-and-feel error.", ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(KCookB.class.getName()).log(Level.SEVERE, "Look-and-feel error.", ex);
        } catch (UnsupportedLookAndFeelException ex) {
            Logger.getLogger(KCookB.class.getName()).log(Level.SEVERE, "Look-and-feel error.", ex);
        }

        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                new KCookB().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextPane jTextPane1;
    private javax.swing.JButton jbtEditRecipe;
    private javax.swing.JButton jbtnNewBook;
    private javax.swing.JButton jbtnNewRecipe;
    private javax.swing.JButton jbtnNext;
    private javax.swing.JButton jbtnOpenBook;
    private javax.swing.JButton jbtnPrevious;
    private javax.swing.JButton jbtnPrintCurrent;
    private javax.swing.JButton jbtnRemoveRecipe;
    private javax.swing.JButton jbtnSearch;
    private javax.swing.JMenu jmEdit;
    private javax.swing.JMenu jmFile;
    private javax.swing.JMenu jmHelp;
    private javax.swing.JMenu jmRecent;
    private javax.swing.JMenu jmTools;
    private javax.swing.JMenuBar jmbMenuBar;
    private javax.swing.JMenuItem jmiAbout;
    private javax.swing.JMenuItem jmiCloseBook;
    private javax.swing.JMenuItem jmiDeleteRecipe;
    private javax.swing.JMenuItem jmiEditRecipe;
    private javax.swing.JMenuItem jmiExit;
    private javax.swing.JMenuItem jmiExport;
    private javax.swing.JMenuItem jmiFind;
    private javax.swing.JMenuItem jmiHelp;
    private javax.swing.JMenuItem jmiImport;
    private javax.swing.JMenuItem jmiNewBook;
    private javax.swing.JMenuItem jmiNewRecipe;
    private javax.swing.JMenuItem jmiOpenBook;
    private javax.swing.JMenuItem jmiOptions;
    private javax.swing.JMenuItem jmiPlugins;
    private javax.swing.JMenuItem jmiPrint;
    private javax.swing.JMenuItem jmiWeb;
    private javax.swing.JMenuItem jmiZip;
    private javax.swing.JPanel jpAllRecipes;
    private javax.swing.JPanel jpMainPanel;
    private javax.swing.JPanel jpStaredRecipes;
    private javax.swing.JPanel jpTaggedRecipes;
    private javax.swing.JScrollPane jscAllRecipes;
    private javax.swing.JScrollPane jscStaredRecipes;
    private javax.swing.JScrollPane jscTaggedRecipe;
    private javax.swing.JSplitPane jspMainSplit;
    private javax.swing.JTree jtAllRecipes;
    private javax.swing.JTree jtStaredRecipes;
    private javax.swing.JTree jtTaggedRecipes;
    private javax.swing.JToolBar jtbMainToolbar;
    private javax.swing.JTabbedPane jtbpMainTab;
    private javax.swing.JTextField jtfSearchField;
    private javax.swing.JToolBar.Separator separator10;
    private javax.swing.JSeparator separator11;
    private javax.swing.JSeparator separator12;
    private javax.swing.JSeparator separator13;
    private javax.swing.JSeparator separator2;
    private javax.swing.JSeparator separator3;
    private javax.swing.JSeparator separator4;
    private javax.swing.JSeparator separator5;
    private javax.swing.JSeparator separator6;
    private javax.swing.JToolBar.Separator separator7;
    private javax.swing.JToolBar.Separator separator8;
    private javax.swing.JToolBar.Separator separator9;
    // End of variables declaration//GEN-END:variables

    public void bookCreated(KCBEngineEvent e) {
        jtAllRecipes.setModel(tmAll = new DefaultTreeModel(rootNode = new DefaultMutableTreeNode(e.getBookName())));
        toggleExistingBookOptions(true);
        //TODO: create all other trees.
    }
    
    public void bookOpened(KCBEngineEvent e) {
        toggleExistingBookOptions(true);
        //TODO: tree creation and population
    }

    public void bookClosed(KCBEngineEvent e) {
        //TODO: confirm cleaning code
        toggleExistingBookOptions(true);
        jtAllRecipes.setModel(null);
        jtStaredRecipes.setModel(null);
        jtTaggedRecipes.setModel(null);
    }

    public void recipeAdded(KCBEngineEvent e) {
        //TODO: search for insert position
        tmAll.insertNodeInto(new DefaultMutableTreeNode(e.getNewRecipe()), rootNode, rootNode.getChildCount());
    }

    public void recipeDeleted(KCBEngineEvent e) {
        //TODO: remove item, search for correct index
    }
}
