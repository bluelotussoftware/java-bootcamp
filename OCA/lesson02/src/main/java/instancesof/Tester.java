/*
 *  Copyright 2009 John Yeary.
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
package instancesof;

import interfaces.IA;
import interfaces.IB;
import interfaces.IC;
import interfaces.ID;
import interfaces.InterfaceCollision;

/**
 *
 * @author John Yeary
 * @version 1.0
 */
public class Tester {

    static InterfaceCollision xFactor;//<-- This is null

    public static void main(String[] args) {
        ID id = new InterfaceCollision();

        if (id instanceof IA) {
            ((IA) id).doSomething();
        }

        if (id instanceof IB) {
            ((IB) id).doSomething();
        }

        if (id instanceof IC) {
            ((IC) id).doSomethingElse();
        }

        if (id instanceof ID) {
            id.doSomething();
        }

        if (null instanceof InterfaceCollision) {
            System.out.println("Oh my gossshh...Nemo is swimming out to sea.");
        } else {
            System.out.println("I know funny. I am a clown fish!");
        }

        if (xFactor instanceof InterfaceCollision) {// <--- I expect an explosion
            System.out.println("SUCCESS... We have created a monster.");
        } else {
            System.out.println("SUCCESS... I am as skinny as a null");
        }
    }
}
