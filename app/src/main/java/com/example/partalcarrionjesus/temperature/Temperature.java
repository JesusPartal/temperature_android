package com.example.partalcarrionjesus.temperature;

public class Temperature {
    private double temperature;
    public Temperature(){

    }
    public void setTemperature(double t) {
        this.temperature = t;
    }

    public double getTemperature(){
        return this.temperature;
    }

    public double toCelsius() {
        return ((temperature - 32)*5)/9;
    }

    public double toFarenheit() {
        return (9/5) * temperature + 32;
    }


}
