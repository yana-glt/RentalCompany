package com.solvd.RentalCompany.util;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.io.IOException;
import java.io.Reader;

public class MybatisDAOFactory {
    private final static Logger logger = LogManager.getLogger(MybatisDAOFactory.class);
    private final static MybatisDAOFactory myBatisDaoFactory = new MybatisDAOFactory();
    private static SqlSessionFactory sqlSessionFactory;

    private MybatisDAOFactory() {
        try {
            Reader reader = Resources.getResourceAsReader("mybatis-config.xml");
            sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
        } catch (IOException e) {
            logger.error("Failed to read information from mybatis-config.xml file", e);
        }
    }

    public static SqlSessionFactory getSqlSessionFactory() {
        return sqlSessionFactory;
    }
}