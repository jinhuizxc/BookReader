package com.example.jh.bookreader.view.pdfview;

/**
 * Created by jinhui  on 2017/4/24
 * 邮箱: 1004260403@qq.com
 */

public class PdfScale {

    public static final float DEFAULT_SCALE = 1.0f;

    float scale = DEFAULT_SCALE;
    float centerX = 0f;
    float centerY = 0f;

    public float getScale() {
        return scale;
    }

    public void setScale(float scale) {
        this.scale = scale;
    }

    public float getCenterX() {
        return centerX;
    }

    public void setCenterX(float centerX) {
        this.centerX = centerX;
    }

    public float getCenterY() {
        return centerY;
    }

    public void setCenterY(float centerY) {
        this.centerY = centerY;
    }
}

