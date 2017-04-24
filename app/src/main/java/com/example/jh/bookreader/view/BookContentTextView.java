package com.example.jh.bookreader.view;

import android.content.Context;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.AppCompatTextView;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.TextPaint;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.util.AttributeSet;
import android.view.View;
import android.widget.TextView;

import com.example.jh.bookreader.R;
import com.example.jh.bookreader.ui.activity.SearchActivity;
import com.example.jh.bookreader.utils.LogUtils;

/**
 * Created by jinhui  on 2017/4/24
 * 邮箱: 1004260403@qq.com
 *
 * 识别文字中的书名
 */

public class BookContentTextView extends AppCompatTextView {

    public BookContentTextView(Context context) {
        this(context, null);
    }

    public BookContentTextView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public BookContentTextView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public void setText(String text) {
        int startIndex = 0;
        while (true) {

            int start = text.indexOf("《");
            int end = text.indexOf("》");
            if (start < 0 || end < 0) {
                append(text.substring(startIndex));
                break;
            }

            append(text.substring(startIndex, start));

            SpannableString spanableInfo = new SpannableString(text.substring(start, end + 1));
            spanableInfo.setSpan(new Clickable(spanableInfo.toString()), 0, end + 1 - start, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
            append(spanableInfo);
            //setMovementMethod()该方法必须调用，否则点击事件不响应
            setMovementMethod(LinkMovementMethod.getInstance());
            text = text.substring(end + 1);

            LogUtils.e(spanableInfo.toString());
        }
    }

    class Clickable extends ClickableSpan {
        private String name;

        public Clickable(String name) {
            super();
            this.name = name;
        }

        @Override
        public void updateDrawState(TextPaint ds) {
            super.updateDrawState(ds);
            ds.setColor(ContextCompat.getColor(getContext(), R.color.light_coffee));
            ds.setUnderlineText(false);
        }

        @Override
        public void onClick(View v) {
            SearchActivity.startActivity(getContext(), name.replaceAll("》","").replaceAll("《",""));
        }
    }
}
