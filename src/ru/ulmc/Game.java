package ru.ulmc;

import ru.ulmc.util.Timer;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by 45 on 16.10.2016.
 */
public class Game {
    private Set<City> cities = new HashSet<>();
    private Set<GameChain> chains = new HashSet<>();
    private Set<GameChain> historyChains = new HashSet<>();
    private Timer timer = new Timer();

    public Game(String... citiesNames) {
        for (String name : citiesNames) {
            cities.add(new City(name));
        }
    }

    public Game(Set<String> set) {
        for (String name : set) {
            cities.add(new City(name));
        }
    }


    public Game(String citiesStr) {
        String[] citiesNames = citiesStr.split(",");
        for (String name : citiesNames) {
            cities.add(new City(name.trim()));
        }
    }


    public void start() {
        timer.start();
        System.out.println("Построение начальных цепочек...");
        for (City city: cities) {
            GameChain chain = new GameChain(city);
            chains.add(chain);
        }
        boolean nextFound = true;
        while(nextFound) {
            System.out.println("Новая итерация поиска следующего звена для цепочек...");
            Set<GameChain> newChains = new HashSet<>();
            for (GameChain chain: chains) {
                for (City next: cities) {
                    if(chain.check(next)) {
                       // System.out.println("Найдено новое звено, ответвляемся и продолжаем дальнейший поиск:");
                        //chain.print();
                        newChains.add(chain.copyChain().addCity(next));
                    }
                }
            }

            nextFound = !newChains.isEmpty();
            if (nextFound) {
                historyChains.addAll(newChains);
                chains = newChains;
            }
        }
      //  chains.forEach(GameChain::print);
        int maxCount = 0;
        Set<GameChain> maxChains = new HashSet<>();
        for (GameChain chain : historyChains) {
            if (chain.getSize() > maxCount) {
                maxCount = chain.getSize();
                maxChains.clear();
                maxChains.add(chain);
            } else if (chain.getSize() == maxCount) {
                maxChains.add(chain);
            }
        }
        System.out.println("Максимально возможные комбинации: ");
        maxChains.forEach(GameChain::print);
        System.out.println("Chains count: " + maxChains.size());
        timer.stop();
    }

}
