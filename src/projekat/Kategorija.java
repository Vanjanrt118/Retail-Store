
package projekat;

public class Kategorija {
    private String ime;

    public Kategorija(String ime) {
        this.ime = ime;
    }

    public String getIme() {
        return ime;
    }

    public void setIme(String ime) {
        this.ime = ime;
    }
    

    @Override
    public String toString() {
        return  ime ;
    }
    public boolean proveriKategoriju(){
        String[] imenaKategorija = {"Alkohol", "Negazirani sok", "Gazirani sok", "Voda"};
        boolean match=false;
        for(String kategorije:imenaKategorija){
            if(ime.equalsIgnoreCase(kategorije))  match=true;
        }
        return match;   
    }
    
}
