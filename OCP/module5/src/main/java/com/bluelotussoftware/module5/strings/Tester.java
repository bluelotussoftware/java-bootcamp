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
package com.bluelotussoftware.module5.strings;

/**
 *
 * @author John Yeary
 * @version 1.0
 */
public class Tester {

    public static void main(String... args) {

        String hello = "Hello" + " " + "World!";
        String hello1 = "Hello".concat(" ").concat("World!");
        String hello2 = new String("Hello").concat(" ").concat("World!");
        String hello3 = "Hello" + new String(" ") + "World!";
        String hello4 = "Hello World!";
        String hello5 = "";
        hello5 += "Hello";
        hello5 += " ";
        hello5 += "World!";


        System.out.println("hello == hello1 -> " + (hello == hello1));
        System.out.println("hello1 == hello2 -> " + (hello1 == hello2));
        System.out.println("hello2 == hello3 -> " + (hello2 == hello3));
        System.out.println("hello == hello4 -> " + (hello == hello4));

        hello3.intern();

        System.out.println("hello == hello3 -> " + (hello == hello3));
        System.out.println("hello2 == hello3 -> " + (hello2 == hello3));
        System.out.println("hello1 == hello4 -> " + (hello1 == hello4));
        System.out.println("hello2 == hello4 -> " + (hello2 == hello4));
        System.out.println("hello3 == hello4 -> " + (hello3 == hello4));
        System.out.println("hello == hello5 -> " + (hello == hello5));

        System.out.println("hello.equals(hello1) -> " + hello.equals(hello1));
        System.out.println("hello.equals(hello2) -> " + hello.equals(hello2));
        System.out.println("hello.equals(hello3) -> " + hello.equals(hello3));
        System.out.println("hello.equals(hello4) -> " + hello.equals(hello4));
        System.out.println("hello.equals(hello5) -> " + hello.equals(hello5));


        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("Hello");
        stringBuffer.append(" ");
        stringBuffer.append("World!");

        System.out.println("stringBuffer -> " + stringBuffer.toString());
        System.out.println("stringBuffer.toString() == hello -> " + (stringBuffer.toString() == hello));
        System.out.println("stringBuffer.toString().intern() == hello -> " + (stringBuffer.toString().intern() == hello));

        System.out.println(new StringBuffer("Hello").append(" ").append("World!").toString());

        System.out.println(new StringBuffer("Hello").append(" ").append("World!").toString() == new StringBuilder(stringBuffer.toString()).toString());
        System.out.println(new StringBuffer("Hello").append(" ").append("World!").toString().intern() == new StringBuilder(stringBuffer.toString()).toString());
        System.out.println(new StringBuffer("Hello").append(" ").append("World!").toString() == new StringBuilder(stringBuffer.toString()).toString().intern());
        System.out.println(new StringBuffer("Hello").append(" ").append("World!").toString().intern() == new StringBuilder(stringBuffer.toString()).toString().intern());

        System.out.println(stringBuffer.toString().subSequence(0, stringBuffer.length()).toString().replaceAll("World", "Mommy"));

        //CASE 1 - . matches a single character
        System.out.println(". -> " + hello.matches("."));
        System.out.println(". -> " + "A".matches("."));

        //CASE 2 - * matches any number of the previous characters
        System.out.println(".* - > " + hello.matches(".*"));
        System.out.println("ZZZA*ZZ -> " + "ZZZAZZ".matches("ZZZA*ZZ"));

        //CASE 3 - + matches one or more times
        System.out.println("AAA -> " + "AAA".matches("A+"));
        System.out.println("ACTGAACTGGA -> " + "ACTGAACTGGA".matches("A+"));
        System.out.println("ACTGAACTGGA -> " + "ACTGAACTGGA".matches(".*A+"));

        //CASE 4 - ? matchess once, or not at all
        System.out.println("AAA -> " + "AAA".matches("A?"));
        System.out.println("ATCG -> " + "ATCG".matches("A?.*"));

        //CASE 5 - \d matches digits
        System.out.println("192 -> " + "192".matches("\\d{3}"));
        System.out.println("451L ->" + "451L".matches("\\d"));

        //CASE 6 - \D matches not digits
        System.out.println("192 -> " + "192".matches("\\D{3}"));
        System.out.println("451L ->" + "451L".matches("\\D"));

        System.out.println(hello.matches("[Hh]\\w*\\s[Ww]orld\\W"));
        System.out.println(hello.matches("[Hh]\\w*\\s\\w*\\W"));
        System.out.println(hello.matches("^H\\w*\\s\\w*\\W"));
        System.out.println(hello.matches(".*\\W$"));
        System.out.println(hello.matches(".*\\w$"));
        System.out.println(hello.matches("\\D*"));
        System.out.println(hello.matches("\\d*"));
        System.out.println(hello.matches("H+\\w*\\w\\w*\\W"));
        System.out.println(hello.matches("\\b.*"));
        System.out.println(hello.matches(".*\\B"));



    }
}
