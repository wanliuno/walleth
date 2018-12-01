package org.walleth.activities.nfc

import android.nfc.NfcAdapter.getDefaultAdapter
import android.os.Bundle
import org.walleth.R
import org.walleth.activities.BaseSubActivity
import org.walleth.khartwarewallet.KHardwareManager
import org.walleth.khartwarewallet.enableKhardwareReader

open class BaseNFCActivity : BaseSubActivity() {

    protected val nfcAdapter by lazy {
        getDefaultAdapter(this)
    }

    protected  val cardManager by lazy { KHardwareManager() }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_nfc)

    }

    public override fun onResume() {
        super.onResume()
        nfcAdapter?.enableKhardwareReader(this, cardManager)
    }

    public override fun onPause() {
        super.onPause()
        nfcAdapter?.disableReaderMode(this)
    }
}