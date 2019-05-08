package com.fanikiosoftware.myfragmentdynamicapp.Controllers.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.fanikiosoftware.myfragmentdynamicapp.Fragments.DetailFragment;
import com.fanikiosoftware.myfragmentdynamicapp.Fragments.MainFragment;
import com.fanikiosoftware.myfragmentdynamicapp.R;

public class MainActivity extends AppCompatActivity implements MainFragment.OnButtonClickedListener {

    public DetailFragment detailFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.configureAndShowDetailFragment();
    }

    @Override
    public void onButtonClicked(View view) {
        // 3 - Check if detail fragment is not created or if not visible
        if (detailFragment == null || !detailFragment.isVisible()){
            startActivity(new Intent(this, DetailActivity.class));
        }
    }

    private void configureAndShowDetailFragment(){
        detailFragment = (DetailFragment) getSupportFragmentManager().findFragmentById(R.id.frame_layout_detail);

        //A - We only add DetailFragment in Tablet mode (If found frame_layout_detail)
        if (detailFragment == null && findViewById(R.id.frame_layout_detail) != null) {
            detailFragment = new DetailFragment();
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.frame_layout_detail, detailFragment)
                    .commit();
        }
    }
}