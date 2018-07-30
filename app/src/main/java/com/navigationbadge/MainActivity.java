package com.navigationbadge;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.chiranjit.badgenavigationview.BadgeBottomNavigation;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private BadgeBottomNavigation navigation;
    public int badge;


    private BadgeBottomNavigation.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BadgeBottomNavigation.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item)
        {
            switch (item.getItemId())
            {
                case R.id.navigation_home:

                    Toast.makeText(getApplicationContext(), "Home", Toast.LENGTH_SHORT).show();
                    return true;

                case R.id.navigation_dashboard:

                    Toast.makeText(getApplicationContext(), "Dashboard", Toast.LENGTH_SHORT).show();
                    return true;

                case R.id.navigation_notifications:

                    Toast.makeText(getApplicationContext(), "Notification", Toast.LENGTH_SHORT).show();
                    return true;
            }

            return false;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        navigation = findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);

        //navigation.setBadgeColor(R.color.colorBadge);
        //navigation.setBadgeTextColor(R.color.colorBadgeText);

        navigation.setRoundBadge(true);
    }

    @Override
    public void onClick(View view)
    {
        badge++;

        navigation.setBadge(badge, 0);
        navigation.setBadge(badge, 1);
        navigation.setBadge(badge, 2);
    }
}
