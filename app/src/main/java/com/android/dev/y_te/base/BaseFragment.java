package com.android.dev.y_te.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by fcsdev on 10/1/16.
 */

public abstract class BaseFragment extends Fragment  {


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(getLayoutID(), container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        onviewCreate(view);
    }

    public abstract int getLayoutID();
    public abstract void onviewCreate(View view);
    public abstract void init(View view);
    public abstract void action(View view);
}
