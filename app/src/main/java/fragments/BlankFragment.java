package fragments;


import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import com.iammukesh.testnavi.MainActivity;
import com.iammukesh.testnavi.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class BlankFragment extends Fragment {
    private View rootView;
    private TextView percentscale;
    private SeekBar optimizeseekbar;
    private MainActivity main;
    public BlankFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        rootView= inflater.inflate(R.layout.fragment_blank, container, false);
        main =(MainActivity)getActivity();
        optimizeseekbar=(SeekBar)rootView.findViewById(R.id.optimizationseekbar);

        percentscale=(TextView)rootView.findViewById(R.id.percentscale);
        SharedPreferences sharedpref1 = main.getSharedPreferences("com.iammukesh.testnavi.hellzpwince", Context.MODE_PRIVATE);
        percentscale.setText(String.valueOf(sharedpref1.getInt("optimizelevel", 0)) + "%");
        optimizeseekbar.setProgress(sharedpref1.getInt("optimizelevel", 0));
        optimizeseekbar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                SharedPreferences sharedpref = main.getSharedPreferences("com.iammukesh.testnavi.hellzpwince", Context.MODE_PRIVATE);
                SharedPreferences.Editor editor = sharedpref.edit();
                editor.putInt("optimizelevel", optimizeseekbar.getProgress());
                //Log.i("progress", String.valueOf(sharedpref.getInt("optimizelevel", 0)));
                editor.commit();
                percentscale.setText(progress + "%");
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

                Toast.makeText(rootView.getContext(), "Optimization Level has been Applied", Toast.LENGTH_SHORT).show();
            }
        });
    return rootView;
    }


}
