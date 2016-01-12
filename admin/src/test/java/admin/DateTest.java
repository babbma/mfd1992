package admin;

import org.junit.Test;

import com.app.util.DateUtil;

public class DateTest {

	@Test
	public void test(){
		System.out.println(DateUtil.toDateString(DateUtil.currentDayBegin().getTime(), "yyyy-MM-dd HH:mm:ss"));
	}
}
