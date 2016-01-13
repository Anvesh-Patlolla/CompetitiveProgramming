package csc570;

import java.util.HashSet;
import java.util.Random;

public class MontyHall {
  private static int noOfGames = 0;
  private static int noOfWins = 0;
  private static int noOfTimesDoorsSwitched = 0;
  private static int noOfSwitchAndWin = 0;
  private static int noOfSwitchAndLoose = 0;
  private boolean userSwitched = false;
  private boolean doorsIn[] = null;
  private int carIndex = 0;
  HashSet<Integer> currentlyOpenDoors = null;
  HashSet<Integer> currentlyClosedDoors = null;
  private int noOfDoors = 0;
  private int usersChoiceOfDoor = -1;
  private Random randomSequence = null;

  public MontyHall(int noOfDoors) {
    noOfGames++;
    long seed = System.currentTimeMillis();
    randomSequence = new Random(seed);

    this.noOfDoors = noOfDoors;
    this.carIndex = generateRandomNum(noOfDoors);
    // System.out.println("Car Index: " + this.carIndex);
    doorsIn = new boolean[this.noOfDoors];
    doorsIn[this.carIndex] = true;
    currentlyClosedDoors = new HashSet<>();
    currentlyOpenDoors = new HashSet<>();
    for (int i = 0; i < noOfDoors; i++) {
      currentlyClosedDoors.add(i);
    }
  }

  public boolean startGame() {
    boolean retVal = false;

    // int doorsToBeOpened = noOfDoors - 2;
    usersChoiceOfDoor = generateRandomNum(noOfDoors);
    // System.out.println("Users choice of Door:" + usersChoiceOfDoor);

    {
      int openADoor = openAClosedDoor();
      // System.out.println("Opened DOOR :" + openADoor);
      usersDecision();
    }

    if (usersChoiceOfDoor == carIndex) {
      retVal = true;
      noOfWins++;
    }
    if (userSwitched) {
      noOfTimesDoorsSwitched++;
      if (retVal) {
        noOfSwitchAndWin++;
      } else {
        noOfSwitchAndLoose++;
      }
    }
    return retVal;
  }

  // Users decision whether to switch the door
  private void usersDecision() {
    if (shouldUserSwitch()) {
      userSwitched = true;
      chooseAClosedDoor();
    }

  }

  private void chooseAClosedDoor() {
    int retVal = generateRandomNum(currentlyClosedDoors.size() - 1);
    while (!currentlyClosedDoors.contains(retVal) || retVal == usersChoiceOfDoor) {
      retVal = generateRandomNum(currentlyClosedDoors.size()-1);
    }
    //System.out.println("User choose to switch door from " + usersChoiceOfDoor + " to :" + retVal);
    usersChoiceOfDoor = retVal;
    // return retVal;
    /*
     * for (int door : currentlyClosedDoors) { if (door != usersChoiceOfDoor) { //
     * System.out.println("User choose to switch door from " + usersChoiceOfDoor + " to :" + //
     * door); usersChoiceOfDoor = door; return; } }
     */

  }

  private boolean shouldUserSwitch() {
    int retVal = generateRandomNum(2);
    return retVal == 0 ? false : true;
  }

  // Open a closed door which contains a Goat and not the door which the user has selected.
  private int openAClosedDoor() {
    int retVal = generateRandomNum(currentlyClosedDoors.size() - 1);
    while(retVal == carIndex || retVal == usersChoiceOfDoor){
      retVal = generateRandomNum(currentlyClosedDoors.size() - 1);
    }
    currentlyClosedDoors.remove(retVal);
    currentlyOpenDoors.add(retVal);
    return retVal;
    /*
    for (int door : currentlyClosedDoors) {
      if (door != carIndex && door != usersChoiceOfDoor) {
        currentlyClosedDoors.remove(door);
        currentlyOpenDoors.add(door);
        return door;
      }
    }
    return 0;*/
  }

  private int generateRandomNum(int bound) {
    return randomSequence.nextInt(bound);
  }

  public static void main(String[] args) {
    int noOfDoors = 4;
    for (int i = 0; i < 10000; i++) {
      MontyHall obj = new MontyHall(noOfDoors);
      obj.startGame();
    }

    System.out.println("No of GAMES :" + noOfGames);
    System.out.println("No of WINS :" + noOfWins);
    System.out.println("No of Switches :" + noOfTimesDoorsSwitched);
    System.out.println("No of Switches and Win :" + noOfSwitchAndWin);
    System.out.println("No of Switches and Loose :" + noOfSwitchAndLoose);
  }


}
