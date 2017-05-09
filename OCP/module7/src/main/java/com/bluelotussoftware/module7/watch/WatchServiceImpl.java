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
package com.bluelotussoftware.module7.watch;

import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.nio.file.Paths;
import static java.nio.file.StandardWatchEventKinds.*;
import java.nio.file.WatchEvent;
import java.nio.file.WatchKey;
import java.nio.file.WatchService;
import java.util.Arrays;
import java.util.concurrent.Callable;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 *
 * @author John Yeary
 * @version 1.0
 */
public class WatchServiceImpl {

    public static void main(String... args) throws IOException {
        if (args.length == 0) {
//            System.err.println("You need to pass at least one argument.");
//            System.exit(-1);
            args = new String[]{"target/"};
        }

        Path target;
        if (args.length > 1) {
            target = Paths.get(args[0], Arrays.copyOfRange(args, 1, args.length - 1));
        } else {
            target = Paths.get(args[0]);
        }
        
        WatchService watchService = FileSystems.getDefault().newWatchService();
        target.register(watchService, ENTRY_CREATE, ENTRY_DELETE, ENTRY_MODIFY, OVERFLOW);
        runWatchService(watchService, 60, TimeUnit.SECONDS);

    }

    public static void runWatchService(final WatchService service, final long timeout, final TimeUnit timeUnit) {

        final ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(2);

        final Future<Void> future = scheduledExecutorService.submit(new Callable<Void>() {
            @Override
            public Void call() throws Exception {

                System.out.println("Running WatchService...");
                WatchKey watchKey;

                try {
                    watchKey = service.take();
                } catch (InterruptedException ex) {
                    return null;
                }

                while (!Thread.interrupted()) {
                    for (WatchEvent<?> event : watchKey.pollEvents()) {
                        WatchEvent.Kind<?> kind = event.kind();
                        WatchEvent<Path> watchEvent = (WatchEvent<Path>) event;
                        Path filename = watchEvent.context();
                        System.out.println("File Name: " + filename);

                        switch (kind.name()) {
                            case "ENTRY_CREATE": {
                                System.out.println(filename + " created!");
                                break;
                            }
                            case "ENTRY_MODIFY": {
                                System.out.println(filename + " modified!");
                                break;
                            }
                            case "ENTRY_DELETE": {
                                System.out.println(filename + " deleted!");
                                break;
                            }
                            case "OVERFLOW": {
                                System.out.println("Events may have been lost");
                                break;
                            }
                        }
                    }
                    watchKey.reset();
                }
                return null;
            }
        });

        // Schedule another job to cancel our currenly running job and shutdown Executor.
        scheduledExecutorService.schedule(new Runnable() {
            @Override
            public void run() {
                future.cancel(true);
                scheduledExecutorService.shutdown();
                System.out.println("WatchService Shutdown.");
            }
        }, timeout, timeUnit);
    }
}
