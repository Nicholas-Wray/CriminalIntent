package com.bignerdranch.android.criminalintent;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.support.v4.app.Fragment;
import android.text.format.DateFormat;
import java.util.Date;

/**
 * Created by nwray on 10/7/15.
 */
public class CrimeFragment extends Fragment{
    private Crime mCrime;
    private EditText mTitleField;
    private Button mDateButton;
    private CheckBox mSolvedCheckBox;

    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        mCrime = new Crime();


    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        View v = inflater.inflate(R.layout.fragment_crime, container, false);

        mTitleField = (EditText)v.findViewById(R.id.crime_title);
        mTitleField.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) { // Intentionally blank

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                mCrime.setTitle(charSequence.toString());
            }

            @Override
            public void afterTextChanged(Editable editable) {  // Intentionally blank

            }
        });

        Date currentDate = mCrime.getDate();
        String formattedCurrentDate = SetFormat(currentDate);

        mDateButton = (Button)v.findViewById(R.id.crime_date);
        mDateButton.setText(formattedCurrentDate);
        mDateButton.setEnabled(false);

        mSolvedCheckBox = (CheckBox)v.findViewById(R.id.crime_solved);
        mSolvedCheckBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                mCrime.setSolved(isChecked);
            }
        });
        return v;
    }
    public Crime getCrime() {
        return mCrime;
    }
    private String SetFormat(Date curdate) {
        java.text.DateFormat dateFormat = java.text.DateFormat.getDateInstance(java.text.DateFormat.FULL);
        return dateFormat.format(curdate);
    }
}
