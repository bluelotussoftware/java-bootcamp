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
package com.bluelotussoftware.module5.formatting;

import java.awt.Color;

/**
 *
 * @author John Yeary
 * @version 1.0
 */
public class Tester {

    public static void main(String... args) throws InterruptedException {

        int age = 11;
        String s = "football.";
        String m = "Mary";
        String h = "had";
        String a = " a";
        String l = "little";
        String la = "lamb";
        Color c = new Color(255, 255, 255);
        double money = 1_000_000;

        System.out.println(String.format("Ethan, my %0$d yo son likes to play %1s", age, s));
        System.out.println(String.format("%s %1s %2s %3s %4s whose fleece was %5s as snow.", m, h, a, l, la, c));
        Thread.sleep(2000);
        String o = String.format("Just kidding... %s %1s %2s %3s %4s whose fleece was %5s as snow.", m, h, a, l, la, "white");
        System.out.println(o);
        String moneyFormatted = String.format("$%,.2f", money);
        System.out.println(String.format("Big Money: %s USD", moneyFormatted));// Formatted twice.

    }
}
