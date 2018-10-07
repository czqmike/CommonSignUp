package cn.edu.hbue.test;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

import cn.edu.hbue.model.*;
import cn.edu.hbue.dao.*;

class selectAddonItems {

	@Test
	void test() {
		ArrayList<AddonItem> items = AddonItemDao.selectAddonItemsById(TitleToIdDao.selectId("test"));
		for (int i = 0; i < items.size(); ++i) {
			System.out.println(items.get(i).getAddon_name());
			System.out.println(items.get(i).getType());
			System.out.println(items.get(i).getOption());
		}
//		fail("Not yet implemented");
	}

}
