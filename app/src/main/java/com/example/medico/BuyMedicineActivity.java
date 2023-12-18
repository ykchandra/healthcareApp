package com.example.medico;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import java.util.ArrayList;
import java.util.HashMap;

public class BuyMedicineActivity extends AppCompatActivity {

    private String[][] packages={
            {"Uprise-D3 Tablets", "10x3=30 Tab", "EXPY: ", "12/2023", "50"},
            {"Chromium Tablets", "12x3=36 Tab", "EXPY: ", "2/2023", "305"},
            {"Vitamin-B Complex Tablets", "10x2=20 Tab", "EXPY: ", "01/2024", "500"},
            {"Vitamin-E Tablets", "12x2=24 Tab", "EXPY: ", "12/2023", "250"},
            {"Dolo-650 Tablets", "7x3=21 Tab", "EXPY: ", "09/2024", "120"},
            {"Crocin Advance Tablets", "5x2=10 Tab", "EXPY: ", "10/2024", "290"},
            {"Strepsils Tablets ", "10x4=40 Tab", "EXPY: ", "08/2025", "110"},
            {"Zithrocin 500 Tablets", "18x2=36 Tab", "EXPY: ", "11/2024", "350"},
            {"Feronia-XT Tablets", "15x3=45 Tab", "EXPY: ", "04/2024", "220"},
           
    };
    private String [] package_details={
            "Uprise-D3 60K Capsule is used in the treatment of vitamin D deficiency and osteoporosis.\n"+"It helps the body to absorb calcium\n"+"Calcium is essential for maintaining strong and healthy bones",
            "Chromium Picolinate which aids metabolism by providing a highly absorb able form of the trace mineral chromium\n"+"Chromium– a highly bio available insulin co-factor for dieters and athletes\n"+"If you want to lose fat or keep up with intense workouts, Chromium Picolinate can help!This superstar supplement is also linked to energy production and muscle building",
            "Vitamin B complex is a group of B vitamins\n"+"These vitamins aid in fetal brain development, and they reduce the risk of birth defects.\n"+"For people who are expecting, B vitamins may help manage energy levels, ease nausea, and lower the risk of developing preeclampsia.",
            "Uprise-D3 60K Capsule is used in the treatment of vitamin D deficiency and osteoporosis.\n"+"It helps the body to absorb calcium\n"+"Calcium is essential for maintaining strong and healthy bones",
            "Chromium Picolinate which aids metabolism by providing a highly absorb able form of the trace mineral chromium\n"+"Chromium– a highly bio available insulin co-factor for dieters and athletes\n"+"If you want to lose fat or keep up with intense workouts, Chromium Picolinate can help!This superstar supplement is also linked to energy production and muscle building",
            "Vitamin B complex is a group of B vitamins\n"+"These vitamins aid in fetal brain development, and they reduce the risk of birth defects.\n"+"For people who are expecting, B vitamins may help manage energy levels, ease nausea, and lower the risk of developing preeclampsia.",
            "Uprise-D3 60K Capsule is used in the treatment of vitamin D deficiency and osteoporosis.\n"+"It helps the body to absorb calcium\n"+"Calcium is essential for maintaining strong and healthy bones",
            "Chromium Picolinate which aids metabolism by providing a highly absorb able form of the trace mineral chromium\n"+"Chromium– a highly bio available insulin co-factor for dieters and athletes\n"+"If you want to lose fat or keep up with intense workouts, Chromium Picolinate can help!This superstar supplement is also linked to energy production and muscle building",
            "Vitamin B complex is a group of B vitamins\n"+"These vitamins aid in fetal brain development, and they reduce the risk of birth defects.\n"+"For people who are expecting, B vitamins may help manage energy levels, ease nausea, and lower the risk of developing preeclampsia."
    };
    HashMap<String, String> item;
    ArrayList list;
    SimpleAdapter sa;
    ListView lst;
    Button btnBack, btnGoToCart;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_buy_medicine);

        lst=findViewById(R.id.listViewBM);
        btnBack=findViewById(R.id.buttonBMBack);
        btnGoToCart=findViewById(R.id.buttonBMGoToCart);

        btnGoToCart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               startActivity(new Intent(BuyMedicineActivity.this, CartBuyMedicineActivity.class));
            }
        });
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(BuyMedicineActivity.this, HomeActivity.class));
            }
        });

        list= new ArrayList();
        for (int i=0;i<packages.length; i++){
            item= new HashMap<String,String>();
            item.put("line1",packages[i][0]);
            item.put("line2",packages[i][1]);
            item.put("line3",packages[i][2]);
            item.put("line4",packages[i][3]);
            item.put("line5","Total Cost: "+packages[i][4]+"/-");
            list.add(item);
        }
        sa= new SimpleAdapter(this, list,
                R.layout.multi_lines,
                new String[] {"line1","line2","line3","line4","line5"},
                new int[] {R.id.line_a,R.id.line_b,R.id.line_c,R.id.line_d,R.id.line_e});
        lst.setAdapter(sa);

        lst.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int i, long l) {
                Intent it= new Intent(BuyMedicineActivity.this, BuyMedicineDetailsActivity.class);
                it.putExtra("text1",packages[i][0]);
                it.putExtra("text2",package_details[i]);
                it.putExtra("text3",packages[i][4]);
                startActivity(it);
            }
        });
    }
}