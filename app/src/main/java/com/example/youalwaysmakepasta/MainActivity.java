package com.example.youalwaysmakepasta;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.media.SoundPool;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.widget.Button;
import android.widget.SeekBar;

public class MainActivity extends AppCompatActivity {

    private Button btn;
    private MediaPlayer mpMusic;
    private MediaPlayer mpKaraoke;
    private MediaPlayer mpPasta;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //音楽プレイヤーの準備
        mpMusic = MediaPlayer.create(this, R.raw.junrenka_kashi);
        mpPasta = MediaPlayer.create(this, R.raw.pasta);
        mpKaraoke = MediaPlayer.create(this, R.raw.junrenka_karaoke);


        //アプリ起動後純恋歌（歌詞付き）＆カラオケを音量０で再生開始
        mpMusic.setVolume(0.25F,0.25F);
        mpKaraoke.setVolume(0,0);
        mpMusic.start();
        mpKaraoke.start();


        //パスタボタンを押したときの処理
        btn = findViewById(R.id.btnPasta);
        btn.setOnClickListener(v -> {
            //純恋歌（歌詞付き）の音量を0に設定
            mpMusic.setVolume(0, 0);
            //パスタを再生
            mpPasta.start();
            mpPasta.setVolume(1,1);
            mpPasta.setOnCompletionListener(mp -> {
                mpMusic.setVolume(0.25F,0.25F);
                mpKaraoke.setVolume(0,0);
            });
            //純恋歌（カラオケ）を音量1にする
            mpKaraoke.setVolume(0.25F,0.25F);
        });



    }
}