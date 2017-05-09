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
 * $Id: Tester.java 7 2011-01-10 20:37:04Z jyeary $
 */
package formatters;

import java.text.DateFormat;
import java.text.NumberFormat;
import java.util.Date;
import java.util.Locale;

/**
 *
 * @author John Yeary <jyeary@bluelotussoftware.com>
 * @version 1.0
 */
public class Tester {

    public static void main(String... args) {
        DateFormat dfLongUs = DateFormat.getDateInstance(DateFormat.LONG, Locale.US);
        DateFormat dfLongCaFr = DateFormat.getDateInstance(DateFormat.LONG, Locale.CANADA_FRENCH);
        DateFormat dfLongJp = DateFormat.getDateInstance(DateFormat.LONG, Locale.JAPAN);

        NumberFormat nfUs = NumberFormat.getNumberInstance(Locale.US);
        NumberFormat nfCaFr = NumberFormat.getNumberInstance(Locale.CANADA_FRENCH);
        NumberFormat nfJp = NumberFormat.getNumberInstance(Locale.JAPAN);

        NumberFormat curUs = NumberFormat.getCurrencyInstance(Locale.US);
        NumberFormat curCaFr = NumberFormat.getCurrencyInstance(Locale.CANADA_FRENCH);
        NumberFormat curJp = NumberFormat.getCurrencyInstance(Locale.JAPAN);

        System.out.println("Date Formats:");
        System.out.println("Us: " + dfLongUs.format(new Date()));
        System.out.println("Ca_Fr: " + dfLongCaFr.format(new Date()));
        System.out.println("Jp: " + dfLongJp.format(new Date()));

        System.out.println("Number Formats:");
        System.out.println("Us: " + nfUs.format(1000000.25));
        System.out.println("Ca_Fr: " + nfCaFr.format(1000000.25));
        System.out.println("Jp: " + nfJp.format(1000000.25));

        System.out.println("Currency Formats:");
        System.out.println("Us: " + curUs.format(1000000.25));
        System.out.println("Ca_Fr: " + curCaFr.format(1000000.25));
        System.out.println("Jp: " + curJp.format(1000000.25));

        for (Locale l : Locale.getAvailableLocales()) {
            System.out.println(l.getCountry() + " -  " + l.getDisplayCountry());
            System.out.println(l.getLanguage() + " - " + l.getDisplayLanguage());
        }

    }
}
