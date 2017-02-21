package com.javier.compoundviewexample;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

/**
 * Created by User on 2/21/2017.
 */

public class SidesSpinner extends LinearLayout {

    private Button mPreviousBtn;
    private Button mNextBtn;

    private  CharSequence[] mSpinnerValues = null;
    private int mSelectedIndex = -1;


    public SidesSpinner(Context context){
        super(context);
        initializeViews(context);
    }

    public SidesSpinner(Context context, AttributeSet attrs){
        super(context, attrs);
        initializeViews(context);
    }

    public SidesSpinner(Context context, AttributeSet attrs, int defstyle){
        super(context, attrs, defstyle);
        initializeViews(context);
    }


    private void initializeViews(Context context) {
        LayoutInflater inflater = (LayoutInflater)context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        inflater.inflate(R.layout.sidespinner_view, this);
    }

    @Override
    protected void onFinishInflate() {
        // When the controls in the layout are doing being inflated, set
        // the callbacks for the side arrows.
        super.onFinishInflate();

        // When the previous button is pressed, select the previous value
        // in the list.
        mPreviousBtn = (Button) this
                .findViewById(R.id.sidespinner_view_previous);
        mPreviousBtn
                .setBackgroundResource(android.R.drawable.ic_media_previous);

        mPreviousBtn.setOnClickListener(new OnClickListener() {
            public void onClick(View view) {
                if (mSelectedIndex > 0) {
                    int newSelectedIndex = mSelectedIndex - 1;
                    setSelectedIndex(newSelectedIndex);
                }
            }
        });

        // When the next button is pressed, select the next item in the
        // list.
        mNextBtn = (Button)this
                .findViewById(R.id.sidespinner_view_next);
        mNextBtn
                .setBackgroundResource(android.R.drawable.ic_media_next);
        mNextBtn.setOnClickListener(new OnClickListener() {
            public void onClick(View view) {
                if (mSpinnerValues != null
                        && mSelectedIndex < mSpinnerValues.length - 1) {
                    int newSelectedIndex = mSelectedIndex + 1;
                    setSelectedIndex(newSelectedIndex);
                }
            }
        });

        // Select the first value by default.
        setSelectedIndex(0);
    }

    public void setValues(CharSequence[] values) {
        mSpinnerValues = values;

        // Select the first item of the string array by default since
        // the list of value has changed.
        setSelectedIndex(0);
    }


    public void setSelectedIndex(int index) {
        // If no values are set for the spinner, do nothing.
        if (mSpinnerValues == null || mSpinnerValues.length == 0)
            return;

        // If the index value is invalid, do nothing.
        if (index < 0 || index >= mSpinnerValues.length)
            return;

        //set the current index and display the value
        mSelectedIndex = index;
        TextView currentValue;
        currentValue= (TextView) this .findViewById(R.id.sidespinner_view_value);
        currentValue.setText(mSpinnerValues[index]);

        //If the first value is shown hide the previous button
        if(mSelectedIndex == 0){
            mPreviousBtn.setVisibility(INVISIBLE);
        }
        else {
            mPreviousBtn.setVisibility(VISIBLE);
        }

        //If the last value is shown, hide the next button
        if(mSelectedIndex == mSpinnerValues.length-1){
            mNextBtn.setVisibility(INVISIBLE);
        }else{
            mNextBtn.setVisibility(VISIBLE);
        }

    }
    public CharSequence getSelectedValue() {
        // If no values are set for the spinner, return an empty string.
        if (mSpinnerValues == null || mSpinnerValues.length == 0)
            return "";

        // If the current index is invalid, return an empty string.
        if (mSelectedIndex < 0 || mSelectedIndex >= mSpinnerValues.length)
            return "";

        return mSpinnerValues[mSelectedIndex];
    }

    public int getSelectedIndex(){
        return mSelectedIndex;
    }
}