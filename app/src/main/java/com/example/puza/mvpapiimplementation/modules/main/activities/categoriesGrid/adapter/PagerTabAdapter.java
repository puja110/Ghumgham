package com.example.puza.mvpapiimplementation.modules.main.activities.categoriesGrid.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import com.example.puza.mvpapiimplementation.modules.main.activities.categoriesGrid.tabs.toEatFragment.ToEatFragment;
import com.example.puza.mvpapiimplementation.modules.main.activities.categoriesGrid.tabs.toSleepFragment.ToSleepFragment;
import com.example.puza.mvpapiimplementation.modules.main.activities.categoriesGrid.tabs.todoFragment.TodoFragment;

public class PagerTabAdapter extends FragmentStatePagerAdapter {

    int tabCount;

    //tab titles
    private String[] tabTitles = new String[]{"To Do", "To Sleep", "To Eat"};

    public PagerTabAdapter(FragmentManager fm, int tabCount) {
        super(fm);
        //initializing tabCount variable
        this.tabCount = tabCount;
    }

    // overriding getPageTitle()
    @Override
    public CharSequence getPageTitle(int position) {
        return tabTitles[position];
    }

    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0:
                TodoFragment todoFragment = new TodoFragment();
//                ServicesTypesFragment tab1 = new ServicesTypesFragment();
                return todoFragment;
            case 1:
                ToEatFragment toEatFragment = new ToEatFragment();
                return  toEatFragment;
            case 2:
                ToSleepFragment toSleepFragment = new ToSleepFragment();
                return  toSleepFragment;
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return tabCount;

    }
}
