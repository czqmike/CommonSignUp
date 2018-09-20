package cn.edu.hbue.model;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class AddonItem {
	private String addon_name;
	private String addon_value;
	private String type;
	private String option; 		// option应该是若干个或0个选项以【`】拼接而成的String

	public AddonItem() {
		this.addon_name = this.addon_value = 
			this.type = this.option = "";
	}

	public AddonItem(JSONObject item) {
		try {
			// 把JSON对象转化为Java Bean
			this.addon_name = item.getString("item_name");
			this.addon_value = "";
			this.type = item.getString("item_type");

//			JSONArray options = new JSONArray(item.getJSONArray("item_value"));
			JSONArray options = new JSONArray(item.getString("item_value"));
			String option = "";
			for (int i = 0; i < options.length(); ++i) {
				if (i != 0) {
					option += "`";
				}
				option += options.getString(i);
			}
			this.option = option;
		} catch (JSONException e) {
			// 转化失败则置为空串
			e.printStackTrace();
			this.addon_name = this.addon_value = 
				this.type = this.option = "";
		}
	}

	public AddonItem(String addon_name, String addon_value, String type, String option) {
		this.addon_name = addon_name;
		this.addon_value = addon_value;
		this.type = type;
		this.option = option;
	}

	public AddonItem(AddonItem another) {
		this.addon_name = another.getAddon_name();
		this.addon_value = another.getAddon_value();
		this.type = another.getType();
		this.option = another.getOption();
	}

	public String getAddon_name() {
		return addon_name;
	}
	public void setAddon_name(String addon_name) {
		this.addon_name = addon_name;
	}
	public String getAddon_value() {
		return addon_value;
	}
	public void setAddon_value(String addon_value) {
		this.addon_value = addon_value;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getOption() {
		return option;
	}
	public void setOption(String option) {
		this.option = option;
	}
	
}
