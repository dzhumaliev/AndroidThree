package com.example.androidthree.ui;


import android.content.Context;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.androidthree.R;
import com.example.androidthree.data.entity.exchange.Exchange;
import com.example.androidthree.data.entity.exchange.MainExchange;
import com.example.androidthree.data.entity.weather.CurrentWeatherEntity;
import com.example.androidthree.data.network.RetrofitBuilder;

import java.util.Currency;
import java.util.List;

import butterknife.BindView;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import static com.example.androidthree.BuildConfig.EXCHANGE_KEY;
import static com.example.androidthree.BuildConfig.WEATHER_KEY;

/**
 * A simple {@link Fragment} subclass.
 */
public class SecondFragment extends Fragment {


    @BindView(R.id.testOne)
    TextView testOne;
    @BindView(R.id.testTwo)
    TextView testTwo;
    Spinner spinner;


    public SecondFragment() {
        // Required empty public constructor
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://api.exchangeratesapi.io/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();



//        MainExchange currencyInterface = retrofit.create(CurrencyExchangeService.class);
//        Call<List<Currency>> call = currencyInterface.getCurrency();
//        call.enqueue(new Callback<List<Currency>>() {
//            @Override
//            public void onResponse(Call<List<Currency>> call, Response<List<Currency>> response) {
//
//            }
//
//            @Override
//            public void onFailure(Call<List<Currency>> call, Throwable t) {
//
//            }
//        });

//        RetrofitBuilder.getInstance().getExchangeRate("USD", EXCHANGE_KEY)
//                .enqueue(new Callback<Exchange>() {
//                    @Override
//                    public void onResponse(Call<Exchange> call, Response<Exchange> response) {
//                        Exchange data1 = response.body();
//                        data1.getMainExchange();
//                        try {
//
//                            testOne.setText(String.valueOf(data1.rates));
//                            testTwo.setText(String.valueOf(data1.mainExchange.getBase()));
//
//                        } finally {
//                            return;
//
//                        }
//                    }
//
//                    @Override
//                    public void onFailure(Call<Exchange> call, Throwable t) {
//
//                    }
//
//                });




    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_second, container, false);





        Spinner spinner = (Spinner) v.findViewById(R.id.first_spinner);


        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(v.getContext(), R.array.currency_list  ,
                android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_item);
        spinner.setAdapter(adapter);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener()
        {
            @Override
            public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int position, long id)
            {
                String selected = parentView.getItemAtPosition(position).toString();
                Context context = parentView.getContext();
                CharSequence text = selected;
                int duration = Toast.LENGTH_SHORT;

                Toast toast = Toast.makeText(context, text, duration);
                toast.show();

                TextView bk = (TextView) v.findViewById(R.id.testTwo);

                switch (position){
                    case 0:
                        bk.setText(getResources().getString(R.string.label1));
                        break;
                    case 1:
                        bk.setText(getResources().getString(R.string.label2));
                        break;
                    case 2:
                        bk.setText(getResources().getString(R.string.label3));
                        break;
                    case 3:
                        bk.setText(getResources().getString(R.string.label4));
                        break;
                    case 4:
                        bk.setText(getResources().getString(R.string.label5));
                        break;
                    default:
                        break;
                }


            }



            @Override
            public void onNothingSelected(AdapterView<?> parentView) {
                // your code here
            }
        });

        Button resultBtn = v.findViewById(R.id.result);
        resultBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });





















//        String [] values =
//                {"KGS","USD","EUR","CNY","RUB","KZT"};
//        Spinner spinnerFirst = v.findViewById(R.id.first_spinner);
//        Spinner spinnerSecond = v.findViewById(R.id.second_spinner);
//        ArrayAdapter<String> adapter = new ArrayAdapter<>(this.getActivity(), android.R.layout.simple_spinner_item, values);
//        adapter.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);
//        spinnerFirst.setAdapter(adapter);
//        spinnerFirst.setSelection(1);
//        spinnerSecond.setAdapter(adapter);
//        spinnerSecond.setSelection(0);








        return v;


//        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
//            public void onItemSelected(AdapterView<?> parent,
//                                       View itemSelected, int selectedItemPosition, long selectedId) {
//
//                ArrayAdapter[] choose = getResources().getStringArray();
//                Toast toast = Toast.makeText(getApplicationContext(),
//                        "Ваш выбор: " + choose[selectedItemPosition], Toast.LENGTH_SHORT);
//                toast.show();
//            }
//            public void onNothingSelected(AdapterView<?> parent) {
//            }
//        });
    }


}
