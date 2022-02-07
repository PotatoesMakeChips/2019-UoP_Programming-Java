package testing;
import java.util.Scanner;
import smarthome.*;
import smartdevice.*;

class Step2 {
  public static void main(String[] args) {
    SmartHome smartHome = step2Part1(); // smartHome object created in part 1 used in later tests
    step2Part2(); // smartHome object from part 2 is not used again
    try {
      step2Part3(smartHome); // uses smarthome object from part 1
    } catch(Exception e) {
      System.out.println("An error ocured. You have enterd an index that dosen't exist");
    }
    try {
      step2Part4(smartHome); // uses smarthome object from part 1
    } catch(Exception e) {
      System.out.println("An error ocured. You have enterd an location that dosen't exist");
    }
    try {
      step2Part5(smartHome); // uses smarthome object from part 1
    } catch(Exception e) {
      System.out.println("An error ocured. You have enterd an location that dosen't exist");
    }
  }

  public static SmartHome step2Part1(){
    // set up array
    System.out.println("Input max number of devices:");
    Scanner input = new Scanner(System.in);
    int userNumDevice = input.nextInt();
    SmartHome smartHome = new SmartHome(userNumDevice);
    // input data
    for (int i = 0;i<userNumDevice;i++) {
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
      smartHome.insertDevice(device);
    }
    // output data
    System.out.println(smartHome.toString());
    return smartHome;
  }

  public static void step2Part2(){
    // set up array
    System.out.println("Input max number of devices:");
    Scanner input = new Scanner(System.in);
    int userNumDevice2 = input.nextInt();
    SmartDevice[] smartDevicesIn = new SmartDevice[userNumDevice2];

    // input data
    for (int i = 0;i<userNumDevice2;i++) {
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
      smartDevicesIn[i] = device;
    }
    SmartHome secondSmartHome = new SmartHome(smartDevicesIn);
    // output data
    System.out.println(secondSmartHome.toString());
  }

  // This task is unclear and has been compleated to the best of my understanding
  public static void step2Part3(SmartHome smartHome){
    System.out.println("Input index to change power status:");
    Scanner input = new Scanner(System.in);
    int userDeviceIndex = input.nextInt();
    SmartDevice device = smartHome.getDevice(userDeviceIndex);
    if (device.isSwitchedOn()){
      device.switchOff();
    } else {
      device.switchOn();
    }

    System.out.println(smartHome.toString());


  }

  // This task is unclear and has been compleated to the best of my understanding
  public static void step2Part4(SmartHome smartHome){
    System.out.println("Input location to change power status:");
    Scanner input = new Scanner(System.in);
    double userDeviceLocation = input.nextDouble();
    int deviceNumber = smartHome.getDeviceNumber(userDeviceLocation);
    SmartDevice device = smartHome.getDevice(deviceNumber-1);
    if (device.isSwitchedOn()){
      device.switchOff();
    } else {
      device.switchOn();
    }
    System.out.println(smartHome.toString());

  }

  public static void step2Part5(SmartHome smartHome){
    System.out.println("Input location to change power status:");
    Scanner input = new Scanner(System.in);
    double userDeviceLocation = input.nextDouble();
    smartHome.toggle(userDeviceLocation);
    // output data only shows changed device using get device method
    int deviceNumber = smartHome.getDeviceNumber(userDeviceLocation);
    SmartDevice device = smartHome.getDevice(deviceNumber-1);
    System.out.println(smartHome.toString());

  }
}
