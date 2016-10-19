package ru.ulmc;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.Stream;

public class Main {

    public static void main(String[] args) {
        //  Game game = new Game("Рига", "Париж", "Женева", "Амстердам", "Москва", "Санкт-Петербург", "Гамбург");
        //  game.start();

        String path = "C:\\doc.txt";//readFileLocation();
        Game hardGame;
        if (path == null) {
            hardGame = new Game("Рига, Армавир, Пуэрто-Рико, Ганалулу, Майами, Нью Йорк, Дюсельдорф, " +
                    "Кудрово, Всеволожск, Санкт-Петербург, Москва, Грозный, Лесной, Миасс, Алапаевск, Челябинск, Гаага," +
                    " Одесса, Осло, Тебриз, Шираз, Владикавказ, Ярославль, Астрахань, Аделаида, " +
                    "Петропавловск-Камчатский, Владивосток, Омск, Нальчик, Кировск, Запорожск, Анапа, Норильск, " +
                    "Алма-Аты, Тобольск, Ышиштх");
        } else {
            Set<String> cityNames = new HashSet<>();
            try (Stream<String> stream = Files.lines(Paths.get(path))) {
                stream.forEach(cityNames::add);
            } catch (IOException e) {
                e.printStackTrace();
            }
            hardGame = new Game(cityNames);
        }
        hardGame.start();
    }

    private static String readFileLocation() {
        Scanner scanner = new Scanner(System.in);
        String inputString = null;
        try {
            while (inputString == null) {
                System.out.print("Filename: ");
                inputString = scanner.nextLine();
            }
            return inputString;

        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return null;
    }
}
