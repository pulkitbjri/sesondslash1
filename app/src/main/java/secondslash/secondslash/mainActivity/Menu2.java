package secondslash.secondslash.mainActivity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import secondslash.secondslash.R;


/**
 * Created by alokit nigam on 10/8/2015.
 */
public class Menu2 extends android.support.v4.app.Fragment {
    View v;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        v=inflater.inflate(R.layout.menu2_layout,container,false);
        return v;
    }
}
