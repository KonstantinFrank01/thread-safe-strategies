package at.htl.volatilekeyword;

import java.util.ArrayList;
import java.util.List;

class ThreadDemo {

    public static void show() {
        final DownloadStatus status = new DownloadStatus();

        final Thread thread1 = new Thread(new DownloadFileTask(status));
        final Thread thread2 = new Thread(() -> {
            while (!status.isDone()) {
                synchronized (status) {
                    try {
                        status.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
            System.out.println(status.getTotalBytes());
        });

        thread1.start();
        thread2.start();
    }
}