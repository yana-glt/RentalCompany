package com.solvd.RentalCompany.services;

import com.solvd.RentalCompany.core.CategoryCore;
import com.solvd.RentalCompany.dao.CategoryDAO;
import com.solvd.RentalCompany.dao.ICategoryDAO;
import com.solvd.RentalCompany.exceptionHandlers.ObjectNotFoundExceptionForStringId;
import com.solvd.RentalCompany.mappers.CategoryMapper;
import com.solvd.RentalCompany.mappers.mapperInterfaces.ICategoryMapper;
import com.solvd.RentalCompany.models.Category;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.util.Optional;

public class CategoryService implements ICategoryService{

    private final static Logger logger = LogManager.getLogger(CategoryService.class);
    private final ICategoryDAO categoryDAO = new CategoryDAO();
    private final ICategoryMapper categoryMapper = new CategoryMapper();
    @Override
    public CategoryCore createEntity(CategoryCore categoryCore) {
        Category category = categoryMapper.coreToModel(categoryCore);
        Category savedCategory = this.categoryDAO.createEntity(category);
        logger.info("Object of class Category has been successfully created.");
        return categoryCore;
    }

    @Override
    public CategoryCore getEntityById(String id) {
        Optional<Category> categoryOptional = this.categoryDAO.getEntityById(id);
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

    @Override
    public CategoryCore updateEntity(CategoryCore categoryCore, String id) {
        Optional<Category> categoryOptional = this.categoryDAO.updateEntity(categoryMapper.coreToModel(categoryCore), id);
        try {
            if (categoryOptional.isEmpty()) {
                throw new ObjectNotFoundExceptionForStringId("Object was not found!", categoryCore.getId());
            }
        }catch(ObjectNotFoundExceptionForStringId e){
            logger.error("Object of class Category with id:" + e.getObjectId() + " was not found!", e.getMessage());
        }
        logger.info("Object of class Category has been successfully updated.");
        return categoryMapper.modelToCore(categoryOptional.get());
    }

    @Override
    public void removeEntityById(String id) {
        this.categoryDAO.removeEntityById(id);
        logger.info("Object of class Category has been successfully deleted.");
    }
}