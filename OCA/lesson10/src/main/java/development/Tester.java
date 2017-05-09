/*
 *  Copyright 2010-2011 Blue Lotus Software, LLC.
 *  Copyright 2008-2011 John Yeary <jyeary@bluelotussoftware.com>.
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
 * $Id: Tester.java 12 2011-02-02 01:29:13Z jyeary $
 */
package development;

import static java.lang.Math.PI;
import static java.lang.Math.E;
import static java.math.BigInteger.ONE;
//import static java.lang.Math.*;
import static java.lang.Math.abs;
import static java.lang.System.out;

/**
 *
 * @author John Yeary <jyeary@bluelotussoftware.com>
 * @version 1.0
 */
public class Tester {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        out.println(ONE.doubleValue() + PI);
        out.println(abs(-E));
        out.println(abs(-ONE.signum()));

        System.out.println(calculateAreaOfCircle(PI));
    }

    public static double calculateAreaOfCircle(double radius) {
        return PI * radius * radius;
    }
}
