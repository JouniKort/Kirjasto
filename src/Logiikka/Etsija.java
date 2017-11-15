package Logiikka;

import java.io.File;
import java.util.Scanner;

public class Etsija {
    
    private String hakusana;
    private String nimi;
    private int avatutTiedostot;
    private String polku;
    private boolean totuus;
    private int rivit;
    
    public Etsija(){
    }
    
    public void annaHakusana(String hakusana){
        this.hakusana = hakusana;
    }
    
    public void RadioNappula(boolean totuus){
        this.totuus = totuus;
    }
    
    public String avaaTiedosto(){               
        String merkkijono = "";
        avatutTiedostot = 0;
        try{            
            File tiedosto = new File("C:\\Users\\Jouni\\Desktop\\Kansiot\\txt");
            for(File tiedostoNimi : tiedosto.listFiles()){
                if(totuus){
                    if(containsIgnoreCase(tiedostoNimi.getName())){
                        this.nimi = tiedostoNimi.getName();
                        merkkijono += kirjoitaMerkkijono(tiedostoNimi);
                        polku = tiedostoNimi.getPath();
                    }
                }else{
                    if(tarkastaTiedosto(tiedostoNimi)){
                        merkkijono += kirjoitaMerkkijono(tiedostoNimi)+"\n";
                        this.nimi = tiedostoNimi.getName();
                        polku = tiedostoNimi.getPath();
                    }  
                }
                
            }       
        }catch(Exception e){
            System.out.println("ei toimi "+e);
        }
        
        return merkkijono;
    }
    
    public boolean containsIgnoreCase(String verrattava){
        String pieniVerrattava = verrattava.toLowerCase();
        String pieniHaku = this.hakusana.toLowerCase();
        if(pieniVerrattava.contains(pieniHaku)){
            return true;          
        }else{
            return false;
        }
    }
    
    public boolean tarkastaTiedosto(File tiedosto){
        try{
            if(containsIgnoreCase(tiedosto.getName())){
                return true;
            }
            Scanner lukija = new Scanner(tiedosto);
            while(lukija.hasNext()){
                if(containsIgnoreCase(lukija.next())){
                    return true;
                }
            }
        }catch(Exception e){
            System.out.println(e);
        }
        return false;
    }
    
    public String kirjoitaMerkkijono(File tiedosto){
        String merkkijono = "";
        try{
            merkkijono += tiedosto.getPath()+"\n\n";
            Scanner lukija = new Scanner(tiedosto);
            while(lukija.hasNext()){
                merkkijono += lukija.nextLine()+"\n";
                rivit++;
            }
            lukija.close();
            avatutTiedostot++;
        }catch(Exception e){
            System.out.println(e);
        }
        return merkkijono;
    }
    
    public String getNimi(){
        this.nimi = nimi.substring(0, nimi.length()-4);
        return this.nimi;
    }
    
    public String getPath(){
        return polku;
    }
    
    public int getTiedostotluku(){
        return this.avatutTiedostot;
    }
    
    public void nollaaTiedostoluku(){
        this.avatutTiedostot = 0;
    }
    
    public int getRivit(){
        return rivit;
    }
    
    public void nollaaRivit(){
        rivit = 0;
    }
}
