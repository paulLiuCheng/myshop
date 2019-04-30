package com.jacklin.myshop.entity;

import java.util.Date;

import lombok.Data;

@Data
public class Goods {
    private Integer id;

    private String gname;

    private Double goprice;

    private Double grprice;

    private Integer gstore;

    private String gpicture;

    private GoodsType goodstypeId;

    private Date iputTime;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getGname() {
		return gname;
	}

	public void setGname(String gname) {
		this.gname = gname;
	}

	public Double getGoprice() {
		return goprice;
	}

	public void setGoprice(Double goprice) {
		this.goprice = goprice;
	}

	public Double getGrprice() {
		return grprice;
	}

	public void setGrprice(Double grprice) {
		this.grprice = grprice;
	}

	public Integer getGstore() {
		return gstore;
	}

	public void setGstore(Integer gstore) {
		this.gstore = gstore;
	}

	public String getGpicture() {
		return gpicture;
	}

	public void setGpicture(String gpicture) {
		this.gpicture = gpicture;
	}

	public GoodsType getGoodstypeId() {
		return goodstypeId;
	}

	public void setGoodstypeId(GoodsType goodstypeId) {
		this.goodstypeId = goodstypeId;
	}

	public Date getIputTime() {
		return iputTime;
	}

	public void setIputTime(Date iputTime) {
		this.iputTime = iputTime;
	}
    
    
}