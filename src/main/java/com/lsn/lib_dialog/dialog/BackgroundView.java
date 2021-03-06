package com.lsn.lib_dialog.dialog;

import android.annotation.SuppressLint;
import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

@SuppressLint("AppCompatCustomView")
public class BackgroundView extends ImageView {

    private OnTouchedListener mOnTouchedListener = null;

    public BackgroundView(@NonNull Context context) {
        this(context, null);
    }

    public BackgroundView(@NonNull Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public BackgroundView(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @SuppressLint("ClickableViewAccessibility")
    @Override
    public boolean onTouchEvent(MotionEvent ev) {
        switch (ev.getAction()) {
            case MotionEvent.ACTION_DOWN:
                if (mOnTouchedListener != null) {
                    mOnTouchedListener.onTouched();
                }
                break;
            default:
                break;
        }
        return super.onTouchEvent(ev);
    }

    public void setOnTouchedListener(@Nullable OnTouchedListener onTouchedListener) {
        this.mOnTouchedListener = onTouchedListener;
    }

    public interface OnTouchedListener {
        void onTouched();
    }
}
