import navalclash.Clash;

import java.util.Iterator;
import java.util.Objects;
import java.util.Scanner;

public class Main {
    // Расстановка кораблей вручную
    private static void placement(Clash player) {
        Scanner in = new Scanner(System.in);
        int[] ships = {4, 3, 2, 1};
        for (int i = 0; i < ships.length; i++) {
            for (int j = 0; j < ships[i]; j++) {
                switch (i) {
                    case 0 -> {
                        System.out.println("Введите координаты однопалубника:");
                        System.out.print("X: ");
                        int x = Integer.parseInt(in.nextLine());
                        System.out.print("Y: ");
                        int y = Integer.parseInt(in.nextLine());
                        boolean success = false;
                        while (!success) {
                            success = player.set_ships(1, x - 1, y - 1, "left");
                        }
                        player.show_boards();
                    }
                    case 1 -> {
                        System.out.println("Введите координаты двухпалубника:");
                        System.out.print("X: ");
                        int x = Integer.parseInt(in.nextLine());
                        System.out.print("Y: ");
                        int y = Integer.parseInt(in.nextLine());
                        System.out.print("Введите направление: ");
                        String direction = in.nextLine();
                        boolean success = false;
                        while (!success) {
                            success = player.set_ships(2, x - 1, y - 1, direction);
                        }
                        player.show_boards();
                    }
                    case 2 -> {
                        System.out.println("Введите координаты трехпалубника:");
                        System.out.print("X: ");
                        int x = Integer.parseInt(in.nextLine());
                        System.out.print("Y: ");
                        int y = Integer.parseInt(in.nextLine());
                        System.out.print("Введите направление: ");
                        String direction = in.nextLine();
                        boolean success = false;
                        while (!success) {
                            success = player.set_ships(3, x - 1, y - 1, direction);
                        }
                        player.show_boards();
                    }
                    case 3 -> {
                        System.out.println("Введите координаты четырехпалубника:");
                        System.out.print("X: ");
                        int x = Integer.parseInt(in.nextLine());
                        System.out.print("Y: ");
                        int y = Integer.parseInt(in.nextLine());
                        System.out.print("Введите направление: ");
                        String direction = in.nextLine();
                        boolean success = false;
                        while (!success) {
                            success = player.set_ships(4, x - 1, y - 1, direction);
                        }
                        player.show_boards();
                    }
                }
            }
        }

    }
    public static void main(String[] args) {
        System.out.println("                    Морской бой");
        System.out.println();

        // Инициализация
        boolean running = true;
        Scanner in = new Scanner(System.in);
        Clash player = new Clash();
        Clash enemy = new Clash();

        // Главный цикл
        while (running) {
            // Начальные настройки
            player.show_boards();
            System.out.println("Хотели бы вы сами выставить корабли? ");
            String auto = in.nextLine();
            if (Objects.equals(auto.toLowerCase(), "да")) {
                placement(player);
            } else {
                player.random();
            }
            enemy.random();
            player.show_boards();

            // Игра
            while (!player.is_finished() | !enemy.is_finished()) {
                // TODO: доделать основной цикл
                break;
            }

            // Конец игры
            System.out.println("Хотели бы вы сыграть еще раз? ");
            String cont = in.nextLine();
            if (!cont.equalsIgnoreCase("да")) {
                running = false;
            }
        }
    }
}