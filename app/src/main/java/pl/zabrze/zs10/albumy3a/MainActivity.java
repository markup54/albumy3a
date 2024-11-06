package pl.zabrze.zs10.albumy3a;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayList<Album> albumy = new ArrayList<>();
    ImageButton buttonDalej;
    ImageButton buttonWstecz;
    Button buttonPobierz;
    TextView textViewAlbum;
    TextView textViewWykonawca;
    TextView textViewRok;
    TextView textViewPobrania;
    int aktualny = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        albumy.add(new Album("My Chemical Romance","The Black Parade",2006,14,12131313));
        albumy.add(new Album("30 Seconds To Mars","A Beautiful Lie",2006,13,1213));
        albumy.add(new Album("Wilki","wilki",1992,16,121));

        buttonDalej = findViewById(R.id.imageButton2);
        buttonWstecz = findViewById(R.id.imageButton);
        buttonPobierz = findViewById(R.id.button3);
        textViewAlbum = findViewById(R.id.textViewAlbum);
        textViewPobrania = findViewById(R.id.textViewPobrania);
        textViewRok = findViewById(R.id.textView4);
        textViewWykonawca = findViewById(R.id.textViewWykonawca);

        wyswietlPiesn(0);

        buttonDalej.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        aktualny++;
                        if(aktualny == albumy.size())
                        {
                            aktualny = 0;
                        }
                        wyswietlPiesn(aktualny);
                    }
                }
        );
        buttonWstecz.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        aktualny--;
                        if(aktualny<0){
                            aktualny = albumy.size()-1;
                        }
                        wyswietlPiesn(aktualny);
                    }
                }
        );

        buttonPobierz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                albumy.get(aktualny).zwiekszPobrania();
                wyswietlPiesn(aktualny);
            }
        });
    }

    private void wyswietlPiesn(int i){
        Album album = albumy.get(i);
        textViewWykonawca.setText(album.getWykonawca());
        textViewRok.setText(String.valueOf(album.getRok())+" "+String.valueOf(album.getLiczbaUtworow()));
        textViewPobrania.setText(String.valueOf(album.getPobrania()));
        textViewAlbum.setText(album.getNazwa());
    }

}