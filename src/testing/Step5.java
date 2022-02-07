package testing;
import java.util.Scanner;
import smarthome.*;
import smartdevice.*;

class Step5 {
  public static void main(String[] args) {
    SmartHome smartHome = new SmartHome(7);
    System.out.println("Smart Devices are hardcoded for the following tests");


    SmartDevice computer = new SmartDevice("computer",1.1,true);
    smartHome.insertDevice(computer);
    SmartDevice tv = new SmartDevice("tv",2.1,true);
    smartHome.insertDevice(tv);
    SmartDevice hifi = new SmartDevice("hifi",2.2,false);
    smartHome.insertDevice(hifi);

    SmartFridge fridge = new SmartFridge("fridge",3.1,4);
    smartHome.insertDevice(fridge);
    SmartFridge minifridge = new SmartFridge("minifridge",1.2,4);
    smartHome.insertDevice(minifridge);

    SmartLamp deskLamp = new SmartLamp("deskLamp",1.3,true,1);
    smartHome.insertDevice(deskLamp);
    SmartLamp floorLamp = new SmartLamp("floorLamp",3.2,true,2);
    smartHome.insertDevice(floorLamp);

    System.out.println(smartHome.toString());

    try {
      System.out.println("Input device number of a lamp to change light mode:");
      Scanner input = new Scanner(System.in);
      int userDeviceNumber = input.nextInt();
      SmartDevice lamp = smartHome.getDevice(userDeviceNumber-1); // -1 converts device number to device index
      System.out.println("Select a lamp mode"+ "\n"+
      "0 = NIGHT_MODE" +
      "1 = SOFT_MODE"+
      "2 = STANDARD_MODE" + "\n" +
      ">>>");
      int userLampMode = input.nextInt();

      if (-1 < userLampMode && userLampMode < 3) {
        ((SmartLamp) lamp).setLampMode(userLampMode); // super class cant see child methods so have to cast to child

        System.out.println(smartHome.toString());
      } else {
        System.out.println("Invalid light mode. Valid light modes are between 0 and 2 (inclusive)");
      }


    } catch(Exception e) {
      System.out.println("An error ocured. Thats not a lamp or lamp mode");
    }
  }
}
