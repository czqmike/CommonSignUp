package cn.edu.hbue.test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import cn.edu.hbue.dao.*;

import org.junit.jupiter.api.Test;

class selectNameTest {

	@Test
	void test() {
		ArrayList<String> list = AddonItemDao.selectAddonNamesById(1);
		for (int i = 0; i < list.size(); ++i) {
			System.out.println(list.get(i));
		}
//		fail("Not yet implemented");
	}

}
