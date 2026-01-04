package com.zerofiltre.parkingbot.model;

public class Bicycle extends Vehicle{

  @Override
  public VehicleModelEnum getCategory() {
    return VehicleModelEnum.DEUX_ROUES;
  }

}
