package hongliang.com.handler;

import android.app.Activity;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

import okhttp3.OkHttpClient;

public class MainActivity extends Activity {

    private ImageView image;
    private Handler handler = new Handler();
    private int imagees[]={R.drawable.a,R.drawable.b,R.drawable.c,R.drawable.d,R.drawable.e,R.drawable.f,R.drawable.g,R.drawable.h};
    private int index;
    private MyRunnable myRunnable = new MyRunnable();
    class MyRunnable implements Runnable{

        @Override
        public void run() {
            index++;
            index=index%7;
            image.setImageResource(imagees[index]);
            handler.postDelayed(myRunnable,1000);
        }
    }


  /*  Handler handlerr=new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
        }
    };
    */

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        image = findViewById(R.id.imag1);
        handler.postDelayed(myRunnable,1000);
       /* Message message = new Message();
        message.obj = "22";
        handler.sendMessage(message);*/


    }
}
