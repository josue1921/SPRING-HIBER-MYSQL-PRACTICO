package com.websystique.springboot.service;

import java.util.List;

import com.websystique.springboot.model.Gender;
import com.websystique.springboot.repositories.GenderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service("genderService")
@Transactional
public class GenderServiceImpl implements GenderService {
	
	@Autowired
    private GenderRepository genderRepository;
	
    @Override
	public List<Gender> findAllGender(){
        return genderRepository.findAll();
    }
}
