package com.bi183.anandakusuma;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import com.jakewharton.picasso.OkHttp3Downloader;
import com.squareup.picasso.Picasso;

import de.hdodenhof.circleimageview.CircleImageView;

public class TampilActivity extends AppCompatActivity {

    private TextView tvName, tvMahasiswa, tvKelas, tvGender;
    private CircleImageView imgProfilePicture;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tampil);

        tvName = findViewById(R.id.tv_full_name);
        tvMahasiswa = findViewById(R.id.tv_mahasiswa_nim);
        tvKelas = findViewById(R.id.tv_kelas);
        tvGender = findViewById(R.id.tv_gender);
        imgProfilePicture = findViewById(R.id.profile_image_display);

        Intent receivedData = getIntent();
        Bundle data = receivedData.getExtras();
        tvName.setText(data.getString("FULL_NAME"));
        tvMahasiswa.setText(data.getString("NIM"));
        tvKelas.setText(data.getString("KELAS"));
        tvGender.setText(data.getString("GENDER"));
        String imgLocation = data.getString("IMAGE");
        if (!imgLocation.equals(null)) {
            Picasso.Builder builder = new Picasso.Builder(getApplicationContext());
            builder.downloader(new OkHttp3Downloader(getApplicationContext()));
            builder.build().load(imgLocation)
                    .placeholder((R.drawable.ic_launcher_background))
                    .error(R.drawable.ic_launcher_background)
                    .into(imgProfilePicture);
        }
        imgProfilePicture.setContentDescription(imgLocation);
    }
}