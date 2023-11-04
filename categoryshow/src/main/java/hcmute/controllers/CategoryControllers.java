package hcmute.controllers;

import java.io.IOException;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mysql.cj.x.protobuf.MysqlxCrud.Update;

import hcmute.models.CategoryModels;
import hcmute.services.CategoryServiceImpl;
import hcmute.services.ICategoryService;

//@WebServlet(urlPatterns = {"/listcate"})
@WebServlet(urlPatterns = { "/category/add", "/category/findAll", "/category/update" })

public class CategoryControllers extends HttpServlet {
	// goi cac phuong thuc
	ICategoryService cateService = new CategoryServiceImpl();

	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String url = req.getRequestURI().toString();
		if (url.contains("findAll")) {
			findAll(req, resp);
		} else if (url.contains("add")) {
			RequestDispatcher rd = req.getRequestDispatcher("/views/addCategory.jsp");
			rd.forward(req, resp);

		} else if (url.contains("update")) {
			String id1 = req.getParameter("id");
			id1 = id1.trim();
			// int id = Integer.parseInt(id1);
			// int id = Integer.parseInt(req.getParameter("id"));

			String idParam = req.getParameter("id");
			idParam = idParam.trim(); // Loại bỏ khoảng trắng từ cả hai đầu của chuỗi
			int id = Integer.parseInt(idParam);
			// CategoryModels models = cateService.findOne(id);

			CategoryModels models = cateService.findOne(id);
			req.setAttribute("cate", models);
			RequestDispatcher rd = req.getRequestDispatcher("/views/updateCategory.jsp");
			rd.forward(req, resp);
		}

	}



	private void update(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		req.setCharacterEncoding("UTF-8");
		resp.setCharacterEncoding("UTF-8");

		// nhan du lieu tu form
		String name = req.getParameter("cateName");
		String img = req.getParameter("images");
		int status = Integer.parseInt(req.getParameter("status"));
		int id = Integer.parseInt(req.getParameter("cateId"));

		// dua du lieu vao model
		CategoryModels cate = new CategoryModels();
		cate.setCateId(id);
		cate.setCateName(name);
		cate.setImg(img);
		cate.setStatus(status);
		// goi phuong thuc insert trong services
		cateService.update(cate);
		// tra ve view
		resp.sendRedirect(req.getContextPath() + "/category/findAll");

	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String url = req.getRequestURI().toString();
		if (url.contains("add")) {
			insert(req, resp);
		} else if (url.contains("update")) {
			update(req, resp);
		}
	}

	private void insert(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		req.setCharacterEncoding("UTF-8");
		resp.setCharacterEncoding("UTF-8");

		// nhan du lieu tu form
		String cateId1 = req.getParameter("cateId");
		int cateId = Integer.parseInt(cateId1);

		String cateName = req.getParameter("cateName");
		String images = req.getParameter("images");

		String status1 = req.getParameter("status");
		int status = Integer.parseInt(status1);
		// dua du lieu vao model
		CategoryModels cate = new CategoryModels();
		cate.setCateId(cateId);
		cate.setCateName(cateName);
		cate.setImg(images);
		cate.setStatus(status);
		// goi phuong thuc insert trong services
		cateService.insert(cate);
		// tra ve view
		resp.sendRedirect(req.getContextPath() + "/category/findAll");

	}

	private void findAll(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		List<CategoryModels> listcate = cateService.findAll();
		// push data
		req.setAttribute("list", listcate);
		/// view show data
		RequestDispatcher rd = req.getRequestDispatcher("/views/listCategory.jsp");
		rd.forward(req, resp);

	}
}
