
package projekat;

import java.io.FileNotFoundException;
import java.io.IOException;

public  interface Validacija {
    public  boolean proveriSifru(String lozinka);
    public boolean proveriKorIme(String korIme)throws IOException,FileNotFoundException;
    public  boolean proveriPoklapanjeLozinke(String loz1,String loz2);

}
