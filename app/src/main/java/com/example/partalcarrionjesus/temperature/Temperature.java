package com.example.partalcarrionjesus.temperature;

public class Temperature {
    private double temperature;

    public Temperature(){}

    public void setTemperature(double t) {
        this.temperature = t;
    }

    public double getTemperature(){
        return this.temperature;
    }

    public String toCelsius() {
        double celsius = ((temperature - 32)*5)/9;
        return Double.toString(celsius);
    }

    public String toFahrenheit() {
        double fahrenheit = ((9.0/5.0) * temperature) + 32;
        return Double.toString(fahrenheit);
    }


}
