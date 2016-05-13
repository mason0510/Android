package dl.example.administrator.wangyinews;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

/**
 * Created by Administrator on 2016/4/13.
 */
public class NewContentActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.news_content);

        String newsTitle=getIntent().getStringExtra("news_title");
        String newsContent=getIntent().getStringExtra("news_content");
        NewsContentFragment news_content_fragment= (NewsContentFragment) getFragmentManager().findFragmentById(R.id.news_content_fragment);




    }


    public static void actionstart(Context context,String newstitle,String newscontent){
        Intent intent=new Intent(context,NewContentActivity.class);
        intent.putExtra("news_title",newstitle);
        intent.putExtra("news_content","");

    }
}
