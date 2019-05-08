package com.fanikiosoftware.myfragmentapp.Fragments;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.fanikiosoftware.myfragmentapp.R;

/**
 * A simple Fragment subclass.
 */
public class MainFragment extends Fragment implements View.OnClickListener {

//  Declare callback
    private OnButtonClickedListener mCallback;

//  force any activity that wants to communicate w/this fragment to implement onButtonClicked(View)
    public interface OnButtonClickedListener {
        void onButtonClicked(View view);
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        //Inflate the layout of MainFragment
        View result=inflater.inflate(R.layout.fragment_main, container, false);
        //Set onClickListener to button "SHOW ME DETAILS"
        result.findViewById(R.id.fragment_main_button).setOnClickListener(this);
        return result;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        // 4 - Call the method that creating callback after being attached to parent activity
        this.createCallbackToParentActivity();
    }

    @Override
    public void onClick(View v) {
        // 5 - Spread the click to the parent activity
        mCallback.onButtonClicked(v);
    }

//    ******FRAGMENT SUPPORT*****

//  Create callback to parent activity
    private void createCallbackToParentActivity(){
        try {
            //Parent activity will automatically subscribe to callback
            mCallback = (OnButtonClickedListener) getActivity();
        } catch (ClassCastException e) {
            throw new ClassCastException(e.toString()+ " must implement OnButtonClickedListener");
        }
    }
}