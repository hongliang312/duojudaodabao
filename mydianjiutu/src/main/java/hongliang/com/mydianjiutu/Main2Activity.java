package hongliang.com.mydianjiutu;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.util.Log;
import android.widget.TextView;

public class Main2Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        TextView textview=(TextView)findViewById(R.id.tvshow);

        //1dp=1.5px
        //240dp=360px  360px/1.5  hdpi

        //1dp=2px
        //270dp=540px 540px/2  xhdpi

        DisplayMetrics metric =new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(metric);
        // 屏幕宽度（像素）
        int width = metric.widthPixels;
        // 屏幕高度（像素）
        int height = metric.heightPixels;
        //屏幕密度（0.75 / 1.0 / 1.5/2）
        float density = metric.density;
        //屏幕密度DPI（120 / 160 / 240）
        int densityDpi = metric.densityDpi;
        textview.setText("屏幕宽度："+width+" 屏幕高度："+height+" 密度："+density+" 密度dpi:"+densityDpi);
        Log.d("zzz","屏幕宽度："+width+" 屏幕高度："+height+" 密度："+density+" 密度dpi:"+densityDpi);

    }
}
