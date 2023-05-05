package com.example.run_tracker;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import java.util.Stack;

import static android.app.Activity.RESULT_OK;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link HomeFragment#newInstance} factory method to
 * create an instance of this fragment.
 */

public class HomeFragment extends Fragment implements View.OnClickListener {
    public static String speed,dist,time,date;
    private final int request = 10;
    ArrayList<AdapterItems> home_hist_data; // = new ArrayList<AdapterItems>();

    MyCustomAdapter adapter;
    Button seemore_btn,start_btn;
    ListView lv_home;
    ArrayList<String> al;


    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public HomeFragment(String date,String dist,String time,String speed) {

      HomeFragment.dist = dist;
      HomeFragment.date = date;
      HomeFragment.time = time;
      HomeFragment.speed = speed;


    }

    public HomeFragment() {

    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment HomeFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static HomeFragment newInstance(String param1, String param2) {
          HomeFragment fragment = new HomeFragment(dist,time,date,speed);
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

        home_hist_data = PrefConfig.readListFromPref(getContext());
        if(home_hist_data == null)
            home_hist_data = new ArrayList<>();

        else if(adapter != null){
            adapter = new MyCustomAdapter(home_hist_data);

            lv_home.setAdapter(adapter);
        }

    }

    @Override
    public View onCreateView(final LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home,container,false);

        /*
        lv_home = view.findViewById(R.id.lv_home);


        home_hist_data.add(new AdapterItems("5km", date, "32.06","hhh"));
        home_hist_data.add(new AdapterItems(dist,date,time,speed));


        home_hist_data.add(new AdapterItems("6km", "13.03.21", "32.06", "9.56"));
        home_hist_data.add(new AdapterItems("5km", "13.03.21", "32.06", "9.56"));


        adapter = new MyCustomAdapter(home_hist_data);

        lv_home.setAdapter(adapter);




        seemore_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //create new intent to pass to next activity                <<<<<<<<<<<<<<-------------------------------------------------------------------


            }
        });
        start_btn.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("ResourceType")
            @Override
            public void onClick(View v) {
               Intent intent = new Intent(getActivity(),RunTimer.class);
               startActivity(intent);
               // ((Activity)getActivity()).overridePendingTransition(0,0);
            }
        });


        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home,container,false);
*/
return view;
    }

public void setList_home(String dist,String date,String time,String speed)
{

    HomeFragment.dist = dist;
    HomeFragment.date = date;
    HomeFragment.time = time;
    HomeFragment.speed = speed;



}



    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        lv_home=  view.findViewById(R.id.lv_home);
/*
        home_hist_data = PrefConfig.readListFromPref(getContext());
        if(home_hist_data == null)
            home_hist_data = new ArrayList<>();
*/

/*
        home_hist_data.add(new AdapterItems("5km", date, "32.06", "9.56"));
        home_hist_data.add(new AdapterItems(dist,date,time,speed));


       // home_hist_data.add(new AdapterItems("6km", "13.03.21", "32.06", "9.56"));
       // home_hist_data.add(new AdapterItems("5km", "13.03.21", "32.06", "9.56"));


        adapter = new MyCustomAdapter(home_hist_data);

        lv_home.setAdapter(adapter);
*/
        start_btn = Objects.requireNonNull(getActivity()).findViewById(R.id.start_btn);
        start_btn.setOnClickListener((View.OnClickListener) this);

     //   seemore_btn = getActivity().findViewById(R.id.seemore_btn);
        adapter = new MyCustomAdapter(home_hist_data);

        lv_home.setAdapter(adapter);


        lv_home.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
              final AdapterItems s = home_hist_data.get(position);
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

    @Override
    public void onClick(View v) {
        Intent intent = new Intent(getContext(),Timer.class);
        startActivityForResult(intent,request);
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
      if(requestCode==request)
      {
          if(resultCode==RESULT_OK){
              assert data != null;
              Bundle args = data.getBundleExtra("list");
              al = (ArrayList<String>) args.getSerializable("array");

              Calendar calendar = Calendar.getInstance();

              @SuppressLint("SimpleDateFormat")
              SimpleDateFormat dateFormat = new SimpleDateFormat("dd.MM.yy");
            String Date =   dateFormat.format(calendar.getTime());
            Long seconds = (Long.parseLong(al.get(2))/1000);
         Long sec = seconds%60;
            Long min = seconds/60;
            Long hours = seconds/3600;

                      String time = hours+":"+min+":"+sec;
   setList_home(al.get(0),Date,time,al.get(1));
              home_hist_data.add(new AdapterItems(al.get(0), Date, time, al.get(1)));

              PrefConfig.writeListInPref(getContext(),home_hist_data);
              adapter = new MyCustomAdapter(home_hist_data);

              lv_home.setAdapter(adapter);




          }
      }

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
            @SuppressLint({"ViewHolder", "InflateParams"}) View myview = inflater.inflate(R.layout.layout_ticket, null); // to connect another layout

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
