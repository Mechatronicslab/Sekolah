package com.example.terminator.pkw;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;


import java.util.Calendar;

public class DaftarSiswaActivity extends AppCompatActivity {

    @BindView(R.id.spinnerJenisKelamin)
    Spinner spnJenisKelamin;

    @BindView(R.id.spinnerAgama)
    Spinner spnAgama;

    @BindView(R.id.spinnerJurusan)
    Spinner spnJurusan;

    @BindView(R.id.ed_tgl_lahir)
    EditText edTglLahir;

    private ArrayAdapter adapter;

    private int year;
    private int month;
    private int day;
    static final int DATE_PICKER_ID = 1111;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_daftar_siswa);
        overridePendingTransition(R.anim.fade_out, R.anim.fade_in);
        ButterKnife.bind(this);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        setTitle("Daftar");

        adapter = ArrayAdapter.createFromResource(this, R.array.jenisKelamin, R.layout.row);
        spnJenisKelamin.setAdapter(adapter);

        adapter = ArrayAdapter.createFromResource(this, R.array.agama, R.layout.row);
        spnAgama.setAdapter(adapter);

        adapter = ArrayAdapter.createFromResource(this, R.array.jurusan, R.layout.row);
        spnJurusan.setAdapter(adapter);

        //Get current date by calender
        final Calendar c = Calendar.getInstance();
        year  = c.get(Calendar.YEAR);
        month = c.get(Calendar.MONTH);
        day   = c.get(Calendar.DAY_OF_MONTH);

        edTglLahir.setFocusable(false);
        edTglLahir.setFocusableInTouchMode(false);
    }

    @OnClick(R.id.ed_tgl_lahir)
    void  tglLair(){
        showDialog(DATE_PICKER_ID);
    }

    @Override
    protected Dialog onCreateDialog(int id) {
        switch (id) {
            case DATE_PICKER_ID:

                // open datepicker dialog.
                // set date picker for current date
                // add pickerListener listner to date picker
                return new DatePickerDialog(this, pickerListener, year, month,day);
        }
        return null;
    }

    private DatePickerDialog.OnDateSetListener pickerListener = new DatePickerDialog.OnDateSetListener() {

        // when dialog box is closed, below method will be called.
        @Override
        public void onDateSet(DatePicker view, int selectedYear,
                              int selectedMonth, int selectedDay) {

            year  = selectedYear;
            month = selectedMonth+1;
            day   = selectedDay;
            edTglLahir.setText(year+"-"+month+"-"+day);
        }
    };

    @Override
    public void onBackPressed() {
        Intent a = new Intent(DaftarSiswaActivity.this, MainActivity.class);
        startActivity(a);
        finish();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                onBackPressed();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

}
