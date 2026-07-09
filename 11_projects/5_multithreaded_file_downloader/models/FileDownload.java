package models;

public class FileDownload {
    private String fileName;
    private int size;
    private DownloadStatus status;

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public DownloadStatus getStatus() {
        return status;
    }

    public void setStatus(DownloadStatus status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "FileDownload{" +
                "fileName='" + fileName + '\'' +
                ", size=" + size +
                ", status=" + status +
                '}';
    }

    public FileDownload(String fileName, int size, DownloadStatus status) {
        this.fileName = fileName;
        this.size = size;
        this.status = status;
    }
}
