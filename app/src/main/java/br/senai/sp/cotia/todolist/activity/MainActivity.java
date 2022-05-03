package br.senai.sp.cotia.todolist.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import android.app.Activity;
import android.os.Bundle;

import br.senai.sp.cotia.todolist.R;
import br.senai.sp.cotia.todolist.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding binding;
    private AppBarConfiguration appBarConfiguration;
    private NavController navController;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //intancia o binding
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        //define como content view a raiz do binding
        setContentView(binding.getRoot());

        //associa a barra do aplicativo a navegação
        navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        appBarConfiguration = new AppBarConfiguration.Builder(navController.getGraph()).build();
        NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration);

    }

    @Override
    public boolean onSupportNavigateUp() {
        return NavigationUI.navigateUp(navController, appBarConfiguration)
           || super.onSupportNavigateUp();
    }
}