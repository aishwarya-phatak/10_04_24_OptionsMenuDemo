package in.bitcode.a10_04_24_optionsmenudemo;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.SubMenu;
import android.widget.CheckBox;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    private final int MENU_PHONE_SETTINGS = 1, MENU_DISPLAY_SETTINGS = 2,
            MENU_BLUETOOTH_SETTINGS = 3, MENU_HELP = 4,
            MENU_HISTORY = 5, MENU_PHONE_SETTINGS_A = 6, MENU_PHONE_SETTINGS_B = 7;
    int itemId;
    CheckBox enableSettings;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();
    }

    private void initViews() {
        enableSettings = findViewById(R.id.enableSettings);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        Toast.makeText(this, "onCreateOptionsMenu", Toast.LENGTH_SHORT).show();
    SubMenu menu1 = menu.addSubMenu(1,MENU_PHONE_SETTINGS,1,"Phone Settings");
                    menu.addSubMenu(2,MENU_BLUETOOTH_SETTINGS,2,"Bluetooth Settings");
                    menu.addSubMenu(3,3,MENU_DISPLAY_SETTINGS,"Display Settings");

                    //adding items to sub menu --> menu1
                    menu1.add(1,2,MENU_PHONE_SETTINGS_A,"A");
                    menu1.add(1,3,MENU_PHONE_SETTINGS_B,"B");

                    MenuItem helpMenuItem = menu.add(4,4,MENU_HELP,"Help");
    MenuItem historyMenuItem = menu.add(5,5,MENU_HISTORY,"History");
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        Toast.makeText(this, "opOptionsItemSelected Called", Toast.LENGTH_SHORT).show();
        itemId = item.getItemId();
        switch (itemId) {
            case 1:
                Log.e("tag", "Phone Settings Selected");
                break;
            case 2:
                Toast.makeText(this,"Disaplay Settings",Toast.LENGTH_LONG).show();
                break;
            case 3:
                //Intent intent = new Intent(this, SecondActivity.class);
                //startActivity(intent);
                break;
            case 4:
                Toast.makeText(this,"Help Settings",Toast.LENGTH_LONG).show();
                break;
            case 5:
                Toast.makeText(this,"History Settings",Toast.LENGTH_LONG).show();
                break;
        }
        return true;
    }

    @Override
    public boolean onPrepareOptionsMenu(Menu menu) {
        Toast.makeText(this, "onPrepareOptionsMenu Called", Toast.LENGTH_SHORT).show();
        menu.findItem(4);
        menu.setGroupEnabled(1,(enableSettings.isChecked()));
        menu.setGroupVisible(1,true);

        return true;
    }
}