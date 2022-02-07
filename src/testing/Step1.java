package testing;
import smartdevice.*;
import java.util.Scanner;

class Step1{
  public static void main(String[] args) {
    // Hard Coded Object
    SmartDevice obj = new SmartDevice("TV 1", 1.1, false);
    System.out.println(obj.toString());

    //Objects in an Array
    Scanner input = new Scanner(System.in);
    System.out.println("How many smart devices do you have?:");
    int deviceArrayLength = input.nextInt();
    SmartDevice[] smartDevices = new SmartDevice[deviceArrayLength];

    for (int i = 0;i<deviceArrayLength;i++) {
      int deviceNumber = i + 1;
      System.out.println("##DEVICE " + deviceNumber + "##");
      System.out.println("Name this Device:");
      // .next is used because it works and .nextLine don't
      String nameIn = input.next(); // .next is datatype agnostic
      System.out.println("The Device Location Is:");
      Double locationIn = input.nextDouble();
      System.out.println("true or false, is the device on?:");
      Boolean switchedOnIn = input.nextBoolean();
      SmartDevice device = new SmartDevice(nameIn,locationIn,switchedOnIn);
      smartDevices[i] = device;
    }

    listDevices(smartDevices);

    // Toggle power to device
    System.out.println("Select device number to turn on/off:");
    int userSelectedDevice = input.nextInt();
    SmartDevice updateDevice = smartDevices[userSelectedDevice - 1];
    if (updateDevice.isSwitchedOn()){
      updateDevice.switchOff();
    } else {
      updateDevice.switchOn();
    }

    listDevices(smartDevices);


  }
  //helper function to list all devices
  public static void listDevices(SmartDevice[] smartDevices){
    for (int i=0; i<smartDevices.length; i++) {
      int deviceNumber = i + 1;
      System.out.println("------------" + "\n" +
                         "- Device " + deviceNumber + " -" + "\n" +
                         "------------");
      System.out.println(smartDevices[i].toString());
      System.out.println("------------");
    }
  }
}
