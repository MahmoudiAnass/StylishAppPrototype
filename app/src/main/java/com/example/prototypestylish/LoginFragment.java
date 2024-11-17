package com.example.prototypestylish;

import android.graphics.Color;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.style.ForegroundColorSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

public class LoginFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_login, container, false);


        TextView registerText = view.findViewById(R.id.registertext);

        SpannableStringBuilder builder = new SpannableStringBuilder();
        String part1 = "By clicking the ";
        String part2 = "Register";
        String part3 = " button, you agree to the public offer";
        builder.append(part1);
        SpannableString redRegister = new SpannableString(part2);
        redRegister.setSpan(new ForegroundColorSpan(Color.parseColor("#FF4B26")), 0, redRegister.length(), 0);
        builder.append(redRegister);


        builder.append(part3);

        registerText.setText(builder, TextView.BufferType.SPANNABLE);



        Button button = view.findViewById(R.id.gotologin);
        button.setOnClickListener(v -> {
            // Create an instance of the SecondFragment
            RegisterFragment secondFragment = new RegisterFragment();

            // Get the FragmentManager and begin the transaction
            FragmentManager fragmentManager = requireActivity().getSupportFragmentManager();
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

            // Replace the current fragment with the SecondFragment
            fragmentTransaction.replace(R.id.main, secondFragment);

            // Add the transaction to the back stack so the user can navigate back
            fragmentTransaction.addToBackStack(null);

            // Commit the transaction
            fragmentTransaction.commit();
        });



        return view;
    }

}