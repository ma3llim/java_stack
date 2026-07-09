import models.DownloadStatus;
import models.DownloadTask;
import models.FileDownload;

import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

public class Main {
    public static void main(String[] args) {
        AtomicInteger progress = new AtomicInteger(0);
        List<FileDownload> files = List.of(
                new FileDownload("file1.zip", 120, DownloadStatus.PENDING),
                new FileDownload("file2.zip", 250, DownloadStatus.PENDING),
                new FileDownload("file3.zip", 75, DownloadStatus.PENDING),
                new FileDownload("file4.zip", 500, DownloadStatus.PENDING),
                new FileDownload("file5.zip", 300, DownloadStatus.PENDING),
                new FileDownload("file6.zip", 180, DownloadStatus.PENDING),
                new FileDownload("file7.zip", 95, DownloadStatus.PENDING),
                new FileDownload("file8.zip", 420, DownloadStatus.PENDING),
                new FileDownload("file9.zip", 210, DownloadStatus.PENDING),
                new FileDownload("file10.zip", 150, DownloadStatus.PENDING)
        );
        CountDownLatch latch = new CountDownLatch(files.size());
        ConcurrentHashMap<String, DownloadStatus> statusTracker = new ConcurrentHashMap<>();

        ExecutorService executorService = Executors.newFixedThreadPool(4);
        System.out.println("Starting downloads...");
        for (FileDownload file : files) {
            DownloadTask downloadTask = new DownloadTask(file, progress, files.size(), latch, statusTracker);
            executorService.submit(downloadTask);
        }
        try {
            latch.await();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("All downloads completed");

        for (var entry : statusTracker.entrySet()) {
            System.out.println(entry.getKey() + " -> " + entry.getValue());
        }
        executorService.shutdown();
    }
}