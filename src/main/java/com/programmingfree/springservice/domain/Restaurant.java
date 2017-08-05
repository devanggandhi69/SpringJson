package com.programmingfree.springservice.domain;

public class Restaurant {
	private long id;
	private String short_name;
	private String name;
	private String description;
	private String price_small;
	private String price_large;
	private String small_portion_name;
	private String large_portion_name;

	public Restaurant() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Restaurant(long id, String short_name, String name, String description, String price_small,
			String price_large, String small_portion_name, String large_portion_name) {
		super();
		this.id = id;
		this.short_name = short_name;
		this.name = name;
		this.description = description;
		this.price_small = price_small;
		this.price_large = price_large;
		this.small_portion_name = small_portion_name;
		this.large_portion_name = large_portion_name;
	}

	public long getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getShort_name() {
		return short_name;
	}

	public void setShort_name(String short_name) {
		this.short_name = short_name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getPrice_small() {
		return price_small;
	}

	public void setPrice_small(String price_small) {
		this.price_small = price_small;
	}

	public String getPrice_large() {
		return price_large;
	}

	public void setPrice_large(String price_large) {
		this.price_large = price_large;
	}

	public String getSmall_portion_name() {
		return small_portion_name;
	}

	public void setSmall_portion_name(String small_portion_name) {
		this.small_portion_name = small_portion_name;
	}

	public String getLarge_portion_name() {
		return large_portion_name;
	}

	public void setLarge_portion_name(String large_portion_name) {
		this.large_portion_name = large_portion_name;
	}

}
