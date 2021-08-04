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
        @SneakyThrows
        public void run(){
            Thread.sleep(7000);
            printTextOnLogger("Thread 1 is using the logger");

        }
    }

    public static class ThreadTwo extends Thread{
        @SneakyThrows
        public void run(){
            try {
                Thread.sleep(3000);
                printTextOnLogger("Thread 2 is using the logger");
            } catch (Exception e) {

                throw new Exception(e.getMessage());
            }
        }
    }

    public static void main(String[] args) throws Exception {
        Thread[] threads = new Thread[]{new ThreadOne(), new ThreadTwo()};
        for(Thread thread : threads) {
            thread.start();
        }
        for(Thread threadd : threads) {
            threadd.join();
        }
        log.info("Both threads have finished");

    }
}