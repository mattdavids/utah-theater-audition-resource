package com.utah.theater.audition.schedule.UtahTheaterAuditionResource.dao;

import com.mongodb.ConnectionString;
import com.mongodb.MongoClientSettings;
import com.mongodb.ServerApi;
import com.mongodb.ServerApiVersion;
import com.mongodb.client.MongoClients;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.web.util.UriBuilder;

import java.net.URI;
import java.net.URLEncoder;
import java.nio.charset.Charset;

public class UtahTheaterAuditionsRepository {
    public MongoTemplate getMongoTemplate() {
        String password = "ZARtQtMBt0J9yBrO";
        password = URLEncoder.encode(password, Charset.defaultCharset());
        String connectionString = "mongodb+srv://system:" + password + "@utah-auditions-cluster.fcwslx6.mongodb.net/?retryWrites=true&w=majority";
        ServerApi serverApi = ServerApi.builder()
                .version(ServerApiVersion.V1)
                .build();
        MongoClientSettings settings = MongoClientSettings.builder()
                .applyConnectionString(new ConnectionString(connectionString))
                .serverApi(serverApi)
                .build();
        return new MongoTemplate(MongoClients.create(settings), "admin");
    }


}
