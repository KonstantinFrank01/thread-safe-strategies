package at.htl.confinement;

import java.util.ArrayList;
import java.util.List;

class ThreadDemo {

    public static void show() {
        List<Thread> threads = new ArrayList<>();
        List<DownloadFileTask> tasks = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            final DownloadFileTask task = new DownloadFileTask();
            tasks.add(task);

            Thread thread = new Thread(task);
            threads.add(thread);
            thread.start();
        }

        for (Thread thread : threads) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        int totalBytes = tasks.stream()
                .map((t -> t.getStatus().getTotalBytes()))
                .reduce(0, Integer::sum);
        System.out.println(totalBytes);
    }
}
