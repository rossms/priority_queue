package com.cs576.ross.priority_queue;

import android.content.Context;
import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.Map;
import java.util.PriorityQueue;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    pqueueSorter pqs = new pqueueSorter();
    PriorityQueue<Integer> initPQ = new PriorityQueue<Integer>();
    PriorityQueue<Entry> sortPQ = new PriorityQueue<Entry>(10, new OrderedComparator());
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initializeQueue();

        implementOnClickActions();
    }

    public void implementOnClickActions(){
        final Button maxButton = (Button) findViewById(R.id.max);
        final Button showQueueButton = (Button) findViewById(R.id.showQueue);
        final Button addButton = (Button) findViewById(R.id.add);
        final Button extractMaxButton = (Button) findViewById(R.id.extractMax);
        final Button addToQueue = (Button) findViewById(R.id.insert);
        addToQueue.setVisibility(View.GONE);
        final EditText input = (EditText) findViewById(R.id.editText);
        input.setVisibility(View.GONE);
        final Button doneButton = (Button) findViewById(R.id.done);
        doneButton.setVisibility(View.GONE);

        assert maxButton != null;
        maxButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                String max = max();
                showAlertDialog("Alert", "Max: " + max, MainActivity.this);
            }
        });
        assert showQueueButton != null;
        showQueueButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                showAlertDialog("Alert", "Priority Queue: " + sortPQ, MainActivity.this);
            }
        });
        assert addButton !=null;
        addButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                addToQueue.setVisibility(View.VISIBLE);
                input.setVisibility(View.VISIBLE);
                doneButton.setVisibility(View.VISIBLE);
            }
        });
        assert addToQueue !=null;
        addToQueue.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Random rand = new Random();
                String new_str = input.getText().toString();
                Integer len = sortPQ.size();
                sortPQ.add(new Entry(len+1, new_str));
            }
        });
        assert doneButton !=null;
        doneButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                addToQueue.setVisibility(View.GONE);
                input.setVisibility(View.GONE);
                doneButton.setVisibility(View.GONE);
            }
        });
        assert extractMaxButton !=null;
        extractMaxButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                String exMax = sortPQ.poll().getValue();
                showAlertDialog("Alert", "Extract max: " + exMax, MainActivity.this);
            }
        });

    }
    private void initializeQueue() {
        //int[] in = {4, 5, 3, 10, 9, 6, 7, 1};
        int[] in = {};
       /* for(int x:in){
            initPQ.offer(x);
        }


        for(int x:in){
            sortPQ.offer(x);
        }
        System.out.println("initPQ " + initPQ);
        System.out.println("sortPQ " + sortPQ);*/
    }
    private String max(){
        System.out.println("max " + sortPQ.peek());
        return sortPQ.peek().getValue();
    }

    public void showAlertDialog(String title, String message, Context context)
    {
        AlertDialog alertDialog = new AlertDialog.Builder(context).create();
        alertDialog.setTitle(title);
        alertDialog.setMessage(message);
        alertDialog.setButton(AlertDialog.BUTTON_NEUTRAL, "OK",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                });
        alertDialog.show();
    }
}
