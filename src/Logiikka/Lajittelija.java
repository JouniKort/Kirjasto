package Logiikka;

import java.io.File;
import java.util.ArrayList;

public class Lajittelija {
    
    private File mista;
    private File minne;
    private int siirretyt;
    private ArrayList<String> tiedostojenNimiet = new ArrayList<String>();
    
    public Lajittelija(String mista, String minne){
        this.mista = new File(mista);
        this.minne = new File(minne);
        lajittele();
    }
    
    public void lajittele(){
        for(File i : minne.listFiles()){
            String minneNimi = i.getName();
            
            for(File p : mista.listFiles()){
                String siirrettavaNimi = p.getName();
                
                if(containsIgnoreCase(siirrettavaNimi, minneNimi)){
                    p.renameTo(new File(i+"\\"+p.getName()));
                    p.delete();
                    siirretyt++;
                    tiedostojenNimiet.add(p.getName()+"  ->  "+i.getName());
                }
            }
        }
    }
    
    public ArrayList<String> getTiedostojenNimet(){
        return tiedostojenNimiet;
    }
    
    public int getSiirretytLkm(){
        return siirretyt;
    }
    
    public boolean containsIgnoreCase(String verrattava, String haettava){
        String pieniVerrattava = verrattava.toLowerCase();
        String pieniHaku = haettava.toLowerCase();
        if(pieniVerrattava.contains(pieniHaku)){
            return true;          
        }else{
            return false;
        }
    }
}
