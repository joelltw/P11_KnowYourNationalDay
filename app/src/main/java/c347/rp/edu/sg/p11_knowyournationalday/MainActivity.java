package c347.rp.edu.sg.p11_knowyournationalday;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ListView lv;
    ArrayList<String> al = new ArrayList<String>();
    ArrayAdapter aa;

    String code = "738964";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lv = (ListView) findViewById(R.id.lv);

        aa = new ArrayAdapter(this, android.R.layout.simple_list_item_1, al);
        lv.setAdapter(aa);

        al.add("Singapore National Day on the 9 Aug");
        al.add("Singapore is 52 years old");
        al.add("Theme is #OneNationTogether");


        SharedPreferences prefs = getPreferences(MODE_PRIVATE);
        String restoredText = prefs.getString("code", "false");

        if (restoredText.equals("738964")) {

        } else {
            LayoutInflater inflater = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            LinearLayout passPhrase =
                    (LinearLayout) inflater.inflate(R.layout.passphrase, null);
            final EditText etPassphrase = (EditText) passPhrase
                    .findViewById(R.id.editTextPassPhrase);

            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setTitle("Please Enter")
                    .setView(passPhrase)
                    .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int id) {
                            if (etPassphrase.getText().toString().equals(code)) {
                                SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(MainActivity.this);
                                SharedPreferences.Editor editor = prefs.edit();
                                editor.putString("code", "738964");
                                editor.commit();
                                Toast.makeText(MainActivity.this, "HAPPY NATIONAL DAY", Toast.LENGTH_LONG).show();
                            } else {
                                finish();
                                Toast.makeText(MainActivity.this, "Please Try Again!", Toast.LENGTH_LONG).show();
                            }
                        }
                    })

                    .setNegativeButton("NO ACCESS CODE", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int id) {
                            finish();
                        }
                    });

            AlertDialog alertDialog = builder.create();
            alertDialog.show();

            //Quiz
            LayoutInflater inflater1 = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            LinearLayout passPhrase1 =
                    (LinearLayout) inflater.inflate(R.layout.test, null);
            final EditText etPassphrase1 = (EditText) passPhrase
                    .findViewById(R.id.editTextPassPhrase);

            AlertDialog.Builder builder1 = new AlertDialog.Builder(this);
            builder.setTitle("Test yourself!")
                    .setView(passPhrase)
                    .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int id) {
                            int score = 0;
                            RadioGroup rg1 = (RadioGroup)findViewById(R.id.radio_group1);
                            RadioGroup rg2 = (RadioGroup)findViewById(R.id.radio_group2);
                            RadioGroup rg3 = (RadioGroup)findViewById(R.id.radio_group3);

                            // Get the Id of the selected radio button in the RadioGroup
                            int selectedButtonId = rg1.getCheckedRadioButtonId();
                            // Get the radio button object from the Id we had gotten above
                            RadioButton rb = (RadioButton)findViewById(selectedButtonId);

                            // Get the Id of the selected radio button in the RadioGroup
                            int selectedButtonId2 = rg2.getCheckedRadioButtonId();
                            // Get the radio button object from the Id we had gotten above
                            RadioButton rb2 = (RadioButton)findViewById(selectedButtonId);

                            // Get the Id of the selected radio button in the RadioGroup
                            int selectedButtonId3 = rg3.getCheckedRadioButtonId();
                            // Get the radio button object from the Id we had gotten above
                            RadioButton rb3 = (RadioButton)findViewById(selectedButtonId);

                            if (rb.isChecked() == true){
                                score ++;
                            }else if (rb2.isChecked()== true){
                                score++;
                            }else if (rb3.isChecked()== true) {
                                score++;
                            }
                            Toast.makeText(MainActivity.this, score, Toast.LENGTH_LONG).show();
                        }
                    })


                    .setNegativeButton("DON'T KNOW LAH", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int id) {

                        }
                    });

            AlertDialog alertDialog1 = builder.create();
            alertDialog.show();

        }
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.action_quiz) {
            //Implement simple confirmation dialog
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setTitle("Quiz?")
                    // Set text for the positive button and the corresponding
                    //  OnClickListener when it is clicked
                    .setPositiveButton("QUIZ", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int id) {
                            LayoutInflater inflater = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                            LinearLayout passPhrase =
                                    (LinearLayout) inflater.inflate(R.layout.test, null);
                            final EditText etPassphrase = (EditText) passPhrase
                                    .findViewById(R.id.editTextPassPhrase);

                            AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                            builder.setTitle("Please Enter")
                                    .setView(passPhrase)
                                    .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                                        @Override
                                        public void onClick(DialogInterface dialog, int id) {
                                            if (etPassphrase.getText().toString().equals(code)) {
                                                SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(MainActivity.this);
                                                SharedPreferences.Editor editor = prefs.edit();
                                                editor.putString("code", "738964");
                                                editor.commit();
                                                Toast.makeText(MainActivity.this, "HAPPY NATIONAL DAY", Toast.LENGTH_LONG).show();
                                            } else {
                                                finish();
                                                Toast.makeText(MainActivity.this, "Please Try Again!", Toast.LENGTH_LONG).show();
                                            }
                                        }
                                    })

                                    .setNegativeButton("NO ACCESS CODE", new DialogInterface.OnClickListener() {
                                        @Override
                                        public void onClick(DialogInterface dialog, int id) {
                                            Toast.makeText(MainActivity.this, "You had entered " +
                                                    etPassphrase.getText().toString(), Toast.LENGTH_LONG).show();
                                        }
                                    });

                            AlertDialog alertDialog = builder.create();
                            alertDialog.show();
                        }
                    })
                    // Set text for the positive button and the corresponding
                    //  OnClickListener when it is clicked
                    .setNegativeButton("NOT REALLY", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int id) {

                        }
                    });
            //Create AlertDialog object and return
            AlertDialog alertDialog = builder.create();
            alertDialog.show();

        } else if (item.getItemId() == R.id.action_send) {
            //Implement simple list
            String[] list = new String[]{"Email", "SMS"};

            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setTitle("Select the way to enrich your friend")
                    .setItems(list, new DialogInterface.OnClickListener() {
                        // The parameter "which" is the item index
                        // clicked, starting from 0
                        public void onClick(DialogInterface dialog, int which) {
                            if (which == 0) {
                                Intent email = new Intent(Intent.ACTION_SEND);
                                // Put essentials like email address, subject & body text
                                email.putExtra(Intent.EXTRA_EMAIL,
                                        new String[]{""});
                                email.putExtra(Intent.EXTRA_SUBJECT,
                                        "");
                                email.putExtra(Intent.EXTRA_TEXT,
                                        "");
                                // This MIME type indicates email
                                email.setType("message/rfc822");
                                // createChooser shows user a list of app that can handle
                                // this MIME type, which is, email
                                startActivity(Intent.createChooser(email,
                                        "Choose an Email client :"));

                            } else if (which == 1) {
                                Toast.makeText(MainActivity.this, "SMS",
                                        Toast.LENGTH_LONG).show();
                            }
                        }
                    });

            AlertDialog alertDialog = builder.create();
            alertDialog.show();
        } else if (item.getItemId() == R.id.action_quit) {
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setTitle("Quit?")
                    // Set text for the positive button and the corresponding
                    //  OnClickListener when it is clicked
                    .setPositiveButton("QUIT", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int id) {
                            LayoutInflater inflater = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                            LinearLayout passPhrase =
                                    (LinearLayout) inflater.inflate(R.menu.option, null);
                            final EditText etPassphrase = (EditText) passPhrase
                                    .findViewById(R.id.editTextPassPhrase);

                            AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                            builder.setTitle("Please Enter")
                                    .setView(passPhrase)
                                    .setPositiveButton("Quit", new DialogInterface.OnClickListener() {
                                        @Override
                                        public void onClick(DialogInterface dialog, int id) {
                                            if (etPassphrase.getText().toString().equals(code)) {
                                                SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(MainActivity.this);
                                                SharedPreferences.Editor editor = prefs.edit();
                                                editor.putString("code", "738964");
                                                editor.commit();
                                                Toast.makeText(MainActivity.this, "HAPPY NATIONAL DAY", Toast.LENGTH_LONG).show();
                                            } else {
                                                finish();
                                                Toast.makeText(MainActivity.this, "Please Try Again!", Toast.LENGTH_LONG).show();
                                            }
                                        }
                                    })

                                    .setNegativeButton("NOot really", new DialogInterface.OnClickListener() {
                                        @Override
                                        public void onClick(DialogInterface dialog, int id) {
                                            Toast.makeText(MainActivity.this, "You had entered " +
                                                    etPassphrase.getText().toString(), Toast.LENGTH_LONG).show();
                                        }
                                    });

                            AlertDialog alertDialog = builder.create();
                            alertDialog.show();
                        }
                    });
            //Create AlertDialog object and return
            AlertDialog alertDialog = builder.create();
            alertDialog.show();

        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.option, menu);
        return super.onCreateOptionsMenu(menu);
    }
}
