package com.example.placement_predict;
import android.content.Context;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class HomeFragment extends Fragment implements View.OnClickListener {

    Context context;
    Placed placed;
    TextView textResult;
    EditText textAge,textGender,textStream,textInternships,textCGPA,textBacklogs,textCodingSkills,textAptitudeSkills,textTechnicalSkills,textCommunicationSkills;
    public HomeFragment() {
        // Required empty public constructor
    }

    public static HomeFragment newInstance(String param1, String param2) {
        HomeFragment fragment = new HomeFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        getActivity().setTitle("CHECK YOU ARE TO BE  PLACED OR NOT");

        placed = new Placed();

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_home, container, false);

        this.context = container.getContext();

        textAge = view.findViewById(R.id.textAge);
        textGender = view.findViewById(R.id.textGender);
        textStream = view.findViewById(R.id.textStream);
        textInternships = view.findViewById(R.id.textInternships);
        textCGPA = view.findViewById(R.id.textCGPA);
        textBacklogs= view.findViewById(R.id.textBacklogs);
        textCodingSkills = view.findViewById(R.id.textCodingSkills);
        textAptitudeSkills = view.findViewById(R.id.textAptitudeSkills);
        textTechnicalSkills = view.findViewById(R.id.textTechnicalSkills);
        textCommunicationSkills = view.findViewById(R.id.textCommunicationSkills);

        textResult = view.findViewById(R.id.textResult);

        Button btnResult = view.findViewById(R.id.btnResult);
        btnResult.setOnClickListener(this);

        return view;
    }

    private void GetResult() {

        String url = "http://44.216.252.151/predictresult?";
        url += "age=" + placed.Age + "&";
        url += "gender=" + placed.Gender + "&";
        url += "stream=" + placed.Stream + "&";
        url += "internships=" + placed.Internships + "&";
        url += "cgpa=" + placed.CGPA + "&";
        url += "backlogs=" + placed.Backlogs + "&";
        url += "codingskills=" + placed.CodingSkills+ "&";
        url += "aptitudeskills=" + placed.AptitudeSkills+ "&";
        url += "technicalskills=" + placed.TechnicalSkills + "&";
        url += "communicationskills=" + placed.CommunicationSkills;
        Log.d("url",url);

        // creating a new variable for our request queue
        RequestQueue queue = Volley.newRequestQueue(context);

        // make json array request and then extracting data from each json object.
        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(Request.Method.GET, url, null, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                try {
                    JSONObject responseObj = response.getJSONObject(0);

                    String returnValue = responseObj.getString("Result");
//                    textResult.setText("Result: " + returnValue);
                    if(returnValue.equals("1")){
                        textResult.setText("You are Placed");
                    }else{
                        textResult.setText("You are not to be placed. Improve your skills");
                    }

                    Toast.makeText(context, returnValue, Toast.LENGTH_SHORT).show();

                } catch (JSONException e) {
                    throw new RuntimeException(e);
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(context, error.toString(), Toast.LENGTH_SHORT).show();
                Log.d("Error", error.toString());

            }
        });
        queue.add(jsonArrayRequest);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btnResult:
                placed.Age =  textAge.getText().toString();
                placed.Gender =  textGender.getText().toString();
                placed.Stream =  textStream.getText().toString();
                placed.Internships =  textInternships.getText().toString();
                placed.Backlogs =  textBacklogs.getText().toString();
                placed.CGPA =  textCGPA.getText().toString();
                placed.CodingSkills =  textCodingSkills.getText().toString();
                placed.AptitudeSkills =  textAptitudeSkills.getText().toString();
                placed.TechnicalSkills =  textTechnicalSkills.getText().toString();
                placed.CommunicationSkills =  textCommunicationSkills.getText().toString();



                GetResult();
                textResult.setText("wait..");
                break;
        }
    }
}