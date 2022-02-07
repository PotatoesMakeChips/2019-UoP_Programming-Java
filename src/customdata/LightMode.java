package customdata;

public class LightMode {
  private String mode;
  private String[] validModes = {"NIGHT_MODE", "SOFT_MODE", "STANDARD_MODE"};

  public LightMode(){
    mode = validModes[2];
  }
  public int setMode(int modeIn){
    try {
      mode = validModes[modeIn];
      return 0;
    } catch (Exception e) {
      mode = mode;
      return 1;
    }
  }

  public String getMode(){
    return mode;
  }

  public String getValidModes(){
    return validModes.toString();
  }
}
