package com.abdul.mvvmapp.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.abdul.mvvmapp.R;

public class NewsItemFrag extends Fragment {
    TextView tvNewsItem;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
         super.onCreateView(inflater, container, savedInstanceState);
         View fragUi = inflater.inflate(R.layout.frag_news_item,container,false);
         tvNewsItem = fragUi.findViewById(R.id.tvNewsitem);
                 return fragUi;

    }

    public void setData(@org.jetbrains.annotations.Nullable String headline) {
        tvNewsItem.setText(headline);
    }
}
