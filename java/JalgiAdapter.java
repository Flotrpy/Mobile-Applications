package com.example.jalgibook;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.Switch;
import android.widget.TextView;

import androidx.annotation.NonNull;

import java.util.ArrayList;

public class JalgiAdapter extends ArrayAdapter<Jalgi> {
    public JalgiAdapter(Context context, ArrayList<Jalgi> jalgotes) {
        super(context, 0, jalgotes);
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.adapter_layout, parent, false);
        }

        Jalgi current = getItem(position);

        ImageView imageView = convertView.findViewById(R.id.imageView);
        TextView nameText = convertView.findViewById(R.id.textView);
        Button button = convertView.findViewById(R.id.button);
        Switch toggle = convertView.findViewById(R.id.switch1);

        nameText.setText(current.getName());
        imageView.setImageResource(current.getImageResId());

        button.setText("Remove");

        toggle.setOnCheckedChangeListener(null);
        toggle.setChecked(current.isActive());

        toggle.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(@NonNull CompoundButton compoundButton, boolean b) {
                current.setActive(b);
            }
        });

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                remove(current);
                notifyDataSetChanged();
            }
        });

        return convertView;
    }
}
