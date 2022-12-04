package it.ikbo1120.fitness_club_v1_1.presentation.view;

import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.Arrays;

import it.ikbo1120.fitness_club_v1_1.R;
import it.ikbo1120.fitness_club_v1_1.domain.repository.mock.MockBase;
import it.ikbo1120.fitness_club_v1_1.presentation.viewmodel.HomeViewModel;

public class HomeFragment extends Fragment {

    private HomeViewModel mViewModel;

    public static HomeFragment newInstance() {
        return new HomeFragment();
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mViewModel = new ViewModelProvider(this).get(HomeViewModel.class);
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        MockBase mockBase = new MockBase();
        System.out.println(Arrays.toString(mockBase.getAllServices().toArray()));
        return inflater.inflate(R.layout.fragment_home, container, false);
    }
}