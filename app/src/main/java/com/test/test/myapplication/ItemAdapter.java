package com.test.test.myapplication;

import com.chad.library.adapter.base.BaseMultiItemQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;

import java.util.List;

public class ItemAdapter extends BaseMultiItemQuickAdapter<MyItem, BaseViewHolder> {
    public ItemAdapter(List data) {
        super(data);
        addItemType(MyItem.TEXT, R.layout.text_view);
        addItemType(MyItem.IMG, R.layout.image_view);
        addItemType(MyItem.TEXT_IMG, R.layout.text_image_view);
    }

    @Override
    protected void convert(BaseViewHolder helper, MyItem myItem) {
        switch (helper.getItemViewType()) {
            case MyItem.TEXT:
                helper.setText(R.id.tv, myItem.getText());
                break;
            case MyItem.IMG:
                helper.setImageResource(R.id.img, R.drawable.img2);
                break;
            case MyItem.TEXT_IMG:
                helper.setText(R.id.tv2, myItem.getText());
                helper.setImageResource(R.id.img2, R.drawable.img);
                break;
        }

    }
}
