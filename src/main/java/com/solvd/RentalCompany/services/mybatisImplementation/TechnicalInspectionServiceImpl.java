package com.solvd.RentalCompany.services.mybatisImplementation;

import com.solvd.RentalCompany.core.TechnicalInspectionCore;
import com.solvd.RentalCompany.dao.ITechnicalInspectionDAO;
import com.solvd.RentalCompany.exceptionHandlers.ObjectNotFoundException;
import com.solvd.RentalCompany.mappers.TechnicalInspectionMapper;
import com.solvd.RentalCompany.mappers.mapperInterfaces.ITechnicalInspectionMapper;
import com.solvd.RentalCompany.models.TechnicalInspection;
import com.solvd.RentalCompany.services.ITechnicalInspectionService;
import com.solvd.RentalCompany.util.MybatisDAOFactory;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.util.Optional;

public class TechnicalInspectionServiceImpl implements ITechnicalInspectionService {

    private final static Logger logger = LogManager.getLogger(TechnicalInspectionServiceImpl.class);
    private final ITechnicalInspectionMapper technicalInspectionMapper = new TechnicalInspectionMapper();
    private static final SqlSessionFactory SESSION_FACTORY = MybatisDAOFactory.getSqlSessionFactory();

    @Override
    public TechnicalInspectionCore createEntity(TechnicalInspectionCore technicalInspectionCore) {
        TechnicalInspection technicalInspection = technicalInspectionMapper.coreToModel(technicalInspectionCore);
        SqlSession sqlSession = SESSION_FACTORY.openSession();
        try {
            ITechnicalInspectionDAO technicalInspectionDAO = sqlSession.getMapper(ITechnicalInspectionDAO.class);
            technicalInspectionDAO.createEntity(technicalInspection);
            logger.info("Object of class TechnicalInspection has been successfully created.");
            return technicalInspectionMapper.modelToCore(technicalInspection);
        }
        catch (Exception e) {
            sqlSession.rollback();
            logger.error("Object of class TechnicalInspection was not created!", e.getMessage());
            e.printStackTrace();
            throw new RuntimeException(e.getCause());
        }
        finally {
            sqlSession.close();
        }
    }

    @Override
    public TechnicalInspectionCore getEntityById(Integer id) {
        try(SqlSession sqlSession = SESSION_FACTORY.openSession()) {
            ITechnicalInspectionDAO technicalInspectionDAO = sqlSession.getMapper(ITechnicalInspectionDAO.class);
            Optional<TechnicalInspection> technicalInspectionOptional = technicalInspectionDAO.getEntityById(id);
            try{
                if(technicalInspectionOptional.isEmpty()){
                    throw new ObjectNotFoundException("Object was not found!", id);
                }
            }catch(ObjectNotFoundException e){
                logger.error("Object of class TechnicalInspection with id:" + e.getObjectId() + " was not found!", e.getMessage());
            }
            TechnicalInspection technicalInspection = technicalInspectionOptional.get();
            return technicalInspectionMapper.modelToCore(technicalInspection);
        }
    }

    @Override
    public TechnicalInspectionCore updateEntity(TechnicalInspectionCore technicalInspectionCore, Integer id) {
        TechnicalInspection technicalInspection = technicalInspectionMapper.coreToModel(technicalInspectionCore);
        SqlSession sqlSession = SESSION_FACTORY.openSession();
        try {
            ITechnicalInspectionDAO technicalInspectionDAO = sqlSession.getMapper(ITechnicalInspectionDAO.class);
            technicalInspectionDAO.updateEntity(technicalInspection, id);
            Optional<TechnicalInspection> technicalInspectionOptional = technicalInspectionDAO.getEntityById(id);
            try{
                if(technicalInspectionOptional.isEmpty()){
                    throw new ObjectNotFoundException("Object was not found!", id);
                }
            }catch(ObjectNotFoundException e){
                logger.error("Object of class TechnicalInspection with id:" + e.getObjectId() + " was not found!", e.getMessage());
            }
            TechnicalInspection newTechnicalInspection = technicalInspectionOptional.get();
            sqlSession.commit();
            logger.info("Object of class TechnicalInspection has been successfully updated.");
            return technicalInspectionMapper.modelToCore(newTechnicalInspection);
        }
        catch (Exception e) {
            sqlSession.rollback();
            logger.error("Object of class TechnicalInspection was not updated!", e.getMessage());
            e.printStackTrace();
            throw new RuntimeException(e.getCause());
        }
        finally {
            sqlSession.close();
        }
    }

    @Override
    public void removeEntityById(Integer id) {
        SqlSession sqlSession = SESSION_FACTORY.openSession();
        try {
            ITechnicalInspectionDAO technicalInspectionDAO = sqlSession.getMapper(ITechnicalInspectionDAO.class);
            technicalInspectionDAO.removeEntityById(id);
            sqlSession.commit();
            logger.info("Object of class TechnicalInspection with id:" + id + " was deleted!");
        }
        catch (Exception e) {
            sqlSession.rollback();
            logger.error("Object of class TechnicalInspection was not deleted!", e.getMessage());
            e.printStackTrace();
            throw new RuntimeException(e.getCause());
        }
        finally {
            sqlSession.close();
        }
    }
}