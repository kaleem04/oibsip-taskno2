package com.example.calculator;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

public class MainActivity extends AppCompatActivity {


    TextView working;
    TextView resultTv;
    String workingValue = "";
    String formula = "";
    String tempFormula = "";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        initTextViews();
    }

    private void initTextViews() {
        working = findViewById(R.id.txtWorking);
        resultTv     = findViewById(R.id.txtResult);
    }

    private void setWorkings(String givenValue) {
        workingValue = workingValue + givenValue;
        working.setText(workingValue);
    }
    public void clearOnClick(View view) {
        workingValue = "";
        working.setText(workingValue);
        resultTv.setText(workingValue);
        leftBracket = true;
    }

    boolean leftBracket = true;
    public void bracketsOnClick(View view) {
        if(leftBracket){
            setWorkings("(");
            leftBracket = false;
        }else{
            setWorkings(")");
            leftBracket = true;
        }
    }

    public void powerOnClick(View view) {
        setWorkings("^");
    }

    public void divideOnClick(View view) {
        setWorkings("/");
    }

    public void sevenOnClick(View view) {
        setWorkings("7");
    }

    public void eightOnClick(View view) {
        setWorkings("8");
    }

    public void nineOnClick(View view) {
        setWorkings("9");
    }

    public void multiplyOnClick(View view) {
        setWorkings("*");
    }

    public void fourOnClick(View view) {
        setWorkings("4");
    }

    public void fiveOnClick(View view) {
        setWorkings("5");
    }

    public void sixOnClick(View view) {
        setWorkings("6");
    }

    public void minusOnClick(View view) {
        setWorkings("-");
    }

    public void oneOnClick(View view) {
        setWorkings("1");
    }

    public void twoOnClick(View view) {
        setWorkings("2");
    }

    public void threeOnClick(View view) {
        setWorkings("3");
    }

    public void addOnClick(View view) {
        setWorkings("+");
    }

    public void pointOnClick(View view) {
        setWorkings(".");
    }


    public void zeroOnClick(View view) {
        setWorkings("0");
    }

    public void equalOnClick(View view) {
        Double result = null;
        ScriptEngine engine = new ScriptEngineManager().getEngineByName("rhino");
        checkPowerOf();

        try {
            result = (double)engine.eval(formula);
        } catch (ScriptException e) {
            Toast.makeText(this, "Invalid Input", Toast.LENGTH_SHORT).show();

        }

        if(result != null){
            resultTv.setText(String.valueOf(result.doubleValue()));
        }
    }

    private void checkPowerOf() {

        ArrayList<Integer> indexOfPowers = new ArrayList<>();
        for(int i = 0 ; i < working.length();i++){
            if(workingValue.charAt(i) == '^'){
                indexOfPowers.add(i);
            }
        }

        formula = workingValue;
        tempFormula = workingValue;
        for (Integer index : indexOfPowers){
            changeFormula(index);
        }
        formula = tempFormula;
    }

    private void changeFormula(Integer index) {
    }

    private boolean isNumeric(char a) {

return true;
    }
}