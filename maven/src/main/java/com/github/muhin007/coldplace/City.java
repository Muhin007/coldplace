package com.github.muhin007.coldplace;

class City {


    private String name;
    private int minTemperature;
    private int maxTemperature;

    City(String name, int minTemperature, int maxTemperature) {
        this.name = name;
        this.minTemperature = minTemperature;
        this.maxTemperature = maxTemperature;
    }
    public String getName() {        return name;    }

    public int getMinTemperature() {
        return minTemperature;
    }


    public int getMaxTemperature() {
        return maxTemperature;
    }

    City city = list.get(0);
    double d = (Math.abs(city.maxTemperature - city.minTemperature) * r.nextDouble()) + city.minTemperature;
    int i = (int) d;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        City city = (City) o;
        return name.equals(city.name);
    }

    @Override
    public int hashCode() {
        int result = name.hashCode();
        result = 31 * result + minTemperature;
        result = 31 * result + maxTemperature;
        return result;
    }

    public int calculateRandomTemperature() {
        return 0;
    }

