/*
 *  Copyright 2010 Blue Lotus Software, LLC.
 *  Copyright 2010 John Yeary <jyeary@bluelotussoftware.com>.
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
 * $Id: ClassQuestionExample.java 4 2011-01-10 20:34:25Z jyeary $
 */
package scope;

/**
 *
 * @author John Yeary <jyeary@bluelotussoftware.com>
 * @version 1.0
 */
class ClassQuestionExample {

    public int run(boolean truth) {
        int x;
        if (truth) {
//            return x; // Compilation error! Why?
            return 0;
        } else {
            return 1;
        }
    }

    public int run() {
        int x;
        if (false) {
            return x; // No compilation error. Why?
        } else {
            return 1;
        }
    }

    public int run(String s) {
        int x; // No compilation error. Why?
        int y = 42;
        if (Boolean.valueOf(s)) {
            return y;
        } else {
            return Integer.MIN_VALUE;
        }
    }

    public static void main(String... args) {
        boolean b = false;
        String s = "true";
        System.out.println("run(b): " + new ClassQuestionExample().run(b));
        System.out.println("run(): " + new ClassQuestionExample().run());
        System.out.println("run(s): " + new ClassQuestionExample().run(s));
    }
}
