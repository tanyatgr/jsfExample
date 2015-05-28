package com.bionic.edu;

import java.util.HashMap;
import java.util.LinkedHashMap;

import javax.faces.event.ValueChangeEvent;
import javax.inject.Named;

import org.springframework.context.annotation.Scope;

@Named("mBean")
@Scope("session")
public class MBean {
	private LinkedHashMap<String, String> list;
	private HashMap<String, String> text;
	private String data = "1";
	private String tx = "Text1";

	public MBean() {
		list = new LinkedHashMap<String, String>();
		list.put("Item1", "1");
		list.put("Item 2", "2");
		list.put("Item 3", "3");
		list.put("Item4", "4");
		text = new HashMap<String, String>();
		text.put("1", "Text1");
		text.put("2", "Something like text 2");
		text.put("3", "333333");
		text.put("4", "");
	}

	public LinkedHashMap<String, String> getList() {
		return list;
	}

	public void setList(LinkedHashMap<String, String> list) {
		this.list = list;
	}

	public HashMap<String, String> getText() {
		return text;
	}

	public void setText(HashMap<String, String> text) {
		this.text = text;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	public String getTx() {
		return tx;
	}

	public void setTx(String tx) {
		this.tx = tx;
	}

	public void itemChange(ValueChangeEvent event) {
		String key = (String) event.getNewValue();
		tx = text.get(key);
	}
}
