package toBeDeleted;

class Sample1 {
  int rollno;
  String name;
  String college = "ITS";

  Sample1(int r, String n) {
    rollno = r;
    name = n;
  }

  void display() {
    System.out.println(rollno + " " + name + " " + college);
  }

  public static void main(String args[]) {
    Sample1 s1 = new Sample1(111, "Karan");
    Sample1 s2 = new Sample1(222, "Aryan");

    s1.display();
    s2.display();
  }
}
