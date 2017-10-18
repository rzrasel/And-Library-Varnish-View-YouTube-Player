package com.rz.usagesexample;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.rz.varnishviewyoutubeplayer.MetaData;
import com.rz.varnishviewyoutubeplayer.VarnishYouTubePlayerFragment;

public class ActSplash extends AppCompatActivity {
    private Activity activity;
    private Context context;

    private static final String PLAYER_FRAG_TAG = "player_fragment";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.act_splash);

        activity = this;
        context = this;

        String metaValue = "";
        String metaKeyName = "com.google.android.gms.version";
        metaKeyName = context.getResources().getString(R.string.google_and_youtube_api_key);
        metaValue = MetaData.getMetaData(context, metaKeyName);
        System.out.println("META_VALUE: " + metaValue);

        FragmentManager mgr = getFragmentManager();
        Fragment playerFrag = mgr.findFragmentByTag(PLAYER_FRAG_TAG);

        if(playerFrag == null) {
            final Integer styleResId = getIntent().getBooleanExtra(Constants.EXTRA_USE_CUSTOM_THEME, false) ? R.style.AppTheme_YouTubePlayer : null;
            playerFrag = VarnishYouTubePlayerFragment.newInstance(context, "66f4-NKEYz4", R.style.AppTheme_YouTubePlayer, true);
            mgr.beginTransaction()
                    .add(R.id.fragment_container, playerFrag, PLAYER_FRAG_TAG)
                    .commit();
        }
    }
}