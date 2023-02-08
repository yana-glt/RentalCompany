package com.solvd.RentalCompany.services.mybatisImplementation;

import com.solvd.RentalCompany.core.ServiceCore;
import com.solvd.RentalCompany.dao.IServiceDAO;
import com.solvd.RentalCompany.exceptionHandlers.ObjectNotFoundException;
import com.solvd.RentalCompany.mappers.ServiceMapper;
import com.solvd.RentalCompany.mappers.mapperInterfaces.IServiceMapper;
import com.solvd.RentalCompany.models.Service;
import com.solvd.RentalCompany.services.IServiceService;
import com.solvd.RentalCompany.util.MybatisDAOFactory;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.util.Optional;

public class ServiceServiceImpl implements IServiceService {

    private final static Logger logger = LogManager.getLogger(ServiceServiceImpl.class);
    private final IServiceMapper serviceMapper = new ServiceMapper();
    private static final SqlSessionFactory SESSION_FACTORY = MybatisDAOFactory.getSqlSessionFactory();

    @Override
    public ServiceCore createEntity(ServiceCore serviceCore) {
        Service service = serviceMapper.coreToModel(serviceCore);
        SqlSession sqlSession = SESSION_FACTORY.openSession();
        try {
            IServiceDAO serviceDAO = sqlSession.getMapper(IServiceDAO.class);
            serviceDAO.createEntity(service);
            logger.info("Object of class Service has been successfully created.");
            return serviceMapper.modelToCore(service);
        }
        catch (Exception e) {
            sqlSession.rollback();
            logger.error("Object of class Service was not created!", e.getMessage());
            e.printStackTrace();
            throw new RuntimeException(e.getCause());
        }
        finally {
            sqlSession.close();
        }
    }

    @Override
    public ServiceCore getEntityById(Integer id) {
        try(SqlSession sqlSession = SESSION_FACTORY.openSession()) {
            IServiceDAO serviceDAO = sqlSession.getMapper(IServiceDAO.class);
            Optional<Service> serviceOptional = serviceDAO.getEntityById(id);
            try{
                if(serviceOptional.isEmpty()){
                    throw new ObjectNotFoundException("Object was not found!", id);
                }
            }catch(ObjectNotFoundException e){
                logger.error("Object of class Service with id:" + e.getObjectId() + " was not found!", e.getMessage());
            }
            Service service = serviceOptional.get();
            return serviceMapper.modelToCore(service);
        }
    }

    @Override
    public ServiceCore updateEntity(ServiceCore serviceCore, Integer id) {
        Service service = serviceMapper.coreToModel(serviceCore);
        SqlSession sqlSession = SESSION_FACTORY.openSession();
        try {
            IServiceDAO serviceDAO = sqlSession.getMapper(IServiceDAO.class);
            serviceDAO.updateEntity(service, id);
            Optional<Service> serviceOptional = serviceDAO.getEntityById(id);
            try{
                if(serviceOptional.isEmpty()){
                    throw new ObjectNotFoundException("Object was not found!", id);
                }
            }catch(ObjectNotFoundException e){
                logger.error("Object of class Service with id:" + e.getObjectId() + " was not found!", e.getMessage());
            }
            Service newService = serviceOptional.get();
            sqlSession.commit();
            logger.info("Object of class Service has been successfully updated.");
            return serviceMapper.modelToCore(newService);
        }
        catch (Exception e) {
            sqlSession.rollback();
            logger.error("Object of class Service was not updated!", e.getMessage());
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
            IServiceDAO serviceDAO = sqlSession.getMapper(IServiceDAO.class);
            serviceDAO.removeEntityById(id);
            sqlSession.commit();
            logger.info("Object of class Service with id:" + id + " was deleted!");
        }
        catch (Exception e) {
            sqlSession.rollback();
            logger.error("Object of class Service was not deleted!", e.getMessage());
            e.printStackTrace();
            throw new RuntimeException(e.getCause());
        }
        finally {
            sqlSession.close();
        }
    }
}