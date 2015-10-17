package com.example.zz;

//import java.util.List;

//import model.Search_out;

import java.io.Serializable;  
public class change_to_detailed implements Serializable {  
    private static final long serialVersionUID = -7060210544600464481L;   
    private String name;  
    private int age;  
    public String getName() {  
        return name;  
    }  
    public void setName(String name) {  
        this.name = name;  
    }  
    public int getAge() {  
        return age;  
    }  
    public void setAge(int age) {  
        this.age = age;  
    }  
      
}  