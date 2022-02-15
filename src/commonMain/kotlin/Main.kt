import com.myunidays.segmenkt.WriteKey

val segmentConfig = com.myunidays.segmenkt.Configuration(
    writeKey = WriteKey(
        android = "123",
        ios = "222"
    ),
    context = null
)
val segment = com.myunidays.segmenkt.setupWithConfiguration(segmentConfig)