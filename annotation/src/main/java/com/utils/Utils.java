package com.utils;

import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.core.JdbcTemplate;

public class Utils {
    
    private Logger logger = LoggerFactory.getLogger(Utils.class);
    private JdbcTemplate jdbcTemplate;
    
    public List<Map<String, Object>> getTables() {
        try {
            String sql = "show tables";
            return jdbcTemplate.queryForList(sql);
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
            logger.debug("getTables failed." + e);
        }
        
        return null;
    }
    
}
