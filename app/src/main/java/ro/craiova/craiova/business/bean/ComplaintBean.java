package ro.craiova.craiova.business.bean;

import java.util.Date;

/**
 * Created by Andrei.
 */

public class ComplaintBean {

	private Date date;

	private String type;

	private String location;

	public ComplaintBean() {
	}

	public ComplaintBean(Date date, String type, String location) {
		this.date = date;
		this.type = type;
		this.location = location;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}
}
