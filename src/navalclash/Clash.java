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
        System.out.println("       Ваша доска               Доска сопеника");
        System.out.println("   A B C D E F G H I J       A B C D E F G H I J");
        for (int i = 0; i < player_board.length; i++) {
            for (int j = 0; j < player_board[i].length; j++) {
                if (j == 0)
                    if (i == 9) {
                        System.out.printf("%d ", i + 1);
                    } else {
                        System.out.printf("%d  ", i + 1);
                    }
                switch (player_board[i][j]) {
                    case 0 -> {
                        System.out.print("- ");
                    }
                    case 1 -> {
                        System.out.print("■ ");
                    }
                    case 2 -> {
                        System.out.print("X ");
                    }
                }
                if (j == 9) {
                    System.out.print("   ");
                    for (int g = 0; g < enemy_board[i].length; g++) {
                        if (g == 0)
                            if (i == 9) {
                                System.out.printf("%d ", i + 1);
                            } else {
                                System.out.printf("%d  ", i + 1);
                            }
                        switch (enemy_board[i][g]) {
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
                }
            }
            System.out.println();
        }
        System.out.println();
    }

    // Проверка валидности индекса
    private boolean is_valid_index(int[] arr, int index) {
        try {
            int i = arr[index];
        } catch (IndexOutOfBoundsException e) {
            return false;
        }
        return true;
    }

    // Проверка валидности границ
    private boolean check_borders(int n, int x, int y, String direction) {
        if (n == 1) {
            try {
                if (player_board[y - 1][x] == 1){
                    return true;
                }
            } catch (ArrayIndexOutOfBoundsException ignore) {
            }
            try {
                if (player_board[y + 1][x] == 1){
                    return true;
                }
            } catch (ArrayIndexOutOfBoundsException ignore) {
            }
            try {
                if (player_board[y][x + 1] == 1){
                    return true;
                }
            } catch (ArrayIndexOutOfBoundsException ignore) {
            }
            try {
                if (player_board[y][x - 1] == 1){
                    return true;
                }
            } catch (ArrayIndexOutOfBoundsException ignore) {
            }
            return false;
        }
        switch (direction) {
            case "left" -> {
                if (!is_valid_index(player_board[y], x - n - 1)) {
                    return true;
                }
                for (int i = x; i >= x - (n - 1); i--) {
                    if (player_board[y][i] == 1) {
                        return true;
                    }
                    try {
                        if (player_board[y + 1][i] == 1) {
                            return true;
                        }
                    } catch (ArrayIndexOutOfBoundsException ignore) {
                    }
                    try {
                        if (player_board[y - 1][i] == 1) {
                            return true;
                        }
                    } catch (ArrayIndexOutOfBoundsException ignore) {
                    }
                    try {
                        if (i == x) {
                            if (player_board[y][x + 1] == 1) {
                                return true;
                            }
                        }
                    } catch (ArrayIndexOutOfBoundsException ignore) {
                    }
                    try {
                        if (i == x - (n - 1)) {
                            if (player_board[y][x - 1] == 1) {
                                return true;
                            }
                        }
                    } catch (ArrayIndexOutOfBoundsException ignore) {
                    }
                }
            }
            case "right" -> {
                if (!is_valid_index(player_board[y], x + (n - 1))) {
                    return true;
                }
                for (int i = x; i <= x + (n - 1); i++) {
                    if (player_board[y][i] == 1) {
                        return true;
                    }
                    try {
                        if (player_board[y + 1][i] == 1) {
                            return true;
                        }
                    } catch (ArrayIndexOutOfBoundsException ignore) {
                    }
                    try {
                        if (player_board[y - 1][i] == 1) {
                            return true;
                        }
                    } catch (ArrayIndexOutOfBoundsException ignore) {
                    }
                    try {
                        if (i == x) {
                            if (player_board[y][x - 1] == 1) {
                                return true;
                            }
                        }
                    } catch (ArrayIndexOutOfBoundsException ignore) {
                    }
                    try {
                        if (i == x + (n - 1)) {
                            if (player_board[y][x + 1] == 1) {
                                return true;
                            }
                        }
                    } catch (ArrayIndexOutOfBoundsException ignore) {
                    }
                }
            }
            case "up" -> {
                try {
                    if (player_board[y - (n - 1)][x] == 1) {
                        return true;
                    }
                } catch (ArrayIndexOutOfBoundsException e) {
                    return true;
                }
                for (int i = y; i >= y - (n - 1); i--) {
                    if (player_board[i][x] == 1) {
                        return true;
                    }
                    try {
                       if (player_board[i][x - 1] == 1) {
                           return true;
                       }
                    } catch (ArrayIndexOutOfBoundsException ignore) {
                    }
                    try {
                        if (player_board[i][x + 1] == 1) {
                            return true;
                        }
                    } catch (ArrayIndexOutOfBoundsException ignore) {
                    }
                    try {
                        if (i == y) {
                            if (player_board[i + 1][x] == 1) {
                                return true;
                            }
                        }
                    } catch (ArrayIndexOutOfBoundsException ignore) {
                    }
                    try {
                        if (i == y - (n - 1)) {
                            if (player_board[i - 1][x] == 1) {
                                return true;
                            }
                        }
                    } catch (ArrayIndexOutOfBoundsException ignore) {
                    }
                }
            }
            case "down" -> {
                try {
                    if (player_board[y + (n - 1)][x] == 1) {
                        return true;
                    }
                } catch (ArrayIndexOutOfBoundsException e) {
                    return true;
                }
                for (int i = y; i <= y + (n - 1); i++) {
                    if (player_board[i][x] == 1) {
                        return true;
                    }
                    try {
                        if (player_board[i][x - 1] == 1) {
                            return true;
                        }
                    } catch (ArrayIndexOutOfBoundsException ignore) {
                    }
                    try {
                        if (player_board[i][x + 1] == 1) {
                            return true;
                        }
                    } catch (ArrayIndexOutOfBoundsException ignore) {
                    }
                    try {
                        if (i == y) {
                            if (player_board[i - 1][x] == 1) {
                                return true;
                            }
                        }
                    } catch (ArrayIndexOutOfBoundsException ignore) {
                    }
                    try {
                        if (i == y + (n - 1)) {
                            if (player_board[i + 1][x] == 1) {
                                return true;
                            }
                        }
                    } catch (ArrayIndexOutOfBoundsException ignore) {
                    }
                }
            }
        }
        return false;
    }

    // Расположение кораблей
    public boolean set_ships(int n, int x, int y, String direction) {
        switch (direction) {
            case "left" -> {
                if (check_borders(n, x, y, direction)) return false;
                for (int i = x; i >= x - (n - 1); i--) {
                    player_board[y][i] = 1;
                }
                return true;
            }
            case "right" -> {
                if (check_borders(n, x, y, direction)) return false;
                for (int i = x; i <= x + (n - 1); i++) {
                    player_board[y][i] = 1;
                }
                return true;
            }
            case "up" -> {
                if (check_borders(n, x, y, direction)) return false;
                for (int i = y; i >= y - (n - 1); i--) {
                    player_board[i][x] = 1;
                }
                return true;
            }
            case "down" -> {
                if (check_borders(n, x, y, direction)) return false;
                for (int i = y; i <= y + (n - 1); i++) {
                    player_board[i][x] = 1;
                }
                return true;
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
                    int x = (int) (Math.random() * 10);
                    int y = (int) (Math.random() * 10);
                    String direction = s[(int) (Math.random() * 4)];
                    /* Логи
                    System.out.println(i);
                    System.out.println(x);
                    System.out.println(y);
                    System.out.println(direction);
                    */
                    success = set_ships(i + 1, x, y, direction);
                }
                show_boards();
            }
        }
    }

    // Ход
    public boolean move(Clash player, Clash enemy, int x, int y) {
        switch (enemy.player_board[x - 1][y - 1]) {
            case 0 -> {
                System.out.println("Вы промахнулись!");
                player.enemy_board[x - 1][y - 1] = 1;
                enemy.player_board[x - 1][y - 1] = 2;
                return false;
            }
            case 1 -> {
                System.out.println("Вы попали!");
                player.enemy_board[x - 1][y - 1] = 2;
                enemy.player_board[x - 1][y - 1] = 2;
                return true;
            }
            case 2 -> {
                System.out.println("Вы уже стреляли сюда, попробуйте еще раз");
                return move(player, enemy, x, y);
            }
        }
        return false;
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
