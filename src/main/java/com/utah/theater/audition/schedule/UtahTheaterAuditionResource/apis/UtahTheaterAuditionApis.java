package com.utah.theater.audition.schedule.UtahTheaterAuditionResource.apis;

import com.utah.theater.audition.schedule.UtahTheaterAuditionResource.dao.UtahTheaterAuditionsRepository;
import org.bson.Document;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.security.Principal;
import java.util.HashMap;
import java.util.Map;

@Controller
public class UtahTheaterAuditionApis {
    @GetMapping(path = "/test", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public Map<String, String> test(Principal p) {
        Map<String, String> map = new HashMap<>();
        map.put("hello", "world");
        UtahTheaterAuditionsRepository utahTheaterAuditionApis = new UtahTheaterAuditionsRepository();
        MongoTemplate mongoTemplate = utahTheaterAuditionApis.getMongoTemplate();
        Document serverStatus = mongoTemplate.executeCommand(new Document("serverStatus", 1));
        System.out.println(serverStatus);
        return map;
    }
}
