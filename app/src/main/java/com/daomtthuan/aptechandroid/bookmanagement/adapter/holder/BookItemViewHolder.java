package com.daomtthuan.aptechandroid.bookmanagement.adapter.holder;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.daomtthuan.aptechandroid.R;

public class BookItemViewHolder extends RecyclerView.ViewHolder {
  private final TextView labelId;
  private final TextView labelTitle;
  private final TextView labelAuthor;

  public BookItemViewHolder(@NonNull View itemView) {
    super(itemView);
    this.labelId = itemView.findViewById(R.id.label_id);
    this.labelTitle = itemView.findViewById(R.id.label_title);
    this.labelAuthor = itemView.findViewById(R.id.label_author);
  }

  public TextView getLabelId() {
    return labelId;
  }

  public TextView getLabelTitle() {
    return labelTitle;
  }

  public TextView getLabelAuthor() {
    return labelAuthor;
  }
}
