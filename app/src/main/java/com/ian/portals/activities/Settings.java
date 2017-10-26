package com.ian.portals.activities;

import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.RadioButton;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.ToggleButton;

import com.ian.portals.R;
import com.ian.portals.data.Language;
import com.ian.portals.data.GlobalVariables;

import java.util.Locale;

public class Settings extends AppCompatActivity
{
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);

        updateOptions();
        musicVolumeOnSeekBarChangeEvent(findViewById(R.id.music_volume_tracker));
        soundsVolumeOnSeekBarChangeEvent(findViewById(R.id.sounds_volume_tracker));
    }

    /**
     * Update settings to user preferences
     */
    private void updateOptions()
    {
        ToggleButton music = (ToggleButton) findViewById(R.id.music);
        music.setChecked(GlobalVariables.isMusicActivated());

        SeekBar musicVolume = (SeekBar) findViewById(R.id.music_volume_tracker);
        TextView musicVolumeCurrent = (TextView) findViewById(R.id.music_volume_current);
        musicVolume.setProgress(GlobalVariables.getMusicVolume());
        musicVolumeCurrent.setText(String.valueOf(GlobalVariables.getMusicVolume()));

        ToggleButton sounds = (ToggleButton) findViewById(R.id.sounds);
        sounds.setChecked(GlobalVariables.isSoundsActivated());

        SeekBar soundsVolume = (SeekBar) findViewById(R.id.sounds_volume_tracker);
        TextView soundsVolumeCurrent = (TextView) findViewById(R.id.sounds_volume_current);
        soundsVolume.setProgress(GlobalVariables.getSoundsVolume());
        soundsVolumeCurrent.setText(String.valueOf(GlobalVariables.getSoundsVolume()));

        RadioButton language;
        switch(GlobalVariables.getLanguage())
        {
            case greek:
                language = (RadioButton) findViewById(R.id.language_greek);
                language.setChecked(true);
                break;
            case english:
                language = (RadioButton) findViewById(R.id.language_english);
                language.setChecked(true);
                break;
            default:
                language = (RadioButton) findViewById(R.id.language_english);
                language.setChecked(true);
                break;
        }
    }

    public void musicOnClickEvent(View view)
    {
        ToggleButton music = (ToggleButton) view;
        GlobalVariables.setMusicActivated(music.isChecked());
    }

    public void musicVolumeOnSeekBarChangeEvent(View view)
    {
        SeekBar musicVolume = (SeekBar) findViewById(R.id.music_volume_tracker);

        musicVolume.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener()
        {
            TextView musicVolumeCurrent = (TextView) findViewById(R.id.music_volume_current);

            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser)
            {
                GlobalVariables.setMusicVolume(progress);
                musicVolumeCurrent.setText(String.valueOf(GlobalVariables.getMusicVolume()));
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar)
            {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar)
            {

            }
        });
    }

    public void soundsOnClickEvent(View view)
    {
        ToggleButton sounds = (ToggleButton) view;
        GlobalVariables.setSoundsActivated(sounds.isChecked());
    }

    public void soundsVolumeOnSeekBarChangeEvent(View view)
    {
        SeekBar soundsVolume = (SeekBar) findViewById(R.id.sounds_volume_tracker);

        soundsVolume.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener()
        {
            TextView soundsVolumeCurrent = (TextView) findViewById(R.id.sounds_volume_current);

            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser)
            {
                GlobalVariables.setSoundsVolume(progress);
                soundsVolumeCurrent.setText(String.valueOf(GlobalVariables.getSoundsVolume()));
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar)
            {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar)
            {

            }
        });
    }

    public void languageEnglishOnClickEvent(View view)
    {
        GlobalVariables.setLanguage(Language.english);
        GlobalVariables.setLanguagePrefix("-en");
        updateLocale("en");
    }

    public void languageGreekOnClickEvent(View view)
    {
        GlobalVariables.setLanguage(Language.greek);
        GlobalVariables.setLanguagePrefix("-el");
        updateLocale("el");
    }

    @SuppressWarnings("deprecation")
    private void updateLocale(String language)
    {
        Configuration configuration = getResources().getConfiguration();
        Locale locale = new Locale(language);

        configuration.setLocale(locale);
        getResources().updateConfiguration(configuration, Resources.getSystem().getDisplayMetrics());
    }

    public void backOnClickEvent(View view)
    {
        finish();
    }
}
