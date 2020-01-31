package view;

import java.awt.Desktop;
import handling.DBConnection;
import handling.Photo;
import handling.Employee;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.DefaultCellEditor;
import javax.swing.ImageIcon;
import javax.swing.InputMap;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JProgressBar;
import javax.swing.JTable;
import javax.swing.KeyStroke;
import javax.swing.SwingWorker;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import net.proteanit.sql.DbUtils;

public final class EmployeeView extends javax.swing.JFrame {

    Connection connection;
    Statement statement;
    ResultSet result;

    Employee employee;

    String wersja = "5.3.1";
    File file = null;   //saved big photo
    public final String[] categories = {"\"Wszystkie\"", "Brak", "Spożywcze", "RTV"};
    private int start = 0, limit = 10, nextPageNumber = 1, selectSize = 0;  //"limit" max 50 (zmien j w "getPhotos" zeby było normalnie)
    java.util.ArrayList<ImageIcon> images = new java.util.ArrayList<>();
    String category = "\"Wszystkie\"";
    Object selectedItem = "", prevItem = "";
    DefaultTableModel orderTableModel;

    public EmployeeView(JProgressBar loginClassBar) {
        initComponents();
        table.setAutoscrolls(false);
        progressBar.setStringPainted(true);

        //DELETE SAVED PICTURE WHEN CLOSING PROGRAM
        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
            if (file != null) {
                file.delete();
                System.out.println("Skasowano obrazek \"saved.jpg\"");
            }
        }, "Shutdown-thread"));

        connection = DBConnection.getDBConnection();

        JProgressBar store = progressBar;
        progressBar = loginClassBar;

        //FILL TABLE
        try {
            statement = connection.createStatement();
            selectRange(start, limit, category);
            table.requestFocus(true);
            table.changeSelection(0, 1, false, false);
            photo.setIcon(images.get(0));

        } catch (SQLException ex) {
            System.out.println("Błąd przy tworzeniu widoku pracownika!");
        }

        progressBar = store;
        progressBar.setValue(0);
        setItemComboBoxCategories();

        employee = Employee.getEmployee();
        footer.setText("zalogowano: " + employee.name + " " + employee.surname);

    }

    public void getImages() throws SQLException {
        System.out.println("pobieram OD: " + start);
        System.out.println("pobieram DO: " + (selectSize + start - 1));
        images.clear();

        int j = 0;
        for (int i = start; i < selectSize + start; i++) {
            System.out.print("pobieram i: " + i);
            Object id = (Object) table.getModel().getValueAt(j, 0);
            System.out.println(" -> ID: " + id);
            addImageToList(id);
            j++;
            progressBar.setValue(j * 2);
        }
        progressBar.setValue(100);

    }

    public boolean selectRange(int start, int ile, String kategoria) throws SQLException {
        if (kategoria.equals("search")) {
            result = statement.executeQuery("select id,nazwa,ilość,kategoria from produkty where nazwa like '%" + searchField.getText() + "%' limit " + start + "," + ile + ";");

        } else {
            if (kategoria.equals("\"Wszystkie\"")) {
                result = statement.executeQuery("select id,nazwa,ilość,kategoria from produkty limit " + start + "," + ile + ";");

            } else {
                result = statement.executeQuery("select id,nazwa,ilość,kategoria from produkty where kategoria='" + kategoria + "' limit " + start + "," + ile + ";");
            }
        }

        if (result.next()) {
            result.last();
            selectSize = result.getRow();
            result.beforeFirst();
            System.out.println("\nRozmiar: " + selectSize);

            if (result.isBeforeFirst() && selectSize >= ile) {
                System.out.println("--jest nastepna strona--");
                nextPage.setEnabled(true);

            } else {
                System.out.println("--nie ma nastepnej strony--");
                nextPage.setEnabled(false);
            }

            setResultToTable();
            getImages();
            return true;
        } else {
            return false;
        }
    }

    private void addImageToList(Object photoID) {
        Photo zdjecie = new Photo();
        BufferedImage bImg = zdjecie.getBufferedImage(photoID);

        //RESCALE IMAGE
        int width = bImg.getWidth();
        int height = bImg.getHeight();

        Dimension imgSize = new Dimension(width, height);
        Dimension boundary = new Dimension(378, 220);
        Dimension rescaleResult = zdjecie.getScaledDimension(imgSize, boundary);

        width = (int) rescaleResult.getWidth();
        height = (int) rescaleResult.getHeight();

        ImageIcon imageIcon = new ImageIcon(bImg.getScaledInstance(width, height, Image.SCALE_DEFAULT));
        images.add(imageIcon);
    }

    private void setResultToTable() {
        table.setModel(DbUtils.resultSetToTableModel(result));
        TableColumn tc = table.getColumn("id");
        tc.setMaxWidth(80);
    }

    private void setItemComboBoxCategories() {
        TableColumn column = table.getColumnModel().getColumn(3);
        JComboBox comboBox = new JComboBox();
        for (int i = 1; i < categories.length; i++) {
            comboBox.addItem(categories[i]);
        }

        column.setCellEditor(new DefaultCellEditor(comboBox));
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        menuRMB = new javax.swing.JPopupMenu();
        addToOrder = new javax.swing.JMenuItem();
        jSeparatorRMB1 = new javax.swing.JPopupMenu.Separator();
        saveLine = new javax.swing.JMenuItem();
        saveAll = new javax.swing.JMenuItem();
        jSeparatorRMB2 = new javax.swing.JPopupMenu.Separator();
        updatePhoto = new javax.swing.JMenuItem();
        jSeparatorRMB3 = new javax.swing.JPopupMenu.Separator();
        addProduct = new javax.swing.JMenuItem();
        deleteItem = new javax.swing.JMenuItem();
        menuRMBOrder = new javax.swing.JPopupMenu();
        deleteOrderItem = new javax.swing.JMenuItem();
        tabPanel = new javax.swing.JTabbedPane();
        readTab = new javax.swing.JPanel();
        scrollTable = new javax.swing.JScrollPane();
        table = new javax.swing.JTable();
        searchField = new javax.swing.JTextField();
        search = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        photo = new javax.swing.JLabel();
        categoriesComboBox = new javax.swing.JComboBox<>();
        nextPage = new javax.swing.JButton();
        previousPage = new javax.swing.JButton();
        searchText = new javax.swing.JLabel();
        categoryText = new javax.swing.JLabel();
        footer = new javax.swing.JLabel();
        filler1 = new javax.swing.Box.Filler(new java.awt.Dimension(1, 0), new java.awt.Dimension(1, 0), new java.awt.Dimension(1, 32767));
        refresh = new javax.swing.JButton();
        progressBar = new javax.swing.JProgressBar();
        showCategory = new javax.swing.JButton();
        scrollOrderTable = new javax.swing.JScrollPane();
        orderTable = new javax.swing.JTable();
        orderButton = new javax.swing.JButton();
        orderText = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        orderTab = new javax.swing.JPanel();
        menu = new javax.swing.JMenuBar();
        options = new javax.swing.JMenu();
        addEmployee = new javax.swing.JMenuItem();
        jSeparatorOptions = new javax.swing.JPopupMenu.Separator();
        changePassword = new javax.swing.JMenuItem();
        logOut = new javax.swing.JMenuItem();
        help = new javax.swing.JMenu();
        helpInfo = new javax.swing.JMenuItem();
        informations = new javax.swing.JMenuItem();

        addToOrder.setText("Dodaj do zamówienia");
        addToOrder.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addToOrderActionPerformed(evt);
            }
        });
        menuRMB.add(addToOrder);
        menuRMB.add(jSeparatorRMB1);

        saveLine.setText("Zapisz zaznaczoną linię");
        saveLine.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveLineActionPerformed(evt);
            }
        });
        menuRMB.add(saveLine);

        saveAll.setText("Zapisz wszystko");
        saveAll.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveAllActionPerformed(evt);
            }
        });
        menuRMB.add(saveAll);
        menuRMB.add(jSeparatorRMB2);

        updatePhoto.setText("Zmień zdjęcie");
        updatePhoto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updatePhotoActionPerformed(evt);
            }
        });
        menuRMB.add(updatePhoto);
        menuRMB.add(jSeparatorRMB3);

        addProduct.setText("Dodaj produkt");
        addProduct.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addProductActionPerformed(evt);
            }
        });
        menuRMB.add(addProduct);

        deleteItem.setText("Usuń zaznaczony produkt");
        deleteItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteItemActionPerformed(evt);
            }
        });
        menuRMB.add(deleteItem);

        deleteOrderItem.setText("Usuń z zamówienia");
        deleteOrderItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteOrderItemActionPerformed(evt);
            }
        });
        menuRMBOrder.add(deleteOrderItem);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Magazyn");
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/data/logo.png")));
        setMinimumSize(new java.awt.Dimension(954, 670));
        setName("Magazyn"); // NOI18N
        setPreferredSize(new java.awt.Dimension(954, 670));
        setSize(new java.awt.Dimension(954, 670));

        tabPanel.setTabLayoutPolicy(javax.swing.JTabbedPane.SCROLL_TAB_LAYOUT);
        tabPanel.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        tabPanel.setFont(new java.awt.Font("Dialog", 0, 11)); // NOI18N

        readTab.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                readTabKeyPressed(evt);
            }
        });

        table.setFont(new java.awt.Font("Dialog", 0, 11)); // NOI18N
        table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "id", "nazwa", "ilość", "kategoria"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, true, true, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        table.setMinimumSize(new java.awt.Dimension(60, 500));
        table.getTableHeader().setReorderingAllowed(false);
        table.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                tableFocusGained(evt);
            }
        });
        table.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                tableMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                tableMouseReleased(evt);
            }
        });
        table.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tableKeyPressed(evt);
            }
        });
        scrollTable.setViewportView(table);
        if (table.getColumnModel().getColumnCount() > 0) {
            table.getColumnModel().getColumn(0).setMaxWidth(80);
        }

        searchField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                searchFieldKeyPressed(evt);
            }
        });

        search.setFont(new java.awt.Font("Dialog", 0, 11)); // NOI18N
        search.setText("Szukaj");
        search.setActionCommand("");
        search.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchActionPerformed(evt);
            }
        });
        search.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                searchKeyPressed(evt);
            }
        });

        photo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        photo.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        photo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                photoMouseClicked(evt);
            }
        });

        categoriesComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(categories));
        categoriesComboBox.setKeySelectionManager(null);
        categoriesComboBox.setLightWeightPopupEnabled(false);
        categoriesComboBox.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                categoriesComboBoxFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                categoriesComboBoxFocusLost(evt);
            }
        });
        categoriesComboBox.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                categoriesComboBoxKeyPressed(evt);
            }
        });

        nextPage.setText("Następna strona");
        nextPage.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nextPageActionPerformed(evt);
            }
        });
        nextPage.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                nextPageKeyPressed(evt);
            }
        });

        previousPage.setText("Poprzednia strona");
        previousPage.setEnabled(false);
        previousPage.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                previousPageActionPerformed(evt);
            }
        });
        previousPage.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                previousPageKeyPressed(evt);
            }
        });

        searchText.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        searchText.setText("Szukaj produktu:");

        categoryText.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        categoryText.setText("Wybierz kategorię:");

        footer.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);

        refresh.setText("Odśwież");
        refresh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                refreshActionPerformed(evt);
            }
        });
        refresh.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                refreshKeyPressed(evt);
            }
        });

        progressBar.setMaximumSize(new java.awt.Dimension(100, 25));
        progressBar.setMinimumSize(new java.awt.Dimension(100, 25));
        progressBar.setPreferredSize(new java.awt.Dimension(100, 25));

        showCategory.setFont(new java.awt.Font("Dialog", 0, 11)); // NOI18N
        showCategory.setText("Wyświetl");
        showCategory.setActionCommand("");
        showCategory.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                showCategoryActionPerformed(evt);
            }
        });
        showCategory.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                showCategoryKeyPressed(evt);
            }
        });

        orderTableModel=new DefaultTableModel(){
            @Override
            public boolean isCellEditable(int row, int column) {
                //all cells false
                return false;
            }
        };
        orderTable.setModel(orderTableModel
        );
        orderTableModel.addColumn("id");
        orderTableModel.addColumn("nazwa");
        orderTableModel.addColumn("ilość");
        TableColumn tc = orderTable.getColumn("id");
        tc.setMaxWidth(80);
        orderTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                orderTableMouseReleased(evt);
            }
        });
        scrollOrderTable.setViewportView(orderTable);

        orderButton.setText("Zamów");

        orderText.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        orderText.setText("Zamówienie:");

        javax.swing.GroupLayout readTabLayout = new javax.swing.GroupLayout(readTab);
        readTab.setLayout(readTabLayout);
        readTabLayout.setHorizontalGroup(
            readTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(readTabLayout.createSequentialGroup()
                .addGroup(readTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, readTabLayout.createSequentialGroup()
                        .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 379, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED))
                    .addGroup(readTabLayout.createSequentialGroup()
                        .addGroup(readTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(readTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addGroup(readTabLayout.createSequentialGroup()
                                    .addGap(8, 8, 8)
                                    .addGroup(readTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 379, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGroup(readTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, readTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                                .addComponent(photo, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 378, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGroup(readTabLayout.createSequentialGroup()
                                                    .addGap(6, 6, 6)
                                                    .addComponent(filler1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, readTabLayout.createSequentialGroup()
                                                    .addGroup(readTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                        .addGroup(readTabLayout.createSequentialGroup()
                                                            .addComponent(categoryText, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                            .addComponent(categoriesComboBox, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                                        .addGroup(readTabLayout.createSequentialGroup()
                                                            .addComponent(searchText, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                            .addGap(18, 18, 18)
                                                            .addComponent(searchField, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                    .addGroup(readTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(search, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                        .addComponent(showCategory, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                                            .addComponent(scrollOrderTable, javax.swing.GroupLayout.PREFERRED_SIZE, 376, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, readTabLayout.createSequentialGroup()
                                    .addGap(14, 14, 14)
                                    .addComponent(footer, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(orderButton)))
                            .addGroup(readTabLayout.createSequentialGroup()
                                .addGap(12, 12, 12)
                                .addComponent(orderText, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(10, 10, 10)))
                .addGroup(readTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(readTabLayout.createSequentialGroup()
                        .addComponent(refresh)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(progressBar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(previousPage)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(nextPage)
                        .addContainerGap())
                    .addComponent(scrollTable, javax.swing.GroupLayout.DEFAULT_SIZE, 552, Short.MAX_VALUE)))
        );
        readTabLayout.setVerticalGroup(
            readTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, readTabLayout.createSequentialGroup()
                .addGroup(readTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(scrollTable, javax.swing.GroupLayout.DEFAULT_SIZE, 574, Short.MAX_VALUE)
                    .addGroup(readTabLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(readTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(readTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(search, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(searchField, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(searchText, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(9, 9, 9)
                        .addGroup(readTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(categoriesComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(categoryText, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(showCategory, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(photo, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(orderText)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(scrollOrderTable, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(filler1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(1, 1, 1)
                .addGroup(readTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(nextPage, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(readTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(previousPage, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(refresh, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(progressBar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(footer, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(orderButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        tabPanel.addTab("Odczytaj", readTab);

        orderTab.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                orderTabKeyPressed(evt);
            }
        });

        javax.swing.GroupLayout orderTabLayout = new javax.swing.GroupLayout(orderTab);
        orderTab.setLayout(orderTabLayout);
        orderTabLayout.setHorizontalGroup(
            orderTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 949, Short.MAX_VALUE)
        );
        orderTabLayout.setVerticalGroup(
            orderTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 620, Short.MAX_VALUE)
        );

        tabPanel.addTab("Zamówienie", orderTab);

        options.setIcon(new javax.swing.ImageIcon(getClass().getResource("/data/options.png"))); // NOI18N
        options.setText("Opcje");

        addEmployee.setIcon(new javax.swing.ImageIcon(getClass().getResource("/data/person.png"))); // NOI18N
        addEmployee.setText("Dodaj pracownika");
        addEmployee.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addEmployeeActionPerformed(evt);
            }
        });
        options.add(addEmployee);
        options.add(jSeparatorOptions);

        changePassword.setIcon(new javax.swing.ImageIcon(getClass().getResource("/data/lock.png"))); // NOI18N
        changePassword.setText("Zmień hasło");
        changePassword.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                changePasswordActionPerformed(evt);
            }
        });
        options.add(changePassword);

        logOut.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F1, 0));
        logOut.setIcon(new javax.swing.ImageIcon(getClass().getResource("/data/exit.png"))); // NOI18N
        logOut.setText("Wyloguj");
        logOut.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                logOutActionPerformed(evt);
            }
        });
        options.add(logOut);

        menu.add(options);

        help.setIcon(new javax.swing.ImageIcon(getClass().getResource("/data/info.png"))); // NOI18N
        help.setText("Pomoc");

        helpInfo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/data/h.png"))); // NOI18N
        helpInfo.setText("Wskazówki");
        helpInfo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                helpInfoActionPerformed(evt);
            }
        });
        help.add(helpInfo);

        informations.setIcon(new javax.swing.ImageIcon(getClass().getResource("/data/i.png"))); // NOI18N
        informations.setText("Informacje o programie");
        informations.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                informationsActionPerformed(evt);
            }
        });
        help.add(informations);

        menu.add(help);

        setJMenuBar(menu);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(tabPanel, javax.swing.GroupLayout.Alignment.TRAILING)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(tabPanel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 649, Short.MAX_VALUE)
        );

        tabPanel.getAccessibleContext().setAccessibleName("panelZakladek");

        getAccessibleContext().setAccessibleDescription("Magazyn");

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void logOutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_logOutActionPerformed
        employee.name = null;
        employee.surname = null;
        employee.login = null;
        employee.password = null;
        employee.email = null;

        this.dispose();
        LoginClass loginClass = new LoginClass();
        loginClass.setVisible(true);
    }//GEN-LAST:event_logOutActionPerformed

    private void addEmployeeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addEmployeeActionPerformed
        AddEmployee dodajPracownika = new AddEmployee();
        dodajPracownika.setVisible(true);
    }//GEN-LAST:event_addEmployeeActionPerformed

    private void saveLineActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveLineActionPerformed
        new SwingWorker<Void, Void>() {
            @Override
            protected Void doInBackground() throws Exception {
                progressBar.setStringPainted(false);
                progressBar.setIndeterminate(true);
                setEnabled(false);
                int rowNumber = table.getSelectedRow();
                Object id = (Object) table.getModel().getValueAt(rowNumber, 0);
                Object name = table.getModel().getValueAt(rowNumber, 1);
                Object quantity = table.getModel().getValueAt(rowNumber, 2);
                Object category = table.getModel().getValueAt(rowNumber, 3);
                boolean correctness = true;

                try {
                    statement.executeUpdate("update produkty set nazwa='" + name + "',ilość='" + quantity + "', kategoria='" + category + "' where id='" + id + "';");

                } catch (SQLException ex) {
                    correctness = false;
                }
//setItemComboBoxCategories();
                setEnabled(true);
                progressBar.setIndeterminate(false);
                progressBar.setStringPainted(true);

                if (correctness) {
                    // TableColumn tc = table.getColumnModel().getColumn(0);
                    //  tc.setCellRenderer(new DefaultTableCellRenderer());
                    // table.repaint();
                    JOptionPane.showMessageDialog(null, "ID: " + id + "\nNazwa: " + name + "\nIlość: " + quantity + "\nKategoria: " + category, "Zaktualizowano", JOptionPane.DEFAULT_OPTION);
                } else {
                    JOptionPane.showMessageDialog(null, "Sprawdź poprawność danych (ID produktu: " + id + ")", "Błąd", JOptionPane.ERROR_MESSAGE);
                }

                return null;
            }
        }.execute();


    }//GEN-LAST:event_saveLineActionPerformed

    private void saveAllActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveAllActionPerformed
        new SwingWorker<Void, Void>() {
            @Override
            protected Void doInBackground() throws Exception {
                progressBar.setStringPainted(false);
                progressBar.setIndeterminate(true);
                setEnabled(false);
                int rows = table.getRowCount();
                Object id = null, name, quantity, category;
                boolean correctness = true;

                for (int i = 0; i < rows; i++) {
                    id = table.getModel().getValueAt(i, 0);
                    name = table.getModel().getValueAt(i, 1);
                    quantity = table.getModel().getValueAt(i, 2);
                    category = table.getModel().getValueAt(i, 3);

                    try {
                        statement.executeUpdate("update produkty set nazwa='" + name + "',ilość='" + quantity + "', kategoria='" + category + "' where id='" + id + "';");

                    } catch (SQLException ex) {
                        correctness = false;
                        break;
                    }

                }
//setItemComboBoxCategories();
                setEnabled(true);
                progressBar.setIndeterminate(false);
                progressBar.setStringPainted(true);

                if (correctness) {
                    //   TableColumn tc = table.getColumnModel().getColumn(0);
                    // tc.setCellRenderer(new DefaultTableCellRenderer());
                    // table.repaint();
                    JOptionPane.showMessageDialog(null, "Zapisano wszystkie zmiany", "Zaktualizowano", JOptionPane.DEFAULT_OPTION);
                } else {
                    JOptionPane.showMessageDialog(null, "Sprawdź poprawność danych (ID produktu: " + id + ")", "Błąd", JOptionPane.ERROR_MESSAGE);
                }

                return null;
            }
        }.execute();

    }//GEN-LAST:event_saveAllActionPerformed

    private void deleteItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteItemActionPerformed
        progressBar.setIndeterminate(true);

        new SwingWorker<Void, Void>() {
            @Override
            protected Void doInBackground() throws Exception {
                setEnabled(false);

                int numerWiersza = table.getSelectedRow();
                Object id = (Object) table.getModel().getValueAt(numerWiersza, 0);
                Object nazwa = table.getModel().getValueAt(numerWiersza, 1);
                Object ilosc = table.getModel().getValueAt(numerWiersza, 2);
                boolean poprawnosc = true;

                try {
                    statement.executeUpdate("delete from produkty where id='" + id + "';");

                } catch (SQLException ex) {
                    poprawnosc = false;
                }

                DefaultTableModel model = (DefaultTableModel) table.getModel();
                for (int i = 1; i <= 3; i++) {
                    model.setValueAt("-deleted-", numerWiersza, i);
                }

                setEnabled(true);
                progressBar.setIndeterminate(false);

                if (poprawnosc) {
                    JOptionPane.showMessageDialog(null, "SKASOWANO PRODUKT\nID: " + id + "\nNazwa: " + nazwa + "\nIlość: " + ilosc, "Zaktualizowano", JOptionPane.DEFAULT_OPTION);

                } else {
                    System.out.println("Błąd przy kasowaniu produktu!");
                }

                return null;
            }
        }.execute();


    }//GEN-LAST:event_deleteItemActionPerformed

    private void helpInfoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_helpInfoActionPerformed
        JOptionPane.showMessageDialog(null, "1. Dodatkowe opcje edycji tabeli - kliknij PPM na którymkolwiek produkcie" + ""
                + "\n2. Kliknij w zdjęcie aby je otworzyć"
                + "\n3. Pomoc e-mail: dan123.98@o2.pl", "Wskazówki", JOptionPane.INFORMATION_MESSAGE);

    }//GEN-LAST:event_helpInfoActionPerformed

    private void informationsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_informationsActionPerformed
        JOptionPane.showMessageDialog(null, "Program do obsługi sklepu \"Magazyn\"\nStworzył: Daniel Chrzanowski\nWersja: " + wersja, "Informacje o programie", JOptionPane.INFORMATION_MESSAGE);

    }//GEN-LAST:event_informationsActionPerformed

    private void changePasswordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_changePasswordActionPerformed
        ChangePassword zmianaHasla = new ChangePassword();
        zmianaHasla.setVisible(true);
    }//GEN-LAST:event_changePasswordActionPerformed

    private void addProductActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addProductActionPerformed
        AddProduct dod = new AddProduct(this);
        dod.setVisible(true);
    }//GEN-LAST:event_addProductActionPerformed

    private void photoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_photoMouseClicked
        if (evt.getButton() == MouseEvent.BUTTON1) {

            int rowNumber = table.getSelectedRow();
            Object id = (Object) table.getModel().getValueAt(rowNumber, 0);

            Photo photoObject = new Photo();
            BufferedImage image = photoObject.getBufferedImage(id);

            //SAVE AS "saved.jpg"
            if (file != null) {
                file.delete();
            }

            if (image != null) {
                java.io.File outputfile = new java.io.File("saved.jpg");

                try {
                    ImageIO.write(image, "jpg", outputfile);

                    //SHOW IN WINDOWS
                    file = new File("saved.jpg");
                    Desktop desktop = Desktop.getDesktop();
                    desktop.open(file);

                } catch (IOException ex) {
                    Logger.getLogger(EmployeeView.class.getName()).log(Level.SEVERE, null, ex);
                }
            } else {
                JOptionPane.showMessageDialog(null, "Przekroczono limit czasu oczekiwania na zdjęcie!", "Błąd", JOptionPane.ERROR_MESSAGE);
            }

        }
    }//GEN-LAST:event_photoMouseClicked

    private void searchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchActionPerformed
        new SwingWorker<Void, Void>() {
            @Override
            protected Void doInBackground() throws Exception {
                requestFocus(false);
                setEnabled(false);

                int tempStart = start;
                start = 0;
                System.out.println("limit: " + limit);

                if (selectRange(start, limit, "search")) {
                    photo.setIcon(images.get(0));
                    progressBar.setValue(0);

                    nextPageNumber = 1;
                    previousPage.setEnabled(false);
                    //images.clear();

                    categoriesComboBox.setSelectedIndex(0);
                    category = categories[0];
                    setItemComboBoxCategories();
                    setEnabled(true);
                    table.requestFocus(true);
                    table.changeSelection(0, 1, false, false);
                } else {
                    start = tempStart;
                    setItemComboBoxCategories();
                    setEnabled(true);
                    searchField.setText("");
                    table.requestFocus(true);
                    table.changeSelection(0, 1, false, false);
                    JOptionPane.showMessageDialog(null, "Brak wyników!", "Info", JOptionPane.INFORMATION_MESSAGE);
                }

                return null;
            }
        }.execute();

    }//GEN-LAST:event_searchActionPerformed

    private void searchFieldKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_searchFieldKeyPressed
        int keyCode = evt.getKeyCode();

        if (keyCode == KeyEvent.VK_ENTER) {
            search.doClick();
        }

        if (keyCode == KeyEvent.VK_DOWN) {
            categoriesComboBox.requestFocus(true);
        }

        if (keyCode == KeyEvent.VK_RIGHT) {
            search.requestFocus(true);
        }
    }//GEN-LAST:event_searchFieldKeyPressed

    private void tableKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tableKeyPressed
        int keyCode = evt.getKeyCode();

        if (keyCode == KeyEvent.VK_ENTER) {

            InputMap im = table.getInputMap(JTable.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT);
            KeyStroke enter = KeyStroke.getKeyStroke(KeyEvent.VK_ENTER, 0);
            KeyStroke f2 = KeyStroke.getKeyStroke(KeyEvent.VK_F2, 0);
            im.put(enter, im.get(f2));

        }

        if (keyCode == KeyEvent.VK_LEFT) {
            int numerKolumny = table.getSelectedColumn();

            if (numerKolumny == 1) {
                search.requestFocus(true);
            }

        }

        if (keyCode == KeyEvent.VK_DOWN) {
            int numerWiersza = table.getSelectedRow();
            int ostatniWiersz = table.getModel().getRowCount();

            if (numerWiersza < ostatniWiersz - 1) {
                photo.setIcon(images.get(numerWiersza + 1));
            } else {
                if (nextPage.isEnabled()) {
                    nextPage.requestFocus(true);
                } else {
                    previousPage.requestFocus(true);
                }
            }
        }

        if (keyCode == KeyEvent.VK_UP) {
            int numerWiersza = table.getSelectedRow();

            if (numerWiersza != 0) {
                photo.setIcon(images.get(numerWiersza - 1));
            }

        }

        if (keyCode == KeyEvent.VK_HOME
                || keyCode == KeyEvent.VK_END
                || keyCode == KeyEvent.VK_DELETE
                || keyCode == KeyEvent.VK_INSERT
                || keyCode == KeyEvent.VK_PAUSE
                || keyCode == KeyEvent.VK_SCROLL_LOCK) {
            refresh.doClick();
        }

    }//GEN-LAST:event_tableKeyPressed

    private void tableMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableMouseReleased
        if (evt.isPopupTrigger()) {
            int verticalScrollValue = scrollTable.getVerticalScrollBar().getValue();
            menuRMB.show(this, evt.getX() + 405, evt.getY() - verticalScrollValue + 105);
        }
    }//GEN-LAST:event_tableMouseReleased

    private void tableMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableMousePressed
        int numerKolumny = table.getSelectedColumn();
        int numerWiersza = table.getSelectedRow();

        if (numerKolumny == 0) {
            table.requestFocus();
            table.changeSelection(numerWiersza, 1, false, false);
            JOptionPane.showMessageDialog(null, "Uwaga!\nNie można edytować ID!", "Ostrzeżenie", JOptionPane.WARNING_MESSAGE);
        }

        photo.setIcon(images.get(numerWiersza));
    }//GEN-LAST:event_tableMousePressed

    private void searchKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_searchKeyPressed
        int keyCode = evt.getKeyCode();

        if (keyCode == KeyEvent.VK_ENTER) {
            search.doClick();
        }

        if (keyCode == KeyEvent.VK_LEFT) {
            searchField.requestFocus(true);
        }

        if (keyCode == KeyEvent.VK_DOWN) {
            showCategory.requestFocus(true);
        }

        if (keyCode == KeyEvent.VK_UP) {
            readTab.requestFocus(true);
        }

        if (keyCode == KeyEvent.VK_RIGHT) {
            int numerWiersza = table.getSelectedRow();
            int numerKolumny = table.getSelectedColumn();
            table.requestFocus(true);
            table.changeSelection(numerWiersza, numerKolumny, false, false);
        }
    }//GEN-LAST:event_searchKeyPressed

    private void readTabKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_readTabKeyPressed
        int keyCode = evt.getKeyCode();

        if (keyCode == KeyEvent.VK_RIGHT) {
            tabPanel.setSelectedIndex(1);
        }

        if (keyCode == KeyEvent.VK_ENTER || keyCode == KeyEvent.VK_DOWN) {
            searchField.requestFocus(true);
        }

    }//GEN-LAST:event_readTabKeyPressed

    private void orderTabKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_orderTabKeyPressed
        int keyCode = evt.getKeyCode();

        if (keyCode == KeyEvent.VK_LEFT) {
            tabPanel.setSelectedIndex(0);
        }

    }//GEN-LAST:event_orderTabKeyPressed

    private void categoriesComboBoxKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_categoriesComboBoxKeyPressed
        int keyCode = evt.getKeyCode();
        int selectedIndex = categoriesComboBox.getSelectedIndex();

        if (keyCode == KeyEvent.VK_UP) {
            if (selectedIndex == 0) {
                searchField.requestFocusInWindow();
            }
        }

        if (keyCode == KeyEvent.VK_DOWN) {
            int length = categoriesComboBox.getItemCount();

            if (selectedIndex == length - 1) {
                refresh.requestFocusInWindow();
            }
        }

        if (keyCode == KeyEvent.VK_ENTER) {
            showCategory.doClick();
        }

        if (keyCode == KeyEvent.VK_RIGHT) {
            showCategory.requestFocus(true);
        }
    }//GEN-LAST:event_categoriesComboBoxKeyPressed

    private void categoriesComboBoxFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_categoriesComboBoxFocusGained
        categoriesComboBox.showPopup();
    }//GEN-LAST:event_categoriesComboBoxFocusGained

    private void refreshActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_refreshActionPerformed
        new SwingWorker<Void, Void>() {
            @Override
            protected Void doInBackground() {
                requestFocus(false);
                setEnabled(false);
                // images.clear();

                if (searchField.getText().isEmpty()) {
                    try {
                        System.out.println("Odświeżanie: START-" + start + " ILE-" + limit + " KATEGORIA-" + category);
                        selectRange(start, limit, category);

                    } catch (SQLException exc) {
                        JOptionPane.showMessageDialog(null, "Błąd przy odświeżaniu kategorie", "Błąd", JOptionPane.ERROR_MESSAGE);
                    }
                } else {

                    try {
                        System.out.println("Odświeżanie: START-" + start + " ILE-" + limit + " KATEGORIA-" + category);
                        selectRange(start, limit, "search");

                    } catch (SQLException exc) {
                        JOptionPane.showMessageDialog(null, "Błąd przy odświeżaniu szukaj", "Błąd", JOptionPane.ERROR_MESSAGE);
                    }

                }

                photo.setIcon(images.get(0));
                progressBar.setValue(0);
                setItemComboBoxCategories();
                setEnabled(true);
                table.requestFocus(true);
                table.changeSelection(0, 1, false, false);
                return null;
            }
        }.execute();

    }//GEN-LAST:event_refreshActionPerformed

    private void refreshKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_refreshKeyPressed
        int keyCode = evt.getKeyCode();

        if (keyCode == KeyEvent.VK_UP) {
            int numerWiersza = table.getSelectedRow();
            int numerKolumny = table.getSelectedColumn();
            table.requestFocus(true);
            table.changeSelection(numerWiersza, numerKolumny, false, false);
        }

        if (keyCode == KeyEvent.VK_ENTER) {
            refresh.doClick();
        }

        if (keyCode == KeyEvent.VK_RIGHT) {
            if (previousPage.isEnabled()) {
                previousPage.requestFocus();
            } else {
                nextPage.requestFocus();
            }
        }

        if (keyCode == KeyEvent.VK_LEFT) {
            showCategory.requestFocus();
        }

    }//GEN-LAST:event_refreshKeyPressed

    private void tableFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_tableFocusGained
        int numerKolumny = table.getSelectedColumn();
        int numerWiersza = table.getSelectedRow();

        if (numerKolumny == 0) {
            table.requestFocus(true);
            table.changeSelection(numerWiersza, 1, false, false);
        }
    }//GEN-LAST:event_tableFocusGained

    private void nextPageKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_nextPageKeyPressed
        int keyCode = evt.getKeyCode();

        if (keyCode == KeyEvent.VK_UP) {
            int numerWiersza = table.getSelectedRow();
            int numerKolumny = table.getSelectedColumn();
            table.requestFocus(true);
            table.changeSelection(numerWiersza, numerKolumny, false, false);
        }

        if (keyCode == KeyEvent.VK_ENTER) {
            nextPage.doClick();
        }

        if (keyCode == KeyEvent.VK_LEFT) {
            if (previousPage.isEnabled()) {
                previousPage.requestFocus();
            } else {
                refresh.requestFocus();
            }
        }
    }//GEN-LAST:event_nextPageKeyPressed

    private void showCategoryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_showCategoryActionPerformed
        new SwingWorker<Void, Void>() {
            @Override
            protected Void doInBackground() throws Exception {
                requestFocus(false);
                setEnabled(false);
                category = categoriesComboBox.getSelectedItem().toString();

                start = 0;
                nextPageNumber = 1;
                previousPage.setEnabled(false);
                // images.clear();
                searchField.setText("");

                try {
                    System.out.println("start: " + start + " kategoria: " + category);
                    selectRange(start, limit, category);

                } catch (SQLException exc) {
                    JOptionPane.showMessageDialog(null, "Błąd przy odświeżaniu", "Błąd", JOptionPane.ERROR_MESSAGE);
                }

                photo.setIcon(images.get(0));
                progressBar.setValue(0);
                setEnabled(true);
                table.requestFocus(true);
                table.changeSelection(0, 1, false, false);
                return null;
            }
        }.execute();

    }//GEN-LAST:event_showCategoryActionPerformed

    private void showCategoryKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_showCategoryKeyPressed
        int keyCode = evt.getKeyCode();

        if (keyCode == KeyEvent.VK_UP) {
            search.requestFocus();
        }

        if (keyCode == KeyEvent.VK_ENTER) {
            showCategory.doClick();
        }

        if (keyCode == KeyEvent.VK_RIGHT) {
            int numerWiersza = table.getSelectedRow();
            int numerKolumny = table.getSelectedColumn();
            table.requestFocus(true);
            table.changeSelection(numerWiersza, numerKolumny, false, false);
        }

        if (keyCode == KeyEvent.VK_LEFT) {
            categoriesComboBox.requestFocus();
        }

        if (keyCode == KeyEvent.VK_DOWN) {
            refresh.requestFocus();
        }
    }//GEN-LAST:event_showCategoryKeyPressed

    private void categoriesComboBoxFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_categoriesComboBoxFocusLost
        categoriesComboBox.getUI().setPopupVisible(categoriesComboBox, false);
    }//GEN-LAST:event_categoriesComboBoxFocusLost

    private void nextPageActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nextPageActionPerformed
        new SwingWorker<Void, Void>() {
            @Override
            protected Void doInBackground() throws Exception {
                requestFocus(false);
                setEnabled(false);
                // images.clear();

                start = limit * nextPageNumber;
                nextPageNumber++;
                //System.out.println("Start: "+start+"nextPageNumber: "+nextPageNumber);

                try {
                    System.out.println("start: " + start + " kategoria: " + category);
                    if (searchField.getText().isEmpty()) {
                        selectRange(start, limit, category);
                    } else {
                        selectRange(start, limit, "search");
                    }

                } catch (SQLException ex) {
                    System.out.println("Błąd przy wyświetlaniu następnej strony");
                }

                if (nextPageNumber > 1) {
                    previousPage.setEnabled(true);
                }

                photo.setIcon(images.get(0));
                progressBar.setValue(0);
                setEnabled(true);
                table.requestFocus(true);
                table.changeSelection(0, 1, false, false);
                return null;
            }
        }.execute();

    }//GEN-LAST:event_nextPageActionPerformed

    private void previousPageActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_previousPageActionPerformed
        new SwingWorker<Void, Void>() {
            @Override
            protected Void doInBackground() throws Exception {
                requestFocus(false);
                setEnabled(false);
                // images.clear();
                nextPageNumber--;
                start = limit * (nextPageNumber - 1);

                try {
                    System.out.println("start: " + start + " kategoria: " + category);
                    if (searchField.getText().isEmpty()) {
                        selectRange(start, limit, category);
                    } else {
                        selectRange(start, limit, "search");
                    }
                } catch (SQLException ex) {
                    System.out.println("Błąd przy wyświetlaniu następnej strony");
                }

                if (nextPageNumber <= 1) {
                    previousPage.setEnabled(false);
                }

                photo.setIcon(images.get(0));
                progressBar.setValue(0);
                setEnabled(true);
                table.requestFocus(true);
                table.changeSelection(0, 1, false, false);
                return null;
            }
        }.execute();

    }//GEN-LAST:event_previousPageActionPerformed

    private void previousPageKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_previousPageKeyPressed
        int keyCode = evt.getKeyCode();

        if (keyCode == KeyEvent.VK_UP) {
            int row = table.getSelectedRow();
            int column = table.getSelectedColumn();
            table.requestFocus(true);
            table.changeSelection(row, column, false, false);
        }

        if (keyCode == KeyEvent.VK_ENTER) {
            previousPage.doClick();
        }

        if (keyCode == KeyEvent.VK_LEFT) {
            refresh.requestFocus();
        }

        if (keyCode == KeyEvent.VK_RIGHT) {
            if (nextPage.isEnabled()) {
                nextPage.requestFocus();
            }
        }
    }//GEN-LAST:event_previousPageKeyPressed

    private void updatePhotoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updatePhotoActionPerformed
        int row = (int) table.getValueAt(table.getSelectedRow(), 0);
        String name = (String) table.getValueAt(table.getSelectedRow(), 1);
        UpdatePhoto update = new UpdatePhoto(row, name);
        update.setVisible(true);
    }//GEN-LAST:event_updatePhotoActionPerformed

    private void addToOrderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addToOrderActionPerformed
        int row = table.getSelectedRow();

        int id = (Integer) table.getValueAt(row, 0);
        String name = (String) table.getValueAt(row, 1);
        int DBQuantity = (Integer) table.getValueAt(row, 2);

        int tableLength = orderTable.getRowCount();
        boolean repetition = false;

        //check if not already added
        for (int i = 0; i < tableLength; i++) {
            int orderItemID = (Integer) orderTable.getValueAt(i, 0);

            if (orderItemID == id) {
                repetition = true;
                break;
            }

        }

        if (repetition == false) {
            String productInfo = "ID: " + id + " - " + name;
            AddToOrder iq = new AddToOrder(id, name, DBQuantity, orderTableModel, productInfo);
            iq.setVisible(true);

        } else {
            JOptionPane.showMessageDialog(null, "Produkt jest już na liście!", "Błąd", JOptionPane.ERROR_MESSAGE);
        }

    }//GEN-LAST:event_addToOrderActionPerformed

    private void orderTableMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_orderTableMouseReleased
        if (evt.isPopupTrigger()) {
            int verticalScrollValue = scrollOrderTable.getVerticalScrollBar().getValue();
            menuRMBOrder.show(this, evt.getX() + 18, evt.getY() - verticalScrollValue + 472);
        }
    }//GEN-LAST:event_orderTableMouseReleased

    private void deleteOrderItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteOrderItemActionPerformed
        int row = orderTable.getSelectedRow();

        orderTableModel.removeRow(row);

    }//GEN-LAST:event_deleteOrderItemActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem addEmployee;
    private javax.swing.JMenuItem addProduct;
    private javax.swing.JMenuItem addToOrder;
    private javax.swing.JComboBox<String> categoriesComboBox;
    private javax.swing.JLabel categoryText;
    private javax.swing.JMenuItem changePassword;
    private javax.swing.JMenuItem deleteItem;
    private javax.swing.JMenuItem deleteOrderItem;
    private javax.swing.Box.Filler filler1;
    private javax.swing.JLabel footer;
    private javax.swing.JMenu help;
    private javax.swing.JMenuItem helpInfo;
    private javax.swing.JMenuItem informations;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JPopupMenu.Separator jSeparatorOptions;
    private javax.swing.JPopupMenu.Separator jSeparatorRMB1;
    private javax.swing.JPopupMenu.Separator jSeparatorRMB2;
    private javax.swing.JPopupMenu.Separator jSeparatorRMB3;
    private javax.swing.JMenuItem logOut;
    private javax.swing.JMenuBar menu;
    private javax.swing.JPopupMenu menuRMB;
    private javax.swing.JPopupMenu menuRMBOrder;
    private javax.swing.JButton nextPage;
    private javax.swing.JMenu options;
    private javax.swing.JButton orderButton;
    private javax.swing.JPanel orderTab;
    private javax.swing.JTable orderTable;
    private javax.swing.JLabel orderText;
    public javax.swing.JLabel photo;
    private javax.swing.JButton previousPage;
    public javax.swing.JProgressBar progressBar;
    private javax.swing.JPanel readTab;
    private javax.swing.JButton refresh;
    private javax.swing.JMenuItem saveAll;
    private javax.swing.JMenuItem saveLine;
    private javax.swing.JScrollPane scrollOrderTable;
    private javax.swing.JScrollPane scrollTable;
    private javax.swing.JButton search;
    private javax.swing.JTextField searchField;
    private javax.swing.JLabel searchText;
    private javax.swing.JButton showCategory;
    private javax.swing.JTabbedPane tabPanel;
    public javax.swing.JTable table;
    private javax.swing.JMenuItem updatePhoto;
    // End of variables declaration//GEN-END:variables

}
