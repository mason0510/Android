package dl.example.administrator.wangyinews;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

/**
 * Created by Administrator on 2016/4/13.
 */
public class NewsAdapter extends ArrayAdapter<News> {


    private final int resourceId;


    public NewsAdapter(Context context, int textViewResourceId, List<News> objects){
            super(context,textViewResourceId,objects);
        resourceId = textViewResourceId;//用于显示视图的资源id文件
        }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        News news=getItem(position);//根据数组的位置获取对象
        View view;
        if(convertView==null){
            //获取一个界面
            view=LayoutInflater.from(getContext()).inflate(resourceId,null);//获取一个view
        }else {
            view=convertView;
        }
//空指针异常
      /*  assert view != null;*/
        try {
            TextView newstitle = (TextView)view.findViewById(R.id.news_title);
            newstitle.setText(news.getTitle());//放置
        } catch (Exception e) {
            e.printStackTrace();
        }
        //返回一个设置了textview的view.


        return view;
    }
}
