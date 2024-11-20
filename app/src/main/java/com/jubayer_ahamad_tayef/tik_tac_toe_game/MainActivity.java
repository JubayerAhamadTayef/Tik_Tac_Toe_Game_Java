package com.jubayer_ahamad_tayef.tik_tac_toe_game;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    Button btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8, btn9, restartBtn, currentTurn;
    String btn1txt, btn2txt, btn3txt, btn4txt, btn5txt, btn6txt, btn7txt, btn8txt, btn9txt;
    TextView result;
    byte count = 0;
    byte state = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();

        currentTurn();

        restartBtn.setOnClickListener(view -> {
            restartGame();
        });

    }

    private void init() {

        btn1 = findViewById(R.id.btn1);
        btn2 = findViewById(R.id.btn2);
        btn3 = findViewById(R.id.btn3);
        btn4 = findViewById(R.id.btn4);
        btn5 = findViewById(R.id.btn5);
        btn6 = findViewById(R.id.btn6);
        btn7 = findViewById(R.id.btn7);
        btn8 = findViewById(R.id.btn8);
        btn9 = findViewById(R.id.btn9);

        restartBtn = findViewById(R.id.restartBtn);

        result = findViewById(R.id.result);

        currentTurn = findViewById(R.id.currentTurn);

    }

    @SuppressLint("SetTextI18n")
    public void compareResult(View view) {

        Button currentBtn = (Button) view;

        count++;

        if (currentBtn.getText().toString().isEmpty()) {

            if (state == 0) {
                currentBtn.setText(R.string.x);
                currentBtn.setTextColor(getResources().getColor(R.color.yellow));
                state = 1;
                currentTurn();
            } else {
                currentBtn.setText(R.string.o);
                currentBtn.setTextColor(getResources().getColor(R.color.blue));
                state = 0;
                currentTurn();
            }

            if (count > 4) {

                btn1txt = btn1.getText().toString();
                btn2txt = btn2.getText().toString();
                btn3txt = btn3.getText().toString();
                btn4txt = btn4.getText().toString();
                btn5txt = btn5.getText().toString();
                btn6txt = btn6.getText().toString();
                btn7txt = btn7.getText().toString();
                btn8txt = btn8.getText().toString();
                btn9txt = btn9.getText().toString();

                if (btn1txt.equals(btn2txt) && btn2txt.equals(btn3txt) && !btn1txt.isEmpty()) {

                    result.setText(getString(R.string.winner_is) + btn1txt);

                    winningColor(btn1);
                    winningColor(btn2);
                    winningColor(btn3);

                    currentTurnColor(R.string.game_over, R.color.red);

                    btnClickable(false);

                } else if (btn4txt.equals(btn5txt) && btn5txt.equals(btn6txt) && !btn4txt.isEmpty()) {

                    result.setText(getString(R.string.winner_is) + btn4txt);

                    winningColor(btn4);
                    winningColor(btn5);
                    winningColor(btn6);

                    currentTurnColor(R.string.game_over, R.color.red);

                    btnClickable(false);

                } else if (btn7txt.equals(btn8txt) && btn8txt.equals(btn9txt) && !btn7txt.isEmpty()) {

                    result.setText(getString(R.string.winner_is) + btn7txt);

                    winningColor(btn7);
                    winningColor(btn8);
                    winningColor(btn9);

                    currentTurnColor(R.string.game_over, R.color.red);

                    btnClickable(false);

                } else if (btn1txt.equals(btn4txt) && btn4txt.equals(btn7txt) && !btn1txt.isEmpty()) {

                    result.setText(getString(R.string.winner_is) + btn1txt);

                    winningColor(btn1);
                    winningColor(btn4);
                    winningColor(btn7);

                    currentTurnColor(R.string.game_over, R.color.red);

                    btnClickable(false);

                } else if (btn2txt.equals(btn5txt) && btn5txt.equals(btn8txt) && !btn2txt.isEmpty()) {

                    result.setText(getString(R.string.winner_is) + btn2txt);

                    winningColor(btn2);
                    winningColor(btn5);
                    winningColor(btn8);

                    currentTurnColor(R.string.game_over, R.color.red);

                    btnClickable(false);

                } else if (btn3txt.equals(btn6txt) && btn6txt.equals(btn9txt) && !btn3txt.isEmpty()) {

                    result.setText(getString(R.string.winner_is) + btn3txt);

                    winningColor(btn3);
                    winningColor(btn6);
                    winningColor(btn9);

                    currentTurnColor(R.string.game_over, R.color.red);

                    btnClickable(false);

                } else if (btn1txt.equals(btn5txt) && btn5txt.equals(btn9txt) && !btn1txt.isEmpty()) {

                    result.setText(getString(R.string.winner_is) + btn1txt);

                    winningColor(btn1);
                    winningColor(btn5);
                    winningColor(btn9);

                    currentTurnColor(R.string.game_over, R.color.red);

                    btnClickable(false);

                } else if (btn3txt.equals(btn5txt) && btn5txt.equals(btn7txt) && !btn3txt.isEmpty()) {

                    result.setText(getString(R.string.winner_is) + btn3txt);

                    winningColor(btn3);
                    winningColor(btn5);
                    winningColor(btn7);

                    currentTurnColor(R.string.game_over, R.color.red);

                    btnClickable(false);

                } else if (!btn1txt.isEmpty() && !btn2txt.isEmpty() && !btn3txt.isEmpty() && !btn4txt.isEmpty() && !btn5txt.isEmpty() && !btn6txt.isEmpty() && !btn7txt.isEmpty() && !btn8txt.isEmpty() && !btn9txt.isEmpty()) {

                    result.setText(R.string.match_is_drawn);

                    currentTurnColor(R.string.game_over, R.color.red);

                }

            }

        }

    }

    private void restartGame() {
        btn1.setText("");
        btn2.setText("");
        btn3.setText("");
        btn4.setText("");
        btn5.setText("");
        btn6.setText("");
        btn7.setText("");
        btn8.setText("");
        btn9.setText("");

        result.setText("");

        normalColor(btn1);
        normalColor(btn2);
        normalColor(btn3);
        normalColor(btn4);
        normalColor(btn5);
        normalColor(btn6);
        normalColor(btn7);
        normalColor(btn8);
        normalColor(btn9);

        state = 0;

        count = 0;

        btnClickable(true);

        currentTurn();
    }

    private void currentTurn() {
        if (state == 0) {
            currentTurn.setText(getString(R.string.current_turn_is_x));
            currentTurn.setTextColor(getResources().getColor(R.color.yellow));
        } else if (state == 1) {
            currentTurn.setText(getString(R.string.current_turn_is_o));
            currentTurn.setTextColor(getResources().getColor(R.color.blue));
        }
    }

    private void btnClickable(boolean bool) {
        btn1.setClickable(bool);
        btn2.setClickable(bool);
        btn3.setClickable(bool);
        btn4.setClickable(bool);
        btn5.setClickable(bool);
        btn6.setClickable(bool);
        btn7.setClickable(bool);
        btn8.setClickable(bool);
        btn9.setClickable(bool);
    }

    private void currentTurnColor(int string, int color) {
        currentTurn.setText(getString(string));
        currentTurn.setTextColor(getResources().getColor(color));
    }

    private void normalColor(Button btn) {
        btn.setBackgroundColor(getResources().getColor(R.color.black));
        btn.setTextColor(getResources().getColor(R.color.white));
    }

    private void winningColor(Button btn) {
        btn.setBackgroundColor(getResources().getColor(R.color.green));
        btn.setTextColor(getResources().getColor(R.color.black));
    }

}