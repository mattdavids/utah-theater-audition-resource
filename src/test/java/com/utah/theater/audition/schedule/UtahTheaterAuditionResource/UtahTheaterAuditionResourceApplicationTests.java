package com.utah.theater.audition.schedule.UtahTheaterAuditionResource;

import com.utah.theater.audition.schedule.UtahTheaterAuditionResource.dao.UtahTheaterAuditionsRepository;
import com.utah.theater.audition.schedule.UtahTheaterAuditionResource.utils.UtahTheaterAuditionsUtil;
import org.bson.Document;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.mongodb.core.MongoTemplate;

import java.io.IOException;
import java.text.ParseException;

@SpringBootTest
class UtahTheaterAuditionResourceApplicationTests {

	@Test
	void contextLoads() {
	}

	@Test
	void connectToDB() {
		UtahTheaterAuditionsRepository utahTheaterAuditionsRepository = new UtahTheaterAuditionsRepository();
		MongoTemplate mongoTemplate = utahTheaterAuditionsRepository.getMongoTemplate();
		Document serverStatus = mongoTemplate.executeCommand(new Document("serverStatus", 1));
		System.out.println(serverStatus);
	}

	@Test
	void testConnection() throws IOException, ParseException {
		UtahTheaterAuditionsUtil utahTheaterAuditionsUtil = new UtahTheaterAuditionsUtil();
		utahTheaterAuditionsUtil.scrapeAuditions();
	}

}
