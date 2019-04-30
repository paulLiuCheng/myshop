package com.jacklin.myshop.entity;

import lombok.Data;

@Data
public class GoodsType {
    private Integer id;

    private String typename;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTypename() {
		return typename;
	}

	public void setTypename(String typename) {
		this.typename = typename;
	}
    
    

}