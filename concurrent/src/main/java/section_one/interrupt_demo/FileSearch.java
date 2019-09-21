package section_one.interrupt_demo;

import java.io.File;
import java.util.Objects;

public class FileSearch implements Runnable {
    private String initPath;
    private String fileName;
    public FileSearch(String initPath, String fileName) {
        this.initPath = initPath;
        this.fileName = fileName;
    }

    @Override
    public void run() {
        File file = new File(initPath);
        if (file.isDirectory()){
            try {
                directoryProcess(file);
            } catch (InterruptedException e) {
                System.out.println("the thread has been interrupted:"+Thread.currentThread().getName());
            }
        }
    }

    private void directoryProcess(File file) throws InterruptedException {
        File[] files = file.listFiles();
        if (Objects.nonNull(files)){
            for (int i = 0; i < files.length; i++) {
                if (files[i].isDirectory()){
                    directoryProcess(files[i]);
                }
                else {
                    fileProcess(files[i]);
                }
            }
        }
        if (Thread.interrupted()){
            throw new InterruptedException();
        }
    }

    private void fileProcess(File file) throws InterruptedException {
        if (file.getName().equalsIgnoreCase(fileName)){
            System.out.println(Thread.currentThread().getName()+"-----"+file.getAbsolutePath());
        }
        if (Thread.interrupted()){
            throw new InterruptedException();
        }
    }
}
