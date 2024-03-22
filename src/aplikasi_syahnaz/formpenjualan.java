/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package aplikasi_syahnaz;
import static java.lang.Thread.sleep;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import net.proteanit.sql.DbUtils;
import java.util.Date;
/**
 *
 * @author user
 */
public class formpenjualan extends javax.swing.JFrame {
Connection konek;
PreparedStatement pst, pst2;
ResultSet rst;
int inputstok, inputstok2, inputharga, inputjumlah, kurangistok, tambahstok;
String harga, idproduk, idprodukpenjualan, iddetail, jam, tanggal, sub_total;
    /**
     * Creates new form
     */
    public formpenjualan() {
        initComponents();
        konek = Koneksi.KoneksiDB();
        this.setLocationRelativeTo(null);
        tampilJam();
        autonumber();
        penjumlahan();
    }

    private void simpan(){
        String tgl=txttanggal1.getText();
        String jam=txtjam.getText();
      try {
            String sql="insert into penjualan (PenjualanID,DetailID,TanggalPenjualan,JamPenjualan,TotalHarga) value (?,?,?,?,?)";
            pst=konek.prepareStatement(sql);
            pst.setString(1, txtnamabarang1.getText());
            pst.setString(2, iddetail);
            pst.setString(3, tgl);
            pst.setString(4, jam);
            pst.setString(5, txttotal1.getText());
            pst.execute();
            JOptionPane.showMessageDialog(null, "Data Tersimpan");
        } catch (Exception e){
            JOptionPane.showMessageDialog(null, e);
            }
    }
    
    private void total(){
    int total, bayar, kembali;
        total= Integer.parseInt(txtbayar1.getText());
        bayar= Integer.parseInt(txttotal1.getText());
        kembali=total-bayar;
        String ssub=String.valueOf(kembali);
        txtkembalian1.setText(ssub);
    }
    
    public void clsr(){
    txtjumlah1.setText("");
    }
    
    public void cari(){
    try {
        String sql="select * from produk where ProdukID LIKE '%"+txtnamabarang1.getText()+"%'";
        pst=konek.prepareStatement(sql);
        rst=pst.executeQuery();
        tblbarang1.setModel(DbUtils.resultSetToTableModel(rst));
       } catch (Exception e){ JOptionPane.showMessageDialog(null, e);} 
    }
    
    public void kurangi_stok(){
    int qty;
    qty=Integer.parseInt(txtjumlah1.getText());
    kurangistok=inputstok-qty;
    }
    
    private void subtotal(){
    int jumlah, sub;
         jumlah= Integer.parseInt(txtjumlah1.getText());
         sub=(jumlah*inputharga);
         sub_total=String.valueOf(sub);     
    }
    
    public void tambah_stok(){
    tambahstok=inputjumlah+inputstok2;
        try {
        String update="update produk set Stok='"+tambahstok+"' where ProdukID='"+idproduk+"'";
        pst2=konek.prepareStatement(update);
        pst2.execute();
        }catch (Exception e){
            JOptionPane.showMessageDialog(null, e);}
    }
    
    public void ambil_stock(){
    try {
    String sql="select * from produk where ProdukID='"+idproduk+"'";
    pst=konek.prepareStatement(sql);
    rst=pst.executeQuery();
    if (rst.next()) {    
    String stok=rst.getString(("Stok"));
    inputstok2= Integer.parseInt(stok);
    }
    }catch (Exception e) {
    JOptionPane.showMessageDialog(null, e);}
    }
    
    public void penjumlahan(){
        int totalBiaya = 0;
        int subtotal;
        DefaultTableModel dataModel = (DefaultTableModel) tbltransaksi1.getModel();
        int jumlah = tbltransaksi1.getRowCount();
        for (int i=0; i<jumlah; i++){
        subtotal = Integer.parseInt(dataModel.getValueAt(i, 4).toString());
        totalBiaya += subtotal;
        }
        txttotal1.setText(String.valueOf(totalBiaya));
    }
    
