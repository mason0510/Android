package cn.it.homework6.utils;

public class Constants {

//
//	public static final String WEB_LOGIN = "http://192.168.32.9:8080/web/video_login"; //访问局域网地址或者外网网地址
//	public static final String WEB_REGISTER = "http://192.168.32.9:8080/web/video_register"; //访问局域网地址，广域网地址
//	public static final String IMAGE_LOGIN = "http://192.168.32.9:8080/web/";
//	
	
	public static final String WEB_LOGIN = "http://10.0.2.2:8080/androidWeb/video_login";//代表android系统连接的本windows系统的地址 
	public static final String IMAGE_LOGIN = "http://10.0.2.2:8080/androidWeb/";  
	public static final String WEB_REGISTER = "http://10.0.2.2:8080/androidWeb/video_register";
	
	
	
	//手机要连接电脑 ，电脑是服务器   ：解决方式 ： 电脑或者手机开启一个热点  使电话和手机在一个网段
//	public static final String WEB_LOGIN = "http://192.168.43.67:8080/web/video_login";
//	public static final String WEB_REGISTER = "http://192.168.43.67:8080/web/video_register";
//	public static final String IMAGE_LOGIN = "http://192.168.43.67:8080/web/";  
	
	 //日记操作
	  public static final int DIARY_EDIT=1;//编辑日记
	  public static final String DIARY_OPRATION="diary_opration";//日记操作指令
	  public static final int DIARY_DETAIL=2;//查看日记
}
