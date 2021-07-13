package com.enroutesystems;

import java.util.Random;

public interface IAnimal {
    public String eat(boolean isEating);
    public String breathe(boolean isBreathing);
    public default byte generateByte() {
        Random r = new Random();

        String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz+/*?$&#123456789";
        byte sign = (byte) 'E';
        try {
            for (int i = 0; i < 51; i++) {
                sign += alphabet.charAt(r.nextInt(alphabet.length()));
                if(i == 50) {
                    break;
                }
            }
        } catch (Error e) {
            System.err.println(e);
        } finally {
            System.out.println("Signature process was initialized.");
        }
        return sign;
    }

    public void kill();

}
