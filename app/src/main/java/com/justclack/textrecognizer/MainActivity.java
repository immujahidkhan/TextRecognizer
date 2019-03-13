package com.justclack.textrecognizer;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;

import com.google.android.gms.vision.text.TextBlock;
import com.skyhope.textrecognizerlibrary.TextScanner;
import com.skyhope.textrecognizerlibrary.callback.TextExtractCallback;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    ImageView download;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        download = findViewById(R.id.download);
        Bitmap bitmap = ((BitmapDrawable) download.getDrawable()).getBitmap();
        TextScanner.getInstance(this)
                .init()
                .load(bitmap) // uri or bitmap
                .getCallback(new TextExtractCallback() {
                    @Override
                    public void onGetExtractText(List<String> textList) {
                        // Here you will get list of text
                        for (int i = 0; i < textList.size(); i++) {
                            String item = textList.get(i);
                            Log.d("item", item);
                        }

                    }
                });
    }
}