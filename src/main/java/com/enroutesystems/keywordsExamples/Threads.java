/*throws Exception
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.enroutesystems.keywordsExamples;

import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Threads {

    public static synchronized void printTextOnLogger(String text){
        log.info(text);
    }

    public static class ThreadOne extends Thread{
        public void run(){
            printTextOnLogger("Thread 1 is using the logger");
        }
    }

    public static class ThreadTwo extends Thread{
        @SneakyThrows
        public void run(){
            try {
                printTextOnLogger("Thread 2 is using the logger");
            } catch (Exception e) {

                throw new Exception(e.getMessage());
            }
        }
    }

    public static void main(String[] args) throws Exception {
        ThreadOne t1 = new ThreadOne();
        ThreadTwo t2 = new ThreadTwo();

        t1.start();
        t2.start();
    }
    /**
     * 	Rest of words I couldn't know how to use: native transient volatile
     */
}