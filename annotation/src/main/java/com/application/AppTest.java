package com.application;

import java.io.IOException;
import java.util.List;

import org.apache.commons.exec.CommandLine;
import org.apache.commons.exec.DefaultExecutor;
import org.apache.commons.exec.ExecuteException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.utils.UtilsDao;

public class AppTest {
    
    private static final Logger logger = LoggerFactory.getLogger(AppTest.class);
    
    public static void main(String[] args) {
        
        ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
        
        UtilsDao utilsDao = (UtilsDao) ac.getBean("utilsDao");
        
        List<?> tmp = utilsDao.getTables();
        logger.info(tmp.toString());
        
        DefaultExecutor executor = new DefaultExecutor();
        
        try {
            executor.execute(CommandLine.parse(
                    "/Users/Sabo/Developer/hadoop-1.0.1/bin/hadoop -help "));
        } catch (ExecuteException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        
        logger.info("hello APPTest.");
        
        ((ClassPathXmlApplicationContext) ac).close();
    }
    
}