    public void autonumber(){
    try{
        String sql = "SELECT MAX(RIGHT(PenjualanID,3)) AS NO FROM penjualan";
        pst=konek.prepareStatement(sql);
        rst=pst.executeQuery();
        while (rst.next()) {
                if (rst.first() == false) {
                    txtnamabarang1.setText("IDP001");
                } else {
                    rst.last();
                    int auto_id = rst.getInt(1) + 1;
                    String no = String.valueOf(auto_id);
                    int NomorJual = no.length();
                    for (int j = 0; j < 3 - NomorJual; j++) {
                        no = "0" + no;
                    }
                    txtnamabarang1.setText("IDP" + no);
                }
            }
        rst.close();
        }catch (Exception e){
            JOptionPane.showMessageDialog(null, e);}
    }
    
    public void detail(){
    try {
        String Kode_detail=txtkodetransaksi1.getText();
        String KD="D"+Kode_detail;
        String sql="select * from detailpenjualan where DetailID='"+KD+"'";
        pst=konek.prepareStatement(sql);
        rst=pst.executeQuery();
        tbltransaksi1.setModel(DbUtils.resultSetToTableModel(rst));
       } catch (Exception e){ 
           JOptionPane.showMessageDialog(null, e);} 
    }
    
    public void tampilJam(){
    Thread clock=new Thread(){
        public void run(){
            for(;;){
                Calendar cal=Calendar.getInstance();
                SimpleDateFormat format=new SimpleDateFormat("HH:mm:ss");
                SimpleDateFormat format2=new SimpleDateFormat("yyyy-MM-dd");
                txtjam.setText(format.format(cal.getTime()));
                txttanggal1.setText(format2.format(cal.getTime()));
                
            try { sleep(1000);
            } catch (InterruptedException ex) {
                Logger.getLogger(formpenjualan.class.getName()).log(Level.SEVERE, null, ex);
            }
          }
        }
      };
    clock.start();
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txtnamabarang1 = new javax.swing.JTextField();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txttotal1 = new javax.swing.JTextField();
        txtjumlah1 = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        txtdiskon1 = new javax.swing.JTextField();
        txtbayar1 = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        txtkembalian1 = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        txtkodetransaksi1 = new javax.swing.JTextField();
        jButton6 = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblbarang1 = new javax.swing.JTable();
        jLabel17 = new javax.swing.JLabel();
        btnkeluar1 = new javax.swing.JButton();
        jScrollPane4 = new javax.swing.JScrollPane();
        tbltransaksi1 = new javax.swing.JTable();
        btntambah1 = new javax.swing.JButton();
        txtjam = new javax.swing.JTextField();
        txttanggal1 = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(0, 102, 102));

