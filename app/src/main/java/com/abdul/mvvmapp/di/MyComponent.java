package com.abdul.mvvmapp.di;

import com.abdul.mvvmapp.DiActivity;
import com.abdul.mvvmapp.MainActivity;

import javax.inject.Singleton;
import dagger.Component;

@Singleton
@Component(modules = {SharedPrefModule.class}) //provider=factory
public interface MyComponent {              //real estate agent
    void inject(DiActivity activity);  //consumer
}