/*
 * Copyright 2012 John Yeary.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.bluelotussoftware.factorypattern;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 *
 * @author John Yeary
 * @version 1.0
 */
public class App {

    public static void main(String[] args) throws InterruptedException {
        Creator<Amoeba> creator = new AmoebaCreator();
        Creator<Protozoan> c2 = new Creator<Protozoan>() {
            @Override
            public Protozoan create() {
                return new Protozoan();
            }
        };

        final Amoeba a1 = creator.create();
        Amoeba a2 = a1.replicate();
        Amoeba a3 = a1.replicate();

        System.out.println(a1);
        System.out.println(a2);
        System.out.println(a3);

        System.out.println(c2.create());

        for (int i = 0; i < 10; i++) {
            System.out.println(new ProtozoanCreator().create());
        }

        final Random r = new Random();

        ExecutorService pool = Executors.newFixedThreadPool(10);

        int ctr = 0;
        while (ctr++ < 100) {
            pool.submit(new Runnable() {
                @Override
                public void run() {
                    switch (r.nextInt(3)) {
                        case 0: {
                            System.out.println(a1.replicate());
                            break;
                        }
                        case 1: {
                            System.out.println(new AmoebaCreator().create());
                            break;
                        }
                        case 2: {
                            System.out.println(new ProtozoanCreator().create());
                            break;
                        }
                    }
                }
            });
            Thread.sleep(r.nextInt(1000));
        }
    }
}
