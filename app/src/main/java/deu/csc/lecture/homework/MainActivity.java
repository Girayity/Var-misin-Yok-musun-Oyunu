package deu.csc.lecture.homework;

import android.app.Activity;
import android.app.ListActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Random;

public class MainActivity extends Activity {

    ArrayList<String> karistir = new ArrayList<>();
    ArrayList<String> paralar = new ArrayList<>();
    ArrayList<String> paralar2 = new ArrayList<>();
    ArrayAdapter<String> adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListView myListView = (ListView) findViewById(R.id.listview);

        paralar.add("1");
        paralar.add("5");
        paralar.add("10");
        paralar.add("50");
        paralar.add("100");
        paralar.add("250");
        paralar.add("500");
        paralar.add("1000");
        paralar.add("2500");
        paralar.add("5000");
        paralar.add("10000");
        paralar.add("20000");
        paralar.add("50000");
        paralar.add("75000");
        paralar.add("100000");
        paralar.add("100000");

        paralar2 = new ArrayList<>(paralar);
        adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1,
                paralar2);

        myListView.setAdapter(adapter);

        Random random = new Random();

        for (int i = 0; i < 16; i++) {
            int sayi = paralar.size();
            int rastgele = random.nextInt(sayi);
            karistir.add(String.valueOf(paralar.get(rastgele)));
            paralar.remove(rastgele);
        }
    }

    public void buttonClick(View v) {
        Button button = (Button) v;
        v.setEnabled(false);
        String para = karistir.get(Integer.parseInt(button.getText().toString()) - 1);
        Toast.makeText(getApplicationContext(), "Açılan Para: " + para + " TL.",
                Toast.LENGTH_LONG).show();
        paralar2.remove(para);
        if (paralar2.size() == 1) {
            Toast.makeText(getApplicationContext(), paralar2.get(0) + " TL Kazandınız!",
                    Toast.LENGTH_LONG).show();
            for (int i = 1; i < 17; i++) {
                Button button2 = (Button) findViewById(getResources().getIdentifier("button" + i, "id", this.getPackageName()));
                button2.setEnabled(false);
            }
        }
        adapter.notifyDataSetChanged();
    }
}
