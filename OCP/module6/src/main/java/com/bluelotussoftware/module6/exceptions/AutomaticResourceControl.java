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
package com.bluelotussoftware.module6.exceptions;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.ClosedChannelException;
import java.nio.channels.FileChannel;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author John Yeary
 * @version 1.0
 */
public class AutomaticResourceControl {

    public static final int MEGABYTE = 1024 * 1024;

    public static void main(String[] args) {

        File file = null;
        try {
            file = File.createTempFile("temp__", ".txt");
            file.createNewFile();
            System.out.println("Don't Taze me bro!!!");
        } catch (IOException ex) {
            Logger.getLogger(AutomaticResourceControl.class.getName()).log(Level.SEVERE, null, ex);
        }

        try (final FileInputStream fis = new FileInputStream(file);
                FileChannel fc = fis.getChannel();) {

            long fileSize = fc.size();
            System.out.println("Big Boy SIZE:" + fileSize);
            long bytesRead = 0L;
            ByteBuffer bb;

            bb = ByteBuffer.allocate((10 * MEGABYTE));


            while (bytesRead < fileSize) {
                System.out.println("Vrrrrrmmmmmmm....");
                bytesRead += fc.read(bb);
                bb.flip();
                bb.clear();
            }
            
            throw new DontTazeMeBroException("Zaaap!");
        } catch (IllegalArgumentException | ClosedChannelException | FileNotFoundException ex) {
            Logger.getLogger(AutomaticResourceControl.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(AutomaticResourceControl.class.getName()).log(Level.SEVERE, "I gotz ta know!", ex);
        }
    }
    
    static class DontTazeMeBroException extends IOException{
        public DontTazeMeBroException(String s) {
            super(s);
        }
    }
}
