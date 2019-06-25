package com.example.openwhyd.views;

import android.support.test.rule.ActivityTestRule;
import android.view.View;

import com.example.openwhyd.R;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import static org.junit.Assert.*;

public class MainActivityTest {

    /*
    * Simple Unit test case to test if the main activity is launching
    * */

    @Rule
    public ActivityTestRule<MainActivity> mActivityTestRule = new ActivityTestRule<MainActivity>(MainActivity.class);

    private MainActivity mActivity = null;

    @Before
    public void setUp() throws Exception {
        mActivity = mActivityTestRule.getActivity();
    }

    @Test
    public void testLaunch(){

        View view = mActivity.findViewById(R.id.recyclerView);
        assertNotNull(view);

    }

    @After
    public void tearDown() throws Exception {
    }
}