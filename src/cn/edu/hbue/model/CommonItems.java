package cn.edu.hbue.model;

/**
 * @author czqmike
 * @date 2018年8月4日
 * @description  一个CommonItems实例对应common_items的一条记录
 * @waring class为了和关键字不冲突而采用class_
 */
public class CommonItems {
	
	private String name = "";
	private String student_no = "";
	private String class_ = "";
	private String report_year = "";
	private int addon_id = -1;
	
	public CommonItems() {
	}
	
	public CommonItems(String name, String student_no, String class_, String report_year, int addon_id) {
		super();
		this.name = name;
		this.student_no = student_no;
		this.class_ = class_;
		this.report_year = report_year;
		this.addon_id = addon_id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getStudent_no() {
		return student_no;
	}

	public void setStudent_no(String student_no) {
		this.student_no = student_no;
	}

	public String getClass_() {
		return class_;
	}

	public void setClass_(String class_) {
		this.class_ = class_;
	}

	public String getReport_year() {
		return report_year;
	}

	public void setReport_year(String report_year) {
		this.report_year = report_year;
	}

	public void setAddon_id(int addon_id) {
		this.addon_id = addon_id;
	}
	
	public int getAddon_id() {
		return this.addon_id;
	}
}
