package fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.Spinner;
import android.widget.Toast;

import com.iammukesh.testnavi.MainActivity;
import com.iammukesh.testnavi.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class profile_fragment extends Fragment {
    public void saveProfileOption(View view){
        CheckBox socialcheck = (CheckBox) getActivity().findViewById(R.id.socialcheck);
        if(socialcheck.isChecked()==true){
            Toast.makeText(getActivity().getApplicationContext(),"Social is checked",Toast.LENGTH_SHORT).show();
        }
    }
    public profile_fragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_profile_fragment, container, false);

    }
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }


}
