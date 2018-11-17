package com.example.osvaldoairon.servicesandroid;

import android.app.IntentService;
import android.content.Intent;
import android.content.Context;
import android.media.MediaPlayer;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.util.Log;
import android.widget.Toast;

import com.example.osvaldoairon.servicesandroid.Mp4Service.Mp4Binder;
import com.example.osvaldoairon.servicesandroid.Mp4Service.mp4Service;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * An {@link IntentService} subclass for handling asynchronous task requests in
 * a service on a separate handler thread.
 * <p>
 * TODO: Customize class - update intent actions, extra parameters and static
 * helper methods.
 */
public class MeuService extends IntentService implements mp4Service{
    public static final String SINCRONIZAR = "sincronizar";
    public static final String SUCESSO  = "sucesso";

    public static final String ARQUIVO = "arquivo";
    public static final String PLAY = "play";
    public static final String ACAO = "acao";
    public static final String PAUSE = "pause";
    public static final String STOP = "stop";


    /**
     * Construtor padrão
     */
    public MeuService(){
        super("MeuService");

    }

    /**
     * Metodo principal do IntentService, em resumo. ele cria uma fila de execução de processos via intents;
     * é utilizado quando se quer realizar alguma operação em background, mas que demore um certo periodo de tempo;
     * diferentemente dos broadcasts;
     * ele so executa o proximo "item da fila" quando o que esta sendo executado termina sua tarefa.
     * dessa forma nao é preciso se preocupar com encadeamentos;
     * Portanto, se esse código levar muito tempo,
     * ele reterá outras solicitações para o mesmo IntentService,
     * mas não irá sustentar mais nada.
     * Quando todas as solicitações foram tratadas,
     * o IntentService para em si, portanto,
     * você não deve chamar Service.stopSelf ().
     Esse método pode levar vários segundos para concluir,
     por isso só deve ser chamado de um segmento de trabalho.
     * @param intent
     */
    @Override
    protected void onHandleIntent(@Nullable Intent intent) {
        if(intent!=null){
            if(PLAY.equals(intent.getStringExtra(ACAO))){
                play();
            }else if(PAUSE.equals(intent.getStringExtra(ACAO))){
                pause();
            }else if(STOP.equals(intent.getStringExtra(ACAO))){
                stop();
            }
        }
    }

    /**
     * é chamado sempre que o serviço é invocado por meio do método startService(intent);
     * @param intent
     * @param flags
     * @param startId
     * @return
     */
    @Override
    public int onStartCommand(@Nullable Intent intent, int flags, int startId) {
        Log.d("startService?" , "StartService - ok");
        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public void onCreate() {
        super.onCreate();
    }
    /**
     * retorna um objeto IBinder que estabele o canal de comunicação com uma activity.
     * obrigatoriamente deve ser implementado mesmo que retorne null.
     * @param intent
     * @return
     */
    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return new Mp4Binder(this);
    }

    /**
     * é invocado quando o serviço é destruído e nele devemos liberar os recursos alocados
     */
    @Override
    public void onDestroy() {
        super.onDestroy();
    }


    /**
     * metodos da interface mp4Service;
     *
     */

    @Override
    public void play() {
        Log.d("play", "Executando musica");
    }

    @Override
    public void pause() {
        Log.d("pause", "Musica pausada!");
    }

    @Override
    public void stop() {
        Log.d("stop", "Musica finalizada!");
    }


}
