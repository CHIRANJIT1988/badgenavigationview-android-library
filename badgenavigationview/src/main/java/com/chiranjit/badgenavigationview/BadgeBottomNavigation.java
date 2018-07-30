package com.chiranjit.badgenavigationview;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.design.internal.BottomNavigationItemView;
import android.support.design.internal.BottomNavigationMenuView;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.content.ContextCompat;
import android.support.v4.graphics.drawable.DrawableCompat;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;


public class BadgeBottomNavigation extends BottomNavigationView
{
    private BottomNavigationMenuView bottomNavigationMenuView;
    private List<TextView> badgeList = new ArrayList<>();

    private Context context;
    private int badgeColor = R.color.badge_color;
    private int badgeTextColor = R.color.badge_text_color;
    private boolean isCircleBadge = false;


    public BadgeBottomNavigation(Context context)
    {
        super(context);
        this.context = context;
    }

    public BadgeBottomNavigation(Context context, AttributeSet attrs)
    {
        super(context, attrs);
        this.context = context;
    }

    public BadgeBottomNavigation(Context context, AttributeSet attrs, int defStyleAttr)
    {
        super(context, attrs, defStyleAttr);
        this.context = context;
    }


    /**
     * Initialize BottomNavigationMenuView
     */
    private void init()
    {
        bottomNavigationMenuView = (BottomNavigationMenuView) this.getChildAt(0);

        for(int index=0; index<bottomNavigationMenuView.getChildCount(); index++)
        {
            try
            {
                View v = bottomNavigationMenuView.getChildAt(index);
                BottomNavigationItemView itemView = (BottomNavigationItemView) v;

                FrameLayout badgeView = (FrameLayout) LayoutInflater.from(context)
                        .inflate(R.layout.layout_notification_badge, this, false);

                itemView.addView(badgeView);

                TextView notifications_badge = (TextView) badgeView.getChildAt(0);
                notifications_badge.setTag(index);
                badgeList.add(notifications_badge);

                notifications_badge.setVisibility(GONE);
            }

            catch (Exception e)
            {
                e.printStackTrace();
            }
        }
    }


    /**
     * set badge color
     * @param badgeColor color resource
     */
    public void setBadgeColor(int badgeColor)
    {
        this.badgeColor = badgeColor;
    }

    /**
     * set badge text color
     * @param badgeTextColor color resource
     */
    public void setBadgeTextColor(int badgeTextColor)
    {
        this.badgeTextColor = badgeTextColor;
    }

    /**
     * set badge shape round/rectangle
     * @param isCircleBadge true if round
     */
    public void setRoundBadge(boolean isCircleBadge)
    {
        this.isCircleBadge = isCircleBadge;
    }

    /**
     * set badge counter
     */
    public void setBadge(int badge, int mIndex)
    {
        try
        {
            if(bottomNavigationMenuView == null)
            {
                init();
            }

            TextView notifications_badge = badgeList.get(mIndex).findViewWithTag(mIndex);

            if(badge > 0)
            {
                notifications_badge.setVisibility(VISIBLE);
                notifications_badge.setText(String.valueOf(badge));
            }

            else
            {
                notifications_badge.setVisibility(GONE);
            }

            Drawable drawable = notifications_badge.getBackground();
            drawable = DrawableCompat.wrap(drawable);
            DrawableCompat.setTint(drawable, ContextCompat.getColor(context, badgeColor));
            notifications_badge.setBackground(drawable);

            notifications_badge.setTextColor(ContextCompat.getColor(context, badgeTextColor));

            if(isCircleBadge)
            {
                notifications_badge.setBackground(getResources().getDrawable(R.drawable.ic_round_badge));
            }

            else
            {
                notifications_badge.setBackground(getResources().getDrawable(R.drawable.ic_rect_badge));
            }
        }

        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
}