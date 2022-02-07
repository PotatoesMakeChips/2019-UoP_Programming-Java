package smartdevice;

public class SmartFridge extends SmartDevice {
  // properties
  protected int currentTemperature;

  // methods
  public SmartFridge(String nameIn, Double locationIn, int currentTemperatureIn){
    super(nameIn, locationIn, true);
    currentTemperature = currentTemperatureIn;
  }

  public void increment(){currentTemperature += 1;}
  public void decrement(){currentTemperature -= 1;}

  // overide methods
  @Override public void switchOff(){

  }

  @Override public String toString(){
    return "Name: " + name + "\n" +
           "Location: " + location.toString() + "\n" +
           "Switched On: " + switchedOn.toString() + "\n" +
           "Current Temperature: " + currentTemperature;
  }

}
