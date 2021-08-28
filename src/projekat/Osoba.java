
package projekat;

public abstract class Osoba {
   protected String ime;
   protected String prezime;
   protected   int godRodjenja;

   
 @Override
    public String toString() {
        return   ime + " " + prezime + " " + godRodjenja;
    }
    
    
}
