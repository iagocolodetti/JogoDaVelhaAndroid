package iagocolodetti.jogodavelha;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.*;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    boolean iniciado = false;

    int[][] possibilidades = {
            new int[] {0, 1, 2},
            new int[] {3, 4, 5},
            new int[] {6, 7, 8},
            new int[] {0, 3, 6},
            new int[] {1, 4, 7},
            new int[] {2, 5, 8},
            new int[] {0, 4, 8},
            new int[] {2, 4, 6}
    };

    int vitoriasX, vitoriasO, empates, jogadas;
    String jogadorDaVez = "";
    int cPadrao = Color.BLACK, cX = Color.GREEN, cO = Color.RED;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        vitoriasX = vitoriasO = empates = 0;

        final TextView[] tvs = {
                findViewById(R.id.tvX),             // [0]
                findViewById(R.id.tvV),             // [1]
                findViewById(R.id.tvO),             // [2]
                findViewById(R.id.tvVez),           // [3]
                findViewById(R.id.tvResultado)      // [4]
        };

        tvs[0].setTextColor(cX);
        tvs[1].setTextColor(cPadrao);
        tvs[2].setTextColor(cO);

        final Button[] bts = {
                findViewById(R.id.bt0),
                findViewById(R.id.bt1),
                findViewById(R.id.bt2),
                findViewById(R.id.bt3),
                findViewById(R.id.bt4),
                findViewById(R.id.bt5),
                findViewById(R.id.bt6),
                findViewById(R.id.bt7),
                findViewById(R.id.bt8)
        };

        final Button btIniciar = findViewById(R.id.btIniciar);

        tvs[4].setVisibility(View.INVISIBLE);

        bts[0].setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if (iniciado) checarResultado(bts[0], bts, btIniciar, tvs);
            }
        });

        bts[1].setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if (iniciado) checarResultado(bts[1], bts, btIniciar, tvs);
            }
        });

        bts[2].setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if (iniciado) checarResultado(bts[2], bts, btIniciar, tvs);
            }
        });

        bts[3].setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if (iniciado) checarResultado(bts[3], bts, btIniciar, tvs);
            }
        });

        bts[4].setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if (iniciado) checarResultado(bts[4], bts, btIniciar, tvs);
            }
        });

        bts[5].setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if (iniciado) checarResultado(bts[5], bts, btIniciar, tvs);
            }
        });

        bts[6].setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if (iniciado) checarResultado(bts[6], bts, btIniciar, tvs);
            }
        });

        bts[7].setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if (iniciado) checarResultado(bts[7], bts, btIniciar, tvs);
            }
        });

        bts[8].setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if (iniciado) checarResultado(bts[8], bts, btIniciar, tvs);
            }
        });

        btIniciar.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if (!iniciado)
                {
                    iniciado = true;
                    jogadas = 0;
                    tvs[4].setVisibility(View.INVISIBLE);
                    btIniciar.setEnabled(false);
                    for (int i = 0; i < bts.length; i++)
                    {
                        bts[i].setText("-");
                        bts[i].setTextColor(cPadrao);
                    }
                    Random r = new Random();
                    int random = r.nextInt(100) + 1;
                    if (random == 1)
                    {
                        jogadorDaVez = "X";
                        tvs[3].setText("Jogador da Vez: " + jogadorDaVez);
                        tvs[3].setTextColor(cX);
                    }
                    else if (random % 2 == 0)
                    {
                        jogadorDaVez = "O";
                        tvs[3].setText("Jogador da Vez: " + jogadorDaVez);
                        tvs[3].setTextColor(cO);
                    }
                    else
                    {
                        jogadorDaVez = "X";
                        tvs[3].setText("Jogador da Vez: " + jogadorDaVez);
                        tvs[3].setTextColor(cX);
                    }
                }
            }
        });
    }

    private void checarResultado(Button btClicado, Button[] bts, Button btIniciar, TextView[] tvs)
    {
        if (btClicado.getText() == "-")
        {
            btClicado.setText(jogadorDaVez);
            jogadas++;
            for (int i = 0; i < possibilidades.length; i++)
            {
                if (bts[possibilidades[i][0]].getText() == "X" && bts[possibilidades[i][1]].getText() == "X" && bts[possibilidades[i][2]].getText() == "X")
                {
                    tvs[3].setText("Jogador da Vez: --");
                    tvs[3].setTextColor(cPadrao);
                    bts[possibilidades[i][0]].setTextColor(cX);
                    bts[possibilidades[i][1]].setTextColor(cX);
                    bts[possibilidades[i][2]].setTextColor(cX);
                    vitoriasX++;
                    tvs[4].setText("Resultado: Jogador \"X\" venceu!");
                    tvs[4].setTextColor(cX);
                    tvs[4].setVisibility(View.VISIBLE);
                    fimDeJogo(btIniciar, tvs);
                    return;
                }
                else if (bts[possibilidades[i][0]].getText() == "O" && bts[possibilidades[i][1]].getText() == "O" && bts[possibilidades[i][2]].getText() == "O")
                {
                    tvs[3].setText("Jogador da Vez: --");
                    tvs[3].setTextColor(cPadrao);
                    bts[possibilidades[i][0]].setTextColor(cO);
                    bts[possibilidades[i][1]].setTextColor(cO);
                    bts[possibilidades[i][2]].setTextColor(cO);
                    vitoriasO++;
                    tvs[4].setText("Resultado: Jogador \"O\" venceu!");
                    tvs[4].setTextColor(cO);
                    tvs[4].setVisibility(View.VISIBLE);
                    fimDeJogo(btIniciar, tvs);
                    return;
                }
            }
            if (jogadas < 9)
            {
                if (jogadorDaVez == "X")
                {
                    jogadorDaVez = "O";
                    tvs[3].setText("Jogador da Vez: " + jogadorDaVez);
                    tvs[3].setTextColor(cO);
                }
                else
                {
                    jogadorDaVez = "X";
                    tvs[3].setText("Jogador da Vez: " + jogadorDaVez);
                    tvs[3].setTextColor(cX);
                }
                return;
            }
            tvs[3].setText("Jogador da Vez: --");
            tvs[3].setTextColor(cPadrao);
            empates++;
            tvs[4].setText("Resultado: VELHA!");
            tvs[4].setTextColor(cPadrao);
            tvs[4].setVisibility(View.VISIBLE);
            fimDeJogo(btIniciar, tvs);
        }
    }

    private void fimDeJogo(Button btIniciar, TextView[] tvs)
    {
        iniciado = false;
        tvs[0].setText("X: " + vitoriasX);
        tvs[1].setText("V: " + empates);
        tvs[2].setText("O: " + vitoriasO);
        btIniciar.setEnabled(true);
    }
}
