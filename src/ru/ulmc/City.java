package ru.ulmc;

/**
 * Created by 45 on 16.10.2016.
 */
public class City {
    private String name;
    private char firstLetter;
    private char lastLetter;

    public City(String name) {
        this.name = name;
        firstLetter = name.toLowerCase().charAt(0);
        lastLetter = getLastLetter(name.toLowerCase());
    }

    public boolean canConnectTo(City firstCity) {
        return firstCity.getLastLetter() == firstLetter &&
                !firstCity.getName().equals(getName());
    }

    public String getName() {
        return name;
    }

    public char getFirstLetter() {
        return firstLetter;
    }

    public char getLastLetter() {
        return lastLetter;
    }

    private char getLastLetter(String word) {
        int index = word.length()-1;
        char letter = word.charAt(index);
        while(letter == 'ь' || letter == 'ъ'/* || letter == 'ы'*/) {
            letter = word.charAt(--index);
        }
        return letter;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        City city = (City) o;

        return name != null ? name.equals(city.name) : city.name == null;

    }

    @Override
    public int hashCode() {
        return name != null ? name.hashCode() : 0;
    }
}
