package hcmute.DAO;

import java.util.List;

import hcmute.models.CategoryModels;

public interface ICategoryDAO {

	
	// dinh nghia cac phuojngthuc 
	List<CategoryModels> findAll();
	void insert(CategoryModels models);
	
	CategoryModels findOne(int id);
	
	
	void update(CategoryModels models);
	
}
