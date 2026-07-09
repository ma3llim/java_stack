package models;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicInteger;

public class DownloadTask implements Runnable {
    private FileDownload fileDownload;
    private AtomicInteger progress;
    private int totalFiles;
    private CountDownLatch latch;
    private ConcurrentHashMap<String, DownloadStatus> statusTracker;

    public DownloadTask(FileDownload fileDownload, AtomicInteger progress, int totalFiles, CountDownLatch latch, ConcurrentHashMap<String, DownloadStatus> statusTracker) {
        this.fileDownload = fileDownload;
        this.progress = progress;
        this.totalFiles = totalFiles;
        this.latch = latch;
        this.statusTracker = statusTracker;
    }

    @Override
    public void run() {
        fileDownload.setStatus(DownloadStatus.DOWNLOADING);
        statusTracker.put(fileDownload.getFileName(), DownloadStatus.DOWNLOADING);
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
            Thread.currentThread().interrupt();
        }
        fileDownload.setStatus(DownloadStatus.COMPLETED);
        statusTracker.put(fileDownload.getFileName(), DownloadStatus.COMPLETED);

        int completed = progress.incrementAndGet();

        System.out.println("File Downloaded Completed!. " +
                fileDownload.getFileName() +
                " By " +
                Thread.currentThread().getName());

        System.out.println("Downloaded " + completed + "/" + totalFiles);
        latch.countDown();
    }
}
