package dao;

public class UtahTheaterAuditionsRepository {
    public MongoTemplate getMongoTemplate() {
        ConnectionString connectionString = new ConnectionString("mongodb+srv://uasys:<password>@utah-auditions-cluster.fcwslx6.mongodb.net/?retryWrites=true&w=majority");
        MongoClientSettings settings = MongoClientSettings.builder()
                .applyConnectionString(connectionString)
                .serverApi(ServerApi.builder()
                        .version(ServerApiVersion.V1)
                        .build())
                .build();
        MongoClient mongoClient = MongoClients.create(settings);
        MongoDatabase database = mongoClient.getDatabase("test");
    }


}
