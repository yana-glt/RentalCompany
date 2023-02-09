package com.solvd.RentalCompany.services.mybatisImplementation;

import com.solvd.RentalCompany.core.CategoryCore;
import com.solvd.RentalCompany.dao.ICategoryDAO;
import com.solvd.RentalCompany.exceptionHandlers.ObjectNotFoundExceptionForStringId;
import com.solvd.RentalCompany.mappers.CategoryMapper;
import com.solvd.RentalCompany.mappers.mapperInterfaces.ICategoryMapper;
import com.solvd.RentalCompany.models.Category;
import com.solvd.RentalCompany.services.ICategoryService;
import com.solvd.RentalCompany.util.MybatisDAOFactory;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.util.Optional;

public class CategoryServiceImpl implements ICategoryService {

    private final static Logger logger = LogManager.getLogger(CategoryServiceImpl.class);
    private final ICategoryMapper categoryMapper = new CategoryMapper();
    private static final SqlSessionFactory SESSION_FACTORY = MybatisDAOFactory.getSqlSessionFactory();
    @Override
    public CategoryCore createEntity(CategoryCore categoryCore) {
        Category category = categoryMapper.coreToModel(categoryCore);
        SqlSession sqlSession = SESSION_FACTORY.openSession();
        try {
            ICategoryDAO categoryDAO = sqlSession.getMapper(ICategoryDAO.class);
            categoryDAO.createEntity(category);
            logger.info("Object of class Category has been successfully created.");
            return categoryMapper.modelToCore(category);
        }
        catch (Exception e) {
            sqlSession.rollback();
            logger.error("Object of class Category was not created!", e.getMessage());
            e.printStackTrace();
            throw new RuntimeException(e.getCause());
        }
        finally {
            sqlSession.close();
        }
    }

    @Override
    public CategoryCore getEntityById(String id) {
        try(SqlSession sqlSession = SESSION_FACTORY.openSession()) {
            ICategoryDAO categoryDAO = sqlSession.getMapper(ICategoryDAO.class);
            Optional<Category> categoryOptional = categoryDAO.getEntityById(id);
            try{
                if(categoryOptional.isEmpty()){
                    throw new ObjectNotFoundExceptionForStringId("Object was not found!", id);
                }
            }catch(ObjectNotFoundExceptionForStringId e){
                logger.error("Object of class Category with id:" + e.getObjectId() + " was not found!", e.getMessage());
            }
            Category category = categoryOptional.get();
            return categoryMapper.modelToCore(category);
        }
    }

    @Override
    public CategoryCore updateEntity(CategoryCore categoryCore, String id) {
        Category category = categoryMapper.coreToModel(categoryCore);
        SqlSession sqlSession = SESSION_FACTORY.openSession();
        try {
            ICategoryDAO categoryDAO = sqlSession.getMapper(ICategoryDAO.class);
            categoryDAO.updateEntity(category, id);
            Optional<Category> categoryOptional = categoryDAO.getEntityById(id);
            try{
                if(categoryOptional.isEmpty()){
                    throw new ObjectNotFoundExceptionForStringId("Object was not found!", id);
                }
            }catch(ObjectNotFoundExceptionForStringId e){
                logger.error("Object of class Category with id:" + e.getObjectId() + " was not found!", e.getMessage());
            }
            Category newCategory = categoryOptional.get();
            sqlSession.commit();
            logger.info("Object of class Category has been successfully updated.");
            return categoryMapper.modelToCore(newCategory);
        }
        catch (Exception e) {
            sqlSession.rollback();
            logger.error("Object of class Category was not updated!", e.getMessage());
            e.printStackTrace();
            throw new RuntimeException(e.getCause());
        }
        finally {
            sqlSession.close();
        }
    }

    @Override
    public void removeEntityById(String id) {
        SqlSession sqlSession = SESSION_FACTORY.openSession();
        try {
            ICategoryDAO categoryDAO = sqlSession.getMapper(ICategoryDAO.class);
            categoryDAO.removeEntityById(id);
            sqlSession.commit();
            logger.info("Object of class Category with id:" + id + " was deleted!");
        }
        catch (Exception e) {
            sqlSession.rollback();
            logger.error("Object of class Category was not deleted!", e.getMessage());
            e.printStackTrace();
            throw new RuntimeException(e.getCause());
        }
        finally {
            sqlSession.close();
        }
    }
}