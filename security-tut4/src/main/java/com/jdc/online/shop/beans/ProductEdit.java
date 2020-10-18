package com.jdc.online.shop.beans;

import java.io.Serializable;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import javax.annotation.PostConstruct;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.Part;

import com.jdc.online.shop.model.entity.Product;
import com.jdc.online.shop.model.entity.Property;
import com.jdc.online.shop.model.service.ProductSearvice;
import com.jdc.online.shop.utils.ImageUtils;

@Named
@ViewScoped
public class ProductEdit implements Serializable{

	private static final long serialVersionUID = 1L;
	private Product product;
	private Part photo;
	
	@Inject
	private ProductSearvice service;
	@Inject
	private OwnerShopBean ownerShop;
	
	@PostConstruct
	private void init() {
		HttpServletRequest req = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
		String strId = req.getParameter("id");
		
		if(null == strId) {
			product = new Product();
			product.setShop(ownerShop.getShop());
		} else {
			int id = Integer.parseInt(strId);
			product = service.findById(id);
		}
	}
	
	public String save() {
		// save to db
		service.save(product);
		// navigate to product list
		return "/owner/home?faces-redirect=true";
	}
	
	public void uploadPhotos() {
		
		HttpServletRequest request = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
		ServletContext context = (ServletContext) FacesContext.getCurrentInstance().getExternalContext().getContext();
		
		String imageFolder = context.getRealPath("/resources/images/");
		try {
			int index = 0;
			for(Part file : request.getParts()) {
				if(file.getName().equals(photo.getName())) {
					// Image File Name photo_shopid_timestamp_index.extension
					String extension = ImageUtils.getExtension(file.getSubmittedFileName());
					String imageName = String.format("photo_%d_%s_%d.%s", 
							ownerShop.getShop().getId(),
							LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMddHHmmss")),
							++ index,
							extension);
					Files.copy(file.getInputStream(), Paths.get(imageFolder, imageName), StandardCopyOption.REPLACE_EXISTING);
					product.getPhotos().add(imageName);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	
	}
	
	public void addProperty() {
		product.getProperties().add(new Property());
	}
	
	public void removeProperty(int index) {
		product.getProperties().remove(index);
	}
	
	public void selectPhoto(int index) {
		product.setPhotoIndex(index);
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public Part getPhoto() {
		return photo;
	}

	public void setPhoto(Part photo) {
		this.photo = photo;
	}
	
}
