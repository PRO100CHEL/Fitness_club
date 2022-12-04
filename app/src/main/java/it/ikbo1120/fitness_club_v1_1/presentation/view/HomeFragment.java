package it.ikbo1120.fitness_club_v1_1.presentation.view;

import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.Arrays;
import java.util.List;

import it.ikbo1120.fitness_club_v1_1.R;
import it.ikbo1120.fitness_club_v1_1.databinding.FragmentHomeBinding;
import it.ikbo1120.fitness_club_v1_1.domain.model.Services;
import it.ikbo1120.fitness_club_v1_1.domain.repository.mock.MockBase;
import it.ikbo1120.fitness_club_v1_1.presentation.view.adapters.ItemListAdapter;
import it.ikbo1120.fitness_club_v1_1.presentation.viewmodel.HomeViewModel;

public class HomeFragment extends Fragment {
    private RecyclerView recyclerView;
    private FragmentHomeBinding binding;
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
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel.getAllServices().observe(getViewLifecycleOwner(), new Observer<List<Services>>() {
            @Override
            public void onChanged(List<Services> services) {
                binding.servicesList.setAdapter(new ItemListAdapter(services));
            }
        });
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        MockBase mockBase = new MockBase();
        binding = FragmentHomeBinding.inflate(getLayoutInflater(), container, false);
        binding.servicesList.setLayoutManager(new LinearLayoutManager(getContext()));
        binding.servicesList.setAdapter(new ItemListAdapter(mockBase.getAllServices()));
        System.out.println(Arrays.toString(mockBase.getAllServices().toArray()));
        return binding.getRoot();
    }
}