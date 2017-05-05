package it.dstech.codicefiscale;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.params.HttpConnectionParams;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.InputStream;
import java.net.HttpURLConnection;

public class MainActivity extends AppCompatActivity {

    private EditText editNome;
    private EditText editCognome;
    private EditText editGiorno;
    private EditText editMese;
    private EditText editAnno;
    private EditText editComune;

    private Button button;

    private TextView textCod;

    private Persona persona;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final EditText editNome= (EditText) findViewById(R.id.editNome);
        final EditText editCognome = (EditText) findViewById(R.id.editCognome);
        final EditText editGiorno = (EditText) findViewById(R.id.editGiorno);
        final EditText editMese = (EditText) findViewById(R.id.editMese);
        final EditText editAnno = (EditText) findViewById(R.id.editAnno);
        final EditText editComune = (EditText) findViewById(R.id.editComune);

        button = (Button) findViewById(R.id.button);

        textCod = (TextView) findViewById(R.id.textCodice);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                persona.setNome(editNome.getText().toString());
                persona.setCognome(editCognome.getText().toString());
                persona.setGiorno(Integer.parseInt(editGiorno.getText().toString()));
                persona.setMese(Integer.parseInt(editMese.getText().toString()));
                persona.setAnno(Integer.parseInt(editAnno.getText().toString()));
                persona.setComune(editComune.getText().toString());
                jsonConnect();

                textCod.setText("CODICE_FISCALE");
            }
        });

    }

    public void jsonConnect(){

        InputStream inputStream = null;
        String result = "";
        try {
            // 1. create HttpClient
            HttpClient httpclient = new DefaultHttpClient();

            // 2. make POST request to the given URL
            HttpPost httpPost = new HttpPost(getResources().getString(R.string.URL));
            String json = "";

            //3. build jsonObject
            JSONObject jsonObject = new JSONObject();
            jsonObject.accumulate("nome", persona.getNome());
            jsonObject.accumulate("cognome", persona.getCognome());
        }catch (Exception e){
            Log.e("InputStream", e.getLocalizedMessage());
        }
    }

//        try {
//            HttpClient client = new DefaultHttpClient();
//            HttpConnectionParams.setConnectionTimeout(client.getParams(),10000);
//            HttpResponse response;
//
//            JSONObject jsonObject = new JSONObject();
//            jsonObject.put("nome", editNome.getText().toString());
//            jsonObject.put("cognome", editCognome.getText().toString());
//            jsonObject.put("giorno", editGiorno.getText().toString());
//            jsonObject.put("mese", editMese.getText().toString());
//            jsonObject.put("anno", editAnno.getText().toString());
//            jsonObject.put("comune", editComune.getText().toString());
//            HttpPost poost = new HttpPost("http://192.168.7.122:8080/codicefiscale/persona"); //metodo post per mandare il json al server
//
//            Log.d("Ok", "json inviato!");
//
//
//
//        }catch (JSONException e){
//            Log.e("ERROR", "Errore connessione json " + e.getMessage());
//        }
//    }
}
