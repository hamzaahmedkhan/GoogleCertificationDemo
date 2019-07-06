package com.tekrevol.googlecert;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.snackbar.Snackbar;

public class MainActivity extends AppCompatActivity {

    ConstraintLayout parentLayout;
    ConstraintLayout contNotification;
    LinearLayout contToast;
    LinearLayout contSnackbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        parentLayout = findViewById(R.id.parentLayout);
        contToast = findViewById(R.id.contCustomToast);
        contSnackbar = findViewById(R.id.contSnackbar);
        contNotification = findViewById(R.id.contNotification);
        setListener();

    }

    private void setListener() {
        contToast.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                showCustomToast();

            }
        });

        contSnackbar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Snackbar.make(parentLayout, "test snackbar", Snackbar.LENGTH_SHORT).show();
            }
        });


        contNotification.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openActivity(NotificationActivity.class);
            }
        });



    }

    /**
     * CUSTOM VIEW TOAST
     */

    private void showCustomToast() {
        LayoutInflater inflater = getLayoutInflater();
        View layout = inflater.inflate(R.layout.custom_toast,
                (ViewGroup) findViewById(R.id.custom_toast_container));

        TextView text = (TextView) layout.findViewById(R.id.text);
        text.setText("This is a custom toast");

        Toast toast = new Toast(getApplicationContext());
        toast.setGravity(Gravity.CENTER_VERTICAL, 0, 0);
        toast.setDuration(Toast.LENGTH_LONG);
        toast.setView(layout);
        toast.show();
    }





    private void openMapsActivityForResult(Class<?> tClass, int requestCode) {
        Intent i = new Intent(this, tClass);
        startActivityForResult(i, requestCode);
    }

    private void openMapsActivityForResult(Class<?> tClass, Fragment fragment, int requestCode) {
        Intent i = new Intent(this, tClass);
        fragment.startActivityForResult(i, requestCode);
    }

    private void openActivity(Class<?> tClass) {
        Intent i = new Intent(this, tClass);
        startActivity(i);
    }
}
