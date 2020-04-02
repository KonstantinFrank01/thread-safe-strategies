package at.htl.synchronizedkeyword;

class DownloadStatus {
    private int totalBytes;
    private final Object totalBytesLock = new Object();

    public int getTotalBytes() {
        return totalBytes;
    }

    /*public void incrementTotalBytes() {
        synchronized (this) { You should not use this as a monitor
            totalBytes++;
        }
    }*/

    public void incrementTotalBytes() {
        synchronized (totalBytesLock) {
            totalBytes++;
        }
    }

    /*public synchronized void incrementTotalBytes() {
        This would be the same as using synchronized(this)
        totalBytes++;
    }*/
}
