package hongliang.com.channelmanagement;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by 知足 on 2018/3/14.
 */

public class content extends Fragment {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View inflate = View.inflate(getActivity(), R.layout.contentlayout, null);
        TextView cte = inflate.findViewById(R.id.cte);
        Bundle arguments = getArguments();
        String name = arguments.getString("name");

        Log.e("chen", "onCreateView: ------"+name );
        cte.setText(name);
        return inflate;
    }
}
