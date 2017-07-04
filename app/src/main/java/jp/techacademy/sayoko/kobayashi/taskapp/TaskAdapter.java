package jp.techacademy.sayoko.kobayashi.taskapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

public class TaskAdapter extends BaseAdapter {
    private LayoutInflater mLayoutInflater = null;
    private List<Task> mTaskList;

    public TaskAdapter(Context context){
        mLayoutInflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    public void setTaskList(List<Task> taskList){
        mTaskList = taskList;
    }

    @Override
    public int getCount() {
        return mTaskList.size();
    }

    @Override
    public Object getItem(int position) {
        return mTaskList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return mTaskList.get(position).getId();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if(convertView == null) {
            convertView = mLayoutInflater.inflate(jp.techacademy.sayoko.kobayashi.taskapp.R.layout.list_item, null);
        }

        TextView textView1 = (TextView) convertView.findViewById(R.id.text1);
        TextView textView2 = (TextView) convertView.findViewById(R.id.text2);
        TextView textView3 = (TextView) convertView.findViewById(R.id.text3);


        textView1.setText(mTaskList.get(position).getTitle());

        textView2.setText(mTaskList.get(position).getCategory());

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-mm-dd HH:mm", Locale.JAPANESE);
        Date date = mTaskList.get(position).getDate();
        textView3.setText(simpleDateFormat.format(date));

        return convertView;

    }
}
