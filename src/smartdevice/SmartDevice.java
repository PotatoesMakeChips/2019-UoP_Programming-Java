package smartdevice;

public class SmartDevice{
  protected String name;
  protected Double location;
  protected Boolean switchedOn;

  public SmartDevice(String nameIn, Double locationIn, Boolean switchedOnIn){
    name = nameIn;
    location = locationIn;
    switchedOn = switchedOnIn;
  }

  // Get Methods
  public String getName(){return name;}
  public Double getLocation(){return location;}
  public Boolean isSwitchedOn(){return switchedOn;}
  public String toString(){
    return "Name: " + name + "\n" +
           "Location: " + location.toString() + "\n" +
           "Switched On: " + switchedOn.toString();
  }


  //Set Methods
  public void setName(String nameIn){name = nameIn;}
  public void setLocation(Double locationIn){location = locationIn;}

  //Control Methods
  public void switchOn(){switchedOn = true;}
  public void switchOff(){switchedOn= false;}
}
