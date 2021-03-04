package com.example.travelloggedin;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;

public class ContactAdapter extends RecyclerView.Adapter<ContactAdapter.Viewholder> {

    private Context context;
    private ArrayList<ContactModel> contactModelArrayList;

    // Constructor
    public ContactAdapter(Context context, ArrayList<ContactModel> contactModelArrayList) {
        this.context = context;
        this.contactModelArrayList = contactModelArrayList;
    }

    @NonNull
    @Override
    public ContactAdapter.Viewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // to inflate the layout for each item of recycler view.
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_layout, parent, false);
        return new Viewholder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ContactAdapter.Viewholder holder, int position) {
        // to set data to textview and imageview of each card layout
        ContactModel model = contactModelArrayList.get(position);
        holder.Email.setText(model.getEmail());
        holder.Phone.setText("" + model.getMobile());
//        holder.courseIV.setImageResource(model.getCourse_image());
    }

    @Override
    public int getItemCount() {
        // this method is used for showing number
        // of card items in recycler view.
        return contactModelArrayList.size();
    }

    // View holder class for initializing of
    // your views such as TextView and Imageview.
    public class Viewholder extends RecyclerView.ViewHolder {
        //private ImageView courseIV;
        private TextView Email, Phone;

        public Viewholder(@NonNull View itemView) {
            super(itemView);
            Email = itemView.findViewById(R.id.email);
            Phone = itemView.findViewById(R.id.phone);
        }
    }
}
