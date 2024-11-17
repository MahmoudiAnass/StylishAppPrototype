package com.example.prototypestylish;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.widget.AppCompatButton;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

public class RegisterFragment extends Fragment {



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_register, container, false);

        Button button = view.findViewById(R.id.signupbutton);
        button.setOnClickListener(v -> {
            // Create an instance of the FirstFragment
            LoginFragment firstFragment = new LoginFragment();

            // Get the FragmentManager and begin the transaction
            FragmentManager fragmentManager = requireActivity().getSupportFragmentManager();
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

            // Replace the current fragment with the FirstFragment
            fragmentTransaction.replace(R.id.main, firstFragment);

            // Add the transaction to the back stack so the user can navigate back
            fragmentTransaction.addToBackStack(null);

            // Commit the transaction
            fragmentTransaction.commit();
        });


        AppCompatButton loginbutton = view.findViewById(R.id.loginbutton);
        loginbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(requireActivity(),HomeActivity.class);
                startActivity(intent);
            }
        });

        return view;


    }
}