
package projekat;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;


public class Administrator extends Osoba implements Validacija {
    String korisnickoIme;
    String lozinka;
    public Administrator(String ime,String prezime,int godRodjenja,String korIme,String lozinka) {        
        this.ime=ime;
        this.prezime=prezime;
        this.godRodjenja=godRodjenja;
        this.korisnickoIme=korIme;
        this.lozinka=lozinka;
        
    }
    public Administrator(){
        
    }


    public String getKorisnickoIme() {
        return korisnickoIme;
    }

    public String getLozinka() {
        return lozinka;
    }

    public String getIme() {
        return ime;
    }
    
    public String getPrezime() {
        return prezime;
    }

    public int getGodRodjenja() {
        return godRodjenja;
    }
    @Override
    public String toString() {
        return  korisnickoIme + "," + lozinka+","+ime+","+prezime+","+godRodjenja+'\n';
    }
   
   
    public boolean proveriSifru(String lozinka){
        int brVelikihSlova=0;
        int brCifara=0;
        char [] niz=lozinka.toCharArray();
        int brKaraktera=niz.length;
        for(int i=0;i<niz.length;i++){
            if(Character.isDigit(niz[i]))brCifara++;
            else if(Character.isUpperCase(niz[i]))brVelikihSlova++;
        }
        if(brVelikihSlova>0&&brKaraktera>5&&brCifara>0)return true;
        else return false;
    }
    public  boolean proveriKorIme(String korIme) {
        BufferedReader br=null;
        boolean match=true;
        try{ 
            br=new BufferedReader(new FileReader("administratori.txt"));
        }
        catch(FileNotFoundException e){
            System.out.println("Greška pri čitanju iz datoteku!");     
        }
        catch(IOException e){
            e.printStackTrace();
        }
        try{
            String line;
            while((line=br.readLine()) != null){
                String [] niz=line.split(",");
                if(niz[0].contentEquals(korIme))match=false;
 
            }            
        }
        catch(IOException e){
            e.printStackTrace();  
        }
        try{
            br.close();
        }
        catch(IOException e){e.printStackTrace();}
        return match;
    }
     public boolean proveriPoklapanjeLozinke(String loz1,String loz2){
        if(loz1.contentEquals(loz2))return true;
        else return false;
    }    
}
