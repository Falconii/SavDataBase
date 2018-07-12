package br.com.brotolegal.savdatabaseexemplo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import br.com.brotolegal.savdatabase.entities.Acordo;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        
        setContentView(R.layout.activity_main);

        TextView label = (TextView) findViewById(R.id.label01);

        Acordo  acordo = new Acordo();

    }
}
