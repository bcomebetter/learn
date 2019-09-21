package section_one.daemon_thread_demo;


import lombok.extern.slf4j.Slf4j;
import section_one.entity.Event;

import java.util.ArrayDeque;

/**
 * 此处目的应知晓,但是为嘛要引入日志框架守护线程才能执行???
 */
@Slf4j
public class Main {
    public static void main(String[] args) {
        ArrayDeque<Event> deque = new ArrayDeque<>();
        WriterTask writerTask = new WriterTask(deque);
        for (int i = 0; i < 3; i++) {
            Thread thread = new Thread(writerTask);
            thread.start();
        }
        // TODO: 2019-09-16 关于守护线程不能正确运行的问题
        CleanerTask cleanerTask = new CleanerTask(deque);
        log.info("该线程是守护线程:"+cleanerTask.isDaemon());
        cleanerTask.start();
    }
}
