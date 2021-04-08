
package bazimafia;

import java.util.ArrayList;



public class doctor extends Player {
    int counter_save=0;
    boolean found=false;
    public doctor(String Name) {
        super(Name);
        
    }
    public void Save(int doctor_index,String name2){
                    Adminestrator adm = Adminestrator.getInstance();
                    ArrayList listmaf = adm.Players;
                    doctor dc = (doctor)adm.Players.get(doctor_index);
                    if(dc.LiveStatus==false){
                        System.out.println("saver is dead");
                    }
                    else{
                    int Max=((Player)listmaf.get(0)).nigth_VoteCounter;
                    int index = 0;
                    int index_of_being_saved=-1;
                    for (int i = 0; i <listmaf.size(); i++){
                             if(((Player)listmaf.get(i)).Name.equals(name2)){
                               
                                 index_of_being_saved=i;//index nafar save shode
                            
                              }              
                    }
                    boolean flag1=false;//braye jologiri az tekrar khat 76
                    for (int i = 0; i <listmaf.size(); i++){
                        if(Max < ((Player)listmaf.get(i)).nigth_VoteCounter){
                            Max=((Player)listmaf.get(i)).nigth_VoteCounter;
                            index=i;//shomare max bara ki bode
                            
                        }              
                    }
                    int equalvote=0;
                    for (int i = 0; i <listmaf.size(); i++){//ki bod ke max shod
                        if(Max == ((Player)listmaf.get(i)).nigth_VoteCounter){
                          
                            equalvote++;
                        }
                    }
                    if(equalvote>2){
                         System.out.println("nobody died");//chand nafaar ray yeksan dashtan
                         flag1=true;
                    }
                     else if(equalvote==2){
                 
                       if(counter_save==1){
                        
                      int idx1=-1,idx2=-1;
                      for (int i = 0; i <listmaf.size(); i++){//ki bod ke max shod
                           if(Max == ((Player)listmaf.get(i)).nigth_VoteCounter){
                              idx1=i;
                              break;
                            }
                        }
                       for (int i = idx1+1; i <listmaf.size(); i++){//ki bod ke max shod
                           if(Max == ((Player)listmaf.get(i)).nigth_VoteCounter){
                              idx2=i;
                             
                            }
                        }
                       
               
                       
                        if(index_of_being_saved==idx1){
                            ((Player)listmaf.get(idx1)).LiveStatus=true;
                         
                          if(!(((Player)listmaf.get(idx1)) instanceof bulletproof)){
                               ((Player)listmaf.get(idx1)).tried_to_kill=true;
                          }
                          else{
                               ((Player)listmaf.get(idx1)).tried_to_kill=false;    
                          }
                          if((((Player)listmaf.get(idx2)) instanceof bulletproof)){
                              if(((bulletproof)listmaf.get(idx2)).Num_Of_Life>0){
                                   ((bulletproof)listmaf.get(idx2)).Num_Of_Life--; 
                              }
                              else{
                                    ((Player)listmaf.get(idx2)).LiveStatus=false;
                                    ((Player)listmaf.get(idx2)).time_of_being_killed=false;
                                     adm.bulletproof_counter--;
                              }
                            
                          }
                          else{//bulletproof nabashe
                            ((Player)listmaf.get(idx2)).LiveStatus=false;
                            ((Player)listmaf.get(idx2)).time_of_being_killed=false;

                            if(((Player)listmaf.get(idx2)) instanceof mafia){
                                adm.mafia_counter--;
                            }
                            else if(((Player)listmaf.get(idx2)) instanceof godfather){
                                adm.godfather_counter--;
                            }
                            else if(((Player)listmaf.get(idx2)) instanceof silencer){
                                adm.silencer_counter--;
                            }
                            else if(((Player)listmaf.get(idx2)) instanceof villager){
                               adm.villager_counter--;
                            }
                            else if(((Player)listmaf.get(idx2)) instanceof detective){
                                adm.detective_counter--;
                            }
                            else if(((Player)listmaf.get(idx2)) instanceof doctor){
                                adm.doctor_counter--;
                            }
                            else if(((Player)listmaf.get(idx2)) instanceof bulletproof){
                                adm.bulletproof_counter--;
                            }
                            else if(((Player)listmaf.get(idx2)) instanceof Joker){
                                adm.Joker_counter--;
                            }

                          }
                          
                        }
                        else if(index_of_being_saved==idx2){
                            ((Player)listmaf.get(idx2)).LiveStatus=true;
                            if(!(((Player)listmaf.get(idx2)) instanceof bulletproof)){
                               ((Player)listmaf.get(idx2)).tried_to_kill=true;
                            }
                            else{
                               ((Player)listmaf.get(idx2)).tried_to_kill=false;
                            }
                            if((((Player)listmaf.get(idx1)) instanceof bulletproof)){
                                if(((bulletproof)listmaf.get(idx1)).Num_Of_Life>0){
                                   ((bulletproof)listmaf.get(idx1)).Num_Of_Life--; 
                                }
                                else{
                                    ((Player)listmaf.get(idx1)).LiveStatus=false;
                                    ((Player)listmaf.get(idx1)).time_of_being_killed=false;
                                     adm.bulletproof_counter--;
                                }
                            }
                            else{
                                ((Player)listmaf.get(idx1)).LiveStatus=false;
                                ((Player)listmaf.get(idx1)).time_of_being_killed=false;

                                if(((Player)listmaf.get(idx1)) instanceof mafia){
                                    adm.mafia_counter--;
                                }
                                else if(((Player)listmaf.get(idx1)) instanceof godfather){
                                    adm.godfather_counter--;
                                }
                                else if(((Player)listmaf.get(idx1)) instanceof silencer){
                                    adm.silencer_counter--;
                                }
                                else if(((Player)listmaf.get(idx1)) instanceof villager){
                                   adm.villager_counter--;
                                }
                                else if(((Player)listmaf.get(idx1)) instanceof detective){
                                    adm.detective_counter--;
                                }
                                else if(((Player)listmaf.get(idx1)) instanceof doctor){
                                    adm.doctor_counter--;
                                }
                                else if(((Player)listmaf.get(idx1)) instanceof bulletproof){
                                    adm.bulletproof_counter--;
                                }
                                else if(((Player)listmaf.get(idx1)) instanceof Joker){
                                    adm.Joker_counter--;
                                }
                            } 

                        }
                        else{//hich kas az ona nabode ya 2 taro nejat nadade
                            
                           ((Player)listmaf.get(idx1)).LiveStatus=true;
                            if(!(((Player)listmaf.get(idx1)) instanceof bulletproof)){
                               ((Player)listmaf.get(idx1)).tried_to_kill=true;
                            }
                            else{
                             ((Player)listmaf.get(idx1)).tried_to_kill=false;
                            }
                            
                            ((Player)listmaf.get(idx2)).LiveStatus=true;
                            if(!(((Player)listmaf.get(idx2)) instanceof bulletproof)){
                               ((Player)listmaf.get(idx2)).tried_to_kill=true;
                            }
                            else{
                             ((Player)listmaf.get(idx2)).tried_to_kill=false;
                            }
                      
                            System.out.println("nobody died");
                            
                        }
                        
                            
                        }
                     }
                     else{//max koshte shod ye nafar bayad koshte beshe
                         
                        if(index_of_being_saved==index){
                           ((Player)listmaf.get(index)).LiveStatus = true;
                        
                            if(!(((Player)listmaf.get(index)) instanceof bulletproof)){
                            
                                if(counter_save==1){
                                       ((Player)listmaf.get(index)).tried_to_kill=true;
                                       ((Player)listmaf.get(index)).LiveStatus = true;
                                }
                                else{
                                     ((Player)listmaf.get(index)).LiveStatus = false;
                                if(((Player)listmaf.get(index)) instanceof mafia){
                                    adm.mafia_counter--;
                                }
                                else if(((Player)listmaf.get(index)) instanceof godfather){
                                    adm.godfather_counter--;
                                }
                                else if(((Player)listmaf.get(index)) instanceof silencer){
                                    adm.silencer_counter--;
                                }
                                else if(((Player)listmaf.get(index)) instanceof villager){
                                   adm.villager_counter--;
                                }
                                else if(((Player)listmaf.get(index)) instanceof detective){
                                    adm.detective_counter--;
                                }
                                else if(((Player)listmaf.get(index)) instanceof doctor){
                                    adm.doctor_counter--;
                                }
                            
                                else if(((Player)listmaf.get(index)) instanceof Joker){
                                    adm.Joker_counter--;
                                }
                                }
                            }
                            else{
                             
                                if(counter_save==1){
                               
                                ((Player)listmaf.get(index)).tried_to_kill=false;
                              
                                }
                                else{
                                             
                                ((bulletproof)listmaf.get(index)).Num_Of_Life--;
                                if(((bulletproof)listmaf.get(index)).Num_Of_Life<=0){
                                    ((bulletproof)listmaf.get(index)).LiveStatus=false;
                                    adm.bulletproof_counter--;
                                    
                                }
                                }
                            }
                            
                         
                        }
                        else{
                                ((Player)listmaf.get(index)).LiveStatus = false;
                                if(((Player)listmaf.get(index)) instanceof mafia){
                                    adm.mafia_counter--;
                                }
                                else if(((Player)listmaf.get(index)) instanceof godfather){
                                    adm.godfather_counter--;
                                }
                                else if(((Player)listmaf.get(index)) instanceof silencer){
                                    adm.silencer_counter--;
                                }
                                else if(((Player)listmaf.get(index)) instanceof villager){
                                   adm.villager_counter--;
                                }
                                else if(((Player)listmaf.get(index)) instanceof detective){
                                    adm.detective_counter--;
                                }
                                else if(((Player)listmaf.get(index)) instanceof doctor){
                                    adm.doctor_counter--;
                                }
                            
                                else if(((Player)listmaf.get(index)) instanceof Joker){
                                    adm.Joker_counter--;
                                }
                                else if(((Player)listmaf.get(index)) instanceof bulletproof){
                                ((bulletproof)listmaf.get(index)).Num_Of_Life--;
                                if(((bulletproof)listmaf.get(index)).Num_Of_Life<=0){
                                    ((bulletproof)listmaf.get(index)).LiveStatus=false;
                                    adm.bulletproof_counter--;
                                    
                                }
                                else{
                                    ((bulletproof)listmaf.get(index)).LiveStatus=true;
                                }
                                }
                        
                        }
                     
                         
                     }
    
    }
    }
}
