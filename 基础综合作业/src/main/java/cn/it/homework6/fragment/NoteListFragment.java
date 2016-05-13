package cn.it.homework6.fragment;

import java.util.List;
import java.util.Map;

import cn.it.homework6.HomeActivity;
import cn.it.homework6.NoteActivity;
import cn.it.homework6.R;
import cn.it.homework6.adapter.DiaryListAdapter;
import cn.it.homework6.db.dao.DBUtils;
import cn.it.homework6.utils.Constants;
import android.app.Fragment;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
/**展示日记列表的片段
 * @author lijun
 */
public class NoteListFragment extends Fragment {
	private TextView mNameTv;//昵称文本框
	private DBUtils dbUtils;//数据库访问工具
	private List<Map<String,Object>> data;//展示日记列表的封装数据
	private DiaryListAdapter adapter;//适配器
	private ListView noteListView;//列表视图
	
	private Context context;
	private View fragmentRootView;//片段界面根节点视图对象
	@Override
	public void onCreate(Bundle savedInstanceState) {
		context=getActivity();//获取上下文 
		super.onCreate(savedInstanceState);
	}
	
	//创建片段界面视图
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		fragmentRootView = inflater.inflate(R.layout.layout_note_list, container, false);
		
		mNameTv = (TextView)fragmentRootView.findViewById(R.id.name_tv);
		//设置昵称
		String nick=context.getSharedPreferences("info", Context.MODE_PRIVATE).getString("nick", null);
		if(nick!=null){
			mNameTv.setText(nick);
		}
		
		dbUtils=new DBUtils(context);
		noteListView = (ListView)fragmentRootView.findViewById(R.id.note_lstview);
		//点击列表项，监听
		noteListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> parent, View view,
					int position, long id) {
				Map<String,Object> map=data.get(position);
				Intent intent=new Intent(context,NoteActivity.class);
				//操作类型：  查看详情 
				intent.putExtra(Constants.DIARY_OPRATION, Constants.DIARY_DETAIL);
				//附加当前点击的列表项的标题和内容数据
				intent.putExtra("title",map.get("title").toString());
				intent.putExtra("content",map.get("content").toString());
				startActivity(intent);
			}
		});
		return fragmentRootView;
	}
	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
		super.onActivityCreated(savedInstanceState);
		//对 新建按钮 添加点击监听事件 
		fragmentRootView.findViewById(R.id.write_btn)
		.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Intent intent=new Intent();
				intent.setClass(context, NoteActivity.class);
				startActivity(intent);
			}
		});
		
	}
	
	//恢复的方法 。Activity调用了onResume  ,之后会调用片段的onResume
	@Override
	public void onResume() {
		data = dbUtils.queryList();
		if(adapter==null){
			// getBaseContext() 获取WrapperContext 上下文 
			adapter=new DiaryListAdapter(context, data);
			noteListView.setAdapter(adapter);
		}else{
			//更新数据
			adapter.setData(data);  
			//通知ListView数据集发生改变 
			adapter.notifyDataSetChanged();
		}
			super.onResume();
	}

}
