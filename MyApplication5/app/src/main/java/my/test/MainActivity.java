package my.test;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnMultiChoiceClickListener;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.Toast;

import java.util.ArrayList;


public class MainActivity extends Activity {





        final CharSequence myList[] = { "Tea", "Coffee", "Milk" };

        ArrayList<Integer> selList=new ArrayList();
        boolean bl[] = new boolean[myList.length];
        RelativeLayout rl;
        String msg ="";
        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);

            rl = (RelativeLayout) findViewById(R.id.myRL);
            final Button btn = (Button) findViewById(R.id.btnDialog);

            final AlertDialog.Builder ad = new AlertDialog.Builder(this);
            ad.setTitle("What do you Like ?");
            ad.setMultiChoiceItems(myList,bl, new OnMultiChoiceClickListener() {

                @Override
                public void onClick(DialogInterface arg0, int arg1, boolean arg2) {
                    // TODO Auto-generated method stub

                    if(arg2)
                    {
                        // If user select a item then add it in selected items
                        selList.add(arg1);
                    }
                    else if (selList.contains(arg1))
                    {
                        // if the item is already selected then remove it
                        selList.remove(Integer.valueOf(arg1));
                    }
                }
            });
            ad.setPositiveButton("OK", new DialogInterface.OnClickListener() {

                @Override
                public void onClick(DialogInterface dialog, int which) {
                    // TODO Auto-generated method stub
                    msg="";
                    for (int i = 0; i < selList.size(); i++) {

                        msg=msg+"\n"+(i+1)+" : "+myList[selList.get(i)];
                    }
                    Toast.makeText(getApplicationContext(),
                            "Total "+ selList.size() +" Items Selected.\n"+ msg , Toast.LENGTH_LONG)
                            .show();


                }
            });
            ad.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {

                @Override
                public void onClick(DialogInterface dialog, int which) {
                    // TODO Auto-generated method stub
                    Toast.makeText(getApplicationContext(),
                            "You Have Cancel the Dialog box", Toast.LENGTH_LONG)
                            .show();
                }
            });

            btn.setOnClickListener(new OnClickListener() {

                @Override
                public void onClick(View arg0) {
                    // TODO Auto-generated method stub
                    msg="";
                    ad.show();
                }
            });

        }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.main, menu);
        return true;
    }
    }


