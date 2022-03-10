package com.example.phoneapplication.adapters;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.Lifecycle;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.example.phoneapplication.fragments.ContactFragment;
import com.example.phoneapplication.fragments.DialerFragment;
import com.example.phoneapplication.fragments.RecentFragment;

public class FragmentAdapter extends FragmentStateAdapter {


    public FragmentAdapter(FragmentManager fragmentManager, Lifecycle lifecycle) {
        super(fragmentManager, lifecycle);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        switch (position){
            case 1:
                return new ContactFragment();
            case 2:
                return new RecentFragment();
        }
        return new DialerFragment();
    }

    @Override
    public int getItemCount() {
        return 3;
    }
}
