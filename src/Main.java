import navalclash.Clash;

import java.util.Objects;
import java.util.Scanner;

public class Main {
    // Расстановка кораблей вручную
    private static void placement() {
        // TODO: сделать ручную расстановку
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
            player.show_boards();
            System.out.println("Хотели бы вы сами выставить корабли? ");
            String auto = in.nextLine();
            if (Objects.equals(auto.toLowerCase(), "да")) {
                placement();
            } else {
                player.random();
            }
            enemy.random();
            player.show_boards();
            running = false;
        }
    }
}