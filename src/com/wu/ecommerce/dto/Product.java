package com.wu.ecommerce.dto;

import com.wu.ecommerce.exceptions.InvalidIdException;
import com.wu.ecommerce.exceptions.InvalidPriceException;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.ToString.Exclude;

@Getter
@EqualsAndHashCode
@ToString
//@AllArgsConstructor
@NoArgsConstructor
public class Product
//implements Comparable<Product>
{

	public void setProductId(String productId) throws InvalidIdException {
		if (productId == null || productId.equals("") || productId.length() < 3) {
			throw new InvalidIdException("invalid id");

		}
		this.productId = productId;
	}

	@Setter
	private String productId;
	@Setter
	private String productName;

	@Exclude
	private float price;
	@Setter
	private String categoryName;

	public void setPrice(float price) throws InvalidPriceException {
		if (price == 0 || price < 0) {
			throw new InvalidPriceException("Price should be greater than zero");
		}

		this.price = price;
	}

	public Product(String productId, String productName, float price, String categoryName)
			throws InvalidIdException, InvalidPriceException {
		super();
		this.setProductId(productId);
		this.productName = productName;
		this.setPrice(price);
		this.categoryName = categoryName;
	}

//	@Override
//	public int compareTo(Product o) {
//		// TODO Auto-generated method stub
//		return o.productId.compareTo(o.productId);
//	}

//	@Override
//	public String toString() {
//		return "Product object jindabad [productId=" + productId + ", productName=" + productName + ", price=" + price
//				+ ", categoryName=" + categoryName + "]";
//	}

}
