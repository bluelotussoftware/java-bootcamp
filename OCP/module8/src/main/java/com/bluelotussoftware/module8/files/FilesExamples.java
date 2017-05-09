/*
 * Copyright 2012 Blue Lotus Software, LLC.
 * Copyright 2012 John Yeary
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
/*
 * $Id$
 */
package com.bluelotussoftware.module8.files;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.FileStore;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.NoSuchFileException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.nio.file.attribute.FileTime;
import java.nio.file.attribute.GroupPrincipal;
import java.nio.file.attribute.PosixFileAttributeView;
import java.nio.file.attribute.PosixFileAttributes;
import java.nio.file.attribute.PosixFilePermission;
import java.nio.file.attribute.PosixFilePermissions;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;

/**
 *
 * @author John Yeary
 * @version 1.0
 */
public class FilesExamples {

    public static void main(String... args) throws IOException {

        Path pxe = Paths.get("target/", "module8-1.0-SNAPSHOT.jar");

        if (Files.exists(pxe, LinkOption.NOFOLLOW_LINKS)) {

            boolean isRegularExecutableFile = Files.isRegularFile(pxe)
                    & Files.isReadable(pxe) & Files.isExecutable(pxe);
            System.out.println("isRegularExecutableFile: " + isRegularExecutableFile);
            System.out.println("Files.isRegularFile(pxe, LinkOption.NOFOLLOW_LINKS): "
                    + Files.isRegularFile(pxe, LinkOption.NOFOLLOW_LINKS));
            System.out.println("Files.isReadable(pxe): " + Files.isReadable(pxe));

            Map<String, Object> attrs = Files.readAttributes(pxe, "*", LinkOption.NOFOLLOW_LINKS);
            for (String s : attrs.keySet()) {
                System.out.format("%s : %s%n", s, attrs.get(s));
            }

            Files.copy(pxe, pxe, StandardCopyOption.REPLACE_EXISTING);
            Files.copy(pxe, Paths.get(pxe.getName(0).toString(), "uber.jar"), StandardCopyOption.REPLACE_EXISTING);
            System.out.println("pxe exists? " + Files.exists(pxe, LinkOption.NOFOLLOW_LINKS));
            System.out.println("pxe lastModifiedTime: " + Files.getLastModifiedTime(pxe).toString());

            try {
                Files.delete(pxe);
            } catch (NoSuchFileException nsfe) {
                System.out.println(nsfe.getFile());
                System.out.println(nsfe.getMessage());
                System.out.println(nsfe.getCause());
                System.out.println(nsfe.getReason());
            } finally {
                Files.deleteIfExists(pxe);
                System.out.println("pxe exists? " + Files.exists(pxe));
            }

            try (BufferedOutputStream buffy = new BufferedOutputStream(new FileOutputStream(pxe.toFile()), 8192)) {
                Files.copy(Paths.get("target/uber.jar"), buffy);
            }
            System.out.println("pxe exists? " + Files.exists(pxe));

            Path infection = pxe;
            Path patient0 = Paths.get("target", "patient0");
            Files.move(infection, patient0, StandardCopyOption.ATOMIC_MOVE);

            PosixFileAttributeView pfv = Files.getFileAttributeView(patient0, PosixFileAttributeView.class, LinkOption.NOFOLLOW_LINKS);
            Set<PosixFilePermission> permissions = pfv.readAttributes().permissions();
            for (PosixFilePermission pfp : permissions) {
                System.out.println(pfp.name());
            }

            PosixFileAttributes attributes = Files.readAttributes(patient0, PosixFileAttributes.class);

            System.out.format("%s %s %s%n",
                    attributes.owner().getName(),
                    attributes.group().getName(),
                    PosixFilePermissions.toString(attributes.permissions()));

            // This group needs to exist on your system.
            GroupPrincipal group = patient0.getFileSystem().getUserPrincipalLookupService().lookupPrincipalByGroupName("_developer");
            System.out.println("Group: " + group.getName());
            Files.getFileAttributeView(patient0, PosixFileAttributeView.class).setGroup(group);
            attributes = Files.readAttributes(patient0, PosixFileAttributes.class);

            System.out.format("%s %s %s%n",
                    attributes.owner().getName(),
                    attributes.group().getName(),
                    PosixFilePermissions.toString(attributes.permissions()));


            Files.move(Paths.get("target", "uber.jar"), pxe, StandardCopyOption.REPLACE_EXISTING);

            //META-DATA
            System.out.format("Files.size(pxe): %d%n", Files.size(pxe));
            System.out.format("Files.isDirectory(pxe, LinkOption.NOFOLLOW_LINKS): %b%n", Files.isDirectory(pxe, LinkOption.NOFOLLOW_LINKS));
            System.out.format("Files.isHidden(pxe): %b%n", Files.isHidden(pxe));
            Files.copy(pxe, Paths.get("target", ".agent"), StandardCopyOption.REPLACE_EXISTING);
            System.out.format("Files.isHidden(.agent): %b%n", Files.isHidden(Paths.get("target", ".agent")));
            System.out.println("Files.getLastModifiedTime(pxe): " + Files.getLastModifiedTime(pxe));
            Files.setLastModifiedTime(pxe, FileTime.from(1L, TimeUnit.NANOSECONDS));
            System.out.println("Files.getLastModifiedTime(pxe): " + Files.getLastModifiedTime(pxe));
            System.out.format("Files.getOwner(pxe): %s%n", Files.getOwner(pxe));

            //File Storage
            FileStore store = Files.getFileStore(pxe);
            long totalSpace = store.getTotalSpace() / 1024;
            long usedSpace = (store.getTotalSpace() - store.getUnallocatedSpace()) / 1024;
            long usableSpace = store.getUsableSpace() / 1024;

            System.out.format("FileStore Data (bytes) total: %d  used: %d available: %d%n", totalSpace,usedSpace,usableSpace);
            
        } else {
            Path pox = Files.createTempFile("", "");
            System.out.println("pox exists? : " + Files.exists(pox));
            System.out.println("If you have pox... you need to do a clean build");
        }
    }
}
