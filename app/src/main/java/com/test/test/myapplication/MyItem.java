package com.test.test.myapplication;

import com.chad.library.adapter.base.entity.MultiItemEntity;

public class MyItem implements MultiItemEntity {
    public static final int TEXT = 1;
    public static final int IMG = 2;
    public static final int TEXT_IMG = 3;
    private int type;

    private String text="";

    public MyItem(int itemType) {
        this.type = itemType;
    }

    @Override
    public int getItemType() {
        return type;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
