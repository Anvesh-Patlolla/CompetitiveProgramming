package csc505;

import java.util.ArrayList;

public class CellTowers {

  ArrayList<Integer> placingCellTowers(ArrayList<Integer> houseList, int minimumDistance) {
    ArrayList<Integer> cellTowerList = new ArrayList<>();
    int currentTower = houseList.get(0) + minimumDistance;
    while (houseList.isEmpty() == false) {

      currentTower = houseList.get(0) + minimumDistance;
      while (houseList.isEmpty() == false && houseList.get(0) <= currentTower + minimumDistance) {
        houseList.remove(0);
      }
      cellTowerList.add(currentTower);

    }

    return cellTowerList;
  }

  public static void main(String[] args) {
    CellTowers towers = new CellTowers();
    ArrayList<Integer> houseList = new ArrayList<>();
    houseList.add(1);
    houseList.add(2);
    houseList.add(3);
    houseList.add(4);
    houseList.add(5);
    houseList.add(6);
    houseList.add(7);
    houseList.add(8);
    houseList.add(9);
    houseList.add(10);
    houseList.add(12);
    houseList.add(13);
    houseList.add(14);
    int minimumDistance = 3;
    System.out.println(towers.placingCellTowers(houseList, minimumDistance));
  }
}
