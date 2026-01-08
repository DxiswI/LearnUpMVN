package org.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

class GameTest {

    @Test
    void testGreenLightZeroSpeed() {
        Game.setGreenLight(true);
        Assertions.assertFalse(Game.isPlayerOut(0));
    }

    @Test
    void testGreenLightNonZeroSpeed() {
        Game.setGreenLight(true);
        Assertions.assertFalse(Game.isPlayerOut(5));
        Assertions.assertFalse(Game.isPlayerOut(10));
    }

    @Test
    void testRedLightZeroSpeed() {
        Game.setGreenLight(false);
        Assertions.assertFalse(Game.isPlayerOut(0));
    }

    @Test
    void testRedLightNonZeroSpeed() {
        Game.setGreenLight(false);
        Assertions.assertTrue(Game.isPlayerOut(5));
        Assertions.assertTrue(Game.isPlayerOut(1));
    }

    @Test
    void testRedLightEdgeCases() {
        Game.setGreenLight(false);
        Assertions.assertTrue(Game.isPlayerOut(1));
        Assertions.assertTrue(Game.isPlayerOut(100));
        Assertions.assertTrue(Game.isPlayerOut(Integer.MAX_VALUE));
    }

    @Test
    void testGreenLightEdgeCases() {
        Game.setGreenLight(true);
        Assertions.assertFalse(Game.isPlayerOut(1));
        Assertions.assertFalse(Game.isPlayerOut(100));
        Assertions.assertFalse(Game.isPlayerOut(Integer.MAX_VALUE));
    }

    @Test
    void testLightSwitching() {
        Game.setGreenLight(true);
        Assertions.assertFalse(Game.isPlayerOut(5));

        Game.setGreenLight(false);
        Assertions.assertTrue(Game.isPlayerOut(5));

        Game.setGreenLight(true);
        Assertions.assertFalse(Game.isPlayerOut(5));
    }
    @Test
    void testCountEliminatedPlayers() {
        Game.setGreenLight(false);
        int[] speeds = {5, 0, 2};
        assertEquals(2, Game.countEliminatedPlayers(speeds));
    }

    @Test
    void testGetEliminatedSpeeds() {
        Game.setGreenLight(false);
        int[] speeds = {5, 0, 2};
        int[] expected = {5, 2};
        assertArrayEquals(expected, Game.getEliminatedSpeeds(speeds));
    }

    @Test
    void testGetSurvivedSpeeds() {
        Game.setGreenLight(false);
        int[] speeds = {5, 0, 2};
        int[] expected = {0};
        assertArrayEquals(expected, Game.getSurvivedSpeeds(speeds));
    }
}