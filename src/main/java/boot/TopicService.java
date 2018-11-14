package boot;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class TopicService {
    List<Topic> topics = new ArrayList<>(Arrays.asList(
            new Topic("1", "a", "aa"),
            new Topic("2", "b", "bb"),
            new Topic("3", "c", "cc")
    ));

    public List<Topic> getTopics() {
        return topics;
    }

    public Topic getTopic(String id) {
        return topics.stream().filter(t -> t.getId().equals(id)).findFirst().get();
    }

    public void addTopic(Topic topic) {
        topics.add(topic);
    }

    public void deleteTopic(String id) {
        topics.removeIf(t -> t.getId().equals(id));
    }

    public void updateTopic(Topic topic, String id) {
        for(int i=0;i<topics.size();i++){
            Topic t=topics.get(i);
            if(t.getId().equals(id)){
                topics.set(i,topic);
                return;
            }
        }
    }

}
