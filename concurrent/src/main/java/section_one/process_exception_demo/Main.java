package section_one.process_exception_demo;

/**
 *  When an exception is thrown in a thread and is not caught (it has to be an
 *  unchecked exception), the JVM checks if the thread has an uncaught exception
 *  handler set by the corresponding method. If it has, the JVM invokes this method
 *  with the Thread object and Exception as arguments.
 *
 *  If the thread has not got an uncaught exception handler, the JVM prints the stack
 *  trace in the console and exits the program.
 *
 *  look for default uncaught exception handler????
 *   *  The Thread class has another method related to the process of uncaught
 *   exceptions. It's the static method setDefaultUncaughtExceptionHandler() that
 *   establishes an exception handler for all the Thread objects in the application.
 */
public class Main {
    public static void main(String[] args) {
        Task task = new Task();
        Thread thread = new Thread(task);
        thread.setUncaughtExceptionHandler(new ExceptionHandler());
        thread.start();
    }
}
