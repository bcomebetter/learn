package section_one.create_threads_factory;

import com.google.common.collect.Lists;
import lombok.Data;

import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ThreadFactory;

@Data
public class MyThreadFactory implements ThreadFactory {
    private Integer counter;
    private String name;
    private List<String> state;

    public MyThreadFactory(String name) {
        this.counter = 0;
        this.name = name;
        this.state = Lists.newArrayList();
    }

    @Override
    public Thread newThread(Runnable r) {
        Thread t = new Thread(r, name + "-Thread" + counter);
        counter++;
        state.add(String.format("Created thread %d with name %s on %s\n",t.getId(),t.getName(),new Date()));
        return t;
    }
    public String getStatus(){
        StringBuffer sb = new StringBuffer();
        Iterator<String> it = state.iterator();
        while (it.hasNext()){
            sb.append(it.next());
            sb.append("\n");
        }
        return sb.toString();
    }
}
