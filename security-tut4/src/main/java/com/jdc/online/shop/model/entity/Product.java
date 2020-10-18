package com.jdc.online.shop.model.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CollectionTable;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Transient;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

@Entity
public class Product implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@NotBlank(message = "Please enter product name.")
	private String name;
	private String brand;
	@ManyToOne(optional = false)
	private Shop shop;
	private boolean used;
	@Min(value = 100, message = "Please enter product price.")
	private int price;

	@CollectionTable(name = "product_photo")
	@ElementCollection(fetch = FetchType.EAGER)
	private List<String> photos;

	@CollectionTable(name = "product_prop")
	@ElementCollection
	private List<Property> properties;

	private boolean soldOut;
	
	@Transient
	private int photoIndex;

	public Product() {
		photos = new ArrayList<>();
		properties = new ArrayList<>();
	}
	
	public String getCoverImage() {
		if(photos.size() > photoIndex) {
			return photos.get(photoIndex);
		}
		
		return "product.jpeg";
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public Shop getShop() {
		return shop;
	}

	public void setShop(Shop shop) {
		this.shop = shop;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public boolean isUsed() {
		return used;
	}

	public void setUsed(boolean used) {
		this.used = used;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public List<String> getPhotos() {
		return photos;
	}

	public void setPhotos(List<String> photos) {
		this.photos = photos;
	}

	public List<Property> getProperties() {
		return properties;
	}

	public void setProperties(List<Property> properties) {
		this.properties = properties;
	}

	public boolean isSoldOut() {
		return soldOut;
	}

	public void setSoldOut(boolean soldOut) {
		this.soldOut = soldOut;
	}

	public int getPhotoIndex() {
		return photoIndex;
	}

	public void setPhotoIndex(int photoIndex) {
		this.photoIndex = photoIndex;
	}
	
	

}
