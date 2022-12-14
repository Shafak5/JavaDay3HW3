package business;

import java.util.List;

import core.logging.ILogger;
import dataAccess.ICategoryDao;
import entities.Category;

public class CategoryManager {
	private ICategoryDao iCategoryDao;
	private ILogger[] loggers;
	private List<Category> categories;

	public CategoryManager(ICategoryDao iCategoryDao, ILogger[] loggers, List<Category> categories) {
		this.iCategoryDao = iCategoryDao;
		this.loggers = loggers;
		this.categories = categories;
	}

	public void add(Category category) throws Exception{
		for(Category newcategory : categories) {
			if (newcategory.getName().equals(category.getName())) {
				throw new Exception("kategorinin adi daha once kullanilmis");
			}
		}
		iCategoryDao.add(category);
		categories.add(category);

		for(ILogger logger : loggers) {
			logger.log(category.getName() + " eklendi");
		}
	}
}
