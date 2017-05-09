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
 * $Id: Tester.java 7 2011-01-10 20:37:04Z jyeary $
 */
package time;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.TimeZone;

/**
 *
 * @author John Yeary <jyeary@bluelotussoftware.com>
 * @version 1.0
 */
public class Tester {

    public static void main(String... args) throws InterruptedException {
        Date date = new Date();
        System.out.println("Current Date: " + date.toString());
        long start = date.getTime();
        Thread.sleep(2000);
        long end = System.currentTimeMillis();
        System.out.println("Elapsed Time:" + (end - start));
        date.setTime(start);
        System.out.println("setTime: " + date + " Actual Time: " + new Date());
        Calendar c = Calendar.getInstance();
        System.out.println("\n");
        System.out.println("Calendar: " + c);
        date = c.getTime();
        System.out.println("Current Calendar Date: " + date);
        c.roll(Calendar.MONTH, 1);
        date = c.getTime();
        System.out.println("\nNew Calendar Date: " + date);
        c.set(Calendar.DAY_OF_WEEK, 1);
        date = c.getTime();
        System.out.println("Revised Date: " + date);
        c = Calendar.getInstance(TimeZone.getTimeZone("CET"));
        date = c.getTime();
        System.out.println("Revised Date (CET): " + date); // What time should it be?
        System.out.println("Calendar Timezone: " + c.getTimeZone().getDisplayName());
        GregorianCalendar gc = (GregorianCalendar) Calendar.getInstance(TimeZone.getTimeZone("GMT"));
        System.out.println("Calendar Timezone: " + gc.getTimeZone().getDisplayName());
        System.out.println("Calendar Time: " + gc.get(Calendar.HOUR_OF_DAY) + ":" + gc.get(Calendar.MINUTE) + ":" + gc.get(Calendar.SECOND) + " " + gc.getTimeZone().getID());
        gc.roll(Calendar.MONTH, 1);
        gc.set(Calendar.DAY_OF_MONTH, 32);
        System.out.println(gc.getTime().toString());
        gc.roll(Calendar.MONTH, 1);
        System.out.println(gc.getTime().toString());
        gc.roll(Calendar.MONTH, 1);
        System.out.println(gc.getTime().toString());
        gc.roll(Calendar.MONTH, 1);
        System.out.println(gc.getTime().toString());
        System.out.println("\n" + gc.toString());
    }
}
