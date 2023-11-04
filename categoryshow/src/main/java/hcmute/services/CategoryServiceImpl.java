package hcmute.services;

import java.util.List;

import javax.servlet.annotation.WebServlet;

import hcmute.DAO.CategoryDAOimpl;
import hcmute.DAO.ICategoryDAO;
import hcmute.models.CategoryModels;
@WebServlet(urlPatterns = {"/icategoryserviceimpl"})
public class CategoryServiceImpl implements ICategoryService {
	//goi cac phuong thuc trong dao
	ICategoryDAO cateDao = new CategoryDAOimpl();
	
	@Override
	public List<CategoryModels> findAll() {
		//xu li logic neu co
		// goi va truyen cho phan DAO
		
		
		return cateDao.findAll();
	}

	@Override
	public void insert(CategoryModels models) {
		// TODO Auto-generated method stub
		//xu li logic
		cateDao.insert(models);
		
	}
	//

	@Override
	public CategoryModels findOne(int id) {
		// TODO Auto-generated method stub
		return cateDao.findOne(id);
	}

	@Override
	public void update(CategoryModels models) {
		CategoryModels oldcate = cateDao.findOne(models.getCateId());
		oldcate.setCateId(models.getCateId());
		oldcate.setCateName(models.getCateName());
		oldcate.setImg(models.getImg());
		oldcate.setStatus(models.getStatus());
		//return cateDao.update(models);
		cateDao.update(oldcate);
	}

}
