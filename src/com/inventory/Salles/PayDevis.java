/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.inventory.Salles;

import com.inventory.Combo.ComboItem;
import com.inventory.DAO.ProductDAO;
import com.inventory.DTO.ProductDTO;
import com.inventory.Database.ConnectionFactory;
import com.inventory.raport.PDFSalleNoTVA;
import com.inventory.raport.PDFSalleTVA;
import com.itextpdf.text.DocumentException;
import com.inventory.raport.PdfSalle;
import java.awt.Desktop;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author deidine
 */
public class PayDevis extends javax.swing.JDialog {

    /**
     * Creates new form PayDevis2
     */
    String username;
    Double moneyToCaisse = 0.0;

    Connection conn = null;
    Statement statement = null;
    ResultSet resultSet = null;
    private Object[] data;

    Object[] items
            = {
                new ComboItem("Choisir type operation"),
                new ComboItem("Cash"),
                new ComboItem("A Terme"),};

    /**
     * Creates new form PayDevis
     */
    public PayDevis(Object[] data, String username) {
        try {
            conn = new ConnectionFactory().getConn();
            statement = conn.createStatement();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        this.username = username;
        this.data = data;
        initComponents();
        isTva();

        loadDataSet();
        allDevisTable();
        totalValue();

        getCustemr();
        setLocationRelativeTo(null);
        setResizable(false);
        setModal(true);
        setVisible(true);
        setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel4 = new javax.swing.JPanel();
        codeText = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        phoneText = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        nameText = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        locationText = new javax.swing.JTextField();
        jPanel5 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        allDevisTable = new javax.swing.JTable();
        jPanel3 = new javax.swing.JPanel();
        btnPay = new javax.swing.JButton();
        txtRecu = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        txtRendre = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        txtTotal = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        operationType = new javax.swing.JComboBox<>();
        TVA = new javax.swing.JCheckBox();
        jLabel7 = new javax.swing.JLabel();
        txtbnCmnd = new javax.swing.JTextField();

        jPanel4.setBackground(new java.awt.Color(0, 255, 255));

        codeText.setEditable(false);
        codeText.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        codeText.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                codeTextActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Segoe UI", 2, 14)); // NOI18N
        jLabel2.setText(" Code du client:");

        jLabel5.setFont(new java.awt.Font("Segoe UI", 2, 14)); // NOI18N
        jLabel5.setText("Num Telephone:");

        phoneText.setEditable(false);
        phoneText.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        phoneText.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                phoneTextActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Segoe UI", 2, 14)); // NOI18N
        jLabel3.setText("Nom Complete:");

        nameText.setEditable(false);
        nameText.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N

        jLabel4.setFont(new java.awt.Font("Segoe UI", 2, 14)); // NOI18N
        jLabel4.setText("Lieux Habitation:");

        locationText.setEditable(false);
        locationText.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(codeText, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jLabel5)
                .addGap(0, 0, 0)
                .addComponent(phoneText, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jLabel3)
                .addGap(0, 0, 0)
                .addComponent(nameText, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(locationText, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(49, 49, 49))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(codeText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(phoneText, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(nameText, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(locationText, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, 0))
        );

        allDevisTable.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        allDevisTable.setModel(new javax.swing.table.DefaultTableModel(
        ) );
        jScrollPane2.setViewportView(allDevisTable);

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 654, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 525, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel3.setBackground(new java.awt.Color(0, 153, 153));
        jPanel3.setForeground(new java.awt.Color(255, 255, 255));

        btnPay.setBackground(new java.awt.Color(51, 51, 0));
        btnPay.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnPay.setForeground(new java.awt.Color(255, 255, 255));
        btnPay.setText("Terminer");
        btnPay.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPayActionPerformed(evt);
            }
        });

        txtRecu.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        txtRecu.setForeground(new java.awt.Color(4, 0, 0));
        txtRecu.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtRecu.setText("0");
        txtRecu.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtRecuKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtRecuKeyTyped(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Total Recu");

        txtRendre.setEditable(false);
        txtRendre.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        txtRendre.setForeground(new java.awt.Color(4, 0, 0));
        txtRendre.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtRendre.setText("0");
        txtRendre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtRendreActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Total A Rendre");

        txtTotal.setEditable(false);
        txtTotal.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        txtTotal.setForeground(new java.awt.Color(4, 0, 0));
        txtTotal.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtTotal.setText("0");
        txtTotal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTotalActionPerformed(evt);
            }
        });

        jLabel13.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setText("Total a payee");

        //operationType.setRenderer(new ComboRenderer());

        operationType.setModel(
            new javax.swing.DefaultComboBoxModel(items));

        TVA.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        TVA.setForeground(new java.awt.Color(255, 255, 255));
        TVA.setText("TVA");
        TVA.setEnabled(false);
        TVA.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TVAActionPerformed(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText(" No: Bon Cmnde");

        txtbnCmnd.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        txtbnCmnd.setForeground(new java.awt.Color(4, 0, 0));
        txtbnCmnd.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtbnCmnd.setText("0");
        txtbnCmnd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtbnCmndActionPerformed(evt);
            }
        });

        jLabel13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/money.png")));

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(operationType, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtTotal)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel3Layout.createSequentialGroup()
                                .addComponent(btnPay, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(txtRendre, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtRecu, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addComponent(TVA, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(txtbnCmnd))
                    .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(jLabel13)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtRendre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtRecu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtbnCmnd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(operationType, javax.swing.GroupLayout.DEFAULT_SIZE, 38, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(TVA)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnPay, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(125, 125, 125))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void codeTextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_codeTextActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_codeTextActionPerformed

    private void phoneTextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_phoneTextActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_phoneTextActionPerformed

    private void btnPayActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPayActionPerformed
        String operation = null;
        Double total = Double.valueOf(txtTotal.getText());
        Double recu = Double.valueOf(txtRecu.getText());
        operation = operationType.getSelectedItem().toString();
        if (null == operation) {
        } else {
            switch (operation) {
                case "Cash": {

                    if (!txtRecu.getText().equals("") && !txtRecu.getText().equals("0") && recu >= total) {
                        moneyToCaisse = moneyToCaisse + Double.valueOf(txtTotal.getText());
                        try {
                            selleOrloanProduct(false);
                        } catch (URISyntaxException ex) {
                            Logger.getLogger(PayDevis.class.getName()).log(Level.SEVERE, null, ex);
                        } catch (InterruptedException ex) {
                            Logger.getLogger(PayDevis.class.getName()).log(Level.SEVERE, null, ex);
                        }

                    } else {
                        JOptionPane.showMessageDialog(this,
                                "il vaut rmeplie le montent recu "
                                + "pour et le montent doit \n"
                                + "etre superaire ou egal"
                                + " le montent total terminer "
                                + " l'operation.");
                        txtRecu.requestFocus();

                        txtRecu.setSelectionStart(0);
                        txtRecu.setSelectionEnd(txtRecu.getText().length());
                    }
                    putMoneyInCaisse();
                    break;
                }
                // TODO add your handling code here:
                case "A Terme": {
                    if ((txtRecu.getText().equals("0") || recu < total)) {

                        try {
                            selleOrloanProduct(true);
                        } catch (URISyntaxException ex) {
                            Logger.getLogger(PayDevis.class.getName()).log(Level.SEVERE, null, ex);
                        } catch (InterruptedException ex) {
                            Logger.getLogger(PayDevis.class.getName()).log(Level.SEVERE, null, ex);
                        }

                    } else {
                        JOptionPane.showMessageDialog(this,
                                " le montent doit \n"
                                + "etre inferieur a \n"
                                + " le montent total ou egal\n zero ou le client inconue ne peux pas emprete les produit pour terminer "
                                + " l'operation A terme.");
                        txtRecu.requestFocus();

                        txtRecu.setSelectionStart(0);
                        txtRecu.setSelectionEnd(txtRecu.getText().length());
                    }

                    break;
                }
                default:
                    JOptionPane.showMessageDialog(this,
                            "il vaut choisir le type de vente ou le type d'operation vende en cash ou mise en terme pour terminer l'operation.");
                    break;
            }
        }
        // TODO add your handling code here:
    }//GEN-LAST:event_btnPayActionPerformed

    private void txtRecuKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtRecuKeyReleased
        Double totalPaye = Double.valueOf(txtTotal.getText());
        Double totalRecu = Double.valueOf(txtRecu.getText());
        if (totalRecu >= totalPaye) {
            txtRendre.setText("" + (totalRecu - totalPaye) + "");
            //            int revenu = Integer.parseInt(txtRendre.getText());
            //            txtRendre.setText("" + (revenu) + "");

        } else {
            txtRendre.setText("0");
        }
        // TODO add your handling code here:
    }//GEN-LAST:event_txtRecuKeyReleased

    private void txtRecuKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtRecuKeyTyped
        char c = evt.getKeyChar();
        if (!(Character.isDigit(c)) && !(c == KeyEvent.VK_BACK_SPACE)) {
            JOptionPane.showMessageDialog(null, "il vaut entrer les nombre seulement", "Ilegal Input",
                    JOptionPane.ERROR_MESSAGE);
            evt.consume();
        }    // TODO add your handling code here:
    }//GEN-LAST:event_txtRecuKeyTyped

    private void txtRendreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtRendreActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtRendreActionPerformed

    private void txtTotalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTotalActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTotalActionPerformed

    private void TVAActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TVAActionPerformed
        totalValue();        // TODO add your handling code here:
    }//GEN-LAST:event_TVAActionPerformed

    private void txtbnCmndActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtbnCmndActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtbnCmndActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JCheckBox TVA;
    private javax.swing.JTable allDevisTable;
    private javax.swing.JButton btnPay;
    private javax.swing.JTextField codeText;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextField locationText;
    private javax.swing.JTextField nameText;
    private javax.swing.JComboBox<String> operationType;
    private javax.swing.JTextField phoneText;
    private javax.swing.JTextField txtRecu;
    private javax.swing.JTextField txtRendre;
    private javax.swing.JTextField txtTotal;
    private javax.swing.JTextField txtbnCmnd;
    // End of variables declaration//GEN-END:variables

    private void allDevisTable() {
        DefaultTableModel listpays = (DefaultTableModel) allDevisTable.getModel();
        listpays.addColumn("idVende");
        listpays.addColumn("code produit");

        listpays.addColumn("pix de vende");
        listpays.addColumn("quentite");

        listpays.addColumn("nom produit");
        listpays.addColumn("idDetail");

        try {
            String tampilBarang = "SELECT `salesid`, `date`, `customercode`, `total_paye`, "
                    + "`recu`, `changeMony`, `soldby`,"
                    + " `productcode`, `quantity`, `isLoan`,"
                    + " (SELECT  `productname` FROM `products` as p WHERE"
                    + " p.productcode=s.productcode) as productname ,"
                    + " `detaild`, `sellprice` FROM devisdata as s where   "
                    + "  customercode='" + codeText.getText() + "' and salesid='" + data[0].toString() + "'";

            resultSet = statement.executeQuery(tampilBarang);

            DefaultTableModel laporan = new DefaultTableModel();
            laporan.addColumn("id");
            laporan.addColumn("code produit");

            laporan.addColumn("prix vente");
            laporan.addColumn("quentite");
            laporan.addColumn("nom Produit");

            laporan.addColumn("idDetail");

            laporan.getDataVector().removeAllElements();
            laporan.fireTableDataChanged();
            laporan.setRowCount(0);

            while (resultSet.next()) {
                laporan.addRow(new Object[]{
                    resultSet.getString("salesid"),
                    resultSet.getString("productcode"),
                    resultSet.getString("sellprice"),
                    resultSet.getString("quantity"),
                    resultSet.getString("productname"),
                    resultSet.getString("detaild"),});
                allDevisTable.setModel(laporan);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "cek Kembali " + e + "");
        }
    }

    private void delteDevis() {
        if (allDevisTable.getRowCount() != 0) {

            for (int i = 0; i < allDevisTable.getRowCount(); i++) {
                //this query will delete from saledetail table if the client pay his debit 

                String query = "DELETE FROM sale_devis_detail WHERE detaild    ='" + allDevisTable.getValueAt(i, 5) + "'";

                //this will check if id stell in saleifo but not in saildetail table so will delete it to not let
                //it stay in houre database and not also show that the clent is not pay his loan or debit 
                try {
                    statement.executeUpdate(query);

                } catch (SQLException ex) {
                    Logger.getLogger(PayDevis.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            String query2 = "DELETE FROM salesdevis WHERE salesid NOT IN(SELECT salesid FROM sale_devis_detail) ";

            try {
                statement.executeUpdate(query2);
            } catch (SQLException ex) {
                Logger.getLogger(PayDevis.class.getName()).log(Level.SEVERE, null, ex);
            }
            totalValue();
            DefaultTableModel listSalles = (DefaultTableModel) allDevisTable.getModel();
            listSalles.setRowCount(0);
        } else {
            JOptionPane.showMessageDialog(this, "Le Table est null.");

        }

    }

    private String getCureentTime() {
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date dates = new Date();

        return dateFormat.format(dates);

    }

    void totalValue() {

        Utils.totalValue((DefaultTableModel) allDevisTable.getModel(), TVA, txtTotal, allDevisTable);

    }

    public void loadDataSet() {
        codeText.setText(data[2].toString());
    }

    public void getCustemr() {
        try {
            String query = "select * FROM customers WHERE customercode='" + codeText.getText() + "'";
            resultSet = statement.executeQuery(query);

            if (resultSet.next()) {
                nameText.setText(resultSet.getString("fullname"));
                locationText.setText(resultSet.getString("location"));
                phoneText.setText(resultSet.getString("phone"));

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void isTva() {
        String isTva = "false";
        try {
            String query = "select isTva FROM salesdevis WHERE salesid ='" + data[0].toString() + "'";
            resultSet = statement.executeQuery(query);
//            isTva = resultSet.next();
            while (resultSet.next()) {
                isTva = resultSet.getString("isTva");
                if (isTva.equals("true")) {
                    TVA.setSelected(true);
                } else {
                    TVA.setSelected(false);

                }
//
                System.out.println(resultSet.getString("isTva") + "SS" + data[0].toString() + "ss" + isTva);
//
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println(data[0].toString() + "ss" + isTva);
    }

    public void selleOrloanProduct(boolean isLoan) throws URISyntaxException, InterruptedException {
        DefaultTableModel listSalles = (DefaultTableModel) allDevisTable.getModel();

        boolean tva = false;
        if (TVA.isSelected()) {
            tva = true;
        }
        if (listSalles.getRowCount() != 0) {
            ProductDTO productDTO = new ProductDTO();
            ProductDTO productDTO2 = new ProductDTO();

            productDTO.setDate(getCureentTime());
            productDTO.setCustCode(codeText.getText());
            productDTO.setTotalRcue(Double.parseDouble(txtRecu.getText()));
            productDTO.setTotalPayee(Double.parseDouble(txtTotal.getText()));
            productDTO.setTotalChange(Double.parseDouble(txtRendre.getText()));

            new ProductDAO().sellProductDAO(productDTO, this.username, isLoan, tva);
            int id = new ProductDAO().idSalle();
            productDTO2.setSalleID(id);
            productDTO.setSalleID(id);
            for (int i = 0; i < listSalles.getRowCount(); i++) {

                productDTO2.setDate(listSalles.getValueAt(i, 4).toString());
                productDTO2.setCustCode(listSalles.getValueAt(i, 0).toString());
                productDTO2.setProdCode(listSalles.getValueAt(i, 1).toString());
                productDTO2.setSellPrice(Double.parseDouble(listSalles.getValueAt(i, 2).toString()));

                productDTO2.setQuantity(Double.parseDouble(listSalles.getValueAt(i, 3).toString()));
                new ProductDAO().sellDetailProductDAO(productDTO2, id);
            }
//new ProductDAO().report(id);
//            JOptionPane.showMessageDialog(null, "le vende est terminer  pour le client." + productDTO.getCustCode() + " par le vendeur " + username + " bonjournee");
            saveFile();
            delteDevis();
            listSalles.setRowCount(0);
//            clear3();

        } else {
            JOptionPane.showMessageDialog(this, "Le Table est null.");

        }

    }

    public void saveFile() throws URISyntaxException, InterruptedException {

        try {

            if (TVA.isSelected()) {
                PDFSalleTVA.inBaoCao(new File("deidine.pdf"), getCureentTime(), operationType.getSelectedItem().toString(), (DefaultTableModel) allDevisTable.getModel(),
                        getCustomerInfo(codeText.getText()), txtRecu.getText(), txtRendre.getText(), txtTotal.getText(), true,txtbnCmnd.getText());
                
            } else {
                PDFSalleTVA.inBaoCao(new File("deidine.pdf"), getCureentTime(), operationType.getSelectedItem().toString(), (DefaultTableModel) allDevisTable.getModel(),
                        getCustomerInfo(codeText.getText()), txtRecu.getText(), txtRendre.getText(), txtTotal.getText(), false,txtbnCmnd.getText());
                
            }

        } catch (DocumentException ex) {
            Logger.getLogger(DataDetail.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ParseException ex) {
            Logger.getLogger(DataDetail.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
        }
    }

    public String getCustomerInfo(String code) {

        return nameText.getText() + " TELEPHONE: " + phoneText.getText();

    }

    void putMoneyInCaisse() {
        if (moneyToCaisse > 0.0) {
            new ProductDAO().putInCaisse(getCureentTime(), moneyToCaisse, this.username);
            moneyToCaisse = 0.0;
        } else {
            JOptionPane.showMessageDialog(null, "il y'as aucun vente dans cette session !");

        }
    }

}
