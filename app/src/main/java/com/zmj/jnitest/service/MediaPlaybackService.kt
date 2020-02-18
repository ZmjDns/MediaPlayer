package com.zmj.jnitest.service

import android.os.Bundle
import android.support.v4.media.MediaBrowserCompat
import android.support.v4.media.session.MediaSessionCompat
import android.support.v4.media.session.PlaybackStateCompat
import androidx.media.MediaBrowserServiceCompat


/**
 * Author : Zmj
 * Blog : https://blog.csdn.net/Zmj_Dns
 * DitHub : https://github.com/ZmjDns
 * Time : 2020/2/18
 * Description :
 */

private const val MY_MEDIA_ROOT_ID = "media_root_id"
private const val MY_EMPTY_MEDIA_ROOT_ID = "empty_root_id"

class MediaPlaybackService: MediaBrowserServiceCompat() {

    private val LOG_TAG = "MediaPlaybackService";

    private var mediaSession: MediaSessionCompat? = null
    private lateinit var stateBuilder: PlaybackStateCompat.Builder

    override fun onCreate() {
        super.onCreate()
        //
        mediaSession = MediaSessionCompat(baseContext,LOG_TAG).apply {

            setFlags(MediaSessionCompat.FLAG_HANDLES_MEDIA_BUTTONS or MediaSessionCompat.FLAG_HANDLES_TRANSPORT_CONTROLS)

            stateBuilder = PlaybackStateCompat.Builder().setActions(PlaybackStateCompat.ACTION_PLAY or PlaybackStateCompat.ACTION_PLAY_PAUSE)

            setPlaybackState(stateBuilder.build())

            //设置回调
            setCallback(/*MySessionCallBack()*/ null)

            setSessionToken(sessionToken)
        }
    }

    override fun onGetRoot(clientPackageName: String,clientUid: Int, rootHints: Bundle?): BrowserRoot? {
        return if (allowBrowsing(clientPackageName,clientUid)){
            MediaBrowserServiceCompat.BrowserRoot(MY_MEDIA_ROOT_ID,null)
        }else{
            MediaBrowserServiceCompat.BrowserRoot(MY_EMPTY_MEDIA_ROOT_ID,null)
        }
    }

    //判断是否允许接入
    private fun allowBrowsing(clientPackageName: String, clientUid: Int): Boolean {

        return false
    }

    override fun onLoadChildren(parentId: String, result: Result<MutableList<MediaBrowserCompat.MediaItem>>) {
        if (MY_EMPTY_MEDIA_ROOT_ID == parentId){
            result.sendResult(null)
            return
        }

        val mediaItems = emptyList<MediaBrowserCompat.MediaItem>()

        if (MY_MEDIA_ROOT_ID == parentId){
            // Build the MediaItem objects for the top level,
            // and put them in the mediaItems list...
        }else{
            // Examine the passed parentMediaId to see which submenu we're at,
            // and put the children of that menu in the mediaItems list...
        }

        result.sendResult(mediaItems as MutableList<MediaBrowserCompat.MediaItem>?)

    }

}