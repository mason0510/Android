package cn.it.homework6;


import cn.it.homework6.db.dao.DBUtils;
import cn.it.homework6.utils.Constants;
import android.app.Activity;
import android.content.ContentValues;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
/**
 * 展示写日记和查看日记的Activity
 * @author lijun
 *
 */
public class NoteActivity extends Activity {
	private EditText titleEt;//标题编辑框
	private EditText contentEt;//内容编辑框
	private Button saveBtn;//保存命令按钮
	private DBUtils dbUtils;//数据库访问的工具类

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_note);
		titleEt=(EditText)findViewById(R.id.title_et);
		contentEt=(EditText)findViewById(R.id.content_et);
		saveBtn=(Button)findViewById(R.id.save_btn);
		dbUtils=new DBUtils(this);
		//获取调用者传递过来的附加数据 
		int type=getIntent().getIntExtra(Constants.DIARY_OPRATION, 0);
		if(type==Constants.DIARY_DETAIL){ //查看笔记的详细内容
			
			String title=getIntent().getStringExtra("title");
			String content=getIntent().getStringExtra("content");
			titleEt.setText(title);
			//标题不可用
			titleEt.setEnabled(false);
			
			contentEt.setText(content);
			//内容不可用
			contentEt.setEnabled(false);
			//保存按钮消失
			saveBtn.setVisibility(View.GONE);
		}
		getActionBar().setDisplayHomeAsUpEnabled(true);//设置Home返回的图标
	}
	
	//保存笔记
	public void save(View v){
		String title=titleEt.getText().toString().trim();
		String content=contentEt.getText().toString();
		ContentValues values=new ContentValues();
		values.put("title", title);
		values.put("content", content);
		dbUtils.save(values);
		finish();
	}
	
	//监听actionBar的返回箭头home按钮
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		//按下返回的home 键
		if(item.getItemId()==android.R.id.home){
			finish();//销毁当前Activity
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
	


}
