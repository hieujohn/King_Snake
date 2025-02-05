package com.example.snake_game.models;

import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

public class GetTop10User {
    public static FindIterable<Document> getTop10User(){
        MongoDatabase database = null;
        // Thay đổi URI kết nối theo cấu hình MongoDB của bạn
        String connectionString = "mongodb+srv://kingsnake:kingsnake@cluster0.baduwey.mongodb.net/?retryWrites=true&w=majority";
        FindIterable<Document> result = null ;
        try (MongoClient mongoClient = new MongoClient(new MongoClientURI(connectionString))) {
            // Kết nối thành công

            // Chọn cơ sở dữ liệu
            database = mongoClient.getDatabase("huongcaoha");
            MongoCollection<Document> collection = database.getCollection("users");
             result = collection.find()
                    .sort(new Document("score", -1))
                    .limit(10);

        } catch (Exception e) {
            // Xử lý lỗi kết nối
            e.printStackTrace();
        }
        return result ;
    }
}
