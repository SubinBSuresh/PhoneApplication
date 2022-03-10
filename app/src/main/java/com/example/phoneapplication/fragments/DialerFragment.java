package com.example.phoneapplication.fragments;

import android.annotation.SuppressLint;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.example.phoneapplication.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class DialerFragment extends Fragment implements View.OnClickListener, View.OnLongClickListener {

    private Button btnDialOne, btnDialTwo, btnDialThree, btnDialFour, btnDialFive, btnDialSix, btnDialSeven, btnDialEight, btnDialNine, btnDialStar, btnDialZero, btnDialHash;
    private FloatingActionButton fabMakeCall, fabBackspaceNumber;
    private TextView tvUserEnteredNumber;
    private String userEnteredNumber;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_dialer, container, false);

        btnDialOne = view.findViewById(R.id.buttonDialOne);
        btnDialTwo = view.findViewById(R.id.buttonDialTwo);
        btnDialThree = view.findViewById(R.id.buttonDialThree);
        btnDialFour = view.findViewById(R.id.buttonDialfour);
        btnDialFive = view.findViewById(R.id.buttonDialFive);
        btnDialSix = view.findViewById(R.id.buttonDialSix);
        btnDialSeven = view.findViewById(R.id.buttonDialSeven);
        btnDialEight = view.findViewById(R.id.buttonDialEight);
        btnDialNine = view.findViewById(R.id.buttonDialNine);
        btnDialStar = view.findViewById(R.id.buttonDialStar);
        btnDialZero = view.findViewById(R.id.buttonDialZero);
        btnDialHash = view.findViewById(R.id.buttonDialhash);


        btnDialOne.setOnClickListener(this);
        btnDialTwo.setOnClickListener(this);
        btnDialTwo.setOnClickListener(this);
        btnDialThree.setOnClickListener(this);
        btnDialFour.setOnClickListener(this);
        btnDialFive.setOnClickListener(this);
        btnDialSix.setOnClickListener(this);
        btnDialSeven.setOnClickListener(this);
        btnDialEight.setOnClickListener(this);
        btnDialNine.setOnClickListener(this);
        btnDialStar.setOnClickListener(this);
        btnDialZero.setOnClickListener(this);
        btnDialHash.setOnClickListener(this);


        fabMakeCall = view.findViewById(R.id.fabMakeCall);
        fabBackspaceNumber = view.findViewById(R.id.fabBackSpaceNumbers);

        fabMakeCall.setOnClickListener(this);
        fabBackspaceNumber.setOnClickListener(this);


        btnDialZero.setOnLongClickListener(this);
        fabBackspaceNumber.setOnLongClickListener(this);

        tvUserEnteredNumber = view.findViewById(R.id.tecxtViewuserEnteredNumber);
        return view;
    }

    //Empty Constructor
    public DialerFragment() {
    }


    //For Button Clicks
    @SuppressLint("NonConstantResourceId")
    @Override
    public void onClick(View view) {
        userEnteredNumber = tvUserEnteredNumber.getText().toString();
        switch (view.getId()) {
            case R.id.buttonDialOne:
                userEnteredNumber = showUserEnteredNumber("1", userEnteredNumber);
                break;
            case R.id.buttonDialTwo:
                userEnteredNumber = showUserEnteredNumber("2", userEnteredNumber);
                break;
            case R.id.buttonDialThree:
                userEnteredNumber = showUserEnteredNumber("3", userEnteredNumber);
                break;
            case R.id.buttonDialfour:
                userEnteredNumber = showUserEnteredNumber("4", userEnteredNumber);
                break;
            case R.id.buttonDialFive:
                userEnteredNumber = showUserEnteredNumber("5", userEnteredNumber);
                break;
            case R.id.buttonDialSix:
                userEnteredNumber = showUserEnteredNumber("6", userEnteredNumber);
                break;
            case R.id.buttonDialSeven:
                userEnteredNumber = showUserEnteredNumber("7", userEnteredNumber);
                break;
            case R.id.buttonDialEight:
                userEnteredNumber = showUserEnteredNumber("8", userEnteredNumber);
                break;
            case R.id.buttonDialNine:
                userEnteredNumber = showUserEnteredNumber("9", userEnteredNumber);
                break;
            case R.id.buttonDialStar:
                userEnteredNumber = showUserEnteredNumber("*", userEnteredNumber);
                break;
            case R.id.buttonDialZero:
                userEnteredNumber = showUserEnteredNumber("0", userEnteredNumber);
                break;
            case R.id.buttonDialhash:
                userEnteredNumber = showUserEnteredNumber("#", userEnteredNumber);
                break;
            case R.id.fabMakeCall:
                //MAKE CALL
                break;
            case R.id.fabBackSpaceNumbers:
                userEnteredNumber = removeLastNumber(userEnteredNumber);
        }

        tvUserEnteredNumber.setText(userEnteredNumber);

    }

    //For Button Long Clicks
    @SuppressLint("NonConstantResourceId")
    @Override
    public boolean onLongClick(View view) {
        userEnteredNumber = tvUserEnteredNumber.getText().toString();
        switch (view.getId()) {
            case R.id.fabBackSpaceNumbers:
                userEnteredNumber = "";
                break;

            case R.id.buttonDialZero:
                userEnteredNumber = showUserEnteredNumber("+", userEnteredNumber);
                break;
        }
        tvUserEnteredNumber.setText(userEnteredNumber);

        return true;
    }

    //Remove last digit
    private String removeLastNumber(String userEnteredNumber) {
        StringBuilder stringBuilder = new StringBuilder(userEnteredNumber);
        if (stringBuilder.length() > 0) {
            stringBuilder.deleteCharAt(userEnteredNumber.length() - 1);
        }
        return stringBuilder.toString();
    }


    private String showUserEnteredNumber(String s, String userEnteredNumber) {
        if (userEnteredNumber.length() < 15) {
            return userEnteredNumber + s;
        }
        return userEnteredNumber;
    }


}