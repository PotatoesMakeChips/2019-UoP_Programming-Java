package testing;
import java.util.Scanner;
import smarthome.*;
import smartdevice.*;

class Step4 {
  public static void main(String[] args) {
    // set up array
    System.out.println("Input max number of devices:");
    Scanner input = new Scanner(System.in);
    int userNumDevice = input.nextInt();
    SmartHome smartHome = new SmartHome(userNumDevice);
    // input data
    for (int i = 0;i<userNumDevice;i++) {
      System.out.println("Is this a fridge [true/false]:");
      Boolean isAFridge = input.nextBoolean();
      int deviceNumber = i + 1;
      if (isAFridge) {
        //fridge
        System.out.println("##DEVICE " + deviceNumber + "##");
        System.out.println("Name this Fridge:");
        // .next is used because it works and .nextLine don't
        String nameIn = input.next(); // .next is datatype agnostic
        System.out.println("The Fridge Location Is:");
        Double locationIn = input.nextDouble();
        System.out.println("The Fridge Temperature Is:");
        int fridgeTemp = input.nextInt();
        SmartFridge fridge = new SmartFridge(nameIn,locationIn,fridgeTemp);
        smartHome.insertDevice(fridge);
      } else {
        //not a fridge
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
    }
    // output data
    System.out.println(smartHome.toString());


    // second population method to a second object to avoid errors
    // set up array
    System.out.println("Input max number of devices:");
    int userNumDevice2 = input.nextInt();
    SmartDevice[] smartDevicesIn = new SmartDevice[userNumDevice];

    // input data
    for (int i = 0;i<userNumDevice2;i++) {
      System.out.println("Is this a fridge [true/false]:");
      Boolean isAFridge = input.nextBoolean();
      int deviceNumber = i + 1;
      if (isAFridge) {
        //fridge
        System.out.println("##DEVICE " + deviceNumber + "##");
        System.out.println("Name this Fridge:");
        // .next is used because it works and .nextLine don't
        String nameIn = input.next(); // .next is datatype agnostic
        System.out.println("The Fridge Location Is:");
        Double locationIn = input.nextDouble();
        System.out.println("The Fridge Temperature Is:");
        int fridgeTemp = input.nextInt();
        SmartFridge fridge = new SmartFridge(nameIn,locationIn,fridgeTemp);
        smartDevicesIn[i] = fridge;
      } else {
        //not a fridge
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
    }
    SmartHome secondSmartHome = new SmartHome(smartDevicesIn);
    // output data
    System.out.println(secondSmartHome.toString());


    //using first smartHome object
    smartHome.shutdown();
    System.out.println(smartHome.toString());
    try {
      System.out.println("Input device number of a fridge to change Temperature status:");
      int userDeviceNumber = input.nextInt();
      SmartDevice fridge = smartHome.getDevice(userDeviceNumber-1); // -1 converts device number to device index
      ((SmartFridge) fridge).increment(); // super class cant see child methods so have to cast to child

      System.out.println(smartHome.toString());


      ((SmartFridge) fridge).decrement(); // super class cant see child methods so have to cast to child

      System.out.println(smartHome.toString());

    } catch(Exception e) {
      System.out.println("An error ocured. Thats not a fridge");
    }

  }

}
