
package projekat;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;


public class RadSaDatotekom {
    
   public  void upisiKupca (Kupac k) throws  IOException {
       BufferedWriter bw=null;
        try{
            bw=new BufferedWriter(new FileWriter("korisnici.txt",true));    
              bw.append(k.toString());  
        }
        catch(IOException e){
         throw new  IOException("Greska pri upisu u datoteku") ;   
        }     
        
            bw.close();
        

    }
    public  boolean pretragaKupca(String korIme,String lozinka) throws IOException,FileNotFoundException {
        BufferedReader br=null;
        boolean match=false;
        try{            
            br=new BufferedReader(new FileReader("korisnici.txt"));
               String line;
            while((line=br.readLine()) != null){
                String [] niz=line.split(" ");
                if(niz[0].contentEquals(korIme)&&niz[1].contentEquals(lozinka)) match=true;
            } 
        }
        catch(FileNotFoundException e){
            throw new FileNotFoundException("Greska pri citanju iz datoteke");
        }
        catch(IOException e){
            throw new IOException("Greska pri citanju iz datoteke");
        }
        
      
            br.close();
         
        return match;
    }
     public  boolean pretragaAdministratora(String korIme,String lozinka)throws FileNotFoundException,IOException{
        BufferedReader br=null;
        boolean match=false;
        try{            
            br=new BufferedReader(new FileReader("administratori.txt"));
             String line;
            while((line=br.readLine()) != null){
                String [] niz=line.split(",");
                if(niz[0].contentEquals(korIme)&&niz[1].contentEquals(lozinka)) match=true;
            }
        }
        catch(FileNotFoundException e){
           throw new FileNotFoundException("Greška pri čitanju iz datoteku!");     
        }
        catch(IOException e){
            throw new IOException("Greška pri čitanju iz datoteku!");
        }
       
            br.close();
    
        return match;
    }
       public  void upisiAdministratora (Administrator a) throws IOException {
        BufferedWriter bw=null;
        try{
            bw=new BufferedWriter(new FileWriter("administratori.txt",true)); 
              bw.append(a.toString());  
        }
        catch(IOException e){
            throw new IOException("Greška pri čitanju iz datoteku!");
            
        }       
      
            bw.close();
    
    
    }
       public ArrayList<Proizvod> procitajProizvode()throws IOException,FileNotFoundException{
        BufferedReader br=null;
        ArrayList<Proizvod> proizvodi=new ArrayList<Proizvod>();
        try{            
            br=new BufferedReader(new FileReader("proizvodi.txt"));  
               String line;
            while((line=br.readLine()) != null){
               String [] niz=line.split(",");
               Proizvod p=new Proizvod(niz[0],niz[1],Double.parseDouble(niz[2]),new Kategorija(niz[3]),Integer.parseInt(niz[4]));
               proizvodi.add(p);              
            }    
        }
        catch(FileNotFoundException e){
          throw new FileNotFoundException("Greška pri čitanju iz datoteku!");    
        }
        catch(IOException e){
            throw new IOException("Greška pri čitanju iz datoteku!");
        }
       
            br.close();

        return proizvodi;
    }
        public  void upisiProizvod (Proizvod p) throws KategorijaException,IOException,FileNotFoundException {
        BufferedWriter bw=null;
        BufferedReader br=null;
        boolean postoji=false;
        ArrayList<Proizvod>lista=new ArrayList<Proizvod>();
        double cena=0.0;
        int kolicina=0;
        lista=procitajProizvode();
        for(Proizvod pr:lista){
            if(pr.getImeProizvoda().contentEquals(p.getImeProizvoda())&&pr.getBarkod().contentEquals(p.getBarkod())){
                postoji=true;
                pr.setKolicina(p.getKolicina());
                pr.setCena(p.getCena());
            }                 
        }
        if(postoji==true){          
            try{
                bw=new BufferedWriter(new FileWriter("proizvodi.txt"));
                for(Proizvod pr:lista) bw.write(pr.toString());             
            }       
            catch(IOException e){throw new IOException("Greška pri upisu podataka u datoteku!");}           
                bw.close();           
        }
        if(postoji==false){
            try{
                bw=new BufferedWriter(new FileWriter("proizvodi.txt",true));
                if(p.getKategorija().proveriKategoriju()!=true)throw new KategorijaException();
                else bw.append(p.toString());              
            }   
            catch(IOException e){throw new IOException("Greška pri upisu podataka u datoteku!");}
           
                bw.close();
          
                     
        }
    }
         public  void izbrisiProizvod (Proizvod proizvod)throws IOException{
        try{
        ArrayList<Proizvod>listaProizvoda=procitajProizvode();
        
        BufferedWriter bw=null;
        Proizvod pronadjen=null;
        boolean match=false;
        for(Proizvod p:listaProizvoda){
            if(p.getImeProizvoda().contentEquals(proizvod.getImeProizvoda())&&p.getBarkod().contentEquals(proizvod.getBarkod())){
                pronadjen=p;
                match=true;
            }
        }
        listaProizvoda.remove(pronadjen);
        if(match==true){
            try{
                bw=new BufferedWriter(new FileWriter("proizvodi.txt")); 
                for(Proizvod p :listaProizvoda){
                    bw.write(p.toString());
                }
            }
            catch(IOException e){e.printStackTrace();}
            
                bw.close();
            
        }
        }
            catch(IOException e){
                e.printStackTrace();}            
                    
   
    }
          public void upisiRacun(Racun r) throws IOException{
        BufferedWriter bw=null;
        String tekst="";
        double ukupnaCena=0;
        for(Proizvod p:r.kupac.korpa)
        {
            tekst+=p.getImeProizvoda()+"-"+p.getCena()+"\n";
            ukupnaCena+=p.getCena();
        }
        try{
            bw=new BufferedWriter(new FileWriter("racun.txt"));
            bw.write(tekst);
            bw.write("----------------------------------------------------------"+"\n");
            bw.write("Ukupno "+ukupnaCena+"din");    
        }
        catch(IOException  e){throw new IOException("Greska pri upisu podataka u datoteku");}
        bw.close();
               
    }
          public ArrayList<String> citajRacun()throws IOException,FileNotFoundException{
        BufferedReader br=null;
        ArrayList<String> proizvodi=new ArrayList<String>();
        try{            
            br=new BufferedReader(new FileReader("racun.txt"));  
              String line;
            while((line=br.readLine()) != null){
                proizvodi.add(line);
            }
        }
     catch(FileNotFoundException e){throw new FileNotFoundException("Greska pricitanja podataka iz datoteke");}
        catch(IOException e){
          throw new IOException("Greska pricitanja podataka iz datoteke");
        }
       
      
            br.close();
      
        return proizvodi;
    }
       
    
}
