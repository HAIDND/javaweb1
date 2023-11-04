package hcmute.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.annotation.WebServlet;

import hcmute.models.CategoryModels;
@WebServlet(urlPatterns = {"/cateDAO"})
public class CategoryDAOimpl implements ICategoryDAO{

	@Override
	public List<CategoryModels> findAll() {
		// TODO Auto-generated method stub
		
		//xi li du lieu hien thi tat ca category
		//findAll();
		//ket noi database
				//truy van dulieu
				// chuye ddu lieu ra view
				//view nao se nhan duoc du lieu
				List<CategoryModels> listcate = new ArrayList<CategoryModels>();
				String truyvan = "Select * from category";
				try {
					new DBCONNECserver();
					Connection conn = new DBCONNECserver().getConnection();//ket noidatabase
					PreparedStatement ps = conn.prepareStatement(truyvan);//thuc hien truy van
					ResultSet rs = ps.executeQuery();
					
					while (rs.next()) {
						CategoryModels category = new CategoryModels();
						category.setCateId(rs.getInt("categoryId"));
						category.setCateName(rs.getString("categoryName"));
						category.setImg(rs.getString("images"));
						category.setStatus(rs.getInt("status"));
						
						listcate.add(category);						
					}					
					System.out.println(new DBCONNECserver().getConnection());
					int a = 1;
					if (a == 1) {
						System.out.print("connec thanh cong");
					}					
				} catch (Exception e) {
					e.printStackTrace();
				}
		return listcate;
	}
//tang sevice controll xuong dao roio xuong seervice
	@Override
	public void insert(CategoryModels models) {
		// TODO Auto-generated method stub
		//xuli them category
		List<CategoryModels> listcate = new ArrayList<CategoryModels>();
		String sql = "Insert into category(categoryId,categoryName,images,status) values (?,?,?,?)";
		//tryy catch
		try {
			new DBCONNECserver();
			Connection conn = new DBCONNECserver().getConnection();//ket noidatabase
			PreparedStatement ps = conn.prepareStatement(sql);//thuc hien truy van
			// gans gia tri cho tham so
			ps.setInt(1, models.getCateId());
			ps.setString(2, models.getCateName());
			ps.setString(3, models.getImg());
			ps.setInt(4,models.getStatus());			
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				CategoryModels category = new CategoryModels();
				category.setCateId(rs.getInt("categoryId"));
				category.setCateName(rs.getString("categoryName"));
				category.setImg(rs.getString("images"));
				category.setStatus(rs.getInt("status"));				
				listcate.add(category);				
			}			
			System.out.println(new DBCONNECserver().getConnection());
			int a = 1;
			if (a == 1) {
				System.out.print("connec thanh cong");
			}			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	@Override
	public CategoryModels findOne(int id) {
		//xuli du lieu
		String sql = "Select * from category Where categoryId=?";
		CategoryModels models = new CategoryModels();
		try {
			Connection  conn = new DBCONNECserver().getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				
				models.setCateId(rs.getInt("categoryId"));
				models.setCateName(rs.getString("categoryName"));
				models.setImg(rs.getString("images"));
				models.setStatus(rs.getInt("status"));	
			}
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return models;
}
	@Override
	public void update(CategoryModels models) {
		// sai lenh String sql = "update category set categoryName=? images=? status=? Where categoryId=?";
		String sql = "UPDATE category SET categoryName=?, images=?, status=? WHERE categoryId=?";

		try {
			Connection conn = new DBCONNECserver().getConnection();//ket noidatabase
			PreparedStatement ps = conn.prepareStatement(sql);//thuc hien truy van
			// gans gia tri cho tham so
			
			ps.setString(1, models.getCateName());
			ps.setString(2, models.getImg());
			ps.setInt(3,models.getStatus());
			ps.setInt(4, models.getCateId());			
			ps.executeUpdate();
			conn.close();
		
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
