/*
 * KCookBGui.java
 *
 * Created on 15 de Março de 2008, 18:00
 */
package de.berlios.kcookb.gui;

import de.berlios.kcookb.exceptions.NonCoerentDatabaseException;
import de.berlios.kcookb.model.KCookB;
import edu.stanford.ejalbert.BrowserLauncher;
import edu.stanford.ejalbert.exception.BrowserLaunchingInitializingException;
import edu.stanford.ejalbert.exception.UnsupportedOperatingSystemException;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

/**
 *
 * @author  Knitter
 */
public class KCookBGui extends javax.swing.JFrame {

    private KCookBGui me = this;
    private KCookB book = null;

    /** Creates new form KCookBGui */
    public KCookBGui() {
        initComponents();
        showCentered();
    }

    private void showCentered() {
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
    }

    public void newBook(String name) {
        //defineInterfaceOptionsEstate(true);
        //TODO: create a new book
    }

    private void newBook() {
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                new NewBook(me, true).showCentered();
            }
        });
    }

    private void openBook() {      
        JFileChooser jfc = new JFileChooser();
        
        if(jfc.showOpenDialog(this) == JFileChooser.APPROVE_OPTION) {
            //TODO: book.openCatalog("");
        }          
    }

    private void save() {
        book.save();
    }

    private void exit() {
        if (book != null) {
            if (book.hasChanges()) {
                //TODO: i18n
                switch (JOptionPane.showConfirmDialog(this,
                        "Existem alterações pendentes deseja guardá-las?",
                        "", JOptionPane.YES_NO_CANCEL_OPTION)) {
                    case JOptionPane.CANCEL_OPTION:
                        return;
                    case JOptionPane.YES_OPTION:
                        save();
                }
            } else {
                book.closeCatalog();
            }
        }
        dispose();
        System.exit(0);
    }

    private void addNewRecipe() {
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                new RecipeGui(me, true, null).showCentered();
            }
        });
    }

    private void editRecipe() {
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                new RecipeGui(me, true, null).showCentered();//TODO: send recipe into edit dialog
            }
        });
    }

    private void deleteRecipe() {
        try {
            //TODO: send recipe into
            book.removeRecipe(null);
        } catch (NonCoerentDatabaseException ex) {
            Logger.getLogger(KCookBGui.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void doQuickSearch(String text) {
        showSearchDialog(text);
    }

    private void undo() {
        //TODO: undo
    }

    private void redo() {
        //TODO: redo
    }

    private void print() {
        //TODO: print
    }

    private void previousRecipe() {
        //TODO: previous recipe
    }

    private void nextRecipe() {
        //TODO: next recipe
    }

    private void showNotes() {
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {//TODO: send recipe or notes to the dialog
                new NoteDialog(me, true, null).showCentered();
            }
        });
    }

    private void showTips() {
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                new TipsDialog(me, true).showCentered();
            }
        });
    }

    private void showSearchDialog(final String text) {
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                new Search(me, true, text).showCentered();
            }
        });
    }

    private void showLink(String url) {
        try {
            new BrowserLauncher().openURLinBrowser(url);
        } catch (BrowserLaunchingInitializingException ex) {
            Logger.getLogger(KCookBGui.class.getName()).log(Level.SEVERE, null, ex);
        } catch (UnsupportedOperatingSystemException ex) {
            Logger.getLogger(KCookBGui.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void defineInterfaceOptionsEstate(boolean active) {
        /*jmiCloseBook.setEnabled(active);
        //TODO:see: jmiDeleteRecipe.setEnabled(active);
        //TODO:see: jmiEditRecipe.setEnabled(active);
        jmiExport.setEnabled(active);
        jmiMeal.setEnabled(active);
        jmiNewRecipe.setEnabled(active);
        jmiRedo.setEnabled(active);
        jmiUndo.setEnabled(active);
        //TODO:see: jmiSave.setEnabled(active);
        jmiSchedule.setEnabled(active);
        jmiSearch.setEnabled(active);
        jmiTemplatedBook.setEnabled(active);
        jmiTips.setEnabled(active);
        jmiZipBook.setEnabled(active);
        jbtDeleteRecipe.setEnabled(active);
        jbtEditRecipe.setEnabled(active);
        jbtNewRecipe.setEnabled(active);
        jbtNext.setEnabled(active);
        jbtPrevious.setEnabled(active);
        jbtPrintRecipe.setEnabled(active);
        jbtQuickSearch.setEnabled(active);
        jbtRedo.setEnabled(active);
        jbtSave.setEnabled(active);
        jbtUndo.setEnabled(active);
        jtfQuickSearch.setEnabled(active);*/
        //TODO: hide the interface
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jtbMainBar = new javax.swing.JToolBar();
        jbtNewBook = new javax.swing.JButton();
        jbtOpenBook = new javax.swing.JButton();
        jbtSave = new javax.swing.JButton();
        jSeparator10 = new javax.swing.JToolBar.Separator();
        jbtNewRecipe = new javax.swing.JButton();
        jbtEditRecipe = new javax.swing.JButton();
        jbtDeleteRecipe = new javax.swing.JButton();
        jSeparator11 = new javax.swing.JToolBar.Separator();
        jbtUndo = new javax.swing.JButton();
        jbtRedo = new javax.swing.JButton();
        jSeparator12 = new javax.swing.JToolBar.Separator();
        jbtPrintRecipe = new javax.swing.JButton();
        jSeparator13 = new javax.swing.JToolBar.Separator();
        jtfQuickSearch = new javax.swing.JTextField();
        jbtQuickSearch = new javax.swing.JButton();
        jSeparator14 = new javax.swing.JToolBar.Separator();
        jbtPrevious = new javax.swing.JButton();
        jbtNext = new javax.swing.JButton();
        jSeparator16 = new javax.swing.JToolBar.Separator();
        jbtRecipeNotes = new javax.swing.JButton();
        jbtTips = new javax.swing.JButton();
        jSeparator18 = new javax.swing.JToolBar.Separator();
        jbtApplyStar = new javax.swing.JButton();
        jspMainSplit = new javax.swing.JSplitPane();
        jtpTreeTabs = new javax.swing.JTabbedPane();
        jpTabType = new javax.swing.JPanel();
        jscpTreeTypeScroll = new javax.swing.JScrollPane();
        jtreeType = new javax.swing.JTree();
        jpTabLabel = new javax.swing.JPanel();
        jscpTreeLabelScroll = new javax.swing.JScrollPane();
        jtreeLabel = new javax.swing.JTree();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTree1 = new javax.swing.JTree();
        jpMainRightPanel = new javax.swing.JPanel();
        jscpEditor = new javax.swing.JScrollPane();
        jepRecipe = new javax.swing.JEditorPane();
        jmbMainMenu = new javax.swing.JMenuBar();
        jmFile = new javax.swing.JMenu();
        jmiNewBook = new javax.swing.JMenuItem();
        jSeparator2 = new javax.swing.JSeparator();
        jmiOpenBook = new javax.swing.JMenuItem();
        jmiCloseBook = new javax.swing.JMenuItem();
        jmRecentBooks = new javax.swing.JMenu();
        jSeparator3 = new javax.swing.JSeparator();
        jmiSave = new javax.swing.JMenuItem();
        jSeparator15 = new javax.swing.JSeparator();
        jmiBookInfo = new javax.swing.JMenuItem();
        jSeparator17 = new javax.swing.JSeparator();
        jmiImport = new javax.swing.JMenuItem();
        jmiExport = new javax.swing.JMenuItem();
        jmiTemplatedBook = new javax.swing.JMenuItem();
        jSeparator4 = new javax.swing.JSeparator();
        jmiZipBook = new javax.swing.JMenuItem();
        jSeparator7 = new javax.swing.JSeparator();
        jmiExit = new javax.swing.JMenuItem();
        jmRecipe = new javax.swing.JMenu();
        jmiUndo = new javax.swing.JMenuItem();
        jmiRedo = new javax.swing.JMenuItem();
        jSeparator5 = new javax.swing.JSeparator();
        jmiNewRecipe = new javax.swing.JMenuItem();
        jmiEditRecipe = new javax.swing.JMenuItem();
        jmiDeleteRecipe = new javax.swing.JMenuItem();
        jSeparator6 = new javax.swing.JSeparator();
        jmiSearch = new javax.swing.JMenuItem();
        jmiTools = new javax.swing.JMenu();
        jmiMeal = new javax.swing.JMenuItem();
        jmiTips = new javax.swing.JMenuItem();
        jmiSchedule = new javax.swing.JMenuItem();
        jSeparator8 = new javax.swing.JSeparator();
        jmiOptions = new javax.swing.JMenuItem();
        jmHelp = new javax.swing.JMenu();
        jmiHelpContents = new javax.swing.JMenuItem();
        jmOnlineResources = new javax.swing.JMenu();
        jmiHome = new javax.swing.JMenuItem();
        jSeparator9 = new javax.swing.JSeparator();
        jmiPresentationTemplates = new javax.swing.JMenuItem();
        jmiExportTemplates = new javax.swing.JMenuItem();
        jSeparator1 = new javax.swing.JSeparator();
        jmiAbout = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        java.util.ResourceBundle bundle = java.util.ResourceBundle.getBundle("de/berlios/kcookb/resources/languages/language"); // NOI18N
        setTitle(bundle.getString("WINDOW_TITLE")); // NOI18N
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        jtbMainBar.setFloatable(false);
        jtbMainBar.setRollover(true);

        jbtNewBook.setIcon(new javax.swing.ImageIcon(getClass().getResource("/de/berlios/kcookb/resources/images/toolbar/tb-new-book.png"))); // NOI18N
        jbtNewBook.setToolTipText(bundle.getString("MAINBAR_TIP_NEWBOOK")); // NOI18N
        jbtNewBook.setFocusable(false);
        jbtNewBook.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jbtNewBook.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jbtNewBook.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtNewBookActionPerformed(evt);
            }
        });
        jtbMainBar.add(jbtNewBook);

        jbtOpenBook.setIcon(new javax.swing.ImageIcon(getClass().getResource("/de/berlios/kcookb/resources/images/toolbar/tb-open-book.png"))); // NOI18N
        jbtOpenBook.setToolTipText(bundle.getString("MAINBAR_TIP_OPENBOOK")); // NOI18N
        jbtOpenBook.setFocusable(false);
        jbtOpenBook.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jbtOpenBook.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jbtOpenBook.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtOpenBookActionPerformed(evt);
            }
        });
        jtbMainBar.add(jbtOpenBook);

        jbtSave.setIcon(new javax.swing.ImageIcon(getClass().getResource("/de/berlios/kcookb/resources/images/toolbar/tb-save.png"))); // NOI18N
        jbtSave.setToolTipText(bundle.getString("MAINBAR_TIP_SAVE")); // NOI18N
        jbtSave.setFocusable(false);
        jbtSave.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jbtSave.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jbtSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtSaveActionPerformed(evt);
            }
        });
        jtbMainBar.add(jbtSave);
        jtbMainBar.add(jSeparator10);

        jbtNewRecipe.setIcon(new javax.swing.ImageIcon(getClass().getResource("/de/berlios/kcookb/resources/images/toolbar/tb-new-recipe.png"))); // NOI18N
        jbtNewRecipe.setToolTipText(bundle.getString("MAINBAR_TIP_NEWRECIPE")); // NOI18N
        jbtNewRecipe.setFocusable(false);
        jbtNewRecipe.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jbtNewRecipe.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jbtNewRecipe.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtNewRecipeActionPerformed(evt);
            }
        });
        jtbMainBar.add(jbtNewRecipe);

        jbtEditRecipe.setIcon(new javax.swing.ImageIcon(getClass().getResource("/de/berlios/kcookb/resources/images/toolbar/tb-edit.png"))); // NOI18N
        jbtEditRecipe.setToolTipText(bundle.getString("MAINBAR_TIP_EDITRECIPE")); // NOI18N
        jbtEditRecipe.setFocusable(false);
        jbtEditRecipe.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jbtEditRecipe.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jbtEditRecipe.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtEditRecipeActionPerformed(evt);
            }
        });
        jtbMainBar.add(jbtEditRecipe);

        jbtDeleteRecipe.setIcon(new javax.swing.ImageIcon(getClass().getResource("/de/berlios/kcookb/resources/images/toolbar/tb-delete.png"))); // NOI18N
        jbtDeleteRecipe.setToolTipText(bundle.getString("MAINBAR_TIP_DELETERECIPE")); // NOI18N
        jbtDeleteRecipe.setFocusable(false);
        jbtDeleteRecipe.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jbtDeleteRecipe.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jbtDeleteRecipe.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtDeleteRecipeActionPerformed(evt);
            }
        });
        jtbMainBar.add(jbtDeleteRecipe);
        jtbMainBar.add(jSeparator11);

        jbtUndo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/de/berlios/kcookb/resources/images/toolbar/tb-undo.png"))); // NOI18N
        jbtUndo.setFocusable(false);
        jbtUndo.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jbtUndo.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jbtUndo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtUndoActionPerformed(evt);
            }
        });
        jtbMainBar.add(jbtUndo);

        jbtRedo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/de/berlios/kcookb/resources/images/toolbar/tb-redo.png"))); // NOI18N
        jbtRedo.setFocusable(false);
        jbtRedo.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jbtRedo.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jbtRedo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtRedoActionPerformed(evt);
            }
        });
        jtbMainBar.add(jbtRedo);
        jtbMainBar.add(jSeparator12);

        jbtPrintRecipe.setIcon(new javax.swing.ImageIcon(getClass().getResource("/de/berlios/kcookb/resources/images/toolbar/tb-print-recipe.png"))); // NOI18N
        jbtPrintRecipe.setFocusable(false);
        jbtPrintRecipe.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jbtPrintRecipe.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jbtPrintRecipe.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtPrintRecipeActionPerformed(evt);
            }
        });
        jtbMainBar.add(jbtPrintRecipe);
        jtbMainBar.add(jSeparator13);

        jtfQuickSearch.setMaximumSize(new java.awt.Dimension(150, 20));
        jtfQuickSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtfQuickSearchActionPerformed(evt);
            }
        });
        jtbMainBar.add(jtfQuickSearch);

        jbtQuickSearch.setIcon(new javax.swing.ImageIcon(getClass().getResource("/de/berlios/kcookb/resources/images/toolbar/tb-find.png"))); // NOI18N
        jbtQuickSearch.setFocusable(false);
        jbtQuickSearch.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jbtQuickSearch.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jbtQuickSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtQuickSearchActionPerformed(evt);
            }
        });
        jtbMainBar.add(jbtQuickSearch);
        jtbMainBar.add(jSeparator14);

        jbtPrevious.setIcon(new javax.swing.ImageIcon(getClass().getResource("/de/berlios/kcookb/resources/images/toolbar/tb-previous.png"))); // NOI18N
        jbtPrevious.setFocusable(false);
        jbtPrevious.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jbtPrevious.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jbtPrevious.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtPreviousActionPerformed(evt);
            }
        });
        jtbMainBar.add(jbtPrevious);

        jbtNext.setIcon(new javax.swing.ImageIcon(getClass().getResource("/de/berlios/kcookb/resources/images/toolbar/tb-next.png"))); // NOI18N
        jbtNext.setFocusable(false);
        jbtNext.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jbtNext.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jbtNext.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtNextActionPerformed(evt);
            }
        });
        jtbMainBar.add(jbtNext);
        jtbMainBar.add(jSeparator16);

        jbtRecipeNotes.setIcon(new javax.swing.ImageIcon(getClass().getResource("/de/berlios/kcookb/resources/images/toolbar/tb-notes.png"))); // NOI18N
        jbtRecipeNotes.setFocusable(false);
        jbtRecipeNotes.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jbtRecipeNotes.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jbtRecipeNotes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtRecipeNotesActionPerformed(evt);
            }
        });
        jtbMainBar.add(jbtRecipeNotes);

        jbtTips.setIcon(new javax.swing.ImageIcon(getClass().getResource("/de/berlios/kcookb/resources/images/toolbar/tb-tips.png"))); // NOI18N
        jbtTips.setFocusable(false);
        jbtTips.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jbtTips.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jbtTips.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtTipsActionPerformed(evt);
            }
        });
        jtbMainBar.add(jbtTips);
        jtbMainBar.add(jSeparator18);

        jbtApplyStar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/de/berlios/kcookb/resources/images/toolbar/tb-star.png"))); // NOI18N
        jbtApplyStar.setFocusable(false);
        jbtApplyStar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jbtApplyStar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jbtApplyStar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtApplyStarActionPerformed(evt);
            }
        });
        jtbMainBar.add(jbtApplyStar);

        jspMainSplit.setDividerLocation(160);

        jtpTreeTabs.setTabPlacement(javax.swing.JTabbedPane.BOTTOM);

        jscpTreeTypeScroll.setViewportView(jtreeType);

        org.jdesktop.layout.GroupLayout jpTabTypeLayout = new org.jdesktop.layout.GroupLayout(jpTabType);
        jpTabType.setLayout(jpTabTypeLayout);
        jpTabTypeLayout.setHorizontalGroup(
            jpTabTypeLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jscpTreeTypeScroll, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 154, Short.MAX_VALUE)
        );
        jpTabTypeLayout.setVerticalGroup(
            jpTabTypeLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jscpTreeTypeScroll, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 531, Short.MAX_VALUE)
        );

        jtpTreeTabs.addTab(bundle.getString("WINDOW_TABCATEGORIES"), jpTabType); // NOI18N

        jscpTreeLabelScroll.setViewportView(jtreeLabel);

        org.jdesktop.layout.GroupLayout jpTabLabelLayout = new org.jdesktop.layout.GroupLayout(jpTabLabel);
        jpTabLabel.setLayout(jpTabLabelLayout);
        jpTabLabelLayout.setHorizontalGroup(
            jpTabLabelLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(org.jdesktop.layout.GroupLayout.TRAILING, jscpTreeLabelScroll, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 154, Short.MAX_VALUE)
        );
        jpTabLabelLayout.setVerticalGroup(
            jpTabLabelLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jscpTreeLabelScroll, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 531, Short.MAX_VALUE)
        );

        jtpTreeTabs.addTab(bundle.getString("WINDOW_LABELTAB"), jpTabLabel); // NOI18N

        jScrollPane1.setViewportView(jTree1);

        org.jdesktop.layout.GroupLayout jPanel1Layout = new org.jdesktop.layout.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jScrollPane1, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 154, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jScrollPane1, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 531, Short.MAX_VALUE)
        );

        jtpTreeTabs.addTab("", new javax.swing.ImageIcon(getClass().getResource("/de/berlios/kcookb/resources/images/tabbed-stared.png")), jPanel1); // NOI18N

        jspMainSplit.setLeftComponent(jtpTreeTabs);
        jtpTreeTabs.getAccessibleContext().setAccessibleName(bundle.getString("WINDOW_LABELTAB")); // NOI18N

        jepRecipe.setEditable(false);
        jscpEditor.setViewportView(jepRecipe);

        org.jdesktop.layout.GroupLayout jpMainRightPanelLayout = new org.jdesktop.layout.GroupLayout(jpMainRightPanel);
        jpMainRightPanel.setLayout(jpMainRightPanelLayout);
        jpMainRightPanelLayout.setHorizontalGroup(
            jpMainRightPanelLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(org.jdesktop.layout.GroupLayout.TRAILING, jscpEditor, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 573, Short.MAX_VALUE)
        );
        jpMainRightPanelLayout.setVerticalGroup(
            jpMainRightPanelLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jscpEditor, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 561, Short.MAX_VALUE)
        );

        jspMainSplit.setRightComponent(jpMainRightPanel);

        jmFile.setText(bundle.getString("WINDOW_FILEMENU")); // NOI18N

        jmiNewBook.setIcon(new javax.swing.ImageIcon(getClass().getResource("/de/berlios/kcookb/resources/images/menu/mn-new-book.png"))); // NOI18N
        jmiNewBook.setText(bundle.getString("WINDOW_FILEMENU_NEWBOOK")); // NOI18N
        jmiNewBook.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmiNewBookActionPerformed(evt);
            }
        });
        jmFile.add(jmiNewBook);
        jmFile.add(jSeparator2);

        jmiOpenBook.setIcon(new javax.swing.ImageIcon(getClass().getResource("/de/berlios/kcookb/resources/images/menu/mn-open-book.png"))); // NOI18N
        jmiOpenBook.setText(bundle.getString("WINDOW_FILEMENU_OPENBOOK")); // NOI18N
        jmiOpenBook.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmiOpenBookActionPerformed(evt);
            }
        });
        jmFile.add(jmiOpenBook);

        jmiCloseBook.setText(bundle.getString("WINDOW_FILEMENU_CLOSEBOOK")); // NOI18N
        jmiCloseBook.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmiCloseBookActionPerformed(evt);
            }
        });
        jmFile.add(jmiCloseBook);

        jmRecentBooks.setText(bundle.getString("WINDOW_FILEMENU_OPENRECENT")); // NOI18N
        jmFile.add(jmRecentBooks);
        jmFile.add(jSeparator3);

        jmiSave.setIcon(new javax.swing.ImageIcon(getClass().getResource("/de/berlios/kcookb/resources/images/menu/mn-save.png"))); // NOI18N
        jmiSave.setText(bundle.getString("WINDOW_FILEMENU_SAVE")); // NOI18N
        jmiSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmiSaveActionPerformed(evt);
            }
        });
        jmFile.add(jmiSave);
        jmFile.add(jSeparator15);

        jmiBookInfo.setText(bundle.getString("WINDOW_FILEMENU_BOOKINFO")); // NOI18N
        jmiBookInfo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmiBookInfoActionPerformed(evt);
            }
        });
        jmFile.add(jmiBookInfo);
        jmFile.add(jSeparator17);

        jmiImport.setIcon(new javax.swing.ImageIcon(getClass().getResource("/de/berlios/kcookb/resources/images/menu/mn-import.png"))); // NOI18N
        jmiImport.setText(bundle.getString("WINDOW_FILEMENU_IMPORT")); // NOI18N
        jmiImport.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmiImportActionPerformed(evt);
            }
        });
        jmFile.add(jmiImport);

        jmiExport.setIcon(new javax.swing.ImageIcon(getClass().getResource("/de/berlios/kcookb/resources/images/menu/mn-export.png"))); // NOI18N
        jmiExport.setText(bundle.getString("WINDOW_FILEMENU_EXPORT")); // NOI18N
        jmiExport.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmiExportActionPerformed(evt);
            }
        });
        jmFile.add(jmiExport);

        jmiTemplatedBook.setText(bundle.getString("WINDOW_FILEMENU_TEMPLATEEXPORT")); // NOI18N
        jmiTemplatedBook.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmiTemplatedBookActionPerformed(evt);
            }
        });
        jmFile.add(jmiTemplatedBook);
        jmFile.add(jSeparator4);

        jmiZipBook.setIcon(new javax.swing.ImageIcon(getClass().getResource("/de/berlios/kcookb/resources/images/menu/mn-package.png"))); // NOI18N
        jmiZipBook.setText(bundle.getString("WINDOW_FILEMENU_ZIP")); // NOI18N
        jmiZipBook.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmiZipBookActionPerformed(evt);
            }
        });
        jmFile.add(jmiZipBook);
        jmFile.add(jSeparator7);

        jmiExit.setText(bundle.getString("WINDOW_FILEMENU_EXIT")); // NOI18N
        jmiExit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmiExitActionPerformed(evt);
            }
        });
        jmFile.add(jmiExit);

        jmbMainMenu.add(jmFile);

        jmRecipe.setText(bundle.getString("WINDOW_EDITMENU")); // NOI18N

        jmiUndo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/de/berlios/kcookb/resources/images/menu/mn-undo.png"))); // NOI18N
        jmiUndo.setText(bundle.getString("WINDOW_EDITMENU_UNDO")); // NOI18N
        jmiUndo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmiUndoActionPerformed(evt);
            }
        });
        jmRecipe.add(jmiUndo);

        jmiRedo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/de/berlios/kcookb/resources/images/menu/mn-redo.png"))); // NOI18N
        jmiRedo.setText(bundle.getString("WINDOW_EDITMENU_REDO")); // NOI18N
        jmiRedo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmiRedoActionPerformed(evt);
            }
        });
        jmRecipe.add(jmiRedo);
        jmRecipe.add(jSeparator5);

        jmiNewRecipe.setIcon(new javax.swing.ImageIcon(getClass().getResource("/de/berlios/kcookb/resources/images/menu/mn-new-recipe.png"))); // NOI18N
        jmiNewRecipe.setText(bundle.getString("WINDOW_EDITMENU_NEWRECIPE")); // NOI18N
        jmiNewRecipe.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmiNewRecipeActionPerformed(evt);
            }
        });
        jmRecipe.add(jmiNewRecipe);

        jmiEditRecipe.setIcon(new javax.swing.ImageIcon(getClass().getResource("/de/berlios/kcookb/resources/images/menu/mn-edit.png"))); // NOI18N
        jmiEditRecipe.setText(bundle.getString("WINDOW_EDITMENU_EDITRECIPE")); // NOI18N
        jmiEditRecipe.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmiEditRecipeActionPerformed(evt);
            }
        });
        jmRecipe.add(jmiEditRecipe);

        jmiDeleteRecipe.setIcon(new javax.swing.ImageIcon(getClass().getResource("/de/berlios/kcookb/resources/images/menu/mn-delete.png"))); // NOI18N
        jmiDeleteRecipe.setText(bundle.getString("WINDOW_EDITMENU_DELETERECIPE")); // NOI18N
        jmiDeleteRecipe.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmiDeleteRecipeActionPerformed(evt);
            }
        });
        jmRecipe.add(jmiDeleteRecipe);
        jmRecipe.add(jSeparator6);

        jmiSearch.setIcon(new javax.swing.ImageIcon(getClass().getResource("/de/berlios/kcookb/resources/images/menu/mn-find.png"))); // NOI18N
        jmiSearch.setText(bundle.getString("WINDOW_EDITMENU_FIND")); // NOI18N
        jmiSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmiSearchActionPerformed(evt);
            }
        });
        jmRecipe.add(jmiSearch);

        jmbMainMenu.add(jmRecipe);

        jmiTools.setText(bundle.getString("WINDOW_TOOLSMENU")); // NOI18N

        jmiMeal.setText(bundle.getString("WINDOW_TOOLSMENU_MEALS")); // NOI18N
        jmiMeal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmiMealActionPerformed(evt);
            }
        });
        jmiTools.add(jmiMeal);

        jmiTips.setIcon(new javax.swing.ImageIcon(getClass().getResource("/de/berlios/kcookb/resources/images/menu/mn-tips.png"))); // NOI18N
        jmiTips.setText(bundle.getString("WINDOW_TOOLSMENU_TIPS")); // NOI18N
        jmiTips.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmiTipsActionPerformed(evt);
            }
        });
        jmiTools.add(jmiTips);

        jmiSchedule.setIcon(new javax.swing.ImageIcon(getClass().getResource("/de/berlios/kcookb/resources/images/menu/mn-calendar.png"))); // NOI18N
        jmiSchedule.setText(bundle.getString("WINDOW_TOOLSMENU_SCHEDULE")); // NOI18N
        jmiSchedule.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmiScheduleActionPerformed(evt);
            }
        });
        jmiTools.add(jmiSchedule);
        jmiTools.add(jSeparator8);

        jmiOptions.setIcon(new javax.swing.ImageIcon(getClass().getResource("/de/berlios/kcookb/resources/images/menu/mn-preferences.png"))); // NOI18N
        jmiOptions.setText(bundle.getString("WINDOW_TOOLSMENU_OPTIONS")); // NOI18N
        jmiOptions.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmiOptionsActionPerformed(evt);
            }
        });
        jmiTools.add(jmiOptions);

        jmbMainMenu.add(jmiTools);

        jmHelp.setText(bundle.getString("WINDOW_HELPMENU")); // NOI18N

        jmiHelpContents.setIcon(new javax.swing.ImageIcon(getClass().getResource("/de/berlios/kcookb/resources/images/menu/mn-help.png"))); // NOI18N
        jmiHelpContents.setText(bundle.getString("WINDOW_HELPMENU_HELP")); // NOI18N
        jmiHelpContents.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmiHelpContentsActionPerformed(evt);
            }
        });
        jmHelp.add(jmiHelpContents);

        jmOnlineResources.setIcon(new javax.swing.ImageIcon(getClass().getResource("/de/berlios/kcookb/resources/images/menu/mn-internet.png"))); // NOI18N
        jmOnlineResources.setText(bundle.getString("WINDOW_HELPMENU_ONLINERESOURCES")); // NOI18N

        jmiHome.setText(bundle.getString("WINDOW_HELPMENU_ONLINEHOME")); // NOI18N
        jmiHome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmiHomeActionPerformed(evt);
            }
        });
        jmOnlineResources.add(jmiHome);
        jmOnlineResources.add(jSeparator9);

        jmiPresentationTemplates.setText(bundle.getString("WINDOW_HELPMENU_ONLINEPTEMPLATE")); // NOI18N
        jmiPresentationTemplates.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmiPresentationTemplatesActionPerformed(evt);
            }
        });
        jmOnlineResources.add(jmiPresentationTemplates);

        jmiExportTemplates.setText(bundle.getString("WINDOW_HELPMENU_ONLINEETEMPLATE")); // NOI18N
        jmiExportTemplates.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmiExportTemplatesActionPerformed(evt);
            }
        });
        jmOnlineResources.add(jmiExportTemplates);

        jmHelp.add(jmOnlineResources);
        jmHelp.add(jSeparator1);

        jmiAbout.setText(bundle.getString("WINDOW_HELPMENU_ABOUT")); // NOI18N
        jmiAbout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmiAboutActionPerformed(evt);
            }
        });
        jmHelp.add(jmiAbout);

        jmbMainMenu.add(jmHelp);

        setJMenuBar(jmbMainMenu);

        org.jdesktop.layout.GroupLayout layout = new org.jdesktop.layout.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jtbMainBar, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 739, Short.MAX_VALUE)
            .add(org.jdesktop.layout.GroupLayout.TRAILING, jspMainSplit, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 739, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .add(jtbMainBar, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 25, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(jspMainSplit, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 563, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    private void jmiAboutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmiAboutActionPerformed
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                new About(me, true).showCentered();
            }
        });
    }//GEN-LAST:event_jmiAboutActionPerformed

    private void jmiHelpContentsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmiHelpContentsActionPerformed
        //TODO: Create and add help system
        //use threads
    }//GEN-LAST:event_jmiHelpContentsActionPerformed

    private void jbtNewBookActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtNewBookActionPerformed
        newBook();
    }//GEN-LAST:event_jbtNewBookActionPerformed

    private void jbtOpenBookActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtOpenBookActionPerformed
        openBook();
    }//GEN-LAST:event_jbtOpenBookActionPerformed

    private void jbtSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtSaveActionPerformed
        save();
    }//GEN-LAST:event_jbtSaveActionPerformed

    private void jbtNewRecipeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtNewRecipeActionPerformed
        addNewRecipe();
    }//GEN-LAST:event_jbtNewRecipeActionPerformed

    private void jbtDeleteRecipeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtDeleteRecipeActionPerformed
        deleteRecipe();
    }//GEN-LAST:event_jbtDeleteRecipeActionPerformed

    private void jbtUndoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtUndoActionPerformed
        undo();
    }//GEN-LAST:event_jbtUndoActionPerformed

    private void jbtRedoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtRedoActionPerformed
        redo();
    }//GEN-LAST:event_jbtRedoActionPerformed

    private void jbtPrintRecipeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtPrintRecipeActionPerformed
        print();
    }//GEN-LAST:event_jbtPrintRecipeActionPerformed

    private void jbtQuickSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtQuickSearchActionPerformed
        doQuickSearch(jtfQuickSearch.getText().trim());
    }//GEN-LAST:event_jbtQuickSearchActionPerformed

    private void jtfQuickSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtfQuickSearchActionPerformed
        doQuickSearch(jtfQuickSearch.getText().trim());
    }//GEN-LAST:event_jtfQuickSearchActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        exit();
    }//GEN-LAST:event_formWindowClosing

    private void jbtEditRecipeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtEditRecipeActionPerformed
        editRecipe();
    }//GEN-LAST:event_jbtEditRecipeActionPerformed

    private void jbtPreviousActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtPreviousActionPerformed
        previousRecipe();
    }//GEN-LAST:event_jbtPreviousActionPerformed

    private void jbtNextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtNextActionPerformed
        nextRecipe();
    }//GEN-LAST:event_jbtNextActionPerformed

    private void jmiOptionsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmiOptionsActionPerformed
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                new Options(me, true).showCentered();
            }
        });
    }//GEN-LAST:event_jmiOptionsActionPerformed

    private void jmiNewBookActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmiNewBookActionPerformed
        newBook();
    }//GEN-LAST:event_jmiNewBookActionPerformed

    private void jmiOpenBookActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmiOpenBookActionPerformed
        openBook();
    }//GEN-LAST:event_jmiOpenBookActionPerformed

    private void jmiCloseBookActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmiCloseBookActionPerformed
        book.closeCatalog();
        book = null;
        //TODO: defineInterfaceOptionsEstate(false);
    }//GEN-LAST:event_jmiCloseBookActionPerformed

    private void jmiImportActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmiImportActionPerformed
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                new Import(me, true).showCentered();
            }
        });
    }//GEN-LAST:event_jmiImportActionPerformed

    private void jmiExportActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmiExportActionPerformed
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                new Export(me, true).showCentered();
            }
        });
    }//GEN-LAST:event_jmiExportActionPerformed

    private void jmiTemplatedBookActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmiTemplatedBookActionPerformed
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                new TemplateExport(me, true).showCentered();
            }
        });
    }//GEN-LAST:event_jmiTemplatedBookActionPerformed

    private void jmiZipBookActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmiZipBookActionPerformed
        JFileChooser jfc = new JFileChooser();
        
        if(jfc.showSaveDialog(this) == JFileChooser.APPROVE_OPTION) {
            //TODO: create zip file of all project folder.
        }        
    }//GEN-LAST:event_jmiZipBookActionPerformed

    private void jmiExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmiExitActionPerformed
        exit();
    }//GEN-LAST:event_jmiExitActionPerformed

    private void jmiUndoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmiUndoActionPerformed
        undo();
    }//GEN-LAST:event_jmiUndoActionPerformed

    private void jmiRedoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmiRedoActionPerformed
        redo();
    }//GEN-LAST:event_jmiRedoActionPerformed

    private void jmiNewRecipeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmiNewRecipeActionPerformed
        addNewRecipe();
    }//GEN-LAST:event_jmiNewRecipeActionPerformed

    private void jmiEditRecipeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmiEditRecipeActionPerformed
        editRecipe();
    }//GEN-LAST:event_jmiEditRecipeActionPerformed

    private void jmiDeleteRecipeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmiDeleteRecipeActionPerformed
        deleteRecipe();
    }//GEN-LAST:event_jmiDeleteRecipeActionPerformed

    private void jmiSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmiSearchActionPerformed
        showSearchDialog(null);
    }//GEN-LAST:event_jmiSearchActionPerformed

    private void jmiMealActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmiMealActionPerformed
        //TODO: create GUI for meal data
    }//GEN-LAST:event_jmiMealActionPerformed

    private void jmiScheduleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmiScheduleActionPerformed
        //TODO: create GUI for schedule tool
    }//GEN-LAST:event_jmiScheduleActionPerformed

    private void jmiHomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmiHomeActionPerformed
        showLink(java.util.ResourceBundle.getBundle("de/berlios/kcookb/resources/config").getString("APPURL"));// NOI18N
    }//GEN-LAST:event_jmiHomeActionPerformed

    private void jmiPresentationTemplatesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmiPresentationTemplatesActionPerformed
        showLink(java.util.ResourceBundle.getBundle("de/berlios/kcookb/resources/config").getString("PTEMPLATEURL"));// NOI18N
    }//GEN-LAST:event_jmiPresentationTemplatesActionPerformed

    private void jmiExportTemplatesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmiExportTemplatesActionPerformed
        showLink(java.util.ResourceBundle.getBundle("de/berlios/kcookb/resources/config").getString("ETEMPLATEURL"));// NOI18N
    }//GEN-LAST:event_jmiExportTemplatesActionPerformed

    private void jmiSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmiSaveActionPerformed
        save();
    }//GEN-LAST:event_jmiSaveActionPerformed

    private void jmiBookInfoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmiBookInfoActionPerformed
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                new BookInfoGui(me, true, book.getInfo()).setVisible(true);
            }
        });
    }//GEN-LAST:event_jmiBookInfoActionPerformed

    private void jbtRecipeNotesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtRecipeNotesActionPerformed
        showNotes();
    }//GEN-LAST:event_jbtRecipeNotesActionPerformed

    private void jbtApplyStarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtApplyStarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jbtApplyStarActionPerformed

    private void jbtTipsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtTipsActionPerformed
        showTips();
    }//GEN-LAST:event_jbtTipsActionPerformed

    private void jmiTipsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmiTipsActionPerformed
        showTips();
    }//GEN-LAST:event_jmiTipsActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
            java.awt.EventQueue.invokeLater(new Runnable() {
                public void run() {
                    new KCookBGui().setVisible(true);
                }
            });
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(KCookBGui.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            Logger.getLogger(KCookBGui.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(KCookBGui.class.getName()).log(Level.SEVERE, null, ex);
        } catch (UnsupportedLookAndFeelException ex) {
            Logger.getLogger(KCookBGui.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JToolBar.Separator jSeparator10;
    private javax.swing.JToolBar.Separator jSeparator11;
    private javax.swing.JToolBar.Separator jSeparator12;
    private javax.swing.JToolBar.Separator jSeparator13;
    private javax.swing.JToolBar.Separator jSeparator14;
    private javax.swing.JSeparator jSeparator15;
    private javax.swing.JToolBar.Separator jSeparator16;
    private javax.swing.JSeparator jSeparator17;
    private javax.swing.JToolBar.Separator jSeparator18;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JSeparator jSeparator5;
    private javax.swing.JSeparator jSeparator6;
    private javax.swing.JSeparator jSeparator7;
    private javax.swing.JSeparator jSeparator8;
    private javax.swing.JSeparator jSeparator9;
    private javax.swing.JTree jTree1;
    private javax.swing.JButton jbtApplyStar;
    private javax.swing.JButton jbtDeleteRecipe;
    private javax.swing.JButton jbtEditRecipe;
    private javax.swing.JButton jbtNewBook;
    private javax.swing.JButton jbtNewRecipe;
    private javax.swing.JButton jbtNext;
    private javax.swing.JButton jbtOpenBook;
    private javax.swing.JButton jbtPrevious;
    private javax.swing.JButton jbtPrintRecipe;
    private javax.swing.JButton jbtQuickSearch;
    private javax.swing.JButton jbtRecipeNotes;
    private javax.swing.JButton jbtRedo;
    private javax.swing.JButton jbtSave;
    private javax.swing.JButton jbtTips;
    private javax.swing.JButton jbtUndo;
    private javax.swing.JEditorPane jepRecipe;
    private javax.swing.JMenu jmFile;
    private javax.swing.JMenu jmHelp;
    private javax.swing.JMenu jmOnlineResources;
    private javax.swing.JMenu jmRecentBooks;
    private javax.swing.JMenu jmRecipe;
    private javax.swing.JMenuBar jmbMainMenu;
    private javax.swing.JMenuItem jmiAbout;
    private javax.swing.JMenuItem jmiBookInfo;
    private javax.swing.JMenuItem jmiCloseBook;
    private javax.swing.JMenuItem jmiDeleteRecipe;
    private javax.swing.JMenuItem jmiEditRecipe;
    private javax.swing.JMenuItem jmiExit;
    private javax.swing.JMenuItem jmiExport;
    private javax.swing.JMenuItem jmiExportTemplates;
    private javax.swing.JMenuItem jmiHelpContents;
    private javax.swing.JMenuItem jmiHome;
    private javax.swing.JMenuItem jmiImport;
    private javax.swing.JMenuItem jmiMeal;
    private javax.swing.JMenuItem jmiNewBook;
    private javax.swing.JMenuItem jmiNewRecipe;
    private javax.swing.JMenuItem jmiOpenBook;
    private javax.swing.JMenuItem jmiOptions;
    private javax.swing.JMenuItem jmiPresentationTemplates;
    private javax.swing.JMenuItem jmiRedo;
    private javax.swing.JMenuItem jmiSave;
    private javax.swing.JMenuItem jmiSchedule;
    private javax.swing.JMenuItem jmiSearch;
    private javax.swing.JMenuItem jmiTemplatedBook;
    private javax.swing.JMenuItem jmiTips;
    private javax.swing.JMenu jmiTools;
    private javax.swing.JMenuItem jmiUndo;
    private javax.swing.JMenuItem jmiZipBook;
    private javax.swing.JPanel jpMainRightPanel;
    private javax.swing.JPanel jpTabLabel;
    private javax.swing.JPanel jpTabType;
    private javax.swing.JScrollPane jscpEditor;
    private javax.swing.JScrollPane jscpTreeLabelScroll;
    private javax.swing.JScrollPane jscpTreeTypeScroll;
    private javax.swing.JSplitPane jspMainSplit;
    private javax.swing.JToolBar jtbMainBar;
    private javax.swing.JTextField jtfQuickSearch;
    private javax.swing.JTabbedPane jtpTreeTabs;
    private javax.swing.JTree jtreeLabel;
    private javax.swing.JTree jtreeType;
    // End of variables declaration//GEN-END:variables
}
