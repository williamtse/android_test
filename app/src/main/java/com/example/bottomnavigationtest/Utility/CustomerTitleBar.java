package com.example.bottomnavigationtest.Utility;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.bottomnavigationtest.R;

/**
 * Created by IT_ZJYANG on 2016/9/9.
 * 标题栏
 */
public class CustomerTitleBar extends LinearLayout{

    private Boolean isLeftBtnVisible;
    private int leftResId;

    private Boolean isLeftTvVisible;
    private String leftTvText;

    private Boolean isRightBtnVisible;
    private int rightResId;

    private Boolean isRightTvVisible;
    private String rightTvText;

    private Boolean isTitleVisible;
    private String titleText;

    private int backgroundResId;

    public CustomerTitleBar(Context context) {
        this(context, null);
    }

    public CustomerTitleBar(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public CustomerTitleBar(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initView(attrs);
    }

    /**
     * 初始化属性
     * @param attrs
     */
    public void initView(AttributeSet attrs){

        TypedArray typedArray = getContext().obtainStyledAttributes(attrs, R.styleable.CustomToolBar);
        /**-------------获取左边按钮属性------------*/
        isLeftBtnVisible = typedArray.getBoolean(R.styleable.CustomToolBar_left_btn_visible, false);
        leftResId = typedArray.getResourceId(R.styleable.CustomToolBar_left_btn_src, -1);
        /**-------------获取左边文本属性------------*/
        isLeftTvVisible = typedArray.getBoolean(R.styleable.CustomToolBar_left_tv_visible, false);
        if(typedArray.hasValue(R.styleable.CustomToolBar_left_tv_text)){
            leftTvText = typedArray.getString(R.styleable.CustomToolBar_left_tv_text);
        }
        /**-------------获取右边按钮属性------------*/
        isRightBtnVisible = typedArray.getBoolean(R.styleable.CustomToolBar_right_btn_visible, false);
        rightResId = typedArray.getResourceId(R.styleable.CustomToolBar_right_btn_src, -1);
        /**-------------获取右边文本属性------------*/
        isRightTvVisible = typedArray.getBoolean(R.styleable.CustomToolBar_right_tv_visible, false);
        if(typedArray.hasValue(R.styleable.CustomToolBar_right_tv_text)){
            rightTvText = typedArray.getString(R.styleable.CustomToolBar_right_tv_text);
        }
        /**-------------获取标题属性------------*/
        isTitleVisible = typedArray.getBoolean(R.styleable.CustomToolBar_title_visible, false);
        if(typedArray.hasValue(R.styleable.CustomToolBar_title_text)){
            titleText = typedArray.getString(R.styleable.CustomToolBar_title_text);
        }
        /**-------------背景颜色------------*/
        backgroundResId = typedArray.getResourceId(R.styleable.CustomToolBar_barBackground, -1);

        typedArray.recycle();

        /**-------------设置内容------------*/
        View barLayoutView = View.inflate(getContext(), R.layout.public_titlebar, null);
        Button leftBtn = (Button)barLayoutView.findViewById(R.id.toolbar_left_btn);
        TextView leftTv = (TextView)barLayoutView.findViewById(R.id.toolbar_left_tv);
        TextView titleTv = (TextView)barLayoutView.findViewById(R.id.toolbar_title_tv);
        Button rightBtn = (Button)barLayoutView.findViewById(R.id.toolbar_right_btn);
        TextView rightTv = (TextView)barLayoutView.findViewById(R.id.toolbar_right_tv);
        RelativeLayout barRlyt = (RelativeLayout)barLayoutView.findViewById(R.id.toolbar_content_rlyt);

        if(isLeftBtnVisible){
            leftBtn.setVisibility(VISIBLE);
        }
        if(isLeftTvVisible){
            leftTv.setVisibility(VISIBLE);
        }
        if(isRightBtnVisible){
            rightBtn.setVisibility(VISIBLE);
        }
        if(isRightTvVisible){
            rightTv.setVisibility(VISIBLE);
        }
        if(isTitleVisible){
            titleTv.setVisibility(VISIBLE);
        }
        leftTv.setText(leftTvText);
        rightTv.setText(rightTvText);
        titleTv.setText(titleText);

        if(leftResId != -1){
            leftBtn.setBackgroundResource(leftResId);
        }
        if(rightResId != -1){
            rightBtn.setBackgroundResource(rightResId);
        }
        if(backgroundResId != -1){
            barRlyt.setBackgroundColor(getResources().getColor(R.color.bg_toolbar));
        }
        //将设置完成之后的View添加到此LinearLayout中
        addView(barLayoutView, 0);
    }
}