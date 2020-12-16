package com.daomtthuan.aptechandroid.studentlist.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import com.daomtthuan.aptechandroid.studentlist.adapter.holder.StudentItemViewHolder;
import com.daomtthuan.aptechandroid.studentlist.entity.Student;

import java.util.List;

public class StudentListAdapter extends BaseAdapter {
  private final Context context;
  private final int layout;
  private final List<Student> listStudent;

  public StudentListAdapter(Context context, int layout, List<Student> listStudent) {
    this.context = context;
    this.layout = layout;
    this.listStudent = listStudent;
  }

  @Override
  public int getCount() {
    return this.listStudent.size();
  }

  @Override
  public Student getItem(int position) {
    return this.listStudent.get(position);
  }

  @Override
  public long getItemId(int position) {
    return position;
  }

  @Override
  public View getView(int position, View convertView, ViewGroup parent) {
    StudentItemViewHolder itemStudent;
    if (convertView == null) {
      convertView = ((LayoutInflater) this.context.getSystemService(Context.LAYOUT_INFLATER_SERVICE)).inflate(this.layout, null);
      itemStudent = new StudentItemViewHolder(convertView);
      convertView.setTag(itemStudent);
    } else {
      itemStudent = (StudentItemViewHolder) convertView.getTag();
    }

    Student student = this.listStudent.get(position);
    itemStudent.getLabelId().setText(String.valueOf(student.getId()));
    itemStudent.getLabelName().setText(String.valueOf(student.getName()));
    itemStudent.getLabelEmail().setText(String.valueOf(student.getEmail()));

    return convertView;
  }
}
