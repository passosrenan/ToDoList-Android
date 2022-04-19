package br.senai.sp.cotia.todolist.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.os.Bundle;

import br.senai.sp.cotia.todolist.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //intancia o binding
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        //define como content view a raiz do binding
        setContentView(binding.getRoot());
    }
}