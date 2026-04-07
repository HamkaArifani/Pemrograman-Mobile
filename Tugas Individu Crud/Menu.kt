package com.example.lib

class CowMenu (val manager: CowManager){
    fun menu(){
        var running= true

        while (running){
            println("===========================================================================================")
            println("                                        COW CRUD    ")
            println("===========================================================================================")
            previewMenu()
            println("===========================================================================================")
            println("Welcome to COW CRUD! please choose over option below and start your own terminal cow farm :)")
            println("1. Add Cow (Add a new cow to the farm!)")
            println("2. List Cow (See farm population!)")
            println("3. Update Cow (Edit your cow identity except the gender and id)")
            println("4. Delete Cow (Delete one of your cow using it own id)")
            println("5. Show Cow (Showing details about the cow that you choose)")
            println("Or insert 0 to exit COW CRUD)")
            println("Inser your choose: ")
            val answer = readlnOrNull()?.toIntOrNull() ?: -1
            when (answer){
                1 -> addMenu()
                2 -> listMenu()
                3 -> updateMenu()
                4 -> deleteMenu()
                5 -> showMenu()
                0 -> running=false
                else -> print("Input invalid! Please only choose between 1-5 :)")
            }
        }

    }
    fun previewMenu(){
        val cowPreview = manager.listCow()
        if (cowPreview.isEmpty()){
            println("Waiting for a cow to be added :)")
        }
        else for(cow in cowPreview){
            println("ID: ${cow.identity.id} |" +
                    "Name: ${cow.identity.name} |" +
                    "Age: ${cow.age} Month |" +
                    "Gender: ${cow.identity.gender}"
            )
        }

    }

    fun addMenu(){
        println("--- Add New Cow ---")
        println("Cow ID: ")
        val inputId = readln()
        println("Cow name: ")
        val inputName = readln()
        println("Cow gender: ")
        val inputGender = readln()
        val identity= CowIdentity(inputId, inputName, inputGender)
        val newCow = Cow(identity)

        println("Cow age(in month): ")
        newCow.age=readln().toIntOrNull() ?: 0
        println("Cow weight: ")
        newCow.weight=readln().toDoubleOrNull() ?: 0.0
        println("Health status(sick/healthy): ")
        newCow.healthStatus=readln()
        println("Additional Description (Maybe you wanna add family corelation between your cows or any description for your cow :))")
        val inputDesc = readln()
        if (inputDesc.isNotBlank()){
            newCow.additionalDesc=inputDesc
        }
        else newCow.additionalDesc=null

        manager.addCow(newCow)
        println("Cow has added to your farm")
        println("Press enter to go back at the main menu :)")
        readln()
    }
    fun listMenu(){
        println("--- Current Farm Population ---")
        previewMenu()
        println("Press enter to go back at the main menu :)")
        readln()
    }
    fun updateMenu(){
        println("--- Update Your Cow Identity---")
        println("Insert the id of the cow you want to update: ")
        val inputId= readln()
        val selectedCow=manager.showCow(inputId)
        if (selectedCow == null){
            println("Sorry we can't find the cow that U are looking for :(\n" +
                    "Please check if maybe there is misstyped on the id!")
            return
        }
        var updateRunning = true
        while(updateRunning){
            println("What do u want to update from ${selectedCow.identity.name}? ")
            println("1. Cow Name (Current:${selectedCow.identity.name})")
            println("2. Cow Age (Current:${selectedCow.age} Month)")
            println("3. Cow Weight (Current:${selectedCow.weight})")
            println("4. Cow Health Status (Current:${selectedCow.healthStatus})")
            println("5. Cow Additional Description (Current:${selectedCow.additionalDesc})")
            println("Choose between option 1 to 5 or 0 to go back at main menu: ")
            val userInput= readln().toIntOrNull()
            when(userInput){
                1-> {println("Insert the new name: ")
                    val inputName = readln()
                    manager.updateCowName(inputId, inputName)
                    println("Name has been updated")
                }
                2-> {println("Insert the new age: ")
                    val inputAge = readln().toIntOrNull() ?: selectedCow.age
                    manager.updateCowAge(inputId, inputAge)
                    println("Age has been updated")
                }
                3-> {println("Insert the new weight: ")
                    val inputWeight = readln().toDoubleOrNull() ?: selectedCow.weight
                    manager.updateCowWeight(inputId, inputWeight)
                    println("Weight has been updated")
                }
                4-> {println("Update health status: ")
                    val inputHealthStatus = readln()
                    manager.updateCowHealthStat(inputId, inputHealthStatus)
                    println("Health status has been updated")
                }
                5-> {println("Insert new descriptiom: ")
                    val inputAdditionalDesc = readln()
                    manager.updateCowAddDesc(inputId, inputAdditionalDesc)
                    println("Description has been updated")
                }
                0-> updateRunning = false
                else ->println("pilihan tidak valid")
            }
        }
    }
    fun deleteMenu(){
        println("--- Delete one of your cow ---")
        println("Insert the id of the cow you want to delete: ")
        val removedCowId = readln()
        val deletedCow = manager.showCow(removedCowId)
        if (deletedCow != null){
            println("Are u sure you want to delete ${deletedCow.identity.name} from the farm ? (y/n)")
            if(readln().lowercase()== "y"){
                manager.deleteCow(removedCowId)
                println("Cow has been deleted!")
            } else println("Cancel the delete procces!")
        } else println("Sorry we can't find the cow that U are looking for :(\n" +
                "Please check if maybe there is misstyped on the id!")
        println("Press enter to go back at the main menu :)")
        readln()
    }
    fun showMenu(){
        println("Enter the cow ID you want to view details for: ")
        val inputid= readln()
        val showCow = manager.showCow(inputid)

        if (showCow != null){
            println("Here are the detail of the cow u selected : ")
            println("ID: ${showCow.identity.id} |" +
                    "Name: ${showCow.identity.name} |" +
                    "Age: ${showCow.age} |" +
                    "Gender: ${showCow.identity.gender} |"+
                    "Category: ${showCow.category} |"+
                    "Weight: ${showCow.weight} |"+
                    "Health Status: ${showCow.healthStatus} |"+
                    "Additional Description: ${showCow.additionalDesc ?: "-"}"
            )
        }
        else println("Sorry we can't find the cow that U are looking for :(\n" +
                     "Please check if maybe there is misstyped on the id!")
        println("Press enter to go back at the main menu :)")
        readln()
    }
}