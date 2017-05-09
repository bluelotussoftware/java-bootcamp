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
package com.bluelotussoftware.module4.generics;

import java.util.concurrent.atomic.AtomicInteger;

/**
 *
 * @author John Yeary
 * @version 1.0
 */
public class Widget implements Comparable<Widget> {

    private static AtomicInteger counter = new AtomicInteger(0);
    private final int widgetNumber;

    public Widget() {
        widgetNumber = counter.incrementAndGet();
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 43 * hash + this.widgetNumber;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Widget other = (Widget) obj;
        if (this.widgetNumber != other.widgetNumber) {
            return false;
        }
        return true;
    }

    @Override
    public int compareTo(Widget o) {
        return Integer.compare(widgetNumber, o.getWidgetNumber());
    }

    public int getWidgetNumber() {
        return widgetNumber;
    }

    @Override
    public String toString() {
        return "Widget{" + "widgetNumber=" + widgetNumber + '}';
    }
    
    
}
