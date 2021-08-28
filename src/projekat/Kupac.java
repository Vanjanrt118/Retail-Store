
package projekat;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;


public class Kupac extends Osoba  implements Validacija {
    String korisnickoIme;
    String lozinka;
    boolean punoletan;
    RadSaDatotekom rad=new RadSaDatotekom();
    public ArrayList<Proizvod> korpa=new ArrayList<Proizvod>();

    public Kupac( String ime, String prezime, int godRodjenja,String korisnickoIme, String lozinka) {
       
        this.korisnickoIme = korisnickoIme;
        this.lozinka = lozinka;
        int godina = Calendar.getInstance().get(Calendar.YEAR);
        this.ime=ime;
        this.prezime=prezime;
        this.godRodjenja=godRodjenja;
        if(godina-godRodjenja>=18) punoletan=true;
        else punoletan=false;
    }
    public Kupac(){
        
    }
  

    public String getKorisnickoIme() {
        return korisnickoIme;
    }

    public void setKorisnickoIme(String korisnickoIme) {
        this.korisnickoIme = korisnickoIme;
    }

    public String getLozinka() {
        return lozinka;
    }

    public void setLozinka(String lozinka) {
        this.lozinka = lozinka;
    }

    public String getIme() {
        return ime;
    }

    public void setIme(String ime) {
        this.ime = ime;
    }

    public String getPrezime() {
        return prezime;
    }

    public void setPrezime(String prezime) {
        this.prezime = prezime;
    }

    public int getGodRodjenja() {
        return godRodjenja;
    }

    public void setGodRodjenja(int godRodjenja) {
        this.godRodjenja = godRodjenja;
    }
   

    public boolean isPunoletan() {
        return punoletan;
    }

    @Override
    public String toString() {
        return  korisnickoIme + " " + lozinka+" "+ime+" "+prezime+" "+godRodjenja+ '\n';
    }
   public void dodajUKorpu(Proizvod p){
       korpa.add(p);
   }
   public void izbaciIzKorpe(int i){
       korpa.remove(i);
       
   }

public boolean dozvoliKupovinu(){
    int br=0;
    boolean match=true;
    for(int i=0;i<this.korpa.size();i++){
        if(br>this.korpa.get(i).getKolicina()){
            match=false;
            break;
        }
        for(int j=i;j<this.korpa.size()-1;j++){
            if (this.korpa.get(i).getBarkod().equalsIgnoreCase( this.korpa.get(j).getBarkod())&&this.korpa.get(i).getImeProizvoda().equalsIgnoreCase( this.korpa.get(j).getImeProizvoda()))
                br++;
        }
    }
    return match;
}
   
   
    public static  Kupac  vratiKupca(String korIme,String lozinka)throws IOException,FileNotFoundException{
        BufferedReader br=null;
        Kupac k=null;
        try{            
            br=new BufferedReader(new FileReader("korisnici.txt"));
        }
        catch(FileNotFoundException e){
           throw new FileNotFoundException("Greska pri citanju iz datoteke");     
        }
        catch(IOException e){
            throw new IOException("Greska pri citanju iz datoteke");   
        }
        try{
            String line;
            while((line=br.readLine()) != null){
                String [] niz=line.split(" ");
                if(niz[0].contentEquals(korIme)&&niz[1].contentEquals(lozinka))
                   k=new Kupac(niz[2],niz[3],Integer.parseInt(niz[4]),niz[0],niz[1]); 
            }
        }
        catch(IOException e){
            throw new IOException("Greska pri citanju iz datoteke");   
        }
     
            br.close();  
        
        return k;
    }
      
    public void smanjiKolicinu() throws IOException{
        ArrayList<Proizvod>proizvodi=new ArrayList<Proizvod>();
        try{
        proizvodi=rad.procitajProizvode();
       
        BufferedWriter bw=null;
            for(Proizvod pr:proizvodi){
                for(Proizvod p:korpa){
                    if(p.getImeProizvoda().contentEquals(pr.getImeProizvoda())&& p.getBarkod().contentEquals(pr.getBarkod())){
                        pr.setKolicina(pr.getKolicina()-1);
                        if(pr.getKolicina()<0) pr.setKolicina(0);
                    }
                }           
                try{
                    bw=new BufferedWriter(new FileWriter("proizvodi.txt"));
                    for(Proizvod p:proizvodi) {bw.write(p.toString());}
                }
                catch(IOException e){e.printStackTrace();}
               
                    bw.close();
              
            }
    }
        catch(IOException e){throw new IOException("Greska pri upisu podataka u datoteku");}
    }
    

    public ArrayList<Proizvod>pretraziPoImenu(String ime) throws IOException{
        ArrayList<Proizvod> proizvodi=new ArrayList<Proizvod>();
        ArrayList<Proizvod> pronadjeno=new ArrayList<Proizvod>();
        try{
            proizvodi=rad.procitajProizvode();
        
        
        for(Proizvod p:proizvodi){
            if(p.getImeProizvoda().startsWith(ime))
                pronadjeno.add(p);
        }
        }
          catch(IOException e ){throw new IOException("Greska pri citanju podataka iz datoteke");}      
        return pronadjeno;
    }
      
    public ArrayList<Proizvod>pretraziPoKategoriji(String kategorija) throws IOException{
        ArrayList<Proizvod> proizvodi=new ArrayList<Proizvod>();
        ArrayList<Proizvod> pronadjeno=new ArrayList<Proizvod>();
        try{
            proizvodi=rad.procitajProizvode();
        
       
        for(Proizvod p:proizvodi){
            if(p.getKategorija().getIme().compareToIgnoreCase(kategorija)==0)
                pronadjeno.add(p);
        }
        }
         catch(IOException e){throw new IOException("Greska pri citanju podataka u datoteku");}
        return pronadjeno;     
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
    public  boolean proveriKorIme(String korIme)throws IOException,FileNotFoundException {
        BufferedReader br=null;
        boolean match=true;
        try{ 
            br=new BufferedReader(new FileReader("korisnici.txt"));
        }
        catch(FileNotFoundException e){
           throw new FileNotFoundException("Greska pri citanju podataka iz datoteke") ;   
        }
        catch(IOException e){
            throw new IOException("Greska pri citanju podataka iz datoteke");
        }
        try{
            String line;
            while((line=br.readLine()) != null){
                String [] niz=line.split(" ");
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
