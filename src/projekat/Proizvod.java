
package projekat;

import com.sun.xml.internal.fastinfoset.util.StringArray;
import java.awt.List;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;


public class Proizvod  {
    private String imeProizvoda;
    private  String barkod;
    private Double cena;
    private Kategorija kategorija;
    private int kolicina;
    


    public Proizvod(String imeProizvoda, String barkod, Double cena, Kategorija kategorija,int kolicina) {
        this.imeProizvoda = imeProizvoda;
        this.barkod = barkod;
        this.cena = cena;
        this.kategorija = kategorija;
        this.kolicina=kolicina;
    }

    public String getImeProizvoda() {
        return imeProizvoda;
    }

    public void setImeProizvoda(String imeProizvoda) {
        this.imeProizvoda = imeProizvoda;
    }

    public String getBarkod() {
        return barkod;
    }

    public void setBarkod(String barkod) {
        this.barkod = barkod;
    }

    public Double getCena() {
        return cena;
    }

    public void setCena(Double cena) {
        this.cena = cena;
    }

    public Kategorija getKategorija() {
        return kategorija;
    }

    public void setKategorija(Kategorija kategorija) {
        this.kategorija = kategorija;
    }

    public int getKolicina() {
        return kolicina;
    }

    public void setKolicina(int kolicina) {
        this.kolicina = kolicina;
    }
    

    @Override
    public String toString() {
        return   imeProizvoda + "," + barkod + "," + cena + "," +kategorija.toString()+","+kolicina+'\n' ;
    }

    
  
}
