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

import de.berlios.kcookb.exceptions.NonCoerentDatabaseException;
import de.berlios.kcookb.gui.utils.KCookBFilter;
import de.berlios.kcookb.gui.utils.KCookBFileView;
import de.berlios.kcookb.model.KCookB;
import de.berlios.kcookb.model.Recipe;
import de.berlios.kcookb.model.events.KCookBChangedListener;
import de.berlios.kcookb.model.events.KCookBEvent;
import de.berlios.kcookb.model.events.RecipeListener;
import edu.stanford.ejalbert.BrowserLauncher;
import edu.stanford.ejalbert.exception.BrowserLaunchingInitializingException;
import edu.stanford.ejalbert.exception.UnsupportedOperatingSystemException;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.io.File;
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
public class KCookBGui extends javax.swing.JFrame implements KCookBChangedListener, RecipeListener {

    private KCookBGui me = this;
    private KCookB book = null;
    private Recipe selectedRecipe;

    /** Creates new form KCookBGui */
    public KCookBGui() {
        initComponents();
        jepRecipe.setContentType("text/plain");
        defineInterfaceOptionsEstate(false);
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

    public KCookB getBook() {
        return book;
    }

    public void showRecipe(Recipe rep) {
        jepRecipe.setText(rep.getTitle());
        selectedRecipe = rep;
    }

    public void newBook(String name) {
        book = new KCookB(name);
        book.addKCookBChangedListener(me);
        defineInterfaceOptionsEstate(true);
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
        jfc.setFileFilter(new KCookBFilter());
        jfc.setFileView(new KCookBFileView());
        jfc.setMultiSelectionEnabled(false);

        if (jfc.showOpenDialog(this) == JFileChooser.APPROVE_OPTION) {
            book.openCatalog(jfc.getSelectedFile().getAbsolutePath());
            defineInterfaceOptionsEstate(true);
            createTrees();
        }
    }

    private void save() {
        book.save();
    }

    private void exit() {
        if (book != null) {
            if (book.hasChanges()) {
                switch (JOptionPane.showConfirmDialog(this,
                        java.util.ResourceBundle.getBundle("de/berlios/kcookb/resources/i18n/i18n").getString("KCookBGui.JOptionPane.exit.messagem"),
                        java.util.ResourceBundle.getBundle("de/berlios/kcookb/resources/i18n/i18n").getString("KCookBGui.JOptionPane.exit.title"),
                        JOptionPane.YES_NO_CANCEL_OPTION)) {
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
            book.removeRecipe(selectedRecipe);
        } catch (NonCoerentDatabaseException ex) {
            Logger.getLogger(KCookBGui.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void doQuickSearch(String text) {
        showSearchDialog(text);
    }

    private void undo() {
        book.undo();
    }

    private void redo() {
        book.redo();
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

            public void run() {
                new NoteDialog(me, true, selectedRecipe.getNote()).showCentered();
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
        //Toolbar buttons
        jbtnApplyStar.setEnabled(active);
        jbtnDeleteRecipe.setEnabled(active);
        jbtnEditRecipe.setEnabled(active);
        jbtnNewRecipe.setEnabled(active);
        jbtnNext.setEnabled(active);
        jbtnPrevious.setEnabled(active);
        jbtnPrintRecipe.setEnabled(active);
        jbtnQuickSearch.setEnabled(active);
        jbtnRecipeNotes.setEnabled(active);
        jbtnRedo.setEnabled(active);
        jbtnTips.setEnabled(active);
        jbtnUndo.setEnabled(active);
        //File menu items
        jmiBookInfo.setEnabled(active);
        jmiCloseBook.setEnabled(active);
        jmiExport.setEnabled(active);
        jmiZipBook.setEnabled(active);
        if (!active) {
            jbtnSave.setEnabled(false);
            jmiSave.setEnabled(false);
        }
        //Tools menu items
        jmiMeal.setEnabled(active);
        jmiSchedule.setEnabled(active);
        jmiTips.setEnabled(active);

        //Edit menu
        jmEdit.setEnabled(active);
    }

    private void zipAll(File selectedFile) {
        //TODO: zip contents
        /*
        import java.io.*;
        import java.util.zip.*;
        
        class Zip {
        public static void main(String args[]) throws IOException {
        byte b[] = new byte[512];
        ZipOutputStream zout = new ZipOutputStream(System.out);
        for(int i = 0; i < args.length; i ++) {
        InputStream in = new FileInputStream(args[i]);
        ZipEntry e = new ZipEntry(args[i].replace(File.separatorChar,'/'));
        zout.putNextEntry(e);
        int len=0;
        while((len=in.read(b)) != -1) {
        zout.write(b,0,len);
        }
        zout.closeEntry();
        print(e);
        }
        zout.close();
        }
        
        public static void print(ZipEntry e){
        PrintStream err = System.err;
        err.print("added " + e.getName());
        if (e.getMethod() == ZipEntry.DEFLATED) {
        long size = e.getSize();
        if (size > 0) {
        long csize = e.getCompressedSize();
        long ratio = ((size-csize)*100) / size;
        err.println(" (deflated " + ratio + "%)");
        }
        else {
        err.println(" (deflated 0%)");
        }
        }
        else {
        err.println(" (stored 0%)");
        }
        }
        }*/
        /*
         * // These are the files to include in the ZIP file
        String[] filenames = new String[]{"filename1", "filename2"};
        
        // Create a buffer for reading the files
        byte[] buf = new byte[1024];
        
        try {
        // Create the ZIP file
        String outFilename = "outfile.zip";
        ZipOutputStream out = new ZipOutputStream(new FileOutputStream(outFilename));
        
        // Compress the files
        for (int i=0; i<filenames.length; i++) {
        FileInputStream in = new FileInputStream(filenames[i]);
        
        // Add ZIP entry to output stream.
        out.putNextEntry(new ZipEntry(filenames[i]));
        
        // Transfer bytes from the file to the ZIP file
        int len;
        while ((len = in.read(buf)) > 0) {
        out.write(buf, 0, len);
        }
        
        // Complete the entry
        out.closeEntry();
        in.close();
        }
        
        // Complete the ZIP file
        out.close();
        } catch (IOException e) {
        }*/
    }

    private void createTrees() {
        //jtStaredRecipe
        //jtreeLabel
                //jtreeType
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jtbMainBar = new javax.swing.JToolBar();
        jbtnNewBook = new javax.swing.JButton();
        jbtnOpenBook = new javax.swing.JButton();
        jbtnSave = new javax.swing.JButton();
        jSeparator10 = new javax.swing.JToolBar.Separator();
        jbtnNewRecipe = new javax.swing.JButton();
        jbtnEditRecipe = new javax.swing.JButton();
        jbtnDeleteRecipe = new javax.swing.JButton();
        jSeparator11 = new javax.swing.JToolBar.Separator();
        jbtnUndo = new javax.swing.JButton();
        jbtnRedo = new javax.swing.JButton();
        jSeparator12 = new javax.swing.JToolBar.Separator();
        jbtnPrintRecipe = new javax.swing.JButton();
        jSeparator13 = new javax.swing.JToolBar.Separator();
        jtfQuickSearch = new javax.swing.JTextField();
        jbtnQuickSearch = new javax.swing.JButton();
        jSeparator14 = new javax.swing.JToolBar.Separator();
        jbtnPrevious = new javax.swing.JButton();
        jbtnNext = new javax.swing.JButton();
        jSeparator16 = new javax.swing.JToolBar.Separator();
        jbtnRecipeNotes = new javax.swing.JButton();
        jbtnTips = new javax.swing.JButton();
        jSeparator18 = new javax.swing.JToolBar.Separator();
        jbtnApplyStar = new javax.swing.JButton();
        jspMainSplit = new javax.swing.JSplitPane();
        jtpTreeTabs = new javax.swing.JTabbedPane();
        jpTabType = new javax.swing.JPanel();
        jscpTreeTypeScroll = new javax.swing.JScrollPane();
        jtreeType = new javax.swing.JTree();
        jpTabLabel = new javax.swing.JPanel();
        jscpTreeLabelScroll = new javax.swing.JScrollPane();
        jtreeLabel = new javax.swing.JTree();
        jpStaredRecipe = new javax.swing.JPanel();
        jscpStaredRecipe = new javax.swing.JScrollPane();
        jtStaredRecipe = new javax.swing.JTree();
        jpMainRightPanel = new javax.swing.JPanel();
        jscpEditor = new javax.swing.JScrollPane();
        jepRecipe = new javax.swing.JEditorPane();
        jmbMainMenu = new javax.swing.JMenuBar();
        jmFile = new javax.swing.JMenu();
        jmiNewBook = new javax.swing.JMenuItem();
        jSeparator2 = new javax.swing.JSeparator();
        jmiOpenBook = new javax.swing.JMenuItem();
        jmiCloseBook = new javax.swing.JMenuItem();
        jSeparator3 = new javax.swing.JSeparator();
        jmiSave = new javax.swing.JMenuItem();
        jSeparator15 = new javax.swing.JSeparator();
        jmiBookInfo = new javax.swing.JMenuItem();
        jSeparator17 = new javax.swing.JSeparator();
        jmiImport = new javax.swing.JMenuItem();
        jmiExport = new javax.swing.JMenuItem();
        jSeparator4 = new javax.swing.JSeparator();
        jmiZipBook = new javax.swing.JMenuItem();
        jSeparator7 = new javax.swing.JSeparator();
        jmiExit = new javax.swing.JMenuItem();
        jmEdit = new javax.swing.JMenu();
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
        java.util.ResourceBundle bundle = java.util.ResourceBundle.getBundle("de/berlios/kcookb/resources/i18n/i18n"); // NOI18N
        setTitle(bundle.getString("WINDOW_TITLE")); // NOI18N
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        jtbMainBar.setFloatable(false);
        jtbMainBar.setRollover(true);

        jbtnNewBook.setIcon(new javax.swing.ImageIcon(getClass().getResource("/de/berlios/kcookb/resources/images/x22/tb-new-book.png"))); // NOI18N
        jbtnNewBook.setToolTipText(bundle.getString("MAINBAR_TIP_NEWBOOK")); // NOI18N
        jbtnNewBook.setFocusable(false);
        jbtnNewBook.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jbtnNewBook.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jbtnNewBook.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnNewBookActionPerformed(evt);
            }
        });
        jtbMainBar.add(jbtnNewBook);

        jbtnOpenBook.setIcon(new javax.swing.ImageIcon(getClass().getResource("/de/berlios/kcookb/resources/images/x22/tb-open-book.png"))); // NOI18N
        jbtnOpenBook.setToolTipText(bundle.getString("MAINBAR_TIP_OPENBOOK")); // NOI18N
        jbtnOpenBook.setFocusable(false);
        jbtnOpenBook.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jbtnOpenBook.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jbtnOpenBook.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnOpenBookActionPerformed(evt);
            }
        });
        jtbMainBar.add(jbtnOpenBook);

        jbtnSave.setIcon(new javax.swing.ImageIcon(getClass().getResource("/de/berlios/kcookb/resources/images/x22/tb-save.png"))); // NOI18N
        jbtnSave.setToolTipText(bundle.getString("MAINBAR_TIP_SAVE")); // NOI18N
        jbtnSave.setFocusable(false);
        jbtnSave.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jbtnSave.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jbtnSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnSaveActionPerformed(evt);
            }
        });
        jtbMainBar.add(jbtnSave);
        jtbMainBar.add(jSeparator10);

        jbtnNewRecipe.setIcon(new javax.swing.ImageIcon(getClass().getResource("/de/berlios/kcookb/resources/images/x22/tb-new-recipe.png"))); // NOI18N
        jbtnNewRecipe.setToolTipText(bundle.getString("MAINBAR_TIP_NEWRECIPE")); // NOI18N
        jbtnNewRecipe.setFocusable(false);
        jbtnNewRecipe.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jbtnNewRecipe.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jbtnNewRecipe.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnNewRecipeActionPerformed(evt);
            }
        });
        jtbMainBar.add(jbtnNewRecipe);

        jbtnEditRecipe.setIcon(new javax.swing.ImageIcon(getClass().getResource("/de/berlios/kcookb/resources/images/x22/tb-edit.png"))); // NOI18N
        jbtnEditRecipe.setToolTipText(bundle.getString("MAINBAR_TIP_EDITRECIPE")); // NOI18N
        jbtnEditRecipe.setFocusable(false);
        jbtnEditRecipe.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jbtnEditRecipe.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jbtnEditRecipe.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnEditRecipeActionPerformed(evt);
            }
        });
        jtbMainBar.add(jbtnEditRecipe);

        jbtnDeleteRecipe.setIcon(new javax.swing.ImageIcon(getClass().getResource("/de/berlios/kcookb/resources/images/x22/tb-delete.png"))); // NOI18N
        jbtnDeleteRecipe.setToolTipText(bundle.getString("MAINBAR_TIP_DELETERECIPE")); // NOI18N
        jbtnDeleteRecipe.setFocusable(false);
        jbtnDeleteRecipe.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jbtnDeleteRecipe.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jbtnDeleteRecipe.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnDeleteRecipeActionPerformed(evt);
            }
        });
        jtbMainBar.add(jbtnDeleteRecipe);
        jtbMainBar.add(jSeparator11);

        jbtnUndo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/de/berlios/kcookb/resources/images/x22/tb-undo.png"))); // NOI18N
        jbtnUndo.setToolTipText(bundle.getString("KCookBGui.jbtnUndo.toolTipText")); // NOI18N
        jbtnUndo.setFocusable(false);
        jbtnUndo.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jbtnUndo.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jbtnUndo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnUndoActionPerformed(evt);
            }
        });
        jtbMainBar.add(jbtnUndo);

        jbtnRedo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/de/berlios/kcookb/resources/images/x22/tb-redo.png"))); // NOI18N
        jbtnRedo.setToolTipText(bundle.getString("KCookBGui.jbtnRedo.toolTipText")); // NOI18N
        jbtnRedo.setFocusable(false);
        jbtnRedo.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jbtnRedo.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jbtnRedo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnRedoActionPerformed(evt);
            }
        });
        jtbMainBar.add(jbtnRedo);
        jtbMainBar.add(jSeparator12);

        jbtnPrintRecipe.setIcon(new javax.swing.ImageIcon(getClass().getResource("/de/berlios/kcookb/resources/images/x22/tb-print-recipe.png"))); // NOI18N
        jbtnPrintRecipe.setToolTipText(bundle.getString("KCookBGui.jbtnPrintRecipe.toolTipText")); // NOI18N
        jbtnPrintRecipe.setFocusable(false);
        jbtnPrintRecipe.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jbtnPrintRecipe.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jbtnPrintRecipe.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnPrintRecipeActionPerformed(evt);
            }
        });
        jtbMainBar.add(jbtnPrintRecipe);
        jtbMainBar.add(jSeparator13);

        jtfQuickSearch.setMaximumSize(new java.awt.Dimension(150, 27));
        jtfQuickSearch.setPreferredSize(new java.awt.Dimension(150, 27));
        jtfQuickSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtfQuickSearchActionPerformed(evt);
            }
        });
        jtbMainBar.add(jtfQuickSearch);

        jbtnQuickSearch.setIcon(new javax.swing.ImageIcon(getClass().getResource("/de/berlios/kcookb/resources/images/x22/tb-find.png"))); // NOI18N
        jbtnQuickSearch.setToolTipText(bundle.getString("KCookBGui.jbtnQuickSearch.toolTipText")); // NOI18N
        jbtnQuickSearch.setFocusable(false);
        jbtnQuickSearch.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jbtnQuickSearch.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jbtnQuickSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnQuickSearchActionPerformed(evt);
            }
        });
        jtbMainBar.add(jbtnQuickSearch);
        jtbMainBar.add(jSeparator14);

        jbtnPrevious.setIcon(new javax.swing.ImageIcon(getClass().getResource("/de/berlios/kcookb/resources/images/x22/tb-previous.png"))); // NOI18N
        jbtnPrevious.setToolTipText(bundle.getString("KCookBGui.jbtnPrevious.toolTipText")); // NOI18N
        jbtnPrevious.setFocusable(false);
        jbtnPrevious.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jbtnPrevious.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jbtnPrevious.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnPreviousActionPerformed(evt);
            }
        });
        jtbMainBar.add(jbtnPrevious);

        jbtnNext.setIcon(new javax.swing.ImageIcon(getClass().getResource("/de/berlios/kcookb/resources/images/x22/tb-next.png"))); // NOI18N
        jbtnNext.setToolTipText(bundle.getString("KCookBGui.jbtnNext.toolTipText")); // NOI18N
        jbtnNext.setFocusable(false);
        jbtnNext.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jbtnNext.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jbtnNext.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnNextActionPerformed(evt);
            }
        });
        jtbMainBar.add(jbtnNext);
        jtbMainBar.add(jSeparator16);

        jbtnRecipeNotes.setIcon(new javax.swing.ImageIcon(getClass().getResource("/de/berlios/kcookb/resources/images/x22/tb-notes.png"))); // NOI18N
        jbtnRecipeNotes.setToolTipText(bundle.getString("KCookBGui.jbtnRecipeNotes.toolTipText")); // NOI18N
        jbtnRecipeNotes.setFocusable(false);
        jbtnRecipeNotes.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jbtnRecipeNotes.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jbtnRecipeNotes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnRecipeNotesActionPerformed(evt);
            }
        });
        jtbMainBar.add(jbtnRecipeNotes);

        jbtnTips.setIcon(new javax.swing.ImageIcon(getClass().getResource("/de/berlios/kcookb/resources/images/x22/tb-tips.png"))); // NOI18N
        jbtnTips.setToolTipText(bundle.getString("KCookBGui.jbtnTips.toolTipText")); // NOI18N
        jbtnTips.setFocusable(false);
        jbtnTips.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jbtnTips.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jbtnTips.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnTipsActionPerformed(evt);
            }
        });
        jtbMainBar.add(jbtnTips);
        jtbMainBar.add(jSeparator18);

        jbtnApplyStar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/de/berlios/kcookb/resources/images/x22/tb-star.png"))); // NOI18N
        jbtnApplyStar.setFocusable(false);
        jbtnApplyStar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jbtnApplyStar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jbtnApplyStar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnApplyStarActionPerformed(evt);
            }
        });
        jtbMainBar.add(jbtnApplyStar);

        jspMainSplit.setDividerLocation(160);

        jtpTreeTabs.setTabPlacement(javax.swing.JTabbedPane.BOTTOM);

        jtreeType.setModel(null);
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

        jtreeLabel.setModel(null);
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

        jtStaredRecipe.setModel(null);
        jscpStaredRecipe.setViewportView(jtStaredRecipe);

        org.jdesktop.layout.GroupLayout jpStaredRecipeLayout = new org.jdesktop.layout.GroupLayout(jpStaredRecipe);
        jpStaredRecipe.setLayout(jpStaredRecipeLayout);
        jpStaredRecipeLayout.setHorizontalGroup(
            jpStaredRecipeLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jscpStaredRecipe, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 154, Short.MAX_VALUE)
        );
        jpStaredRecipeLayout.setVerticalGroup(
            jpStaredRecipeLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jscpStaredRecipe, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 531, Short.MAX_VALUE)
        );

        jtpTreeTabs.addTab(bundle.getString("KCookBGui.jpStaredRecipe.TabConstraints.tabTitle"), new javax.swing.ImageIcon(getClass().getResource("/de/berlios/kcookb/resources/images/x16/tabbed-stared.png")), jpStaredRecipe); // NOI18N

        jspMainSplit.setLeftComponent(jtpTreeTabs);
        jtpTreeTabs.getAccessibleContext().setAccessibleName("null");

        jepRecipe.setEditable(false);
        jscpEditor.setViewportView(jepRecipe);

        org.jdesktop.layout.GroupLayout jpMainRightPanelLayout = new org.jdesktop.layout.GroupLayout(jpMainRightPanel);
        jpMainRightPanel.setLayout(jpMainRightPanelLayout);
        jpMainRightPanelLayout.setHorizontalGroup(
            jpMainRightPanelLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(org.jdesktop.layout.GroupLayout.TRAILING, jscpEditor)
        );
        jpMainRightPanelLayout.setVerticalGroup(
            jpMainRightPanelLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jscpEditor, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 561, Short.MAX_VALUE)
        );

        jspMainSplit.setRightComponent(jpMainRightPanel);

        jmFile.setText(bundle.getString("WINDOW_FILEMENU")); // NOI18N

        jmiNewBook.setIcon(new javax.swing.ImageIcon(getClass().getResource("/de/berlios/kcookb/resources/images/x16/mn-new-book.png"))); // NOI18N
        jmiNewBook.setText(bundle.getString("WINDOW_FILEMENU_NEWBOOK")); // NOI18N
        jmiNewBook.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmiNewBookActionPerformed(evt);
            }
        });
        jmFile.add(jmiNewBook);
        jmFile.add(jSeparator2);

        jmiOpenBook.setIcon(new javax.swing.ImageIcon(getClass().getResource("/de/berlios/kcookb/resources/images/x16/mn-open-book.png"))); // NOI18N
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
        jmFile.add(jSeparator3);

        jmiSave.setIcon(new javax.swing.ImageIcon(getClass().getResource("/de/berlios/kcookb/resources/images/x16/mn-save.png"))); // NOI18N
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

        jmiImport.setIcon(new javax.swing.ImageIcon(getClass().getResource("/de/berlios/kcookb/resources/images/x16/mn-import.png"))); // NOI18N
        jmiImport.setText(bundle.getString("WINDOW_FILEMENU_IMPORT")); // NOI18N
        jmiImport.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmiImportActionPerformed(evt);
            }
        });
        jmFile.add(jmiImport);

        jmiExport.setIcon(new javax.swing.ImageIcon(getClass().getResource("/de/berlios/kcookb/resources/images/x16/mn-export.png"))); // NOI18N
        jmiExport.setText(bundle.getString("WINDOW_FILEMENU_EXPORT")); // NOI18N
        jmiExport.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmiExportActionPerformed(evt);
            }
        });
        jmFile.add(jmiExport);
        jmFile.add(jSeparator4);

        jmiZipBook.setIcon(new javax.swing.ImageIcon(getClass().getResource("/de/berlios/kcookb/resources/images/x16/mn-package.png"))); // NOI18N
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

        jmEdit.setText(bundle.getString("WINDOW_EDITMENU")); // NOI18N

        jmiUndo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/de/berlios/kcookb/resources/images/x16/mn-undo.png"))); // NOI18N
        jmiUndo.setText(bundle.getString("WINDOW_EDITMENU_UNDO")); // NOI18N
        jmiUndo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmiUndoActionPerformed(evt);
            }
        });
        jmEdit.add(jmiUndo);

        jmiRedo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/de/berlios/kcookb/resources/images/x16/mn-redo.png"))); // NOI18N
        jmiRedo.setText(bundle.getString("WINDOW_EDITMENU_REDO")); // NOI18N
        jmiRedo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmiRedoActionPerformed(evt);
            }
        });
        jmEdit.add(jmiRedo);
        jmEdit.add(jSeparator5);

        jmiNewRecipe.setIcon(new javax.swing.ImageIcon(getClass().getResource("/de/berlios/kcookb/resources/images/x16/mn-new-recipe.png"))); // NOI18N
        jmiNewRecipe.setText(bundle.getString("WINDOW_EDITMENU_NEWRECIPE")); // NOI18N
        jmiNewRecipe.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmiNewRecipeActionPerformed(evt);
            }
        });
        jmEdit.add(jmiNewRecipe);

        jmiEditRecipe.setIcon(new javax.swing.ImageIcon(getClass().getResource("/de/berlios/kcookb/resources/images/x16/mn-edit.png"))); // NOI18N
        jmiEditRecipe.setText(bundle.getString("WINDOW_EDITMENU_EDITRECIPE")); // NOI18N
        jmiEditRecipe.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmiEditRecipeActionPerformed(evt);
            }
        });
        jmEdit.add(jmiEditRecipe);

        jmiDeleteRecipe.setIcon(new javax.swing.ImageIcon(getClass().getResource("/de/berlios/kcookb/resources/images/x16/mn-delete.png"))); // NOI18N
        jmiDeleteRecipe.setText(bundle.getString("WINDOW_EDITMENU_DELETERECIPE")); // NOI18N
        jmiDeleteRecipe.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmiDeleteRecipeActionPerformed(evt);
            }
        });
        jmEdit.add(jmiDeleteRecipe);
        jmEdit.add(jSeparator6);

        jmiSearch.setIcon(new javax.swing.ImageIcon(getClass().getResource("/de/berlios/kcookb/resources/images/x16/mn-find.png"))); // NOI18N
        jmiSearch.setText(bundle.getString("WINDOW_EDITMENU_FIND")); // NOI18N
        jmiSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmiSearchActionPerformed(evt);
            }
        });
        jmEdit.add(jmiSearch);

        jmbMainMenu.add(jmEdit);

        jmiTools.setText(bundle.getString("WINDOW_TOOLSMENU")); // NOI18N

        jmiMeal.setText(bundle.getString("WINDOW_TOOLSMENU_MEALS")); // NOI18N
        jmiMeal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmiMealActionPerformed(evt);
            }
        });
        jmiTools.add(jmiMeal);

        jmiTips.setIcon(new javax.swing.ImageIcon(getClass().getResource("/de/berlios/kcookb/resources/images/x16/mn-tips.png"))); // NOI18N
        jmiTips.setText(bundle.getString("WINDOW_TOOLSMENU_TIPS")); // NOI18N
        jmiTips.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmiTipsActionPerformed(evt);
            }
        });
        jmiTools.add(jmiTips);

        jmiSchedule.setIcon(new javax.swing.ImageIcon(getClass().getResource("/de/berlios/kcookb/resources/images/x16/mn-calendar.png"))); // NOI18N
        jmiSchedule.setText(bundle.getString("WINDOW_TOOLSMENU_SCHEDULE")); // NOI18N
        jmiSchedule.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmiScheduleActionPerformed(evt);
            }
        });
        jmiTools.add(jmiSchedule);
        jmiTools.add(jSeparator8);

        jmiOptions.setIcon(new javax.swing.ImageIcon(getClass().getResource("/de/berlios/kcookb/resources/images/x16/mn-preferences.png"))); // NOI18N
        jmiOptions.setText(bundle.getString("WINDOW_TOOLSMENU_OPTIONS")); // NOI18N
        jmiOptions.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmiOptionsActionPerformed(evt);
            }
        });
        jmiTools.add(jmiOptions);

        jmbMainMenu.add(jmiTools);

        jmHelp.setText(bundle.getString("WINDOW_HELPMENU")); // NOI18N

        jmiHelpContents.setIcon(new javax.swing.ImageIcon(getClass().getResource("/de/berlios/kcookb/resources/images/x16/mn-help.png"))); // NOI18N
        jmiHelpContents.setText(bundle.getString("WINDOW_HELPMENU_HELP")); // NOI18N
        jmiHelpContents.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmiHelpContentsActionPerformed(evt);
            }
        });
        jmHelp.add(jmiHelpContents);

        jmOnlineResources.setIcon(new javax.swing.ImageIcon(getClass().getResource("/de/berlios/kcookb/resources/images/x16/mn-internet.png"))); // NOI18N
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
            .add(jtbMainBar, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 759, Short.MAX_VALUE)
            .add(org.jdesktop.layout.GroupLayout.TRAILING, jspMainSplit, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 759, Short.MAX_VALUE)
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
        //TODO: help for main window
    }//GEN-LAST:event_jmiHelpContentsActionPerformed

    private void jbtnNewBookActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnNewBookActionPerformed
        newBook();
}//GEN-LAST:event_jbtnNewBookActionPerformed

    private void jbtnOpenBookActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnOpenBookActionPerformed
        openBook();
}//GEN-LAST:event_jbtnOpenBookActionPerformed

    private void jbtnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnSaveActionPerformed
        save();
}//GEN-LAST:event_jbtnSaveActionPerformed

    private void jbtnNewRecipeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnNewRecipeActionPerformed
        addNewRecipe();
}//GEN-LAST:event_jbtnNewRecipeActionPerformed

    private void jbtnDeleteRecipeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnDeleteRecipeActionPerformed
        deleteRecipe();
}//GEN-LAST:event_jbtnDeleteRecipeActionPerformed

    private void jbtnUndoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnUndoActionPerformed
        undo();
}//GEN-LAST:event_jbtnUndoActionPerformed

    private void jbtnRedoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnRedoActionPerformed
        redo();
}//GEN-LAST:event_jbtnRedoActionPerformed

    private void jbtnPrintRecipeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnPrintRecipeActionPerformed
        print();
}//GEN-LAST:event_jbtnPrintRecipeActionPerformed

    private void jbtnQuickSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnQuickSearchActionPerformed
        doQuickSearch(jtfQuickSearch.getText().trim());
}//GEN-LAST:event_jbtnQuickSearchActionPerformed

    private void jtfQuickSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtfQuickSearchActionPerformed
        doQuickSearch(jtfQuickSearch.getText().trim());
    }//GEN-LAST:event_jtfQuickSearchActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        exit();
    }//GEN-LAST:event_formWindowClosing

    private void jbtnEditRecipeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnEditRecipeActionPerformed
        editRecipe();
}//GEN-LAST:event_jbtnEditRecipeActionPerformed

    private void jbtnPreviousActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnPreviousActionPerformed
        previousRecipe();
}//GEN-LAST:event_jbtnPreviousActionPerformed

    private void jbtnNextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnNextActionPerformed
        nextRecipe();
}//GEN-LAST:event_jbtnNextActionPerformed

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
        defineInterfaceOptionsEstate(false);
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

    private void jmiZipBookActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmiZipBookActionPerformed
        JFileChooser jfc = new JFileChooser();

        //TODO: config jfc
        if (jfc.showSaveDialog(this) == JFileChooser.APPROVE_OPTION) {
            zipAll(jfc.getSelectedFile());
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
                new BookInfoGui(me, true, book).setVisible(true);
            }
        });
    }//GEN-LAST:event_jmiBookInfoActionPerformed

    private void jbtnRecipeNotesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnRecipeNotesActionPerformed
        showNotes();
}//GEN-LAST:event_jbtnRecipeNotesActionPerformed

    private void jbtnApplyStarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnApplyStarActionPerformed
        selectedRecipe.setStared(!selectedRecipe.isStared());
}//GEN-LAST:event_jbtnApplyStarActionPerformed

    private void jbtnTipsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnTipsActionPerformed
        showTips();
}//GEN-LAST:event_jbtnTipsActionPerformed

    private void jmiTipsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmiTipsActionPerformed
        showTips();
    }//GEN-LAST:event_jmiTipsActionPerformed

    public void recipeAdded(KCookBEvent ev) {
        //TODO: added recipe
    }

    public void recipeDeleted(KCookBEvent ev) {
        //TODO: remove recipe
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(KCookBGui.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            Logger.getLogger(KCookBGui.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(KCookBGui.class.getName()).log(Level.SEVERE, null, ex);
        } catch (UnsupportedLookAndFeelException ex) {
            Logger.getLogger(KCookBGui.class.getName()).log(Level.SEVERE, null, ex);
        }

        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                new KCookBGui().setVisible(true);
            }
        });

    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
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
    private javax.swing.JButton jbtnApplyStar;
    private javax.swing.JButton jbtnDeleteRecipe;
    private javax.swing.JButton jbtnEditRecipe;
    private javax.swing.JButton jbtnNewBook;
    private javax.swing.JButton jbtnNewRecipe;
    private javax.swing.JButton jbtnNext;
    private javax.swing.JButton jbtnOpenBook;
    private javax.swing.JButton jbtnPrevious;
    private javax.swing.JButton jbtnPrintRecipe;
    private javax.swing.JButton jbtnQuickSearch;
    private javax.swing.JButton jbtnRecipeNotes;
    private javax.swing.JButton jbtnRedo;
    private javax.swing.JButton jbtnSave;
    private javax.swing.JButton jbtnTips;
    private javax.swing.JButton jbtnUndo;
    private javax.swing.JEditorPane jepRecipe;
    private javax.swing.JMenu jmEdit;
    private javax.swing.JMenu jmFile;
    private javax.swing.JMenu jmHelp;
    private javax.swing.JMenu jmOnlineResources;
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
    private javax.swing.JMenuItem jmiTips;
    private javax.swing.JMenu jmiTools;
    private javax.swing.JMenuItem jmiUndo;
    private javax.swing.JMenuItem jmiZipBook;
    private javax.swing.JPanel jpMainRightPanel;
    private javax.swing.JPanel jpStaredRecipe;
    private javax.swing.JPanel jpTabLabel;
    private javax.swing.JPanel jpTabType;
    private javax.swing.JScrollPane jscpEditor;
    private javax.swing.JScrollPane jscpStaredRecipe;
    private javax.swing.JScrollPane jscpTreeLabelScroll;
    private javax.swing.JScrollPane jscpTreeTypeScroll;
    private javax.swing.JSplitPane jspMainSplit;
    private javax.swing.JTree jtStaredRecipe;
    private javax.swing.JToolBar jtbMainBar;
    private javax.swing.JTextField jtfQuickSearch;
    private javax.swing.JTabbedPane jtpTreeTabs;
    private javax.swing.JTree jtreeLabel;
    private javax.swing.JTree jtreeType;
    // End of variables declaration//GEN-END:variables
}
