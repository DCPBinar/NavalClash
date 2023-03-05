package navalclash;

public class Clash {
    int[][] player_board =
    {
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
    };

    int[][] enemy_board =
            {
                    {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                    {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                    {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                    {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                    {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                    {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                    {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                    {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                    {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                    {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            };
    

    // Отображение доски
    public void show_boards() {
        // TODO: переделать на ABC... и добавить отображение вражеской доски
        System.out.println("   1 2 3 4 5 6 7 8 9 10");
        for (int i = 0; i < player_board.length; i++) {
            for (int j = 0; j < player_board[i].length; j++) {
                if (j == 0)
                    System.out.printf("%d  ", i + 1);
                switch (player_board[i][j]) {
                    case 0 -> {
                        System.out.print("- ");
                    }
                    case 1 -> {
                        System.out.print("0 ");

                    }
                    case 2 -> {
                        System.out.print("X ");
                    }
                }
            }
            System.out.println();
        }
        System.out.println();
    }

    // Проверка валидности расположения
    private boolean check(int x, int y) {
        // TODO: доделать проверку
        return true;
    }

    // Расположение кораблей
    public boolean set_ships(int n, int x, int y, String direction) {
        // TODO: !возможно! переписать алгоритм позиционирования кораблей
        switch (direction) {
            case "left" -> {
                try {
                    for (int i = x - 1; i > n - (x - 1); i--) {
                        if (player_board[y][i] == 1){
                            return false;
                        }
                    }
                    for (int i = x - 1; i > n - (x - 1); i--) {
                        player_board[y][i] = 1;
                    }
                    return true;
                } catch (ArrayIndexOutOfBoundsException e) {
                    return false;
                }
            }
            case "right" -> {
                try {
                    for (int i = x - 1; i < n + (x - 1); i++) {
                        if (player_board[y][i] == 1) {
                            return false;
                        }
                    }
                    for (int i = x - 1; i < n + (x - 1); i++) {
                        player_board[y][i] = 1;
                    }
                    return true;
                } catch (ArrayIndexOutOfBoundsException e) {
                    return false;
                }
            }
            case "up" -> {
                try {
                    for (int i = y - 1; i > n - (y - 1); i--) {
                        if (player_board[i][x] == 1) {
                            return false;
                        }
                    }
                    for (int i = y - 1; i > n - (y - 1); i--) {
                        player_board[i][x] = 1;
                    }
                    return true;
                } catch (ArrayIndexOutOfBoundsException e) {
                    return false;
                }
            }
            case "down" -> {
                try {
                    for (int i = y - 1; i < n + (y - 1); i++) {
                        if (player_board[i][x] == 1) {
                            return false;
                        }
                    }
                    for (int i = y - 1; i < n + (y - 1); i++) {
                        player_board[i][x] = 1;
                    }
                    return true;
                } catch (ArrayIndexOutOfBoundsException e) {
                    return false;
                }
            }
        }
        return false;
    }

    // Случайная генерация поля
    public void random() {
        String[] s = {"left", "right", "up", "down"};
        int[] ships = {4, 3, 2, 1};
        for (int i = 0; i < ships.length; i++) {
            for (int j = 0; j < ships[i]; j++) {
                boolean success = false;
                while (!success) {
                    int x = (int) (Math.random() * 11);
                    int y = (int) (Math.random() * 11);
                    String direction = s[(int) (Math.random() * 4)];
                    /* Логи
                    System.out.println(i);
                    System.out.println(x);
                    System.out.println(y);
                    System.out.println(direction);
                    */
                    success = set_ships(i + 1, x, y, direction);
                }
            }
        }
        System.out.println("Finish");
    }

    // Ход
    public boolean move(Clash clash) {
        // TODO: сделать механику хода и отображение хода на всех досках
        return true;
    }

    // Проверка на конец игры
    public boolean is_finished() {
        for (int[] ints : player_board) {
            for (int anInt : ints) {
                if (anInt == 1) {
                    return false;
                }
            }
        }
        return true;
    }
}
