package dam2.act2_di_jose_igualada_calero;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RatingBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ToggleButton;

        //Jose Igualada Calero

public class MainActivity extends Activity {

    //Declaramos todos los componentes de los view

    ToggleButton TbFondo, TbTexto;
    TextView TxtOculto, TxtEstrellas, Txtlargo;
    CheckBox CbMostrar;
    RatingBar RtEstrellas;
    RelativeLayout RelLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TbFondo = (ToggleButton) findViewById(R.id.tbFondo);
        TbTexto = (ToggleButton) findViewById(R.id.tbTexto);

        TxtOculto = (TextView) findViewById(R.id.txtOculto);
        TxtEstrellas = (TextView) findViewById(R.id.txtEstrellas);
        Txtlargo = (TextView) findViewById(R.id.txtLargo);

        CbMostrar = (CheckBox) findViewById(R.id.cbMostrar);

        RtEstrellas = (RatingBar) findViewById(R.id.rtEstrellas);

        RelLayout = (RelativeLayout) findViewById(R.id.relativeLayout);


        TbFondo.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                if(TbFondo.isChecked()){

                    RelLayout.setBackgroundColor(Color.WHITE);

                }else{

                    RelLayout.setBackgroundColor(Color.RED);
                }
            }
        });

        TbTexto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(TbTexto.isChecked()){

                    TxtEstrellas.setTextColor(Color.BLACK);

                }else{

                    TxtEstrellas.setTextColor(Color.GREEN);

                }
            }
        });

        CbMostrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (CbMostrar.isChecked()) {

                    TxtOculto.setVisibility(View.VISIBLE);

                } else {

                    TxtOculto.setVisibility(View.INVISIBLE);

                }
            }
        });

        Txtlargo.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                if (Txtlargo.isLongClickable()) {

                    Toast toast = Toast.makeText(getApplicationContext(), "Deja de pulsar!", Toast.LENGTH_LONG);
                    toast.show();
                    return true;

                } else {

                    return false;

                }
            }
        });

        TxtEstrellas.setText("[0/5]");

        RtEstrellas.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float rating, boolean fromUser) {
                int estrellas = (int) RtEstrellas.getRating();
                TxtEstrellas.setText("["+estrellas+"/5]");
            }
        });


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
