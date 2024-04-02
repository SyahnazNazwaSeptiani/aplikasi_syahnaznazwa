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


/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */

/**
 *
 * @author user
 */
public class menuutama extends javax.swing.JFrame {
Connection konek;
PreparedStatement pst;
ResultSet rst;
    /**
     * Creates new form
     */
    public menuutama() {
        initComponents();
        this.setExtendedState(MAXIMIZED_BOTH);
        konek = Koneksi.KoneksiDB();
        mulai();
        tampilWaktu();
    }

    public void mulai() {
    formlogin.setVisible(false);
    Register.setEnabled(false);
    Logout.setEnabled(false);
    Master.setEnabled(false);
    Transaksi.setEnabled(false);
    Laporan.setEnabled(false);
    txtjam.setEnabled(false);
    txttanggal.setEnabled(false);
    btnregister.setEnabled(false);
    btnproduk.setEnabled(false);
    btnpelanggan.setEnabled(false);
    btnpenjualan.setEnabled(false);
}

    public void tampilWaktu() {
        Thread clock = new Thread() {
            public void run() {
                for(;;) {
                    Calendar cal = Calendar.getInstance();
                    SimpleDateFormat Jam = new SimpleDateFormat("HH:mm:ss");
                    SimpleDateFormat Tanggal = new SimpleDateFormat("yyyy-MM-dd");
                    txtjam.setText(Jam.format(cal.getTime()));
                    txttanggal.setText(Tanggal.format(cal.getTime()));
               try { sleep(1000);
            } catch (InterruptedException ex) {
                Logger.getLogger(menuutama.class.getName()).log(Level.SEVERE, null, ex);
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
        btnregister = new javax.swing.JButton();
        lbluser = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        btnpelanggan = new javax.swing.JButton();
        btnproduk = new javax.swing.JButton();
        btnpenjualan = new javax.swing.JButton();
        formlogin = new javax.swing.JInternalFrame();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtusername = new javax.swing.JTextField();
        cmbhakakses = new javax.swing.JComboBox<>();
        btnbatal = new javax.swing.JButton();
        btnmasuk = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        txtpassword = new javax.swing.JPasswordField();
        txttanggal = new javax.swing.JTextField();
        txtjam = new javax.swing.JTextField();
        jMenuBar1 = new javax.swing.JMenuBar();
        Beranda = new javax.swing.JMenu();
        login = new javax.swing.JMenuItem();
        Register = new javax.swing.JMenuItem();
        Logout = new javax.swing.JMenuItem();
        Master = new javax.swing.JMenu();
        Pelanggan = new javax.swing.JMenuItem();
        Produk = new javax.swing.JMenuItem();
        Transaksi = new javax.swing.JMenu();
        Penjualan = new javax.swing.JMenuItem();
        Laporan = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        Help = new javax.swing.JMenu();
        Tentang = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(0, 102, 102));

        btnregister.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/icons8-register-20.png"))); // NOI18N
        btnregister.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnregisterActionPerformed(evt);
            }
        });

        lbluser.setBackground(new java.awt.Color(0, 0, 0));
        lbluser.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        lbluser.setForeground(new java.awt.Color(255, 255, 255));
        lbluser.setText("Silahkan Masuk Dulu...!");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbluser)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(btnregister)
                        .addGap(56, 56, 56)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(lbluser)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 395, Short.MAX_VALUE)
                .addComponent(btnregister)
                .addGap(50, 50, 50))
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, 510));

        jPanel2.setBackground(new java.awt.Color(0, 102, 102));

        btnpelanggan.setFont(new java.awt.Font("MV Boli", 1, 12)); // NOI18N
        btnpelanggan.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/icons8-customer-20.png"))); // NOI18N
        btnpelanggan.setText("Pelanggan");
        btnpelanggan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnpelangganActionPerformed(evt);
            }
        });

        btnproduk.setFont(new java.awt.Font("MV Boli", 1, 12)); // NOI18N
        btnproduk.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/icons8-product-20.png"))); // NOI18N
        btnproduk.setText("Produk");
        btnproduk.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnprodukActionPerformed(evt);
            }
        });

        btnpenjualan.setFont(new java.awt.Font("MV Boli", 1, 12)); // NOI18N
        btnpenjualan.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/icons8-sale-20.png"))); // NOI18N
        btnpenjualan.setText("Penjualan");
        btnpenjualan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnpenjualanActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(91, 91, 91)
                .addComponent(btnpelanggan)
                .addGap(45, 45, 45)
                .addComponent(btnproduk)
                .addGap(59, 59, 59)
                .addComponent(btnpenjualan)
                .addContainerGap(48, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnpelanggan)
                    .addComponent(btnproduk)
                    .addComponent(btnpenjualan))
                .addContainerGap(50, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 406, 560, 100));

        formlogin.setVisible(true);

        jLabel1.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel1.setText("Username");

        jLabel2.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel2.setText("Password");

        jLabel3.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel3.setText("Hak Akses");

        cmbhakakses.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "-pilih salah satu-", "Admin", "Petugas" }));
        cmbhakakses.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbhakaksesActionPerformed(evt);
            }
        });

        btnbatal.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        btnbatal.setText("BATAL");
        btnbatal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnbatalActionPerformed(evt);
            }
        });

        btnmasuk.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        btnmasuk.setText("MASUK");
        btnmasuk.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnmasukActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel4.setText("Form Login");

        javax.swing.GroupLayout formloginLayout = new javax.swing.GroupLayout(formlogin.getContentPane());
        formlogin.getContentPane().setLayout(formloginLayout);
        formloginLayout.setHorizontalGroup(
            formloginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(formloginLayout.createSequentialGroup()
                .addGroup(formloginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(formloginLayout.createSequentialGroup()
                        .addGap(140, 140, 140)
                        .addComponent(jLabel4))
                    .addGroup(formloginLayout.createSequentialGroup()
                        .addGap(124, 124, 124)
                        .addGroup(formloginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cmbhakakses, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtpassword, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(84, Short.MAX_VALUE))
            .addGroup(formloginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(formloginLayout.createSequentialGroup()
                    .addGap(20, 20, 20)
                    .addGroup(formloginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(formloginLayout.createSequentialGroup()
                            .addComponent(jLabel1)
                            .addGap(30, 30, 30)
                            .addComponent(txtusername, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(jLabel2)
                        .addComponent(jLabel3)
                        .addGroup(formloginLayout.createSequentialGroup()
                            .addGap(38, 38, 38)
                            .addComponent(btnbatal)
                            .addGap(56, 56, 56)
                            .addComponent(btnmasuk)))
                    .addContainerGap(80, Short.MAX_VALUE)))
        );
        formloginLayout.setVerticalGroup(
            formloginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(formloginLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel4)
                .addGap(56, 56, 56)
                .addComponent(txtpassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(cmbhakakses, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(102, Short.MAX_VALUE))
            .addGroup(formloginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(formloginLayout.createSequentialGroup()
                    .addGap(31, 31, 31)
                    .addGroup(formloginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(formloginLayout.createSequentialGroup()
                            .addGap(1, 1, 1)
                            .addComponent(jLabel1))
                        .addComponent(txtusername, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGap(17, 17, 17)
                    .addComponent(jLabel2)
                    .addGap(30, 30, 30)
                    .addComponent(jLabel3)
                    .addGap(48, 48, 48)
                    .addGroup(formloginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(btnbatal)
                        .addComponent(btnmasuk))
                    .addContainerGap(35, Short.MAX_VALUE)))
        );

        getContentPane().add(formlogin, new org.netbeans.lib.awtextra.AbsoluteConstraints(237, 86, -1, -1));
        getContentPane().add(txttanggal, new org.netbeans.lib.awtextra.AbsoluteConstraints(441, 26, 113, -1));
        getContentPane().add(txtjam, new org.netbeans.lib.awtextra.AbsoluteConstraints(587, 26, 113, -1));

        Beranda.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/icons8-home-20.png"))); // NOI18N
        Beranda.setText("Beranda");
        Beranda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BerandaActionPerformed(evt);
            }
        });

        login.setText("Login");
        login.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                loginActionPerformed(evt);
            }
        });
        Beranda.add(login);

        Register.setText("Register");
        Register.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RegisterActionPerformed(evt);
            }
        });
        Beranda.add(Register);

        Logout.setText("Logout");
        Logout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LogoutActionPerformed(evt);
            }
        });
        Beranda.add(Logout);

        jMenuBar1.add(Beranda);

        Master.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/icons8-master-20.png"))); // NOI18N
        Master.setText("Master");
        Master.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MasterActionPerformed(evt);
            }
        });

        Pelanggan.setText("Pelanggan");
        Pelanggan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PelangganActionPerformed(evt);
            }
        });
        Master.add(Pelanggan);

        Produk.setText("Produk");
        Produk.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ProdukActionPerformed(evt);
            }
        });
        Master.add(Produk);

        jMenuBar1.add(Master);

        Transaksi.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/icons8-transaction-20.png"))); // NOI18N
        Transaksi.setText("Transaksi");

        Penjualan.setText("Penjualan");
        Penjualan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PenjualanActionPerformed(evt);
            }
        });
        Transaksi.add(Penjualan);

        jMenuBar1.add(Transaksi);

        Laporan.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/icons8-list-20.png"))); // NOI18N
        Laporan.setText("Laporan");
        Laporan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LaporanActionPerformed(evt);
            }
        });

        jMenuItem1.setText("recap laporan");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        Laporan.add(jMenuItem1);

        jMenuBar1.add(Laporan);

        Help.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/icons8-help-20.png"))); // NOI18N
        Help.setText("Help");
        Help.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                HelpActionPerformed(evt);
            }
        });

        Tentang.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/icons8-about-20.png"))); // NOI18N
        Tentang.setText("Tentang");
        Tentang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TentangActionPerformed(evt);
            }
        });
        Help.add(Tentang);

        jMenuBar1.add(Help);

        setJMenuBar(jMenuBar1);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void loginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_loginActionPerformed
        formlogin.setVisible(true);        // TODO add your handling code here:
    }//GEN-LAST:event_loginActionPerformed

    private void RegisterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RegisterActionPerformed
        new formregister().setVisible(true); // TODO add your handling code here:
    }//GEN-LAST:event_RegisterActionPerformed

    private void LogoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LogoutActionPerformed
        new menuutama().setVisible(true);        // TODO add your handling code here:
    }//GEN-LAST:event_LogoutActionPerformed

    private void BerandaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BerandaActionPerformed
        formlogin.setVisible(true);        // TODO add your handling code here:
    }//GEN-LAST:event_BerandaActionPerformed

    private void PelangganActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PelangganActionPerformed
        new formpelanggan().setVisible(true);        // TODO add your handling code here:
    }//GEN-LAST:event_PelangganActionPerformed

    private void ProdukActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ProdukActionPerformed
        new formproduk().setVisible(true);        // TODO add your handling code here:
    }//GEN-LAST:event_ProdukActionPerformed

    private void PenjualanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PenjualanActionPerformed
        new formpenjual().setVisible(true);
        // TODO add your handling code here:
    }//GEN-LAST:event_PenjualanActionPerformed

    private void btnregisterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnregisterActionPerformed
        new formregister().setVisible(true);        // TODO add your handling code here:
    }//GEN-LAST:event_btnregisterActionPerformed

    private void btnpelangganActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnpelangganActionPerformed
        new formpelanggan().setVisible(true);        // TODO add your handling code here:
    }//GEN-LAST:event_btnpelangganActionPerformed

    private void btnprodukActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnprodukActionPerformed
        new formproduk().setVisible(true);        // TODO add your handling code here:
    }//GEN-LAST:event_btnprodukActionPerformed

    private void cmbhakaksesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbhakaksesActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmbhakaksesActionPerformed

    private void btnbatalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnbatalActionPerformed

    }//GEN-LAST:event_btnbatalActionPerformed

    private void btnmasukActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnmasukActionPerformed
        try {
            String sql="select * from login where Username='"+txtusername.getText()+"' and Password='"+txtpassword.getText()+"' and HakAkses='"+cmbhakakses.getSelectedItem()+"'";
            pst = konek.prepareStatement(sql);
            rst = pst.executeQuery();
            if (rst.next()) {
                if(txtusername.getText().equals(rst.getString("Username"))&& txtpassword.getText().equals(rst.getString("Password"))&& cmbhakakses.getSelectedItem().equals(rst.getString("HakAkses")))
                if(cmbhakakses.getSelectedItem().equals("Admin")){
                    Register.setEnabled(true);
                    Logout.setEnabled(true);
                    Master.setEnabled(true);
                    Produk.setEnabled(true);
                    Pelanggan.setEnabled(true);
                    Transaksi.setEnabled(true);
                    Penjualan.setEnabled(true);
                    Laporan.setEnabled(true);
                    formlogin.setVisible(false);
                    btnregister.setEnabled(true);
                    btnproduk.setEnabled(true);
                    btnpelanggan.setEnabled(true);
                    btnpenjualan.setEnabled(true);
                    txtjam.setEnabled(false);
                    txttanggal.setEnabled(false);
                } else if(cmbhakakses.getSelectedItem().equals("Petugas")){
                    Register.setEnabled(false);
                    Logout.setEnabled(true);
                    Master.setEnabled(true);
                    Produk.setEnabled(true);
                    Pelanggan.setEnabled(true);
                    Transaksi.setEnabled(true);
                    Penjualan.setEnabled(true);
                    Laporan.setEnabled(true);
                    formlogin.setVisible(false);
                    btnregister.setEnabled(false);
                    btnproduk.setEnabled(true);
                    btnpelanggan.setEnabled(true);
                    btnpenjualan.setEnabled(true);
                    txtjam.setEnabled(false);
                    txttanggal.setEnabled(false);
                }
                {
                    JOptionPane.showMessageDialog(null, "Selamat Datang '"+txtusername.getText()+"'");
                    String text = txtusername.getText();
                    lbluser.setText(text);
                }
            } else {
                JOptionPane.showMessageDialog(null, "Gagal Login. Periksa kembali Username, Password dan Hak Akses");
                txtusername.setText("");
                txtpassword.setText("");
                cmbhakakses.setSelectedItem("-Pilih Salah Satu-");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
        // TODO add your handling code here:
    }//GEN-LAST:event_btnmasukActionPerformed

    private void MasterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MasterActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_MasterActionPerformed

    private void LaporanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LaporanActionPerformed
 new formlaptransaksi().setVisible(true);          // TODO add your handling code here:
    }//GEN-LAST:event_LaporanActionPerformed

    private void HelpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_HelpActionPerformed
 new formabout().setVisible(true);          // TODO add your handling code here:
    }//GEN-LAST:event_HelpActionPerformed

    private void TentangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TentangActionPerformed
