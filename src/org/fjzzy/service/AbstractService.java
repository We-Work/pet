package org.fjzzy.service;

import java.util.ArrayList;

import org.fjzzy.util.SqlHelper;

public abstract class AbstractService {
	public int getRowCount(String sql, String[] paras){
		ArrayList<Object[]> list = SqlHelper.executeQuery(sql, paras);
		return Integer.parseInt(list.get(0)[0].toString());
	}
}
