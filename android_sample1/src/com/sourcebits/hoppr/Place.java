package com.sourcebits.hoppr;

import java.io.Serializable;

public class Place  implements Serializable{

	private String title = null;
	private String subTitle = null;
	private int iconId;
	
	public Place(String title,String subTitle){
		this.title = title;
		this.subTitle =subTitle;
	}
	protected String getTitle() {
		return title;
	}
	protected void setTitle(String title) {
		this.title = title;
	}
	protected String getSubTitle() {
		return subTitle;
	}
	protected void setSubTitle(String subTitle) {
		this.subTitle = subTitle;
	}
	protected int getIconId() {
		return iconId;
	}
	protected void setIconId(int iconId) {
		this.iconId = iconId;
	}
	
}
