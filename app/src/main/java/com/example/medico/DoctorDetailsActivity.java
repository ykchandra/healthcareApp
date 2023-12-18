package com.example.medico;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;

public class DoctorDetailsActivity extends AppCompatActivity {
    private String[][] doctor_details1=
            {
                    {"Dr. Name : Dr. YASH KUMAR", "Hospital Address : DHANBAD", "Exp : 5yrs", "Mobile No :9876543210", "600"},
                    {"Dr. Name : Dr. ARHAM SHARJEEL", "Hospital Address : MAU", "Exp : 15yrs", "Mobile No :9876543210", "600"},
                    {"Dr. Name : Dr. ANKUR SINGH", "Hospital Address : PRAYAGRAJ", "Exp : 2yrs", "Mobile No :9876543210", "600"},
                    {"Dr. Name : Dr. VARNIT SINGH", "Hospital Address : LUCKNOW", "Exp : 4yrs", "Mobile No :9876543210", "600"},
                    {"Dr. Name : Dr. DIVYANSHU CHANDRA", "Hospital Address : UNNAO", "Exp : 5yrs", "Mobile No :9876543210", "600"},
            };
    private String[][] doctor_details2=
            {
                    {"Dr. Name : Dr. UNNATI", "Hospital Address : RAE BARELI", "Exp : 5yrs", "Mobile No :9876543210", "600"},
                    {"Dr. Name : Dr. SHREYASHI RAI", "Hospital Address : LUCKNOW", "Exp : 15yrs", "Mobile No :9876543210", "600"},
                    {"Dr. Name : Dr. ISHITA SHRIVASTAVA", "Hospital Address : KANPUR", "Exp : 2yrs", "Mobile No :9876543210", "600"},
                    {"Dr. Name : Dr. AASTHA BARANWAL", "Hospital Address : RANCHI", "Exp : 4yrs", "Mobile No :9876543210", "600"},
                    {"Dr. Name : Dr. AKANKSHA SINGH", "Hospital Address : VARANASI", "Exp : 5yrs", "Mobile No :9876543210", "600"},
            };
    private String[][] doctor_details3=
            {
                    {"Dr. Name : Dr. HARSHAL AGRAHARI", "Hospital Address : DHANBAD", "Exp : 5yrs", "Mobile No :9876543210", "600"},
                    {"Dr. Name : Dr. ABHINAV TRIPATHI", "Hospital Address : MAU", "Exp : 15yrs", "Mobile No :9876543210", "600"},
                    {"Dr. Name : Dr. ANURAG SINGH", "Hospital Address : PRAYAGRAJ", "Exp : 2yrs", "Mobile No :9876543210", "600"},
                    {"Dr. Name : Dr. ASHUTOSH TIWARI", "Hospital Address : LUCKNOW", "Exp : 4yrs", "Mobile No :9876543210", "600"},
                    {"Dr. Name : Dr. GYANANSHU KASHYAP", "Hospital Address : UNNAO", "Exp : 5yrs", "Mobile No :9876543210", "600"},
            };
    private String[][] doctor_details4=
            {
                    {"Dr. Name : Dr. SAMRIDHI SINGH", "Hospital Address : DHANBAD", "Exp : 5yrs", "Mobile No :9876543210", "600"},
                    {"Dr. Name : Dr. SHIVALIKA SINHA", "Hospital Address : MAU", "Exp : 15yrs", "Mobile No :9876543210", "600"},
                    {"Dr. Name : Dr. SIMRAN CHAURASIYA", "Hospital Address : PRAYAGRAJ", "Exp : 2yrs", "Mobile No :9876543210", "600"},
                    {"Dr. Name : Dr. PARMITA SINGH", "Hospital Address : LUCKNOW", "Exp : 4yrs", "Mobile No :9876543210", "600"},
                    {"Dr. Name : Dr. SHWETA MISHRA", "Hospital Address : UNNAO", "Exp : 5yrs", "Mobile No :9876543210", "600"},
            };
    private String[][] doctor_details5=
            {
                    {"Dr. Name : Dr. HARSHIT SHRIVASTAVA", "Hospital Address : DHANBAD", "Exp : 5yrs", "Mobile No :9876543210", "600"},
                    {"Dr. Name : Dr. SHIVAM JHA", "Hospital Address : MAU", "Exp : 15yrs", "Mobile No :9876543210", "600"},
                    {"Dr. Name : Dr. ACHINTYA NATH", "Hospital Address : PRAYAGRAJ", "Exp : 2yrs", "Mobile No :9876543210", "600"},
                    {"Dr. Name : Dr. ANURAG CHOWDHURY", "Hospital Address : LUCKNOW", "Exp : 4yrs", "Mobile No :9876543210", "600"},
                    {"Dr. Name : Dr. SHUBHAM SAHIL", "Hospital Address : UNNAO", "Exp : 5yrs", "Mobile No :9876543210", "600"},
            };

    TextView tv;
    Button btn;
    String[][] doctor_details={};
    HashMap<String, String> item;
    ArrayList list;
    SimpleAdapter sa;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doctor_details);

        tv=findViewById(R.id.textViewODTitle);
        btn=findViewById(R.id.buttonBMBack);

        Intent it= getIntent();
        String title=it.getStringExtra("title");
        tv.setText(title);

        if (title.compareTo("Family Physician")==0)
            doctor_details=doctor_details1;
        else
        if (title.compareTo("Dietician")==0)
            doctor_details=doctor_details2;
        else
        if (title.compareTo("Dentist")==0)
            doctor_details=doctor_details3;
        else
        if (title.compareTo("Surgeon")==0)
            doctor_details=doctor_details4;
        else
            doctor_details=doctor_details5;

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(DoctorDetailsActivity.this, FindDoctorActivity.class));
            }
        });
        list = new ArrayList();
        for (int i=0; i<doctor_details.length; i++){
            item = new HashMap<String, String>();
            item.put("line1", doctor_details[i][0]);
            item.put("line2", doctor_details[i][1]);
            item.put("line3", doctor_details[i][2]);
            item.put("line4", doctor_details[i][3]);
            item.put("line5", "Cons. Fees: "+doctor_details[i][4]+ "/-");
            list.add(item);
        }
        //Mapping
        sa= new SimpleAdapter(this,list,
                R.layout.multi_lines,
                new String[]{"line1","line2","line3","line4","line5"},
                new int[]{R.id.line_a, R.id.line_b, R.id.line_c, R.id.line_d, R.id.line_e,}
        );
        ListView lst= findViewById(R.id.listViewBM);
        lst.setAdapter(sa);
        lst.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int i, long l) {
               Intent it=new Intent(DoctorDetailsActivity.this, BookAppointmentActivity.class);
               it.putExtra("text1",title);
                it.putExtra("text2",doctor_details[i][0]);
                it.putExtra("text3",doctor_details[i][1]);
                it.putExtra("text4",doctor_details[i][3]);
                it.putExtra("text5",doctor_details[i][4]);
                startActivity(it);
            }
        });
    }
}