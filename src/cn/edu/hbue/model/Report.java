package cn.edu.hbue.model;

import java.util.ArrayList;

import cn.edu.hbue.dao.AddonItemDao;
import cn.edu.hbue.dao.CommonItemsDao;
import cn.edu.hbue.dao.TitleToIdDao;
import cn.edu.hbue.model.*;

/**
 * @author czqmike
 * @date 2018年9月20日
 * @description 一个Report实例代表一项报名，其中包含基础项及附加项
 */
public class Report {
	private CommonItems commonItem;
	private ArrayList<AddonItem> addonItem;
	
	public Report() {
		commonItem = null;
		addonItem = null;
	}
	
	// TODO:添加用附加表id去构造一项报名的代码
	public Report(int addon_id) {
		this.commonItem = CommonItemsDao.selectByAddonId(addon_id);
		this.addonItem = AddonItemDao.selectAddonItemsById(addon_id);
	}
	
	public CommonItems getCommonItem() {
		return commonItem;
	}
	public void setCommonItem(CommonItems commonItem) {
		this.commonItem = commonItem;
	}
	public ArrayList<AddonItem> getAddonItem() {
		return addonItem;
	}
	public void setAddonItem(ArrayList<AddonItem> addonItem) {
		this.addonItem = addonItem;
	}

}
