package com.example.harshit.a13_tictactoe;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity
{
    View v;
    int count =0;
    int player= 0;
    int matrix[][] =new int[3][3];

    public void playagain(View v)
    {
        Toast.makeText(MainActivity.this,"Playing again",Toast.LENGTH_SHORT).show();
        MainActivity.this.recreate();
    }

    public void clicked(View v)
    {
        this.v =v;
        ImageView img = (ImageView) v;
        String tag = img.getTag().toString();
        int x = Integer.parseInt(String.valueOf(tag.charAt(0)))-1;
        int y = Integer.parseInt(String.valueOf(tag.charAt(1)))-1;
        if(player == 0 && matrix[x][y]==9)
        {
            matrix[x][y] = 0;
            img.setImageResource(R.drawable.circle);
            check(0);
            player=1;
            count++;
        }
        else if(player == 1 && matrix[x][y]==9)
        {
            matrix[x][y] = 1;
            img.setImageResource(R.drawable.cross);
            check(1);
            player=0;
            count++;
        }
        if(count == 9)
        {
            View layout = findViewById(R.id.dialog);
            TextView txtbox = (TextView) findViewById(R.id.textWon);
            txtbox.setText("Draw!!");

            findViewById(R.id.img21).setVisibility(View.INVISIBLE);
            findViewById(R.id.img22).setVisibility(View.INVISIBLE);
            findViewById(R.id.img23).setVisibility(View.INVISIBLE);

            layout.setVisibility(View.VISIBLE);
        }
    }

    void check(int value)
    {
        if(matrix[0][0]==value && matrix[1][1]==value && matrix[2][2]==value)
        {
            won(value);
        }
        else if(matrix[0][2]==value && matrix[1][1]==value && matrix[2][0]==value)
        {
            won(value);
        }
        else if(matrix[0][0]==value && matrix[1][0]==value && matrix[2][0]==value)
        {
            won(value);
        }
        else if(matrix[0][1]==value && matrix[1][1]==value && matrix[2][1]==value)
        {
            won(value);
        }
        else if(matrix[0][2]==value && matrix[1][2]==value && matrix[2][2]==value)
        {
            won(value);
        }
        else if(matrix[0][0]==value && matrix[0][1]==value && matrix[0][2]==value)
        {
            won(value);
        }
        else if(matrix[1][0]==value && matrix[1][1]==value && matrix[1][2]==value)
        {
            won(value);
        }
        else if(matrix[2][0]==value && matrix[2][1]==value && matrix[2][2]==value)
        {
            won(value);
        }

    }
    void won(int value)
    {
        View layout = findViewById(R.id.dialog);
        TextView txtbox = (TextView) findViewById(R.id.textWon);
        txtbox.setText("Player with " + value+" has won");

        findViewById(R.id.img21).setVisibility(View.INVISIBLE);
        findViewById(R.id.img22).setVisibility(View.INVISIBLE);
        findViewById(R.id.img23).setVisibility(View.INVISIBLE);

        layout.setVisibility(View.VISIBLE);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        for (int i = 0; i < 3; i++)
        {
            for (int j = 0; j < 3; j++)
            {
                matrix[i][j]=9;
            }
        }
    }
}
