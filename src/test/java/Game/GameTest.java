package Game;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class GameTest {
    @Test
    public void testWhenFirstPlayerWin() {
        Player masha = new Player(1, "Маша", 78);
        Player rita = new Player(2, "Рита", 65);
        Game game = new Game();

        game.register(masha);
        game.register(rita);

        int expected = 1;
        int actual = game.round("Маша", "Рита");

        Assertions.assertEquals(expected, actual);

    }

    @Test
    public void testWhenSecondPlayerWin() {
        Player masha = new Player(1, "Маша", 54);
        Player rita = new Player(2, "Рита", 65);
        Game game = new Game();

        game.register(masha);
        game.register(rita);

        int expected = 2;
        int actual = game.round("Маша", "Рита");

        Assertions.assertEquals(expected, actual);

    }

    @Test
    public void testWhenNobodyPlayersWin() {
        Player masha = new Player(1, "Маша", 54);
        Player rita = new Player(2, "Рита", 54);
        Game game = new Game();

        game.register(masha);
        game.register(rita);

        int expected = 0;
        int actual = game.round("Маша", "Рита");

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void testWhenFirstPlayerIsNotExist() {
        Player masha = new Player(1, "Маша", 54);
        Player rita = new Player(2, "Рита", 54);
        Game game = new Game();

        game.register(masha);
        game.register(rita);


        Assertions.assertThrows(NotRegisteredException.class, () -> game.round("Аня", "Рита"));
    }

    @Test
    public void testWhenSecondPlayerIsNotExist() {
        Player masha = new Player(1, "Маша", 54);
        Player rita = new Player(2, "Рита", 54);
        Game game = new Game();

        game.register(masha);
        game.register(rita);


        Assertions.assertThrows(NotRegisteredException.class, () -> game.round("Маша", "Саша"));
    }
}