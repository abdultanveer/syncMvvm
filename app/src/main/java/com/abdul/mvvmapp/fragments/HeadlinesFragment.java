package com.abdul.mvvmapp.fragments;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.abdul.mvvmapp.R;

public class HeadlinesFragment  extends Fragment implements AdapterView.OnItemClickListener {
    ListView headlinesLv;

    interface HeadlineClickListener{ //switchboard
        void onHeadlineClick(String headline);
    }




    HeadlineClickListener headlineClickListener;

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        headlineClickListener = (HeadlineClickListener) getActivity(); //wiring


    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
         super.onCreateView(inflater, container, savedInstanceState);
         View fragUi = inflater.inflate(R.layout.frag_headlines,container,false);
         headlinesLv = fragUi.findViewById(R.id.headlinesListview);
        return fragUi;
    }

    @Override
    public void onStart() {
        super.onStart();
        headlinesLv.setOnItemClickListener(this);
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
       String headline = (String)adapterView.getItemAtPosition(position);
        Toast.makeText(getActivity(), headline, Toast.LENGTH_SHORT).show();
        headlineClickListener.onHeadlineClick(headline); //clicking the switch
    }
}