new formabout().setVisible(true);      // TODO add your handling code here:
    }//GEN-LAST:event_TentangActionPerformed

    private void btnpenjualanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnpenjualanActionPerformed
        new formpenjual().setVisible(true);        // TODO add your handling code here:
    }//GEN-LAST:event_btnpenjualanActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
new formlaptransaksi().setVisible(true);        // TODO add your handling code here:
    }//GEN-LAST:event_jMenuItem1ActionPerformed

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
            java.util.logging.Logger.getLogger(menuutama.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(menuutama.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(menuutama.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(menuutama.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new menuutama().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenu Beranda;
    private javax.swing.JMenu Help;
    private javax.swing.JMenu Laporan;
    private javax.swing.JMenuItem Logout;
    private javax.swing.JMenu Master;
    private javax.swing.JMenuItem Pelanggan;
    private javax.swing.JMenuItem Penjualan;
    private javax.swing.JMenuItem Produk;
    private javax.swing.JMenuItem Register;
    private javax.swing.JMenuItem Tentang;
    private javax.swing.JMenu Transaksi;
    private javax.swing.JButton btnbatal;
    private javax.swing.JButton btnmasuk;
    private javax.swing.JButton btnpelanggan;
    private javax.swing.JButton btnpenjualan;
    private javax.swing.JButton btnproduk;
    private javax.swing.JButton btnregister;
    private javax.swing.JComboBox<String> cmbhakakses;
    private javax.swing.JInternalFrame formlogin;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JLabel lbluser;
    private javax.swing.JMenuItem login;
    private javax.swing.JTextField txtjam;
    private javax.swing.JPasswordField txtpassword;
    private javax.swing.JTextField txttanggal;
    private javax.swing.JTextField txtusername;
    // End of variables declaration//GEN-END:variables
}
