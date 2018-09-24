package algorithm;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Regexp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//email地址
		//String ex ="^\\w+([-+.]\\w+)*@\\w+([-.]\\w+)*\\.\\w+([-.]\\w+)*$";
        //String input = "zhangtanww@126.com";
		//电话号码
		//String ipNumber = "18392114596";
		//String input = "^1[3|4|5|8][0-9]\\d{8}$";
		
		//字幕下划线数字
		//String str = "hell_a123";
		//String input = "^[A-Za-z][A-Za-z_0-9]+$";
		
		//url
		//String url = "www.hao123.com";
		//String input = "^((http|https)://)?([\\w]+\\.)+[\\w]+(/[\\w./?%&=]*)?$";
        
		//身份证号码
		String id = "612401198806514580";
		String input = "^(\\d{6})(18|19|20)?(\\d{2})([01]\\d{1})(\\d{1})([0123]\\d)(\\d{3})(\\d|X|x)?$";
		
		regfun(input,id);
	}
	
	
	public static void regfun(String reg, String text)
	{
		Pattern p = Pattern.compile(reg);
		Matcher m = p.matcher(text);
		if(m.find())
		{
			System.out.println("right");
		}
		else
		{
			System.out.println("wrong");
		}
	}

}
