import java.sql.*;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import java.io.*;
import java.io.FileFilter;
import java.io.FileOutputStream;
import com.itextpdf.text.*;
import com.itextpdf.text.pdf.*;



/**
 *
 * @author Eythan
 */
public class orderForm extends javax.swing.JFrame {

    
    public orderForm() {
        initComponents();
        Connect();
        LoadProductNo();
        Fetch();
        
    }
    
    Connection con;
    PreparedStatement pst;
    ResultSet rs;
    
    public void Connect(){
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost/orderform","root","");
            
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(orderForm.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(orderForm.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private void Fetch(){
        try {
            int q;
            pst = con.prepareStatement("SELECT * FROM order_tbl");
            rs = pst.executeQuery();
            ResultSetMetaData rss = rs.getMetaData();
            q = rss.getColumnCount();
            
            DefaultTableModel df =(DefaultTableModel)jTable1.getModel();
            df.setRowCount(0);
            while(rs.next()){
                Vector v2 = new Vector();
                for(int a =1; a<=q; a++){
                    v2.add(rs.getString("id"));
                    v2.add(rs.getString("pname"));
                    v2.add(rs.getString("address"));
                    v2.add(rs.getString("guitar"));
                    v2.add(rs.getString("price"));
                    v2.add(rs.getString("qty"));
                }
                df.addRow(v2);
            }
        } catch (SQLException ex) {
            Logger.getLogger(orderForm.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void LoadProductNo(){
        
        try {
            pst = con.prepareStatement("Select id FROM order_tbl");
            rs = pst.executeQuery();
            txtpid.removeAllItems();
            while(rs.next()){
               txtpid.addItem(rs.getString(1)); 
            }
        } catch (SQLException ex) {
            Logger.getLogger(orderForm.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
        
  
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        txtPname = new javax.swing.JTextField();
        txtpid = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        btnAdd = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        btnPDF = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        btnExport = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        btnUpdate = new javax.swing.JButton();
        btnSearch = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txtAdd = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        txtPrice = new javax.swing.JTextField();
        txtQty = new javax.swing.JTextField();
        txtGui = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(102, 102, 102));
        setPreferredSize(new java.awt.Dimension(719, 750));

        jLabel1.setBackground(new java.awt.Color(102, 102, 102));
        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel1.setText("Customer Name:");
        jLabel1.setBorder(new javax.swing.border.MatteBorder(null));

        txtPname.setBackground(new java.awt.Color(204, 204, 204));
        txtPname.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        txtPname.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPnameActionPerformed(evt);
            }
        });

        txtpid.setBackground(new java.awt.Color(102, 102, 102));
        txtpid.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        txtpid.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtpidActionPerformed(evt);
            }
        });

        jLabel4.setBackground(new java.awt.Color(102, 102, 102));
        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel4.setText("Order ID:");
        jLabel4.setBorder(new javax.swing.border.MatteBorder(null));

        btnAdd.setBackground(new java.awt.Color(102, 102, 102));
        btnAdd.setText("Add");
        btnAdd.setBorder(new javax.swing.border.MatteBorder(null));
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActionPerformed(evt);
            }
        });

        btnDelete.setBackground(new java.awt.Color(102, 102, 102));
        btnDelete.setText("Delete");
        btnDelete.setBorder(new javax.swing.border.MatteBorder(null));
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });

        btnPDF.setBackground(new java.awt.Color(102, 102, 102));
        btnPDF.setText("Export PDF");
        btnPDF.setBorder(new javax.swing.border.MatteBorder(null));
        btnPDF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPDFActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N

        btnExport.setBackground(new java.awt.Color(102, 102, 102));
        btnExport.setText("Export to CSV");
        btnExport.setBorder(new javax.swing.border.MatteBorder(null));
        btnExport.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExportActionPerformed(evt);
            }
        });

        jTable1.setBackground(new java.awt.Color(102, 102, 102));
        jTable1.setBorder(new javax.swing.border.MatteBorder(null));
        jTable1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Order ID", " Customer Name", "Customer Address", "Guitar Name", "Guitar Price", "Guitar Quantity"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        btnUpdate.setBackground(new java.awt.Color(102, 102, 102));
        btnUpdate.setText("Update");
        btnUpdate.setBorder(new javax.swing.border.MatteBorder(null));
        btnUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 677, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(btnAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(btnExport, javax.swing.GroupLayout.DEFAULT_SIZE, 175, Short.MAX_VALUE)
                                    .addComponent(btnPDF, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))))
                .addGap(0, 24, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(btnPDF, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnExport, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 202, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel6))
        );

        btnSearch.setBackground(new java.awt.Color(102, 102, 102));
        btnSearch.setText("Search");
        btnSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSearchActionPerformed(evt);
            }
        });

        jLabel5.setBackground(new java.awt.Color(102, 102, 102));
        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel5.setText("GUITAR SHOP ORDER FORM");

        jLabel2.setBackground(new java.awt.Color(102, 102, 102));
        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel2.setText("Guitar Price:");
        jLabel2.setBorder(new javax.swing.border.MatteBorder(null));

        jLabel3.setBackground(new java.awt.Color(102, 102, 102));
        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel3.setText("Guitar Qty:");
        jLabel3.setBorder(new javax.swing.border.MatteBorder(null));

        jLabel7.setBackground(new java.awt.Color(102, 102, 102));
        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel7.setText("Customer Address: ");
        jLabel7.setBorder(new javax.swing.border.MatteBorder(null));

        txtAdd.setBackground(new java.awt.Color(204, 204, 204));
        txtAdd.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        txtAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtAddActionPerformed(evt);
            }
        });

        jLabel8.setBackground(new java.awt.Color(102, 102, 102));
        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel8.setText("Guitar Name:");
        jLabel8.setBorder(new javax.swing.border.MatteBorder(null));

        txtPrice.setBackground(new java.awt.Color(204, 204, 204));
        txtPrice.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        txtPrice.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPriceActionPerformed(evt);
            }
        });

        txtQty.setBackground(new java.awt.Color(204, 204, 204));
        txtQty.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        txtQty.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtQtyActionPerformed(evt);
            }
        });

        txtGui.setBackground(new java.awt.Color(204, 204, 204));
        txtGui.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        txtGui.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtGuiActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel2))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 228, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(txtPrice, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel8)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(txtGui, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(txtQty, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel7)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(txtAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(txtPname, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(126, 126, 126)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(jLabel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtpid, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(btnSearch))
                        .addGap(144, 144, 144))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(7, 7, 7)
                .addComponent(jLabel5)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4)
                    .addComponent(txtpid, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtPname, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSearch)
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtAdd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtGui, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtPrice, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtQty, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(414, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void txtPnameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPnameActionPerformed

    }//GEN-LAST:event_txtPnameActionPerformed

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed
        
        if(txtPname.getText().isEmpty()){
          ;
        }else if (txtAdd.getText().isEmpty()){
            JOptionPane.showMessageDialog(this," Address is required ");
        }else if (txtGui.getText().isEmpty()){  JOptionPane.showMessageDialog(this," name is required !!");
            JOptionPane.showMessageDialog(this," Guitar name is required ");
        }else if (txtPrice.getText().isEmpty()){
            JOptionPane.showMessageDialog(this," Guitar Price is required ");
        }else if (txtQty.getText().isEmpty()){
            JOptionPane.showMessageDialog(this," Quantity is required ");
        }else{
        try {
            String pname = txtPname.getText();
            String address = txtAdd.getText();
            String guitar = txtGui.getText();
            String price = txtPrice.getText();
            String qty =  txtQty.getText();
            
            
            pst = con.prepareStatement("INSERT INTO order_tbl (pname,address,guitar,price,qty)VALUES(?,?,?,?,?)");
            pst.setString(1,pname);
            pst.setString(2, address);
            pst.setString(3, guitar);
            pst.setString(4, price);
            pst.setString(5,qty);
            
            int k = pst.executeUpdate();
            
            if (k==1){
                JOptionPane.showMessageDialog(this,"YOUR ORDER  ADDED!! succesfully");
                txtPname.setText("");
                txtAdd.setText("");
                txtGui.setText("");
                txtPrice.setText("");
                txtQty.setText("");
                
                Fetch();
                LoadProductNo();
                
            }else{
                JOptionPane.showMessageDialog(this,"YOUR ORDER IS FAILED TO SUBMIT");
                

            }
        } catch (SQLException ex) {
            Logger.getLogger(orderForm.class.getName()).log(Level.SEVERE, null, ex);
        }
        }
    }//GEN-LAST:event_btnAddActionPerformed

    private void txtpidActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtpidActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtpidActionPerformed

    private void btnSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearchActionPerformed
 
        try {
            String pid = txtpid.getSelectedItem().toString();
            
            pst = con.prepareStatement("SELECT * FROM order_tbl Where id=?");
            pst.setString(1, pid);
            rs=pst.executeQuery();
            if (rs.next() == true){
                txtPname.setText(rs.getString(2));
                txtAdd.setText(rs.getString(3));
                txtGui.setText(rs.getString(4));
                txtPrice.setText(rs.getString(5));
                txtQty.setText(rs.getString(6));   
               
            }else{
                JOptionPane.showMessageDialog(this,"No Record Found");

            }
        } catch (SQLException ex) {
            Logger.getLogger(orderForm.class.getName()).log(Level.SEVERE, null, ex);
        }
            
    }//GEN-LAST:event_btnSearchActionPerformed

    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateActionPerformed
        
        if(txtPname.getText().isEmpty()){
            JOptionPane.showMessageDialog(this,"Customer name is required !!");
        }else if (txtAdd.getText().isEmpty()){
            JOptionPane.showMessageDialog(this,"Address  is required ");
        }else if (txtGui.getText().isEmpty()){
            JOptionPane.showMessageDialog(this,"Guitar Name is required ");
        }else if (txtPrice.getText().isEmpty()){
            JOptionPane.showMessageDialog(this,"Guitar Price is required ");
        }else if (txtQty.getText().isEmpty()){
            JOptionPane.showMessageDialog(this,"Product Quantity is required ");
        }else{
        try {
            
            
            String pname = txtPname.getText();
            String address = txtAdd.getText();
            String guitar = txtGui.getText();
            String price = txtPrice.getText();
            String qty = txtQty.getText();
            String pid = txtpid.getSelectedItem().toString();
            
            pst = con.prepareStatement("UPDATE order_tbl SET pname=?,address=?,guitar=?,price=?,qty=? WHERE id=?");
            
            pst.setString(1,pname);
            pst.setString(2,address);
            pst.setString(3,guitar);
            pst.setString(4,price);
            pst.setString(5, qty);
            pst.setString(6,pid);
            
            int k=pst.executeUpdate();
            
            if (k==1){
                JOptionPane.showMessageDialog(this,"Your Order has been succesfully updated ");
                txtPname.setText("");
                txtAdd.setText("");
                txtGui.setText("");
                txtPrice.setText("");
                txtQty.setText("");
                txtPname.requestFocus();
                Fetch();
                LoadProductNo();
                
            }
        } catch (SQLException ex) {
            Logger.getLogger(orderForm.class.getName()).log(Level.SEVERE, null, ex);
        }
        }
    }//GEN-LAST:event_btnUpdateActionPerformed

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        if(txtPname.getText().isEmpty()){
            JOptionPane.showMessageDialog(this,"Product name is required !!");
        }else if (txtAdd.getText().isEmpty()){
            JOptionPane.showMessageDialog(this,"Address is required ");
        }else if (txtGui.getText().isEmpty()){
            JOptionPane.showMessageDialog(this,"Guitar name is required ");
        }else if (txtPrice.getText().isEmpty()){
            JOptionPane.showMessageDialog(this,"Guitar Price is required ");
        }else if (txtQty.getText().isEmpty()){
            JOptionPane.showMessageDialog(this,"Product Quantity is required ");
        }else{
        try {
          
            String pid = txtpid.getSelectedItem().toString();
            pst = con.prepareStatement("DELETE FROM order_tbl WHERE id=?");
            pst.setString(1,pid);
            
            int k = pst.executeUpdate();
            
            if (k==1){
                 JOptionPane.showMessageDialog(this,"Your Order has been succesfully Deleted ");
                txtPname.setText("");
                txtAdd.setText("");
                txtGui.setText("");
                txtPrice.setText("");
                txtQty.setText("");
                txtPname.requestFocus();
                LoadProductNo();
                Fetch();
                
            }else{
                JOptionPane.showMessageDialog(this,"Record failed to Deleted ");
            }
        } catch (SQLException ex) {
            Logger.getLogger(orderForm.class.getName()).log(Level.SEVERE, null, ex);
        }
        }
        
    }//GEN-LAST:event_btnDeleteActionPerformed

    private void btnExportActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExportActionPerformed
        
        String filename ="C:\\ExportedFileJava.csv";
        try {
           
           FileWriter fw = new FileWriter(filename);
           pst = con.prepareStatement("SELECT * FROM order_tbl");
           rs = pst.executeQuery();
           
           while(rs.next()){
               fw.append(rs.getString(1));
               fw.append(',');
               fw.append(rs.getString(2));
               fw.append(',');
               fw.append(rs.getString(3));
               fw.append(',');
               fw.append(rs.getString(4));
               fw.append(',');
               fw.append(rs.getString(5));
               fw.append(',');
               fw.append(rs.getString(6));
               fw.append('\n');
           }
           JOptionPane.showMessageDialog(this,"Csv file is exported Succesfully!! ");
           fw.flush();
           fw.close();
        } catch (IOException ex) {
            Logger.getLogger(orderForm.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(orderForm.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnExportActionPerformed

    private void btnPDFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPDFActionPerformed
        try {
            
            pst = con.prepareStatement("SELECT * FROM order_tbl");
            rs = pst.executeQuery();
            
            Document PDFreport = new Document();
            PdfWriter.getInstance(PDFreport,new FileOutputStream("C:\\outputReportJava.pdf"));
            
            PDFreport.open();
            
            PdfPTable PDFTable = new PdfPTable(6);
            PdfPCell table_cell;
            
            while(rs.next()){
                
                String pid = rs.getString("id");
                table_cell = new PdfPCell(new Phrase(pid));
                PDFTable.addCell(table_cell);
                
                
                String ppname = rs.getString("pname");
                table_cell = new PdfPCell(new Phrase(ppname));
                PDFTable.addCell(table_cell);
                
                String ppaddress = rs.getString("address");
                table_cell = new PdfPCell(new Phrase(ppaddress));
                PDFTable.addCell(table_cell);
                
                String ppguitar = rs.getString("guitar");
                table_cell = new PdfPCell(new Phrase(ppguitar));
                PDFTable.addCell(table_cell);
                
                
                String pprice = rs.getString("price");
                table_cell = new PdfPCell(new Phrase(pprice));
                PDFTable.addCell(table_cell);
                
                
                String ppqty = rs.getString("qty");
                table_cell = new PdfPCell(new Phrase(ppqty));
                PDFTable.addCell(table_cell);
            }
            JOptionPane.showMessageDialog(this,"PDF file is Exported Succesfully");
            
            PDFreport.add(PDFTable);
            PDFreport.close();
            
        } catch (SQLException ex) {
            Logger.getLogger(orderForm.class.getName()).log(Level.SEVERE, null, ex);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(orderForm.class.getName()).log(Level.SEVERE, null, ex);
        } catch (DocumentException ex) {
            Logger.getLogger(orderForm.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }//GEN-LAST:event_btnPDFActionPerformed

    private void txtAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtAddActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtAddActionPerformed

    private void txtPriceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPriceActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPriceActionPerformed

    private void txtQtyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtQtyActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtQtyActionPerformed

    private void txtGuiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtGuiActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtGuiActionPerformed


    public static void main(String args[]) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(orderForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(orderForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(orderForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(orderForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
       
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new orderForm().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnExport;
    private javax.swing.JButton btnPDF;
    private javax.swing.JButton btnSearch;
    private javax.swing.JButton btnUpdate;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField txtAdd;
    private javax.swing.JTextField txtGui;
    private javax.swing.JTextField txtPname;
    private javax.swing.JTextField txtPrice;
    private javax.swing.JTextField txtQty;
    private javax.swing.JComboBox<String> txtpid;
    // End of variables declaration//GEN-END:variables

    private static class JoptionPane {

        private static void showMessageDialog(orderForm aThis, String record_added_succesfully) {
            throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        }
    }
}

 
