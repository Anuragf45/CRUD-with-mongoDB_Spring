package com.example.userData.Model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.web.bind.annotation.RestController;
@Data
@Document(collection = "userData")
public class Model {
    @Id
    private String id;
    private String userName;
    private String full_name;
    private String email;
    private String address;
    private Long mobile;
    private String organization;
}
