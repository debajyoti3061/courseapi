package com.mathworks.courseapidata.topic;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class TopicService {
  @Autowired
  private TopicRepository topicRepository;

  private List<Topic> topics = new ArrayList<>(Arrays.asList(
      new Topic("spring","spring framework" ,"description1"),
        new Topic("java","java framework" ,"description2"),
        new Topic("javascript","js framework" ,"description3")
    ));

  public List<Topic> getAllTopics(){

    //return topics;
    List<Topic> topics = new ArrayList<>();
    topicRepository.findAll().forEach(topics::add);
    return topics;
  }

  public Topic getTopic(String id){

    //return topics.stream().filter(t -> t.getId().equals(id)).findFirst().get();
    return topicRepository.findOne(id);
  }

  public void addTopic(Topic topic) {
    topicRepository.save(topic);
  }

  public void updateTopic(Topic topic, String id) {
    /*for (int i=0; i<topics.size();i++){
      Topic t = topics.get(i);
      if(t.getId().endsWith(id)){
        topics.set(i,topic);
      }
    }*/
    topicRepository.save(topic);
  }

  public void deleteTopic(String id) {

    //topics.removeIf(t -> t.getId().equals(id));
    topicRepository.delete(id);
  }
}
