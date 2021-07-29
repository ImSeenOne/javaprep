package com.enroutesystems.atomicAPI;

import com.enroutesystems.keywordsExamples.Threads;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.atomic.AtomicInteger;

@Slf4j
public class AtomicAPI {

    static AtomicInteger atint = new AtomicInteger(50);
    static int val = 10;

    public static void changeValue(int value){
        AtomicAPI.atint.set(value);
    }

    static class TOne extends Thread{
        public void run(){
            log.info("Thread one set");
            changeValue(55);
        }
    }

    static class TTwo extends Thread{
        public void run(){
            log.info("Thread two set");
            changeValue(45);
        }
    }

    public static void main(String[] args) throws Exception {
        AtomicAPI.TOne t1 = new AtomicAPI.TOne();
        AtomicAPI.TTwo t2 = new AtomicAPI.TTwo();

        t1.start();
        t2.start();
    }
}


