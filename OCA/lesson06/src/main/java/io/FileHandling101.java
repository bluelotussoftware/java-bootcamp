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
 * $Id: FileHandling101.java 7 2011-01-10 20:37:04Z jyeary $
 */
package io;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;
import java.io.Writer;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Date;
import javax.tools.FileObject;
import javax.tools.SimpleJavaFileObject;

/**
 *
 * @author John Yeary <jyeary@bluelotussoftware.com>
 * @version 1.0
 */
public class FileHandling101 {

    public static void main(String... args) throws IOException, URISyntaxException {
        File f = new File("out.txt");
        f.createNewFile();
        System.out.println("f.exists() : " + f.exists());
        System.out.println(f.toURI().toString());
        System.out.println(new Date(f.lastModified()));
        URI uri = f.toURI();

        FileObject fileObject = new SimpleJavaFileObjectImpl(uri);
        
//        System.out.println(new Date(fileObject.getLastModified()));
//        Writer writer = fileObject.openWriter();
//        BufferedWriter buf = new BufferedWriter(writer);
//        buf.write("Hello World\n");
//        buf.write("I love Java Programming\n");
//        buf.flush();
//        buf.close();


        BufferedReader reader = new BufferedReader(fileObject.openReader(true));
        String s = null;
        while ((s = reader.readLine()) != null) {
            System.out.println(s);
        }
        reader.close();
        fileObject.delete();
        System.out.println("f.exists() : " + f.exists());
    }
}

class SimpleJavaFileObjectImpl extends SimpleJavaFileObject {

    public SimpleJavaFileObjectImpl(URI uri) {
        super(uri, SimpleJavaFileObject.Kind.OTHER);
    }
}
