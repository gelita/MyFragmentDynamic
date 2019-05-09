package com.fanikiosoftware.myfragmentdynamicapp.Fragments;
public class DetailFragment extends Fragment {

    ....

    // 1 - Declare a buttonTag tracking
    private int buttonTag;
    // 2 - Create static variable to identify key in Bundle
    private static final String KEY_BUTTONTAG = "com.openclassrooms.myfragmentapp.Controllers.Fragments.DetailFragment.KEY_BUTTONTAG";
    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        // 5 - Restore last buttonTag if possible
        if (savedInstanceState != null) {
            int buttonTagRestored = savedInstanceState.getInt(KEY_BUTTONTAG, 0);
            // 6 - Update TextView
            this.updateTextView(buttonTagRestored);
        }
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        // 4 - Save buttonTag in Bundle when fragment is destroyed
        outState.putInt(KEY_BUTTONTAG, buttonTag);
    }

    // --------------
    // UPDATE UI
    // --------------

    //Update TextView depending on TAG's button
    public void updateTextView(int tag){

        // 3 - Save tag in ButtonTag variable
        this.buttonTag = tag;
    }
}