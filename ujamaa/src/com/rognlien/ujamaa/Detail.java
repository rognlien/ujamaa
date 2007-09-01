package com.rognlien.ujamaa;

public class Detail {
  private DetailType type;
  private String value;
  private String descrption;


  public DetailType getType() {
    return type;
  }
  public void setType(DetailType type) {
    this.type = type;
  }

  public String getValue() {
    return value;
  }
  public void setValue(String value) {
    this.value = value;
  }
  public String getDescrption() {
    return descrption;
  }
  public void setDescrption(String descrption) {
    this.descrption = descrption;
  }
}