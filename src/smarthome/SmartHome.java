package smarthome;
import smartdevice.*;

public class SmartHome{
  // private properties
  private SmartDevice[] smartDevices;

  // constructors
  // Java desides what constructor to use based on the type of data the class is given
  public SmartHome(int deviceArrayLength){
    smartDevices = new SmartDevice[deviceArrayLength];
  }

  public SmartHome(SmartDevice[] smartDevicesIn){
    smartDevices = smartDevicesIn;
  }

  // methods

  //this method gets the length of the SmartDevice array
  private int deviceArrayLength(){
    return smartDevices.length;
  }

  // this method puts a SmartDevice in the first empty slot in the array
  // it returns 1 when there is no avalible slot else 0
  private int firstNullSlot(SmartDevice smartDeviceIn){
    int errorcode = 1;
    for (int i=0;i<smartDevices.length;i++) {
      if (smartDevices[i] == null){
        smartDevices[i] = smartDeviceIn;
        errorcode = 0;
        break;
      }
    }
    return errorcode;
  }

  // this method enlarges the smartDevices array to have the number
  // of slots specified empty. This is done with arraycopy. Arrays.copyOf()
  // uses this method and would have been used insted if use of the util libary
  // was not forbiden
  private void enlargeArray(int enlargeAmount){
    int deviceArrayLength = deviceArrayLength();
    SmartDevice[] bigerArray = new SmartDevice[deviceArrayLength + enlargeAmount];
    System.arraycopy(smartDevices,0,bigerArray,0,deviceArrayLength);
    smartDevices = bigerArray;
  }

  // this is the two insertDevice methods they both pass a smart device to the
  // firstNullSlot method and pass the errorcode back to the calling method or function
  public void insertDevice(String nameIn, Double locationIn, Boolean switchedOnIn){
      SmartDevice newDevice = new SmartDevice(nameIn,locationIn,switchedOnIn);
      int errorcode = firstNullSlot(newDevice);
      if (errorcode == 1) {addDevice(newDevice);}
  }
  public void insertDevice(SmartDevice newDevice){
      int errorcode = firstNullSlot(newDevice);
      if (errorcode == 1) {addDevice(newDevice);}
  }


  // add device funtion adds the device it is parced to the first empty slot
  // if their is now empty slot it uses the array enlarge method to make one
  public void addDevice(SmartDevice deviceIn){
    int errorcode = firstNullSlot(deviceIn);
    if (errorcode == 1) {
      enlargeArray(1);
      firstNullSlot(deviceIn);
    }
  }

// this function gets the number of a smart device from its location
// if it reterns 0 then the device does not exist this is done as an int cannot
// store a null value to to limitations in java
  public int getDeviceNumber(double locationIn){ // this should be private but testing requires it in the Step2 class
    int deviceNumber = 0;
    for (int i=0; i<deviceArrayLength(); i++ ) {
      SmartDevice device = smartDevices[i];
      if (device.getLocation() == locationIn) {
        deviceNumber = i+1;
        break;
      }
    }
    return deviceNumber;
  }

  // the two get device methods identify devices by their index or by their location
  public SmartDevice getDevice(int deviceIndex){
    SmartDevice device;
    try {
      device = smartDevices[deviceIndex];
    } catch (Exception e) {
      device = null;
    }
    return device;
  }
  public SmartDevice getDevice(double deviceLocation){
    SmartDevice device;
    int deviceNumber = getDeviceNumber(deviceLocation);
    if (deviceNumber == 0) {
      device = null;
    }
    else{
      device = smartDevices[deviceNumber-1]; //-1 converts from number (counting from 1) to device index (counting from 0)
    }
    return device;
  }

  // function to toggle a device on or off
  public void toggle(double deviceLocation){
    SmartDevice device;
    int deviceNumber = getDeviceNumber(deviceLocation);
    if (deviceNumber == 0) {
      device = null;
    }
    else{
      device = smartDevices[deviceNumber-1]; //-1 converts from number to device index
      if (device.isSwitchedOn()){
        device.switchOff();
      } else {
        device.switchOn();
      }
    }
  }

  // toggles all of the devices in one room
  public void setAllInRoom(double roomNumber){
    for (SmartDevice device : smartDevices) {
      double deviceLocation = device.getLocation();
      double deviceRoom = deviceLocation-(deviceLocation%1); // caclulates decimal and subtracts it
      if (deviceRoom == roomNumber) {
        device.switchOn();
      }
    }
  }

  //turns everything off
  public void shutdown(){
    for (SmartDevice device : smartDevices) {
      device.switchOff();
    }
  }

  public String toString(){
    String outputString = "";
    for (int i=0; i<smartDevices.length; i++) {
      int deviceNumber = i + 1;
      if (smartDevices[i] == null) {
        break;
      } else{
        outputString += "------------" + "\n" +
                        "- Device " + deviceNumber + " -" + "\n" +
                        "------------" + "\n" +
                        smartDevices[i].toString() + "\n" +
                        "------------";
      }
    }
    return outputString;
  }


}
