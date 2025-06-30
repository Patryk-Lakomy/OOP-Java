package org.example;

public class Ocenki {
    public char JakieOceny(int procent){
        if (procent<0){
            throw new IllegalArgumentException("pojebało?");
        } else if (procent<60) {
            return 'f';
        }
        else if (procent<70) {
            return 'd';
        }
        else if (procent<80) {
            return 'c';
        }
        else if (procent<90) {
            return 'b';
        }
        return 'a';
    }
}
