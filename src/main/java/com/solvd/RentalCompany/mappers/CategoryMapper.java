package com.solvd.RentalCompany.mappers;

import com.solvd.RentalCompany.core.CategoryCore;
import com.solvd.RentalCompany.models.Category;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class CategoryMapper implements ICategoryMapper{

    private final static Logger logger = LogManager.getLogger(CategoryMapper.class);
    @Override
    public CategoryCore modelToCore(Category category) {
        CategoryCore categoryCore = new CategoryCore();
        categoryCore.setId(category.getId());
        categoryCore.setName(category.getName());
        categoryCore.setDescription(category.getDescription());
        categoryCore.setCoefficient(category.getCoefficient());
        logger.info("Object of type Category has been successfully mapped to CategoryCore type.");
        return categoryCore;
    }

    @Override
    public Category coreToModel(CategoryCore categoryCore) {
        Category category = new Category();
        category.setId(categoryCore.getId());
        category.setName(categoryCore.getName());
        category.setDescription(categoryCore.getDescription());
        category.setCoefficient(categoryCore.getCoefficient());
        logger.info("Object of type CategoryCore has been successfully mapped to Category type.");
        return category;
    }
}