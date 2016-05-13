package dl.example.administrator.wangyinews;

import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2016/4/14.
 */
public class NewsTitleFragment extends Fragment implements AdapterView.OnItemClickListener{

    private List<News> newsList;
    boolean isTwoPane;
    private NewsAdapter newsAdapter;
    private ListView listView;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
      //  return super.onCreateView(inflater, container, savedInstanceState);
       View view=inflater.inflate(R.layout.news_title_frag,container,false);
        listView = (ListView) view.findViewById(R.id.news_title_list_view);
        listView.setAdapter(newsAdapter);
        listView.setOnItemClickListener(this);
        return view;
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        newsList = getNews();
        newsAdapter = new NewsAdapter(activity, R.layout.news_item,newsList);
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        if(getActivity().findViewById(R.id.news_content_layout)!=null){
            isTwoPane=true;//双叶
        }else {
            isTwoPane=false;//单页
        }

    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        News news=newsList.get(position);

        if(isTwoPane){
//双叶 刷新
            NewsContentFragment newsContentFragment= (NewsContentFragment) getFragmentManager().findFragmentById(R.id.news_content_fragment);
            newsContentFragment.refresh(news.getTitle(),news.getContent());
        }else {
            //单页 直接启动Activity
            NewContentActivity.actionstart(getActivity(),news.getTitle(),news.getContent());

        }
    }









private List<News> getNews(){
    List<News> list=new ArrayList<>();
    News news=new News();

    news.setTitle("hhhhhhhhhhhhhhhhhh");
    news.setContent("哈哈哈哈哈哈哈哈哈哈");
    list.add(news);
        News news2=new News();

    news2.setTitle("xxxxxxxxxxxxxxxxx");
    news2.setContent("嘻嘻嘻嘻嘻嘻嘻嘻嘻嘻嘻");
    list.add(news2);
    return list;

}







}
