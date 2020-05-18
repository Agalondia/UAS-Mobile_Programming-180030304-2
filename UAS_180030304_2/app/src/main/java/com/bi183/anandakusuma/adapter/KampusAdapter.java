package com.bi183.anandakusuma.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.jakewharton.picasso.OkHttp3Downloader;
import com.bi183.anandakusuma.InputActivity;
import com.bi183.anandakusuma.R;
import com.bi183.anandakusuma.TampilActivity;
import com.bi183.anandakusuma.model.Kampus;
import com.squareup.picasso.Picasso;

import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

public class KampusAdapter extends RecyclerView.Adapter<KampusAdapter.KampusViewHolder> {

    private List<Kampus> dataKampus;
    private Context context;

    public KampusAdapter(List<Kampus> dataKampus, Context context) {
        this.dataKampus = dataKampus;
        this.context = context;
    }

    @NonNull
    @Override
    public KampusViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.list_kampus, parent, false);
        return new KampusViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull KampusViewHolder holder, int position) {
        Kampus tempKampus = dataKampus.get(position);
        holder.id = tempKampus.getId();
        holder.firstName = tempKampus.getFirstName();
        holder.lastName = tempKampus.getLastName();
        holder.kelas = tempKampus.getKelas();
        holder.gender = tempKampus.getGender();
        holder.tvName.setText(holder.firstName + " " + holder.lastName);
        holder.tvNim.setText(tempKampus.getNim());
        holder.tvKelas.setText(tempKampus.getKelas());
        String imgLocation = tempKampus.getPhoto();
        if(!imgLocation.equals(null)) {
            //Picasso.get().load(imgLocation).resize(64, 64).into(holder.imgAvatar);
            Picasso.Builder builder = new Picasso.Builder(context);
            builder.downloader(new OkHttp3Downloader(context));
            builder.build().load(imgLocation)
                    .placeholder((R.drawable.ic_launcher_background))
                    .error(R.drawable.ic_launcher_background)
                    .into(holder.imgAvatar);
        }
        holder.imgAvatar.setContentDescription(tempKampus.getPhoto());
    }

    @Override
    public int getItemCount() {
        return dataKampus.size();
    }

    public class KampusViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener, View.OnLongClickListener{

        private TextView tvName, tvNim, tvKelas;
        private CircleImageView imgAvatar;
        private int id;
        private String firstName, lastName, kelas, gender;

        public KampusViewHolder(@NonNull View itemView) {
            super(itemView);

            tvName = itemView.findViewById(R.id.tv_name);
            tvNim = itemView.findViewById(R.id.tv_nim);
            tvKelas = itemView.findViewById(R.id.tv_kelas);
            imgAvatar = itemView.findViewById(R.id.profile_image);

            itemView.setOnClickListener(this);
            itemView.setOnLongClickListener(this);
        }

        @Override
        public void onClick(View v) {
            Intent openDisplay = new Intent(context, TampilActivity.class);
            openDisplay.putExtra("FULL_NAME", firstName +" "+ lastName);
            openDisplay.putExtra("NIM", tvNim.getText());
            openDisplay.putExtra("KELAS", kelas);
            openDisplay.putExtra("IMAGE", imgAvatar.getContentDescription());
            openDisplay.putExtra("GENDER", gender);
            itemView.getContext().startActivity(openDisplay);
        }

        @Override
        public boolean onLongClick(View v) {
            Intent openInput = new Intent(context, InputActivity.class);
            openInput.putExtra("OPERATION", "update");
            openInput.putExtra("ID", id);
            openInput.putExtra("FIRST_NAME", firstName);
            openInput.putExtra("LAST_NAME", lastName);
            openInput.putExtra("NIM", tvNim.getText());
            openInput.putExtra("KELAS", kelas);
            openInput.putExtra("IMAGE", imgAvatar.getContentDescription());
            openInput.putExtra("GENDER", gender);
            itemView.getContext().startActivity(openInput);
            return true;
        }
    }
}