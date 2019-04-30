package com.jacklin.myshop.entity;

import java.util.Date;

import lombok.Data;

@Data
public class Notice {
    private Integer id;

    private String ntitle;

    private String ncontent;

    private Date ntime;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNtitle() {
		return ntitle;
	}

	public void setNtitle(String ntitle) {
		this.ntitle = ntitle;
	}

	public String getNcontent() {
		return ncontent;
	}

	public void setNcontent(String ncontent) {
		this.ncontent = ncontent;
	}

	public Date getNtime() {
		return ntime;
	}

	public void setNtime(Date ntime) {
		this.ntime = ntime;
	}




}