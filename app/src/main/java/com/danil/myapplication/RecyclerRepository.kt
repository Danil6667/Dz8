package com.danil.myapplication
class RecyclerRepository {

    private val listOfCharacters: ArrayList<RecyclerModel> = ArrayList()

    fun getListOfCharacters(): ArrayList<RecyclerModel> {
        listOfCharacters.add(
            RecyclerModel(
                "https://i.pinimg.com/originals/ba/fa/f6/bafaf6c6d691233d5d07ca7dc92f8878.jpg",
                "Kocmoc",
                21,
                "Kane"
            )
        )
        listOfCharacters.add(
            RecyclerModel(
                "https://phonoteka.org/uploads/posts/2021-04/1618636516_39-phonoteka_org-p-kosmos-fon-vertikalnii-49.jpg",
                "Baby",
                7,
                "Yoda"
            )
        )
        listOfCharacters.add(
            RecyclerModel(
                "https://zastavok.net/uploads/228x400/cosmos/165273632066.jpg",
                "Tieger",
                51,
                "West"

            )
        )
        listOfCharacters.add(
            RecyclerModel(
                "https://avatanplus.com/files/resources/original/5a1d807a6c778160033dde4c.jpg",
                "Kung Phu",
                27,
                "Panda"
            )
        )
        listOfCharacters.add(
            RecyclerModel(
                "https://phonoteka.org/uploads/posts/2021-06/thumbs/1624622301_9-phonoteka_org-p-oboi-na-android-kosmos-krasivo-9.jpg",
                "Marshal",
                32,
                "Tinder"
            )
        )
        return listOfCharacters
    }
}
