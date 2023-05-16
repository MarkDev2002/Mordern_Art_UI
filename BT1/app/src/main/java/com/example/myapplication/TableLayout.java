package com.example.myapplication;

import android.app.AlertDialog;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.SeekBar;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class TableLayout extends AppCompatActivity {
    Intent intent = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_table_layout);
        this.setTitle("Table Layout");

        SeekBar sb = findViewById(R.id.seekBar);
        View view1 = findViewById(R.id.view1);
        View view2 = findViewById(R.id.view2);
        View view3 = findViewById(R.id.view3);
        View view4 = findViewById(R.id.view4);
        View view5 = findViewById(R.id.view5);

        int colorOfview1 = getResources().getColor(R.color.material_deep_teal_500);
        int colorOfview2 = getResources().getColor(R.color.accent_material_dark);
        int colorOfview3 = getResources().getColor(R.color.accent_material_dark);
        int colorOfview4 = getResources().getColor(R.color.white);
        int colorOfview5 = getResources().getColor(R.color.green_monochrome);
        int red = getResources().getColor(R.color.red);
        int blue = getResources().getColor(R.color.blue);

        sb.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {

            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {


                view1.setBackgroundColor((int) (colorOfview1 + blue * (i / 100f)));
                view2.setBackgroundColor((int) (colorOfview2 + blue * (i / 100f)));
                view3.setBackgroundColor((int) (colorOfview3 + red * (i / 100f)));
                view4.setBackgroundColor((int) (colorOfview4 + blue * (i / 100f)));
                view5.setBackgroundColor((int) (colorOfview5 + blue * (i / 100f)));

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menutable, menu);
        return true;
    }

    public void doPositiveClick() {
        Uri uri = Uri.parse("https://www.facebook.com/nvtins");
        Intent visit = new Intent(Intent.ACTION_VIEW, uri);
        startActivity(visit);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case (R.id.linear):
                intent = new Intent(this, LinearLayout.class).setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);
                return true;
            case (R.id.relative):
                intent = new Intent(this, RelativeLayout.class).setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);
                return true;
            case (R.id.info):
                AlertDialog.Builder builder = new AlertDialog.Builder(TableLayout.this);
                builder.setMessage(R.string.dialog_text);  //định nghĩa dialog_text trong string.xml
                builder.setCancelable(false);
                builder.setPositiveButton(
                        R.string.visit, //định nghĩa visit_MOMA trong string.xml
                        (dialogInterface, i) -> TableLayout.this.doPositiveClick()
                );
                builder.setNegativeButton(
                        R.string.not_now, //định nghĩa not_now trong string.xml
                        (dialogInterface, i) -> dialogInterface.cancel()
                );
                builder.create().show();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

}
