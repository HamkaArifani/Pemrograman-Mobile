package com.example.lib

class CowManager(){
    val cowList=arrayListOf<Cow>()

    fun addCow(cow: Cow){
        cowList.add(cow)
    }
    fun listCow(): ArrayList<Cow>{
        return cowList
    }
    fun deleteCow(id :String): Boolean{
        return cowList.removeIf {it.identity.id==id }
    }
    fun updateCowName(
        id: String,
        newName: String
    ):Boolean{
        val cow = showCow(id)
        if (cow !=null){
            cow.identity.name = newName
            return true
        }
        return false
    }
    fun updateCowAge(
        id: String,
        newAge: Int
    ):Boolean{
        val cow = showCow(id)
        if (cow !=null){
            cow.age = newAge
            return true
        }
        return false
    }
    fun updateCowWeight(
        id: String,
        newWeight: Double
    ):Boolean{
        val cow = showCow(id)
        if (cow !=null){
            cow.weight = newWeight
            return true
        }
        return false
    }
    fun updateCowHealthStat(
        id: String,
        newHealthstatus: String
    ):Boolean{
        val cow = showCow(id)
        if (cow !=null){
            cow.healthStatus= newHealthstatus
            return true
        }
        return false
    }
    fun updateCowAddDesc(
        id: String,
        newAddDesc: String
    ):Boolean{
        val cow = showCow(id)
        if (cow !=null){
            cow.additionalDesc = newAddDesc
            return true
        }
        return false
    }
    fun showCow(id: String): Cow?{
        return cowList.find{it.identity.id==id}
    }

}