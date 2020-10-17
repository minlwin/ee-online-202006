package com.jdc.online.shop.beans;

import java.io.Serializable;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import javax.servlet.ServletContext;

import com.jdc.online.shop.model.entity.Member;
import com.jdc.online.shop.model.entity.Shop;
import com.jdc.online.shop.model.service.ShopService;
import com.jdc.online.shop.utils.ImageUtils;

@Named
@SessionScoped
public class OwnerShopBean implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Named("loginUser")
	@Inject
	private Member owner;
	
	private Shop shop;
	
	@Inject
	private ImageUtils coverImage;
	
	@Inject
	private ShopService service;
	
	@PostConstruct
	private void init() {
		shop  = service.findByOnwer(owner);
	}
	
	public void uploadCover() {
		
		if(null != coverImage.getInputFile()) {
			
			try {
				// get image file name
				String coverFileName = String.format("cover_%s.%s", LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMddHHmmss")), coverImage.getExtension());
				
				// get image directory
				ServletContext context = (ServletContext) FacesContext.getCurrentInstance().getExternalContext().getContext();
				String imageFolder = context.getRealPath("/resources/images/");
				
				// copy image
				Files.copy(coverImage.getInputStream(), Paths.get(imageFolder, coverFileName), StandardCopyOption.REPLACE_EXISTING);
				
				// update file name to shop
				shop.setCoverImage(coverFileName);
				
				service.save(shop);
				
			} catch (Exception e) {
				e.printStackTrace();
			}
			
		}
		
	}
	
	public void saveShopInfo() {
		shop = service.save(shop);
	}
	
	public void changeState() {
		shop.setPublished(!shop.isPublished());
		shop = service.save(shop);
	}

	public Shop getShop() {
		return shop;
	}

	public void setShop(Shop shop) {
		this.shop = shop;
	}

	public ImageUtils getCoverImage() {
		return coverImage;
	}

	public void setCoverImage(ImageUtils coverImage) {
		this.coverImage = coverImage;
	}
	
}
