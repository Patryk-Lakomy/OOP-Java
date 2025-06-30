package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class OcenkiTest {
@Test
        void pięćdziesiątdziewięctoF() {
    var ocenki = new Ocenki();
    assertEquals('f',ocenki.JakieOceny(59));
    }
    @Test
    void sześćdziesiątdziewięctoF() {
        var ocenki = new Ocenki();
        assertEquals('d',ocenki.JakieOceny(69));
    }
    @Test
    void piędziesiątdziewięctoF() {
        var ocenki = new Ocenki();
        assertEquals('c',ocenki.JakieOceny(79));
    }
    @Test
    void pćdziesiątdziewięctoF() {
        var ocenki = new Ocenki();
        assertEquals('b',ocenki.JakieOceny(89));
    }
    @Test
    void dziesiątdziewięctoF() {
        var ocenki = new Ocenki();
        assertEquals('a',ocenki.JakieOceny(99));
    }
    @Test
    void negative(){
    var ocenki=new Ocenki();
    assertThrows(IllegalArgumentException.class,() -> {
        ocenki.JakieOceny(-1);
    });
    }
}