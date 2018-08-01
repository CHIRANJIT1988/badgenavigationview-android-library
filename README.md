# BadgeBottomNavigation

BadgeBottomNavigation is as simple as bottom navigation viewer which helps to add/update badge on navigation item.


# Installation

BadgeBottomNavigation is installed by adding the following dependency to your build.gradle file:

```
dependencies {
    implementation 'com.chiranjit.ui:badgenavigationview:1.0.0'
}
```

Note that BadgeBottomNavigation depends on Android Support Library 27.1.1 so you will need to use compileSdkVersion 27 or higher. This change should be safe as compileSdkVersion does not change app behavior.

# Usage

To begin using BadgeBottomNavigation, have your Activity:

```
public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private BadgeBottomNavigation navigation;
    public int badge;
    
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        navigation = findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);

        navigation.setRoundBadge(true);
    }

    @Override
    public void onClick(View view)
    {
        badge++;

        navigation.setBadge(badge, 0); // 0 for first menu 
        navigation.setBadge(badge, 1); // 1 for second menu 
        navigation.setBadge(badge, 2); // 2 for third menu
    }
}
```

Layout file:

```
<RelativeLayout
    xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    android:layout_width="match_parent"
    android:layout_height="match_parent" >

     <com.chiranjit.badgenavigationview.BadgeBottomNavigation
        android:id="@+id/navigation"
        android:layout_width="0dp"
        android:layout_height="wrap_content"
        android:layout_marginEnd="0dp"
        android:layout_marginStart="0dp"
        android:background="?android:attr/windowBackground"
        app:layout_constraintBottom_toBottomOf="parent"
        app:layout_constraintLeft_toLeftOf="parent"
        app:layout_constraintRight_toRightOf="parent"
        app:menu="@menu/navigation" />

</RelativeLayout>
```

### Properties

Badge color (default RED).
Call setBadgeColor() method is used to set badge background color

```
navigation.setBadgeColor(R.color.colorBadge);
```

Badge text color (default WHITE).
Call setBadgeTextColor() method is used to set badge text color

```
navigation.setBadgeTextColor(R.color.colorBadgeText);
```

Badge shape (default SQUARE)
Call setRoundBadge() method true if you need rounded badge

```
navigation.setRoundBadge(true);
```
        
        
## LICENSE

```
Copyright 2017 Chiranjit

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.

```
