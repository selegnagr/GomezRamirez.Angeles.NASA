package com.example.l0010691.gomezramirezangelesnasa;


import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;


import com.squareup.picasso.Picasso;

/**
 * An example full-screen activity that shows and hides the system UI (i.e.
 * status bar and navigation/system bar) with user interaction.
 */
public class FullscreenActivity extends AppCompatActivity {

    private ImageView mImage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_fullscreen);
        mImage = (ImageView) findViewById(R.id.imagenCompleta);
        String url =  getIntent().getSerializableExtra("urlImagen").toString();
        Picasso.with(this).load(url).into(mImage);
    }
}
