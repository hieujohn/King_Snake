package com.example.snake_game;

import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import org.bson.Document;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

public class HistoryController {
    @FXML
    private TableView<History> tableView;

    @FXML
    private TableColumn<History, String> playerColumn;

    @FXML
    private TableColumn<History, String> resultColumn;

    public void initialize() {
        // Connect to MongoDB
        MongoClient mongoClient = MongoClients.create("mongodb://localhost:27017");
        MongoDatabase database = mongoClient.getDatabase("projectdemo");
        MongoCollection<Document> collection = database.getCollection("thi");

        // Query MongoDB and populate the table view
        FindIterable<Document> documents = collection.find();
        for (Document document : documents) {
            String player = document.getString("name");
            String result = document.getString("point");
            tableView.getItems().add(new History(player, result));
        }

        // Configure table columns
        playerColumn.setCellValueFactory(cellData -> cellData.getValue().playerProperty());
        resultColumn.setCellValueFactory(cellData -> cellData.getValue().resultProperty());
    }
}