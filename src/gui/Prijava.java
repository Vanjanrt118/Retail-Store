
package gui;

import gui.AdministratorForma;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import javax.swing.*;
import projekat.Administrator;
import projekat.Kupac;
import projekat.RadSaDatotekom;

public class Prijava extends javax.swing.JFrame {
    public Prijava() { 
        initComponents();
    }
   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnUlogujSe = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtKorIme = new javax.swing.JTextField();
        rdbtnAdmin = new javax.swing.JRadioButton();
        rdbtnKupac = new javax.swing.JRadioButton();
        txtLozinka = new javax.swing.JPasswordField();

        btnUlogujSe.setText("Uloguj se");
        btnUlogujSe.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUlogujSeActionPerformed(evt);
            }
        });

        jLabel1.setText("Username");

        jLabel2.setText("Passwod");

        rdbtnAdmin.setText("Administrator");

        rdbtnKupac.setText("Kupac");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2))
                        .addGap(121, 121, 121)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtKorIme, javax.swing.GroupLayout.DEFAULT_SIZE, 137, Short.MAX_VALUE)
                            .addComponent(txtLozinka)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(rdbtnAdmin)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 195, Short.MAX_VALUE)
                        .addComponent(rdbtnKupac)))
                .addGap(33, 33, 33))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnUlogujSe, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(147, 147, 147))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtKorIme, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel2)
                    .addComponent(txtLozinka, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(47, 47, 47)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rdbtnAdmin)
                    .addComponent(rdbtnKupac))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnUlogujSe, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(37, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnUlogujSeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUlogujSeActionPerformed
        Kupac kupac=new Kupac();
        RadSaDatotekom rad=new RadSaDatotekom();
        Administrator admin=new Administrator();
        try{
        if(!rdbtnKupac.isSelected()&&!rdbtnAdmin.isSelected()||rdbtnKupac.isSelected()&&rdbtnAdmin.isSelected()) JOptionPane.showMessageDialog(this,"Morate odabrati jednu vrednost!");
        else{
            if(rdbtnKupac.isSelected()){
                if(txtKorIme.getText().isEmpty()|| String.valueOf(txtLozinka.getPassword()).isEmpty())
                    JOptionPane.showMessageDialog(this,"Morate popuniti sva polja!");
                else  if( rad.pretragaKupca(txtKorIme.getText(), String.valueOf(txtLozinka.getPassword()))==true){  
                    Kupac k=Kupac.vratiKupca(txtKorIme.getText(), String.valueOf(txtLozinka.getPassword()));
                    JOptionPane.showMessageDialog(this,"Prijava uspesna!");
                    new KorisnikForma(k).setVisible(rootPaneCheckingEnabled);        
                }
                else  if(rad.pretragaKupca(txtKorIme.getText(), String.valueOf(txtLozinka.getPassword()))==false) JOptionPane.showMessageDialog(this,"Pogresni podaci!");
            }
            else if(rdbtnAdmin.isSelected()){
                if(txtKorIme.getText().isEmpty()|| String.valueOf(txtLozinka.getPassword()).isEmpty())
                    JOptionPane.showMessageDialog(this,"Morate popuniti sva polja!");
                else  if(rad.pretragaAdministratora(txtKorIme.getText(), String.valueOf(txtLozinka.getPassword()))==true){  
                    JOptionPane.showMessageDialog(this,"Prijava uspesna!"); 
                    new AdministratorForma().setVisible(rootPaneCheckingEnabled);
                }
                else  if(rad.pretragaAdministratora(txtKorIme.getText(), String.valueOf(txtLozinka.getPassword()))==false) JOptionPane.showMessageDialog(this,"Pogresni podaci!");
            }
        }
        }
         catch(FileNotFoundException e){ JOptionPane.showMessageDialog(this,e);}
         catch(IOException e){ JOptionPane.showMessageDialog(this,e);}
    }//GEN-LAST:event_btnUlogujSeActionPerformed

    
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
            java.util.logging.Logger.getLogger(Prijava.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Prijava.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Prijava.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Prijava.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Prijava().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnUlogujSe;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JRadioButton rdbtnAdmin;
    private javax.swing.JRadioButton rdbtnKupac;
    private javax.swing.JTextField txtKorIme;
    private javax.swing.JPasswordField txtLozinka;
    // End of variables declaration//GEN-END:variables
}
