package com.example.figma;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

public class MainActivity4 extends AppCompatActivity {

    androidx.appcompat.app.ActionBar actionBar;
    String profileName = "Profile Name";
    String profileEmail;
    String profilePassword;

    private TextInputEditText nameET;
    private TextInputEditText emailET;
    private TextInputEditText passwordET;

    private TextInputLayout nameL;
    private TextInputLayout emailL;
    private TextInputLayout passwordL;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);

        profileEmail = getIntent().getStringExtra("email");
        profilePassword = getIntent().getStringExtra("password");

        nameET = findViewById(R.id.nameET);
        emailET = findViewById(R.id.emailET);
        passwordET = findViewById(R.id.passET);

        nameL = findViewById(R.id.nameL);
        emailL = findViewById(R.id.emailL);
        passwordL = findViewById(R.id.passL);

        BottomNavigationView bottomNav = findViewById(R.id.bottom_navigation);
        bottomNav.setOnNavigationItemSelectedListener(navListener);
        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new ChatsFragment()).commit();
        actionBar = getSupportActionBar();
        actionBar.setTitle(R.string.menu_text_chats);
    }

    private BottomNavigationView.OnNavigationItemSelectedListener navListener = item -> {
        Fragment selectedFragment = null;
        switch (item.getItemId()) {
            case R.id.chats:
                selectedFragment = new ChatsFragment();
                actionBar.setTitle(R.string.menu_text_chats);
                break;
            case R.id.settings:
                selectedFragment = new SettingsFragment();
                actionBar.setTitle(R.string.menu_text_settings);
                break;
            case R.id.profile:
                selectedFragment = new ProfileFragment();
                actionBar.setTitle(R.string.menu_text_profile);
                break;
        }
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.fragment_container, selectedFragment)
                .commit();
        return true;
    };
}