package com.example.andri.iak_biginer;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    boolean doubleBackToExitPressedonce =false;

    private Button culik;
@Override
public void onBackPressed(){
    if (getSupportFragmentManager().getBackStackEntryCount()>0){
    getSupportFragmentManager().popBackStack();

    }
    else if (!doubleBackToExitPressedonce) {
        this.doubleBackToExitPressedonce = true;
        Toast.makeText(this, "Ketuk dua kali untuk keluar", Toast.LENGTH_SHORT).show();
        new Handler().postDelayed(new Runnable() {

            @Override
            public void run() {
                doubleBackToExitPressedonce = false;

            }
        }, 2000);
    }else{
        super.onBackPressed();
        return;
        }
}







    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    public void onClickBtn(View view) {

        Intent intent = new Intent(this, culik2Activity.class);
        startActivity(intent);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        Intent intent;
        switch (item.getItemId()) {
            case R.id.order:
                intent = new Intent(this, culik2Activity.class);
                startActivity(intent);
                break;
            case R.id.about:
                intent = new Intent(this, AboutActivity.class);
                startActivity(intent);
                break;
            case R.id.exit:
                AlertDialog.Builder builder = new AlertDialog.Builder(this);
                builder.setTitle("Anda Yakin Mau Keluar");
                builder.setPositiveButton("Ya",new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick (DialogInterface dialogInterface,int i){
                    finish();
                    }
                });
                builder.setNegativeButton("Tidak", new DialogInterface.OnClickListener(){
                    @Override
                    public void onClick(DialogInterface dialogInterface,int i){
                        dialogInterface.dismiss();
                    }
                });
                AlertDialog quit = builder.create();
                quit.show();
                break;


        }
        return super.onOptionsItemSelected(item);
    }





}

