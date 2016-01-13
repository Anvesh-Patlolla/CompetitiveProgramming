package csc570;
//source taken from :http://rosettacode.org/wiki/Monty_Hall_problem#Java
import java.util.Random;

public class Monty {
  public static void main(String[] args) {
    int switchWins = 0;
    int stayWins = 0;
    Random gen = new Random(System.currentTimeMillis());
    for (int plays = 0; plays < 32768; plays++) {
      //gen = new Random(System.currentTimeMillis());
      int[] doors = {0, 0, 0, 0};// 0 is a goat, 1 is a car
      doors[gen.nextInt(4)] = 1;// put a winner in a random door
      int choice = gen.nextInt(4); // pick a door, any door
      int shown; // the shown door
      
      
      do {
        shown = gen.nextInt(4);
        // don't show the winner or the choice
      } while (doors[shown] == 1 || shown == choice);
      
      
      
      
      stayWins += doors[choice];// if you won by staying, count it

      int switchIndex ;
      do{
        switchIndex = gen.nextInt(4);
      }while(switchIndex == choice || switchIndex == shown);
      
      switchWins += doors[switchIndex];
    }
    System.out.println("Switching wins " + switchWins + " times.");
    System.out.println("Staying wins " + stayWins + " times.");
  }
}
