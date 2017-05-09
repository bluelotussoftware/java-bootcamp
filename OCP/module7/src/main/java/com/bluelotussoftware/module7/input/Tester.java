/*
 * Copyright 2012 Blue Lotus Software, LLC.
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
package com.bluelotussoftware.module7.input;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author John Yeary
 * @version 1.0
 */
public class Tester {

    public static void main(String... args) {
        System.out.println("Reading input from the console");
        InputStreamReader inputStreamReader = new InputStreamReader(System.in);
        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);

        try {
            String line;
            boolean result;

            do {
                line = bufferedReader.readLine();

                if (line != null && !line.isEmpty()) {
                    result = true;
                } else {
                    result = false;
                }

                if (result) {
                    System.out.println("The value you entered was: " + line);
                }
            } while (result);

        } catch (IOException ex) {
            Logger.getLogger(Tester.class.getName()).log(Level.SEVERE, "An exception occurred.", ex);
        }
    }
}
