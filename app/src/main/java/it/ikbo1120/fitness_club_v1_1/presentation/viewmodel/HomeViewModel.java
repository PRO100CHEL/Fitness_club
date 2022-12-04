package it.ikbo1120.fitness_club_v1_1.presentation.viewmodel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.util.List;

import it.ikbo1120.fitness_club_v1_1.domain.model.Services;
import it.ikbo1120.fitness_club_v1_1.domain.repository.mock.MockBase;

public class HomeViewModel extends ViewModel {
    private MutableLiveData<List<Services>> allServices;

    public MutableLiveData<List<Services>> getAllServices() {
        return allServices;
    }

    public void setAllServices(MutableLiveData<List<Services>> allServices) {
        this.allServices = allServices;
    }

    public HomeViewModel(){
        allServices = new MutableLiveData<>();
        MockBase mockBase = new MockBase();
        allServices.setValue(mockBase.getAllServices());
    }
}