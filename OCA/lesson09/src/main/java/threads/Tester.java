/*
 *  Copyright 2010 Blue Lotus Software, LLC.
 *  Copyright 2008-2010 John Yeary <jyeary@bluelotussoftware.com>.
 *
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 *  under the License.
 */
/*
 * $Id: Tester.java 10 2011-01-10 20:39:22Z jyeary $
 */
package threads;

/**
 *
 * @author John Yeary <jyeary@bluelotussoftware.com>
 * @version 1.0
 */
public class Tester {

    /**
     * @param args the command line arguments
     */
    @SuppressWarnings("static-access")
    public static void main(String[] args) {

        Thread thread = new Thread();
        thread.start();

        // Stop the Thread and show its state then re-start it.
//        thread.stop();
//        System.out.println(thread.getState());
//        thread.start();
//        thread.dumpStack();

        System.out.println("Thread ID: " + thread.getId());
        System.out.println("Thread Name: " + thread.getName());
        thread.currentThread().setPriority(Thread.MAX_PRIORITY);
        System.out.println("Thread Priority: " + thread.getPriority());

        // What is the default UncaughtExceptionHandler?
        Thread.UncaughtExceptionHandler uncaughtExceptionHandler = thread.getDefaultUncaughtExceptionHandler();
        if (uncaughtExceptionHandler != null) {
            System.out.println(uncaughtExceptionHandler.getClass().getName());
        } else {
            System.out.println("UncaughtExceptionHandler class was null");
        }


        Runnable runner = new Runnable() {

            public void run() {
                new Thread(new Runnable() {

                    public void run() {
                        new Thread(new Runnable() {

                            public void run() {
                                new Thread(new Runnable() {

                                    public void run() {
                                        System.out.println("I am a deeply nested runnable called... " + this.getClass().getName());
                                    }
                                }).start();
                            }
                        }).start();
                    }
                }).start();
            }
        };
        new Thread(runner).start();

        // Run the profiler on the method below to show effects.
//        new Thread(new Tester().new Runner()).start();
    }

    class Runner implements Runnable {

        public void run() {
            Thread t = new Thread(new Runner());
            t.start();
            System.out.println("Thread ID: " + t.getId() + "created.");
        }
    }
}
