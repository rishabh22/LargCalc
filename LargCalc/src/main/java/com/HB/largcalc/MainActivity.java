package com.HB.largcalc;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.view.View;


public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    /*@Override
    public boolean onCreateOptionsMenu(Menu menu) {
        
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }*/

    /*@Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }*/

    public void clear(View view)
    {
        EditText var1=(EditText)(findViewById(R.id.input1));
        EditText var2=(EditText)(findViewById(R.id.input2));
        EditText res=(EditText)(findViewById(R.id.result));
        var1.setText("");
        var2.setText("");
        res.setText("");
        var1.requestFocus();
    }
    public void mult(View view)
    {
        EditText var1=(EditText)(findViewById(R.id.input1));
        EditText var2=(EditText)(findViewById(R.id.input2));
        EditText res=(EditText)(findViewById(R.id.result));
        res.setText(multi(var1.getText().toString(),var2.getText().toString()));
    }
    public static String multi(String s1,String s2)
    {
        char cs[]=new char[s1.length()+s2.length()];
        for(int i=0;i<cs.length;i++)
            cs[i]='0';
        int temp1=0,temp2=0,tempt=0,temptf=0,temptfinal;
        int k=cs.length-1,carry=0;
        int count;
        for(int i=s1.length()-1;i>=0;i--)
        {
            count=k;
            carry=0;
            temp1=Character.getNumericValue(s1.charAt(i));
            for(int j=s2.length()-1;j>=0;j--,count--)
            {
                temp2=Character.getNumericValue(s2.charAt(j));
                tempt=temp2*temp1+carry;
                temptf=tempt+Character.getNumericValue(cs[count]);
                temptfinal=temptf%10;
                carry=temptf/10;
                cs[count]=(Integer.toString(temptfinal)).charAt(0);
            }
            tempt=carry;
            temptf=tempt+Character.getNumericValue(cs[count]);
            temptfinal=temptf%10;
            carry=temptf/10;
            cs[count]=Integer.toString(temptfinal).charAt(0);
            k--;
        }
        return new String(cs);
    }
}
