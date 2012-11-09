package com.justudin.moneychanger;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class Money_Activity extends Activity {
	private Button btn_hitung;
	String res;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_money_);
		inisialisasi();

	}

	// inisialisasi variable
	public void inisialisasi() {

		btn_hitung = (Button) findViewById(R.id.btn_hitung);
		btn_hitung.setOnClickListener(proses_hitung);
	}

	public void ubah(View view) {
		boolean checked = ((RadioButton) view).isChecked();
		switch (view.getId()) {
		case R.id.pil_do_piah:
			if (checked) {
				res = "1";

			}
			break;
		case R.id.pil_ru_dol:
			if (checked) {

				res = "0";

			}
			break;

		}

	}

	public View.OnClickListener proses_hitung = new View.OnClickListener() {

		public void onClick(View v) {
			// TODO Auto-generated method stub
			EditText input = (EditText) findViewById(R.id.txt_dolar);
			EditText output = (EditText) findViewById(R.id.txt_rupiah);
			double x = Double.parseDouble(input.getText().toString());
			double hasil = 0;

			if (res.equals("1")) {
				hasil = x * 9500;
			} else {
				hasil = x / 9500;
			}

			String aString = Double.toString(hasil);
			output.setText(aString);
		}
	};

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.activity_money_, menu);
		return true;
	}
}
