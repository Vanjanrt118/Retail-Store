
package gui;

import gui.RacunForma;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import javax.swing.*;
import projekat.Kategorija;
import projekat.Kupac;
import projekat.Proizvod;
import projekat.Racun;
import projekat.*;
public class KorisnikForma extends javax.swing.JFrame {
    Kupac kupac=null;
    DefaultListModel df=new DefaultListModel();
    DefaultListModel df2=new DefaultListModel();
    ArrayList <Proizvod> proizvodi;
    RadSaDatotekom rad=new RadSaDatotekom();
    public KorisnikForma() {
        initComponents();
        lstbxProizvodi.setModel(df);
        lstbxProizvodi1.setModel(df2);
        df.clear();
        df2.clear();
    }
    public KorisnikForma(Kupac k) {
        initComponents();
        lstbxProizvodi.setModel(df);
        lstbxProizvodi1.setModel(df2);
        df.clear();
        df2.clear();
        podaciKupca(k);       
    }
    public void podaciKupca(Kupac k){
        kupac=k;
    }
    

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jToggleButton1 = new javax.swing.JToggleButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        lstbxProizvodi = new javax.swing.JList<>();
        btnPrikazi = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        lstbxProizvodi1 = new javax.swing.JList<>();
        btmDodaj = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        txtUkupno = new javax.swing.JTextField();
        txtTrazi = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        btnTrazi = new javax.swing.JButton();
        btnZavrsi = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        txtKategorija = new javax.swing.JTextField();
        btnTrazi1 = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        btnIzbaci = new javax.swing.JButton();

        jToggleButton1.setText("jToggleButton1");

        lstbxProizvodi.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jScrollPane1.setViewportView(lstbxProizvodi);

