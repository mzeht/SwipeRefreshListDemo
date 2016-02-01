package com.example.mzeht.swiperefreshlistdemo;

import android.view.View;

/**
 * Created by wpmac on 16/2/1.
 */
public interface OnListClickListener {

        public void OnItemClick(View view,String data);


        public void OnItemTextClick(View view,String data);



        public void OnItemIconClick(View view ,String data);
}
