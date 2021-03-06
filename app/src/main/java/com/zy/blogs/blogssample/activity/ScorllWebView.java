package com.zy.blogs.blogssample.activity;

import android.content.Context;
import android.util.AttributeSet;
import android.webkit.WebView;

/**
 * <p/>
 * 作者：zhouyuan on  2016/7/29 15:56
 * <p/>
 * 邮箱：244370114@qq.com
 * <p/>
 */
public class ScorllWebView extends WebView {

    private OnScrollChangedCallback mOnScrollChangedCallback;

    public ScorllWebView(Context context) {
        super(context);
    }

    public ScorllWebView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public ScorllWebView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }


    @Override
    protected void onScrollChanged(int l, int t, int oldl, int oldt) {
        super.onScrollChanged(l, t, oldl, oldt);
        if (mOnScrollChangedCallback != null) {
            mOnScrollChangedCallback.onScroll(l - oldl, t - oldt);
        }
    }

    public OnScrollChangedCallback getOnScrollChangedCallback() {
        return mOnScrollChangedCallback;
    }

    public void setOnScrollChangedCallback(
            final OnScrollChangedCallback onScrollChangedCallback) {
        mOnScrollChangedCallback = onScrollChangedCallback;
    }

    public static interface OnScrollChangedCallback {
        //这里的dx和dy代表的是x轴和y轴上的偏移量，你也可以自己把l, t, oldl, oldt四个参数暴露出来
        public void onScroll(int dx, int dy);
    }
}
