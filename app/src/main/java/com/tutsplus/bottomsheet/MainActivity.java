package com.tutsplus.bottomsheet;

import android.support.design.widget.BottomSheetBehavior;
import android.support.design.widget.BottomSheetDialogFragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private BottomSheetBehavior mBottomSheetBehavior;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        View bottomSheet = findViewById( R.id.bottom_sheet );
        Button button1 = (Button) findViewById( R.id.button_1 );
        Button button2 = (Button) findViewById( R.id.button_2 );
        Button button3 = (Button) findViewById( R.id.button_3 );

        button1.setOnClickListener(this);
        button2.setOnClickListener(this);
        button3.setOnClickListener(this);

//        todo 3 get the bahaviour bottom sheet
        mBottomSheetBehavior = BottomSheetBehavior.from(bottomSheet);

        // TODO: 9/24/16
        mBottomSheetBehavior.setBottomSheetCallback(new BottomSheetBehavior.BottomSheetCallback() {
            @Override
            public void onStateChanged(View bottomSheet, int newState) {
                // TODO: 9/24/16 6 - when the bottom sheet is at the mimumum and we collapse, close it
                if (newState == BottomSheetBehavior.STATE_COLLAPSED) {
                    mBottomSheetBehavior.setPeekHeight(0);
                }
            }

            @Override
            public void onSlide(View bottomSheet, float slideOffset) {
            }
        });


    }

    // TODO: 9/24/16 4 - when click, change the bottom bar behavior
    @Override
    public void onClick(View v) {
        switch( v.getId() ) {
            case R.id.button_1: {
                mBottomSheetBehavior.setState(BottomSheetBehavior.STATE_EXPANDED);
                break;
            }
            case R.id.button_2: {
//                todo 5 - with setPeekHeight and setState, when bottom sheet expands, it can shorten -> collapsed
                mBottomSheetBehavior.setPeekHeight(300);
                mBottomSheetBehavior.setState(BottomSheetBehavior.STATE_COLLAPSED);
                break;
            }
            case R.id.button_3: {
                BottomSheetDialogFragment bottomSheetDialogFragment = new TutsPlusBottomSheetDialogFragment();
                bottomSheetDialogFragment.show(getSupportFragmentManager(), bottomSheetDialogFragment.getTag());
                break;
            }
        }
    }
}

