package co.com.k4soft.listviewsencillo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private String[] ciudades ={"Bogotá","Medellín","Rionegro","Barranquilla","Bucaramanga","Cali","Cartagena"};
    private ListView listViewCiudades;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initComponents();
        loadInfo();
        onSelectedItemListener();
    }

    private void onSelectedItemListener() {
        listViewCiudades.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(getApplicationContext(),getCiudad(i),Toast.LENGTH_LONG).show();
            }
        });
    }

    private String getCiudad(int i) {
        return ciudades[i];
    }

    private void loadInfo() {
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(this,R.layout.support_simple_spinner_dropdown_item,ciudades);
        listViewCiudades.setAdapter(arrayAdapter);
    }

    private void initComponents() {
        listViewCiudades = findViewById(R.id.listViewCiudades);
    }
}
