package com.example.lib

data class CowIdentity(
    val id : String,
    var name: String,
    val gender : String
)
class Cow(val identity: CowIdentity){
    var age : Int = 0
        set(value) {
            if (value<0){
                field = 0
            }
            else field=value
        }
    var weight : Double = 0.0
        set(value){
            if (value<=0.0){
                field = 0.0
            }
            else field=value
        }
    var healthStatus: String = "healthy"
        set(value) {
            val inputLower= value.lowercase()
            if (inputLower=="healthy"||inputLower=="sick"){
                field=inputLower
            }
            else field= "?? check if there is misstype on the input"
        }
    var additionalDesc : String?= null
    val category : String
        get() {
            if (age>=24){
                return "Adult"
            }
            else return "Baby"
        }
}
