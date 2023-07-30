package com.example.placement_predict;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.webkit.WebViewClient;


public class TestsFragment extends Fragment {

    public TestsFragment() {
        // Required empty public constructor
    }

    public static TestsFragment newInstance(String param1, String param2) {
        TestsFragment fragment = new TestsFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        getActivity().setTitle("Take Tests");
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_details, container, false);

        // Find the WebView by its unique ID
        WebView webView = view.findViewById(R.id.webView);

        webView.loadUrl("https://www.indiabix.com/online-test/categories/");
        webView.getSettings().setJavaScriptEnabled(true);
        webView.setWebViewClient(new WebViewClient());

        return view;
    }
}