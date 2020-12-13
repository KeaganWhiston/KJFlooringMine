package com.example.kjflooring;
import android.content.SharedPreferences;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import android.preference.PreferenceManager;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import com.example.kjflooring.JavaBean.Products;
import java.text.NumberFormat;
import java.util.ArrayList;


/**
 * @author keaganwhiston
 * A simple {@link Fragment} subclass.
 */
public class nav_calculator extends Fragment {

    private EditText squareFootAmountEditText;
    private double squareFootAmount = 0.0;
    private TextView totalCostTextView;
    private double price;
    private SharedPreferences sharedPreferences;
    TextView nameTextView;

    public nav_calculator() {
        // Required empty public constructor
    }

    public static final NumberFormat currencyFormat = NumberFormat.getCurrencyInstance();

    /**
     *
     * @param inflater - instantiates fragment_nav_contact.xml into the view.
     * @param container - decides the organization, size, and position of the view.
     * @param savedInstanceState - references the Bundle object passed into the onCreate method.
     * @return
     */
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        final View view= inflater.inflate(R.layout.fragment_nav_calculator, container, false);
        final Spinner spinner = view.findViewById(R.id.floor_dropdown);

        // Adding all the products to an array list
        final ArrayList<Products> products = new ArrayList<>();
        products.add(new Products("Hardwood","Admiria Acacia",5.99));
        products.add(new Products("Hardwood","Dream Sun",4.33));
        products.add(new Products("Hardwood","Mine Craft",3.97));
        products.add(new Products("Laminate","Bilgewater",2.22));
        products.add(new Products("Laminate","Bright Wood",3.99));
        products.add(new Products("Laminate","Hoth",2.49));
        products.add(new Products("Vinyl","Xayah's Oak",4.15));
        products.add(new Products("Tile","Ivory Bathroom Tile",2.19));
        products.add(new Products("Tile","Checkered Tile",2.89));

        ArrayAdapter<Products> adapter = new ArrayAdapter<Products>(getContext(),android.R.layout.simple_dropdown_item_1line,products);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);

        sharedPreferences = PreferenceManager.getDefaultSharedPreferences(getContext());
        squareFootAmountEditText = view.findViewById(R.id.squareFootAmount);

        // Change the value depending on the conversion
        if(sharedPreferences.getBoolean("measurementSwitch", false)) {
            squareFootAmount = squareFootAmount * 30.48;
            squareFootAmountEditText.setHint("Please enter Metric Measurement (Metres)");
        }

        totalCostTextView = view.findViewById(R.id.totalCost);
        squareFootAmountEditText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                try{
                    squareFootAmount = Double.parseDouble(s.toString());
                }catch(NumberFormatException e){
                    squareFootAmount = 0.00;
                }
                calculateTotal();
            }
            @Override
            public void afterTextChanged(Editable s) {
            }
        });

        //Gather what the spinner is selected to based on its position
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String flooringCost = spinner.getSelectedItem().toString();
                price = products.get(position).getPrice();
                //floorCost = Double.valueOf(flooringCost);
                calculateTotal();
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });
        nameTextView = view.findViewById(R.id.nameTextView);
        sharedPreferences = PreferenceManager.getDefaultSharedPreferences(getContext());
        nameTextView.setText(sharedPreferences.getString("nameEditTextPreference", ""));
        return view;
    }

    /**
     * Changes the calculation to match the metric system.
     */
    // Calculates the total and returns a value
    private void calculateTotal(){
        double totalCost = squareFootAmount*price;
        if(sharedPreferences.getBoolean("measurementSwitch", false)) {
            totalCost = totalCost / 30.48;
        }
        totalCostTextView.setText(currencyFormat.format(totalCost));
    }

}