        btnPrikazi.setText("Prikazi sve proizvode");
        btnPrikazi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPrikaziActionPerformed(evt);
            }
        });

        lstbxProizvodi1.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jScrollPane2.setViewportView(lstbxProizvodi1);

        btmDodaj.setText("Dodaj u korpu");
        btmDodaj.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btmDodajActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel1.setText("Ukupno:");

        jLabel2.setText("Pretrazi proizvod:");

        btnTrazi.setText("?");
        btnTrazi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTraziActionPerformed(evt);
            }
        });

        btnZavrsi.setText("Zavrsi kupovinu");
        btnZavrsi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnZavrsiActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel3.setText("Korpa");

        btnTrazi1.setText("?");
        btnTrazi1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTrazi1ActionPerformed(evt);
            }
        });

        jLabel4.setText("Pretrazi kategoriju:");

        btnIzbaci.setText("Izbaci");
        btnIzbaci.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnIzbaciActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(51, 51, 51)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 186, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel4))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtKategorija, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(txtTrazi, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 103, Short.MAX_VALUE))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnTrazi1, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel3)
                                .addGap(171, 171, 171))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(btnTrazi, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(layout.createSequentialGroup()
                                                .addGap(50, 50, 50)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                    .addComponent(btnPrikazi, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                    .addComponent(btmDodaj, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(btnZavrsi, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(10, 10, 10)))
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(layout.createSequentialGroup()
                                                .addGap(49, 49, 49)
                                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(btnIzbaci))
                                            .addGroup(layout.createSequentialGroup()
                                                .addGap(71, 71, 71)
                                                .addComponent(jLabel1)
                                                .addGap(18, 18, 18)
                                                .addComponent(txtUkupno, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtTrazi, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnTrazi))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(99, 99, 99)
                        .addComponent(btnPrikazi, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(40, 40, 40)
                        .addComponent(btmDodaj, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(txtKategorija, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(btnTrazi1)
                                .addComponent(jLabel4))
                            .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(26, 26, 26)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 264, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 264, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnIzbaci)
                                .addGap(142, 142, 142)))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 34, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(txtUkupno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(89, 89, 89))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(btnZavrsi, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(65, 65, 65))))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnPrikaziActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPrikaziActionPerformed
        df.clear();
        proizvodi= new ArrayList<Proizvod>();
        try{
            proizvodi= rad.procitajProizvode();
        }
        catch(IOException e){JOptionPane.showMessageDialog(this,e); }
        for(Proizvod p:proizvodi){       
            df.addElement(p);
        }
    }//GEN-LAST:event_btnPrikaziActionPerformed
    double ukupno=0;
    private void btmDodajActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btmDodajActionPerformed
        Object izabran=null;
        try{
            izabran=lstbxProizvodi.getSelectedValue();
            String [] niz=izabran.toString().split(",");
            Proizvod p= new Proizvod(niz[0],niz[1],Double.parseDouble(niz[2]),new Kategorija(niz[3]),Integer.parseInt(niz[4].trim()));
            if(Integer.parseInt(niz[4].trim())>0){
                if(kupac.isPunoletan()==false&&niz[3].equalsIgnoreCase("Alkohol")){
                    JOptionPane.showMessageDialog(this,"Samo punoletna lica mogu kupiti alkohol!");                 
                }
                else{
                    kupac.dodajUKorpu(p);
                    ukupno+=p.getCena();
                    df2.addElement(p);
                    txtUkupno.setText(Double.toString(ukupno));
                }
            }
            else  JOptionPane.showMessageDialog(this,"Proizvod vise nije dostupan!");
        }
        catch(NullPointerException e){JOptionPane.showMessageDialog(this,"Morate izabrati neki proizvod!");}
    }//GEN-LAST:event_btmDodajActionPerformed

    private void btnTraziActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTraziActionPerformed
        df.clear(); 
        if(txtTrazi.getText().length()==0)JOptionPane.showMessageDialog(this,"Morate uneti naziv proizvoda za pretragu!");
        else{
        try{
            ArrayList<Proizvod> pronadjeno= kupac.pretraziPoImenu(txtTrazi.getText());                               
            if(pronadjeno.isEmpty())JOptionPane.showMessageDialog(this,"Ne postoji takav proizvod!");
            else{
                for(Proizvod p:pronadjeno)
                    df.addElement(p);
                }
            }
            catch(IOException e){JOptionPane.showMessageDialog(this,e); }        
        }
    }//GEN-LAST:event_btnTraziActionPerformed
    
    private void btnZavrsiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnZavrsiActionPerformed
        if(kupac.dozvoliKupovinu()==false){
            JOptionPane.showMessageDialog(this,"Nemamo toliko proizvoda dostupno!");
        }
        else{
            txtUkupno.setText("");
            Racun r=new Racun(kupac);
            if(kupac.korpa.size()!=0){
                ukupno=0;
                try{
                kupac.smanjiKolicinu();
                 
                new RacunForma(r).setVisible(rootPaneCheckingEnabled);
                rad.upisiRacun(r);
                df2.clear();
                kupac.korpa.clear();}
                catch(IOException e){JOptionPane.showMessageDialog(this,e); }
            }
            else JOptionPane.showMessageDialog(this,"Vasa korpa je prazna!");
        }       
    }//GEN-LAST:event_btnZavrsiActionPerformed

    
    private void btnTrazi1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTrazi1ActionPerformed
        df.clear();
        if(txtKategorija.getText().length()==0)JOptionPane.showMessageDialog(this,"Morate uneti naziv kategorije  za pretragu!");
        else{
            try{
                ArrayList <Proizvod>listaPoKategoriji=kupac.pretraziPoKategoriji(txtKategorija.getText());
                if(listaPoKategoriji.isEmpty())JOptionPane.showMessageDialog(this,"Ne postoji takav proizvod!");
                for(Proizvod p:listaPoKategoriji){
                    df.addElement( p);
                }
            }
            catch(IOException e){JOptionPane.showMessageDialog(this,e); }        
        }
    }//GEN-LAST:event_btnTrazi1ActionPerformed

    private void btnIzbaciActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIzbaciActionPerformed
        int index=0;
        if(df2.isEmpty()){
           JOptionPane.showMessageDialog(this,"Vasa korpa je prazna!");
        }
        else {          
            try{
                index=lstbxProizvodi1.getSelectedIndex();
                Object proizvodIzListe=df2.getElementAt(index);
                String [] niz=proizvodIzListe.toString().split(",");
                Proizvod p=new Proizvod(niz[0],niz[1],Double.parseDouble(niz[2]),new Kategorija(niz[3]),Integer.parseInt(niz[4].trim()));
                ukupno-=p.getCena();
                txtUkupno.setText(String.valueOf(ukupno));
                kupac.izbaciIzKorpe(index);
                df2.removeElementAt(index); 
                JOptionPane.showMessageDialog(this,"Proizvod izbacen iz korpe!");
            }
            catch(ArrayIndexOutOfBoundsException e){
                JOptionPane.showMessageDialog(this,"Niste izabrali proizvod iz korpe!");
            }          
        }       
    }//GEN-LAST:event_btnIzbaciActionPerformed
  
    public static void main(String args[]) {    
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new KorisnikForma().setVisible(true);           
            }
        });
    }

  
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btmDodaj;
    private javax.swing.JButton btnIzbaci;
    private javax.swing.JButton btnPrikazi;
    private javax.swing.JButton btnTrazi;
    private javax.swing.JButton btnTrazi1;
    private javax.swing.JButton btnZavrsi;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JToggleButton jToggleButton1;
    private javax.swing.JList<String> lstbxProizvodi;
    private javax.swing.JList<String> lstbxProizvodi1;
    private javax.swing.JTextField txtKategorija;
    private javax.swing.JTextField txtTrazi;
    private javax.swing.JTextField txtUkupno;
    // End of variables declaration//GEN-END:variables
}

