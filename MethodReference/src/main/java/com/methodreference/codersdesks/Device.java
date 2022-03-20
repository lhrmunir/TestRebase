package com.methodreference.codersdesks;

// http://www.codersdesks.com/java-8-method-reference-with-example/

class Device
{
	int id;
	String type;

	public Device(int id, String type) {
		super();
		this.id = id;
		this.type = type;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	@Override
	public String toString() {
		return "Device [id=" + id + ", type=" + type + "]";
	}
}
