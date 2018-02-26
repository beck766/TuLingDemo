package com.beck.tuling.view.adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.beck.tuling.R;
import com.beck.tuling.model.http.entity.TuLingResponse;

import java.text.SimpleDateFormat;
import java.util.List;

public class ChatMessageAdapter extends BaseAdapter {
    private static final String TAG = ChatMessageAdapter.class.getSimpleName();
    private LayoutInflater mInflater;
    private List<TuLingResponse> mDatas;

    public ChatMessageAdapter(Context context, List<TuLingResponse> mDatas) {
        mInflater = LayoutInflater.from(context);
        this.mDatas = mDatas;
    }

    @Override
    public int getCount() {
        return mDatas.size();
    }

    @Override
    public Object getItem(int position) {
        return mDatas.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public int getItemViewType(int position) {
        TuLingResponse chatMessage = mDatas.get(position);
        if (chatMessage.getType() == TuLingResponse.Type.INCOMING) {
            return 0;
        }
        return 1;
    }

    @Override
    public int getViewTypeCount() {
        return 2;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Log.i(TAG, "getView: position=" + position);
        TuLingResponse chatMessage = mDatas.get(position);
        ViewHolder viewHolder = null;
        if (convertView == null) {
            Log.i(TAG, "getView: getItemViewType(position)=" + getItemViewType(position));
            // 通过ItemType设置不同的布局
            if (getItemViewType(position) == 0) {
                convertView = mInflater.inflate(R.layout.item_from_msg, parent,
                        false);
                viewHolder = new ViewHolder();
                viewHolder.mDate = convertView
                        .findViewById(R.id.id_form_msg_date);
                viewHolder.mMsg = convertView
                        .findViewById(R.id.id_from_msg_info);
            } else {
                convertView = mInflater.inflate(R.layout.item_to_msg, parent,
                        false);
                viewHolder = new ViewHolder();
                viewHolder.mDate = convertView
                        .findViewById(R.id.id_to_msg_date);
                viewHolder.mMsg = convertView
                        .findViewById(R.id.id_to_msg_info);
            }
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }
        // 设置数据
        @SuppressLint("SimpleDateFormat") SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        viewHolder.mDate.setText(df.format(chatMessage.getDate()));
        viewHolder.mMsg.setText(chatMessage.getText());
        return convertView;
    }

    private final class ViewHolder {
        TextView mDate;
        TextView mMsg;
    }

}
