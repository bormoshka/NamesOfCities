package ru.ulmc;

import java.util.*;

/**
 * Created by 45 on 16.10.2016.
 */
public class GameChain {
    private List<City> list = new LinkedList<>();
    private static int counter = 0;
    private int chainID = counter++;

    public GameChain(City city) {
        list.add(city);
    }

    public int getSize() {
        return list.size();
    }

    public GameChain(List<City> list) {
        this.list = list;
    }

    public boolean check(City city) {
        if(list.contains(city)) {
            return false;
        }
        if (city.canConnectTo(getLastCity())) {
            return true;
        }
        return false;
    }

    public GameChain addCity(City city) {
        list.add(city);
        return this;
    }

    protected GameChain copyChain() {
        List<City> copy = new LinkedList<>(list);
        return new GameChain(copy);
    }

    private City getLastCity() {
        return list.get(list.size()-1);
    }

    public void print() {
        String output = "GameChain (id: " + chainID + ", size: " + list.size() + ") : { \n";
        int level = 0;
        City prevCity = null;
        if (list.size() == 1) {
            output += list.get(0).getName() + "\n";
        } else {
            for (City city : list) {
                if (prevCity != null) {
                    output += offset(level++) + prevCity.getName() + " -> " + city.getName() + "\n";
                }
                prevCity = city;
            }
        }
        output += "} \n";
        System.out.println(output);
    }

    private static String offset(int level) {
        char[] offset = new char[level];
        for (int i = 0; i < level; i++) {
            offset[i] = ' ';
        }
        return new String(offset);
    }
}
