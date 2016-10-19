package ru.ulmc;

public class CityPair {
    private City firstCity;
    private City secondCity;

    public CityPair(City firstCity, City secondCity) {
        this.firstCity = firstCity;
        this.secondCity = secondCity;
    }

    public boolean checkPair(City fCity, City sCity) {
        return firstCity.equals(fCity) && secondCity.equals(sCity);
    }

    public City getFirstCity() {
        return firstCity;
    }

    public void setFirstCity(City firstCity) {
        this.firstCity = firstCity;
    }

    public City getSecondCity() {
        return secondCity;
    }

    public void setSecondCity(City secondCity) {
        this.secondCity = secondCity;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CityPair cityPair = (CityPair) o;

        if (firstCity != null ? !firstCity.equals(cityPair.firstCity) : cityPair.firstCity != null) return false;
        return secondCity != null ? secondCity.equals(cityPair.secondCity) : cityPair.secondCity == null;

    }

    @Override
    public int hashCode() {
        int result = firstCity != null ? firstCity.hashCode() : 0;
        result = 31 * result + (secondCity != null ? secondCity.hashCode() : 0);
        return result;
    }
}
