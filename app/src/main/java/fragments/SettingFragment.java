package fragments;


import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.Toast;

import com.iammukesh.testnavi.MainActivity;
import com.iammukesh.testnavi.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class SettingFragment extends Fragment {
    private  MainActivity main;
    private CheckBox remainInBackground;
    private CheckBox screenOffKill;
    private View rootView;
    public SettingFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        rootView =  inflater.inflate(R.layout.fragment_setting, container, false);
        initView();
        checkSavedPref();
        return rootView;
    }
    private void initView(){
        remainInBackground = (CheckBox) rootView.findViewById(R.id.remainInBackground);
        screenOffKill = (CheckBox) rootView.findViewById(R.id.screenOffKill);
    }
    private void checkSavedPref(){
        main=(MainActivity)getActivity();
        if(main.background!=null){
            // Toast.makeText(rootView.getContext(), "Active", Toast.LENGTH_SHORT).show();
            remainInBackground.setChecked(true);
        }
        if(main.screenKill!=null){
            // Toast.makeText(rootView.getContext(), "Active", Toast.LENGTH_SHORT).show();
            screenOffKill.setChecked(true);
        }
    }



}
