package com.sevenplus.wificonfiguration.view.popwindow;


import android.app.Dialog;
import android.content.Context;
import android.graphics.drawable.BitmapDrawable;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.WindowManager;
import android.view.animation.AnimationUtils;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.TextView;

import com.sevenplus.wificonfiguration.activity.R;

import java.util.List;


public class ListSelectPop extends PopupWindow {
    private Dialog loadDialog;
    private Context mContext;
    TextView tv;
    String title = "";
    List<String> list;

    public ListSelectPop(Context mActivity, final TextView tv, String title, final List<String> list
    ) {

        this.mContext = mActivity;
        this.tv = tv;
        this.title = title;
        this.list = list;

        View view = View.inflate(mContext, R.layout.listselect_pop, null);
        view.startAnimation(AnimationUtils.loadAnimation(mContext,
                R.anim.fade_in));
        setInputMethodMode(PopupWindow.INPUT_METHOD_NEEDED);
        setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_RESIZE);
        setWidth(LayoutParams.WRAP_CONTENT);
        setHeight(LayoutParams.WRAP_CONTENT);
        setBackgroundDrawable(new BitmapDrawable());
        setFocusable(true);
        setOutsideTouchable(true);
        setContentView(view);
        showAtLocation(tv, Gravity.CENTER, 0, 0);
        update();
        TextView pop_title_tv = (TextView) view.findViewById(R.id.pop_title_tv);
        pop_title_tv.setText(title);
        ListView pop_listview = (ListView) view.findViewById(R.id.pop_listview);
        ListSelectAdapter adapter = new ListSelectAdapter(mActivity, list);
        pop_listview.setAdapter(adapter);
        pop_listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                tv.setText("" + list.get(position));
                dismiss();
            }
        });

    }


}

	
	

	
