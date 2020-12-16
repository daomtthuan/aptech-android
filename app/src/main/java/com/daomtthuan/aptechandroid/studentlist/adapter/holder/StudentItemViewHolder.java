package com.daomtthuan.aptechandroid.studentlist.adapter.holder;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.daomtthuan.aptechandroid.R;

public class StudentItemViewHolder extends RecyclerView.ViewHolder {
  private final TextView labelId;
  private final TextView labelName;
  private final TextView labelEmail;

  public StudentItemViewHolder(@NonNull View itemView) {
    super(itemView);
    this.labelId = itemView.findViewById(R.id.label_id);
    this.labelName = itemView.findViewById(R.id.label_name);
    this.labelEmail = itemView.findViewById(R.id.label_email);
  }

  public TextView getLabelId() {
    return labelId;
  }

  public TextView getLabelName() {
    return labelName;
  }

  public TextView getLabelEmail() {
    return labelEmail;
  }
}
