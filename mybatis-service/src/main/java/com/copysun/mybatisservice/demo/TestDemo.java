package com.copysun.mybatisservice.demo;

import java.util.HashMap;
import java.util.Map;

public class TestDemo {
	public static void main(String[] args) {

//		BigDecimal bigDecimal=BigDecimal.ZERO;
//		List<String> list= Arrays.asList("1","2","3");
//		list.stream().forEach(e->{
//			bigDecimal=bigDecimal.add(new BigDecimal("1"));
//		});
//		System.out.println(bigDecimal);
        String queryDate="2021-12-28";

		int year = Integer.valueOf(queryDate.substring(0, 4));
		int month = Integer.valueOf(queryDate.substring(5, 7));
		Map<String, String> stringStringMap = calcSeason(year, month);
		System.out.println(stringStringMap.get("SEASON_BEGIN").toString());
		System.out.println(stringStringMap.get("SEASON_END").toString());


	}

	/**
	 * 该方法用于计算给定年月所在季度的季初、季末日期
	 *
	 * @param year
	 * @param month
	 * @return
	 */
	public static Map<String, String> calcSeason(int year, int month)
	{
		Map<String, String> map = new HashMap<String, String>();
		String seasonEndDate = "";
		String seasonBeginDate = "";
		if (month >= 1 && month <= 3)
		{
			seasonBeginDate = year + "-01-01";
			seasonEndDate = year + "-03-31";
		}
		else if (month >= 4 && month <= 6)
		{
			seasonBeginDate = year + "-04-01";
			seasonEndDate = year + "-06-30";
		}
		else if (month >= 7 && month <= 9)
		{
			seasonBeginDate = year + "-07-01";
			seasonEndDate = year + "-09-30";
		}
		else
		{
			seasonBeginDate = year + "-10-01";
			seasonEndDate = year + "-12-31";
		}
		map.put("SEASON_BEGIN", seasonBeginDate);
		map.put("SEASON_END", seasonEndDate);

		return map;
	}
}
