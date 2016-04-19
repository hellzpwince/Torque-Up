package fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;

import com.iammukesh.testnavi.MainActivity;
import com.iammukesh.testnavi.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class GeoSettingFragement extends Fragment {
    private View rootView;
    private CheckBox leaveOptimizeCheckbox;
    private CheckBox leaveNetOnCheckbox;
    private CheckBox GPSCheckbox;
    private MainActivity main;

    public GeoSettingFragement() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        rootView= inflater.inflate(R.layout.fragment_geo_setting_fragement, container, false);
        main =(MainActivity)getActivity();
        leaveOptimizeCheckbox=(CheckBox)rootView.findViewById(R.id.leaveoptimize);
        leaveNetOnCheckbox=(CheckBox)rootView.findViewById(R.id.networkCheckbox);
        GPSCheckbox=(CheckBox)rootView.findViewById(R.id.GPScheckbox);
        if(main.optimizeAsILeavetest!=null){
            // Toast.makeText(rootView.getContext(), "Active", Toast.LENGTH_SHORT).show();
            leaveOptimizeCheckbox.setChecked(true);
        }
        if(main.leaveNetOntest!=null){
            // Toast.makeText(rootView.getContext(), "Active", Toast.LENGTH_SHORT).show();
            leaveNetOnCheckbox.setChecked(true);
        }
        if(main.useGPStest!=null){
            // Toast.makeText(rootView.getContext(), "Active", Toast.LENGTH_SHORT).show();
            GPSCheckbox.setChecked(true);
        }



        return rootView;
    }

}
