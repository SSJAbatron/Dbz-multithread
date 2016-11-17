import java.lang.*;
import java.io.*;
import java.util.Random;
public class multithread extends Thread
{

  static multithread player1=new multithread();
  static multithread player2=new multithread();
  static int p1_life;
  static int p2_life;
  String attack_fun()
  {
     String[] attacks={"kamehameha","finalflash","bigbang","spiritbomb"};
     Random rn=new Random();
       String attack=attacks[rn.nextInt(3-0+1)+0];
       return attack;
  }

  public void run()
  {
    try{
      DataInputStream in=new DataInputStream(System.in);
      System.out.print(getName()+":"+getPriority()*10+"\t");
     p1_life=player1.getPriority()*10;
     p2_life=player2.getPriority()*10;
      System.out.println("\n");
      while(p1_life>0 && p2_life>0)
    {
      String attack=attack_fun();
      String name=getName();
      System.out.print(name+":"+attack+"\t");
      if(name=="goku" && attack=="kamehameha")
      {
           p2_life=p2_life-20;
         System.out.print(player2.getName()+":"+p2_life);
      }
      else if( name=="vegeta" && attack=="finalflash")
      {
         p1_life=p1_life-20;
         System.out.print(player1.getName()+":"+p1_life);
      }
      else if(name=="goku" && attack=="spiritbomb")
      {
        p2_life=p2_life-40;
        System.out.println(player2.getName()+":"+p2_life);
      }
      else if(name=="vegeta" && attack=="spiritbomb")
      {
        p1_life=p1_life-40;
        System.out.println(player1.getName()+":"+p1_life);
      }
          System.out.println("\n");

                if(p1_life==0 || p2_life==0)
                  {
                    break;
                  }

    }
System.out.println("Scores for player1 vs player2 is:"+p1_life+"-"+p2_life);

    }
    catch(Exception e)
    {}

   }
  public static void main(String[] args)
  {

    player1.setName("goku");
    player2.setName("vegeta");
    player1.setPriority(10);
    player2.setPriority(10);
    player1.start();
    player2.start();
  }
}
