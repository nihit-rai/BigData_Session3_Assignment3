package com.acadgild.assignment3_3_1;
import org.apache.hadoop.io.Text;

public class TvBean {
public String CompanyName, Product, Size,State,PinCode,Price;

public TvBean(String companyName, String product, String size, String state, String pinCode, String price) {
	
	CompanyName=companyName;
	Product=product;
	
	Size=size;
	State=state;
	PinCode=pinCode;
	Price=price;
	
}

public String getCompanyName() {
	return CompanyName;
}

public void setCompanyName(String companyName) {
	CompanyName = companyName;
}

public String getProduct() {
	return Product;
}

public void setProduct(String product) {
	Product = product;
}



public String getSize() {
	return Size;
}

public void setSize(String size) {
	Size = size;
}

public String getState() {
	return State;
}

public void setState(String state) {
	State = state;
}

public String getPinCode() {
	return PinCode;
}

public void setPinCode(String pinCode) {
	PinCode = pinCode;
}

public String getPrice() {
	return Price;
}

public void setPrice(String price) {
	Price = price;
}


}
