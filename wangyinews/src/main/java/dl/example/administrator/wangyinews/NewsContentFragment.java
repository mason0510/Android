package dl.example.administrator.wangyinews;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by Administrator on 2016/4/14.
 */
public class NewsContentFragment extends Fragment {
    private View view;
    private TextView textView;
    private TextView newcontentview;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.news_content_frag,null);
        return view;
    }
    public void refresh(String newsTitle,String newscontent){
        View visibilityLayout=view.findViewById(R.id.visibility_layout);
        visibilityLayout.setVisibility(View.VISIBLE);
        textView = (TextView) view.findViewById(R.id.news_title);
        newcontentview = (TextView) view.findViewById(R.id.news_content);
        textView.setText(newsTitle);//刷新标题和内容
        newcontentview.setText(newscontent);
    }
}
