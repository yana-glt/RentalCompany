package com.solvd.RentalCompany.services.mybatisImplementation;

import com.solvd.RentalCompany.core.CarCore;
import com.solvd.RentalCompany.dao.ICarDAO;
import com.solvd.RentalCompany.exceptionHandlers.ObjectNotFoundException;
import com.solvd.RentalCompany.mappers.CarMapper;
import com.solvd.RentalCompany.mappers.mapperInterfaces.ICarMapper;
import com.solvd.RentalCompany.models.Car;
import com.solvd.RentalCompany.services.ICarServiceS;
import com.solvd.RentalCompany.util.MybatisDAOFactory;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.util.Optional;

public class CarServiceImpl implements ICarServiceS {
    private final static Logger logger = LogManager.getLogger(CarServiceImpl.class);
    private final ICarMapper carMapper = new CarMapper();
    private static final SqlSessionFactory SESSION_FACTORY = MybatisDAOFactory.getSqlSessionFactory();
    @Override
    public CarCore createEntity(CarCore carCore) {
        Car car = carMapper.coreToModel(carCore);
        SqlSession sqlSession = SESSION_FACTORY.openSession();
        try {
            ICarDAO carDAO = sqlSession.getMapper(ICarDAO.class);
            carDAO.createEntity(car);
            logger.info("Object of class Car has been successfully created.");
            return carMapper.modelToCore(car);
        }
        catch (Exception e) {
            sqlSession.rollback();
            logger.error("Object of class Car was not created!", e.getMessage());
            e.printStackTrace();
            throw new RuntimeException(e.getCause());
        }
        finally {
            sqlSession.close();
        }
    }

    @Override
    public CarCore getEntityById(Integer id) {
        try(SqlSession sqlSession = SESSION_FACTORY.openSession()) {
            ICarDAO carDAO = sqlSession.getMapper(ICarDAO.class);
            Optional<Car> carOptional = carDAO.getEntityById(id);
            try{
                if(carOptional.isEmpty()){
                    throw new ObjectNotFoundException("Object was not found!", id);
                }
            }catch(ObjectNotFoundException e){
                logger.error("Object of class Car with id:" + e.getObjectId() + " was not found!", e.getMessage());
            }
            Car car = carOptional.get();
            return carMapper.modelToCore(car);
        }
    }

    @Override
    public CarCore updateEntity(CarCore carCore, Integer id) {
        Car car = carMapper.coreToModel(carCore);
        SqlSession sqlSession = SESSION_FACTORY.openSession();
        try {
            ICarDAO carDAO = sqlSession.getMapper(ICarDAO.class);
            carDAO.updateEntity(car, id);
            Optional<Car> carOptional = carDAO.getEntityById(id);
            try{
                if(carOptional.isEmpty()){
                    throw new ObjectNotFoundException("Object was not found!", id);
                }
            }catch(ObjectNotFoundException e){
                logger.error("Object of class Car with id:" + e.getObjectId() + " was not found!", e.getMessage());
            }
            Car newCar = carOptional.get();
            sqlSession.commit();
            logger.info("Object of class Car has been successfully updated.");
            return carMapper.modelToCore(newCar);
        }
        catch (Exception e) {
            sqlSession.rollback();
            logger.error("Object of class Car was not updated!", e.getMessage());
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
            ICarDAO carDAO = sqlSession.getMapper(ICarDAO.class);
            carDAO.removeEntityById(id);
            sqlSession.commit();
            logger.info("Object of class Car with id:" + id + " was deleted!");
        }
        catch (Exception e) {
            sqlSession.rollback();
            logger.error("Object of class Car was not deleted!", e.getMessage());
            e.printStackTrace();
            throw new RuntimeException(e.getCause());
        }
        finally {
            sqlSession.close();
        }
    }
}