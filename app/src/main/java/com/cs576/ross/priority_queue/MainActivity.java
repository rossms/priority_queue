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

import java.util.PriorityQueue;

public class MainActivity extends AppCompatActivity {
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
        assert addToQueue != null;
        addToQueue.setVisibility(View.GONE);
        final EditText input = (EditText) findViewById(R.id.editText);
        assert input != null;
        input.setVisibility(View.GONE);
        final EditText priorityInput = (EditText) findViewById(R.id.priorityInput);
        assert priorityInput != null;
        priorityInput.setVisibility(View.GONE);
        final Button doneButton = (Button) findViewById(R.id.done);
        assert doneButton != null;
        doneButton.setVisibility(View.GONE);
        final TextView valueText = (TextView) findViewById(R.id.valueText);
        assert valueText !=null;
        valueText.setVisibility(View.GONE);
        final TextView priorityText = (TextView) findViewById(R.id.priorityText);
        assert priorityText !=null;
        priorityText.setVisibility(View.GONE);


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
                priorityInput.setVisibility(View.VISIBLE);
                doneButton.setVisibility(View.VISIBLE);
                valueText.setVisibility(View.VISIBLE);
                priorityText.setVisibility(View.VISIBLE);
            }
        });
        assert addToQueue !=null;
        addToQueue.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                String new_str = input.getText().toString();
                Integer priority = Integer.parseInt(priorityInput.getText().toString());
                sortPQ.add(new Entry(priority, new_str));
                input.setText("");
                priorityInput.setText("");
            }
        });
        assert doneButton !=null;
        doneButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                addToQueue.setVisibility(View.GONE);
                input.setVisibility(View.GONE);
                priorityInput.setVisibility(View.GONE);
                doneButton.setVisibility(View.GONE);
                valueText.setVisibility(View.GONE);
                priorityText.setVisibility(View.GONE);
            }
        });
        assert extractMaxButton !=null;
        extractMaxButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                String exMax = (String)sortPQ.poll().getValue();
                showAlertDialog("Alert", "Extract max: " + exMax, MainActivity.this);
            }
        });

    }
    private void initializeQueue() {
        //int[] in = {4, 5, 3, 10, 9, 6, 7, 1};
        int[] in;
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
        return (String)sortPQ.peek().getValue();
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
