package xyz.antifreezzz.anovote

import org.json.JSONObject
import org.junit.Test

class JSONTests {
    var  jsonDoc:String = JSONObject("\\home\\antifreezzz\\StudioProjects\\AnoVote\\app\\src\\main\\test.json").getString("Data")

    @Test
    fun jSONParseTest() {
        JSONConverter().JSONIn(jsonDoc)

    }


}