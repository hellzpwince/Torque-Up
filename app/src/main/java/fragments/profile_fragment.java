package fragments;


import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.iammukesh.testnavi.MainActivity;
import com.iammukesh.testnavi.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class profile_fragment extends Fragment {
    private  MainActivity main;
    private CheckBox socialcheck;
    private CheckBox businesscheck;
    private CheckBox developercheck;
    private CheckBox gamecheck;
    private View rootView;
    private EditText rootchangename;
    public profile_fragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment


        rootView= inflater.inflate(R.layout.fragment_profile_fragment, container, false);
        initView();
        checkSavedPref();
        return rootView;
    }
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        SharedPreferences pref = getActivity().getPreferences(0);

       // String checkstatus=main.test.toString();
       //if(checkstatus=="true"){

       //}
    }
    private void initView(){
         socialcheck = (CheckBox) rootView.findViewById(R.id.socialcheck);
        gamecheck = (CheckBox) rootView.findViewById(R.id.gamecheck);
        developercheck = (CheckBox) rootView.findViewById(R.id.developercheck);
        businesscheck = (CheckBox) rootView.findViewById(R.id.businesscheck);
    }
    private void checkSavedPref(){
         main=(MainActivity)getActivity();
        if(main.test!=null){
           // Toast.makeText(rootView.getContext(), "Active", Toast.LENGTH_SHORT).show();
            socialcheck.setChecked(true);
        }
        if(main.game!=null){
           // Toast.makeText(rootView.getContext(), "Active", Toast.LENGTH_SHORT).show();
            gamecheck.setChecked(true);
        }
        if(main.develop!=null){
           // Toast.makeText(rootView.getContext(), "Active", Toast.LENGTH_SHORT).show();
            developercheck.setChecked(true);
        }
        if(main.business!=null){
           // Toast.makeText(rootView.getContext(), "Active", Toast.LENGTH_SHORT).show();
            businesscheck.setChecked(true);
        }


    }


}
