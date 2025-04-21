package com.badlogic.citadel.Methods;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Preferences;

public class AppPreferences{
    private static final String MUSIC_VOLUME = "volume";
    private static final String MUSIC_ENABLE = "music.enable";
    private static final String SOUND_ENABLE = "sound.enable";
    private static final String SOUND_VOLUME = "sound";
    private static final String PREFS_NAME = "citadel";

    protected Preferences getPreferences() {
        return Gdx.app.getPreferences(PREFS_NAME);
    }

    public float getMusicVolume() {
        return getPreferences().getFloat(MUSIC_VOLUME, 0.5f);
    }
    public void setMusicVolume(float musicVolume) {
        getPreferences().putFloat(MUSIC_VOLUME, musicVolume);
        getPreferences().flush();
    }

    public boolean getMusicEnable() {
        return getPreferences().getBoolean(MUSIC_ENABLE, false);
    }
    public void setMusicEnable(boolean musicEnable) {
        getPreferences().putBoolean(MUSIC_ENABLE, musicEnable);
        getPreferences().flush();
    }

    public boolean getSoundEnable() {
        return getPreferences().getBoolean(SOUND_ENABLE, false);
    }
    public void setSoundEnable(boolean soundEnable) {
        getPreferences().putBoolean(SOUND_ENABLE, soundEnable);
    }

    public float getSoundVolume() {
        return getPreferences().getFloat(SOUND_VOLUME, 0.5f);
    }
    public void setSoundVolume(float soundVolume) {
        getPreferences().putFloat(SOUND_VOLUME, soundVolume);
        getPreferences().flush();
    }
}
