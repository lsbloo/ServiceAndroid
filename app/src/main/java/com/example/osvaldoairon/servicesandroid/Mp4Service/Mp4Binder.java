package com.example.osvaldoairon.servicesandroid.Mp4Service;

import android.os.Binder;

/**
 * Created by osvaldoairon on 17/11/2018.
 */

/**
 * estabele o canal de comunicação entre o metodo onBind que retorna
 * um objeto do tipo Binder;
 *
 */
public class Mp4Binder extends Binder {

    private mp4Service mp4Service;

    public Mp4Binder(mp4Service s){
        this.mp4Service=s;
    }

    public mp4Service getService(){
        return this.mp4Service;
    }
}
