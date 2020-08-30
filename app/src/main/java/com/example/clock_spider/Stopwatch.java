package com.example.clock_spider;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.os.SystemClock;
import android.text.Editable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Chronometer;
import android.widget.EditText;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

///**
// * A simple {@link Fragment} subclass.
// * Use the {@link Stopwatch#newInstance} factory method to
// * create an instance of this fragment.
// */
public class Stopwatch extends Fragment {
    private Chronometer chronometer;
    private long pauseOffset;
    private boolean running;
    Button start,pause,reset,lap;
    ScrollView scrollView;
    TextView textview;
    int lapcounter=1;
//    Chronometer chronometer;
//    EditText editText;
//    Button startbtn;
//    Button lapbtn;
//    Button stopbtn;
//    ScrollView scrollView;


    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
//    private static final String ARG_PARAM1 = "param1";
//    private static final String ARG_PARAM2 = "param2";
//
//    // TODO: Rename and change types of parameters
//    private String mParam1;
//    private String mParam2;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_stopwatch, container, false);
        chronometer = view.findViewById(R.id.chronometer);
        start=(Button)view.findViewById(R.id.start);
        pause=(Button)view.findViewById(R.id.pause);
        reset=(Button)view.findViewById(R.id.reset);
        scrollView=(ScrollView)view.findViewById(R.id.scrollview);
        textview=(TextView) view.findViewById(R.id.textview);
        lap=(Button)view.findViewById(R.id.lap);
        textview.setText("");

        start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!running) {
                    chronometer.setBase(SystemClock.elapsedRealtime() - pauseOffset);
                    chronometer.start();
                    running = true;
                    reset.setVisibility(View.INVISIBLE);
//                    textview.setText("");

                }
            }
        });
        reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                chronometer.setBase(SystemClock.elapsedRealtime());
                pauseOffset = 0;
                textview.setText("");
                lapcounter=1;
            }
        });
        pause.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (running) {
                    chronometer.stop();
                    pauseOffset = SystemClock.elapsedRealtime() - chronometer.getBase();
                    running = false;
                    reset.setVisibility(View.VISIBLE);
                }
            }
        });
        lap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textview.append("LAP"+String.valueOf(lapcounter++)+"  ->  "+chronometer.getText().toString()
                        +"\n");

                scrollView.post(new Runnable() {
                    @Override
                    public void run() {
                        scrollView.smoothScrollTo(0,textview.getBottom());
                    }
                });

            }
        });


//        chronometer.setFormat("Time: %s");
//        chronometer.setBase(SystemClock.elapsedRealtime());
//        chronometer.setOnChronometerTickListener(new Chronometer.OnChronometerTickListener() {
//            @Override
//            public void onChronometerTick(Chronometer chronometer) {
//                if ((SystemClock.elapsedRealtime() - chronometer.getBase()) >= 10000) {
//                    chronometer.setBase(SystemClock.elapsedRealtime());
//                    Toast.makeText(getContext(), "Bing!", Toast.LENGTH_SHORT).show();
//                }
//            }
//        });
        return view;
    }

    public Stopwatch() {
        // Required empty public constructor
    }

//    public void startChronometer(View v) {
//        if (!running) {
//            chronometer.setBase(SystemClock.elapsedRealtime() - pauseOffset);
//            chronometer.start();
//            running = true;
//        }
//    }
//    public void pauseChronometer(View v) {
//        if (running) {
//            chronometer.stop();
//            pauseOffset = SystemClock.elapsedRealtime() - chronometer.getBase();
//            running = false;
//        }
//    }
//    public void resetChronometer(View v) {
//        chronometer.setBase(SystemClock.elapsedRealtime());
//        pauseOffset = 0;
//    }
}

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment Stopwatch.
     */
    // TODO: Rename and change types and number of parameters
//    public static Stopwatch newInstance(String param1, String param2) {
//        Stopwatch fragment = new Stopwatch();
//        Bundle args = new Bundle();
//        args.putString(ARG_PARAM1, param1);
//        args.putString(ARG_PARAM2, param2);
//        fragment.setArguments(args);
//        return fragment;
//    }

//    @Override
//    public void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//
//
////        if (getArguments() != null) {
////            mParam1 = getArguments().getString(ARG_PARAM1);
////            mParam2 = getArguments().getString(ARG_PARAM2);
////        }
//    }
//






