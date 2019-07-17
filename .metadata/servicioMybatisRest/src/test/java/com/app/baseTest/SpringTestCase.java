package com.app.baseTest;

import org.junit.runner.RunWith;  
import org.slf4j.Logger;  
import org.slf4j.LoggerFactory;  
import org.springframework.test.context.ContextConfiguration;  
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;  
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

//Specify the configuration file for bean injection  
@ContextConfiguration(locations = { "classpath:application.xml" })  
//Use the standard JUnit@RunWith annotation to tell JUnit to use Spring TestRunner  
@RunWith(SpringJUnit4ClassRunner.class)  
public abstract class SpringTestCase extends AbstractJUnit4SpringContextTests{  
  protected Logger logger = LoggerFactory.getLogger(getClass());  
}  
