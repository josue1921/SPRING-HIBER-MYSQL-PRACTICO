
package com.websystique.springboot.service;
 
import com.websystique.springboot.model.Gender;
import java.util.List;
 
public interface GenderService {
     
    List<Gender> findAllGender();
 
}