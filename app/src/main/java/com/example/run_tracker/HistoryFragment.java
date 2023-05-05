package com.example.run_tracker;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link HistoryFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class HistoryFragment extends Fragment {
ArrayList<AdapterItems> hist_data = new ArrayList<AdapterItems>();

MyCustomAdapter myadapter;


    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public HistoryFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment HistoryFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static HistoryFragment newInstance(String param1, String param2) {
        HistoryFragment fragment = new HistoryFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_history,container,false);

        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_history, container, false);

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ListView lv_hist_parent = view.findViewById(R.id.lv_hist_parent);
      hist_data =  PrefConfig.readListFromPref(getContext());
        if(hist_data == null)
            hist_data = new ArrayList<>();


        /*

        hist_data.add(new AdapterItems("5km", "13.03.21", "32.06", "9.56"));
        hist_data.add(new AdapterItems("5km", "13.03.21", "32.06", "9.56"));
        hist_data.add(new AdapterItems("5km", "13.03.21", "32.06", "9.56"));

*/
        myadapter = new MyCustomAdapter(hist_data);

        lv_hist_parent.setAdapter(myadapter);



        lv_hist_parent.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                final AdapterItems s = hist_data.get(position);
                ArrayList<String> intent_arr = new ArrayList<>();
                intent_arr.add(s.date);
                intent_arr.add(s.distance);
                intent_arr.add(s.time);
                intent_arr.add(s.speed);
                //  TextView tvDate = (TextView) view.findViewById(R.id.tvDate); // pass to next activity
                Intent intent = new Intent(getActivity(),hist_det.class);
                intent.putStringArrayListExtra("Data",intent_arr);

                startActivity(intent);

            }
        });

    }

    private class MyCustomAdapter extends BaseAdapter {
    public ArrayList<AdapterItems> adapterItemsArrayList;

    public MyCustomAdapter(ArrayList<AdapterItems> adapterItemsArrayList) {
        this.adapterItemsArrayList = adapterItemsArrayList;
    }

    @Override
    public int getCount() {
        return adapterItemsArrayList.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = getLayoutInflater();
        View myview = inflater.inflate(R.layout.layout_ticket, null); // to connect another layout

        final AdapterItems s = adapterItemsArrayList.get(position);

        TextView tvDate = (TextView) myview.findViewById(R.id.tvDate); // seting date

        tvDate.setText(s.date);


        TextView tvDist = (TextView) myview.findViewById(R.id.tvDist); // seting distance

        tvDist.setText(s.distance);


        TextView tvTime = (TextView) myview.findViewById(R.id.tvTime); // seting time

        tvTime.setText(s.time);


        TextView tvSpeed = (TextView) myview.findViewById(R.id.tvSpeed); // seting speed

        tvSpeed.setText(s.speed + "kph");


        return myview;
    }
}

}
