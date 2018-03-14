package hongliang.com.channelmanagement;

import android.content.Intent;
import android.support.design.widget.TabLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Toast;

import com.andy.library.ChannelActivity;
import com.andy.library.ChannelBean;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private TabLayout mMytab;
    private ImageButton mImgBtn;
    private ArrayList<ChannelBean> channelBeens;
    String jsonStr = "";
    private Gson gson;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        initData();

    }
    private void initData(){
        //准备栏目数据
        channelBeens = new ArrayList<ChannelBean>();
        channelBeens.add(new ChannelBean("热点",true));
        channelBeens.add(new ChannelBean("军事",true));
        channelBeens.add(new ChannelBean("八卦",true));
        channelBeens.add(new ChannelBean("游戏",true));
        channelBeens.add(new ChannelBean("宠物",true));
        channelBeens.add(new ChannelBean("汽车",true));
        channelBeens.add(new ChannelBean("热卖",true));
        channelBeens.add(new ChannelBean("外卖",true));
        channelBeens.add(new ChannelBean("条目1",true));
        channelBeens.add(new ChannelBean("条目2",true));
        channelBeens.add(new ChannelBean("条目3",false));
        channelBeens.add(new ChannelBean("条目4",false));
        channelBeens.add(new ChannelBean("条目5",false));
        channelBeens.add(new ChannelBean("条目6",false));
        channelBeens.add(new ChannelBean("条目7",false));
        channelBeens.add(new ChannelBean("条目8",false));
        //把选择的栏目（true）数据配置给tablayout
        for (int i=0;i<channelBeens.size();i++){
            if(channelBeens.get(i).isSelect()){
                mMytab.addTab(mMytab.newTab().setText(channelBeens.get(i).getName()));
            }
        }

    }

    private void initView() {
        mMytab = (TabLayout) findViewById(R.id.mytab);
        mImgBtn = (ImageButton) findViewById(R.id.imgBtn);
        mImgBtn.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {

            case R.id.imgBtn:
                ChannelActivity.startChannelActivity(MainActivity.this,channelBeens);
                break;
            default:
                break;
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == ChannelActivity.REQUEST_CODE && resultCode == ChannelActivity.RESULT_CODE){//为true表示是频道管理回调回来的
            jsonStr = data.getStringExtra(ChannelActivity.RESULT_JSON_KEY);//得到栏目管理的结果
            Toast.makeText(this,jsonStr,Toast.LENGTH_SHORT).show();
            Log.i("main",jsonStr);
            mMytab.removeAllTabs();//清空之前的栏目
            //把新选择的栏目结果更新到tablayout上
            gson = new Gson();
            //进行json解析
            Type type= new TypeToken<ArrayList<ChannelBean>>(){}.getType();
            channelBeens = gson.fromJson(jsonStr,type);
            //遍历结果，更新tablayout
            for (int i=0;i<channelBeens.size();i++){
                if(channelBeens.get(i).isSelect()){
                    mMytab.addTab(mMytab.newTab().setText(channelBeens.get(i).getName()));
                }
            }
        }
    }
}