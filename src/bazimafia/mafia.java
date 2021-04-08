
package bazimafia;

import java.util.ArrayList;
import java.util.Scanner;

public class mafia extends Player {
        public mafia(String Name) {
        super(Name);
    }
        public String Vote_During_Night(int index_mafia,String name2){
            boolean found=false;
           
            Adminestrator adm = Adminestrator.getInstance();
            ArrayList listmaf = adm.Players;
         //   mafia m = (mafia)listmaf.get(index_mafia);
            Player m = (Player)listmaf.get(index_mafia);
            if(m.LiveStatus==false){
               return " mafia(voter) is dead";  
            }
            for (int i = 0; i < listmaf.size(); i++) {
                Player p = (Player)listmaf.get(i);
                if(p.Name.equals(name2)){
                    if(p.LiveStatus==false){
                        return "votee already dead";
                    }
                    else{
                       return index_mafia+"->"+i+"]"; 
                     // p.VoteCounter++;
                    }
                }
              
            }
            if(found==false){
                    return "user not joined";
            }



            return "";
        }
       
    
}
