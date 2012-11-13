package com.salamandroid.happylook;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;

import org.apache.http.util.ByteArrayBuffer;

import android.util.Log;

public class ImageDownloader
{

    private String DIRECTORY_NAME = "HappyLook";

    public void DownloadFromUrl(String DownloadUrlAddress, String fileName)
    {
	try {
	    long startTime = System.currentTimeMillis();
	    ByteArrayBuffer downloadedFileByteArray = download(getURL(DownloadUrlAddress));
	    FileOutputStream fos = new FileOutputStream(makeFile(
		    DIRECTORY_NAME, fileName));
	    fos.write(downloadedFileByteArray.toByteArray());
	    fos.flush();
	    fos.close();
	    Log.d("DownloadManager",
		    "download ready in"
			    + ((System.currentTimeMillis() - startTime) / 1000)
			    + " sec");
	} catch (IOException e) {
	    Log.d("DownloadManager", "Error: " + e);
	}
    }

    private URL getURL(String DownloadUrlAddress) throws IOException
    {
	return new URL(DownloadUrlAddress);
    }

    private ByteArrayBuffer download(URL url) throws IOException
    {
	URLConnection ucon = url.openConnection();
	InputStream is = ucon.getInputStream();
	BufferedInputStream bis = new BufferedInputStream(is);
	ByteArrayBuffer baf = new ByteArrayBuffer(5000);
	int currentBufferIndex = 0;
	while ((currentBufferIndex = bis.read()) != -1) {
	    baf.append((byte) currentBufferIndex);
	}
	return baf;
    }

    private File makeFile(String directoryName, String fileName)
    {
	File file = new File(getDirectory(directoryName), fileName);
	return file;
    }

    private File getDirectory(String directoryName)
    {
	File root = android.os.Environment.getExternalStorageDirectory();
	File dir = new File(root.getAbsolutePath() + "/" + directoryName);
	if (dir.exists() == false) {
	    dir.mkdirs();
	}
	return dir;
    }
}
