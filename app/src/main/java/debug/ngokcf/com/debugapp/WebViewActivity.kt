package debug.ngokcf.com.debugapp

import android.annotation.SuppressLint
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.webkit.WebChromeClient
import android.webkit.WebView
import android.webkit.WebViewClient
import kotlinx.android.synthetic.main.activity_webview.*

class WebViewActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_webview)

        webView.settings.apply {
            @SuppressLint("SetJavaScriptEnabled")
            javaScriptEnabled = true
            useWideViewPort = true
            loadWithOverviewMode = true
            setAppCacheEnabled(true)
        }
        webView.apply {
            isVerticalScrollBarEnabled = false
            isHorizontalScrollBarEnabled = false
            webChromeClient = CustomWebChromeClient()
            webViewClient = CustomWebViewClient(this@WebViewActivity)
        }

        webView.loadUrl("http://st.cp.wowma.jp/santaro/")
    }

    class CustomWebChromeClient : WebChromeClient() {

        override fun onProgressChanged(view: WebView?, newProgress: Int) {
        }

    }

    class CustomWebViewClient(activity: WebViewActivity) : WebViewClient() {

    }

}
