package com.solvd.RentalCompany.services.mybatisImplementation;

import com.solvd.RentalCompany.core.CarServiceCore;
import com.solvd.RentalCompany.dao.ICarServiceDAO;
import com.solvd.RentalCompany.dao.IServiceDAO;
import com.solvd.RentalCompany.exceptionHandlers.ObjectNotFoundException;
import com.solvd.RentalCompany.mappers.CarServiceMapper;
import com.solvd.RentalCompany.mappers.ServiceMapper;
import com.solvd.RentalCompany.mappers.mapperInterfaces.ICarServiceMapper;
import com.solvd.RentalCompany.mappers.mapperInterfaces.IServiceMapper;
import com.solvd.RentalCompany.models.CarService;
import com.solvd.RentalCompany.models.Service;
import com.solvd.RentalCompany.services.ICarServiceService;
import com.solvd.RentalCompany.util.MybatisDAOFactory;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Optional;

public class CarServiceServiceImpl implements ICarServiceService {

    private final static Logger logger = LogManager.getLogger(CarServiceServiceImpl.class);
    private final ICarServiceMapper carServiceMapper = new CarServiceMapper();
    private static final SqlSessionFactory SESSION_FACTORY = MybatisDAOFactory.getSqlSessionFactory();

    @Override
    public CarServiceCore createEntity(CarServiceCore carServiceCore) {
        CarService carService = carServiceMapper.coreToModel(carServiceCore);
        SqlSession sqlSession = SESSION_FACTORY.openSession();
        try {
            ICarServiceDAO carServiceDAO = sqlSession.getMapper(ICarServiceDAO.class);
            carServiceDAO.createEntity(carService);
            logger.info("Object of class CarService has been successfully created.");
            return carServiceMapper.modelToCore(carService);
        }
        catch (Exception e) {
            sqlSession.rollback();
            logger.error("Object of class CarService was not created!", e.getMessage());
            e.printStackTrace();
            throw new RuntimeException(e.getCause());
        }
        finally {
            sqlSession.close();
        }
    }

    @Override
    public CarServiceCore getEntityById(Integer id) {
        try(SqlSession sqlSession = SESSION_FACTORY.openSession()) {
            ICarServiceDAO carServiceDAO = sqlSession.getMapper(ICarServiceDAO.class);
            Optional<CarService> carServiceOptional = carServiceDAO.getEntityById(id);
            try{
                if(carServiceOptional.isEmpty()){
                    throw new ObjectNotFoundException("Object was not found!", id);
                }
            }catch(ObjectNotFoundException e){
                logger.error("Object of class CarService with id:" + e.getObjectId() + " was not found!", e.getMessage());
            }
            CarService carService = carServiceOptional.get();
            return carServiceMapper.modelToCore(carService);
        }
    }

    @Override
    public CarServiceCore updateEntity(CarServiceCore carServiceCore, Integer id) {
        CarService carService = carServiceMapper.coreToModel(carServiceCore);
        SqlSession sqlSession = SESSION_FACTORY.openSession();
        try {
            ICarServiceDAO carServiceDAO = sqlSession.getMapper(ICarServiceDAO.class);
            carServiceDAO.updateEntity(carService, id);
            Optional<CarService> carServiceOptional = carServiceDAO.getEntityById(id);
            try{
                if(carServiceOptional.isEmpty()){
                    throw new ObjectNotFoundException("Object was not found!", id);
                }
            }catch(ObjectNotFoundException e){
                logger.error("Object of class CarService with id:" + e.getObjectId() + " was not found!", e.getMessage());
            }
            CarService newCarService = carServiceOptional.get();
            sqlSession.commit();
            logger.info("Object of class CarService has been successfully updated.");
            return carServiceMapper.modelToCore(newCarService);
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
            ICarServiceDAO carServiceDAO = sqlSession.getMapper(ICarServiceDAO.class);
            carServiceDAO.removeEntityById(id);
            sqlSession.commit();
            logger.info("Object of class CarService with id:" + id + " was deleted!");
        }
        catch (Exception e) {
            sqlSession.rollback();
            logger.error("Object of class CarService was not deleted!", e.getMessage());
            e.printStackTrace();
            throw new RuntimeException(e.getCause());
        }
        finally {
            sqlSession.close();
        }
    }
}