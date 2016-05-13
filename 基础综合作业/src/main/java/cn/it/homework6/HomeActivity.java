package cn.it.homework6;

import cn.it.homework6.fragment.NoteListFragment;
import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.Window;
import android.widget.Toast;

public class HomeActivity extends Activity {

	private FragmentManager mFt;//片段管理器
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);//没有标题,设置窗口的样式
		setContentView(R.layout.activity_home);
		// 创建 日记列表片段
		Fragment noteListFragment=new NoteListFragment();
		//片段管理器
		mFt = getFragmentManager();
		FragmentTransaction bt = mFt.beginTransaction();
		//添加或者替换片段到content容器中
		bt.replace(R.id.content, noteListFragment).commit();
		}
	
	//再按一次，退出系统
	private long mCurrentTime=0;//保存当前的按键时间
	@Override
	public boolean onKeyDown(int keyCode, KeyEvent event) {
		System.out.println(keyCode+"按键码");
		//返回键4  ，菜单键 82  home键 
		if(keyCode==KeyEvent.KEYCODE_BACK){//当按下返回键
			if(System.currentTimeMillis()-mCurrentTime>2000){
				Toast.makeText(getApplicationContext(), "再按一次，退出系统", Toast.LENGTH_SHORT).show();
				mCurrentTime=System.currentTimeMillis();
			}else{//两次按键在两秒之内
				finish();
			}
			return true;
		}
		return super.onKeyDown(keyCode, event);
	}
}
