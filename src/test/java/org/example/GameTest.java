package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GameTest {

    @Test
    void testGreenLightZeroSpeed() {
        Game.setGreenLight(true);
        Game.setMaxSpeed(0);
        assertFalse(Game.isPlayerOut(0));
    }

    @Test
    void testGreenLightNonZeroSpeed() {
        Game.setGreenLight(true);
        Game.setMaxSpeed(0);
        assertFalse(Game.isPlayerOut(5));
        assertFalse(Game.isPlayerOut(10));
    }

    @Test
    void testRedLightZeroSpeed() {
        Game.setGreenLight(false);
        Game.setMaxSpeed(0);
        assertFalse(Game.isPlayerOut(0));
    }

    @Test
    void testRedLightNonZeroSpeed() {
        Game.setGreenLight(false);
        Game.setMaxSpeed(0);
        assertTrue(Game.isPlayerOut(5));
        assertTrue(Game.isPlayerOut(1));
    }

    @Test
    void testRedLightEdgeCases() {
        Game.setGreenLight(false);
        Game.setMaxSpeed(0);
        assertTrue(Game.isPlayerOut(1));
        assertTrue(Game.isPlayerOut(100));
        assertTrue(Game.isPlayerOut(Integer.MAX_VALUE));
    }

    @Test
    void testGreenLightEdgeCases() {
        Game.setGreenLight(true);
        Game.setMaxSpeed(0);
        assertFalse(Game.isPlayerOut(1));
        assertFalse(Game.isPlayerOut(100));
        assertFalse(Game.isPlayerOut(Integer.MAX_VALUE));
    }

    @Test
    void testLightSwitching() {
        Game.setMaxSpeed(0);

        Game.setGreenLight(true);
        assertFalse(Game.isPlayerOut(5));

        Game.setGreenLight(false);
        assertTrue(Game.isPlayerOut(5));

        Game.setGreenLight(true);
        assertFalse(Game.isPlayerOut(5));
    }

    @Test
    void testCountEliminatedPlayers() {
        Game.setGreenLight(false);
        Game.setMaxSpeed(0);
        int[] speeds = {5, 0, 2};
        assertEquals(2, Game.countEliminatedPlayers(speeds));
    }

    @Test
    void testGetEliminatedSpeeds() {
        Game.setGreenLight(false);
        Game.setMaxSpeed(0);
        int[] speeds = {5, 0, 2};
        int[] expected = {5, 2};
        assertArrayEquals(expected, Game.getEliminatedSpeeds(speeds));
    }

    @Test
    void testGetSurvivedSpeeds() {
        Game.setGreenLight(false);
        Game.setMaxSpeed(0);
        int[] speeds = {5, 0, 2};
        int[] expected = {0};
        assertArrayEquals(expected, Game.getSurvivedSpeeds(speeds));
    }

    // НОВЫЕ ТЕСТЫ ДЛЯ maxSpeed
    @Test
    void testMaxSpeedZero() {
        Game.setGreenLight(false);
        Game.setMaxSpeed(0);
        assertTrue(Game.isPlayerOut(1));
        assertTrue(Game.isPlayerOut(10));
        assertTrue(Game.isPlayerOut(100));
        assertFalse(Game.isPlayerOut(0));
    }

    @Test
    void testMaxSpeedTen() {
        Game.setGreenLight(false);
        Game.setMaxSpeed(10);
        assertFalse(Game.isPlayerOut(0));
        assertFalse(Game.isPlayerOut(5));
        assertFalse(Game.isPlayerOut(10));
        assertTrue(Game.isPlayerOut(11));
        assertTrue(Game.isPlayerOut(20));
    }

    @Test
    void testMaxSpeedWithGreenLight() {
        Game.setGreenLight(true);
        Game.setMaxSpeed(0);
        assertFalse(Game.isPlayerOut(100));
    }

    @Test
    void testMaxSpeedChange() {
        Game.setGreenLight(false);

        Game.setMaxSpeed(5);
        assertFalse(Game.isPlayerOut(3));
        assertTrue(Game.isPlayerOut(7));

        Game.setMaxSpeed(20);
        assertFalse(Game.isPlayerOut(7));
        assertTrue(Game.isPlayerOut(25));
    }

    @Test
    void мойПервыйТест() {
        Game.setMaxSpeed(100);
        int result = Game.getMaxSpeed();
        assertEquals(100, result);
    }
    @Test
    void testMaxSpeed10Speed15() {
        Game.setGreenLight(false);
        Game.setMaxSpeed(10);
        boolean result = Game.isPlayerOut(15);
        assertTrue(result);
    }

    @Test
    void testCountEliminatedPlayersWithMaxSpeed() {
        Game.setGreenLight(false);
        Game.setMaxSpeed(5);

        int[] speeds = {3, 7, 0, 10, 5};
        assertEquals(2, Game.countEliminatedPlayers(speeds));
    }
}