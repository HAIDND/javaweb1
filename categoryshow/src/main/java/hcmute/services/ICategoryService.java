package hcmute.services;

import java.util.List;
import java.util.Locale.Category;

import javax.servlet.annotation.WebServlet;

import hcmute.models.CategoryModels;
@WebServlet(urlPatterns = {"/icategoryservice"})
public interface ICategoryService {
	//dinh nghia cac phuong thuc phuong thuc ten khac ccung duoc
	List<CategoryModels> findAll();//findall cua aervice. doi ten cung dc
	
	void insert(CategoryModels models) ;
	
	CategoryModels findOne(int id);
	
	void update(CategoryModels models);
}
