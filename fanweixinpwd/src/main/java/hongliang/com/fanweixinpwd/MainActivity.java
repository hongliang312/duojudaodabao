package hongliang.com.fanweixinpwd;

import android.app.Activity;
import android.os.Bundle;
import android.widget.Toast;

public class MainActivity extends Activity {

    private PwdEditText mPetPwd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mPetPwd = (PwdEditText) findViewById(R.id.pet_pwd);
        mPetPwd.setOnInputFinishListener(new PwdEditText.OnInputFinishListener() {

            @Override
            public void onInputFinish(String password) {

                Toast.makeText(MainActivity.this, password, 1).show();
            }
        });
    }

}
