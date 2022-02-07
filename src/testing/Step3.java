package testing;
import java.util.Scanner;
import smarthome.*;
import smartdevice.*;

class Step3 {
  public static void main(String[] args) {
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

    System.out.println("~ You are adding another device ~");
    System.out.println("Name this Device:");
    // .next is used because it works and .nextLine don't
    String nameIn = input.next(); // .next is datatype agnostic
    System.out.println("The Device Location Is:");
    double locationIn = input.nextDouble();
    System.out.println("true or false, is the device on?:");
    Boolean switchedOnIn = input.nextBoolean();
    SmartDevice device = new SmartDevice(nameIn,locationIn,switchedOnIn);
    smartHome.addDevice(device);

    System.out.println(smartHome.toString());

    System.out.println("Select a room to toggle all devices");
    double roomIn = input.nextDouble();
    smartHome.setAllInRoom(roomIn);

    System.out.println(smartHome.toString());

    System.out.println("~ shuting down ~");
    smartHome.shutdown();

    System.out.println(smartHome.toString());

  }
}
