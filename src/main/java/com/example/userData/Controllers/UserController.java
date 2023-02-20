package com.example.userData.Controllers;


import com.example.userData.Model.Model;
import com.example.userData.Repositories.Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.lang.reflect.Array;
import java.util.List;
import java.util.Optional;

@RestController
public class UserController {
    @Autowired
 private   Repository Repository;
    @GetMapping("/getUsers")
    public List<Model> getUsers(){
        return Repository.findAll();
    }

@PostMapping("/createUser")
    public Model createUser(@RequestBody Model model){

      Repository.save(model);
      return model;
    }

    @PutMapping("/editDetails/{userName}")
    public  String updateUser(@PathVariable String userName, Model model) {
        Optional<Model> optional1 = Repository.findByUserName(userName);
        //System.out.println(userName);
        Model modelData = optional1.get();
        String res;
        if (!optional1.isPresent()) {
            return "No user found with this userName " + userName;
        } else {
            res = "";
            String str = modelData.getFull_name();

//            return "hey";
//         for(int i=0;i<str.length();i++){
//             if(str.charAt(i)=='a' || str.charAt(i)=='e' ||str.charAt(i)=='i' ||str.charAt(i)=='o' ||str.charAt(i)=='u'){
//                 res+=
//             }else{
//                 res=res+(str.charAt(i));
//             }
//         }
            char[] specialChars = {'!', '@', '#', '%','*','&'};
            for (int i = 0; i < str.length(); i++) {
                if (str.charAt(i) == 'a' || str.charAt(i) == 'e' || str.charAt(i) == 'i' || str.charAt(i) == 'o' || str.charAt(i) == 'u') {
                    int randomNum = (int) Math.floor(Math.random() * 10) % specialChars.length;

                    res += specialChars[randomNum];

                } else {
                    res += str.charAt(i);
                }
            }
            System.out.println(res);

        }
        return res;
    }
    @DeleteMapping("/deleteUser/{id}")
    public String deleteUser(@PathVariable String id){
    Repository.deleteById(id);
    return "user with user ID "+id+" has been deleted successfully";
    }
}


//username, full name, email, address, mobile number, current organization