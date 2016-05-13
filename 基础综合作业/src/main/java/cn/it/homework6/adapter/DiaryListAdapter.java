package cn.it.homework6.adapter;

import java.util.List;
import java.util.Map;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import cn.it.homework6.R;

public class DiaryListAdapter extends BaseAdapter {
	private  Context context;//上下文
	private List<Map<String, Object>> data;//要装配的数据
    
	public DiaryListAdapter(Context context, List<Map<String, Object>> data) {
		this.context=context;
		this.data=data;
	}
	
	//设置要装配的数据
	public void setData(List<Map<String, Object>> data){
		this.data=data;
	}

	@Override
	public int getCount() {
		return data==null?0:data.size();
	}

	@Override
	public Object getItem(int position) {
		return data==null?null:data.get(position);
	}

	@Override
	public long getItemId(int position) {
		return data==null?0:Long.valueOf(data.get(position).get("_id").toString());
	}
    //取得列表项视图对象
	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		Map<String,Object> map=data.get(position);
		if(convertView==null){ //通过可回收的View优化自定义适配器
			convertView=LayoutInflater.from(context).inflate(R.layout.note_item, parent, false);
		}
		TextView titleTv=(TextView) convertView.findViewById(R.id.title_tv);
		TextView contentTv=(TextView) convertView.findViewById(R.id.content_tv);
		titleTv.setText(map.get("title").toString());
		contentTv.setText(map.get("content").toString());
		return convertView;
	}
	
}
