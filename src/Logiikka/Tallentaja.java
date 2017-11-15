package Logiikka;

import java.io.File;
import java.io.FileWriter;

public class Tallentaja {
    
    private int pituus;
    
    public Tallentaja(){
        
    }
    
    public boolean Talleta(String nimi, String merkkijono){
        try{
            File uusitiedosto = new File("C:\\Users\\Jouni\\Desktop\\Kansiot\\txt\\"+nimi+".txt");
            pituus = uusitiedosto.getPath().length();
            return kirjoita(uusitiedosto,merkkijono);
        }catch(Exception e){
            System.out.println(e);
        }
        return false;
    }
    
    private boolean kirjoita(File tiedosto, String merkkijono){
        try{
            FileWriter kirjoittaja = new FileWriter(tiedosto);
            kirjoittaja.write(merkkijono);
            kirjoittaja.close();
            return true;
        }catch(Exception e){
            System.out.println(e);
        }
        return false;
    }
}
