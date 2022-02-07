package smartdevice;
import customdata.LightMode;

public class SmartLamp extends SmartDevice {
  // properties
  private LightMode lightMode = new LightMode();

  // methods
  public SmartLamp(String nameIn, Double locationIn, Boolean switchedOnIn, int lightModeIn){
    super(nameIn, locationIn, true);

    lightMode.setMode(lightModeIn);
  }

  public void setLampMode(int lightModeIn){
    lightMode.setMode(lightModeIn);
  }

  public String getLampMode(){return lightMode.getMode();}

  // override Methods
  @Override public String toString(){
    return "Name: " + name + "\n" +
           "Location: " + location.toString() + "\n" +
           "Switched On: " + switchedOn.toString() + "\n" +
           "Current Light Mode: " + getLampMode();
  }
}
