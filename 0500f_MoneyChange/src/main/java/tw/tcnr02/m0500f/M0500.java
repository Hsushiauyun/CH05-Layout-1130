package tw.tcnr02.m0500f;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.text.DecimalFormat;


public class M0500 extends AppCompatActivity{

    private EditText e001;
    private Button b001;
    private TextView t003;
    private String ans;
    private DecimalFormat pondsFormat;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.m0500);
        setupViewcomponent();  //自定義方法
    }

    private void setupViewcomponent() {
        //定義配置碼
        e001 = (EditText)findViewById(R.id.m0500_e001);
        b001=(Button)findViewById(R.id.m0500_b001);
        t003=(TextView)findViewById(R.id.m0500_t003);
        b001.setOnClickListener(B001on);
    }



    private View.OnClickListener B001on=new View.OnClickListener() {
    @Override
    public void onClick(View v) {
//        DecimalFormat   pondsFormat = new DecimalFormat("0.00000");
        pondsFormat = new DecimalFormat( "0.00000"); //宣告 格式( 小數後5位，不足補0 )
        if(e001.getText().toString().length()>0){
            ans = pondsFormat.format(Float.parseFloat(e001.getText().toString())*29.9999);
            t003.setText(ans);
        }else{
            t003.setText(getString(R.string.m_ans));
        }


    }
};

}