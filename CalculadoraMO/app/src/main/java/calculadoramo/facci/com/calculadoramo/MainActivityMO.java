package calculadoramo.facci.com.calculadoramo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivityMO extends AppCompatActivity implements View.OnClickListener {

    TextView res;

    boolean decimal = false;
    boolean suma = false;
    boolean resta = false;
    boolean multi = false;
    boolean div = false;
    Double[] numero = new Double[5];
    Double resultado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_activity_mo);

        Button btn0 = (Button) findViewById(R.id.btn0);
        btn0.setOnClickListener(this);
        Button btn1 = (Button) findViewById(R.id.btn1);
        btn1.setOnClickListener(this);
        Button btn2 = (Button) findViewById(R.id.btn2);
        btn2.setOnClickListener(this);
        Button btn3 = (Button) findViewById(R.id.btn3);
        btn3.setOnClickListener(this);
        Button btn4 = (Button) findViewById(R.id.btn4);
        btn4.setOnClickListener(this);
        Button btn5 = (Button) findViewById(R.id.btn5);
        btn5.setOnClickListener(this);
        Button btn6 = (Button) findViewById(R.id.btn6);
        btn6.setOnClickListener(this);
        Button btn7 = (Button) findViewById(R.id.btn7);
        btn7.setOnClickListener(this);
        Button btn8 = (Button) findViewById(R.id.btn8);
        btn8.setOnClickListener(this);
        Button btn9 = (Button) findViewById(R.id.btn9);
        btn9.setOnClickListener(this);

        Button coma = (Button) findViewById(R.id.btnpunto);
        coma.setOnClickListener(this);

        Button btnSu = (Button) findViewById(R.id.btnS);
        btnSu.setOnClickListener(this);
        Button btnRe = (Button) findViewById(R.id.btnR);
        btnRe.setOnClickListener(this);
        Button btnMu = (Button) findViewById(R.id.btnM);
        btnMu.setOnClickListener(this);
        Button btnDi = (Button) findViewById(R.id.btnD);
        btnDi.setOnClickListener(this);
        Button btnIg = (Button) findViewById(R.id.btnigual);
        btnIg.setOnClickListener(this);

        Button btnLim = (Button) findViewById(R.id.btnLimpiar);
        btnLim.setOnClickListener(this);

        Button btnacerca = (Button) findViewById(R.id.acerca);
        btnacerca.setOnClickListener(this);

        TextView res = (TextView) findViewById(R.id.resultado);
    }
    @Override
    public void onClick(View v) {
        EditText txtIngreso = (EditText) findViewById(R.id.txtIngreso);
        int op = v.getId();
        String a = txtIngreso.getText().toString();

        try {
            switch (op){
                case R.id.btn0:
                    txtIngreso.setText(a+"0");
                    break;
                case R.id.btn1:
                    txtIngreso.setText(a+"1");
                    break;
                case R.id.btn2:
                    txtIngreso.setText(a+"2");
                    break;
                case R.id.btn3:
                    txtIngreso.setText(a+"3");
                    break;
                case R.id.btn4:
                    txtIngreso.setText(a+"4");
                    break;
                case R.id.btn5:
                    txtIngreso.setText(a+"5");
                    break;
                case R.id.btn6:
                    txtIngreso.setText(a+"6");
                    break;
                case R.id.btn7:
                    txtIngreso.setText(a+"7");
                    break;
                case R.id.btn8:
                    txtIngreso.setText(a+"8");
                    break;
                case R.id.btn9:
                    txtIngreso.setText(a+"9");
                    break;
                case R.id.btnpunto:
                    if (decimal==false){
                        txtIngreso.setText(a+".");
                        decimal=true;
                    } else {
                        return;
                    }
                    break;
                case R.id.btnS:
                    suma=true;
                    numero[0] = Double.parseDouble(a);
                    txtIngreso.setText("");
                    decimal=false;
                    break;
                case R.id.btnR:
                    resta=true;
                    numero[0] = Double.parseDouble(a);
                    txtIngreso.setText("");
                    decimal=false;
                    break;
                case R.id.btnM:
                    multi=true;
                    numero[0] = Double.parseDouble(a);
                    txtIngreso.setText("");
                    decimal=false;
                    break;
                case R.id.btnD:
                    div=true;
                    numero[0] = Double.parseDouble(a);
                    txtIngreso.setText("");
                    decimal=false;
                    break;
                case R.id.btnLimpiar:
                    txtIngreso.setText("");
                    decimal=false;
                    break;
                case R.id.btnigual:
                    numero[1] = Double.parseDouble(a);
                    if (suma==true){
                        resultado = (numero[0]+numero[1]);
                    } else {
                        if (resta==true){
                            resultado = (numero[0]-numero[1]);
                        } else {
                            if (multi==true){
                                resultado = (numero[0]*numero[1]);
                            } else {
                                if (div==true){
                                    resultado = (numero[0]/numero[1]);
                                }
                            }
                        }
                    }

                    txtIngreso.setText(String.valueOf(resultado));
                    decimal = false;
                    suma = false;
                    resta = false;
                    multi = false;
                    div = false;
             //       res.setText(String.valueOf(resultado));

                    break;
                case R.id.acerca:
                    Intent i = new Intent(getBaseContext(),AcercaActivityMO.class);
                    startActivity(i);
                    break;
            }
        } catch (Exception e){
            txtIngreso.setText("");
            Toast.makeText(getApplicationContext(), "Error en la aplicacion", Toast.LENGTH_SHORT).show();
        }
    }
}
