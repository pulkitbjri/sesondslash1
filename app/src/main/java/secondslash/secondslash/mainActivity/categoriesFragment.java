package secondslash.secondslash.mainActivity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;

import secondslash.secondslash.R;


/**
 * Created by alokit nigam on 10/8/2015.
 */
public class categoriesFragment extends android.support.v4.app.Fragment {
    View v;
ImageButton imageButton6,imageButton,imageButton2,imageButton3,imageButton4,imageButton5;
    Button button;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        v=inflater.inflate(R.layout.categories,container,false);
      /* imageButton =(ImageButton)view.findViewById(R.id.delhi);
        imageButton2 =(ImageButton) getView().findViewById(R.id.world);
        imageButton3 =(ImageButton) getView().findViewById(R.id.business);
        imageButton4 =(ImageButton) getView().findViewById(R.id.india);
        imageButton5 =(ImageButton) getView().findViewById(R.id.football);
        imageButton6 =(ImageButton) getView().findViewById(R.id.hockey);
        button=*/





        return v;


    }
}
