package xyz.antifreezzz.anovote

import org.json.JSONObject

class JSONConverter{



    fun JSONIn(input: String) {
//        lateinit var input: String

        val reader = JSONObject(input)
        val data: JSONObject = reader.getJSONObject("Data")

        val voteList = data.getJSONArray("Voting")
        println(voteList)
    }



}