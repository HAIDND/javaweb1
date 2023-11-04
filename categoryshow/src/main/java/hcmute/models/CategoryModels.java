package hcmute.models;

import java.io.Serializable;



public class CategoryModels implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	//khai bao cac bien trong truuong daabse
	private int cateId;
	private String cateName;
	private String img;
	private int status;

	
	//tao cac structer
		
	public CategoryModels() {
		super();
	}
	
	
	
	public CategoryModels(int cateId, String cateName, String img, int status) {
		super();
		this.cateId = cateId;
		this.cateName = cateName;
		this.img = img;
		this.status = status;
	}
	// tap cac setter va geter
	public int getCateId() {
		return cateId;
	}
	public void setCateId(int cateId) {
		this.cateId = cateId;
	}
	public String getCateName() {
		return cateName;
	}
	public void setCateName(String cateName) {
		this.cateName = cateName;
	}
	public String getImg() {
		return img;
	}
	public void setImg(String img) {
		this.img = img;
	}
	
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}



	@Override
	public String toString() {
		return "CategoryModels [cateId=" + cateId + ", cateName=" + cateName + ", img=" + img + ", status=" + status
				+ "]";
	}
	
	

}