        jLabel1.setFont(new java.awt.Font("Book Antiqua", 3, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("TRANSAKSI PENJUALAN");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(248, 248, 248)
                .addComponent(jLabel1)
                .addContainerGap(304, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(jLabel1)
                .addContainerGap(39, Short.MAX_VALUE))
        );

        txtnamabarang1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtnamabarang1ActionPerformed(evt);
            }
        });

        jButton4.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/icons8-search-20.png"))); // NOI18N
        jButton4.setText("cari");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jButton5.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jButton5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/icons8-delete-20 (1).png"))); // NOI18N
        jButton5.setText("hapus");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel5.setText("jumlah");

        jLabel12.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel12.setText("total ");

        jLabel6.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel6.setText("diskon");

        jLabel13.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel13.setText("Bayar");

        txtbayar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtbayar1ActionPerformed(evt);
            }
        });

        jLabel14.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel14.setText("Kembalian");

        jLabel15.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel15.setText("Kode Transaksi");

        txtkembalian1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtkembalian1ActionPerformed(evt);
            }
        });

        jLabel16.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel16.setText("Masukan Nama Barang");

        jButton6.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jButton6.setText("Bayar");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        tblbarang1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tblbarang1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblbarang1MouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tblbarang1);

        jLabel17.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel17.setText("data transaksi");

        btnkeluar1.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        btnkeluar1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/icons8-exit-20.png"))); // NOI18N
        btnkeluar1.setText("keluar");
        btnkeluar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnkeluar1ActionPerformed(evt);
            }
        });

        tbltransaksi1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tbltransaksi1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbltransaksi1MouseClicked(evt);
            }
        });
        jScrollPane4.setViewportView(tbltransaksi1);

        btntambah1.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        btntambah1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/icons8-plus-20 (1).png"))); // NOI18N
        btntambah1.setText("TAMBAH");
        btntambah1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btntambah1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel16)
                                .addComponent(txtnamabarang1, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGap(36, 36, 36)
                            .addComponent(jButton4)
                            .addGap(143, 143, 143)
                            .addComponent(txttanggal1, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(79, 79, 79)
                            .addComponent(txtjam, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 414, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(31, 31, 31)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createSequentialGroup()
                                    .addGap(39, 39, 39)
                                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addComponent(txtjumlah1, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(layout.createSequentialGroup()
                                    .addGap(126, 126, 126)
                                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGap(19, 19, 19)
                            .addComponent(btntambah1))
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(jLabel15)
                            .addGap(18, 18, 18)
                            .addComponent(txtkodetransaksi1, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(287, 287, 287)
                            .addComponent(txtdiskon1, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(jLabel17)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 414, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jButton5)
                                .addGroup(layout.createSequentialGroup()
                                    .addGap(34, 34, 34)
                                    .addComponent(jButton6))))
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(jLabel12)
                            .addGap(26, 26, 26)
                            .addComponent(txttotal1, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(60, 60, 60)
                            .addComponent(jLabel14)
                            .addGap(6, 6, 6)
                            .addComponent(txtkembalian1, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(77, 77, 77)
                            .addComponent(btnkeluar1, javax.swing.GroupLayout.PREFERRED_SIZE, 234, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(jLabel13)
                            .addGap(18, 18, 18)
                            .addComponent(txtbayar1, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGap(0, 54, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 475, Short.MAX_VALUE))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 118, Short.MAX_VALUE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(jLabel16)
                            .addGap(6, 6, 6)
                            .addComponent(txtnamabarang1, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(jButton4)
                        .addGroup(layout.createSequentialGroup()
                            .addGap(5, 5, 5)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(txttanggal1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(txtjam, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGap(18, 18, 18)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(jLabel5)
                            .addGap(18, 18, 18)
                            .addComponent(txtjumlah1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(29, 29, 29)
                            .addComponent(jLabel6))
                        .addGroup(layout.createSequentialGroup()
                            .addGap(13, 13, 13)
                            .addComponent(btntambah1)))
                    .addGap(5, 5, 5)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                            .addGap(3, 3, 3)
                            .addComponent(jLabel15))
                        .addComponent(txtkodetransaksi1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(layout.createSequentialGroup()
                            .addGap(21, 21, 21)
                            .addComponent(txtdiskon1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGap(5, 5, 5)
                    .addComponent(jLabel17)
                    .addGap(12, 12, 12)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(jButton5)
                            .addGap(39, 39, 39)
                            .addComponent(jButton6)))
                    .addGap(7, 7, 7)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                            .addGap(25, 25, 25)
                            .addComponent(jLabel12))
                        .addGroup(layout.createSequentialGroup()
                            .addGap(19, 19, 19)
                            .addComponent(txttotal1, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createSequentialGroup()
                            .addGap(3, 3, 3)
                            .addComponent(jLabel14))
                        .addComponent(txtkembalian1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(layout.createSequentialGroup()
                            .addGap(10, 10, 10)
                            .addComponent(btnkeluar1)))
                    .addGap(26, 26, 26)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                            .addGap(3, 3, 3)
                            .addComponent(jLabel13))
                        .addComponent(txtbayar1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGap(0, 13, Short.MAX_VALUE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtnamabarang1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtnamabarang1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtnamabarang1ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        cari();        // TODO add your handling code here:
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        try {
            String sql="delete from detailpenjualan where ProdukID=?";
            pst=konek.prepareStatement(sql);
            pst.setString(1, idprodukpenjualan);
            pst.execute();
        }catch (Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
        detail();
        penjumlahan();
        tambah_stok();
        cari();              // TODO add your handling code here:
    }//GEN-LAST:event_jButton5ActionPerformed

    private void txtbayar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtbayar1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtbayar1ActionPerformed

    private void txtkembalian1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtkembalian1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtkembalian1ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        total();
        simpan();
        autonumber();
        detail();
        txttotal1.setText("");
        txtbayar1.setText("");
        txtkembalian1.setText("");
        txtnamabarang1.setText("");
        cari();

        // TODO add your handling code here:
    }//GEN-LAST:event_jButton6ActionPerformed

    private void tblbarang1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblbarang1MouseClicked
        try {
            int row=tblbarang1.getSelectedRow();
            String tabel_klik=(tblbarang1.getModel().getValueAt(row, 0).toString());
            String sql="select * from produk where ProdukID='"+tabel_klik+"'";
            pst=konek.prepareStatement(sql);
            rst=pst.executeQuery();
            if (rst.next()) {
                idproduk=rst.getString(("ProdukID"));
                String stok=rst.getString(("Stok"));
                inputstok= Integer.parseInt(stok);
                harga=rst.getString(("Harga"));
                inputharga= Integer.parseInt(harga);
            }
        }catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }                // TODO add your handling code here:
    }//GEN-LAST:event_tblbarang1MouseClicked

    private void btnkeluar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnkeluar1ActionPerformed
        this.dispose();        new menuutama().setVisible(true);
        this.dispose();
        // TODO add your handling code here:
    }//GEN-LAST:event_btnkeluar1ActionPerformed

    private void tbltransaksi1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbltransaksi1MouseClicked
        try {
            int row=tbltransaksi1.getSelectedRow();
            idprodukpenjualan=(tbltransaksi1.getModel().getValueAt(row, 1).toString());
            String sql="select * from detailpenjualan where ProdukID='"+idprodukpenjualan+"'";
            pst=konek.prepareStatement(sql);
            rst=pst.executeQuery();
            if (rst.next()) {
                String jumlah=rst.getString(("JumlahProduk"));
                inputjumlah= Integer.parseInt(jumlah);
            }
        }catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
        ambil_stock();              // TODO add your handling code here:
    }//GEN-LAST:event_tbltransaksi1MouseClicked

    private void btntambah1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btntambah1ActionPerformed
        subtotal();
        kurangi_stok();
        try {
            String Kode_detail=txtnamabarang1.getText();
            iddetail="D"+Kode_detail;
            String sql="insert into detailpenjualan (DetailID,ProdukID,Harga,JumlahProduk,Subtotal) value (?,?,?,?,?)";
            String update="update produk set Stok='"+kurangistok+"' where ProdukID='"+idproduk+"'";
            pst=konek.prepareStatement(sql);
            pst2=konek.prepareStatement(update);
            pst.setString(1, iddetail);
            pst.setString(2, idproduk);
            pst.setString(3, harga);
            pst.setString(4, txtjumlah1.getText());
            pst.setString(5, sub_total);
            pst.execute();
            pst2.execute();
        } catch (Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
        detail();
        penjumlahan();
        cari();
        clsr();

        // TODO add your handling code here:
    }//GEN-LAST:event_btntambah1ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(formpenjualan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(formpenjualan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(formpenjualan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(formpenjualan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new formpenjualan().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnkeluar1;
    private javax.swing.JButton btntambah1;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTable tblbarang1;
    private javax.swing.JTable tbltransaksi1;
    private javax.swing.JTextField txtbayar1;
    private javax.swing.JTextField txtdiskon1;
    private javax.swing.JTextField txtjam;
    private javax.swing.JTextField txtjumlah1;
    private javax.swing.JTextField txtkembalian1;
    private javax.swing.JTextField txtkodetransaksi1;
    private javax.swing.JTextField txtnamabarang1;
    private javax.swing.JTextField txttanggal1;
    private javax.swing.JTextField txttotal1;
    // End of variables declaration//GEN-END:variables
}
