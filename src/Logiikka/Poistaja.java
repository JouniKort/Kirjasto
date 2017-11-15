package Logiikka;

import java.io.File;

public class Poistaja {
    
    public Poistaja(){
        
    }
    
    public boolean poistaTiedosto(String tiedostonNimi){
        File tiedosto = new File("C:\\Users\\Jouni\\Desktop\\Kansiot\\txt\\"+tiedostonNimi+".txt");
        tiedosto.delete();
             
        return true;
    }
}
