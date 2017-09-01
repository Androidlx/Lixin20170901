package com.example.lixin.lixin20170901;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

/**
 * Created by hua on 2017/9/1.
 */

public class MyCustomView extends LinearLayout {

    private TextView text;
    private int textColor;
    private float textSize;
    private ImageView icon;
    private LinearLayout container;
    private TypedArray array;
    private int bg_color;
    private Drawable icon_drawable;
    private String title;

    public MyCustomView(Context context) {
        super(context);
        initView(context,null);
    }

    public MyCustomView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        initView(context,attrs);
    }

    private void initView(Context context,@Nullable AttributeSet attrs) {
        View inflate = inflate(context, R.layout.activity_custom, this);
        container = inflate.findViewById(R.id.container);
        text = inflate.findViewById(R.id.text);
        icon = inflate.findViewById(R.id.icon);

        icon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (monClickListener!=null){
                    monClickListener.onClickListener(view);
                }
            }
        });
        if (attrs == null) {
            return;
        }
        initAttrs(context, attrs);
        setViewContent();


    }


    private void initAttrs(Context context, AttributeSet attrs) {
        if (attrs == null) {
            return;
        }
        array = getContext().obtainStyledAttributes(attrs, R.styleable.MyCustomView);
        title = array.getString(R.styleable.MyCustomView_text);
        textColor = array.getColor(R.styleable.MyCustomView_textColor, 0xffffff);
        textSize = array.getDimension(R.styleable.MyCustomView_textSize, 16);
        bg_color = array.getColor(R.styleable.MyCustomView_text_bg_color, 0x00ff00);
        icon_drawable = array.getDrawable(R.styleable.MyCustomView_icon);
    }

    private void setViewContent() {
        container.setBackgroundColor(bg_color);
        icon.setImageDrawable(icon_drawable);
        text.setText(title);
        text.setTextSize(textSize);
        text.setTextColor(textColor);
    }

    public interface OnClickListener{
        void onClickListener(View icon);
    }

    private OnClickListener monClickListener;

    public void setOnClickListener(OnClickListener onClickListener){
        monClickListener = onClickListener;
    }


}
