package com.example.weatherapp;

public class CitySettingModel {
    boolean WindSw = false, HumiditySw = false, PressureSw = false;
    String cityName = "City";

    private static  CitySettingModel instance;
    public static CitySettingModel getInstance(){
        instance = instance == null ? new CitySettingModel() : instance;
        return instance;
    }

    public boolean isWindSw() {
        return WindSw;
    }

    public void setWindSw(boolean windSw) {
        WindSw = windSw;
    }

    public boolean isHumiditySw() {
        return HumiditySw;
    }

    public void setHumiditySw(boolean humiditySw) {
        HumiditySw = humiditySw;
    }

    public boolean isPressureSw() {
        return PressureSw;
    }

    public void setPressureSw(boolean pressureSw) {
        PressureSw = pressureSw;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }
}
