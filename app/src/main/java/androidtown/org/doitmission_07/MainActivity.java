package androidtown.org.doitmission_07;

import android.app.ActionBar;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    int numButton=0;
    CalendarView cal;
    EditText editContext;
    Button saveButton;
    TextView textView2;
    String date ;
    String result;
    LinearLayout dynamicArea;
    private final int DYNAMIC_VIEW_ID =0x8000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        cal =(CalendarView)findViewById(R.id.calendarView);
        editContext =(EditText)findViewById(R.id.editContext);
        saveButton =(Button)findViewById(R.id.saveButton);
        textView2 =(TextView)findViewById(R.id.textView2);
        dynamicArea =(LinearLayout)findViewById(R.id.dynamicArea);



        saveButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                String text =editContext.getText().toString();
                numButton++;
                TextView textview3= new TextView(getApplication());
                textview3.setId(DYNAMIC_VIEW_ID+numButton);
                textview3.setText(date+" "+text+"예약됨");
                dynamicArea.addView(textview3,new LinearLayout.LayoutParams(ActionBar.LayoutParams.FILL_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT));

               // textView2.setText(date+" "+text +"예약됨");
            }
        });
        cal.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(@NonNull CalendarView view, int year, int month, int dayOfMonth) {
                date =year+"년"+(month+1)+"월"+dayOfMonth+"일"; // date에 선택된 날짜가 저장됨
            }
        });






    }
}
