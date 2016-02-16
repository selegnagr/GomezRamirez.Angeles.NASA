package com.example.l0010691.gomezramirezangelesnasa;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import com.example.l0010691.gomezramirezangelesnasa.models.Photo;
import com.example.l0010691.gomezramirezangelesnasa.models.ResultNasa;
import com.example.l0010691.gomezramirezangelesnasa.rest.RestClient;
import java.util.ArrayList;
import java.util.List;

import retrofit.Call;
import retrofit.Callback;
import retrofit.Response;

public class MainActivity extends AppCompatActivity {
    List<Photo> fotosNasa;

    private RecyclerView mRecyclerView;
    private PhotosAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Initialize recycler view
        mRecyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));

        fotosNasa = new ArrayList<Photo>();


        final ProgressDialog dialog = ProgressDialog.show(this, "", "loading...");
        RestClient.GitApiInterface service = RestClient.getClient();
        Call<ResultNasa> call = service.getPhotos(1000, "DEMO_KEY");
        call.enqueue(new Callback<ResultNasa>() {
            @Override
            public void onResponse(Response<ResultNasa> response) {
                dialog.dismiss();
                Log.d("MainActivity", "Status Code = " + response.code());
                if (response.isSuccess()) {
                    // request successful (status code 200, 201)
                    ResultNasa result = response.body();
                    //Log.d("MainActivity", "response = " + new Gson().toJson(result));
                    fotosNasa = result.getPhotos();
                    //Log.d("MainActivity", "Cantidad de Fotos = " + fotosNasa.size());
                    adapter = new PhotosAdapter(MainActivity.this, fotosNasa);
                    mRecyclerView.setAdapter(adapter);

                } else {
                    // response received but request not successful (like 400,401,403 etc)
                    //Handle errors

                }
            }

            @Override
            public void onFailure(Throwable t) {
                dialog.dismiss();
            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
