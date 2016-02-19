package tbd;




public class Restaurent extends  AbstractClass implements IInterface{

  protected Restaurent() {
    System.out.println("inside Restaurent Constructor");
  }

  static Restaurent sInstance = null;

  public static synchronized Restaurent getInstance() {
    if (sInstance == null) {
      sInstance = new Restaurent();
    }
    return sInstance;
  }

  @Override
  public void method1() {
    
  }


}
